<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>

<!DOCTYPE html>
<html>
<head>

<title>登陆</title>
<script type="text/javascript" src="<%=path%>/js/jquery-1.8.3.js"></script>
<script type="text/javascript">
	function getCode(obj) {
		$(obj).prop("src", "getCode.do?v=" + Math.random())
	}
	$(function() {

		var form = $("form");

		function check(nickname, pwd, code) {
			var flag = true;
			if (nickname == null || nickname == "") {
				alert("昵称不能为空");
				flag = false;
			}
			if (password == null || password == "") {
				alert("密码不能为空");
				flag = false;
			}
			if (code == null || code == "") {
				alert("验证码不能为空");
				flag = false;
			}

			return flag;
		}

		form.submit(function() {
			var nickname = $("input[name='nickname']").val();
			var password = $("input[name='password']").val();
			var code = $("input[name='code']").val();
			return check(nickname, password, code);
		});

	});
</script>
</head>

<body>
	<form action="<%=path%>/user/login.do" method="post">
		${requestScope.errInfo}<br/>
		昵&nbsp;&nbsp;&nbsp;&nbsp;称：
			<input type="text" name="nickname" placeholder="输入昵称" autocomplete="off" /><br />
		密&nbsp;&nbsp;&nbsp;&nbsp;码：
			<input type="password" name="password" placeholder="输入密码" autocomplete="off" /><br /> 
		验证码：
			<input type="text" name="code" placeholder="输入验证码" autocomplete="off" /><br />
		<img src="<%=path%>/getCode.do" width="80" height="30" style="margin-left:65px;" onclick="getCode(this)" /><br /> 
		<input type="submit" value="登录" style="margin-right:20px;" />
		<a href="<%=path%>/reg.jsp">注册</a>
	</form>
</body>
</html>