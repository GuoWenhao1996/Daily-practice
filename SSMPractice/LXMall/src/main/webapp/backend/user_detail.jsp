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
    <title>乐鲜Mall后台丨会员详情</title>
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
            <h2 class="fl">会员详情</h2>
            <a href="adjust_funding.html" class="fr top_rt_btn money_icon">资金管理</a>
        </div>
        <ul class="ulColumn2">
            <li>
                <span class="item_name" style="width:120px;">上传头像：</span>
                <label class="uploadImg">
                    <input type="file"/>
                    <span>上传头像</span>
                </label>
            </li>
            <li>
                <span class="item_name" style="width:120px;">会员名称：</span>
                <input type="text" class="textbox textbox_225" value="DeathGhost" placeholder="会员账号..."/>
                <span class="errorTips">错误提示信息...</span>
            </li>
            <li>
                <span class="item_name" style="width:120px;">登陆密码：</span>
                <input type="password" class="textbox textbox_225" value="1830000000" placeholder="会员密码..."/>
                <span class="errorTips">错误提示信息...</span>
            </li>
            <li>
                <span class="item_name" style="width:120px;">会员等级：</span>
                <select class="select">
                    <option>会员等级</option>
                    <option>普通会员</option>
                    <option>高级会员</option>
                </select>
            </li>
            <li>
                <span class="item_name" style="width:120px;">电子邮箱：</span>
                <input type="email" class="textbox textbox_225" value="DeathGhost@sina.cn" placeholder="电子邮件地址..."/>
                <span class="errorTips">错误提示信息...</span>
            </li>
            <li>
                <span class="item_name" style="width:120px;">手机号码：</span>
                <input type="tel" class="textbox textbox_225" value="18300000000" placeholder="手机号码..."/>
                <span class="errorTips">错误提示信息...</span>
            </li>
            <li>
                <span class="item_name" style="width:120px;">可用资金：</span>
                <input type="text" class="textbox textbox_225" value="1599.00" placeholder="可用资金（单位：元）..." readonly/>
                <span>元</span>
            </li>
            <li>
                <span class="item_name" style="width:120px;">冻结资金：</span>
                <input type="text" class="textbox textbox_225" value="100.00" placeholder="冻结资金（单位：元）..." readonly/>
                <span>元</span>
            </li>
            <li>
                <span class="item_name" style="width:120px;">收货地址：</span>
                <select class="select">
                    <option>选择省份</option>
                    <option>陕西省</option>
                    <option>山西省</option>
                </select>
                <select class="select">
                    <option>选择城市</option>
                    <option>西安市</option>
                    <option>大同市</option>
                </select>
                <select class="select">
                    <option>选择区/县</option>
                    <option>长安县</option>
                    <option>不晓得</option>
                </select>
            </li>
            <li>
                <span class="item_name" style="width:120px;">详细地址：</span>
                <input type="text" class="textbox textbox_295" value="陕西省西安市未央区凤城五路旺景国际大厦" placeholder="详细地址..."/>
                <span class="errorTips">错误提示信息...</span>
            </li>
            <li>
                <span class="item_name" style="width:120px;"></span>
                <input type="submit" class="link_btn" value="更新/保存"/>
            </li>
        </ul>
    </div>
</section>
</body>
</html>