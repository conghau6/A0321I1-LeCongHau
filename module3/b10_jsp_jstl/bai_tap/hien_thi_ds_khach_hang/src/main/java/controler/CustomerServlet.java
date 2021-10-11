package controler;

import model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customer_list")
public class CustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = new ArrayList<>();
        customerList.add(new Customer("Lê Công Hậu", "31-12-2001", "Quảng Nam", "https://cdn.nguyenkimmall.com/images/detailed/555/may-anh-cho-nguoi-moi.jpg"));
        customerList.add(new Customer("Lê Văn Hậu", "5-11-2002", "Quảng Ngãi", "https://cellphones.com.vn/sforum/wp-content/uploads/2018/11/3-8.png"));
        customerList.add(new Customer("Nguyễn Công Hậu", "3-3-2003", "Quảng Bình", "https://cellphones.com.vn/sforum/wp-content/uploads/2020/04/LR-29-scaled.jpg"));
        customerList.add(new Customer("Võ Công Hậu", "1-6-2001", "Quảng Trị", "https://media.travelmag.vn/files/tranthuthao172/2021/04/09/chup-anh-voi-bau-troi-1302.jpg"));

        request.setAttribute("customerListServlet", customerList);
        request.getRequestDispatcher("list_customer.jsp").forward(request,response);
    }
}
