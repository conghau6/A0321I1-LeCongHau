package controller;

import model.bean.service.Service;
import model.bean.service.ServiceType;
import model.service.RentTypeService;
import model.service.ServiceService;
import model.service.ServiceTypeService;
import model.service.impl.RentTypeServiceImpl;
import model.service.impl.ServiceServiceImpl;
import model.service.impl.ServiceTypeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServiceServlet",urlPatterns = "/service")
public class ServiceServlet extends HttpServlet {
    private ServiceService serviceService = new ServiceServiceImpl();
    private ServiceTypeService serviceTypeService = new ServiceTypeServiceImpl();
    private RentTypeService rentTypeService = new RentTypeServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action==null) action="";
        switch (action){
            case "create":
                break;
            default:
                showListService(request,response);
                break;
        }
    }

    private void showListService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Service> list = serviceService.findAll();
        request.setAttribute("serviceList", list);
        request.getRequestDispatcher("/service/list.jsp").forward(request,response);
    }
}
