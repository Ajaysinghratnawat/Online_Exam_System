package com.ajay.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ajay.dao.QuestionDAO;
import com.ajay.dto.Question;

@WebServlet("/ListServlet")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 List<Question> list = QuestionDAO.getAllQuestions();
	        request.setAttribute("questions", list);
	        RequestDispatcher rd= request.getRequestDispatcher("admin.jsp");
	        rd.forward(request, response);
	}
}
