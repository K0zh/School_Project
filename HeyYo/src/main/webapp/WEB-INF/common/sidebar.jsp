<%@page import="java.text.Format"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/common/common.jsp"%>

<% 
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
%>
<style>
	.media-object {
		padding: 10px;
	}
</style>
<div id="sidebar-wrapper">
	<ul class="sidebar-nav">
		<c:forEach items="${contentLists}" var="content" varStatus="status">
			<li>
				<a href="detail.con?num=${content.NUM }">
				<div class="media">
					<div class="media-left">
						<img class="media-object" src="${pageContext.request.contextPath}/resources/images/pic01.png" alt="image" width="100px">
					</div>
					<div class="media-body">
						<b>${content.SUBJECT }</b>
						${content.TALENT }
					</div>
					${content.C_DATE}
				</div>
				</a>
			</li>
		</c:forEach>
	</ul>
</div>
<!-- /#sidebar-wrapper -->
