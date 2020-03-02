<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<!-- 页面meta -->
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>用户详情</title>

	<!-- Tell the browser to be responsive to screen width -->
	<meta
			content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no"
			name="viewport">


	<link rel="stylesheet"
		  href="${pageContext.request.contextPath}/plugins/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet"
		  href="${pageContext.request.contextPath}/plugins/font-awesome/css/font-awesome.min.css">
	<link rel="stylesheet"
		  href="${pageContext.request.contextPath}/plugins/ionicons/css/ionicons.min.css">
	<link rel="stylesheet"
		  href="${pageContext.request.contextPath}/plugins/iCheck/square/blue.css">
	<link rel="stylesheet"
		  href="${pageContext.request.contextPath}/plugins/morris/morris.css">
	<link rel="stylesheet"
		  href="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
	<link rel="stylesheet"
		  href="${pageContext.request.contextPath}/plugins/datepicker/datepicker3.css">
	<link rel="stylesheet"
		  href="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.css">
	<link rel="stylesheet"
		  href="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
	<link rel="stylesheet"
		  href="${pageContext.request.contextPath}/plugins/datatables/dataTables.bootstrap.css">
	<link rel="stylesheet"
		  href="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.css">
	<link rel="stylesheet"
		  href="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.theme.default.css">
	<link rel="stylesheet"
		  href="${pageContext.request.contextPath}/plugins/select2/select2.css">
	<link rel="stylesheet"
		  href="${pageContext.request.contextPath}/plugins/colorpicker/bootstrap-colorpicker.min.css">
	<link rel="stylesheet"
		  href="${pageContext.request.contextPath}/plugins/bootstrap-markdown/css/bootstrap-markdown.min.css">
	<link rel="stylesheet"
		  href="${pageContext.request.contextPath}/plugins/adminLTE/css/AdminLTE.css">
	<link rel="stylesheet"
		  href="${pageContext.request.contextPath}/plugins/adminLTE/css/skins/_all-skins.min.css">
	<link rel="stylesheet"
		  href="${pageContext.request.contextPath}/css/style.css">
	<link rel="stylesheet"
		  href="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.css">
	<link rel="stylesheet"
		  href="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.skinNice.css">
	<link rel="stylesheet"
		  href="${pageContext.request.contextPath}/plugins/bootstrap-slider/slider.css">
	<link rel="stylesheet"
		  href="${pageContext.request.contextPath}/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.css">
</head>

<body class="hold-transition skin-purple sidebar-mini">

<div class="wrapper">

	<!-- 页面头部 -->
	<jsp:include page="header.jsp"></jsp:include>
	<!-- 页面头部 /-->
	<!-- 导航侧栏 -->
	<jsp:include page="aside.jsp"></jsp:include>
	<!-- 导航侧栏 /-->

	<!-- 内容区域 -->
	<div class="content-wrapper">

		<!-- 内容头部 -->
		<section class="content-header">
			<h1>
				系统管理 <small>用户管理</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="${pageContext.request.contextPath}/notice/main.do"><i
						class="fa fa-dashboard"></i> 首页</a></li>
				<li><a
						href="#">系统管理</a></li>
				<li><a
						href="${pageContext.request.contextPath}/user/findAll.do">用户管理</a></li>
				<li class="active">用户详情</li>
			</ol>
		</section>
		<!-- 内容头部 /-->


			<!-- 正文区域 -->
			<section class="content"> <!--用户信息-->
				<form action="${pageContext.request.contextPath}/user/update.do" method="post">
				<div class="panel panel-default">
					<div class="panel-heading">用户详情</div>
					<div class="row data-type">

						<input type="hidden" name="uid" value="${userInfo.uid}">

						<div class="col-md-2 title">用户名</div>
						<div class="col-md-4 data">
							<input type="text" class="form-control" name="username"
								   placeholder="用户名称" value="${userInfo.username}" readonly>
						</div>
						<div class="col-md-2 title">密码</div>
						<div class="col-md-4 data">
							<input type="password" class="form-control" name="psw"
								   placeholder="密码" value="${userInfo.psw}">
						</div>
						<div class="col-md-2 title">姓名</div>
						<div class="col-md-4 data">
							<input type="text" class="form-control" name="uname"
								   placeholder="姓名" value="${userInfo.uname}">
						</div>
						<div class="col-md-2 title">手机号码</div>
						<div class="col-md-4 data">
							<input type="text" class="form-control" name="phone"
								   placeholder="手机号码" value="${userInfo.phone}">
						</div>
						<div class="col-md-2 title">邮箱</div>
						<div class="col-md-4 data">
							<input type="text" class="form-control" name="email"
								   placeholder="邮箱" value="${userInfo.email}">
						</div>

						<div class="col-md-2 title">办公地点</div>
						<div class="col-md-4 data">
							<input type="text" class="form-control" name="office"
								   placeholder="办公地点" value="${userInfo.office}">
						</div>

						<div class="col-md-2 title">创建时间</div>
						<div class="col-md-4 data">
							<input type="text" class="form-control" name="create_timeStr"
								   placeholder="创建时间" value="${userInfo.create_timeStr}" readonly>
						</div>
						<security:authorize access="hasRole('ROLE_ADMIN')">
						<div class="col-md-2 title">用户状态</div>
						<c:if test="${userInfo.status==0}" >
							<div class="col-md-4 data">
								<select class="form-control select2" style="width: 100%"
										name="status">
									<option value="0" selected="selected">关闭</option>
									<option value="1">开启</option>
								</select>
							</div>
						</c:if>
						<c:if test="${userInfo.status==1}" >
							<div class="col-md-4 data">
								<select class="form-control select2" style="width: 100%"
										name="status">
									<option value="0" >关闭</option>
									<option value="1" selected="selected">开启</option>
								</select>
							</div>
						</c:if>
					</div>
					</security:authorize>
				</div>
				<!--工具栏-->
				<div class="box-tools text-center">
					<button type="submit" class="btn bg-maroon">修改</button>
					<%--<button type="button" class="btn bg-default"--%>
					<%--onclick="window.location.href='${pageContext.request.contextPath}/user/findAll.do';">返回</button>--%>
					<button type="button" class="btn bg-default"
							onclick="history.back(-1);">返回</button>
				</div>
				<!--工具栏/-->
		</form>

				<div class="panel panel-default">
					<div class="panel-heading">部门职位信息
						<security:authorize access="hasRole('ROLE_ADMIN')">
						<button type="button" class="btn bg-olive btn-xs" onclick="location.href='${pageContext.request.contextPath}/departmentAndPosition/findOtherDP.do?uid=${userInfo.uid}'">添加部门职位</button>
						</security:authorize>
					</div>
					<table id="dataList" class="table table-bordered table-striped table-hover dataTable">
						<thead>

						<tr>
							<th class="sorting_asc">部门</th>
							<th class="sorting_desc">职位</th>
							<security:authorize access="hasRole('ROLE_ADMIN')">
							<th class="sorting_desc">操作</th>
							</security:authorize>
						</tr>

						</thead>
						<tbody>
						<c:forEach items="${userInfo.departmentAndPositionList}" var="dpInfo">
							<tr>
								<td>${dpInfo.department.department_name}</td>
								<td>${dpInfo.position.position_name}</td>
								<security:authorize access="hasRole('ROLE_ADMIN')">
								<td class="text-center">
									<button type="button" class="btn bg-yellow-active btn-xs" onclick="deleteDP('${userInfo.uid}','${dpInfo.dpid}')">删除</button>
								</td>
								</security:authorize>
							</tr>
						</c:forEach>
						</tbody>
					</table>
					<c:if test="${empty userInfo.departmentAndPositionList}">
						<h4>暂无部门信息</h4>
					</c:if>
				</div>

				<div class="panel panel-default">
					<div class="panel-heading">角色信息
						<security:authorize access="hasRole('ROLE_ADMIN')">
						<button type="button" class="btn bg-olive btn-xs" onclick="window.location.href='${pageContext.request.contextPath}/role/findOtherRole.do?uid=${userInfo.uid}'">添加角色</button>
						</security:authorize>
					</div>
					<table id="dataList" class="table table-bordered table-striped table-hover dataTable">
						<thead>

						<tr>
							<th class="sorting_asc">ID</th>
							<th class="sorting_desc">角色名</th>
							<th class="sorting_desc">权限级别</th>
							<th class="sorting_desc">角色描述</th>
							<security:authorize access="hasRole('ROLE_ADMIN')">
							<th class="sorting_desc">操作</th>
							</security:authorize>
						</tr>

						</thead>
						<tbody>
						<c:forEach items="${userInfo.roleList}" var="roleInfo">
							<tr>
								<td>${roleInfo.rid}</td>
								<td>${roleInfo.role_name}</td>
								<td>${roleInfo.permission}</td>
								<td>${roleInfo.description}</td>
								<security:authorize access="hasRole('ROLE_ADMIN')">
								<td class="text-center">
									<button type="button" class="btn bg-yellow-active btn-xs" onclick="deleteRole('${userInfo.uid}','${roleInfo.rid}')">删除</button>
								</td>
								</security:authorize>
							</tr>
						</c:forEach>
						</tbody>
					</table>
					<c:if test="${empty userInfo.roleList}">
						<h4>暂无角色信息</h4>
					</c:if>
				</div>
			</section>
			<!-- 正文区域 /-->
	</div>
	<!-- 内容区域 /-->

	<!-- 底部导航 -->
	<jsp:include page="footer.jsp"/>
	<!-- 底部导航 /-->

</div>


<script
		src="${pageContext.request.contextPath}/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/jQueryUI/jquery-ui.min.js"></script>
<script>
	$.widget.bridge('uibutton', $.ui.button);
</script>
<script
		src="${pageContext.request.contextPath}/plugins/bootstrap/js/bootstrap.min.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/raphael/raphael-min.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/morris/morris.min.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/sparkline/jquery.sparkline.min.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/knob/jquery.knob.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/daterangepicker/moment.min.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.zh-CN.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/datepicker/bootstrap-datepicker.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/datepicker/locales/bootstrap-datepicker.zh-CN.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/fastclick/fastclick.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/iCheck/icheck.min.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/adminLTE/js/app.min.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/select2/select2.full.min.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/colorpicker/bootstrap-colorpicker.min.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap-wysihtml5.zh-CN.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/bootstrap-markdown.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/locale/bootstrap-markdown.zh.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/markdown.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/to-markdown.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/ckeditor/ckeditor.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.extensions.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/datatables/jquery.dataTables.min.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/datatables/dataTables.bootstrap.min.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/chartjs/Chart.min.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.min.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.resize.min.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.pie.min.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.categories.min.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.min.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/bootstrap-slider/bootstrap-slider.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.min.js"></script>

<script>

	function deleteDP(uid,dpid){
		 if (confirm("确定要删除该职位吗")){
			 location.href='${pageContext.request.contextPath}/departmentAndPosition/deleteDP.do?uid='+uid+'&dpid='+dpid;
		 }
	}

	function deleteRole(uid,rid){
		 if (confirm("确定要删除该角色吗")){
			 location.href='${pageContext.request.contextPath}/user/deleteRole.do?uid='+uid+'&rid='+rid;
		 }
	}

	//提示操作是否成功
	$(document).ready(function () {

		var msgInfo = "${msgInfo}";

		if (msgInfo !=null && msgInfo.length>0){
			alert(msgInfo);
			location.reload();
		}
	})

	$(document).ready(function() {
		// 选择框
		$(".select2").select2();

		// WYSIHTML5编辑器
		$(".textarea").wysihtml5({
			locale : 'zh-CN'
		});
	});

	// 设置激活菜单
	function setSidebarActive(tagUri) {
		var liObj = $("#" + tagUri);
		if (liObj.length > 0) {
			liObj.parent().parent().addClass("active");
			liObj.addClass("active");
		}
	}

	$(document).ready(function () {

		// 激活导航位置
		setSidebarActive("form-user");

		// 列表按钮
		$("#dataList td input[type='checkbox']").iCheck({
			checkboxClass: 'icheckbox_square-blue',
			increaseArea: '20%'
		});
		// 全选操作
		$("#selall").click(function () {
			var clicks = $(this).is(':checked');
			if (!clicks) {
				$("#dataList td input[type='checkbox']").iCheck("uncheck");
			} else {
				$("#dataList td input[type='checkbox']").iCheck("check");
			}
			$(this).data("clicks", !clicks);
		});
	});
</script>


</body>

</html>