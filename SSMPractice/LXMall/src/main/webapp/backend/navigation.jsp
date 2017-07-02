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
	<base href="<%=basePath%>">
    <meta charset="utf-8"/>
    <title>乐鲜Mall后台丨首页</title>
    <meta name="author" content="DeathGhost"/>
    <link rel="stylesheet" type="text/css" href="${basePath}backend/css/style.css">
    <!--[if lt IE 9]>
    <script src="${basePath}js/html5.js"></script>
    <![endif]-->
    <script src="${basePath}backend/js/jquery.js"></script>
    <script src="${basePath}backend/js/jquery.mCustomScrollbar.concat.min.js"></script>
    <script>
        (function ($) {
            $(window).load(function () {
                $("a[rel='load-content']").click(function (e) {
                    e.preventDefault();
                    var url = $(this).attr("href");
                    $.get(url, function (data) {
                        $(".content .mCSB_container").append(data); //load new content inside .mCSB_container
                        //scroll-to appended content
                        $(".content").mCustomScrollbar("scrollTo", "h2:last");
                    });
                });

                $(".content").delegate("a[href='top']", "click", function (e) {
                    e.preventDefault();
                    $(".content").mCustomScrollbar("scrollTo", $(this).attr("href"));
                });
            });
        })(jQuery);
    </script>
    
<script type="text/javascript">
	function changeClass(e) {
		var leader = document.getElementsByName("lead");
		for (i = 0; i < leader.length; i++) {
			if (leader[i].className == "active") {
				leader[i].className = "";
			}
		}
		e.className = "active";
	}
</script>
</head>
<body>
<!--header-->
<header>
    <h1><img src="${basePath}backend/images/admin_logo.png"/></h1>
    <ul class="rt_nav">
        <li><a href="http://www.mycodes.net" target="_blank" class="website_icon">站点首页</a></li>
        <li><a href="#" class="clear_icon">清除缓存</a></li>
        <li><a href="#" class="admin_icon">DeathGhost</a></li>
        <li><a href="#" class="set_icon">账号设置</a></li>
        <li><a href="${basePath}backend/login.jsp" class="quit_icon">安全退出</a></li>
    </ul>
</header>
<!--aside nav-->
<!--aside nav-->
<aside class="lt_aside_nav content mCustomScrollbar">
    <h2><a href="${basePath}backend/index.jsp" target="mainframe">首页</a></h2>
    <ul>
        <li>
            <dl>
                <dt>商品管理</dt>
                <!--当前链接则添加class:active-->
                <dd><a href="${basePath }goods/Adminlist.do" name="lead" target="mainframe" onclick="javascript:changeClass(this)">商品列表</a></dd>
                <dd><a href="${basePath}backend/product_add.jsp" name="lead" target="mainframe" onclick="javascript:changeClass(this)">添加商品</a></dd>
            </dl>
        </li>
        <li>
            <dl>
                <dt>订单信息</dt>
                <dd><a href="${basePath}order/list.do" name="lead" target="mainframe" onclick="javascript:changeClass(this)">订单管理</a></dd>
            </dl>
        </li>
        <li>
            <dl>
                <dt>会员管理</dt>
                <dd><a href="${basePath}backend/user_list.jsp" name="lead" target="mainframe" onclick="javascript:changeClass(this)">会员列表</a></dd>
                <dd><a href="${basePath}backend/user_detail.jsp" name="lead" target="mainframe" onclick="javascript:changeClass(this)">添加会员</a></dd>
            </dl>
        </li>
        <li>
            <dl>
                <dt>基础设置</dt>
                <dd><a href="${basePath}backend/setting.jsp" name="lead" target="mainframe" onclick="javascript:changeClass(this)">站点基础设置</a></dd>
            </dl>
        </li>
        <li>
            <dl>
                <dt>配送与支付设置</dt>
                <dd><a href="${basePath}backend/express_list.jsp" name="lead" target="mainframe" onclick="javascript:changeClass(this)">配送方式</a></dd>
                <dd><a href="${basePath}backend/pay_list.jsp" name="lead" target="mainframe" onclick="javascript:changeClass(this)">支付方式</a></dd>
            </dl>
        </li>
        <li>
            <dl>
                <dt>在线统计</dt>
                <dd><a href="${basePath}backend/discharge_statistic.jsp" name="lead" target="mainframe" onclick="javascript:changeClass(this)">数据统计</a></dd>
                <dd><a href="${basePath}backend/sales_volume.jsp" name="lead" target="mainframe" onclick="javascript:changeClass(this)">销售额统计</a></dd>
            </dl>
        </li>
        <li>
            <p class="btm_infor">© 乐鲜Mall 版权所有</p>
        </li>
    </ul>
</aside>

<style>
    .dataStatistic {
        width: 400px;
        height: 200px;
        border: 1px solid #ccc;
        margin: 0 auto;
        margin: 10px;
        overflow: hidden
    }

    #cylindrical {
        width: 400px;
        height: 200px;
        margin-top: -15px
    }

    #line {
        width: 400px;
        height: 200px;
        margin-top: -15px
    }

    #pie {
        width: 400px;
        height: 200px;
        margin-top: -15px
    }
</style>
<iframe src="${basePath}backend/index.jsp" width="100%" height="100%" id="mainframe" name="mainframe"></iframe>
<script src="${basePath}js/amcharts.js" type="text/javascript"></script>
<script src="${basePath}js/serial.js" type="text/javascript"></script>
<script src="${basePath}js/pie.js" type="text/javascript"></script>

</body>
</html>