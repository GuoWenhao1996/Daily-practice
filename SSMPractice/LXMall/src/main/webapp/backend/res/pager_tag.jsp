<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://jsptags.com/tags/navigation/pager" prefix="pg"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body> 
	<div class="pages">
	  <pg:page export="first,last">
	  	当前<label>${first }-${last }</label>共<label>${total }</label>条记录
	  </pg:page>
	  
	  <pg:first export="pageUrl" unless="current">
	  	<c:if test="${pageUrl!=null}">
	  		<a href="${pageUrl}" class="first">首页</a>
	  	</c:if>
	  </pg:first>
	  <pg:prev export="pageUrl" ifnull="${true}">
	  	<c:if test="${pageUrl != null}">
	  		<a href="${pageUrl}" class="prev" title="上一页">上一页</a>
	  	</c:if>
	  </pg:prev>
	  <pg:pages>
	  	<c:choose>
	  		<c:when test="${currentPageNumber eq pageNumber}">
	  			<span>${pageNumber }</span>
	  		</c:when>
	  		<c:otherwise>
	  			<a href="${pageUrl}">${pageNumber }</a>
	  		</c:otherwise>
	  	</c:choose>
	  </pg:pages>
	  <pg:next export="pageUrl" ifnull="${true}">
	  	<c:if test="${pageUrl!=null}">
	  		<a href="${pageUrl}" class="next" title="下一页">下一页</a>
	  	</c:if>
	  </pg:next>
	  <pg:last export="pageUrl" unless="current">
	  	<c:if test="${pageUrl!=null}">
	  		<a href="${pageUrl}" class="last">尾页</a>
	  	</c:if>
	  </pg:last>
	</div>
</body>
</html>