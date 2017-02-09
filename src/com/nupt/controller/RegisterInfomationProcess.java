package com.nupt.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterInformationProcess")
public class RegisterInfomationProcess extends HttpServlet {
	
	protected  void doGet(HttpServletRequest request,HttpServletResponse response){
		String name = request.getParameter("txtName");
		String pwd = request.getParameter("txtPwd");
		
		File file = new File("E:/file/userInformation","registerInfo.txt");
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		FileReader fr;
		try {
			fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String str = null;
			while((str = br.readLine()) != null){
				
				String[] result = str.split("  ");
				str = result[0];
				if(str.equals(name)){
					break;
				}
			}
			br.close();
			fr.close();
			if(str == null){
				FileWriter fw = new FileWriter(file,true);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(name+"  "+pwd);
				bw.newLine();
				
				bw.close();
				fw.close();
				RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/registerSuccess.jsp");
				rd.forward(request, response);
			}else{
				RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/registerFailed.jsp");
				rd.forward(request,response);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response){
		doGet(request,response);
		
	}
}
