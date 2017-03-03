<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>

<!DOCTYPE html>
<html>
  <head>
    
    <title>发帖</title>
	<script type="text/javascript" src="<%=path%>/js/jquery-1.8.3.js"></script>
	<script type="text/javascript">
		function getCode(obj) {
			$(obj).prop("src", "getCode.do?v=" + Math.random())
		}
		
		$(function() {

			var form = $("form");

			function check(topicTitle, topicContent, code) {
				var flag = true;
				if (topicTitle == null || topicTitle == "") {
					alert("主题不能为空");
					flag = false;
				}
				if (topicContent == null || topicContent == "") {
					alert("内容不能为空");
					flag = false;
				}
				if (code == null || code == "") {
					alert("验证码不能为空");
					flag = false;
				}
	
				return flag;
			}

			form.submit(function() {
				var topicTitle = $("input[name='topicTitle']").val();
				var topicContent = $("#content").val();
				var code = $("input[name='code']").val();
				return check(topicTitle, topicContent, code);
			});
		});
	</script>
	<style type="text/css">
		*{
			margin:0;
			padding:0;
			vertical-align: 
		}
	</style>
  </head>
  
  <body>
    <form action="<%=path%>/topic/addTopic.do" method="post">
    	<input type="hidden" name="bbsUser.id" value="${sessionScope.bbsUser.id}"/>
    	主题：<input type="text" name="topicTitle"/><br/>
    	内容：<textarea rows="10" cols="30" name="topicContent" id="content"></textarea><br/>
		验证码：<input type="text" size="4" name="code"/>
		<img src="<%=path%>/getCode.do" width="80" height="30" style="vertical-align: middle;" onclick="getCode(this)"/><br />
		<input type="submit" value="提交"/>
		<a href="#" onclick="history.go(-1);">返回</a>
    </form>
  </body>
</html>
