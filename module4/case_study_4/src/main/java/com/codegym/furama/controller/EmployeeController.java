package com.codegym.furama.controller;

import com.codegym.furama.entity.*;
import com.codegym.furama.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    IEmployeeService employeeService;

    @ModelAttribute("url")
    public String url(){
        return "/employees";
    }

    @GetMapping("")
    public ModelAndView showIndex(@PageableDefault(size = 10) Pageable pageable,
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
        return new ModelAndView("employee/create","employee",new Customer());
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("employee") Employee employee){
        employeeService.save(employee);
        return "redirect:/employees/";
    }

    @GetMapping("/edit/{id}")
    public String showFormEdit(@PathVariable("id") Integer id, Model model){
        Employee employee = employeeService.findById(id);
        model.addAttribute("employee", employee);
        return "employee/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("employee") Employee employee){
        employeeService.save(employee);
        return "employee/edit";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        employeeService.remove(id);
        return "redirect:/employees/";
    }
}
