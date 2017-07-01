<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	session.setAttribute("basePath",basePath);
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="pg" uri="http://jsptags.com/tags/navigation/pager" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <base href="<%=basePath%>">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>乐鲜Mall商城 | 商品详情</title>
    <link rel="shortcut icon" href="${basePath }images/web_title.png">
    <link href="${basePath }frontend/css/bootstrap.css" rel="stylesheet" type="text/css" media="all"/>
    <link href="${basePath }frontend/css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <link rel="stylesheet" href="${basePath }frontend/css/etalage.css" type="text/css" media="all"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <script type="application/x-javascript"> addEventListener("load", function () {
        setTimeout(hideURLbar, 0);
    }, false);
    function hideURLbar() {
        window.scrollTo(0, 1);
    } </script>
    <script src="${basePath }frontend/js/jquery.min.js"></script>

    <script src="${basePath }frontend/js/jquery.etalage.min.js"></script>
    <script>
        jQuery(document).ready(function ($) {

            $('#etalage').etalage({
                thumb_image_width: 300,
                thumb_image_height: 400,
                source_image_width: 900,
                source_image_height: 1200,
                show_hint: true,
                click_callback: function (image_anchor, instance_id) {
                    alert('Callback example:\nYou clicked on an image with the anchor: "' + image_anchor + '"\n(in Etalage instance: "' + instance_id + '")');
                }
            });

        });
    </script>

</head>
<body>

<div class="container">
 <c:forEach items= "${goods}" var="g">
    <div class=" single_top">
        <div class="single_grid">
            <div class="grid images_3_of_2">
                <ul id="etalage">
                    <li>
                        <img class="etalage_thumb_image" src="images/c3.jpg" class="img-responsive"/>
                        <img class="etalage_source_image" src="images/c3.jpg" class="img-responsive" title=""/>
                    </li>
                    <li>
                        <img class="etalage_thumb_image" src="images/c2.jpg" class="img-responsive"/>
                        <img class="etalage_source_image" src="images/c2.jpg" class="img-responsive"/>
                    </li>
                    <li>
                        <img class="etalage_thumb_image" src="images/c1.jpg" class="img-responsive"/>
                        <img class="etalage_source_image" src="images/c1.jpg" class="img-responsive"/>
                    </li>
                </ul>
                <div class="clearfix"></div>
            </div>
       
            <div class="desc1 span_3_of_2">
             
                    <h4>${g.gname }</h4>
                <div class="cart-b">
                    <div class="left-n ">RMB：${g.gprice }</div>
                    <a class="now-get get-cart-in" href="#">加入购入车</a>
                    <div class="clearfix"></div>
                </div>
                <h6>销量:${g.gvolume}&nbsp;&nbsp;&nbsp;&nbsp;库存: ${g.gstock}</h6>
                <p>商品介绍</p>
                <div class="share">
                    <h5>商品分享 :</h5>
                    <ul class="share_nav">
                        <li><a href="#"><img src="frontend/images/facebook.png" title="facebook"></a></li>
                        <li><a href="#"><img src="frontend/images/twitter.png" title="Twiiter"></a></li>
                        <li><a href="#"><img src="frontend/images/rss.png" title="Rss"></a></li>
                        <li><a href="#"><img src="frontend/images/gpluse.png" title="Google+"></a></li>
                    </ul>
                </div>
          
            </div>
            <div class="clearfix"></div>
        </div>
        <script type="text/javascript">
            $(window).load(function () {
                $("#flexiselDemo1").flexisel({
                    visibleItems: 5,
                    animationSpeed: 1000,
                    autoPlay: true,
                    autoPlaySpeed: 3000,
                    pauseOnHover: true,
                    enableResponsiveBreakpoints: true,
                    responsiveBreakpoints: {
                        portrait: {
                            changePoint: 480,
                            visibleItems: 1
                        },
                        landscape: {
                            changePoint: 640,
                            visibleItems: 2
                        },
                        tablet: {
                            changePoint: 768,
                            visibleItems: 3
                        }
                    }
                });

            });
        </script>
        <script type="text/javascript" src="${basePath }frontend/js/jquery.flexisel.js"></script>
        <div class="toogle">
            <h3 class="m_3">产品详情</h3>
            <p class="m_text"> ${g.gdetail}</p>
        </div>
    </div>

  <div class="sub-cate"  >
    <div class=" top-nav rsidebar span_1_of_left">
        <h3 class="cate">类别</h3>
        <ul class="menu">
            <li class="item1"><a  href="${basePath }goods/list.do">生鲜水果<img class="arrow-img" src="images/arrow1.png" alt=""/>
            </a>
                <ul class="cute">
                    <li class="subitem1"><a href="${basePath }goods/list.do?gsort=${g.gsort}">新鲜蔬菜 </a></li>
                    <li class="subitem2"><a href="${basePath }goods/list.do?gsort=${g.gsort}">新鲜水果</a></li>
                    <li class="subitem3"><a href="${basePath }goods/list.do?gsort=${g.gsort}">新鲜水产 </a></li>
                    <li class="subitem4"><a href="${basePath }goods/list.do?gsort=${g.gsort}">肉类 </a></li>
                </ul>
            </li>
            <li class="item2" ><a href="${basePath }goods/list.do?gsort=${g.gsort}">零&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;食<img class="arrow-img"
                                                                                     src="images/arrow1.png"
                                                                                     alt=""/></a>
                <ul class="cute">
                    <li class="subitem1"><a href="${basePath }goods/list.do?gsort=${g.gsort}">进口食品 </a></li>
                    <li class="subitem2"><a href="${basePath }goods/list.do?gsort=${g.gsort}">休闲零食</a></li>

                </ul>
            </li>
            <li class="item3"><a href="${basePath }goods/list.do?gsort='茶叶'">茶&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;酒<img class="arrow-img"
                                                                                     src="images/arrow1.png"
                                                                                     alt=""/> </a>
                <ul class="cute">
                    <li class="subitem1"><a href="${basePath }goods/list.do?gsort='酒类'">酒类 </a></li>
                    <li class="subitem2"><a href="${basePath }goods/list.do?gsort='茶叶'">茶叶 </a></li>
                    <li class="subitem3"><a href="${basePath }goods/list.do?gsort=${g.gsort}">乳品冲饮</a></li>
                </ul>
            </li>

            <ul class="kid-menu ">
                <li class="menu-kid-left"><a href="${basePath }frontend/contact.jsp">联系我们</a></li>
            </ul>
        </ul>
    </div>
        <script type="${basePath }frontend/text/javascript">
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
        <a class="view-all all-product" href="${basePath }goods/list.do">查看所有商品<span> </span></a>
    </div>
    <div class="clearfix"></div>
       </c:forEach>
</div>

</body>
</html>