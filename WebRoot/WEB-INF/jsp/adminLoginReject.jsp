<%@page import="java.util.ArrayList"%>
<%@page import="java.io.File"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.FileReader"%>
<%@page import="com.nupt.controller.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员不允许登陆投票</title>

</head>
<body>

		<table border="1">
			<tr>
				<th>编号</th>
				<th>用户名</th>
				<th>密码</th>
			</tr>
			
				<%
				
				
				
				try {
					int id = 1;
					File file = new File("E:/file/userInformation/registerInfo.txt");
					FileReader fr = new FileReader(file);
					BufferedReader br = new BufferedReader(fr);
					String str = null;
					while((str = br.readLine()) != null){
						String[] result = str.split("  ");	%>
							<tr>	 
			
		  						<td><%=id++ %></td>
		 					
					<% 
						for(int i =0; i<result.length;i++){%>
								<td><%=result[i] %></td>
					<% 
						}
					%>
					     </tr>
					<%
					}
					br.close();
					fr.close();
				}catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	
				%>
				
	

		
		
			
			
		</table>
</body>
</html>