<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
  <head>
    <title>CRM后台管理系统</title>
    <!-- 页面样式 -->
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/base.css" />
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/admin-all.css" />
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/bootstrap.min.css" />
    
    <!-- 页面脚本 -->
    <script type="text/javascript" src="<%=path%>/js/jquery-1.7.2.js"></script>
    <script type="text/javascript" src="<%=path%>/js/jquery.spritely-0.6.js"></script>
    <script type="text/javascript" src="<%=path%>/js/chur.min.js"></script>
    
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/login.css" />
    <script type="text/javascript">
        $(function () {
            $('#clouds').pan({ fps: 20, speed: 0.7, dir: 'right', depth: 10 });
            
            $('form').submit(function(){
            	if ($('#userName').val() == "" || $('#pwd').val() == "" ) 
                { 
                	$('.tip').html('用户名,密码不可为空！') ;
                	return false;
                }else if ($('#code').val() == ""){
                	$('.tip').html('验证码不可为空！') ;
                	return false;
                }else{
                	return true;
                }
               
            });
        });
        function changeCode(){
        	$(".imgCode").attr("src","user/getCode.action?v="+Math.random());
        }
    </script>
</head>
<body>
    <div id="clouds" class="stage"></div>
    <div class="loginmain">
    </div>

    <div class="row-fluid">
        <form action="<%=path%>/user/login.action" method="post">
        	<h1>CRM后台管理系统</h1>
	        <p>
	            <label>帐&nbsp;&nbsp;&nbsp;号：<input type="text" id="userName" name="userName" /></label>
	        </p>
	        <p>
	            <label>密&nbsp;&nbsp;&nbsp;码：<input type="password" id="pwd" name="userPassword" /></label>
	        </p>
	        <p class="pcode">
	            <label>验证码：<input type="text" id="code" maxlength="5" class="code" name="code"/><img src="<%=path%>/user/getCode.action" alt="验证码" width="80" height="25" class="imgCode" /><a href="#" onclick="changeCode()">刷新</a></label>
	        </p>
	        <p class="tip">&nbsp;${requestScope.errInfo}</p>
	        <hr />
	        <input type="submit" value=" 登 录 " class="btn btn-primary btn-large login" />
	        &nbsp;&nbsp;&nbsp;<input type="button" value=" 取 消 " class="btn btn-large" />
        </form>
    </div>
</body>
</html>
