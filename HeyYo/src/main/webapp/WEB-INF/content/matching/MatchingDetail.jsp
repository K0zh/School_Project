<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/common/common.jsp"%>
<%
	session.setAttribute("id", 7);
%>
<%
	session.setAttribute("name", "park");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- SideBar CSS -->
<link href="${pageContext.request.contextPath}/resources/css/sidebar.css" rel="stylesheet">
</head>
<body>

	<!-- Login Modal JSP-->
	<jsp:include page="/WEB-INF/common/loginmodal.jsp" />

	<!-- Navigation Bar JSP  -->
	<jsp:include page="/WEB-INF/common/navbar.jsp" />

	<div id="wrapper">
		<!-- Sidebar -->
		<jsp:include page="/WEB-INF/common/sidebar.jsp" />
		
		매칭 상세보기 페이지 입니다.<br>
		
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