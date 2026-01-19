package com.ajay.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ajay.util.DBConnection;

@WebServlet("/DeleteQuestion")
public class DeleteQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		try(Connection con = DBConnection.getConnection();){
			PreparedStatement pstmt = con.prepareStatement("Delete from question where q_id = ?");
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		response.sendRedirect("ListServlet");
	}

}
