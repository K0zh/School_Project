<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/common/common.jsp"%>
<div style="width: 200px;">
	<header>
		<h3>$SUBJECT</h3>
	</header>
	<section>
		<div>
			<b>재능 : </b><br> &nbsp;&nbsp;&nbsp;$TALENT
		</div>
		<div>
		
			<b>시간 : </b><br> &nbsp;&nbsp;&nbsp;$S_DAY
		</div>
	</section>
	<footer>
		<div class="text-center">
		<a href='detail.con?num=$NUM&id=$ID' class="btn btn-primary btn-sm">상세보기</a>
		</div>
	</footer>
</div>

