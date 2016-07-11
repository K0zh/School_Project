<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 기본 CSS -->
<link
	href="${pageContext.request.contextPath}/resources/common/default.css"
	rel="stylesheet">
</head>
<body>


	<!-- Login Modal JSP-->
	<jsp:include page="/WEB-INF/common/loginmodal.jsp" />

	<!-- Navigation Bar JSP  -->
	<jsp:include page="/WEB-INF/common/navbar.jsp" />

	<div class="container">
		<div id="wrapper">
			<table class="table" width="500px">

				<thead>
					<tr>
						<td>필요해요?</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th>이름</th>
						<td>${responseMember.name}</td>
					</tr>
					<tr>
						<th>성별</th>
						<td>${responseMember.gender}</td>
					</tr>
					<tr>
						<th>전화번호</th>
						<td>${responseMember.hp}</td>
					</tr>
					<tr>
						<th>생년월일</th>
						<td>${responseMember.birthday}</td>
					</tr>
					<tr>
						<th>주소</th>
						<td>${responseMember.address}</td>
					</tr>
					<tr>
						<th>회원 등급</th>
						<td>${responseMember.grade}</td>
					</tr>
				</tbody>
			</table>
			<table class="table" width="500px">
				<thead>
					<tr>
						<td>필요해요!</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th>이름</th>
						<td>${requestMember.name}</td>
					</tr>
					<tr>
						<th>성별</th>
						<td>${requestMember.gender}</td>
					</tr>
					<tr>
						<th>전화번호</th>
						<td>${requestMember.hp}</td>
					</tr>
					<tr>
						<th>생년월일</th>
						<td>${requestMember.birthday}</td>
					</tr>
					<tr>
						<th>주소</th>
						<td>${requestMember.address}</td>
					</tr>
					<tr>
						<th>회원 등급</th>
						<td>${requestMember.grade}</td>
					</tr>
				</tbody>
			</table>
					<input type="button" value="대화하기" class="btn btn-default">

		</div>
		<!-- /#wrapper -->
	</div>
</body>
</html>