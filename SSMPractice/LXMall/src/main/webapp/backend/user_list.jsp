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
    <title>乐鲜Mall后台丨会员列表</title>
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
            <h2 class="fl">会员列表</h2>
            <a href="user_detail.html" class="fr top_rt_btn add_icon">添加新会员</a>
        </div>
        <section class="mtb">
            <select class="select">
                <option>会员等级</option>
                <option>普通会员</option>
                <option>高级会员</option>
            </select>
            <input type="text" class="textbox textbox_225" placeholder="输入会员号/手机/电子邮件查询..."/>
            <input type="button" value="查询" class="group_btn"/>
        </section>
        <table class="table">
            <tr>
                <th>Id</th>
                <!--<th>会员头像</th>-->
                <th>会员账号</th>
                <th>手机号码</th>
                <th>电子邮件</th>
                <th>验证</th>
                <th>会员等级</th>
                <!--<th>账户余额</th>-->
                <!--<th>冻结资金</th>-->
                <th>操作</th>
            </tr>
            <tr>
                <td class="center">001</td>
                <!--<td class="center"><img src="upload/user_002.png" width="50" height="50"/></td>-->
                <td>DeathGhost</td>
                <td class="center">18300000000</td>
                <td class="center">deathghost@sina.cn</td>
                <td class="center"><a title="已验证" class="link_icon">&#89;</a></td>
                <td class="center">普通会员</td>
                <!--<td class="center">-->
                    <!--<strong class="rmb_icon">5559.00</strong>-->
                <!--</td>-->
                <!--<td class="center">-->
                    <!--<strong class="rmb_icon">59.00</strong>-->
                <!--</td>-->
                <td class="center">
                    <a href="user_detail.html" title="编辑" class="link_icon">&#101;</a>
                    <a href="#" title="删除" class="link_icon">&#100;</a>
                </td>
            </tr>
            <tr>
                <td class="center">002</td>
                <!--<td class="center"><img src="upload/user_001.png" width="50" height="50"/></td>-->
                <td>DeathGhost02</td>
                <td class="center">15800000000</td>
                <td class="center">232650413@sina.cn</td>
                <td class="center"><a title="未验证" class="link_icon">&#88;</a></td>
                <td class="center">高级会员</td>
                <!--<td class="center">-->
                    <!--<strong class="rmb_icon">199.00</strong>-->
                <!--</td>-->
                <!--<td class="center">-->
                    <!--<strong class="rmb_icon">15.00</strong>-->
                <!--</td>-->
                <td class="center">
                    <a href="user_detail.html" title="编辑" class="link_icon">&#101;</a>
                    <a href="#" title="删除" class="link_icon">&#100;</a>
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