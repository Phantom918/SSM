<%@page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!doctype html>
<html>
	<head>
		<title>角色查看</title>
		<%@include file="/pages/common/meta.jsp"%>
    	<%@include file="/pages/common/baseLink.jsp"%>
	</head>
	<body>
		<h1>这是RoleController的role_view.html</h1>
		<div>
			<table  class="table table-hover table-bordered">
				<tr>
					<td class="info text-center col-md-4">角色名:</td>
					<td class="info text-center col-md-8">${entity.name}</td>
				</tr>
			</table>
		</div>
		<div>
			<h3><a href="${ctx}/role">返回</a></h3>
		</div>
		
		<!-- ========== Bootstrap core JavaScript =========== -->
    	<%@include file="/pages/common/baseScript.jsp"%>
	</body>
</html>