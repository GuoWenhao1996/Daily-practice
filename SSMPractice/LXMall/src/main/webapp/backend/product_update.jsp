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
<base href="<%=basePath%>">
<meta charset="utf-8" />
<title>乐鲜Mall后台丨商品添加</title>
<meta name="author" content="DeathGhost" />
<link rel="stylesheet" type="text/css"
	href="${basePath}backend/css/style.css">
<script src="${basePath}backend/js/jquery.js"></script>
<script
	src="${basePath}backend/js/jquery.mCustomScrollbar.concat.min.js"></script>
<script>
	(function($) {
		$(window).load(
				function() {

					$("a[rel='load-content']").click(
							function(e) {
								e.preventDefault();
								var url = $(this).attr("href");
								$.get(url, function(data) {
									$(".content .mCSB_container").append(data); //load new content inside .mCSB_container
									$(".content").mCustomScrollbar("scrollTo",
											"h2:last");
								});
							});

					$(".content").delegate(
							"a[href='top']",
							"click",
							function(e) {
								e.preventDefault();
								$(".content").mCustomScrollbar("scrollTo",
										$(this).attr("href"));
							});

				});
	})(jQuery);
</script>
</head>
<body>  
<section class="rt_wrap content mCustomScrollbar">
<div class="rt_content">
     <div class="page_title">
      <h2 class="fl">商品详情</h2>
      <a href="${basePath }goods/Adminlist.do"  class="fr top_rt_btn" >返回产品列表</a>
     </div>
     <form action="${basePath }goods/update.do">
   <c:forEach items= "${pgoods}" var="g"> 
    <section>
     <ul class="ulColumn2">
       <li>
       <span class="item_name" style="width:200px;">商品编号：</span>
       <input type="text" class="textbox"  readonly="readonly" name="gnumber" value="${g.gnumber}"/>
      </li>
      <li>
       <span class="item_name" style="width:200px;">商品名称： </span>
       <input type="text" class="textbox textbox_295" value="${g.gname}" name="gname" />
      </li>
      <li>
       <span class="item_name" style="width:200px;">商品单价：</span>
       <input type="number" class="textbox textbox_295" value="${g.gprice}" name="gprice"/>
      </li>
       <li>
       <span class="item_name" style="width:200px;">商品库存数量：</span>
       <input type="number" class="textbox textbox_295" value="${g.gstock}" name="gstock"/>
      </li>
      <li>
       <span class="item_name" style="width: 180px;">商品状态：</span>
			 	<select class="select" name="gstatus">
			 		<option value="${g.gstatus}">${g.gstatus }</option>
					<option value="在售">在售</option>
					<option value="待上架">待上架</option>
					<option value="库存不足">库存不足</option>
					<option value="库存满">库存满</option>
				</select>
      	</li>
      	<li>
       <span class="item_name" style="width:180px;">商品分类：</span>
       <select class="select" name="gsort" >
       		<option value="${g.gsort}">${g.gsort }</option>
        	<option value="牛奶"> 牛 奶 </option>
        	<option value="酒  精"> 酒  精 </option>
        	<option value="茶  叶"> 茶  叶 </option>
        	<option value="食  品"> 食  品 </option>
       </select>
       </li>
      <li>
		<span class="item_name" style="width: 80px;">产品详情：</span>
		 <textarea name="gdetail" class="ckeditor" >${g.gdetail}</textarea>
	 <li>
      <li>
       <span class="item_name" style="width:120px;"></span>
      <!--  <input type="submit" class="link_btn"/> -->
      </li>
     </ul>
    </section>
    </c:forEach>
    <button type="submit" >提交</button>
    </form>
</div>
</section>
<script src="${basePath }backend/js/ueditor.config.js"></script>
<!-- 自己加的富文本编辑器 -->
<script src="${basePath}backend/ckeditor/ckeditor.js"></script>
</body>
</html>