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
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<!doctype html>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>乐鲜Mall商城 | 我的订单</title>
<!--[if IE]>
    <!--[if IE 7]><link rel="stylesheet" type="text/css" href="css/ie7.css">
<![endif]-->
<link rel="shortcut icon" href="${basePath}frontend/images/30-30.ico"/>
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
				$(
						function() {//第一步都得写这个
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
				<div class="public_m2">订单明细 >>>>>订单:${theOrder.orderId}</div>
				<div class="rt_content">
					<table class="table">
						<tr>
							<td>收件人：${theOrder.consigenee.cname}</td>
							<td>联系电话：${theOrder.consigenee.ctelephone}</td>
							<td>收件地址：${theOrder.consigenee.address}</td>
							<td>下单时间：${theOrder.orderTime}</td>
						</tr>
						<tr>
							<td>订单状态：<label id="label_status">${theOrder.orderStatus}</label></td>
							<td colspan="3">订单总额： <mark>${theOrder.orderMoney} 元</mark>
							</td>
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
								<td class="center"><strong class="rmb_icon"><fmt:formatNumber
											type="number"
											value="${Float.parseFloat(p.buyprice)*p.buynumber}"
											pattern="0" maxFractionDigits="2" /></strong></td>
								<td class="center">${p.goods.gsort}</td>
							</tr>
						</c:forEach>
					</table>
					<aside class="mtb" style="text-align: right;">
						<label id="yhcz">用户操作：</label> 
						<a id="qx_qq" onclick="quxiao()" style="color: red">取消订单</a>
						<a id="qx_cz" href = "${basePath}order/oneuserupdate.do?orderId=${theOrder.orderId}&orderStatus=9" class="public_m3" style="display: none">取消订单</a>
						<a href="${basePath}order/oneuserlist.do">返回</a>
					</aside>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		function quxiao() {
			var status = document.getElementById("label_status").innerHTML;
			if (status == "配货中" || status == "待付款") {
				var choose = confirm("确认取消？取消订单后不可恢复");
				if (choose == true) {
					alert("订单取消权限已开放，请慎重！");
					document.getElementById("qx_cz").style.display = "";
					document.getElementById("qx_qq").style.display = "none";
					document.getElementById("yhcz").style.display = "none";
				} else {
				}
			} else {
				alert("对不起，【"+status+"】状态下您不可取消此订单，请您谅解。");
			}
		}
	</script>
</body>
</html>



































































