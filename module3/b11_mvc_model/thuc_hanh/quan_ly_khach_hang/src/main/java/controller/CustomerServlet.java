package controller;

import entity.Customer;
import service.CustomerService;
import service.impl.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = {"","/customer"})
public class CustomerServlet extends HttpServlet {
    CustomerService customerService = new CustomerServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = null;
        String name = null;
        String email = null;
        String address = null;

        String action = request.getParameter("action");
        switch (action){
            case "create":
                id = Integer.valueOf(request.getParameter("id"));
                name = request.getParameter("name");
                email = request.getParameter("email");
                address = request.getParameter("address");
                this.customerService.addCustomer(id,name,email,address);
                response.sendRedirect("/customer");
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action  = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action) {
            case "create":
                request.getRequestDispatcher("create.jsp").forward(request,response);
                break;
            default:
                goCustomerList(request,response);
                break;
        }
    }

    private void goCustomerList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("customerListServlet", customerService.findAll());
        request.getRequestDispatcher("list.jsp").forward(request,response);
    }
}
