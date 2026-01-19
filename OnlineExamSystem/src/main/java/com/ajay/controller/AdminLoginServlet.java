package com.ajay.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ajay.dao.AdminDAO;

@WebServlet("/adminLogin")
public class AdminLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        AdminDAO dao = new AdminDAO();
        boolean isValid = dao.validateAdmin(username, password);

        if (isValid) {
            HttpSession session = request.getSession();
            session.setAttribute("admin", username);
            response.sendRedirect("admin");
        } else {
            response.sendRedirect("adminlogin.html");
        }
    }
}
