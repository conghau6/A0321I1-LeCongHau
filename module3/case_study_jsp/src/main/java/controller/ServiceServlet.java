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
        String action = request.getParameter("action");
        switch (action){
            case "create":
                createService(request,response);
                break;
        }
    }

    private void createService(HttpServletRequest request, HttpServletResponse response) {
        int serviceId = Integer.parseInt(request.getParameter("serviceId"));
        String serviceName = request.getParameter("serviceName");
        int serviceArea = Integer.parseInt(request.getParameter("serviceArea"));
        double serviceCost = Double.parseDouble(request.getParameter("serviceCost"));
        int serviceMaxPeople = Integer.parseInt(request.getParameter("serviceMaxPeople"));
        int rentTypeId = Integer.parseInt(request.getParameter("rentTypeId"));
        int serviceTypeId = Integer.parseInt(request.getParameter("serviceTypeId"));
        String standardRoom = request.getParameter("standardRoom");
        String desc = request.getParameter("desc");
        double poolArea = Double.parseDouble(request.getParameter("poolArea"));
        int numberOfFloor = Integer.parseInt(request.getParameter("numberOfFloor"));

        Service service = new Service(serviceId,serviceName,serviceArea,serviceCost,serviceMaxPeople,rentTypeId,serviceTypeId,
                standardRoom,desc,poolArea,numberOfFloor);
        serviceService.save(service);
        try {
            showListService(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action==null) action="";
        switch (action){
            case "create":
                showFormCreate(request,response);
                break;
            default:
                showListService(request,response);
                break;
        }
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("serviceTypeList",serviceTypeService.findAll());
        request.setAttribute("rentTypeList",rentTypeService.findAll());
        request.setAttribute("standardRoomList",serviceService.findAllStandardRoom());
        try {
            request.getRequestDispatcher("/service/create.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showListService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Service> list = serviceService.findAll();
        request.setAttribute("serviceList", list);
        request.getRequestDispatcher("/service/list.jsp").forward(request,response);
    }
}
