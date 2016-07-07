<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 기본 CSS -->
<link href="${pageContext.request.contextPath}/resources/common/reset.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/common/default.css" rel="stylesheet">
</head>
<body>

	<!-- Login Modal JSP-->
	<jsp:include page="/WEB-INF/common/loginmodal.jsp" />

	<!-- Navigation Bar JSP  -->
	<jsp:include page="/WEB-INF/common/navbar.jsp" />

	<div id="wrapper">
		<table>
			<tr>
				<td>필요해요?</td>
				<td>${responseMember.name}</td>
				<td>${responseMember.email}</td>
			</tr>
		</table>
		<table>
			<tr>
				<td>필요해요!</td>
				<td>${requestMember.name}</td>
				<td>${requestMember.email}</td>
			</tr>
		</table>
		
		
		


	</div>
	<!-- /#wrapper -->
</body>
</html>