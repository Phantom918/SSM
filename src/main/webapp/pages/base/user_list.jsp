<%@page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!doctype html>
<html>
	<head>
		<title>用户列表显示</title>
		<%@include file="/pages/common/meta.jsp"%>
    	<%@include file="/pages/common/baseLink.jsp"%>
	</head>
	<body>
		<h1>这是UserController对应的user_list.html</h1>
		<form action="${ctx}/user" method="post">
			<table class="table table-hover table-bordered">
				<tr>
					<td class="font_d3">姓名</td>
					<td>
						<input type="text" name="username" value="${entity.username}"/>
					</td>
					<td>
						<input type="submit" value="查询" />
					</td>
				</tr>
			</table>
		</form>
		<div>
			<table class="table table-hover table-bordered">
				<tr align="center">
					<th class="info text-center col-md-2">用户序号</th>
					<th class="info text-center col-md-5">用户姓名</th>
					<th class="info text-center col-md-5">角色姓名</th>
				</tr>
				<c:forEach items="${ list }" var="userVO">
					<tr align="center" bgcolor="#FFFFFF">
						<td>${userVO.id}</td>
						<td>${userVO.username}</td>
						<td>${userVO.role.name}</td>
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