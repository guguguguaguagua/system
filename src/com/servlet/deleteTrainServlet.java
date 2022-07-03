package com.servlet;

import com.DAO.DAOFactory;
import com.DAO.TrainDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/deleteTrainServlet")
public class deleteTrainServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String TrainNumber = request.getParameter("TrainNumber");
        TrainDAO trainDAO = DAOFactory.getTrainDAOImpl();
        try {
            if (trainDAO.DeleteTrain(TrainNumber)) {
                request.getRequestDispatcher("trainManage.jsp").forward(request,response);
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
