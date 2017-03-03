<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">

<title>注册</title>
<script type="text/javascript" src="<%=path%>/js/jquery-1.8.3.js"></script>
<script type="text/javascript">
	$(function() {
		$("input[name='nickname']").blur(function() {
			var nickname = $(this).val();
			$.get("user/getName.do", {
				"nickname" : nickname
			}, function(data) {
				if (data == "true") {
					$("#nick").html(nickname + "已存在，请重新输入").css("color", "red").css("margin-left", "10px");
					$(":submit").prop("disabled", "disabled");
				} else {
					$("#nick").html("");
					$(":submit").prop("disabled", "")
				}
			});
		});

		var form = $("form");

		function check(username, nickname, password) {
			var flag = true;
			if (username == null || username == "") {
				alert("用户名不能为空");
				flag = false;
			}
			if (nickname == null || nickname == "") {
				alert("昵称不能为空");
				flag = false;
			}
			if (password == null || password == "") {
				alert("密码不能为空");
				flag = false;
			}
			return flag;
		}

		form.submit(function() {
			var username = $("input[name='username']").val();
			var nickname = $("input[name='nickname']").val();
			var password = $("input[name='password']").val();
			return check(username, nickname, password);
		});
	});
</script>
</head>

<body>
	<form action="<%=path%>/user/reg.do" method="post">
		用户名：
			<input type="text" name="username" placeholder="输入用户名" autocomplete="off" /><br /> 
		昵&nbsp;&nbsp;&nbsp;&nbsp;称：
			<input type="text" name="nickname" placeholder="输入昵称" autocomplete="off" /><span id="nick"></span><br /> 
		密&nbsp;&nbsp;&nbsp;&nbsp;码：
			<input type="password" name="password" placeholder="输入密码" autocomplete="off" /><br />
		<input type="submit" value="注册" style="margin-right:20px;"/>
		<a href="<%=path%>/index.jsp">返回</a>
	</form>
</body>
</html>
