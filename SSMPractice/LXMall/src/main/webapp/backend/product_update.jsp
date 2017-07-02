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
<c:forEach items= "${pgoods}" var="g"> 
<div>   
<section class="rt_wrap content mCustomScrollbar">
<div class="rt_content">
     <div class="page_title">
      <h2 class="fl">商品详情</h2>
      <a href="${basePath }goods/Adminlist.do"  class="fr top_rt_btn" >返回产品列表</a>
     </div>
    <section>
     
     <ul class="ulColumn2">
       <li>
       <span class="item_name" style="width:200px;">商品编号：</span>
       <input type="text" class="textbox" placeholder="${g.gnumber}"/>
      </li>
      <li>
       <span class="item_name" style="width:200px;">商品名称： </span>
       <input type="text" class="textbox textbox_295" placeholder="${g.gname}"/>
      </li>
      <li>
       <span class="item_name" style="width:200px;">商品库存：</span>
       <input type="text" class="textbox textbox_295" placeholder="${g.gstock}"/>
      </li>
      <li>
       <span class="item_name" style="width:180px;">商品分类：</span>
       <select class="select">
        <option> 牛 奶 </option>
        <option> 酒  精 </option>
        <option> 茶  叶 </option>
        <option> 食  品 </option>
       </select>
      </li>
      <li>
       <span class="item_name" style="width:120px;">上传图片：</span>
       <label class="uploadImg">
        <input type="file"/>
        <span>上传图片</span>
       </label>
      </li>
      <li>
       <span class="item_name" style="width:120px;">产品详情：</span>
       <script id="editor" type="text/plain" style="width:1024px;height:500px;margin-left:120px;margin-top:0;"></script>
      </li>
      <li>
       <span class="item_name" style="width:120px;"></span>
       <input type="submit" class="link_btn"/>
      </li>
     </ul>
    </section>
</div>
</section>
<script src="${basePath }backend/js/ueditor.config.js"></script>
<script src="${basePath }backend/js/ueditor.all.min.js"> </script>
<script type="text/javascript">
    //实例化编辑器
    //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
    var ue = UE.getEditor('editor');
    function isFocus(e){
        alert(UE.getEditor('editor').isFocus());
        UE.dom.domUtils.preventDefault(e)
    }
    function setblur(e){
        UE.getEditor('editor').blur();
        UE.dom.domUtils.preventDefault(e)
    }
    function insertHtml() {
        var value = prompt('插入html代码', '');
        UE.getEditor('editor').execCommand('insertHtml', value)
    }
    function createEditor() {
        enableBtn();
        UE.getEditor('editor');
    }
    function getAllHtml() {
        alert(UE.getEditor('editor').getAllHtml())
    }
    function getContent() {
        var arr = [];
        arr.push("使用editor.getContent()方法可以获得编辑器的内容");
        arr.push(${g.gdetail }"");
        arr.push(UE.getEditor('editor').getContent());
        alert(arr.join("\n"));
    }
    function getPlainTxt() {
        var arr = [];
        arr.push("使用editor.getPlainTxt()方法可以获得编辑器的带格式的纯文本内容");
        arr.push("内容为：");
        arr.push(UE.getEditor('editor').getPlainTxt());
        alert(arr.join('\n'))
    }
    function setContent(isAppendTo) {
        var arr = [];
        arr.push("使用editor.setContent('欢迎使用ueditor')方法可以设置编辑器的内容");
        UE.getEditor('${g.gdetail }').setContent('欢迎使用ueditor', isAppendTo);
        alert(arr.join("\n"));
    }
    function setDisabled() {
        UE.getEditor('editor').setDisabled('fullscreen');
        disableBtn("enable");
    }

    function setEnabled() {
        UE.getEditor('editor').setEnabled();
        enableBtn();
    }

    function getText() {
        //当你点击按钮时编辑区域已经失去了焦点，如果直接用getText将不会得到内容，所以要在选回来，然后取得内容
        var range = UE.getEditor('editor').selection.getRange();
        range.select();
        var txt = UE.getEditor('editor').selection.getText();
        alert(txt)
    }

    function getContentTxt() {
        var arr = [];
        arr.push("使用editor.getContentTxt()方法可以获得编辑器的纯文本内容");
        arr.push("编辑器的纯文本内容为：");
        arr.push(UE.getEditor('editor').getContentTxt());
        alert(arr.join("\n"));
    }
    function hasContent() {
        var arr = [];
        arr.push("使用editor.hasContents()方法判断编辑器里是否有内容");
        arr.push("判断结果为：");
        arr.push(UE.getEditor('editor').hasContents());
        alert(arr.join("\n"));
    }
    function setFocus() {
        UE.getEditor('editor').focus();
    }
    function deleteEditor() {
        disableBtn();
        UE.getEditor('editor').destroy();
    }
    function disableBtn(str) {
        var div = document.getElementById('btns');
        var btns = UE.dom.domUtils.getElementsByTagName(div, "button");
        for (var i = 0, btn; btn = btns[i++];) {
            if (btn.id == str) {
                UE.dom.domUtils.removeAttributes(btn, ["disabled"]);
            } else {
                btn.setAttribute("disabled", "true");
            }
        }
    }
    function enableBtn() {
        var div = document.getElementById('btns');
        var btns = UE.dom.domUtils.getElementsByTagName(div, "button");
        for (var i = 0, btn; btn = btns[i++];) {
            UE.dom.domUtils.removeAttributes(btn, ["disabled"]);
        }
    }

    function getLocalData () {
        alert(UE.getEditor('editor').execCommand( "getlocaldata" ));
    }

    function clearLocalData () {
        UE.getEditor('editor').execCommand( "clearlocaldata" );
        alert("已清空草稿箱")
    }
</script>
</div>
  </c:forEach>
</body>
</html>