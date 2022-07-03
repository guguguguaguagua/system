package com.servlet;

import com.DAO.DAOFactory;
import com.DAO.StationDAO;
import com.bean.Station;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/changeStationServlet")
public class changeStationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String StationNumber = request.getParameter("StationNumber");
        String StationName = request.getParameter("StationName");
        Station station = new Station();
        station.setStationNumber(StationNumber);
        station.setStationName(StationName);
        StationDAO stationDAO = DAOFactory.getStationDAOImpl();
        try {
            if (stationDAO.ChangeStation(station)) {
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
