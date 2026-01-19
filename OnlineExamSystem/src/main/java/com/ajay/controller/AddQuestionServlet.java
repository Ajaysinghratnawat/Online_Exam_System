package com.ajay.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ajay.dao.QuestionDAO;
import com.ajay.dto.Question;

@WebServlet("/addQuestion")
public class AddQuestionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("admin") == null) {
            response.sendRedirect("adminlogin.html");
            return;
        }

        Question q = new Question();
        q.setQuestion(request.getParameter("question"));
        q.setOption1(request.getParameter("option1"));
        q.setOption2(request.getParameter("option2"));
        q.setOption3(request.getParameter("option3"));
        q.setOption4(request.getParameter("option4"));
        q.setCorrectOption(Integer.parseInt(request.getParameter("correct")));

        QuestionDAO dao = new QuestionDAO();
        dao.addQuestion(q);

        response.sendRedirect("admin");
    }
}
