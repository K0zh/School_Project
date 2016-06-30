<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/common/common.jsp"%>

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
		
			
			<a onclick ="mainStart()">도움 요청</a><br>
			<a href="#">도움 찾기(미구현)</a><br>
			<a href="#">감사(미구현)</a><br>
			<a href="#">우리 동네 알림(미구현)</a><br>
			<hr>
			<a href="infowindow.con">인포 윈도우 테스트</a><br>
			<a href="signup.mb">회원 가입 폼</a><br>
			<a href="write.con">도움 요청 폼</a><br>
			<hr>
			<a href="test.do">테스트</a><br>
			<input type="hidden" id="location">
	</div>
	<script type="text/javascript">
	$(function() {
		if (navigator.geolocation) {
			// 위치정보 얻어옴
			navigator.geolocation.getCurrentPosition(function(position) {
				var lat_result = position.coords.latitude, // 위도
					lng_result = position.coords.longitude;// 경도
					
					document.getElementById("location").value = lat_result + "," + lng_result
					
					location.href ="main.do?init_lat="+lat_result+"&init_lng"+lng_result;
					
					if (window.sessionStorage) {
		                sessionStorage.setItem("init_lat", lat_result);
		                sessionStorage.setItem("init_lng", lng_result);
		            }
					
			});
		}
	});
	</script>
</body>
</html>