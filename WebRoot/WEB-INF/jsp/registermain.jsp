<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<div align="center">

	<form action="RegisterInformationProcess" method="post" id="userRegister" name="userRegister">
		用户名<input type="text" id="txtName" name="txtName" value=""/><div id="divName" style="display:none;color:red">用户名必须以字母开头且不少于六位</div>
		                                                             <div id="divNameLogin" style="display:none;color:red">用户名错误</div><br/>
		密码<input type="password" id="txtPwd" name="txtPwd" value=""/><div id ="divPwd" style="display:none;color:red">密码为六位且必须同时包含字母，数字和下划线</div><br/>
																	  <div id="divPwdLogin" style="display:none;color:red">密码错误</div>
		<input type="button" value="登录" onclick="return loginCheck()"/>
		<input type="button"  value="注册" onClick="return registerCheck()"/>
	</form>
	</div>