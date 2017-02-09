package com.nupt.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/vote")
public class voteJump extends HttpServlet{
	protected void doGet(HttpServletRequest request,HttpServletResponse response){
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/vote.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response){
		doGet(request,response);
	}
}
