package controller;

import entity.Student;
import service.StudentService;
import service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentServlet", urlPatterns = {"","/list","/student"})
public class StudentServlet extends HttpServlet {
    private StudentService studentService = new StudentServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        Integer id = null;
        String name = null;
        String dateOfBirth = null;
        Integer gender = null;
        Double grade = null;

        switch (action){
            case "add":
                id = Integer.valueOf(request.getParameter("id"));
                name = request.getParameter("name");
                dateOfBirth = request.getParameter("dateOfBirth");
                gender = Integer.valueOf(request.getParameter("gender"));
                grade = Double.valueOf(request.getParameter("grade"));
                this.studentService.addStudent(id,name,dateOfBirth,gender,grade);
                response.sendRedirect("/student");
                break;
            case "update":
                id = Integer.valueOf(request.getParameter("id"));
                name = request.getParameter("name");
                dateOfBirth = request.getParameter("dateOfBirth");
                gender = Integer.valueOf(request.getParameter("gender"));
                grade = Double.valueOf(request.getParameter("grade"));
                this.studentService.updateStudent(id,name,dateOfBirth,gender,grade);
                response.sendRedirect("/student");
                break;
            case "delete":
                id = Integer.valueOf(request.getParameter("id"));
                this.studentService.deleteStudent(id);
                response.sendRedirect("/student");
                break;
            default:
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        Integer id = -1;
        Student student = null;

        if(action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                request.getRequestDispatcher("add.jsp").forward(request,response);
                break;
            case "update":
                id = Integer.valueOf(request.getParameter("id"));
                student = this.studentService.findById(id);
                request.setAttribute("student",student);
                request.getRequestDispatcher("update.jsp").forward(request,response);
                break;
            case "delete":
                id = Integer.valueOf(request.getParameter("id"));
                student = this.studentService.findById(id);
                request.setAttribute("student",student);
                request.getRequestDispatcher("delete.jsp").forward(request,response);
                break;
            default:
                List<Student> students = this.studentService.findAll();
                request.setAttribute("studentListServlet", students);
                request.getRequestDispatcher("list_by_jstl.jsp").forward(request,response);
        }
    }
}
