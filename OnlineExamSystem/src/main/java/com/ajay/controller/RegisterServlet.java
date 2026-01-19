package com.ajay.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ajay.dao.StudentDAO;
import com.ajay.dto.Student;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Fetch form data
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Set values to model
        Student s = new Student();
        s.setName(name);
        s.setEmail(email);
        s.setPassword(password);

        // DAO call
        StudentDAO dao = new StudentDAO();
        boolean status = dao.registerStudent(s);

        if (status) {
            response.sendRedirect("login.html");
        } else {
            response.sendRedirect("register.html");
        }
    }
}
