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
                <a href="#"><h4>商品相关 - <span>${total } 项</span></h4></a>
                <ul class="w_nav">
                    <form action="${basePath }goods/list.do" method="post">
	                 <input type="text"  placeholder=" 请输入商品名称" name="gname" >
	                 <button type="submit">查询</button>
                     </form>
                    <div class="clearfix"></div>
                </ul>
                <div class="clearfix"></div>
            </div>
        </div>
    <div class="grid-product"> </div>
       <c:forEach items= "${goods}" var="g">
        <div class="  product-grid">
            <div class="content_box">
            <a href="${basePath }goods/idlist.do?gnumber=${g.gnumber}">
                <div class="left-grid-view grid-view-left">
                    <img src="${g.url }" class="img-responsive watch-right" style="object-fit:contain;"/>
                    <div class="mask">
                        <div class="info">快速查看</div>
                    </div>
               </div>
            </a>
            <h4><a href="${basePath }goods/idlist.do?gnumber=${g.gnumber}">${g.gname }</a></h4>
            <p>${g.gdetail}</p>
            RMB：${g.gprice}
       </div>
        </div>
     </c:forEach>  
      </div>
<div class="sub-cate"  >
    <div class=" top-nav rsidebar span_1_of_left">
        <h3 class="cate">类别</h3>
        <ul class="menu">
            <li class="item1"><a  >生&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;鲜<img class="arrow-img" src="${basePath }frontend/images/sun.png"/>
            </a>
                <ul class="cute">
                    <li class="subitem1"><a href="${basePath }goods/list.do?gsort=蔬菜">新鲜蔬菜 </a></li>
                    <li class="subitem2"><a href="${basePath }goods/list.do?gsort=水果">新鲜水果</a></li>
                    <li class="subitem3"><a href="${basePath }goods/list.do?gsort=水产">新鲜水产 </a></li>
                    <li class="subitem4"><a href="${basePath }goods/list.do?gsort=肉类">肉类 </a></li>
                </ul>
            </li>
            <li class="item2" ><a href="${basePath }goods/list.do?gsort=零食">零&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;食<img class="arrow-img"
                                                                                     src="${basePath }frontend/images/snack.png"
                                                                                     alt=""/></a>
                <ul class="cute">
                    <li class="subitem1"><a href="${basePath }goods/list.do?gsort=食品">休闲零食 </a></li>
                    <li class="subitem2"><a href="${basePath }goods/list.do?gsort=零食">饼干糕点</a></li>

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
        <a href="${basePath }frontend/single.jsp">
        	<img class="img-responsive chain" src="images/chengzi.jpg" style="object-fit:contain;"/></a>
        <div class="grid-chain-bottom chain-watch">
            <span class="actual dolor-left-grid">${g.gprice}元</span>
            <span class="reducedfrom">1${g.gprice}元</span>
            <h6><a href="${basePath }frontend/single.jsp">${g.gname }</a></h6>
        </div>
    </div>
    <a class="view-all all-product" href="${basePath }goods/list.do">查看所有商品<span> </span></a>
</div>
<div class="clearfix"></div>
   	<!-- 分页标签 -->
	<pg:pager items="${total }" maxIndexPages="3" maxPageItems="2" url="${basePath }goods/list.do" scope="request" >
	   <pg:param name="gname" value="${goodsnamequery}"/>
	   <pg:param name="gnumber" value="${goodsnumberquery }"/>
	   <pg:param name="gsort" value="${goodstypequery }"/>
	   <jsp:include page="res/pager_tag.jsp"></jsp:include>
	</pg:pager>
</body>
</html>