<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: ouyang
  Date: 2019/10/14
  Time: 21:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!-- 导航侧栏 -->
<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- Sidebar user panel -->
        <div class="user-panel">
            <div class="pull-left image">
                <img src="../img/user2-160x160.jpg" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
                <p><security:authentication property="principal.username"/></p>
                <a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
            </div>
        </div>

        <!-- sidebar menu: : style can be found in sidebar.less -->
        <ul class="sidebar-menu">
            <li class="header">菜单</li>

            <li id="admin-index"><a href="${pageContext.request.contextPath}/notice/main.do"><i class="fa fa-home"></i> <span>首页</span></a></li>

            <!-- 菜单 -->
            <security:authorize access="hasAnyRole('ROLE_USER','ROLE_LEADER')">
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-edit"></i> <span>我的资料</span>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>
                <ul class="treeview-menu">

                    <li id="form-iuser">
                        <a href="${pageContext.request.contextPath}/user/details.do?uid=${login_user.uid}&status=0">
                            <i class="fa fa-circle-o"></i> 个人信息
                        </a>
                    </li>
                </ul>
            </li>

            <li class="treeview">
                <a href="#">
                    <i class="fa fa-edit"></i> <span>培训记录</span>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>
                <ul class="treeview-menu">

                    <li id="form-mycul">
                        <a href="${pageContext.request.contextPath}/cultivate/userCul.do?uid=${login_user.uid}">
                            <i class="fa fa-circle-o"></i> 我的培训
                        </a>
                    </li>

                </ul>
            </li>

            <li class="treeview">
                <a href="#">
                    <i class="fa fa-edit"></i> <span>荣誉记录</span>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>
                <ul class="treeview-menu">
                    <security:authorize access="hasAnyRole('ROLE_USER')">
                    <li id="form-ach_apply">
                        <a href="${pageContext.request.contextPath}/achievement/findAll.do?status=1">
                            <i class="fa fa-circle-o"></i> 申请荣誉
                        </a>
                    </li> <li id="form-ach_rec">
                        <a href="${pageContext.request.contextPath}/opinion/findRec.do?uid=${login_user.uid}">
                            <i class="fa fa-circle-o"></i> 申请记录
                        </a>
                    </li>
                    <li id="form-my_ach">
                        <a href="${pageContext.request.contextPath}/opinion/findPass.do?uid=${login_user.uid}">
                            <i class="fa fa-circle-o"></i> 已获荣誉
                        </a>
                    </li>
                    </security:authorize>
                <security:authorize access="hasAnyRole('ROLE_LEADER')">
                <li id="form-dept_apply">
                        <a href="${pageContext.request.contextPath}/opinion/findDeptRecN.do?uid=${login_user.uid}">
                            <i class="fa fa-circle-o"></i> 申请审批
                        </a>
                    </li>
                </security:authorize>
                </ul>
            </li>

            <li class="treeview">
                <a href="#">
                    <i class="fa fa-edit"></i> <span>合同记录</span>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>
                <ul class="treeview-menu">
                    <li id="form-ctr">
                        <a href="${pageContext.request.contextPath}/contract/findOne.do?uid=${login_user.uid}">
                            <i class="fa fa-circle-o"></i>我的合同
                        </a>
                    </li>
                </ul>
            </li>
                <li class="treeview">
                <a href="#">
                    <i class="fa fa-edit"></i> <span>档案记录</span>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>
                <ul  class="treeview-menu">
                <li id="form-myfile">
                    <a href="${pageContext.request.contextPath}/file/findOne.do?fid=${login_user.userFile.fid}&status=0">
                        <i class="fa fa-circle-o"></i> 个人档案
                    </a>
                </li>
                </ul>
            </li>

            <li class="treeview">
                <a href="#">
                    <i class="fa fa-edit"></i> <span>查看公告</span>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>
                <ul class="treeview-menu">
                    <li id="form-noticeView">
                        <a href="${pageContext.request.contextPath}/notice/findAll.do?status=1">
                            <i class="fa fa-circle-o"></i> 往期公告
                        </a>
                    </li>
                </ul>
            </li>
            </security:authorize>

            <security:authorize access="hasRole('ROLE_ADMIN')">
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-edit"></i> <span>系统管理</span>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>
                <ul class="treeview-menu">

                    <li id="form-user">
                        <a href="${pageContext.request.contextPath}/user/findAll.do">
                            <i class="fa fa-circle-o"></i> 用户管理
                        </a>
                    </li>

                    <li id="form-role">
                        <a href="${pageContext.request.contextPath}/role/findAll.do">
                            <i class="fa fa-circle-o"></i> 角色管理
                        </a>
                    </li>

                    <li id="form-department">
                        <a href="${pageContext.request.contextPath}/department/findAll.do">
                            <i class="fa fa-circle-o"></i> 部门管理
                        </a>
                    </li>

                    <li id="form-position">
                        <a href="${pageContext.request.contextPath}/position/findAll.do">
                            <i class="fa fa-circle-o"></i> 职位管理
                        </a>
                    </li>

                    <li id="form-notice">
                        <a href="${pageContext.request.contextPath}/notice/findAll.do">
                            <i class="fa fa-circle-o"></i> 公告管理
                        </a>
                    </li>
                    <li id="form-a_o" class="treeview">
                        <a href="javascript:void(0)">
                            <i class="fa fa-circle-o"></i> <span>荣誉管理</span>
                            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                        </a>
                        <ul class="treeview-menu">
                            <li id="form-achievement"><a href="${pageContext.request.contextPath}/achievement/findAll.do"><i class="fa fa-circle-o"></i> 奖项设置</a></li>
                            <li id="form-opinion"><a href="${pageContext.request.contextPath}/opinion/findAll.do"><i class="fa fa-circle-o"></i> 审批列表</a></li>
                        </ul>
                    </li>

                    <li id="form-cul">
                        <a href="${pageContext.request.contextPath}/cultivate/findAll.do">
                            <i class="fa fa-circle-o"></i> 培训管理
                        </a>
                    </li>

                    <li id="form-contract">
                        <a href="${pageContext.request.contextPath}/contract/findAll.do">
                            <i class="fa fa-circle-o"></i> 合同管理
                        </a>
                    </li>

                    <li id="form-file">
                        <a href="${pageContext.request.contextPath}/file/findAll.do">
                            <i class="fa fa-circle-o"></i> 档案管理
                        </a>
                    </li>

                </ul>
            </li>



            <li class="treeview">
                <a href="#">
                    <i class="fa fa-table"></i> <span>系统数据</span>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>
                <ul class="treeview-menu">

                    <li id="form-log">
                        <a href="${pageContext.request.contextPath}/log/findAll.do">
                            <i class="fa fa-circle-o"></i> 访问日志
                        </a>
                    </li>

                </ul>
            </li>
            </security:authorize>
        </ul>
    </section>
    <!-- /.sidebar -->
</aside>
<!-- 导航侧栏 /-->
