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
		<li> <h3 style="color: white">목록</h3></li>
		<c:forEach items="${contentLists}" var="content" varStatus="status">
			<li>
				<a href="detail.con?num=${content.NUM }&id=${content.ID}">
				<div class="media">
					<div class="media-left">
						<img class="media-object" src="${pageContext.request.contextPath}/resources/images/profile/${content.IMAGE}" alt="image" width="80px">
					</div>
					<div class="media-body">
						<b><font color="lightgray">${content.SUBJECT } </font><br></b>
						<c:if test="${content.TYPE eq 'able' }">
						 	필요해요 ? : <br>
						</c:if>
						<c:if test="${content.TYPE eq 'need' }">
						 	필요해요 ! : <br>
						</c:if>
						${content.TALENT }
					</div>
					등록일 : <fmt:formatDate value="${content.C_DATE}" pattern="yyyy-MM-dd hh:mm"/>
				</div>
				</a>
			</li>
			<hr style="border: solid 0.1em #333;">
		</c:forEach>
	</ul>
</div>
<!-- /#sidebar-wrapper -->
