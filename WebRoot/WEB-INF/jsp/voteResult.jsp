<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>投票结果</title>
<script type="text/javascript" src="resource/js/jquery-3.1.0.min.js"></script>
<script type="text/javascript" src="resource/js/jquery.cookie.js"></script>
<script type="text/javascript">

		<%
			HttpSession httpSession = request.getSession();
			int totalNumber =Integer.parseInt(httpSession.getAttribute("colorNumber").toString());
			
			int red = Integer.parseInt(httpSession.getAttribute("red").toString());
			int green = Integer.parseInt(httpSession.getAttribute("green").toString());
			int blue = Integer.parseInt(httpSession.getAttribute("blue").toString());
			
			String redper = Math.round(((double)red/totalNumber)*100)+"%";
			String greenper = Math.round(((double)green/totalNumber)*100)+"%";
			String blueper = Math.round(((double)blue/totalNumber)*100)+"%";
	   %>

	

	
</script>
</head>
<body>
	<p> 投票结果</p>
	
	红色：<progress id="redpro" value=red max=totalNumber></progress> 
	<div id="redDiv"><%=redper %></div>
	绿色：<progress id="greenpro" value=green max=totalNumber></progress>
	<div id="whiteDiv"><%=greenper %></div>
	蓝色：<progress id="bluepro" value=blue max=totalNumber></progress>
	<div id="blueDiv"><%=blueper %></div>
</body>
</html>