<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	session.setAttribute("basePath", basePath);
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="pg" uri="http://jsptags.com/tags/navigation/pager" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8"/>
    <title>乐鲜Mall后台丨商品列表</title>
    <meta name="author" content="DeathGhost"/>
    <link rel="stylesheet" type="text/css" href="${basePath }backend/css/style.css"> 
   <script src="${basePath }backend/js/jquery.js"></script> 
   <script src="${basePath }backend/js/jquery.mCustomScrollbar.concat.min.js"></script>
  
</head>
<body>
 
<section class="rt_wrap content mCustomScrollbar">
    <form action="${basePath }goods/Adminlist.do" method="post">
				<input  type="text"  placeholder=" 请输入商品名称" name="gname" >
                <select  name="gsort"  >
                <option value="">商品类型</option>
                <option value="水果">新鲜水果</option>
                <option value="乳品冲饮" >乳品冲饮</option>
                <option value="酒类" >酒类</option>
                <option value="茶类" >茶类</option>
                <option value="逼哥类型" >逼哥类型</option>
           </select>
           <button type="submit">查询</button>
  </form>
    <div class="rt_content">
        <div class="page_title">
            <h2 class="fl">商品列表</h2>
            <a href="${basePath }backend/product_add.jsp"  class="fr top_rt_btn" >添加商品</a>
        </div>
        <section class="mtb">
        <table class="table">
            <tr>
                <th>缩略图</th>
                <th>编号</th>
                <th>产品名称</th>
                <th>单价</th>
                <th>产品类型</th>
                <th>库存</th>
                <th>产品状态</th>
                <th>操作</th>
            </tr>
            <c:forEach items= "${goods}" var="g">
            <tr>
                <td class="center"><img src="${basePath }frontend/upload/goods01.jpg" width="50" height="50"/></td>
                <td>${g.gnumber }</td>
                <td class="center">${g.gname }</td>
                <td class="center"><strong class="rmb_icon">${g.gprice}</strong></td>
                <td class="center">${g.gsort}</td>
                <td class="center">${g.gstock}</td>
                <td class="center">${g.gstatus}</td>
                <td class="center">
                    <a href="${basePath }goods/loadupdate.do?gnumber=${g.gnumber}" title="编辑" class="link_icon">&#101;</a>
                    <a href="${basePath }goods/delete.do?gnumber=${g.gnumber }" title="删除" class="link_icon">&#100;</a>
                </td>
            </tr>
           </c:forEach>
        </table>
        <aside class="paging">
       <!-- 分页标签 -->
	<pg:pager items="${total }" maxIndexPages="3" maxPageItems="2" url="${basePath }goods/Adminlist.do" scope="request" >
	   <pg:param name="gname" value="${goodsnamequery}"/>
	   <pg:param name="gsort" value="${goodstypequery }"/>
	   <jsp:include page="res/pager_tag.jsp"></jsp:include>
	</pg:pager>
        </aside>
    </div>
</section>
</body>
</html>