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
  <form id="baseForm" action="${basePath}goods/add.do" method="post"  onkeydown="javascript: if (event.keyCode == 13){return check();}">
  <!-- <form id="baseForm" name="baseForm" 
         action="xxx.action" method="post"
         onkeydown="javascript: if (event.keyCode == 13){return check();}">
        <input id="gname" name="name" type="text" />
       <input type="button" value="提交" onclick="check();"/>
     </form> -->
	<section>
		<ul class="ulColumn2">
			 <li>
				<span class="item_name" style="width: 200px;">商品编号：</span>
				<input type="text" class="textbox" placeholder="商品货号..." name="gnumber"  id="gnumber"  /><span id="gnumberr" style="color: red"></span><br>
			</li> 
			<li>
				<span class="item_name" style="width: 200px;">商品名称：</span>
				<input  id="gname" type="text" class="textbox textbox_295" placeholder="商品名称..." name="gname"  />
			</li>
			<li>
				<span  class="item_name" style="width: 200px;">商品数量：</span>
				<input id="gvolume" type="text" class="textbox textbox_295" placeholder="商品库存..."name="gstock"   />
			<script type="text/javascript">

</script>
			</li>
			<li>
				<span class="item_name" style="width: 200px;">商品价格：</span>
				<input type = "number" name= "gprice" id = "gprice" class="textbox textbox_295" placeholder="商品价格..." onkeyup="clearNoNum(this);"/>  
			</li>
			<li>
			 	<span class="item_name" style="width: 180px;">商品分类：</span>
			 	<select class="select" name="gsort">
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
				<textarea  id="inputgdetail"  name="gdetail" class="ckeditor" ></textarea>
			</li> 
		   </ul>
	   </section>
		       <!-- <button type="submit"  onclick="check();">提交</button> -->
		       <input type="button" value="提交" onclick="check();"/>
	 </form>
  </div>
</section>
	 <script type="text/javascript">
	//判断输入数量的范围
	  var text = document.getElementById("gvolume");
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
	  //检查表单内容不能为空
		function check(){
		var gnumber=document.getElementById('gnumber').value;//商品编号验证
		var gname=document.getElementById('gname').value;//商品名称验证
		var gstock=document.getElementById('gstock').value;//商品数量验证
		var gprice=document.getElementById('gprice').value;//商品价格为空验证
		if(gnumber==""||gname==""||gvolume==""||gprice==""||myurl==""||gdetail==""){
                alert('添加的所有内容均不能为空');
				document.baseForm.gnumber.focus(); 
                }else{
                     document.baseForm.submit();
                 }
			}
		//验证商品编号是否唯一
	 $(function () {
			$("#gnumber").blur(function() {
				//验证姓名是否唯一
				//发送ajax请求
				 $.post("${basePath}goods/validate.do",{gnumber:$("#gnumber").val()},function(data){
					$("#gnumberr").html(data.content);
				},"json") 
			});//失去焦点是执行本函数 
		})	
	   //加载图片预览
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
		
		/* 输入单价两位小数 */
		function clearNoNum(obj) {  
    		obj.value = obj.value.replace(/[^\d.]/g,""); //清除"数字"和"."以外的字符  
        	obj.value = obj.value.replace(/^\./g,""); //验证第一个字符是数字而不是  
        	obj.value = obj.value.replace(/\.{2,}/g,"."); //只保留第一个. 清除多余的  
        	obj.value = obj.value.replace(".","$#$").replace(/\./g,"").replace("$#$",".");  
        	obj.value = obj.value.replace(/^(\-)*(\d+)\.(\d\d).*$/,'$1$2.$3'); //只能输入两个小数  

		} 
	</script> 
</body>
</html>