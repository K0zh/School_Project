<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/common/common.jsp"%>
<div id="sidebar-wrapper">
	<ul class="sidebar-nav">
		<li class="sidebar-brand"><a href="home.do"> 우리동네 </a></li>
		<c:forEach items="${contentLists}" var="content" varStatus="status">
			<li>
					<div class="media">
					<a href="detail.con?num=${content.NUM }">
						<div class="media-left">
							<img class="media-object" src="..." alt="...">
						</div>
						<div class="media-body">
							<h5 class="media-heading">${content.SUBJECT }</h5>
							${content.TALENT }
						</div>
							${content.C_DATE}
					</a>
					</div>
				<br>
			</li>
		</c:forEach>
	</ul>
</div>
<!-- /#sidebar-wrapper -->


<!-- 사이드바 토글 Script -->
<script>
	/* 사이드바 토글 */
	$("#menu-toggle").click(function(e) {
		e.preventDefault();
		$("#wrapper").toggleClass("toggled");
	});
</script>