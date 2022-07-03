package com.servlet;

import com.DAO.DAOFactory;
import com.DAO.StationDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/deleteStationServlet")
public class deleteStationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String StationNumber = request.getParameter("StationNumber");
        StationDAO stationDAO = DAOFactory.getStationDAOImpl();
        try {
            if (stationDAO.DeleteStation(StationNumber)) {
                request.getRequestDispatcher("stationManage.jsp").forward(request,response);
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
