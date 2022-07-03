package com.servlet;

import com.DAO.DAOFactory;
import com.DAO.OrderDAO;
import com.bean.Order;
import com.bean.Train;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/seekOrderServlet")
public class seekOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String UserNumber = request.getParameter("UserNumber");
        OrderDAO orderDAO = DAOFactory.getOrderDAOImpl();
        //List<Train> trainList = trainDAO.SeekTrain(request.getParameter("StartStation"),request.getParameter("EndStation"));
        try {
            List<Order> orderList  = orderDAO.SeekUserOrder(UserNumber);
            request.setAttribute("orderList",orderList);
            request.getRequestDispatcher("order.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
