package com.servlet;

import com.DAO.DAOFactory;
import com.DAO.OrderDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
@WebServlet("/deleteOrderServlet")
public class deleteOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String OrderNumber = request.getParameter("OrderNumber");
        //OrderDAO orderDAO = DAOFactory.getOrderDAOImpl();
        OrderDAO orderDAO = DAOFactory.getOrderDAOImpl();
        try {
            if (orderDAO.DeleteOrder(OrderNumber)) {
                request.getRequestDispatcher("user.jsp").forward(request,response);
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
