<%@page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!doctype html>
<html>
	<head>
		<title>首页</title>
		<%@include file="/pages/common/meta.jsp"%>
    	<%@include file="/pages/common/baseLink.jsp"%>
	</head>
	<body>
		<h1>这是HelloController默认的hello.html</h1>
		<div>
			<h3><a href="${ctx}/user">点击链接，执行UserController</a></h3>
		</div>
		<div>
			<h3><a href="${ctx}/role">点击链接，执行RoleController</a></h3>
		</div>
	</body>
</html>