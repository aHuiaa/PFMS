<%--
  Created by IntelliJ IDEA.
  User: ouyang
  Date: 2019/10/15
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- @@master = admin-layout.html-->
<!-- @@block = content -->


<!DOCTYPE html>
<html>

<head>
    <!-- 页面meta -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <title>添加档案</title>

    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">

    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>

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

    <div class="content-wrapper">

        <!-- 内容头部 -->
        <section class="content-header">
            <h1>
                系统管理
                <small>档案管理</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="${pageContext.request.contextPath}/notice/main.do"><i
                        class="fa fa-dashboard"></i> 首页</a></li>
                <li><a href="#">系统管理</a></li>
                <li><a href="${pageContext.request.contextPath}/file/findAll.do">档案管理</a></li>
                <li class="active">档案添加</li>
            </ol>
        </section>
        <!-- 内容头部 /-->

        <!-- 正文区域 -->
        <section class="content">

            <!-- .box-body -->
            <div class="box box-primary">
                <div class="box-header with-border">
                    <h3 class="box-title">档案添加</h3>
                </div>

                <div class="box-body">

                    <!-- 数据表格 -->
                    <div class="table-box">
                        <!--数据列表-->
                        <form action="/file/add.do" method="post">
                        <table id="dataList" class="table table-bordered table-striped table-hover dataTable">

                            <th rowspan="7" class="col-lg-1 text-center">基本信息</th>
                            <tr>
                                <th class="col-lg-1 text-center">用户账号</th>
                                <td class="col-lg-1 ">
                                    <input type="text" name="userInfo.username">
                                </td>
                                <th class="col-lg-1 text-center">性别</th>
                                <td class="col-lg-1 ">
                                    <div class="form-group">
                                    <input type="radio" name="gender" value="男" checked>男
                                    <input type="radio" name="gender" value="女">女
                                    </div>
                                </td>
                                <th class="col-lg-1 text-center">民族</th>
                                <td class="col-lg-1 "><input name="people" type="text"> </td>
                            </tr>
                            <tr>
                                <th class="col-lg-1 text-center">出生日期</th>
                                <td><input type="date" name="birthday"></td>
                                <th class="col-lg-1 text-center">身份证号</th>
                                <td colspan="3"> <input type="text" name="id" > </td>
                            </tr>
                            <tr>
                                <th class="col-lg-1 text-center">政治面貌</th>
                                <td>
                                    <input name="politics" type="radio" value="中共党员" checked>中共党员
                                    <input name="politics" type="radio" value="共青团员">共青团员
                                    <input name="politics" type="radio" value="群众">群众
                                    <input name="politics" type="radio" value="其他">其他
                                </td>
                                <th class="col-lg-1 text-center">婚姻状况</th>
                                <td>
                                    <div class="form-group">
                                    <input name="marital_status" type="radio" value="已婚" checked>已婚
                                    <input name="marital_status" type="radio" value="未婚">未婚
                                    </div>
                                </td>
                                <th class="col-lg-1 text-center">学历</th>
                                <td><input name="education" type="text"> </td>
                            </tr>
                            <tr>
                                <th class="col-lg-1 text-center">毕业学校</th>
                                <td colspan="2"><input name="school" type="text" style="width: 350px"> </td>
                                <th class="col-lg-1 text-center">专业</th>
                                <td colspan="2"><input name="specialty" type="text" style="width: 350px"> </td>
                            </tr>
                            <tr>
                                <th class="col-lg-1 text-center">户口所在地</th>
                                <td><input name="hk_adr" type="text"></td>
                                <th class="col-lg-1 text-center">籍贯</th>
                                <td><input name="census_register" type="text"></td>
                                <th class="col-lg-1 text-center">户口性质</th>
                                <td>
                                    <div class="form-group">
                                        <input name="hk_type" type="radio" value="城镇户口" checked>城镇户口
                                        <input name="hk_type" type="radio" value="农村户口">农村户口
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <th class="col-lg-1 text-center">家庭住址</th>
                                <td colspan="3"><input name="address" type="text" style="width: 650px" > </td>
                                <th class="col-lg-1 text-center">邮政编码</th>
                                <td><input name="postcode" type="text"></td>
                            </tr>
                            <tr>
                                <th class="col-lg-1 text-center">聘用形式</th>
                                <td colspan="2">
                                    <div class="form-group">
                                    <input name="source" type="radio" value="网络招聘" checked>网络招聘
                                    <input name="source" type="radio" value="内部推荐">内部推荐
                                    </div>
                                </td>
                                <th></th>
                                <td colspan="2"> </td>
                            </tr>
                        </table>

                        <!--数据列表/-->
                        <!--工具栏-->
                        <div class="box-tools text-center">
                            <button type="submit" class="btn bg-maroon">保存</button>
                            <button type="button" class="btn bg-default"
                                    onclick="history.back(-1);">返回</button>
                        </div>
                        </form>
                    </div>
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
        setSidebarActive("form-file");

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