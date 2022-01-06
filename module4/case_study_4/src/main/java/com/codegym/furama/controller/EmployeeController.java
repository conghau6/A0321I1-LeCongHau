package com.codegym.furama.controller;

import com.codegym.furama.entity.*;
import com.codegym.furama.repositories.employee.IUserRepositories;
import com.codegym.furama.service.IEmployeeService;
import com.codegym.furama.ultil.EmployeeCreate;
import com.codegym.furama.ultil.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    IEmployeeService employeeService;

    @Autowired
    IUserRepositories userRepositories;

    @ModelAttribute("url")
    public String url(){
        return "/employees";
    }

    @ModelAttribute("nameUser")
    public String nameUser(Principal principal){
        if(principal == null) return null;
        org.springframework.security.core.userdetails.User loginedUserInfo = (org.springframework.security.core.userdetails.User) ((Authentication) principal).getPrincipal();
        String userInfo = WebUtils.toString(loginedUserInfo);
        String nameUser = userRepositories.findByUsername(loginedUserInfo.getUsername()).getEmployee().getEmployeeName();
        return nameUser;
    }


    @GetMapping("")
    public ModelAndView showIndex(Model model, @PageableDefault(size = 10) Pageable pageable,
                                  Optional<String> search){
        if(search.isPresent()){
            return new ModelAndView("employee/list","employeeList",employeeService.findCustomerByEmployeeName(search.get(), pageable));
        }
        return new ModelAndView("employee/list","employeeList",employeeService.findAll(pageable));
    }

    @ModelAttribute("positions")
    public List<Position> positions(){
        return employeeService.findAllPosition();
    }

    @ModelAttribute("degrees")
    public List<EducationDegree> educationDegrees(){
        return employeeService.findAllDegree();
    }

    @ModelAttribute("divisions")
    public List<Division> divisions(){
        return employeeService.findAllDivision();
    }

    @GetMapping("/create")
    public ModelAndView showFormCreate(){
        return new ModelAndView("employee/create","employee",new Employee());
    }

    @PostMapping("/create")
    public String create(@Validated @ModelAttribute("employee") Employee employee, BindingResult bindingResult){
        if(bindingResult.hasFieldErrors()) {
            return "employee/create";
        }
        employeeService.save(employee);

        return "redirect:/employees/";
    }

    @GetMapping("/edit/{id}")
    public String showFormEdit(@PathVariable("id") Integer id, Model model){
        Employee employee = employeeService.findById(id);
        EmployeeCreate employeeCreate = new EmployeeCreate(employee);
        model.addAttribute("employeeCreate", employeeCreate);
        return "employee/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("employeeCreate") EmployeeCreate e){
        Employee employee = new Employee(e.getEmployeeId(), e.getEmployeeName(), e.getEmployeeBirthday(), e.getEmployeeIdCard(),e.getEmployeeSalary(), e.getEmployeePhone(), e.getEmployeeEmail(),
                e.getEmployeeAddress() ,new Position(e.getPositionId()),new EducationDegree(e.getDegreeId()), new Division(e.getDivisionId()), new User(e.getUsername()));
        employee.getUser().setPassword(e.getPassword());
        employeeService.save(employee);

        return "redirect:/employees/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        employeeService.remove(id);
        return "redirect:/employees/";
    }
}
