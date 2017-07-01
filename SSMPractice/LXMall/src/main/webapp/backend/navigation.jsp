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
    <h2><a href="${basePath}index.jsp">首页</a></h2>
    <ul>
        <li>
            <dl>
                <dt>商品管理</dt>
                <!--当前链接则添加class:active-->
                <dd><a href="${basePath}backend/product_list.jsp" class="active" target="mainframe">商品列表</a></dd>
                <dd><a href="${basePath}backend/product_detail.jsp" target="mainframe">>商品详情</a></dd>
                <dd><a href="${basePath}backend/recycle_bin.jsp" target="mainframe">>商品回收站</a></dd>
            </dl>
        </li>
        <li>
            <dl>
                <dt>订单信息</dt>
                <dd><a href="${basePath}order/list.do" target="mainframe">>订单列表</a></dd>
                <dd><a href="${basePath}backend/order_detail.jsp" target="mainframe">>订单详情</a></dd>
            </dl>
        </li>
        <li>
            <dl>
                <dt>会员管理</dt>
                <dd><a href="${basePath}backend/user_list.jsp" target="mainframe">>会员列表</a></dd>
                <dd><a href="${basePath}backend/user_detail.jsp" target="mainframe">>添加会员</a></dd>
            </dl>
        </li>
        <li>
            <dl>
                <dt>基础设置</dt>
                <dd><a href="${basePath}backend/setting.jsp" target="mainframe">>站点基础设置</a></dd>
            </dl>
        </li>
        <li>
            <dl>
                <dt>配送与支付设置</dt>
                <dd><a href="${basePath}backend/express_list.jsp" target="mainframe">>配送方式</a></dd>
                <dd><a href="${basePath}backend/pay_list.jsp" target="mainframe">>支付方式</a></dd>
            </dl>
        </li>
        <li>
            <dl>
                <dt>在线统计</dt>
                <dd><a href="${basePath}backend/discharge_statistic.jsp" target="mainframe">>数据统计</a></dd>
                <dd><a href="${basePath}backend/sales_volume.jsp" target="mainframe">>销售额统计</a></dd>
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
<iframe src="${basePath}index.jsp" width="100%" height="100%" id="mainframe" name="mainframe"></iframe>
<script src="${basePath}js/amcharts.js" type="text/javascript"></script>
<script src="${basePath}js/serial.js" type="text/javascript"></script>
<script src="${basePath}js/pie.js" type="text/javascript"></script>

<script type="text/javascript">
    $(document).ready(function (e) {
        GetSerialChart();
        MakeChart(json);
    });
    var json = [
        {"name": "数据1", "value": "35"},
        {"name": "数据2", "value": "60"},
        {"name": "数据3", "value": "22"},
        {"name": "数据4", "value": "65"},
        {"name": "数据5", "value": "35"},
        {"name": "数据6", "value": "22"},
        {"name": "数据7", "value": "43"},
        {"name": "数据8", "value": "55"}
    ]
    //柱状图
    function GetSerialChart() {
        chart = new AmCharts.AmSerialChart();
        chart.dataProvider = json;
        //json数据的key
        chart.categoryField = "name";
        //不选择
        chart.rotate = false;
        //值越大柱状图面积越大
        chart.depth3D = 20;
        //柱子旋转角度角度
        chart.angle = 30;
        var mCtCategoryAxis = chart.categoryAxis;
        mCtCategoryAxis.axisColor = "#efefef";
        //背景颜色透明度
        mCtCategoryAxis.fillAlpha = 0.5;
        //背景边框线透明度
        mCtCategoryAxis.gridAlpha = 0;
        mCtCategoryAxis.fillColor = "#efefef";
        var valueAxis = new AmCharts.ValueAxis();
        //左边刻度线颜色
        valueAxis.axisColor = "#ccc";
        //标题
        valueAxis.title = "3D柱状图Demo";
        //刻度线透明度
        valueAxis.gridAlpha = 0.2;
        chart.addValueAxis(valueAxis);
        var graph = new AmCharts.AmGraph();
        graph.title = "value";
        graph.valueField = "value";
        graph.type = "column";
        //鼠标移入提示信息
        graph.balloonText = "测试数据[[category]] [[value]]";
        //边框透明度
        graph.lineAlpha = 0.3;
        //填充颜色
        graph.fillColors = "#b9121b";
        graph.fillAlphas = 1;

        chart.addGraph(graph);

        // CURSOR
        var chartCursor = new AmCharts.ChartCursor();
        chartCursor.cursorAlpha = 0;
        chartCursor.zoomable = false;
        chartCursor.categoryBalloonEnabled = false;
        chart.addChartCursor(chartCursor);

        chart.creditsPosition = "top-right";

        //显示在Main div中
        chart.write("cylindrical");
    }
    //折线图
    AmCharts.ready(function () {
        var chart = new AmCharts.AmSerialChart();
        chart.dataProvider = json;
        chart.categoryField = "name";
        chart.angle = 30;
        chart.depth3D = 20;
        //标题
        //chart.addTitle("3D折线图Demo", 15);
        var graph = new AmCharts.AmGraph();
        chart.addGraph(graph);
        graph.valueField = "value";
        //背景颜色透明度
        graph.fillAlphas = 0.3;
        //类型
        graph.type = "line";
        //圆角
        graph.bullet = "round";
        //线颜色
        graph.lineColor = "#8e3e1f";
        //提示信息
        graph.balloonText = "[[name]]: [[value]]";
        var categoryAxis = chart.categoryAxis;
        categoryAxis.autoGridCount = false;
        categoryAxis.gridCount = json.length;
        categoryAxis.gridPosition = "start";
        chart.write("line");
    });
    //饼图
    //根据json数据生成饼状图，并将饼状图显示到div中
    function MakeChart(value) {
        chartData = eval(value);
        //饼状图
        chart = new AmCharts.AmPieChart();
        chart.dataProvider = chartData;
        //标题数据
        chart.titleField = "name";
        //值数据
        chart.valueField = "value";
        //边框线颜色
        chart.outlineColor = "#fff";
        //边框线的透明度
        chart.outlineAlpha = .8;
        //边框线的狂宽度
        chart.outlineThickness = 1;
        chart.depth3D = 20;
        chart.angle = 30;
        chart.write("pie");
    }
</script>
</body>
</html>