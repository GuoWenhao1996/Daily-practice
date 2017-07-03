<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	session.setAttribute("basePath", basePath);
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>乐鲜Mall商城 | 购物车</title>
<link rel="stylesheet" type="text/css"
	href="${basePath }frontend/css/style-cart.css">
<link rel="stylesheet" type="text/css"
	href="${basePath }frontend/css/css-cart.css" />
<script type="text/javascript"
	src="${basePath }frontend/js/jquery-1.7.2.min.js"></script>

<script type="text/javascript">
	$(function() {
		
		var region = $("#region");
		var address = $("#address");
		var number_this = $("#number_this");
		var name = $("#name_");
		var phone = $("#phone");
		$("#sub_setID").click(function() {
			var input_out = $(".input_style");
			for (var i = 0; i <= input_out.length; i++) {
				if ($(input_out[i]).val() == "") {
					$(input_out[i]).css("border", "1px solid red");

					return false;
				} else {
					$(input_out[i]).css("border", "1px solid #cccccc");
				}
			}
		});
		var span_momey = $(".span_momey");
		var b = 0;
		for (var i = 0; i < span_momey.length; i++) {
			b += parseFloat($(span_momey[i]).html());
		}
		var out_momey = $(".out_momey");
		out_momey.html(b);
		$(".shade_content").hide();
		$(".shade").hide();
		$('.nav_mini ul li').hover(function() {
			$(this).find('.two_nav').show(100);
		}, function() {
			$(this).find('.two_nav').hide(100);
		})
		$('.left_nav').hover(function() {
			$(this).find('.nav_mini').show(100);
		}, function() {
			$(this).find('.nav_mini').hide(100);
		})
		$('#jia').click(function() {
			$('input[name=num]').val(parseInt($('input[name=num]').val()) + 1);
		})
		$('#jian').click(function() {
			$('input[name=num]').val(parseInt($('input[name=num]').val()) - 1);
		})
		$('.Caddress .add_mi').click(
				function() {
					$("#totalMoney").removeAttr("disabled");
					$(this).css('background',
							'url("${basePath }frontend/images/mail_1.jpg") no-repeat').siblings(
							'.add_mi').css('background',
							'url("${basePath }frontend/images/mail.jpg") no-repeat');
					//预存选定的收货地址编号
					//发送AJAX请求
					$.post("${basePath }order/csavenumber.do", {cnumber:$(this).attr("id")}, function (data) {
						alert(data.content);
					}, "json"); 
				})
	})
	var x = Array();

	function func(a, b) {
		x[b] = a.html();
		alert(x)
		a.css('border', '2px solid #f00').siblings('.min_mx').css('border',
				'2px solid #ccc');
	}

	function onclick_close() {
		var shade_content = $(".shade_content");
		var shade = $(".shade");
		if (confirm("确认关闭么！此操作不可恢复")) {
			shade_content.hide();
			shade.hide();
		}
	}

	function onclick_open() {
		$(".shade_content").show();
		$(".shade").show();
		var input_out = $(".input_style");
		for (var i = 0; i <= input_out.length; i++) {
			if ($(input_out[i]).val() != "") {
				$(input_out[i]).val("");
			}
		}
	}

	function onclick_remove(r) {
		if (confirm("确认删除么！此操作不可恢复")) {
			var out_momey = $(".out_momey");
			var input_val = $(r).parent().prev().children().eq(1).val();
			var span_html = $(r).parent().prev().prev().children().html();
			var out_add = parseFloat(input_val).toFixed(2)
					* parseFloat(span_html).toFixed(2);
			var reduce = parseFloat(out_momey.html()).toFixed(2)
					- parseFloat(out_add).toFixed(2);
			console.log(parseFloat(reduce).toFixed(2));
			out_momey.text(parseFloat(reduce).toFixed(2))
			$(r).parent().parent().remove();
			window.location.href = "${basePath }shoppingcart/deleteshoppingcartgoods.do?goods.gnumber="+r.name;
		}
	}

	function onclick_btnAdd(a) {
		var out_momey = $(".out_momey");
		var input_ = $(a).prev();
		var input_val = $(a).prev().val();
		var input_add = parseInt(input_val) + 1;
		input_.val(input_add);
		var btn_momey = parseFloat($(a).parent().prev().children().html());
		var out_momey_float = parseFloat(out_momey.html()) + btn_momey;
		out_momey.text(out_momey_float.toFixed(2));
		
	}

	function onclick_reduce(b) {
		var out_momey = $(".out_momey");
		var input_ = $(b).next();
		var input_val = $(b).next().val();
		if (input_val <= 1) {
			alert("商品个数不能小于1！")
		} else {
			var input_add = parseInt(input_val) - 1;
			input_.val(input_add);
			var btn_momey = parseFloat($(b).parent().prev().children().html());
			var out_momey_float = parseFloat(out_momey.html()) - btn_momey;
			out_momey.text(out_momey_float.toFixed(2));
		}
	}

	/* 选中之前的地址 */
	function SelectAddress() {
		if("${selectaddress}"!=null&&"${selectaddress}"!="") {
			document.getElementById("${selectaddress}").click();
		}
	}
	
</script>

<script>
    	$(function() { //$("#name")表示找到id为name的控件
			$("#totalMoney").mouseenter(function() {
				//把总价给隐藏的input
				//发送AJAX请求
				$("#myordermoney").attr("value", $("#spanmoney").html());
				//验证是否点了收货地址
				//发送AJAX请求
				$.post("${basePath }order/isselect.do", {gnumber:$("#gnumber").attr("id")}, function (data) {
					if(data=="0") {
						alert("请先选择收货地址！");
					} else if(data=="00") {
						alert("您还没有购买任何商品！");
						$("#totalMoney").attr("disabled", "disabled");
					}
				}, "json"); //鼠标经过的时候
			});
		})
    </script>

</head>

<body onload="SelectAddress()">

	<!-- 地址栏 -->
	<div class="Caddress">
		<div class="open_new">
			<button class="open_btn" onclick="javascript:onclick_open();">使用新地址</button>
		</div>
		<c:forEach items="${consigeneelist }" var="cl">

			<div id="${cl.cnumber}" class="add_mi">
				<p style="border-bottom: 1px dashed #ccc; line-height: 28px;">${cl.cname }</p>
				<p style="border-bottom: 1px dashed #ccc; line-height: 28px;">${cl.ctelephone }</p>
				<p style="border-bottom: 1px dashed #ccc; line-height: 28px;">${cl.address }</p>
				<br>
				<p>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a name="${cl.cnumber}" href="javascript:void(0)"
						onclick="javascript:onclick_open();">修改</a>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a
						href="${basePath }shoppingcart/deleteconsigenee.do?cnumber=${cl.cnumber}">删除</a>
				</p>
			</div>

		</c:forEach>
	</div>

	<!--订单栏-->
	<div class="shopping_content">
		<form action="${basePath }order/add.do" method="post">
		<div class="shopping_table">
			<table border="1" bordercolor="#cccccc" cellspacing="0"
				cellpadding="0" style="width: 100%; text-align: center;">
				<tr>
					<th>商品图片</th>
					<th>商品名称</th>
					<th>商品属性</th>
					<th>商品价格</th>
					<th>商品数量</th>
					<th>商品操作</th>
				</tr>
				<c:forEach items="${shoppingcartgoods }" var="scg">
					<tr style="height: 50px">
						<td><a><img src="images/2f1.jpg" /></a></td>
						<td>
						    <!-- 商品编号 -->
							<input id="gnumber" type="hidden" name="gnumber" value="${scg.goods.gnumber }" />
							<!-- 购买时候的单价 -->
							<input type="hidden" name="gprice" value="${scg.goods.gprice }" />
							
						<span>${scg.goods.gname }</span>
						</td>
						<td>
							<div class="">
								<span id="">${scg.goods.gsort }</span>
							</div>
						</td>
						<td><span class="span_momey">${scg.goods.gprice }</span></td>
						<td>
							<button class="btn_reduce" type="button" onclick="javascript:onclick_reduce(this);">-</button>
								<input class="momey_input" readonly="readonly" name="number" id="number" value="${scg.number }"/>
							<button class="btn_add" type="button" onclick="javascript:onclick_btnAdd(this);">+</button>
						</td>
						<td>
							<button class="btn_r" name="${scg.goods.gnumber }"
								onclick="javascript:onclick_remove(this);">删除</button>
						</td>
					</tr>
				</c:forEach>
			</table>
			<div class="" style="width: 100%; text-align: right; margin-top: 2%;">
				<div class="div_outMumey" style="float: left;">
					总价：<span id="spanmoney" class="out_momey">11</span>
					<input id="myordermoney" type="hidden" name="orderMoney" value="">
				</div>
				<button id="totalMoney" class="btn_closing" type="submit">结算</button>
			</div>
		</div>
		</form>
	</div>

	<!--新增地址-->
	<div class="shade_content">
		<div class="col-xs-12 shade_colse">
			<button onclick="javascript:onclick_close();">x</button>
		</div>
		<div class="nav shade_content_div">
			<div class="col-xs-12 shade_title">新增收货地址</div>
			<div class="col-xs-12 shade_from">
				<form action="${basePath }shoppingcart/addconsigenee.do" method="post">
					<div class="col-xs-12">
						<span class="span_style" class="span_sty" id="">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名</span>
						<input class="input_style" type="" name="cname" id="name_" value=""
							placeholder="&nbsp;&nbsp;请输入您的姓名" />
					</div>
					<div class="col-xs-12">
						<span class="span_style" id="">手机号码</span> <input
							class="input_style" type="" name="ctelephone" id="phone" value=""
							placeholder="&nbsp;&nbsp;请输入您的手机号码" />
					</div>
					<div class="col-xs-12">
						<span class="span_style" id="">收货地址</span> <input
							class="input_style" type="" name="address" id="address" value=""
							placeholder="&nbsp;&nbsp;请输入您的详细地址" />
					</div>
					<div class="col-xs-12">
						<input class="btn_remove" type="button" id="" onclick="javascript:onclick_close();" value="取消" />
						<input type="submit" class="sub_set" id="sub_setID" value="提交" />
					</div>
				</form>
			</div>
		</div>
	</div>
</body>

</html>