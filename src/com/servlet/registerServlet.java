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

@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String mess=null;
        String mess1=null;
        User user = new User();
        user.setUserNumber(request.getParameter("UserNumber"));
        user.setUserPassword(request.getParameter("UserPassword"));
        user.setUserName(request.getParameter("UserName"));
        UserDAO userDAO = DAOFactory.getUserDAOImpl();
        try {
            if (userDAO.Register(user)) {
                mess="注册成功，快去登录吧(๑•̀ㅂ•́)و✧";
                session.setAttribute("mess",mess);
                session.setAttribute("mess1",null);
                request.getRequestDispatcher("login.jsp").forward(request,response);
            }
            else {
                mess1="插入失败，可能是用户名重复了!!(ノへ￣、)";
                session.setAttribute("mess1",mess1);
                request.getRequestDispatcher("addUser.jsp").forward(request,response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
