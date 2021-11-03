package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet",urlPatterns = {"","/login"})
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        HttpSession session = request.getSession();
        if("admin".equals(username) && "123".equals(password)){
            System.out.println("Đăng nhập thành công");
            if(request.getParameter("chkRemember") != null){
                Cookie co_username = new Cookie("co_username",username);
                Cookie co_password = new Cookie("co_password",password);
                co_username.setMaxAge(180); //2p
                co_password.setMaxAge(180); //2p

                response.addCookie(co_username);
                response.addCookie(co_password);
            }

            session.setAttribute("session_login",username);
            response.sendRedirect("/employee");
        } else {
            System.out.println("Đăng nhập thất bại");
            request.setAttribute("message","Tên đăng nhập hoặc mật khẩu không đúng");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("login.jsp");
    }
}
