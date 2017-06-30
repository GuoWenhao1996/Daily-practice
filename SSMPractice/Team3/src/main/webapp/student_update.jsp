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
	<form id="student_update_form" action="${basePath}student/update.do">
		编号：<input type="text" name="id" value="${student.id}" readonly="readonly"><br>
		姓名：<input type="text" name="name" value="${student.name}"><br>
		密码：<input type="password" name="password" value="${student.password}"><br>
		班级：
		<select name="clazz.id">
			<c:forEach items="${clazzes}" var="c">
				<option value="${c.id}" ${student.clazz.id==c.id?'selected':'' }>${c.name}</option>
			</c:forEach>
		</select><br>
		头像:<input type="file" name="file" onchange="uploadImg()"><br>
		<input type="hidden" name="url" id="imgurl">
		预览：<img id="pre" style="border:1px solid red;width:100px;height:150px;object-fit:contain" src="${student.url}"></img><br>
		<button type="submit">保存</button>
	</form>
	<script type="text/javascript" src="${basePath}res/js/jquery.min.js"></script>
	<script type="text/javascript" src="${basePath}res/js/jquery.form.js"></script>
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
		
		function uploadImg() {
			var options={
					url:"${basePath}student/upload.do?time="+Math.random(),
					dataType:"json",
					type:"post",
					success:function(str){
						console.log(str);
						$("#pre").attr("src",str);
						$("#imgurl").val(str);
					}
			};
			$("#student_update_form").ajaxSubmit(options);
		}
	</script>
</body>
</html>