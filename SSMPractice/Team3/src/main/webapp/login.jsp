<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	session.setAttribute("basePath", basePath);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>登录</title>
</head>
<body>
	<h3>用户登录</h3>
	<form action="${basePath}student/login.do " method="post">
		<input type="text" name="name" placeholder="请输入账号"><br>
		<input type="password" name="password" placeholder="请输入密码"><br>
		<button type="submit">登录</button>
	</form>
</body>
</html>