package controler;

import model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StudentServlet",urlPatterns = {"/list","/student"})
public class StudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(453, "Nguyễn Văn A", "06/04/2001", 1, 4.0));
        studentList.add(new Student(453, "Nguyễn Văn B", "02/04/2001", 0, 8.0));
        studentList.add(new Student(453, "Nguyễn Văn C", "06/07/2001", 0, 9.0));
        request.setAttribute("studentListServlet", studentList);
        request.getRequestDispatcher("list_by_jstl.jsp").forward(request, response);
    }
}
