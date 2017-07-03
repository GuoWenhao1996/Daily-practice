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
<meta charset="utf-8" />
<title>乐鲜Mall后台丨添加商品</title>
 <meta charset="utf-8"/>
<link rel="stylesheet" type="text/css" href="${basePath }backend/css/style.css">
  <script src="${basePath }backend/js/jquery.js"></script>  
 <script src="${basePath }backend/js/jquery.mCustomScrollbar.concat.min.js"></script> 
<script src="${basePath}backend/ckeditor/ckeditor.js"></script>
<script src="${basePath}backend/ckeditor/config.js"></script>
<script src="${basePath}backend/res/jquery.form.js"></script>
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
			<h2 class="fl">商品添加</h2>
			<a class="fr top_rt_btn" href="${basePath }goods/Adminlist.do">返回产品列表</a>
	  </div>
  <form id="pgoodsupload" action="${basePath}goods/add.do" method="post">
	<section>
		<ul class="ulColumn2">
			 <li>
				<span class="item_name" style="width: 200px;">商品编号：</span>
				<input type="text" class="textbox" placeholder="商品货号..." name="gnumber"    />
			</li> 
			<li>
				<span class="item_name" style="width: 200px;">商品名称：</span>
				<input type="text" class="textbox textbox_295" placeholder="商品名称..." name="gname"  />
			</li>
			<li>
				<span class="item_name" style="width: 200px;">商品数量：</span>
				<input type="number" class="textbox textbox_295" placeholder="商品库存..."name="gstock"   />
			</li>
			<li>
				<span class="item_name" style="width: 200px;">商品价格：</span>
				<input type="number" class="textbox textbox_295" placeholder="商品价格..."name="gprice"   />
			</li>
			<li>
			 	<span class="item_name" style="width: 180px;">商品分类：</span>
			 	<select class="select" name="gsort">
					<option  value="牛奶">牛 奶</option>
					<option value="酒类">酒 类</option>
					<option value="茶类">茶 类</option>
					<option value="食品">食 品</option>
				</select>
			</li>
			<li>
			 	<span class="item_name" style="width: 180px;">商品状态：</span>
			 	<select class="select" name="gstatus">
					<option  value="待上架">待上架</option>
					<option value="在售">在售</option>
				</select>
			</li>
			<li>
				<span class="item_name" style="width: 120px;">上传图片：</span>
				<label class="uploadImg">
					<input id="myimgupload" name="myimgupload" type="file" onchange="fileSelected()" accept=".jpg"/>
					<span>上传图片</span>
				</label>
			</li>
			<li>
				<span class="item_name" style="width: 120px;">图片预览：</span>
				<input type="hidden" id="myurl" name="myurl" value="">
				<img id="myimg" style="width: 30%; height: 320px; object-fit:contain;">
			</li>
			
			 <li>
				<span class="item_name" style="width: 80px;">产品详情：</span>
				<textarea name="gdetail" class="ckeditor"></textarea>
			</li> 
		   </ul>
	   </section>
		       <button type="submit"  >提交</button>
	 </form>
  </div>
</section>
	
	 <script type="text/javascript">
		function changeVideo(str) {
			try {
				document.getElementById("myimg").src = str;
			} catch (e) {
				alert("加载失败！");
			}
		}
		//获得当前选择的本地文件路径
		function fileSelected() {
			var file = document.getElementById('myimgupload').files[0];
			if (file) {
				var url = URL.createObjectURL(file);
				changeVideo(url);
				uploadImg();
			}
		}
		//图片的上传
		function uploadImg() {
			var options = {
				url : "${basePath}goods/uploadpicture.do",
				dataType : "json",
				type : "post",
				success : function(url) {
					$("#myurl").attr("value", url);
				}
			};
			$("#pgoodsupload").ajaxSubmit(options);
		}
	</script> 

</body>
</html>