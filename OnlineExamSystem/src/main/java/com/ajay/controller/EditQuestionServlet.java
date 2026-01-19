package com.ajay.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ajay.util.DBConnection;


@WebServlet("/editQuestion")
public class EditQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String question = request.getParameter("question");
		String option1 = request.getParameter("option1");
		String option2 = request.getParameter("option2");
		String option3 = request.getParameter("option3");
		String option4 = request.getParameter("option4");
		String correct = request.getParameter("correct");
		try(Connection con = DBConnection.getConnection();) {
			Statement stmt = con.createStatement();
			if(question!="") {
				stmt.executeUpdate("Update question set question='"+question+"'"+"where q_id = '"+id+"'");
			}
			if(option1!="") {
				stmt.executeUpdate("Update question set option1='"+option1+"'"+"where q_id = '"+id+"'");
			}
			if(option2!="") {
				stmt.executeUpdate("Update question set option2='"+option2+"'"+"where q_id = '"+id+"'");
			}
			if(option3!="") {
				stmt.executeUpdate("Update question set option3='"+option3+"'"+"where q_id = '"+id+"'");
			}
			if(option4!="") {
				stmt.executeUpdate("Update question set option4='"+option4+"'"+"where q_id = '"+id+"'");
			}
			if(correct!="") {
				stmt.executeUpdate("Update question set correct_option='"+correct+"'"+"where q_id = '"+id+"'");
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
		response.sendRedirect("ListServlet");
		
	}

}
