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
import java.util.InputMismatchException;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = {"","/customer"})
public class CustomerServlet extends HttpServlet {
    CustomerService customerService = new CustomerServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action){
            case "create":
                create(request,response);
                break;
            case "update":
                update(request,response);
                break;
            case "delete":
                delete(request,response);
                break;
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        this.customerService.deleteCustomer(id);
        request.setAttribute("message", "Xoá thành công !!");
        goListCustomer(request,response);
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = null;
        String name = null;
        String email = null;
        String address = null;
        String err = null;
        try {
            id = Integer.valueOf(request.getParameter("id"));
            name = request.getParameter("name");
            email = request.getParameter("email");
            address = request.getParameter("address");
        } catch (InputMismatchException e){
            err = "Nhâp sai định dạng";
        } catch (Exception e) {
            err = "Đã có lỗi xảy ra";
        }
        if(err==null) {
            try {
                this.customerService.updateCustomer(id,name,email,address);
            } catch (Exception exception) {
                err = exception.getMessage();
            }
        }
        request.setAttribute("err", err);
        if(err==null && id!=null && name!="" && address!="" && email!="") {
            request.setAttribute("message", "Cập nhật thành công!!!");
        } else {
            request.setAttribute("message", "Chưa nhập đủ thông tin!!!");
        }
        goListCustomer(request,response);
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = null;
        String name = null;
        String email = null;
        String address = null;
        String err = null;
        try {
             id = Integer.valueOf(request.getParameter("id"));
             name = request.getParameter("name");
             email = request.getParameter("email");
             address = request.getParameter("address");
        } catch (InputMismatchException e){
            err = "Nhâp sai định dạng";
        } catch (Exception e) {
            err = "Đã có lỗi xảy ra";
        }
        if(err==null) {
            try {
                this.customerService.addCustomer(id,name,email,address);
            } catch (Exception exception) {
                err = exception.getMessage();
            }
        }
        request.setAttribute("err", err);
        if(err==null && id!=null && name!="" && address!="" && email!="") {
            request.setAttribute("message", "Thêm thành công!!!");
        } else {
            request.setAttribute("message", "Chưa nhập đủ thông tin!!!");
        }
        goListCustomer(request,response);
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
            case "update":
                goUpdate(request,response);
                break;
            case "delete":
                goDelete(request,response);
                break;
            case "view":
                doView(request,response);
                break;
            default:
                goListCustomer(request,response);
                break;
        }
    }

    private void doView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        Customer customer = customerService.findById(id);
        request.setAttribute("customer", customer);
        request.getRequestDispatcher("view.jsp").forward(request,response);
    }

    private void goDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        Customer customer = customerService.findById(id);
        request.setAttribute("customer", customer);
        request.getRequestDispatcher("delete.jsp").forward(request,response);
    }

    private void goUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        Customer customer = customerService.findById(id);
        request.setAttribute("customer", customer);
        request.getRequestDispatcher("update.jsp").forward(request,response);
    }

    private void goListCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = this.customerService.findAll();
        request.setAttribute("customerListServlet", customerList);
        request.getRequestDispatcher("list.jsp").forward(request,response);
    }
}
