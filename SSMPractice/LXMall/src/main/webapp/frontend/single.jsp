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
    <link rel="shortcut icon" href="${basePath}frontend/images/30-30.ico"/>
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

	$(function() { //$("#name")表示找到id为name的控件
		$("#isadd").click(function() {
			//加入购物车
			//发送AJAX请求
			$.post("${basePath }shoppingcart/isaddshoppingcartgoods.do", {gnumber:$("#gnumber").val()}, function (data) {
				alert(data.content);
			}, "json")
		}); //点击的时候
	})
	
</script>

</head>
<body>

<div class="container">
 <c:forEach items= "${goods}" var="g">
    <div class=" single_top">
        <div class="single_grid">
            <div class="grid images_3_of_2">
                <ul id="etalage">
                	<c:forEach items="${gpictures}" var="p">
                    <li>
                        <img class="etalage_thumb_image" src="${p.pnumber }" class="img-responsive"/>
                        <img class="etalage_source_image" src="${p.pnumber }" class="img-responsive" title=""/>
                    </li>
                    </c:forEach>
                </ul>
                <div class="clearfix"></div>
            </div>
       
            <div class="desc1 span_3_of_2">
             
             	<input type="hidden" id="gnumber" name="gnumber" value="${g.gnumber }">
                    <h4>${g.gname }</h4>
                <div class="cart-b">
                    <div class="left-n ">RMB：${g.gprice }</div>
                    <a class="now-get get-cart-in" name="isadd" id="isadd" href="javascript:void(0)">加入购入车</a>
                    <div class="clearfix"></div>
                </div>
                <h6>销量:${g.gvolume}&nbsp;&nbsp;&nbsp;&nbsp;库存: ${g.gstock}</h6>
                <p>商品介绍</p>
                <div class="share">
                    <h5>商品分享 :</h5>
                    <ul class="share_nav">
                        <li><a href="#"><img src="${basePath}frontend/images/qq.png" title="facebook"></a></li>
                        <li><a href="#"><img src="${basePath}frontend/images/weixin.jpg" title="Twiiter"></a></li>
                        <li><a href="#"><img src="${basePath}frontend/images/wb.jpg" title="Rss"></a></li>
                        <li><a href="#"><img src="${basePath}frontend/images/tb.jpg" title="Google+"></a></li>
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