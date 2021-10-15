package controller;

import entity.Product;
import service.ProductService;
import service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = {"","/list","/product"})
public class ProductServlet extends HttpServlet {
    private ProductService productService = new ProductServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action==null){
            action="";
        }
        switch (action){
            case "create":
                create(request,response);
                break;
            case "update":
                update(request,response);
                break;
            default:break;
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String err = null;
        try {
            Integer id = Integer.valueOf(request.getParameter("id"));
            String name = request.getParameter("name");
            String type = request.getParameter("type");
            String desc = request.getParameter("desc");
            Double price = Double.valueOf(request.getParameter("price"));
            String urlImage = request.getParameter("urlImage");
            productService.updateProduct(id,name,type,desc,price,urlImage);
        } catch (NumberFormatException e){
            err = "Nhập sai định dạng hoặc không đủ thông tin !!";
        }catch (Exception exception) {
            err = exception.getMessage();
        }
        if(err == null) request.setAttribute("message", "Sủa thành công !!");
        else request.setAttribute("err", err);
        goListProduct(request,response);
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String err = null;
        try {
            Integer id = Integer.valueOf(request.getParameter("id"));
            String name = request.getParameter("name");
            String type = request.getParameter("type");
            String desc = request.getParameter("desc");
            Double price = Double.valueOf(request.getParameter("price"));
            String urlImage = request.getParameter("urlImage");
            productService.addProduct(id,name,type,desc,price,urlImage);
        } catch (NumberFormatException e){
            err = "Nhập sai định dạng hoặc không đủ thông tin !!";
        }catch (Exception exception) {
            err = exception.getMessage();
        }
        if(err == null) request.setAttribute("message", "Thêm thành công !!");
        else request.setAttribute("err", err);
        goListProduct(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action="";
        }
        switch (action) {
            case "create":
                response.sendRedirect("create.jsp");
                break;
            case "search":
                goSearch(request,response);
                break;
            case "update":
                goUpdate(request,response);
                break;
            case "delete":
                goDelete(request,response);
                break;
            case "view":
                goView(request,response);
                break;
            default:
                goListProduct(request,response);
                break;
        }
    }

    private void goView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        Product product = productService.findById(id);
        request.setAttribute("product", product);
        request.getRequestDispatcher("view.jsp").forward(request,response);
    }

    private void goDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        productService.deleteProduct(id);
        request.setAttribute("message","Xoá thành công !!");
        goListProduct(request,response);
    }

    private void goUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        Product product = productService.findById(id);
        request.setAttribute("product", product);
        request.getRequestDispatcher("update.jsp").forward(request,response);
    }

    private void goSearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList = productService.findAll();
        List<Product> productListSearch = new ArrayList<>();
        String name = request.getParameter("name");
        for(Product product : productList){
            if(product.getName().equals(name)){
                productListSearch.add(product);
            }
        }
        request.setAttribute("message", "Tìm thấy " + productListSearch.size() +" sản phẩm");
        request.setAttribute("productListServlet", productListSearch);
        request.getRequestDispatcher("list.jsp").forward(request,response);
    }

    private void goListProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList = productService.findAll();
        request.setAttribute("productListServlet", productList);
        request.getRequestDispatcher("list.jsp").forward(request,response);
    }
}
