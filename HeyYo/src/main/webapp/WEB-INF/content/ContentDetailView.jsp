<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/common/common.jsp"%>
<%session.setAttribute("id", 7);%>
<%session.setAttribute("name", "kim");%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- SideBar CSS -->
<link
	href="${pageContext.request.contextPath}/resources/css/sidebar.css"
	rel="stylesheet">
</head>
<body>

	<!-- Login Modal JSP-->
	<jsp:include page="/WEB-INF/common/loginmodal.jsp" />

	<!-- Navigation Bar JSP  -->
	<jsp:include page="/WEB-INF/common/navbar.jsp" />

	<div id="wrapper">

		<!-- Sidebar -->
		<jsp:include page="/WEB-INF/common/sidebar.jsp" />
		<div>
		
		상세보기 페이지 입니다.<br>
		NUM : ${content.num }<br> 
		아이디 : ${content.id } <br> 분류 :
		${content.type } <br> 시간 : ${content.s_day } <br> 작성일 :
		${content.c_date } <br> 재능 : ${content.talent } <br> 제목 :
		${content.subject } <br> 본문 내용 : ${content.content } <br> 주소
		: ${content.address } <br>
		세션 : ${sessionScope.id} 테스트4443
		</div>
		<br> 
		
		<input type="button" value="신청하기"	id="requestBtn" onclick="matching()">
		<div class="form-inline" id="requestDiv">
		
			<form action="matching.con" method="post">
				<input type="hidden" name="m_num" value="${content.num }">
				<input type="hidden" name="m_name" value="${sessionScope.name }">
				<input type="hidden" name="m_id" value="${sessionScope.id}">
				<textarea class="form-control" rows="2" name="introduce">테스트</textarea>
				<input type="submit" value="신청" class="btn btn-primary">
			</form>
		</div>
		<c:if test="${sessionScope.id eq content.id}">
		<table class="table table-bordered table-hover">
			<thead>
				<tr class="text-center">
					<th width="10%">Num</th>
					<th width="20%">Name</th>
					<th width="60%">내용</th>
					<th width="10%">동의</th>
				</tr>
			<thead>
			<tbody>
				<c:forEach items="${matchingList}" var="matching" varStatus="status">
					<tr>
						<td>${status.count }</td>
						<td>
							<a href="user_detail.mb?id=${matching.M_ID}">${matching.M_NAME}</a>
						</td>
						<td>
							<a href="user_detail.mb?id=${matching.M_ID}">${matching.INTRODUCE}</a>
						</td>
						<td>	
							<input type="button" value="수락" onclick="agree(${matching.M_ID})">
							<input type="button" value="거절" onclick="deny(${matching.M_ID}, ${matching.M_NUM})">
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		</c:if>
	</div>
	<!-- /#wrapper -->

	<script type="text/javascript">
		function matching() {
			$("#requestDiv").hide;
			$("#requestDiv").toggle();
		}
		
		function agree(id) {
			document.location.href="agree.con?id="+id;
		}
		
		function deny(id, num) {
			document.location.href="deny.con?id="+id+"&num="+num;
		}
	</script>

</body>
</html>