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
<meta name="author" content="DeathGhost" />
<link rel="stylesheet" type="text/css" href="css/style.css">
<!--[if lt IE 9]>
<script src="js/html5.js"></script>
<![endif]-->
<script src="js/jquery.js"></script>
<script src="js/jquery.mCustomScrollbar.concat.min.js"></script>
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
			<a class="fr top_rt_btn" href="${basePath }goods/Adminlist.do">返回产品列表</a>
		</div>
		<section>
		<form id="pgoodsupload" action="" method="post">
		<ul class="ulColumn2">
			<li>
				<span class="item_name" style="width: 200px;">商品名称：</span>
				<input type="text" class="textbox textbox_295" placeholder="商品名称..." />
			</li>
			<li>
				<span class="item_name" style="width: 200px;">商品数量：</span>
				<input type="text" class="textbox textbox_295" placeholder="商品库存..." />
			</li>
			<li>
				<span class="item_name" style="width: 200px;">商品编号：</span>
				<input type="text" class="textbox" placeholder="商品货号..." />
			</li>
			<li>
			 	<span class="item_name" style="width: 180px;">商品分类：</span>
			 	<select class="select">
					<option>牛 奶</option>
					<option>酒 精</option>
					<option>茶 叶</option>
					<option>食 品</option>
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
				<input type="hidden" id="myurl" value="">
				<img id="myimg" style="width: 30%; height: 320px;">
			</li>
			
			<li>
				<span class="item_name" style="width: 80px;">产品详情：</span>
				<textarea name="goodsDesc" class="ckeditor"></textarea>
			<li>
			<li>
				<span class="item_name" style="width: 120px;"></span>
				<input type="submit" class="link_btn" />
			</li>
		</ul>
		</form>
		</section>
	</div>
	</section>
	<script src="${basePath}backend/ckeditor/ckeditor.js"></script>
	<script src="${basePath}backend/res/jquery.form.js"></script>
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
	<script src="${basePath}backend/js/ueditor.config.js"></script>
	<script src="${basePath}backend/js/ueditor.all.min.js">
	</script>
</body>
</html>