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
<meta charset="utf-8" />
<title>乐鲜Mall后台丨订单列表</title>
<meta name="author" content="DeathGhost" />
<link rel="stylesheet" type="text/css"
	href="${basePath}backend/css/style.css">
<!--[if lt IE 9]>
    <script src="js/html5.js"></script>
    <![endif]-->
<script src="${basePath}backend/js/jquery.js"></script>
<script
	src="${basePath}backend/js/jquery.mCustomScrollbar.concat.min.js"></script>
<script>
	(function($) {
		$(window).load(
				function() {

					$("a[rel='load-content']").click(
							function(e) {
								e.preventDefault();
								var url = $(this).attr("href");
								$.get(url, function(data) {
									$(".content .mCSB_container").append(data); //load new content inside .mCSB_container
									//scroll-to appended content
									$(".content").mCustomScrollbar("scrollTo",
											"h2:last");
								});
							});

					$(".content").delegate(
							"a[href='top']",
							"click",
							function(e) {
								e.preventDefault();
								$(".content").mCustomScrollbar("scrollTo",
										$(this).attr("href"));
							});

				});
	})(jQuery);
</script>
</head>
<body>

	<section class="rt_wrap content mCustomScrollbar">
	<div class="rt_content">
		<div class="page_title">
			<h2 class="fl">订单列表</h2>
		</div>
		<form action="${basePath}order/list.do" method="post">
			<section class="mtb"> <select class="select"
				name="orderStatus">
				<option value="">订单状态</option>
				<option value="0">待付款</option>
				<option value="1">配货中</option>
				<option value="2">已出货</option>
				<option value="3">已签收</option>
				<option value="4">待评价</option>
				<option value="5">已完成</option>
				<option value="9">已取消</option>
			</select> <input type="text" name="orderId" class="textbox textbox_50"
				placeholder="输入订单编号" /> <input type="text" name="user.id"
				class="textbox textbox_50" placeholder="输入用户账号" /> <input
				type="submit" value="查询" class="group_btn" /> </section>
			<table class="table">
				<tr>
					<th>订单编号</th>
					<th>用户账号</th>
					<th>收件人</th>
					<th>联系电话</th>
					<th>收件人地址</th>
					<th>下单日期</th>
					<th>订单状态</th>
					<th>订单总额</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${orders}" var="o">
					<tr>
						<th>${o.orderId}</th>
						<th>${o.user.id}</th>
						<th>${o.consigenee.cname}</th>
						<th>${o.consigenee.ctelephone}</th>
						<th>${o.consigenee.address}</th>
						<th>${o.orderTime}</th>
						<th>${o.orderStatus}</th>
						<th>${o.orderMoney}</th>
						<td class="center"><a href="#" title="查看订单" class="link_icon"
							target="_blank">&#118;</a> <a href="#" title="修改订单"
							class="link_icon">&#101;</a></td>
					</tr>
				</c:forEach>
			</table>
			<aside class="paging"> 
				<pg:pager items="${total}" maxIndexPages="3" maxPageItems="10" url="${basePath}order/list.do" scope="request">
 					<pg:param name="orderStatus" value="${orderStatusquery}" />
 					<pg:param name="orderId" value="${orderIdquery}" />
					<pg:param name="user.id" value="${useridquery}" />
					<jsp:include page="res/pager_tag.jsp"></jsp:include>
				</pg:pager> 
			</aside>
		</form>
	</div>
	</section>
</body>
</html>