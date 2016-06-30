<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- SideBar CSS -->
<link
	href="${pageContext.request.contextPath}/resources/css/sidebar.css"
	rel="stylesheet">

<!-- 재능 입력 (Tokenfield) CSS -->
<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap-tokenfield.css"
	rel="stylesheet">
</head>
<body>SELECT id, ( 6371 * acos( cos( radians(#{init_lat}) ) *
	cos( radians( lat ) ) * cos( radians( lng ) - radians(#{init_lng}) ) +
	sin( radians(#{init_lat}) ) * sin( radians( lat ) ) ) ) AS distance
	FROM contents 
	
	select id,(6371 * acos( cos( (37/90.0) * acos(-1) / 2)) *
	cos( (lat/90.0) * acos(-1) / 2) * cos( (lng/90.0) * acos(-1) / 2) -
	(127/90.0) * acos(-1) / 2)
</body>
</html>

2 3 4 6 / 2 3

