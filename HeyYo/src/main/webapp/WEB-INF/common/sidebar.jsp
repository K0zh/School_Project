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
						<img class="media-object" src="${pageContext.request.contextPath}/resources/images/profile/pic01.png" alt="image" width="80px">
					</div>
					<div class="media-body">
						${content.SUBJECT }<br>
						
						
						<b>${content.TYPE } : </b>${content.TALENT }
					</div>
					등록일 : <fmt:formatDate value="${content.C_DATE}" pattern="yyyy-MM-dd hh:mm"/>
				</div>
				</a>
			</li>
		</c:forEach>
	</ul>
</div>
<!-- /#sidebar-wrapper -->
