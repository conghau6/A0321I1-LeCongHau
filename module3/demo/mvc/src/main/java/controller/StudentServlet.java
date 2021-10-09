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
        switch (action){
            case "update":
                Integer id = Integer.valueOf(request.getParameter("id"));
                String name = request.getParameter("name");
                String dateOfBirth = request.getParameter("dateOfBirth");
                this.studentService.updateStudent(id,name,dateOfBirth);
                response.sendRedirect("/student");
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if(action == null) {
            action = "";
        }

        switch (action) {
            case "update":
                Integer id = Integer.valueOf(request.getParameter("id"));
                Student student = this.studentService.findById(id);
                request.setAttribute("student",student);
                request.getRequestDispatcher("update.jsp").forward(request,response);
                break;
            default:
                List<Student> students = this.studentService.findAll();
                request.setAttribute("studentListServlet", students);
                request.getRequestDispatcher("list_by_jstl.jsp").forward(request,response);
        }
    }
}
