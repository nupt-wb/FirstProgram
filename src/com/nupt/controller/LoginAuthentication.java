package com.nupt.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginProcess")
public class LoginAuthentication extends HttpServlet {
	protected void doGet(HttpServletRequest request,HttpServletResponse response){
		String name = request.getParameter("txtName");
		String pwd = request.getParameter("txtPwd");

		
		File file = new File("E:/file/userInformation","registerInfo.txt");
		//如果文件存在，进行读取并验证用户名和密码的一致性
		if(file.exists()){
			
			
			try {
				FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);
				String str = null;
				while((str = br.readLine()) != null){
					String[] result = str.split("  ");

					if(name.equals(result[0])){
						if(pwd.equals(result[1])){
							//跳转到投票界面
							Cookie cookieName = new Cookie("name",name);
							Cookie cookiePwd = new Cookie("pwd",pwd);
							
							cookieName.setMaxAge(60*30);
							cookieName.setDomain("localhost");
							cookieName.setPath("/");
							cookiePwd.setMaxAge(60*30);
							cookiePwd.setDomain("localhost");
							cookiePwd.setPath("/");
							
							response.addCookie(cookieName);
							response.addCookie(cookiePwd);
							

							
							RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/vote.jsp");
							rd.forward(request, response);
							break;
						}								
					}
				}
				if(str == null){
					//显示提示信息，3秒后自动跳转到登录界面
					RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/loginError.jsp");
					rd.forward(request, response);
				
				}
				
				
				br.close();
				fr.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else{
			System.out.println("************");
		}
		



		
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response){
		doGet(request,response);
	}
}
