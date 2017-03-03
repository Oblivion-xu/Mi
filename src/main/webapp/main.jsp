<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">

<title>主页</title>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
}

body {
	margin: o auto;
	opacity: /* position: absolute; */
}

#info {
	background-color: black;
	position: absolute;
	opacity: 0.8;
	width: 280px;
	height: 90px;
	left: 250px;
	z-index: 999;
	text-align: left;
	padding: 10px 10px;
}
</style>
<script type="text/javascript" src="<%=path%>/js/jquery-1.8.3.js"></script>
<script type="text/javascript">
	$(function() {
		$(":button").click(function() {
			var pageIndex = $(":text").val();
			location.href = "<%=path%>/topic/change.do?pageIndex=" + pageIndex;
		});

		$("#content").live({
			mouseover : function() {
				var tid = $(this).children().val();
				var topic = null;
				$.get("topic/findById.do", {
					"id" : tid
				}, function(data) {
					var title = "<span style='color:lime;'>主题："+data.topicTitle+"</span><br/>";
					var content = "<span style='color:lime;'>内容："+data.topicContent+"</span><br/>";
					var createby = "<span style='color:lime;'>发帖人："+data.bbsUser.nickname+"</span><br/>";
					var createTime = "<span style='color:lime;'>创建时间："+$("#content").next().next().text()+"</span><br/><br/>";
					var div = "<div id='info'>"+title+content+createby+createTime+"</div>";
					
					
					$("#content").append(div);
				}, "json");
				
				
			},
			mouseout : function() {
				$("#info").remove();
			}
		});
	});
</script>
</head>

<body style="margin:0 10%;">
	<div style="height:30px;background-color:lime;padding-right:15px;">
		<div style="float:right;line-height:30px;">
			当前用户<span style="color:red;">${bbsUser.nickname}</span> <a
				href="<%=path%>/addTopic.jsp">发帖</a> <a
				href="<%=path%>/user/exit.do" style="color:red;">退出</a>
		</div>
	</div>
	<table border="1" align="center" cellspacing="2"
		style="background-color: rgb(215,215,215);width:100%;margin-top:5px;">
		<thead align="center">
			<tr>
				<th>编号</th>
				<th>标题</th>
				<th>贴主</th>
				<th>发帖时间</th>
				<th>回复数</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody align="center">
			<c:forEach items="${requestScope.topics}" var="topic"
				varStatus="status">
				<tr>
					<td style="color:red;">${status.count}</td>
					<td style="background-color:yellow" id="content">${topic.topicTitle}<input
						type="hidden" value="${topic.id}" /></td>
					<td style="color:red;">${topic.bbsUser.nickname }</td>
					<td><fmt:formatDate value="${topic.topicTime}"
							pattern="yyyy-MM-dd HH:mm:ss" /></td>
					<td>${fn:length(topic.replys) }</td>
					<td><a href="<%=path%>/reply/findById.do?id=${topic.id}">查看</a>
						<c:if test="${bbsUser.role eq 0 }">
							<a href="<%=path%>/topic/delTopic.do?id=${topic.id}">删除</a>
						</c:if> <c:if test="${bbsUser.id eq topic.bbsUser.id }">
							<a href="<%=path%>/topic/delTopic.do?id=${topic.id}">删除</a>
						</c:if></td>
				</tr>
			</c:forEach>

		</tbody>
		<tfoot align="center">
			<tr>
				<td colspan="6"><a href="<%=path%>/topic/list.do">首页 </a> <c:if
						test="${pager.pageIndex eq 1 }">
						<a>上一页</a>
					</c:if> <c:if test="${pager.pageIndex gt 1 }">
						<a href="<%=path%>/topic/change.do?pageIndex=${pager.pageIndex-1}">上一页</a>
					</c:if> <c:if test="${pager.pageIndex eq pager.pageCount }">
						<a>下一页</a>
					</c:if> <c:if test="${pager.pageIndex lt pager.pageCount }">
						<a href="<%=path%>/topic/change.do?pageIndex=${pager.pageIndex+1}">下一页</a>
					</c:if> <a href="<%=path%>/topic/change.do?pageIndex=${pager.pageCount}">尾页</a>
				</td>
			</tr>
			<tr>
				<td colspan="6">共<span style="color:red;">${pager.pageTotal }</span>条记录&nbsp;
					共<span style="color:blue;">${pager.pageCount }</span>页&nbsp; 一页显示<span
					style="color:red;">${pager.pageSize }</span>条记录&nbsp; 当前第<span
					style="color:red;">${pager.pageIndex}</span>页&nbsp; 去<input
					type="text" size="1" value="1" />页&nbsp; <input type="button"
					value="go" size="8" />
				</td>
			</tr>
		</tfoot>
	</table>
</body>
</html>
