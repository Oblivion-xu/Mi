<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>主题详情</title>
	<script type="text/javascript" src="<%=path%>/js/jquery-1.8.3.js"></script>
	<script type="text/javascript">
		$(function(){
			$("form").hide();
			$(":button").click(function(){
				if($(this).val()=="我要评论"){
					$("form").show();
					$(this).val("关闭评论");
				}else{
					$("textarea").val("");
					$("form").hide();
					$(this).val("我要评论");
				}
			});
			$(":button").click(function(){
				var pageIndex = $(":text").val();
				var tid = $("input[name='topic.id']").val()
				location.href="<%=path%>/reply/change.do?pageIndex="+pageIndex+"&tid="+tid;
			});
		});
	</script>
  </head>
  
  <body style="margin:0 10%;">
    <div style="height:30px;background-color:lime;padding-right:15px;">
    	<div style="float:right;line-height:30px;">
    		当前用户<span style="color:red;">${bbsUser.nickname}</span>
    		<a href="<%=path%>/addTopic.jsp">发帖</a>
    		<a href="<%=path%>/user/exit.do" style="color:red;">退出</a>
    	</div>
    </div>
    <table border="1" align="center" cellspacing="2" style="background-color: rgb(215,215,215);width:100%;margin-top:5px;">
    	<thead>
    		<tr align="center" style="background-color:yellow;">
    			<th width="13%">主题</th>
    			<th width="17%">${replys.get(0).topic.topicTitle }</th>
    			<th width="15%">贴主</th>
    			<th width="15%">${replys.get(0).bbsUser.nickname}</th>
    			<th width="15%">发帖时间</th>
    			<th width="20%"><fmt:formatDate value="${replys.get(0).topic.topicTime}" pattern="yyyy-MM-dd HH:mm:ss"/></th>
    		</tr>
    		<tr align="left" style="background-color:lime;font-size:24px;color:red;">
    			<th colspan="6">${replys.get(0).topic.topicContent}</th>
    		</tr>
    	</thead>
    	<tbody align="left">
    		<c:if test="${fn:length(replys) eq 0 }">
    			<tr style="background-color:rgb(215,215,215);">
    				<td colspan="6" style="background-color:#666;color:lime;font-size:24px;">还没有人开始评论哦</td>
    			</tr>
    		</c:if>
    		<c:forEach items="${replys}" var="reply" varStatus="status">
	    		<tr style="background-color:rgb(215,215,215);">
	    			<td width="15%"><span style="color:red;font-size:24px;">${(pager.pageIndex-1)*pager.pageSize+status.count}楼</span></td>
	    			<td width="15%">主题：<span style="color:blue;">${reply.topic.topicTitle }</span></td>
	    			<td width="50%" colspan="3">回帖时间：<span style="color:blue;"><fmt:formatDate value="${reply.replyTime}" pattern="yyyy-MM-dd HH:mm:ss"/></span></td>
	    			<td width="20%">
	    				回帖人：<span style="color:blue;">${reply.bbsUser.nickname }</span>
	    				<c:if test="${bbsUser.role eq 0 }">
	    					<a href="<%=path%>/reply/delReply.do?id=${reply.replyId}&tid=${reply.topic.id}">删除</a>
	    				</c:if>
	    				<c:if test="${bbsUser.id eq reply.bbsUser.id }">
	    					<a href="<%=path%>/reply/delReply.do?id=${reply.replyId}&tid=${reply.topic.id}">删除</a>
	    				</c:if>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td colspan="6" style="background-color:#666;color:lime;font-size:24px;">
	    				${reply.replyContent}
	    			</td>
    			</tr>
    		</c:forEach>
    		
    	</tbody>
    	<tfoot align="center">
    		<tr>
    			<td colspan="6">
    				<a href="<%=path%>/reply/findById.do?id=${replys.get(0).topic.id}">首页 </a>
    				<c:if test="${pager.pageIndex eq 1 }">
    					<a >上一页</a>
    				</c:if>
    				<c:if test="${pager.pageIndex gt 1 }">
    					<a href="<%=path%>/reply/change.do?pageIndex=${pager.pageIndex-1}&tid=${replys.get(0).topic.id}">上一页</a>
    				</c:if>
    				<c:if test="${pager.pageIndex eq pager.pageCount }">
    					<a>下一页</a>
    				</c:if>
    				<c:if test="${pager.pageIndex lt pager.pageCount }">
    					<a href="<%=path%>/reply/change.do?pageIndex=${pager.pageIndex+1}&tid=${replys.get(0).topic.id}">下一页</a>
    				</c:if>
    				<a href="<%=path%>/reply/change.do?pageIndex=${pager.pageCount}&tid=${replys.get(0).topic.id}">尾页</a>
    			</td>
    		</tr>
    		<tr>
    			<td colspan="6">
    				共<span style="color:red;">${pager.pageTotal }</span>条记录&nbsp;
    				共<span style="color:blue;">${pager.pageCount }</span>页&nbsp;
    				一页显示<span style="color:red;">${pager.pageSize }</span>条记录&nbsp;
    				当前第<span style="color:red;">${pager.pageIndex}</span>页&nbsp;
    				去<input type="text" size="1" value="1"/>页&nbsp;
    				<input type="button" value="go" size="8"/>
    			</td>
    		</tr>
    	</tfoot>
    </table>
    <div style="text-align:left;font-size:16px;display:inline;"><a href="<%=path%>/topic/list.do">返回</a></div>
    <div style="float:right;font-size:16px;display:inline;">
    	已有<span style="font-size:20px;color:red;font-weight: bold;">${fn:length(replys) }</span>位网友对此发表评论
    	<input type="button" value="我要评论"/>
    </div>

    <form action="<%=path%>/reply/addReply.do" method="post">
    	请您留言<br/>
    	<input type="hidden" value="${replys.get(0).topic.id }" name="topic.id"/>
    	<input type="hidden" value="${bbsUser.id }" name="bbsUser.id">
    	<textarea rows="10" cols="30" name="replyContent"></textarea><br/>
    	<input type="submit" value="提交留言" />
    </form>
  </body>
</html>
