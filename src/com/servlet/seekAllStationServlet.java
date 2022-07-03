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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/seekAllStationServlet")
public class seekAllStationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StationDAO stationDAO = DAOFactory.getStationDAOImpl();
        try {
            List<Station> stationList = stationDAO.seekAllStation();
            request.setAttribute("stationList",stationList);
            request.getRequestDispatcher("stationManage.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
