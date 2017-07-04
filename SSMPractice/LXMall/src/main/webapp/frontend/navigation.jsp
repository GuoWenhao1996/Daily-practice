<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	session.setAttribute("basePath",basePath);
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <base href="<%=basePath%>">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>乐鲜Mall商城 | 首页</title>
    <link rel="shortcut icon" href="${basePath}frontend/images/30-30.ico"/>
    <link rel="stylesheet" type="text/css" href="${basePath }frontend/css/style-cart.css">
    <link rel="stylesheet" type="text/css" href="${basePath }frontend/css/css-cart.css"/>
    <script type="text/javascript" src="${basePath }frontend/js/jquery-1.7.2.min.js"></script>
    <script type="text/javascript">
        function setIframeHeight(iframe) {
            if (iframe) {
                var iframeWin = iframe.contentWindow || iframe.contentDocument.parentWindow;
                if (iframeWin.document.body) {
                    iframe.height = iframeWin.document.documentElement.scrollHeight || iframeWin.document.body.scrollHeight;
                }
            }
        };
        window.onload = function () {
            setIframeHeight(document.getElementById('mainframe'));
        };
        function getCookie() 
        { 
        	var arr,reg=new RegExp("(^| )"+"cookieNo"+"=([^;]*)(;|$)");
        	if(arr=document.cookie.match(reg)) 
        		return unescape(arr[2]); 
        	else
        		return null; 
        }

    </script>
    
    <script>
    	/* $(function() { //$("#name")表示找到id为name的控件
			$("#mycart").mouseenter(function() {
				//加入购物车
				//发送AJAX请求
				alert("1111111111");
				$.post("${basePath }shoppingcart/showusergoods.do", {id:$("#getuserid").val()}, function (data) {
					alert(data.content);
				}, "json")
			}); //失去焦点的时候
		}) */
    </script>
    
</head>
<body onload="check()">

<!--顶端头部-->
<div id="top">
    <div id="top_main">
        <ul class="topu">
            <li>
                <div class="xing">
                </div>
            </li>
        </ul>
        <div id="hello">
					<span>您好! <input id="getuserid" name="getuserid" type="hidden" value="11"> 欢迎来到&nbsp;&nbsp;乐鲜Mall商城！
			<a href="${basePath }frontend/login.jsp" target="mainframe">[登陆]</a>&nbsp;<a href="${basePath }frontend/register.jsp" target="mainframe">[免费注册]</a>
			</span>
        </div>
        <div class="topright">
            <ul>
                <li>
                    <div class="cun">
                        <a href="${basePath}order/oneuserlist.do" target="mainframe">我的订单</a>
                    </div>
                </li>
                <li class="kefu">
                    <div class="cun">
                        <div class="a1">
                            <div class="kefuhide">
                                <span>客户服务</span>
                                <div class="downjian1">
                                </div>
                                <ul>
                                    <li><a href="#">意见反馈</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </li>
                <li class="wangzhan">
                    <div class="cun">
                        <span>网站导航</span>
                        <div class="downjian1">
                        </div>
                    </div>
                    <div class="wangzhanhide">
                        <div class="tese">
                            <span>特色栏目</span>
                        </div>
                        <div class="tesemain">
                            <a href="${basePath }goods/index.do">首页</a>
                            <a href="${basePath }shoppingcart/usercartlist.do">购物车</a>
                            <a href="${basePath}order/oneuserlist.do">我的订单</a>
                        </div>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</div>

<!-- 搜索区域开始 -->
<div id="serach">
    <div class="logo">
        <a href="${basePath }goods/index.do" target="mainframe">
            <img src="${basePath }frontend/images/logo.png" alt=""/></a>
        <div class="dongtu">
        </div>
    </div>
    <div class="sou">
        <div class="sousuo">
            <input type="text" class="kuang" placeholder="请输入搜索条件" style="color:#999;font-size:14px"/>
            <div class="souzi">
                <a href="#">搜索</a>
            </div>
        </div>
        <div class="reci">
            <span>热门搜索:</span>
            <a href="${basePath }goods/list.do?gsort=新鲜水果" style="color:red">新鲜水果</a>
            <a href="${basePath }goods/list.do?gsort=新鲜水产">新鲜水产</a>
            <a href="${basePath }goods/list.do?gsort=新鲜蔬菜">新鲜蔬菜</a>
            <a href="${basePath }goods/list.do?gsort=肉类">肉类</a>
            <a href="${basePath }goods/list.do?gsort=休闲零食">休闲零食</a>
            <a href="${basePath }goods/list.do?gsort=饼干糕点">饼干糕点</a>
            <a href="${basePath }goods/list.do?gsort=茶叶">茶叶</a>
            <a href="${basePath }goods/list.do?gsort=乳品冲饮">乳品冲饮</a>
        </div>
    </div>
    <div class="myjd">
        <div class="mytu">
        </div>
        <a href="${basePath }user/getpersondata.do" target="mainframe">我的商城</a>
        <div class="jiantou"></div>
    </div>
    <div class="gouwuche">
        <div class="chetu"></div>
        	<a id="mycart" name="mycart" href="${basePath }shoppingcart/usercartlist.do" target="mainframe">去购物车结算</a>
        	<div class="jianleft"></div>
        <div class="num">
            <div class="numright"></div>
            <div class="numzi">
                <span>0</span>
            </div>
        </div>
    </div>
    <div class="jubao">
    </div>
</div>

<iframe src="${basePath }goods/index.do" width="100%" height="1200px" id="mainframe" name="mainframe"></iframe>

<!-- 底部开始 -->
<div id="down">
    <div class="down_top">
        <a href="#">关于我们</a>
        <a href="#">联系我们</a>
        <a href="#">商家入驻</a>
        <a href="#">营销中心</a>
        <a href="#">手机商城</a>
        <a href="#">友情链接</a>
        <a href="#">销售联盟</a>
        <a href="#">商城社区</a>
        <a href="#">商城公益</a>
        <a href="#" style="border-right:none">English Site</a>
    </div>
    <div class="down_center">
        <span>北京市公安局朝阳分局备案编号110105014669  |  京ICP证070359号  |  <a href="#">互联网药品信息服务资格证编号(京)-经营性-2014-0008</a>  |  新出发京零 字第大120007号</span>
        <span><a href="#">音像制品经营许可证苏宿批005号</a>  |  出版物经营许可证编号新出发(苏)批字第N-012号  |  互联网出版许可证编号新出网证(京)字150号</span>
        <span><a href="#">网络文化经营许可证京网文[2011]0168-061号</a>  违法和不良信息举报电话：4006561155  Copyright (c) 2004-2014  商城JD.com 版权所有</span>
        <span>商城旗下网站：<a href="#">360TOP</a><a href="#">拍拍网</a><a href="#">网银在线</a></span>
    </div>
    <div class="down_bot">
        <img src="${basePath }frontend/images/bot1.gif" alt=""/>
        <img src="${basePath }frontend/images/bot2.gif" alt=""/>
        <img src="${basePath }frontend/images/bot3.png" alt=""/>
        <img src="${basePath }frontend/images/bot4.png" alt=""/>
    </div>
</div>
<!-- 底部结束 -->

</body>
</html>