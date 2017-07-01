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
    <title>乐鲜Mall后台丨登录</title>
    <meta name="author" content="DeathGhost"/>
    <link rel="stylesheet" type="text/css" href="${basePath}backend/css/style.css"/>
    <style>
        body {
            height: 100%;
            background: #16a085;
            overflow: hidden;
        }

        canvas {
            z-index: -1;
            position: absolute;
        }
    </style>
    <script src="${basePath}backend/js/jquery.js"></script>
    <script src="${basePath}backend/js/verificationNumbers.js"></script>
    <script src="${basePath}backend/js/Particleground.js"></script>
    <script>
        $(document).ready(function () {
            //粒子背景特效
            $('body').particleground({
                dotColor: '#5cbdaa',
                lineColor: '#5cbdaa'
            });
            //验证码
            createCode();
        });
    </script>
</head>
<body>
<dl class="admin_login">
    <dt>
        <strong>乐鲜Mall后台管理系统</strong>
        <em>Management System</em>
    </dt>
    <form action="${basePath}admin/login.do " method="post">
    <h2 color="red"><font color="red">${errormessage }</font></h2>
    <dd class="user_icon">
        <input type="text" name="account" placeholder="账号" required autofocus class="login_txtbx" class="input"/>
    </dd>
    <dd class="pwd_icon">
        <input type="password" name ="apassword"placeholder="密码" class="login_txtbx" required class="input"/>
    </dd>
    <dd class="val_icon">
        <div class="checkcode">
            <input type="text" id="J_codetext" placeholder="验证码" maxlength="4" class="login_txtbx" required class="input">
            <canvas class="J_codeimg" id="myCanvas" onclick="createCode()">对不起，您的浏览器不支持canvas，请下载最新版浏览器!</canvas>
        </div>
        <input type="button" value="验证码核验" class="ver_btn" onClick="validate();">
    </dd>
    <dd>
        <input type="submit" value="立即登录" class="submit_btn"/>
    </dd>
    </form>
    <dd>
        <p>© 乐鲜Mall商城 版权所有</p>
        <p>中软实训第三小组</p>
    </dd>
</dl>
</body>
</html>