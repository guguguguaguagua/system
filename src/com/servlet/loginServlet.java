package com.servlet;

import com.DAO.DAOFactory;
import com.DAO.UserDAO;
import com.bean.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDAO userDAO = DAOFactory.getUserDAOImpl();
        String mess = null;
        HttpSession session = request.getSession();
        try {
            User user = userDAO.Login(request.getParameter("UserNumber"));
            if (user.getUserNumber() == null) {
                mess = "用户名不存在！";
                session.setAttribute("mess", mess);
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }

            if (request.getParameter("UserPassword").equals(user.getUserPassword())) {
                session.setAttribute("user", user);
                request.setAttribute("mess", null);
                request.getRequestDispatcher("user.jsp").forward(request, response);
            } else {
                mess = "密码错误！";
                session.setAttribute("mess", mess);
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}

