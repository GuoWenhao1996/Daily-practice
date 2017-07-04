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
<!doctype html>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>乐鲜Mall商城 | 我的订单</title>
<link rel="shortcut icon" href="${basePath}frontend/images/30-30.ico"/>
<!--[if IE]>
    <!--[if IE 7]><link rel="stylesheet" type="text/css" href="css/ie7.css">
<![endif]-->
<link rel="stylesheet" type="text/css"
	href="${basePath }frontend/css/jiazaitoubu.css">
<link rel="stylesheet" type="text/css"
	href="${basePath }frontend/css/css.css">
<script src="${basePath }frontend/js/jquery-1.8.3.min.js"></script>
<script src="${basePath }frontend/js/index2.js"></script>
<link rel="stylesheet" type="text/css"
	href="${basePath }frontend/css/center.css">
<!--城市联动-->
<link rel="stylesheet" type="text/css"
	href="${basePath }frontend/city/city.css">
<script src="${basePath }frontend/city/Popt.js"></script>
<script src="${basePath }frontend/city/cityJson.js"></script>
<script src="${basePath }frontend/city/citySet.js"></script>

<link rel="shortcut icon"
	href="${basePath }frontend/images/web_title.png">
<link href="${basePath }frontend/css/bootstrap.css" rel="stylesheet"
	type="text/css" media="all" />
<!--theme-style-->
<link href="${basePath }frontend/css/style.css" rel="stylesheet"
	type="text/css" media="all" />
<!--//theme-style-->
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<script type="application/x-javascript">
	
	
	
	
	
	 addEventListener("load", function () {
        setTimeout(hideURLbar, 0);
    }, false);
    function hideURLbar() {
        window.scrollTo(0, 1);
    } 





</script>
<!--fonts-->
<!--<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>-->
<!--//fonts-->
<script src="${basePath }frontend/js/jquery.min.js"></script>
<!--script-->
</head>
<body>

	<script>
		window.onload = function() {
			$(".aside").css({
				display : "none"
			})
			$(".important").mouseenter(function() {
				$(".aside").css({
					display : "block"
				})
			}).mouseleave(function() {
				$(".aside").css({
					display : "none"
				})
			})
		}
	</script>
	<!--当前位置-->
	<div class="now_positionm">
		<span>当前位置：</span><a href="${basePath }frontend/index.jsp">首页></a><a
			href="#">个人账户</a>
	</div>
	<!--centers-->
	<div class="centers_m">
		<!--清除浮动-->
		<div class="clear_sm"></div>
		<!--left-->
		<div class="centers_ml">
			<!--头像-->
			<div class="center_header">
				<a href="#"><img
					src="${basePath }frontend/images/66f625e1ecfd7ad8244efabaa744aa73.png" /></a>
				<em>您好，<font>user</font></em>
			</div>
			<!--列表go-->
			<div class="centers_listm">
				<div class="centers_listm_one">
					<img src="images/zshy.png" /> <em>会员中心</em>
				</div>
				<!--一条开始-->
				<div class="centers_listm_one_in">
					<img src="images/shezhi.png" /> <em>资料管理</em> <b></b>
				</div>
				<span class="gjszmdm"> <a
					href="${basePath }frontend/user_center.jsp" class="center_in_self"><font>信息资料</font></a>
				</span>
				<!--一条开始-->
				<div class="centers_listm_one_in">
					<img src="${basePath }frontend/images/ddgl.png" /> <em>订单管理</em> <b></b>
				</div>
				<span class="gjszmdm"> <a
					href="${basePath}order/oneuserlist.do" class="center_in_self"><font>我的订单</font></a>
				</span>
				<!--一条开始-->
				<div class="centers_listm_one_in">
					<img src="${basePath }frontend/images/suo.png" /> <em>账户安全</em> <b></b>
				</div>
				<span class="gjszmdm"> <a
					href="${basePath }frontend/user_updatapassword.jsp"
					class="center_in_self"><font>修改密码</font></a>
				</span>
			</div>
			<script type="text/javascript">
				$(function() {//第一步都得写这个
					$(".centers_listm_one_in").click(
							function() {
								$(this).next(".gjszmdm").slideToggle()
										.siblings("gjszmdm").slideUp()
							});
				})
			</script>
		</div>
		<!--right-->
		<div class="centers_mr">
			<h1 class="welcom_tm">
				欢迎您，普通会员 <font>admin</font>！您上次登录时间为 2016-10-28 14:23
			</h1>

			<!--占空隙-->
			<div class="whatfuck_m"></div>
			<div class="public_m1">
				<div class="public_m2">我的订单</div>
				<form action="${basePath}order/oneuserlist.do" method="post">
					<div align="right">
						<select class="select" name="orderStatus">
							<option value="">订单状态</option>
							<option value="0">待付款</option>
							<option value="1">配货中</option>
							<option value="2">已出货</option>
							<option value="3">已签收</option>
							<option value="4">待评价</option>
							<option value="5">已完成</option>
							<option value="9">已取消</option>
						</select> <input type="submit" value="查询" />
					</div>
					<!--个订单信息-->
					<div class="public_m5">
						<table border="0" cellspacing="0" cellpadding="0">
							<tbody>
								<tr style="border-bottom: 1px solid #000">
									<th  width="40%" class="olist1">订单号</th>
									<th  width="15%" class="olist4">下单日期</th>
									<th  width="20%" class="olist4">订单总额</th>
									<th  width="10%" class="olist4">订单状态</th>
									<th  width="15%" class="olist4"></th>
								</tr>
								<c:forEach items="${orders}" var="o">
									<tr>
										<td><a href="${basePath}pregoods/oneuserlist.do?orderId=${o.orderId}">${o.orderId}</a></td>
										<td>${o.orderTime}</td>
										<td>${o.orderMoney}</td>
										<td><font class="jdqbsys_m">${o.orderStatus}</font></td>
										<td><a href="${basePath}pregoods/oneuserlist.do?orderId=${o.orderId}">详情</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<pg:pager items="${total}" maxIndexPages="3" maxPageItems="10"
						url="${basePath}order/oneuserlist.do" scope="request">
						<pg:param name="orderStatus" value="${orderStatusquery}" />
						<pg:param name="orderId" value="${orderIdquery}" />
						<pg:param name="user.id" value="${useridquery}" />
						<jsp:include page="res/pager_tag.jsp"></jsp:include>
					</pg:pager>
				</form>
			</div>
		</div>
	</div>

</body>
</html>



































































