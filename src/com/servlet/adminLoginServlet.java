package com.servlet;

import com.DAO.AdminDAO;
import com.DAO.DAOFactory;
import com.bean.Admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/adminLoginServlet")
public class adminLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String AdminNumber = request.getParameter("AdminNumber");
        String AdminPassword = request.getParameter("AdminPassword");
        AdminDAO adminDAO = DAOFactory.getAdminDAOImpl();
        try {
            Admin admin = adminDAO.AdminLogin(AdminNumber);
            if (AdminPassword.equals(admin.getAdminPassword())) {
                HttpSession session = request.getSession();
                session.setAttribute("admin",admin);
                request.getRequestDispatcher("admin.jsp").forward(request,response);
            }
            else {
                request.getRequestDispatcher("adminLogin.jsp").forward(request,response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
