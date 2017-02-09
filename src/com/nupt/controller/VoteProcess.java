package com.nupt.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/voteProcess")
public class VoteProcess extends HttpServlet{
	protected void doGet(HttpServletRequest request,HttpServletResponse response){
		String color = request.getParameter("color");
		HttpSession httpSession = request.getSession();
		
		Object colorNumber = httpSession.getAttribute("colorNumber");
		Object red = httpSession.getAttribute("red");
		Object green = httpSession.getAttribute("green");
		Object blue = httpSession.getAttribute("blue");
		
		
		
		if(colorNumber == null){
			httpSession.setAttribute("colorNumber", 1);
		}else{
			httpSession.setAttribute("colorNumber", Integer.parseInt(colorNumber.toString())+1);
		}
		
		
		if(red == null){
			if(color.equals("red")){
				httpSession.setAttribute("red",1);
			}else{
				httpSession.setAttribute("red",0);
			}
		}else{
			if(color.equals("red")){
				httpSession.setAttribute("red",Integer.parseInt(red.toString())+1);
			}
		}
		
		if(green == null){
			if(color.equals("green")){
				httpSession.setAttribute("green",1);
			}else{
				httpSession.setAttribute("green",0);
			}
		}else{
			if(color.equals("green")){
				httpSession.setAttribute("green",Integer.parseInt(green.toString())+1);
			}
		}
		
		if(blue == null){
			if(color.equals("blue")){
				httpSession.setAttribute("blue",1);
			}else{
				httpSession.setAttribute("blue",0);
			}
		}else{
			if(color.equals("blue")){
				httpSession.setAttribute("blue",Integer.parseInt(blue.toString())+1);
			}
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/voteResult.jsp");
		try {
			rd.forward(request,response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response){
		doGet(request,response);
	}
}
