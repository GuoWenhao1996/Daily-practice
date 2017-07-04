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
    <title>乐鲜Mall商城 | 联系我们</title>
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
    <div class="main">
        <div class="reservation_top">
            <div class=" contact_right">
                <h3>联系表单</h3>
                <div class="contact-form">
                    <form method="post" action="${basePath }contact-post.jsp">
                        <input type="text" class="textbox" value="姓名" onfocus="this.value = '';"
                               onblur="if (this.value == '') {this.value = '姓名';}">
                        <input type="text" class="textbox" value="邮箱" onfocus="this.value = '';"
                               onblur="if (this.value == '') {this.value = '邮箱';}">
                        <textarea value="内容" onfocus="this.value= '';"
                                  onblur="if (this.value == '') {this.value = '内容';}">内容</textarea>
                        <input type="submit" value="发送">
                        <div class="clearfix"></div>
                    </form>
                    <address class="address">
                        <p>重庆交通大学 毕业实习<br>Team3</p>
                        <dl>
                            <dt></dt>
                            <dd>免费电话:<span> +1 800 254 2478</span></dd>
                            <dd>电话:<span> +1 800 547 5478</span></dd>
                            <dd>邮箱:&nbsp; <a href="www.cqjtu.end.cn">重庆交通大学</a></dd>
                        </dl>
                    </address>
                </div>
            </div>
        </div>
    </div>
    <div class="sub-cate">
        <div class=" top-nav rsidebar span_1_of_left">
            <ul class="menu">
            <li class="item1"><a >生&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;鲜<img class="arrow-img" src="${basePath }frontend/images/sun.png"/>
            </a>
                <ul class="cute">
                    <li class="subitem1"><a href="${basePath }goods/list.do?gsort=新鲜蔬菜">新鲜蔬菜 </a></li>
                    <li class="subitem2"><a href="${basePath }goods/list.do?gsort=新鲜水果">新鲜水果</a></li>
                    <li class="subitem3"><a href="${basePath }goods/list.do?gsort=新鲜水产">新鲜水产 </a></li>
                    <li class="subitem4"><a href="${basePath }goods/list.do?gsort=肉类">肉类 </a></li>
                </ul>
            </li>
            <li class="item2" ><a href="${basePath }goods/list.do?gsort=零食">零&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;食<img class="arrow-img"
                                                                                     src="${basePath }frontend/images/snack.png"
                                                                                     alt=""/></a>
                <ul class="cute">
                    <li class="subitem1"><a href="${basePath }goods/list.do?gsort=休闲零食">休闲零食 </a></li>
                    <li class="subitem2"><a href="${basePath }goods/list.do?gsort=饼干糕点">饼干糕点</a></li>

                </ul>
            </li>
            <li class="item3"><a >茶&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;酒<img class="arrow-img"
                                                                                     src="${basePath }frontend/images/drinks.png"
                                                                                     alt=""/></a> 
                <ul class="cute">
                    <li class="subitem1"><a href="${basePath }goods/list.do?gsort=酒类">酒类 </a></li>
                    <li class="subitem2"><a href="${basePath }goods/list.do?gsort=茶叶">茶叶 </a></li>
                    <li class="subitem3"><a href="${basePath }goods/list.do?gsort=乳品冲饮">乳品冲饮</a></li>
                </ul>
            </li>

            <ul class="kid-menu ">
                <li class="menu-kid-left"><a href="${basePath }frontend/contact.jsp">联系我们</a></li>
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
        <a href="${basePath }goods/idlist.do?gnumber=${firstGoods.gnumber}">
        	<img class="img-responsive chain" src="${firstGoods.url }" style="object-fit:contain;"/></a>
        <div class="grid-chain-bottom chain-watch">
            <span class="actual dolor-left-grid">${firstGoods.gprice}元</span>
            <span class="reducedfrom">1${firstGoods.gprice}元</span>
            <h6><a href="${basePath }goods/idlist.do?gnumber=${firstGoods.gnumber}">${firstGoods.gname }</a></h6>
        </div>
    </div>
        <a class="view-all all-product" href="${basePath }goods/list.do">查看所有商品<span> </span></a>
    </div>
    <div class="clearfix"></div>
</div>

</body>
</html>