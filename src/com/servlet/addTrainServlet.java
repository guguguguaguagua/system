package com.servlet;

import com.DAO.DAOFactory;
import com.DAO.TrainDAO;
import com.bean.Train;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/addTrainServlet")
public class addTrainServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Train train = new Train();
        train.setStartStation(request.getParameter("StartStation"));
        train.setEndStation(request.getParameter("EndStation"));
        train.setTrainNumber(request.getParameter("TrainNumber"));
        train.setTrainType(request.getParameter("TrainType"));
        train.setDriveTime(request.getParameter("DriveTime"));
        train.setTicketPrice(request.getParameter("TicketPrice"));
        train.setTrainSitType(request.getParameter("TrainSitType"));
        train.setDateValue(request.getParameter("DateValue"));
        TrainDAO trainDAO = DAOFactory.getTrainDAOImpl();
        try {
            if (trainDAO.AddTrain(train)) {
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
