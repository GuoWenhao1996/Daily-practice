<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	session.setAttribute("basePath",basePath);
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <base href="<%=basePath%>">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>乐鲜Mall商城 | 登录</title>
    <link rel="shortcut icon" href="${basePath }frontend/images/web_title.png">
    <link href="${basePath }frontend/css/bootstrap.css" rel="stylesheet" type="text/css" media="all"/>
    <link href="${basePath }frontend/css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <script type="application/x-javascript"> addEventListener("load", function () {
        setTimeout(hideURLbar, 0);
    }, false);
    function hideURLbar() {
        window.scrollTo(0, 1);
    } </script>
    <script src="${basePath }frontend/js/jquery.min.js"></script>
</head>
<body>

<div class="container">
    <div class="account_grid">
        <div class=" login-right">
            <h3>会员登录</h3>
            <p>若已注册会员，请登录！</p>
            <form action="user/login.do" method="post">
                <h2><font color="red">${errormessage }</font></h2>
                <div>
                    <span>账号<label>*</label></span>
                    <input type="text" name="id" required autofocus class="input">
                </div>
                <div>
                    <span>密码<label>*</label></span>
                    <input type="password" name="password" required class="input">
                </div>
                <a class="forgot" href="#">忘记密码？</a>
                <input type="submit" value="登录">
            </form>
        </div>
        <div class=" login-left">
            <h3>新会员</h3>
            <p>通过在我们的商店创建一个帐户，您将能够更快地通过结帐过程， 存储多个送货地址，查看和跟踪您的订单。</p>
            <a class="acount-btn" href="${basepath }frontend/register.jsp">创建一个新账户</a>
        </div>
        <div class="clearfix"></div>
    </div>
    <div class="sub-cate">
        <div class=" top-nav rsidebar span_1_of_left">
            <h3 class="cate">类别</h3>
            <ul class="menu">
                <li class="item1"><a href="#">生鲜水果<img class="arrow-img" src="images/arrow1.png" alt=""/>
                </a>
                    <ul class="cute">
                        <li class="subitem1"><a href="product.html">新鲜蔬菜 </a></li>
                        <li class="subitem2"><a href="product.html">新鲜水果</a></li>
                        <li class="subitem3"><a href="product.html">新鲜水产 </a></li>
                        <li class="subitem4"><a href="product.html">肉类 </a></li>
                    </ul>
                </li>
                <li class="item2"><a href="#">零&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;食<img class="arrow-img"
                                                                                         src="images/arrow1.png"
                                                                                         alt=""/></a>
                    <ul class="cute">
                        <li class="subitem1"><a href="product.html">进口食品 </a></li>
                        <li class="subitem2"><a href="product.html">休闲零食</a></li>

                    </ul>
                </li>
                <li class="item3"><a href="#">茶&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;酒<img class="arrow-img"
                                                                                         src="images/arrow1.png"
                                                                                         alt=""/> </a>
                    <ul class="cute">
                        <li class="subitem1"><a href="product.html">酒类 </a></li>
                        <li class="subitem2"><a href="product.html">茶叶 </a></li>
                        <li class="subitem3"><a href="product.html">乳品冲饮</a></li>
                    </ul>
                </li>

                <ul class="kid-menu ">

                    <li class="menu-kid-left"><a href="contact.html">联系我们</a></li>
                </ul>

            </ul>
        </div>

        <script type="text/javascript">
            $(function () {
                var menu_ul = $('.menu > li > ul'),
                    menu_a = $('.menu > li > a');
                menu_ul.hide();
                menu_a.click(function (e) {
                    e.preventDefault();
                    if (!$(this).hasClass('active')) {
                        menu_a.removeClass('active');
                        menu_ul.filter(':visible').slideUp('normal');
                        $(this).addClass('active').next().stop(true, true).slideDown('normal');
                    } else {
                        $(this).removeClass('active');
                        $(this).next().stop(true, true).slideUp('normal');
                    }
                });

            });
        </script>
        <div class=" chain-grid menu-chain">
            <a href="single.html"><img class="img-responsive chain" src="images/chengzi.jpg" alt=" "/></a>
            <div class="grid-chain-bottom chain-watch">
                <span class="actual dolor-left-grid">30元</span>
                <span class="reducedfrom">50元</span>
                <h6><a href="single.html">刘二橙子</a></h6>
            </div>
        </div>
        <a class="view-all all-product" href="product.html">查看所有商品<span> </span></a>
    </div>
    <div class="clearfix"></div>
</div>

</body>
</html>