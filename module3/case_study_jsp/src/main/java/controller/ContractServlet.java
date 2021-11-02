package controller;

import model.bean.contract.Contract;
import model.service.ContractService;
import model.service.impl.ContractServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "ContractServlet", urlPatterns = "/contract")
public class ContractServlet extends HttpServlet {
    ContractService contractService = new ContractServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action){
            case "create":
                createContract(request,response);
                break;
            case "delete":
                deleteContract(request,response);
                break;
        }
    }

    private void deleteContract(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id_delete"));
        contractService.delete(id);
        showListContract(request,response);
    }

    private void createContract(HttpServletRequest request, HttpServletResponse response) {
        int contractId = Integer.parseInt(request.getParameter("contractId"));
        Date contractStartDate = Date.valueOf(request.getParameter("contractStartDate"));
        Date contractEndDate = Date.valueOf(request.getParameter("contractEndDate"));
        double contractDeposit = Double.parseDouble(request.getParameter("contractDeposit"));
        double contractTotalMoney = Double.parseDouble(request.getParameter("contractTotalMoney"));
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));
        int customerId = Integer.parseInt(request.getParameter("customerId"));
        int serviceId = Integer.parseInt(request.getParameter("serviceId"));

        Contract contract = new Contract(contractId,contractStartDate,contractEndDate,contractDeposit,
                contractTotalMoney,employeeId,customerId,serviceId);

        contractService.create(contract);
        showListContract(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action==null) action = "";
        switch (action){
            case "create":
                showFormCreate(request,response);
                break;
            default:
                showListContract(request,response);
                break;
        }
    }


    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("employeeList", contractService.findAllEmployee());
        request.setAttribute("customerList", contractService.findAllCustomer());
        request.setAttribute("serviceList", contractService.findAllService());
        try {
            request.getRequestDispatcher("/contract/create.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showListContract(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("contractList", contractService.findAllContract());
        try {
            request.getRequestDispatcher("/contract/list.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
