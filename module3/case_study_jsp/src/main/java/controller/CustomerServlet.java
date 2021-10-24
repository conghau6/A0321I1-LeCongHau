package controller;

import model.bean.customer.Customer;
import model.service.CustomerService;
import model.service.impl.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    CustomerService customerService = new CustomerServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action ==null) action="";
        switch (action){
            case "create":
                response.sendRedirect("/customer/create.jsp");
                break;
            default:
                showListCustomer(request,response);
                break;
        }
    }

    private void showListCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Customer> list = customerService.findAll();
        for(Customer customer : list){
            System.out.println(customer.getCustomerName());
        }
        request.setAttribute("customerList",list);
        request.getRequestDispatcher("/customer/list.jsp").forward(request,response);
    }
}
