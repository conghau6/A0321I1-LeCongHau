package controller;

import model.bean.customer.Customer;
import model.service.CustomerService;
import model.service.CustomerTypeService;
import model.service.impl.CustomerServiceImpl;
import model.service.impl.CustomerTypeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    CustomerService customerService = new CustomerServiceImpl();
    CustomerTypeService customerTypeService = new CustomerTypeServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action){
            case "create":
                saveCustomer(request,response);
                break;
            case "edit":
                updateCustomer(request,response);
                break;
        }
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int customerId = Integer.parseInt(request.getParameter("customerId"));
        String customerName = request.getParameter("customerName");
        int customerTypeId = Integer.parseInt(request.getParameter("customerTypeId"));
        java.sql.Date customerBirthday = Date.valueOf(request.getParameter("customerBirthday"));
        String customerIdCard = request.getParameter("customerIdCard");
        String customerPhone = request.getParameter("customerPhone");
        String customerEmail = request.getParameter("customerEmail");
        String customerAddress = request.getParameter("customerAddress");
        int customerGender = Integer.parseInt(request.getParameter("customerGender"));

        Customer customer = new Customer(customerId,customerTypeId,customerName,customerBirthday,customerGender,
                customerIdCard,customerPhone,customerEmail,customerAddress);
        customerService.update(customer);
        showListCustomer(request,response);
    }

    private void saveCustomer(HttpServletRequest request, HttpServletResponse response) {
        int customerId = Integer.parseInt(request.getParameter("customerId"));
        String customerName = request.getParameter("customerName");
        int customerTypeId = Integer.parseInt(request.getParameter("customerTypeId"));
        java.sql.Date customerBirthday = java.sql.Date.valueOf(request.getParameter("customerBirthday"));
        String customerIdCard = request.getParameter("customerIdCard");
        String customerPhone = request.getParameter("customerPhone");
        String customerEmail = request.getParameter("customerEmail");
        String customerAddress = request.getParameter("customerAddress");
        int customerGender = Integer.parseInt(request.getParameter("customerGender"));

        Customer customer = new Customer(customerId,customerTypeId,customerName,customerBirthday,customerGender,
                customerIdCard,customerPhone,customerEmail,customerAddress);
        customerService.save(customer);
        showListCustomer(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getParameter("action");
        if(action ==null) action="";
        switch (action){
            case "create":
                try {
                    showFormCreate(request,response);
                } catch (ServletException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "edit":
                try {
                    showFormUpdate(request,response);
                } catch (ServletException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "delete":
                try {
                    deleteCustomer(request,response);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ServletException e) {
                    e.printStackTrace();
                }
                break;
            default:
                showListCustomer(request,response);
                break;
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        customerService.delete(id);
        showListCustomer(request,response);
    }

    private void showFormUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("customer", customerService.findById(id));
        request.setAttribute("listCustomerType", customerTypeService.findAll());
        request.getRequestDispatcher("/customer/update.jsp").forward(request,response);
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listCustomerType", customerTypeService.findAll());
        request.getRequestDispatcher("/customer/create.jsp").forward(request,response);
    }

    private void showListCustomer(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> list = customerService.findAll();
        request.setAttribute("customerList",list);
        try {
            request.getRequestDispatcher("/customer/list.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
