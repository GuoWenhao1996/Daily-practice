<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	session.setAttribute("basePath", basePath);
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>增加学生</title>
</head>
<body>
	<h3>增加学生</h3>
	<form action="${basePath}student/add.do" method="post">
		姓名：<input type="text" name="name" id="name"><span id="nameerr" style="color: red"></span><br> 
		密码：<input type="password" name="password"><br>
		班级：
		<select name="clazz.id">
			<c:forEach items="${clazzes}" var="c">
				<option value="${c.id}">${c.name}</option>
			</c:forEach>
		</select><br>
		<button type="submit">添加</button>
	</form>
	<script type="text/javascript" src="${basePath}res/js/jquery.min.js"></script>
	<script type="text/javascript">
		$(function() {
			$("#name").blur(function() {
				//console.log("blur");
				$.post("${basePath}student/validate.do",{name:$(this).val()},function(data){
					//$("#nameerr").html(data);
					console.log(data);
					$("#nameerr").html(data.content);
				},"json")
			});
		})
	</script>
</body>
</html>