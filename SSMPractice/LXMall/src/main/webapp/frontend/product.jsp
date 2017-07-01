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
    <title>乐鲜Mall商城 | 全部商品</title>
    <link rel="shortcut icon" href="images/web_title.png">
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

    <div class="women-product">
        <div class=" w_content">
            <div class="women">
                <a href="#"><h4>商品相关 - <span>4449 项</span></h4></a>
                <ul class="w_nav">
                    <li>排序 :</li>
                    <li><a class="active" href="#">最热</a></li>
                    |
                    <li><a href="#">最新</a></li>
                    |
                    <li><a href="#">折扣</a></li>
                    |
                    <li><a href="#">价格: 低 高 </a></li>
                    <div class="clearfix"></div>
                </ul>
                <div class="clearfix"></div>
            </div>
        </div>

        <div class="grid-product">
            <div class="  product-grid">
                <div class="content_box"><a href="${basePath }frontend/single.jsp">
                    <div class="left-grid-view grid-view-left">
                        <img src="${basePath }frontend/images/chengzi.jpg" class="img-responsive watch-right" alt=""/>
                        <div class="mask">
                            <div class="info">快速查看</div>
                        </div>
                </a>
                </div>
                <h4><a href="#">橙子</a></h4>
                <p>这是一个橙子的描述</p>
                RMB. 499
            </div>
        </div>
        <div class="  product-grid">
            <div class="content_box"><a href="single.html">
                <div class="left-grid-view grid-view-left">
                    <img src="images/mihoutao.jpg" class="img-responsive watch-right" alt=""/>
                    <div class="mask">
                        <div class="info">快速查看</div>
                    </div>
            </a>
            </div>
            <h4><a href="#">猕猴桃</a></h4>
            <p>这是一个猕猴桃</p>
            RMB. 499
        </div>
    </div>
    <div class="  product-grid">
        <div class="content_box"><a href="single.html">
            <div class="left-grid-view grid-view-left">
                <img src="images/pingguo.jpg" class="img-responsive watch-right" alt=""/>
                <div class="mask">
                    <div class="info">快速查看</div>
                </div>
        </a>
        </div>
        <h4><a href="#">苹果</a></h4>
        <p>这是一个苹果</p>
        RMB. 499
    </div>
</div>
<div class="  product-grid">
    <div class="content_box"><a href="single.html">
        <div class="left-grid-view grid-view-left">
            <img src="images/boluo.jpg" class="img-responsive watch-right" alt=""/>
            <div class="mask">
                <div class="info">快速查看</div>
            </div>
    </a>
    </div>
    <h4><a href="#">菠萝</a></h4>
    <p>这是一个菠萝</p>
    RMB. 499
</div>
</div>
<div class="  product-grid">
    <div class="content_box"><a href="single.html">
        <div class="left-grid-view grid-view-left">
            <img src="images/ningmeng.jpg" class="img-responsive watch-right" alt=""/>
            <div class="mask">
                <div class="info">快速查看</div>
            </div>
    </a>
    </div>
    <h4><a href="#">柠檬</a></h4>
    <p>这是一个柠檬</p>
    RMB. 499
</div>
</div>
<div class="clearfix"></div>
</div>
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

    <!--initiate accordion-->
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
<div class="clearfix" style="margin: 50% auto auto 80%;">
    7777777777777777777777777777777
</div>

</div>

</body>
</html>