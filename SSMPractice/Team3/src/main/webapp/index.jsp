<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	session.setAttribute("basePath", basePath);
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="pg" uri="http://jsptags.com/tags/navigation/pager"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
</head>
<body>
	<h3>添加学生</h3>
	<a href="${basePath}student/loadadd.do">添加学生</a>

	<h3>
		<a href="${basePath}student/list.do">学生信息</a>
	</h3>
	<form action="${basePath}student/list.do" method="post">
		<input type="" placeholder="请输入姓名" name="name"> 班级 <select
			name="clazz.id">
			<option value="0">---------------</option>
			<c:forEach items="${clazzes}" var="c">
				<option value="${c.id}">${c.name}</option>
			</c:forEach>
		</select>
		<button type="submit">查询</button>
	</form>
	<table>
		<tr>
			<th>编号</th>
			<th>姓名</th>
			<th>密码</th>
			<th>班级</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${students}" var="s">
			<tr>
				<td>${s.id}</td>
				<td><img src="${s.url}" style="width: 100px; height: 150px">${s.name}</td>
				<td>${s.password}</td>
				<td>${s.clazz.name}</td>
				<td><a href="${basePath}student/loadupdate.do?id=${s.id}">修改</a>
					<a href="${basePath}student/delete.do?id=${s.id}">删除</a></td>
			</tr>
		</c:forEach>
	</table>
	<pg:pager items="${total}" maxIndexPages="3" maxPageItems="2"
		url="${basePath}student/list.do" scope="request">
		<pg:param name="name" value="${studentnamequery}" />
		<pg:param name="clazz.id" value="${studentclazzidquery}" />
		<jsp:include page="res/pager_tag.jsp"></jsp:include>
	</pg:pager>

</body>
</html>