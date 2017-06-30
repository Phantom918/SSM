<%@page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!doctype html>
<html>
	<head>
		<title>角色列表显示</title>
		<%@include file="/pages/common/meta.jsp"%>
    	<%@include file="/pages/common/baseLink.jsp"%>
	</head>
	<body>
		<h1>这是RoleController对应的role_list.jsp</h1>
		<div>
			<div><h4>通过RoleController的redirect_user资源定位重定向到UserController</h4></div>
			<h3><a href="${ctx}/role/redirect_user">点击链接，执行重定向，这个URL可以直接改为${ctx}/user</a></h3>
			<h3><a href="${ctx}/role/new">新增</a></h3>
		</div>
		<div>
			<table class="table table-hover table-bordered">
				<tr align="center">
					<th class="info text-center col-md-3">序号</th>
					<th class="info text-center col-md-6">角色</th>
					<th class="info text-center col-md-3">操作</th>
				</tr>
				<c:forEach items="${ roleList }" var="roleVO">
					<tr  class="text-center">
						<td>${roleVO.id}</td>
						<td>${roleVO.name}</td>
						<td>
							<a href="${ctx}/role/view/${roleVO.id}">详细</a>
							<a href="${ctx}/role/edit/${roleVO.id}">修改</a>
							<a href="${ctx}/role/delete/${roleVO.id}">删除</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div>
			<h3><a href="${ctx}/hello">返回</a></h3>
		</div>
		
		<!-- ========== Bootstrap core JavaScript =========== -->
    	<%@include file="/pages/common/baseScript.jsp"%>
    	
	</body>
</html>