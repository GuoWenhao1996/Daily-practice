<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	session.setAttribute("basePath", basePath);
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<title>乐鲜Mall后台丨订单详情</title>
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
			<h2 class="fl">订单:${theOrder.orderId}</h2>
		</div>
		<table class="table">
			<tr>
				<td>收件人：${theOrder.consigenee.cname}</td>
				<td>联系电话：${theOrder.consigenee.ctelephone}</td>
				<td>收件地址：${theOrder.consigenee.address}</td>
				<td>下单时间：${theOrder.orderTime}</td>
			</tr>
			<tr>
				<td>订单状态： <select id="statuses" class="select"
					name="theOrder.orderStatus" onchange="changeA()">
						<option value="-1">---${theOrder.orderStatus}---</option>
						<option value="0">待付款</option>
						<option value="1">配货中</option>
						<option value="2">已出货</option>
						<option value="3">已签收</option>
						<option value="4">待评价</option>
						<option value="5">已完成</option>
						<option value="9">已取消</option>
				</select> <a id="thisa" href="" style="display: none">提交修改</a>
				</td>
				<td colspan="2">订单总额： <mark>${theOrder.orderMoney} 元</mark>
				</td>
				<td><a href="${basePath}order/list.do">返回</a></td>
			</tr>
		</table>
		<table class="table">
			<tr>
				<th class="center">图片</th>
				<th class="center">商品名</th>
				<th class="center">商品ID</th>
				<th class="center">购买时单价</th>
				<th class="center">购买数量</th>
				<th class="center">单项总价</th>
				<th class="center">商品类别</th>
			</tr>
			<c:forEach items="${pregoodses}" var="p">
				<tr>
					<td class="center"><img src="${p.buyid}" width="70"
						height="70" /></td>
					<td class="center">${p.goods.gname}</td>
					<td class="center">${p.goods.gnumber}</td>
					<td class="center"><strong class="rmb_icon">${p.buyprice}</strong></td>
					<td class="center"><strong>${p.buynumber}</strong></td>
					<td class="center"><strong class="rmb_icon"> <fmt:formatNumber
								type="number"
								value="${Float.parseFloat(p.buyprice)*p.buynumber}" pattern="0"
								maxFractionDigits="2" />
					</strong></td>
					<td class="center">${p.goods.gsort}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	</section>
	<script type="text/javascript"
		src="${basePath}backend/res/jquery.form.js"></script>
	<script type="text/javascript">
		function changeA() {
			$("#statuses").val();
			var url = "${basePath}order/update.do?orderId=${theOrder.orderId}&orderStatus="
					+ $("#statuses").val();
			$("#thisa").attr("href", url);
			if($("#statuses").val()=="-1"){
				document.getElementById("thisa").style.display = "none";
			}else{
				document.getElementById("thisa").style.display = "";
			}
				
		}
	</script>
</body>
</html>