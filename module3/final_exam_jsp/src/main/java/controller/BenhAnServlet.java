package controller;

import model.bean.BenhAn;
import model.service.BenhAnService;
import model.service.impl.BenhAnServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.Map;

@WebServlet(name = "BenhAnServlet",urlPatterns = {"","/benhAn"})
public class BenhAnServlet extends HttpServlet {
    BenhAnService benhAnService = new BenhAnServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action){
            case "edit":
                updateBenhAn(request,response);
                break;
            case "delete":
                deleteBenhAn(request,response);
                break;
        }
    }

    private void deleteBenhAn(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id_delete");
        benhAnService.delete(id);
        showListBenhAn(request,response);
    }

    private void updateBenhAn(HttpServletRequest request, HttpServletResponse response) {
        String maBenhAn = request.getParameter("maBenhAn");
        String maBenhNhan = request.getParameter("maBenhNhan");
        String tenBenhNhan = request.getParameter("tenBenhNhan");
        Date ngayNhapVien = Date.valueOf(request.getParameter("ngayNhapVien"));
        Date ngayRaVien = Date.valueOf(request.getParameter("ngayRaVien"));
        String lyDo = request.getParameter("lyDo");
        BenhAn benhAn = new BenhAn(maBenhAn,maBenhNhan,tenBenhNhan,ngayNhapVien,ngayRaVien,lyDo);
        Map<String,String> mapMessage = benhAnService.update(benhAn);
        if(!mapMessage.isEmpty()){
            request.setAttribute("errName",mapMessage.get("errName"));
            request.setAttribute("benhAn",benhAn);
            try {
                request.getRequestDispatcher("update.jsp").forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            showListBenhAn(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action==null) action="";
        switch (action){
            case "edit":
                showUpdateForm(request,response);
                break;
            case "create":
                response.sendRedirect("create.jsp");
                break;
            default:
                showListBenhAn(request,response);
                break;
        }
    }

    private void showUpdateForm(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        BenhAn benhAn = benhAnService.findById(id);
        request.setAttribute("benhAn",benhAn);
        try {
            request.getRequestDispatcher("update.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showListBenhAn(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("listBenhAn",benhAnService.findAll());
        try {
            request.getRequestDispatcher("list.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
