package com.util;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebFilter("/*")
public class accessFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpRequest = (HttpServletRequest) req;
        HttpSession session = httpRequest.getSession();
        ArrayList<String> List = new ArrayList<String>();
        List.add("/login.jsp");
        List.add("/loginServlet");
        List.add("/addUser.jsp");
        List.add("/error.jsp");
        List.add("/registerServlet");
        List.add("/adminLogin.jsp");
        List.add("/adminLoginServlet");

        ArrayList<String> userList = new ArrayList<String>();
        userList.add("/user.jsp");
       // userList.add("/userchange.jsp");
        userList.add("/order.jsp");
        userList.add("/seekTrainServlet");
        userList.add("/seekOrderServlet");
        userList.add("/addOrderServlet");
        userList.add("/deleteOrderServlet");
        userList.add("/changeUserServlet");
        String currentUrl = httpRequest.getServletPath();
        if (List.contains(currentUrl)) {
            chain.doFilter(req, resp);
        }
        else if (session.getAttribute("user") != null && userList.contains(currentUrl)) {
            chain.doFilter(req,resp);
        }
        else if (session.getAttribute("admin") != null && !userList.contains(currentUrl)) {
            chain.doFilter(req,resp);
        }
        else {
            req.getRequestDispatcher("error.jsp").forward(req,resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
