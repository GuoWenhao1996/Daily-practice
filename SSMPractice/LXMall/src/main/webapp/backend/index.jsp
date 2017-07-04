<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	session.setAttribute("basePath", basePath);
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8"/>
    <title>乐鲜Mall后台丨首页</title>
    <meta name="author" content="DeathGhost"/>
    <link rel="shortcut icon" href="${basePath}backend/images/30-30.ico"/>
</head>
<body>
<div style="text-align: center;">
	<p style="font-size: xx-large">欢迎你~ 勤劳的管理员！</p>
</div>
<div style="text-align: center;">
	<img src="${basePath }backend/images/biglog.png" style="width: 350px; height: 350px;">
</div>

</body>
</html>