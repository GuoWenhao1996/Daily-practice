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
    <title>乐鲜Mall后台丨站点基础设置</title>
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
            <h2 class="fl">站点基础设置</h2>
        </div>
        <section>
            <ul class="ulColumn2">
                <li>
                    <span class="item_name" style="width:120px;">站点名称：</span>
                    <input type="text" class="textbox textbox_225" placeholder="站点名称..."/>
                    <span class="errorTips">一般不超过80个字符</span>
                </li>
                <li>
                    <span class="item_name" style="width:120px;">上传logo：</span>
                    <label class="uploadImg">
                        <input type="file"/>
                        <span>上传站点logo</span>
                    </label>
                </li>
                <li>
                    <span class="item_name" style="width:120px;">站点描述：</span>
                    <input type="text" class="textbox textbox_295" placeholder="站点描述..."/>
                    <span class="errorTips">一般不超过200个字符</span>
                </li>
                <li>
                    <span class="item_name" style="width:120px;">关键词：</span>
                    <input type="text" class="textbox textbox_295" placeholder="多个关键词用”,“或”|“隔开..."/>
                    <span class="errorTips">一般不超过100个字符</span>
                </li>
                <li>
                    <span class="item_name" style="width:120px;">公司地址：</span>
                    <select class="select">
                        <option>选择省份</option>
                    </select>
                    <select class="select">
                        <option>选择城市</option>
                    </select>
                    <select class="select">
                        <option>选择区/县</option>
                    </select>
                </li>
                <li>
                    <span class="item_name" style="width:120px;">详细地址：</span>
                    <input type="text" class="textbox textbox_295" placeholder="详细地址..."/>
                </li>
                <li>
                    <span class="item_name" style="width:120px;">关闭站点：</span>
                    <label class="single_selection"><input type="radio" name="name"/>否</label>
                    <label class="single_selection"><input type="radio" name="name"/>是</label>
                </li>
                <li>
                    <span class="item_name" style="width:120px;">关闭站点：</span>
                    <textarea placeholder="关闭站点原因" class="textarea" style="height:50px;width:640px;"></textarea>
                </li>
                <li>
                    <span class="item_name" style="width:120px;"></span>
                    <input type="submit" class="link_btn" value="保存"/>
                </li>
            </ul>
        </section>
    </div>
</section>
</body>
</html>