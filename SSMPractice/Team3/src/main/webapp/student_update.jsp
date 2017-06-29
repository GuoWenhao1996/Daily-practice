<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	session.setAttribute("basePath",basePath);
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改学生信息</title>
</head>
<body>
	<h3>修改学生信息</h3>
	<form action="${basePath}student/update.do">
		编号：<input type="text" name="id" value="${student.id}" readonly="readonly"><br>
		姓名：<input type="text" name="name" value="${student.name}"><br>
		密码：<input type="password" name="password" value="${student.password}"><br>
		班级：
		<select name="clazz.id">
			<c:forEach items="${clazzes}" var="c">
				<option value="${c.id}" ${student.clazz.id==c.id?'selected':'' }>${c.name}</option>
			</c:forEach>
		</select>
		<button type="submit">保存</button>
	</form>
</body>
</html>