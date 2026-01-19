package com.ajay.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ajay.dao.QuestionDAO;
import com.ajay.dto.Question;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("admin") == null) {
            response.sendRedirect("adminlogin.html");
            return;
        }

        QuestionDAO dao = new QuestionDAO();
        List<Question> list = dao.getAllQuestions();

        request.setAttribute("questions", list);
        request.getRequestDispatcher("admin.jsp").forward(request, response);
    }
}
