<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="/WEB-INF/common/common.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<!-- SideBar CSS -->
<title>Insert title here</title>
<link
	href="${pageContext.request.contextPath}/resources/css/sidebar.css"
	rel="stylesheet">
</head>
<body>
	<jsp:include page="/WEB-INF/common/loginmodal.jsp" />
	
	
	<div id="wrapper">
	<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#loginModal">로그인</button>
	<a href="signup.mb" class="btn btn-primary btn-lg" role="button">회원가입</a>
	
	
	</div>
</body>
</html>