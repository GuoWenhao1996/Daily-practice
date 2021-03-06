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
    <form id="baseForm" action="${basePath }goods/update.do" name="baseForm" method="post" >
   	<c:forEach items= "${pgoods}" var="g"> 
    <section>
     <ul class="ulColumn2">
       <li>
       <span class="item_name" style="width:200px;">商品编号：</span>
       <input type="text" class="textbox"  readonly="readonly"  name="gnumber" value="${g.gnumber}"/>
      </li>
      <li>
       <span class="item_name" style="width:200px;">商品名称： </span>
       <input type="text" class="textbox textbox_295" value="${g.gname}" id="gname" name="gname" />
      </li>
      <li>
       <span class="item_name" style="width:200px;">商品单价：</span>
       <input type="text" class="textbox textbox_295" value="${g.gprice}" name="gprice"id="gprice" />
      </li>
       <li>
       <span class="item_name" style="width:200px;">商品库存数量：</span>
       <input type="number" class="textbox textbox_295" value="${g.gstock}" name="gstock" id="gstock"/>
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
        	<option  value="新鲜水果">新鲜水果</option>
					<option value="新鲜蔬菜">新鲜蔬菜</option>
					<option value="新鲜水产">新鲜水产</option>
					<option value="肉类">肉类</option>
					<option value="休闲零食">休闲零食</option>
					<option value="饼干糕点">饼干糕点</option>
					<option value="酒类"> 酒 类 </option>
					<option value="茶叶">茶 叶</option>
					<option value="乳品冲饮">乳品冲饮</option>
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
			<input type="hidden" id="myurl" name="myurl" value="${g.url}">
			<img id="myimg" style="width:30%; height:320px; object-fit:contain;" src="${g.url}">
		</li>
      <li>
		<span class="item_name" style="width: 80px;">产品详情：</span>
		 <textarea name="gdetail" class="ckeditor" >${g.gdetail}</textarea>
	 <li>
      <li>
       <span class="item_name" style="width:120px;"></span>
      </li>
     </ul>
    </section>
    </c:forEach>
      <input type="button" value="提交" onclick="check();"/> 
    </form>
</div>
</section>
<script type="text/javascript">
//检查表单内容不能为空
	function check(){
		var gname=document.getElementById('gname').value;//商品名称验证
		var gstock=document.getElementById('gstock').value;//商品数量验证
		var gprice=document.getElementById('gprice').value;//商品价格为空验证
		var myimgupload=document.getElementById('myimgupload').value;//图片
		if(myimgupload=="") {
			alert('请重新选择图片！');
			document.baseForm.myimgupload.focus();
		}
		if(gname==""||gstock==""||gprice==""||myimgupload==""){
             alert('修改的有内容为空,请继续输入');
			document.baseForm.gnumber.focus(); 
             }else{
                  document.getElementById("baseForm").submit();
              }
		}
		
	//判断输入数量的范围
	  var text = document.getElementById("gstock");
	  text.onkeyup = function(){
        this.value=this.value.replace(/\D/g,'');
            if(text.value<0){
            alert("请填写大于0的数字")
      		return false;
            }
            } 
	  //判断输入的单价大于0
	  var text = document.getElementById("gprice");
	  text.onkeyup = function(){
        this.value=this.value.replace(/\D/g,'');
        if(text.value<0){
            alert("请填写大于0的数字")
      		return false;
            }
            } 
//预览图片
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
		$("#baseForm").ajaxSubmit(options);
	}
</script>
<script src="${basePath }backend/js/ueditor.config.js"></script>
<script src="${basePath}backend/ckeditor/ckeditor.js"></script>
<script src="${basePath}backend/res/jquery.form.js"></script>
</body>
</html>