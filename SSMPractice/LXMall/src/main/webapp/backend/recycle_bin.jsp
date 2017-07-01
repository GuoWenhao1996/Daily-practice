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
    <title>乐鲜Mall后台丨产品回收站</title>
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
            <h2 class="fl">产品回收站</h2>
            <a class="fr top_rt_btn">返回上一页</a>
        </div>
        <section class="mtb">
            <select class="select">
                <option>下拉菜单</option>
                <option>菜单1</option>
            </select>
            <input type="text" class="textbox textbox_225" placeholder="输入产品关键词或产品货号..."/>
            <input type="button" value="查询" class="group_btn"/>
        </section>
        <table class="table">
            <tr>
                <th>缩略图</th>
                <th>产品名称</th>
                <th>货号</th>
                <th>单价</th>
                <th>单位</th>
                <th>精品</th>
                <th>新品</th>
                <th>热销</th>
                <th>库存</th>
                <th>操作</th>
            </tr>
            <tr>
                <td class="center"><img src="upload/goods01.jpg" width="50" height="50"/></td>
                <td>这里是产品名称</td>
                <td class="center">A15902</td>
                <td class="center"><strong class="rmb_icon">59.00</strong></td>
                <td class="center">包</td>
                <td class="center"><a title="是" class="link_icon">&#89;</a></td>
                <td class="center"><a title="否" class="link_icon">&#88;</a></td>
                <td class="center"><a title="是" class="link_icon">&#89;</td>
                <td class="center">5559</td>
                <td class="center">
                    <a href="#" title="预览" class="link_icon" target="_blank">&#118;</a>
                    <a href="#" title="恢复到产品列表" class="link_icon">&#47;</a>
                    <a href="#" title="彻底删除" class="link_icon">&#100;</a>
                </td>
            </tr>
            <tr>
                <td class="center"><img src="upload/goods02.jpg" width="50" height="50"/></td>
                <td>这里是产品名称</td>
                <td class="center">A15902</td>
                <td class="center"><strong class="rmb_icon">59.00</strong></td>
                <td class="center">包</td>
                <td class="center"><a title="是" class="link_icon">&#89;</a></td>
                <td class="center"><a title="否" class="link_icon">&#88;</a></td>
                <td class="center"><a title="是" class="link_icon">&#89;</a></td>
                <td class="center">5559</td>
                <td class="center">
                    <a href="#" title="预览" class="link_icon" target="_blank">&#118;</a>
                    <a href="#" title="恢复到产品列表" class="link_icon">&#47;</a>
                    <a href="#" title="彻底删除" class="link_icon">&#100;</a>
                </td>
            </tr>
        </table>
        <aside class="paging">
            <a>第一页</a>
            <a>1</a>
            <a>2</a>
            <a>3</a>
            <a>…</a>
            <a>1004</a>
            <a>最后一页</a>
        </aside>
    </div>
</section>
</body>
</html>