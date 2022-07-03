package com.servlet;

import com.DAO.DAOFactory;
import com.DAO.UserDAO;
import com.bean.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/changeUserAdminServlet")
public class changeUserAdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        user.setUserNumber(request.getParameter("UserNumber"));
        user.setUserPassword(request.getParameter("UserPassword"));
        user.setUserName(request.getParameter("UserName"));
        UserDAO userDAO = DAOFactory.getUserDAOImpl();
        try {
            if (userDAO.Change(user)) {
                request.getRequestDispatcher("userManage.jsp").forward(request,response);
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
