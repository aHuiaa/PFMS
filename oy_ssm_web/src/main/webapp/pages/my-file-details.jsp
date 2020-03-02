<%--
  Created by IntelliJ IDEA.
  User: ouyang
  Date: 2019/10/15
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!-- @@master = admin-layout.html-->
<!-- @@block = content -->


<!DOCTYPE html>
<html>

<head>
    <!-- 页面meta -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <title>个人档案</title>

    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">

    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->


    <link rel="stylesheet" href="../plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="../plugins/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="../plugins/ionicons/css/ionicons.min.css">
    <link rel="stylesheet" href="../plugins/iCheck/square/blue.css">
    <link rel="stylesheet" href="../plugins/morris/morris.css">
    <link rel="stylesheet" href="../plugins/jvectormap/jquery-jvectormap-1.2.2.css">
    <link rel="stylesheet" href="../plugins/datepicker/datepicker3.css">
    <link rel="stylesheet" href="../plugins/daterangepicker/daterangepicker.css">
    <link rel="stylesheet" href="../plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
    <link rel="stylesheet" href="../plugins/datatables/dataTables.bootstrap.css">
    <link rel="stylesheet" href="../plugins/treeTable/jquery.treetable.css">
    <link rel="stylesheet" href="../plugins/treeTable/jquery.treetable.theme.default.css">
    <link rel="stylesheet" href="../plugins/select2/select2.css">
    <link rel="stylesheet" href="../plugins/colorpicker/bootstrap-colorpicker.min.css">
    <link rel="stylesheet" href="../plugins/bootstrap-markdown/css/bootstrap-markdown.min.css">
    <link rel="stylesheet" href="../plugins/adminLTE/css/AdminLTE.css">
    <link rel="stylesheet" href="../plugins/adminLTE/css/skins/_all-skins.min.css">
    <link rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="../plugins/ionslider/ion.rangeSlider.css">
    <link rel="stylesheet" href="../plugins/ionslider/ion.rangeSlider.skinNice.css">
    <link rel="stylesheet" href="../plugins/bootstrap-slider/slider.css">
    <link rel="stylesheet" href="../plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.css">
</head>

<body class="hold-transition skin-purple sidebar-mini">

<div class="wrapper">

    <!-- 页面头部 -->
    <jsp:include page="header.jsp"/>
    <!-- 页面头部 /-->

    <!-- 导航侧栏 -->
    <jsp:include page="aside.jsp"/>
    <!-- 导航侧栏 /-->

    <!-- 内容区域 -->
    <!-- @@master = admin-layout.html-->
    <!-- @@block = content -->

    <div class="content-wrapper">

        <!-- 内容头部 -->
        <section class="content-header">
            <h1>
                档案记录
                <small>个人档案</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="${pageContext.request.contextPath}/notice/main.do"><i
                        class="fa fa-dashboard"></i> 首页</a></li>
                <li><a href="#">档案记录</a></li>

                <li class="active">个人档案</li>
            </ol>
        </section>
        <!-- 内容头部 /-->

        <!-- 正文区域 -->
        <section class="content">
            <!-- .box-body -->
            <div class="box box-primary">
                <div class="box-header with-border">
                    <h3 class="box-title">我的档案</h3>
                </div>

                <div class="box-body">
                    <c:if test="${userFile==null}">
                        <f4>暂无档案信息</f4>
                    </c:if>
                    <!-- 数据表格 -->
                    <c:if test="${userFile!=null}">
                    <div class="table-box">

                        <!--工具栏-->
                        <div class="pull-left">
                            <div class="form-group form-inline">
                                <div class="btn-group">
                                    <button type="button" onclick="location.href='${pageContext.request.contextPath}/file/download.do?fid=${userFile.fid}'" class="btn btn-default" title="导出所有用户"><i
                                        class="glyphicon glyphicon-download-alt"></i> 导出档案
                                    </button>
                                </div>
                            </div>
                        </div>
                        <!--工具栏/-->

                        <!--数据列表-->
                        <form action="${pageContext.request.contextPath}/file/update.do" method="post">
                            <input name="fid" type="hidden" value="${userFile.fid}">
                        <table id="dataList" class="table table-bordered table-striped table-hover dataTable">

                            <th rowspan="7" class="col-lg-1 text-center">基本信息</th>
                            <tr>
                                <th class="col-lg-1 text-center">姓名</th>
                                <td class="col-lg-1 text-center">${userFile.userInfo.uname} </td>
                                <th class="col-lg-1 text-center">性别</th>
                                <td class="col-lg-1 text-center"><div class="form-group">${userFile.gender}</div></td>
                                <th class="col-lg-1 text-center">民族</th>
                                <td class="col-lg-1 text-center">${userFile.people}" </td>
                            </tr>
                            <tr>
                                <th class="col-lg-1 text-center">出生日期</th>
                                <td> ${userFile.birthdayStr}</td>
                                <th class="col-lg-1 text-center">身份证号</th>
                                <td colspan="3"> ${userFile.id} </td>
                            </tr>
                            <tr>
                                <th class="col-lg-1 text-center">政治面貌</th>
                                <td>${userFile.politics}</td>
                                <th class="col-lg-1 text-center">婚姻状况</th>
                                <td>${userFile.marital_status}</td>
                                <th class="col-lg-1 text-center">学历</th>
                                <td>${userFile.education}</td>
                            </tr>
                            <tr>
                                <th class="col-lg-1 text-center">毕业学校</th>
                                <td colspan="2">${userFile.school} </td>
                                <th class="col-lg-1 text-center">专业</th>
                                <td colspan="2">${userFile.specialty}</td>
                            </tr>
                            <tr>
                                <th class="col-lg-1 text-center">户口所在地</th>
                                <td>${userFile.hk_adr}</td>
                                <th class="col-lg-1 text-center">籍贯</th>
                                <td>${userFile.census_register}</td>
                                <th class="col-lg-1 text-center">户口性质</th>
                                <td>
                                  ${userFile.hk_type}
                                </td>
                            </tr>
                            <tr>
                                <th class="col-lg-1 text-center">家庭住址</th>
                                <td colspan="3">${userFile.address}</td>
                                <th class="col-lg-1 text-center">邮政编码</th>
                                <td>${userFile.postcode}</td>
                            </tr>
                            <th rowspan="4" class="col-lg-1 text-center">入职情况</th>
                            <tr>
                                <th class="col-lg-1 text-center">所属部门</th>
                                <td colspan="2">${userFile.userInfo.departmentAndPositionList[0].department.department_name}</td>
                                <th class="col-lg-1 text-center">主职务</th>
                                <td colspan="2">${userFile.userInfo.departmentAndPositionList[0].position.position_name}</td>
                            </tr>
                            <tr>
                                <th class="col-lg-1 text-center">入职时间</th>
                                <td colspan="2">${userFile.userInfo.create_timeStr}</td>
                                <th class="col-lg-1 text-center">合同到期时间</th>
                                <td colspan="2">${userFile.userInfo.contractList[0].end_timeStr} </td>
                            </tr>
                            <tr>
                                <th class="col-lg-1 text-center">聘用形式</th>
                                <td colspan="2">
                                    <div class="form-group">
                                       ${userFile.source}
                                    </div>
                                </td>
                                <th></th>
                                <td colspan="2"> </td>
                            </tr>
                            <th rowspan="2" class="col-lg-1 text-center">培训经历</th>
                            <tr>
                                <td colspan="6" height="220px">
                                    <c:forEach items="${userFile.userInfo.userCultivateList}" var="cultivate" varStatus="v">
                                        ${v.index+1}.&nbsp;${cultivate.cultivate.cul_name}&nbsp;&nbsp;&nbsp;&nbsp;${cultivate.cultivate.start_timeStr}——${cultivate.cultivate.end_timeStr}<br>
                                    </c:forEach>
                                </td>
                            </tr>
                            <th rowspan="2" class="col-lg-1 text-center">成就</th>
                            <tr>
                                <td colspan="6" height="220px">
                                    <c:forEach items="${userFile.userInfo.achievementOpinionList}" var="ach" varStatus="v">
                                        ${v.index+1}.&nbsp;${ach.achievement.ach_name}&nbsp;&nbsp;&nbsp;&nbsp;${ach.o_timeStr}<br>
                                    </c:forEach>
                                </td>
                            </tr>
                        </table>
                        <!--数据列表/-->
                        </form>
                    </div>
                    </c:if>
                    <!-- 数据表格 /-->
                </div>
                <!-- /.box-body -->
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
<script src="../plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.js"></script>
<script src="../plugins/bootstrap-datetimepicker/locales/bootstrap-datetimepicker.zh-CN.js"></script>

<script>
    //当页面显示数据条数发生改变时触发
    function changeSize() {
        //获取下拉框的值
        var pageSize = $("#changePageSize").val();
        //向服务器发送请求，改变没页显示条数
        location.href = "${pageContext.request.contextPath}/user/findAll.do?pageNum=1&pageSize="
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
        setSidebarActive("form-myfile");

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