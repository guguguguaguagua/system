package com.servlet;

import com.DAO.AdminDAO;
import com.DAO.DAOFactory;
import com.bean.Admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/changeAdminServlet")
public class changeAdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Admin admin = new Admin();
        admin.setAdminNumber(request.getParameter("AdminNumber"));
        admin.setAdminPassword(request.getParameter("AdminPassword"));
        admin.setAdminName(request.getParameter("AdminName"));
        AdminDAO adminDAO = DAOFactory.getAdminDAOImpl();
        try {
            if (adminDAO.ChangeAdmin(admin)) {
                request.getRequestDispatcher("adminLogin.jsp").forward(request,response);
            }
            else {
                request.getRequestDispatcher("error.jsp").forward(request,response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
