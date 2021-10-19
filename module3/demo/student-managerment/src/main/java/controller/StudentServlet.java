package controller;

import model.bean.Student;
import model.service.StudentService;
import model.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StudentServlet", urlPatterns = {"", "/students","/list"})
public class StudentServlet extends HttpServlet {
    StudentService studentService = new StudentServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action==null){
            action = "";
        }
        switch (action) {
            case "create":
                break;
            case "update":
                break;
            case "delete":
                break;
            case "search":
                break;
            default:
                showListStudentForm(request,response);
                break;
        }
    }

    private void showListStudentForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> list = studentService.findAll();
        request.setAttribute("list", list);
        request.getRequestDispatcher("list.jsp").forward(request,response);
    }
}
