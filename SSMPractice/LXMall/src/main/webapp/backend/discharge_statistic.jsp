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
    <title>乐鲜Mall后台丨数据信息</title>
    <meta name="author" content="DeathGhost"/>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <!--[if lt IE 9]>
    <script src="js/html5.js"></script>
    <![endif]-->
    <script src="js/jquery.js"></script>
    <script src="js/jquery.mCustomScrollbar.concat.min.js"></script>
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

<section class="rt_wrap content mCustomScrollbar">
    <div class="rt_content">
        <div class="page_title">
            <h2 class="fl">数据信息统计</h2>
        </div>
        <div class="dataStatistic">
            <div id="line">
            </div>
        </div>
    </div>
</section>
<script src="js/amcharts.js" type="text/javascript"></script>
<script src="js/serial.js" type="text/javascript"></script>
<script src="js/pie.js" type="text/javascript"></script>
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

</script>
</body>
</html>