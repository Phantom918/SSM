<%@page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!doctype html>
<html>
  <head>
    <title>角色管理</title>
    <%@include file="/pages/common/meta.jsp"%>
    <%@include file="/pages/common/baseLink.jsp"%>
  </head>
<body>
	<a class="sr-only sr-only-focusable" href="#content">Skip to main content</a>
	
	<div class="container main-content">
		<h1 class="text-success">这是RoleController对应的role_list.html</h1>
		<div>
			<div><h4>通过RoleController的redirect_user资源定位重定向到UserController</h4></div>
			<h3><a href="${ctx}/role/redirect_user">点击链接，执行重定向，这个URL可以直接改为${ctx}/user</a></h3>
			<h3><a href="${ctx}/role/new">新增</a></h3>
			<div class="row">
				<div class="col-md-12">
                	<button type="button" class="btn btn-default" onclick="requestAjax();">请求ajax</button>
				</div>
            </div>
		</div>
		
		<div class="row">
        	<div class="col-md-12 table-responsive">
            	<table class="table table-hover table-bordered">
                	<thead>
                    	<tr>
                        	<th class="info text-center col-md-4">序号</th>
                            <th class="info text-center col-md-5">角色名称</th>
                            <th class="info text-center col-md-3">操作</th>
                        </tr>
                    </thead>
                    <tbody>
                    	<tr>
                    		<td>${parameter1}</td>
                    		<td>${parameter2}</td>
                    		<td>${parameter2}</td>
                    	</tr>
				        <c:forEach items="${ roleList }" var="roleVO">
							<tr class="text-center">
								<td>${roleVO.id}</td>
								<td>${roleVO.name}</td>
								<td>
									<a href="${ctx}/role/view/${roleVO.id}" class="btn btn-primary btn-xs" role="button">
										<span class="glyphicon glyphicon-file-text-o"></span> 详细
									</a>
									<a href="${ctx}/role/edit/${roleVO.id}" class="btn btn-primary btn-xs" role="button">
										<span class="glyphicon glyphicon-edit"></span> 修改
									</a>
									<a href="${ctx}/role/delete/${roleVO.id}" class="btn btn-primary btn-xs" role="button">
										<span class="glyphicon glyphicon-trash-o"></span> 删除
									</a>
								</td>
							</tr>
                    	</c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        
        <div class="row">
        	<form enctype="multipart/form-data" method="post" action="${ctx}/user/upload">
        		姓名：<input name="specialName" type="text" class="input" placeholder="请输入姓名" />
			    <input type="file" name="file"/>
			    <button type="submit" class="btn btn-default" >提交</button>
			</form>
        </div>
        
        <div class="row">
        	<form method="post" action="${ctx}/user/uploadkm">
        		用户ID：<input name="id" type="text" class="input" placeholder="请输入ID" />
        		用户姓名：<input name="username" type="text" class="input" placeholder="请输入姓名" />
        		用户密码：<input name="password" type="password" class="input" placeholder="请输入密码" />
        		角色ID：<input name="role.id" type="text" class="input" placeholder="请输入角色ID" />
        		角色名：<input name="role.name" type="text" class="input" placeholder="请输入角色名" />
			    <button type="submit" class="btn btn-default" >提交</button>
			</form>
        </div>
		
		<div>
			<h3><a href="${ctx}/hello">返回</a></h3>
		</div>
	</div>
	
	
	<script type="text/javascript">
		function requestAjax(){
			$.ajax({
				url : "${ctx}/user/validateName?name=我的用户1",
				type : "post",
				dataType : "json",
				timeout : 1000,
				deforeSend : function(u) {
					u.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
				},
				error : function(XmlHttpRequest, textStatus, errorThrown) {
					alert("ajax请求异常！"+textStatus+";"+errorThrown)
				},
				success : function(data) {
					alert("data:"+data+";data.success:"+data.success+";specialPeople:"+data.specialPeople);
					if (data && data.success == "true") {  
			            $('#info').html("共" + data.total + "条数据。<br/>");
			            $.each(data.data, function(i, item) {
			              var mess = "ID：" + item.id + "，姓名：" + item.username + "，密码：" + item.password;
			              alert("mess="+mess);
			            });
			          }
				}//end of success
			});
		}
		
	</script>
	
	<!-- ========== Bootstrap core JavaScript =========== -->
    <%@include file="/pages/common/baseScript.jsp"%>

</body>
</html>