<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>投票界面</title>
<script type="text/javascript">
	<%
	response.setHeader("Pragma","No-cache");
	response.setHeader("Cache-Control","No-cache"); 
	response.setDateHeader("Expires", -1); 
	response.setHeader("Cache-Control", "No-store"); 
	if(application.getAttribute("visitNumber") == null){
		application.setAttribute("visitNumber",1);
	}else{
		application.setAttribute("visitNumber", Integer.parseInt(application.getAttribute("visitNumber").toString())+1);
	}
		String visitNumber = application.getAttribute("visitNumber").toString();
	%>
</script>

</head>
<body>
	<div align = "center">
		<form action="voteProcess" method="post" name="vote" id="vote">
	    	<font color="red">欢迎来到投票界面，您是第<%= visitNumber %>位投票者</font><br/>
			请选择你喜欢的颜色<br/>
			<input type="radio" name="color" value="red"/>红色<br/>
			<input type="radio" name="color" value="green"/>绿色<br/>
			<input type="radio" name="color" value="blue" checked/>蓝色<br>
		
			<input type="submit" value="提交" />
		</form>
	</div>
</body>
</html>