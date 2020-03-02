<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <!-- 页面meta -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <title>往期公告</title>

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
                查看公告
                <small>往期公告</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="${pageContext.request.contextPath}/notice/main.do"><i
                        class="fa fa-dashboard"></i> 首页</a></li>
                <li><a href="#">查看公告</a></li>

                <li class="active">往期公告</li>
            </ol>
        </section>
        <!-- 内容头部 /-->

        <!-- 正文区域  职位-->
        <section class="content"> <!-- .box-body -->
            <div class="box box-primary">
                <div class="box-header with-border">
                    <h3 class="box-title">往期公告列表</h3>
                </div>

                <div class="box-body">

                    <!-- 数据表格 -->
                    <div class="table-box">

                        <!--工具栏-->

                        <div class="pull-left">
                            <div class="form-group form-inline">
                                <div class="btn-group">
                                    <form action="/notice/add.do" method="post">
                                        <security:authorize access="hasRole('ROLE_ADMIN')">
                                        <!-- 按钮触发模态框 -->
                                        <input type="hidden" name="uid" value="${login_user.uid}">
                                        <button type="button" class="btn btn-default" data-toggle="modal" data-target="#Modal">
                                            <i class="fa fa-file-o"></i> 新建
                                        </button>
                                        <!-- 模态框（Modal） -->
                                        <div class="modal fade" id="Modal" tabindex="-1" role="dialog" aria-labelledby="ModalLabel" aria-hidden="true">
                                            <div class="modal-dialog">
                                                <div class="modal-content">
                                                    <div class="modal-header">
                                                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                        <h4 class="modal-title" id="ModalLabel">发布新公告</h4>
                                                    </div>
                                                    <div class="modal-body">
                                                        <div class="panel panel-default">
                                                            <div class="form-group col-md-12">
                                                                <label for="title" class="col-md-12">公告标题</label>
                                                                <input type="text" class="form-control " style="width: 100%"  id="title" name="title"
                                                                       placeholder="公告标题">
                                                            </div>
                                                            <div class="form-group col-md-12">
                                                                <label for="content" class="col-md-12 ">公告内容</label>
                                                                <textarea class="form-control " style="width: 100%;resize: none" id="content" rows="5"   name="content"
                                                                          placeholder="公告内容" ></textarea>
                                                                <div class="col-md-12 " style="padding: 2px"></div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="modal-footer">
                                                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                                        <button type="submit" class="btn btn-primary" >提交</button>
                                                    </div>
                                                </div><!-- /.modal-content -->
                                            </div><!-- /.modal -->
                                        </div>
                                        <!-- 模态框（Modal） -->
                                        </security:authorize>
                                        <button type="button" class="btn btn-default" title="刷新" onclick="location.reload();">
                                            <i class="fa fa-refresh" ></i>刷新
                                        </button>
                                    </form>
                                </div>
                            </div>
                        </div>

                        <!--工具栏/-->
                        <!--数据列表-->
                        <table id="dataList"
                               class="table table-bordered table-striped table-hover dataTable">
                            <thead>
                            <tr>
                                <th class="sorting_asc">序号</th>
                                <th class="sorting">公告标题</th>
                                <th class="sorting">发布时间</th>
                                <security:authorize access="hasRole('ROLE_ADMIN')">
                                <th class="sorting">操作</th>
                                </security:authorize>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${pageInfo.list}" var="notice" varStatus="v">
                                <tr>
                                    <td >${v.index+1}</td>
                                    <td>${notice.title}</td>
                                    <td>${notice.create_timeStr}</td>

                                    <td class="text-center">
                                        <form action="/notice/update.do" method="post">
                                            <input type="hidden" name="pid" value="${notice.nid}">
                                        <button type="button" class="btn bg-olive btn-xs" data-toggle="modal" data-target="#myModal${notice.nid}">查看公告</button>
                                        <!-- 模态框（Modal） -->
                                        <div class="modal fade" id="myModal${notice.nid}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                            <div class="modal-dialog">
                                                <div class="modal-content">
                                                    <div class="modal-header">
                                                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                        <h4 class="modal-title" id="myModalLabel">查看公告</h4>
                                                    </div>
                                                    <div class="modal-body">
                                                        <div class="panel panel-default">
                                                            <%--公告标题--%>
                                                            <div class="form-group col-md-12">
                                                                <label class="col-md-12 label-danger "><h4>${notice.title}</h4></label>
                                                            </div>
                                                            <%--公告标题--%>

                                                            <%--公告内容--%>
                                                            <div class="form-group col-md-12">
                                                                <textarea class="form-control " style="width: 100%;resize: none" id="des" rows="8"   name="description"
                                                                          placeholder="公告内容" readonly>${notice.content}</textarea>
                                                                <div class="col-md-12 " style="padding: 2px"></div>
                                                            </div>
                                                           <%--公告内容--%>

                                                            <%--作者、日期--%>
                                                            <div class="form-group col-md-12">
                                                                <label class="col-md-12 right">${notice.userInfo.username}</label>
                                                                <label class="col-md-12 right">${notice.create_timeStr}</label>
                                                            </div>
                                                            <%--作者、日期--%>
                                                        </div>
                                                    </div>
                                                    <div class="modal-footer">
                                                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                                    </div>
                                                </div><!-- /.modal-content -->
                                            </div><!-- /.modal -->
                                        </div>
                                        <!-- 模态框（Modal） -->
                                            <security:authorize access="hasRole('ROLE_ADMIN')">
                                            <button name="bt_delete" type="button" class="btn bg-olive btn-xs" onclick="deleteNotice(${notice.nid});">删除</button>
                                            </security:authorize>
                                        </form>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>

                        <!--数据列表/-->

                    </div>
                    <!-- 数据表格 /-->

                </div>
                <!-- /.box-body -->

                <!-- .box-footer-->
                <div class="box-footer">
                    <div class="pull-left">
                        <div class="form-group form-inline">
                            总共${pageInfo.pages}页，共${pageInfo.total} 条数据。 每页
                            <select class="form-control" id="changePageSize" onchange="changeSize()" >
                                <option >页数</option>
                                <option value="5" ${pageInfo.pageSize == 5?'selected':'' }>5</option>
                                <option value="10" ${pageInfo.pageSize == 10?'selected':'' }>10</option>
                                <option value="20" ${pageInfo.pageSize == 20?'selected':'' }>20</option>
                                <option value="50" ${pageInfo.pageSize == 50?'selected':'' }>50</option>
                                <option value="100" ${pageInfo.pageSize == 100?'selected':'' }>100</option>
                            </select> 条
                        </div>
                    </div>

                    <div class="box-tools pull-right">
                        <ul class="pagination">
                            <li>
                                <a href="${pageContext.request.contextPath}/notice/findAll.do?status=1&pageNum=1&pageSize=${pageInfo.pageSize}" aria-label="Previous">首页</a>
                            </li>
                            <li><a href="${pageContext.request.contextPath}/notice/findAll.do?status=1&pageNum=${pageInfo.pageNum-1}&pageSize=${pageInfo.pageSize}">上一页</a></li>
                            <c:forEach begin="${pageInfo.firstPage}" end="${pageInfo.pages}" var="pageNum">
                                <li class="${pageInfo.pageNum == pageNum?'active':''}" ><a href="${pageContext.request.contextPath}/notice/findAll.do?status=1&pageNum=${pageNum}&pageSize=${pageInfo.pageSize}">${pageNum}</a></li>
                            </c:forEach>
                            <li><a href="${pageContext.request.contextPath}/notice/findAll.do?status=1&pageNum=${pageInfo.pageNum+1}1&pageSize=${pageInfo.pageSize}">下一页</a></li>
                            <li>
                                <a href="${pageContext.request.contextPath}/notice/findAll.do?status=1&pageNum=${pageInfo.pages}&pageSize=${pageInfo.pageSize}" aria-label="Next">尾页</a>
                            </li>
                        </ul>
                    </div>

                </div>
                <!-- /.box-footer-->
            </div>

        </section>
        <!-- 正文区域 /-->

    </div>
    <!-- @@close -->
    <!-- 内容区域 /-->

    <!-- 底部导航 -->
    <jsp:include page="footer.jsp"/>
    <!-- 底部导航 /-->

</div>

<script src="../plugins/jQuery/jquery-2.2.3.min.js"></script>
<script src="../plugins/jQueryUI/jquery-ui.min.js"></script>
<script>
    $.widget.bridge('uibutton', $.ui.button);
</script>
<script src="../plugins/bootstrap/js/bootstrap.min.js"></script>
<script src="../plugins/raphael/raphael-min.js"></script>
<script src="../plugins/morris/morris.min.js"></script>
<script src="../plugins/sparkline/jquery.sparkline.min.js"></script>
<script src="../plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script src="../plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<script src="../plugins/knob/jquery.knob.js"></script>
<script src="../plugins/daterangepicker/moment.min.js"></script>
<script src="../plugins/daterangepicker/daterangepicker.js"></script>
<script src="../plugins/daterangepicker/daterangepicker.zh-CN.js"></script>
<script src="../plugins/datepicker/bootstrap-datepicker.js"></script>
<script src="../plugins/datepicker/locales/bootstrap-datepicker.zh-CN.js"></script>
<script src="../plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<script src="../plugins/slimScroll/jquery.slimscroll.min.js"></script>
<script src="../plugins/fastclick/fastclick.js"></script>
<script src="../plugins/iCheck/icheck.min.js"></script>
<script src="../plugins/adminLTE/js/app.min.js"></script>
<script src="../plugins/treeTable/jquery.treetable.js"></script>
<script src="../plugins/select2/select2.full.min.js"></script>
<script src="../plugins/colorpicker/bootstrap-colorpicker.min.js"></script>
<script src="../plugins/bootstrap-wysihtml5/bootstrap-wysihtml5.zh-CN.js"></script>
<script src="../plugins/bootstrap-markdown/js/bootstrap-markdown.js"></script>
<script src="../plugins/bootstrap-markdown/locale/bootstrap-markdown.zh.js"></script>
<script src="../plugins/bootstrap-markdown/js/markdown.js"></script>
<script src="../plugins/bootstrap-markdown/js/to-markdown.js"></script>
<script src="../plugins/ckeditor/ckeditor.js"></script>
<script src="../plugins/input-mask/jquery.inputmask.js"></script>
<script src="../plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
<script src="../plugins/input-mask/jquery.inputmask.extensions.js"></script>
<script src="../plugins/datatables/jquery.dataTables.min.js"></script>
<script src="../plugins/datatables/dataTables.bootstrap.min.js"></script>
<script src="../plugins/chartjs/Chart.min.js"></script>
<script src="../plugins/flot/jquery.flot.min.js"></script>
<script src="../plugins/flot/jquery.flot.resize.min.js"></script>
<script src="../plugins/flot/jquery.flot.pie.min.js"></script>
<script src="../plugins/flot/jquery.flot.categories.min.js"></script>
<script src="../plugins/ionslider/ion.rangeSlider.min.js"></script>
<script src="../plugins/bootstrap-slider/bootstrap-slider.js"></script>
<script>

    function deleteNotice(nid){
        if (confirm("您确定要删除吗？")) {
            location.href='${pageContext.request.contextPath}/notice/delete.do?nid='+nid;
        }
    }

    //当页面显示数据条数发生改变时触发
    function changeSize() {
        //获取下拉框的值
        var pageSize = $("#changePageSize").val();
        //向服务器发送请求，改变没页显示条数
        location.href = "${pageContext.request.contextPath}/notice/findAll.do?status=1&pageNum=1&pageSize="
            + pageSize;
    }

    //提示操作是否成功
    $(document).ready(function () {

        var msgInfo = "${msgInfo}";

        if (msgInfo !=null && msgInfo.length>0){
            alert(msgInfo);
            location.reload();
        }
    })
    $(document).ready(function () {
        /*table tree*/
        $("#collapse-table").treetable({
            expandable: true
        });
        // 选择框
        $(".select2").select2();

        // WYSIHTML5编辑器
        $(".textarea").wysihtml5({
            locale: 'zh-CN'
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
        setSidebarActive("form-notice");

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