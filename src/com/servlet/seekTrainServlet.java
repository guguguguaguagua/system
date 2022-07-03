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
import java.util.List;

@WebServlet("/seekTrainServlet")
public class seekTrainServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TrainDAO trainDAO = DAOFactory.getTrainDAOImpl();
            try {
               List<Train> trainList = trainDAO.SeekTrain(request.getParameter("StartStation"),request.getParameter("EndStation"));
               // List<Train> trainList = trainDAO.AllTrain();
                request.setAttribute("trainList",trainList);
                request.getRequestDispatcher("user.jsp").forward(request,response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
