<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>后台管理系统</title>
    
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/admin-all.css" />
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/base.css" />
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/ui-lightness/jquery-ui-1.8.22.custom.css" />
    
    <script type="text/javascript" src="<%=path%>/js/jquery-1.7.2.js"></script>
    <script type="text/javascript" src="<%=path%>/js/jquery-ui-1.8.22.custom.min.js"></script>
    <script type="text/javascript" src="<%=path%>/js/index.js"></script>
</head>
<body>
    <div class="warp">
        <!--头部开始-->
        <div class="top_c">
            <div class="top-menu">
                <ul class="top-menu-nav">
                    <li><a href="#">首页</a></li>
                    <li><a href="#">营销管理<i class="tip-up"></i></a>
                        <ul class="kidc">
                            <li><a target="Conframe" href="<%=path%>/jsp/chanceMng.jsp">销售机会管理</a></li>
                            <li><a target="Conframe" href="<%=path%>/jsp/Custmer.jsp">客户开发计划</a></li>
                        </ul>
                    </li>
                    <li><a href="#">客户管理<i class="tip-up"></i></a>
                        <ul class="kidc">
                            <li><b class="tip"></b><a target="Conframe" href="Template/Maintain-add.html">客户信息管理</a></li>
                            <li><b class="tip"></b><a target="Conframe" href="Template/Maintain-edit.html">客户流失管理</a></li>
                        </ul>
                    </li>
                    <li><a href="#">服务管理<i class="tip-up"></i></a>
                        <ul class="kidc">
                            <li><b class="tip"></b><a target="Conframe" href="Template/form-Master-slave.html">服务创建</a></li>
                            <li><b class="tip"></b><a target="Conframe" href="Template/form-collapse.html">服务分配</a></li>
                            <li><b class="tip"></b><a target="Conframe" href="Template/form-tabs.html">服务处理</a></li>
                            <li><b class="tip"></b><a target="Conframe" href="Template/form-tree.html">服务反馈</a></li>
                            <li><b class="tip"></b><a target="Conframe" href="Template/form-guide.html">服务归档</a></li>
                        </ul>
                    </li>
                    <li><a href="#">统计报表<i class="tip-up"></i></a>
                        <ul class="kidc">
                        <li><b class="tip"></b><a target="Conframe" href="Template/Alert.html">客户贡献管理</a></li>
                        <li><b class="tip"></b><a target="Conframe" href="Template/Alert.html">客户构成分析</a></li>
                        <li><b class="tip"></b><a target="Conframe" href="Template/Alert.html">客户服务分析</a></li>
                        <li><b class="tip"></b><a target="Conframe" href="Template/Alert.html">客户流失分析</a></li>
                    </ul>
                    </li>
                    <li><a href="#">基础数据<i class="tip-up"></i></a>
                        <ul class="kidc">
                        <li><b class="tip"></b><a target="Conframe" href="Template/order.html">采购订单</a></li>
                        <li><b class="tip"></b><a target="Conframe" href="Template/formstyle.html">数据说明</a></li>
                        <li><b class="tip"></b><a target="Conframe" href="Template/formstyle.html">操作记录</a></li>
                        <li><b class="tip"></b><a target="Conframe" href="Template/formstyle.html">提示</a></li>
                    </ul>
                    </li>
                    <li><a href="#">权限管理<i class="tip-up"></i></a>
                        <ul class="kidc">
                        <li><b class="tip"></b><a target="Conframe" href="Template/order.html">采购订单</a></li>
                        <li><b class="tip"></b><a target="Conframe" href="Template/formstyle.html">数据说明</a></li>
                        <li><b class="tip"></b><a target="Conframe" href="Template/formstyle.html">操作记录</a></li>
                        <li><b class="tip"></b><a target="Conframe" href="Template/formstyle.html">提示</a></li>
                    </ul>
                    </li>
                </ul>
            </div>
            <div class="top-nav">上午好，欢迎您，${sysUser.sysRole.roleName}： ${sysUser.userName}！&nbsp;&nbsp;<a href="<%=path%>/user/editPwd.action">修改密码</a> | <a href="<%=path%>/user/exit.action">注销</a></div>
        </div>
        <!--头部结束-->
        <!--左边菜单开始-->
        <div class="left_c left">
            <h1>客户关系管理系统</h1>
            <div class="acc">
                <div>
                    <a class="one">营销管理</a>
                    <ul class="kid">
                        <li><b class="tip"></b><a target="Conframe" href="<%=path%>/jsp/chanceMng.jsp">销售机会管理</a></li>
                        <li><b class="tip"></b><a target="Conframe" href="<%=path%>/jsp/Custmer.jsp">客户开发计划</a></li>
                    </ul>
                </div>
                <div>
                    <a class="one">客户管理</a>
                    <ul class="kid">
                        <li><b class="tip"></b><a target="Conframe" href="Template/Maintain-add.html">客户信息管理</a></li>
                        <li><b class="tip"></b><a target="Conframe" href="Template/Maintain-edit.html">客户流失管理</a></li>
                    </ul>
                </div>
                <div>
                    <a class="one">服务管理</a>
                    <ul class="kid">
                        <li><b class="tip"></b><a target="Conframe" href="Template/form-Master-slave.html">服务创建</a></li>
                        <li><b class="tip"></b><a target="Conframe" href="Template/form-collapse.html">服务分配</a></li>
                        <li><b class="tip"></b><a target="Conframe" href="Template/form-tabs.html">服务处理</a></li>
                        <li><b class="tip"></b><a target="Conframe" href="Template/form-tree.html">服务反馈</a></li>
                        <li><b class="tip"></b><a target="Conframe" href="Template/form-guide.html">服务归档</a></li>
                    </ul>
                </div>
                <div>
                    <a class="one">统计报表</a>
                    <ul class="kid">
                        <li><b class="tip"></b><a target="Conframe" href="Template/Alert.html">客户贡献分析</a></li>
                        <li><b class="tip"></b><a target="Conframe" href="Template/Alert.html">客户构成分析</a></li>
                        <li><b class="tip"></b><a target="Conframe" href="Template/Alert.html">客户服务分析</a></li>
                        <li><b class="tip"></b><a target="Conframe" href="Template/Alert.html">客户流失分析</a></li>
                    </ul>
                </div>
                <div>
                    <a class="one">基础数据</a>
                    <ul class="kid">
                        <li><b class="tip"></b><a target="Conframe" href="Template/order.html">采购订单</a></li>
                        <li><b class="tip"></b><a target="Conframe" href="Template/formstyle.html">数据说明</a></li>
                        <li><b class="tip"></b><a target="Conframe" href="Template/formstyle.html">操作记录</a></li>
                        <li><b class="tip"></b><a target="Conframe" href="Template/formstyle.html">提示</a></li>
                    </ul>
                </div>
                <div>
                    <a class="one">权限管理</a>
                    <ul class="kid">
                        <li><b class="tip"></b><a target="Conframe" href="Template/order.html">采购订单</a></li>
                        <li><b class="tip"></b><a target="Conframe" href="Template/formstyle.html">数据说明</a></li>
                        <li><b class="tip"></b><a target="Conframe" href="Template/formstyle.html">操作记录</a></li>
                        <li><b class="tip"></b><a target="Conframe" href="Template/formstyle.html">提示</a></li>
                    </ul>
                </div>
                <div id="datepicker"></div>
            </div>

        </div>
        <!--左边菜单结束-->
        <!--右边框架开始-->
        <div class="right_c">
            <div class="nav-tip" onclick="javascript:void(0)">&nbsp;</div>

        </div>
        <div class="Conframe">
            <iframe name="Conframe" id="Conframe"></iframe>
        </div>
        <!--右边框架结束-->

        <!--底部开始-->
        <div class="bottom_c">Copyright &copy;第二小组 版权所有</div>
        <!--底部结束-->
    </div>
</body>
</html>