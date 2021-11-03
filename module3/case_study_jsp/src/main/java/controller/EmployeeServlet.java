package controller;

import model.bean.employee.Employee;
import model.service.EmployeeService;
import model.service.impl.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "EmployeeServlet", urlPatterns = "/employee")
public class EmployeeServlet extends HttpServlet {
    EmployeeService employeeService = new EmployeeServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action){
            case "create":
                createEmployee(request,response);
                break;
            case "edit":
                editEmployee(request,response);
                break;
        }
    }

    private void editEmployee(HttpServletRequest request, HttpServletResponse response) {
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));
        String employeeName = request.getParameter("employeeName");
        Date employeeBirthday = Date.valueOf(request.getParameter("employeeBirthday"));
        String employeeIdCard = request.getParameter("employeeIdCard");
        double employeeSalary = Double.parseDouble(request.getParameter("employeeSalary"));
        String employeePhone = request.getParameter("employeePhone");
        String employeeEmail = request.getParameter("employeeEmail");
        String employeeAddress = request.getParameter("employeeAddress");
        int positionId = Integer.parseInt(request.getParameter("positionId"));
        String positionName = request.getParameter("positionName");
        int educationDegreeId = Integer.parseInt(request.getParameter("educationDegreeId"));
        String educationDegreeName = request.getParameter("educationDegreeName");
        int divisionId = Integer.parseInt(request.getParameter("divisionId"));
        String divisionName = request.getParameter("divisionName");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Employee employee = new Employee(employeeId,employeeName,employeeBirthday,employeeIdCard,employeeSalary,
                employeePhone,employeeEmail,employeeAddress,positionId,positionName,educationDegreeId,
                educationDegreeName,divisionId,divisionName,username,password);
        employeeService.edit(employee);
        showListEmployee(request,response);
    }

    private void createEmployee(HttpServletRequest request, HttpServletResponse response) {
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));
        String employeeName = request.getParameter("employeeName");
        Date employeeBirthday = Date.valueOf(request.getParameter("employeeBirthday"));
        String employeeIdCard = request.getParameter("employeeIdCard");
        double employeeSalary = Double.parseDouble(request.getParameter("employeeSalary"));
        String employeePhone = request.getParameter("employeePhone");
        String employeeEmail = request.getParameter("employeeEmail");
        String employeeAddress = request.getParameter("employeeAddress");
        int positionId = Integer.parseInt(request.getParameter("positionId"));
        String positionName = request.getParameter("positionName");
        int educationDegreeId = Integer.parseInt(request.getParameter("educationDegreeId"));
        String educationDegreeName = request.getParameter("educationDegreeName");
        int divisionId = Integer.parseInt(request.getParameter("divisionId"));
        String divisionName = request.getParameter("divisionName");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Employee employee = new Employee(employeeId,employeeName,employeeBirthday,employeeIdCard,employeeSalary,
                employeePhone,employeeEmail,employeeAddress,positionId,positionName,educationDegreeId,
                educationDegreeName,divisionId,divisionName,username,password);
        employeeService.create(employee);
        showListEmployee(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cookie[] cookies = request.getCookies();

        if(cookies!=null){
            Cookie cookie = null;
            for(int i=0; i<cookies.length; i++){
                cookie = cookies[i];
                if("co_username".equals(cookie.getName()) && "admin".equals(cookie.getValue())){
                    session.setAttribute("session_login",cookie.getValue());
                    break;
                }
            }
        }

        if(session.getAttribute("session_login") == null){
            response.sendRedirect("/login");
            return;
        }
        String action = request.getParameter("action");
        if(action==null) action = "";
        switch (action){
            case "create":
                showFormCreate(request,response);
                break;
            case "edit":
                showFormEdit(request,response);
                break;
            case "delete":
                deleteEmployee(request,response);
                break;
            default:
                showListEmployee(request,response);
                break;
        }
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        employeeService.delete(id);
        showListEmployee(request,response);
    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee employee = employeeService.findById(id);
        request.setAttribute("employee", employee);

        request.setAttribute("positionList", employeeService.findAllPosition());
        request.setAttribute("divisionList", employeeService.findAllDivision());
        request.setAttribute("degreeList",employeeService.findAllEducationDegree());

        try {
            request.getRequestDispatcher("/employee/update.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("positionList", employeeService.findAllPosition());
        request.setAttribute("divisionList", employeeService.findAllDivision());
        request.setAttribute("degreeList",employeeService.findAllEducationDegree());
        try {
            request.getRequestDispatcher("/employee/create.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showListEmployee(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("employeeList", employeeService.findAll());
        request.setAttribute("positionList", employeeService.findAllPosition());
        request.setAttribute("divisionList", employeeService.findAllDivision());
        request.setAttribute("degreeList",employeeService.findAllEducationDegree());
        try {
            request.getRequestDispatcher("/employee/list.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
