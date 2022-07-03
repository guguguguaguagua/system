package com.servlet;

import com.DAO.DAOFactory;
import com.DAO.OrderDAO;
import com.bean.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;

@WebServlet("/addOrderServlet")
public class addOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String UserNumber = request.getParameter("UserNumber");
        String TrainNumber = request.getParameter("TrainNumber");
        Random random = new Random();
        String OrderNumber = "";
        for (int i = 0; i < 6; i++) {
            OrderNumber += random.nextInt(10);
        }
        Order order = new Order();
        order.setOrderNumber(OrderNumber);
        order.setUserNumber_temp(UserNumber);
        order.setTrainNumber_temp(TrainNumber);
        OrderDAO orderDAO = DAOFactory.getOrderDAOImpl();
        try {
            if (orderDAO.AddOrder(order)) {
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
