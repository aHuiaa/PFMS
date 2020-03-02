<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <!-- 页面meta -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <title>荣誉审批列表</title>

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
                荣誉管理
                <small>审批列表</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="${pageContext.request.contextPath}/notice/main.do"><i class="fa fa-dashboard"></i> 首页</a></li>

                <li><a href="#">荣誉管理</a></li>

                <li class="active">审批列表</li>
            </ol>
        </section>
        <!-- 内容头部 /-->

        <!-- 正文区域  职位-->
        <section class="content"> <!-- .box-body -->
            <div class="box box-primary">
                <div class="box-header with-border">
                    <h3 class="box-title">列表</h3>
                </div>

                <div class="box-body">

                    <!-- 数据表格 -->
                    <div class="table-box">

                        <!--工具栏-->
                        <div class="pull-left">
                            <div class="form-group form-inline">
                                <div class="btn-group">
                                    <form action="/opinion/add.do" method="post">
                                        <!-- 按钮触发模态框 -->
                                        <button type="button" class="btn btn-default" data-toggle="modal" data-target="#Modal">
                                            <i class="fa fa-file-o"></i> 新建
                                        </button>
                                        <!-- 模态框（Modal） -->
                                        <div class="modal fade" id="Modal" tabindex="-1" role="dialog" aria-labelledby="ModalLabel" aria-hidden="true">
                                            <div class="modal-dialog">
                                                <div class="modal-content">
                                                    <div class="modal-header">
                                                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                        <h4 class="modal-title" id="ModalLabel">申请奖项</h4>
                                                    </div>
                                                    <div class="modal-body">
                                                        <div class="panel panel-default">
                                                            <div class="form-group col-md-12">
                                                                <label for="ach_name" class="col-md-12">奖项名称</label>
                                                                <input type="text" class="form-control " style="width: 100%"  id="ach_name" name="achievement.ach_name"
                                                                       placeholder="奖项名称">
                                                            </div>
                                                            <div class="form-group col-md-12">
                                                                <label for="username" class="col-md-12">申请用户账号</label>
                                                                <input type="text" class="form-control " style="width: 100%"  id="username" name="userInfo.username"
                                                                       placeholder="申请用户账号">
                                                            </div>
                                                            <div class="form-group col-md-12">
                                                                <label for="reason" class="col-md-12 ">申请理由</label>
                                                                <textarea class="form-control " style="width: 100%;resize: none" id="reason" rows="5"   name="reason"
                                                                          placeholder="申请理由" ></textarea>
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
                                <th class="sorting">申请用户</th>
                                <th class="sorting">奖项名称</th>
                                <th class="sorting">申请时间</th>
                                <th class="sorting">审批结果</th>
                                <th class="sorting">审批人</th>
                                <th class="sorting">操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${pageInfo.list}" var="ach" varStatus="v">
                                <tr>
                                    <td >${v.index+1}</td>
                                    <td>${ach.userInfo.uname}</td>
                                    <td>${ach.achievement.ach_name}</td>
                                    <td>${ach.a_timeStr}</td>
                                    <td>${ach.opinion}</td>
                                    <td>${ach.approver}</td>
                                    <td class="text-center">
                                        <form action="/opinion/update.do" method="post">
                                            <input type="hidden" name="oid" value="${ach.oid}">
                                            <input type="hidden" name="userInfo.uid" value="${login_user.uid}">
                                        <button type="button" class="btn bg-olive btn-xs" data-toggle="modal" data-target="#myModal${ach.oid}">查看申请</button>
                                        <!-- 模态框（Modal） -->
                                        <div class="modal fade" id="myModal${ach.oid}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                            <div class="modal-dialog">
                                                <div class="modal-content">
                                                    <div class="modal-header">
                                                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                        <h4 class="modal-title" id="myModalLabel">查看奖项申请</h4>
                                                    </div>
                                                    <div class="modal-body">
                                                        <div class="panel panel-default">
                                                            <div class="form-group col-md-12">
                                                                <label for="ach_name1" class="col-md-12">申请奖项名称</label>
                                                                <input type="text" class="form-control " style="width: 100%"  id="ach_name1" name="ach_name"
                                                                       placeholder="奖项名称" value="${ach.achievement.ach_name}" readonly>
                                                            </div>
                                                            <div class="form-group col-md-12">
                                                                <label for="reason1" class="col-md-12 ">申请理由</label>
                                                                <textarea class="form-control " style="width: 100%;resize: none" id="reason1" rows="3"   name="reason"
                                                                          placeholder="申请理由" readonly="readonly" >${ach.reason}</textarea>
                                                                <div class="col-md-12 " style="padding: 2px"></div>
                                                            </div>
                                                            <div class="form-group col-md-12">
                                                                <label for="opinion1" class="col-md-12 ">审批意见</label>
                                                                <input type="radio" name="opinion" ${ach.opinion=="通过"?'checked':""} value="通过">通过
                                                                <input type="radio" name="opinion" ${ach.opinion=="未通过"?'checked':""} value="未通过">未通过
                                                                <textarea class="form-control " style="width: 100%;resize: none" id="opinion1" rows="2"   name="opinion_content"
                                                                          placeholder="审批意见" >${ach.opinion_content}</textarea>
                                                                <div class="col-md-12 " style="padding: 2px"></div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="modal-footer">
                                                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                                        <button type="submit" class="btn btn-primary" >修改审批意见</button>
                                                    </div>
                                                </div><!-- /.modal-content -->
                                            </div><!-- /.modal -->
                                        </div>
                                        <!-- 模态框（Modal） -->
                                        <button name="bt_delete" type="button" class="btn bg-olive btn-xs" onclick="deleteOpinion(${ach.oid});">删除</button>
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
                                <a href="${pageContext.request.contextPath}/opinion/findAll.do?pageNum=1&pageSize=${pageInfo.pageSize}" aria-label="Previous">首页</a>
                            </li>
                            <li><a href="${pageContext.request.contextPath}/opinion/findAll.do?pageNum=${pageInfo.pageNum-1}&pageSize=${pageInfo.pageSize}">上一页</a></li>
                            <c:forEach begin="${pageInfo.firstPage}" end="${pageInfo.pages}" var="pageNum">
                                <li class="${pageInfo.pageNum == pageNum?'active':''}" ><a href="${pageContext.request.contextPath}/opinion/findAll.do?pageNum=${pageNum}&pageSize=${pageInfo.pageSize}">${pageNum}</a></li>
                            </c:forEach>
                            <li><a href="${pageContext.request.contextPath}/opinion/findAll.do?pageNum=${pageInfo.pageNum+1}1&pageSize=${pageInfo.pageSize}">下一页</a></li>
                            <li>
                                <a href="${pageContext.request.contextPath}/opinion/findAll.do?pageNum=${pageInfo.pages}&pageSize=${pageInfo.pageSize}" aria-label="Next">尾页</a>
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

    function deleteOpinion(oid){
        if (confirm("您确定要删除吗？")) {
            location.href='${pageContext.request.contextPath}/opinion/delete.do?oid='+oid;
        }
    }

    //当页面显示数据条数发生改变时触发
    function changeSize() {
        //获取下拉框的值
        var pageSize = $("#changePageSize").val();
        //向服务器发送请求，改变没页显示条数
        location.href = "${pageContext.request.contextPath}/opinion/findAll.do?pageNum=1&pageSize="
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
        setSidebarActive("form-a_o");

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