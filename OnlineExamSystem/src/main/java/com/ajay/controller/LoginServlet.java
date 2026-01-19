package com.ajay.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ajay.dao.StudentDAO;
import com.ajay.dto.Student;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        StudentDAO dao = new StudentDAO();
        Student s = dao.loginStudent(email, password);

        if (s != null) {
            // Create session
            HttpSession session = request.getSession();
            session.setAttribute("student", s);

            response.sendRedirect("exam");
        } else {
            response.sendRedirect("login.html");
        }
    }
}
