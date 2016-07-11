<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="/WEB-INF/common/common.jsp"%>

<html>
<head>
<link href="${pageContext.request.contextPath}/resources/css/bootstrap-tokenfield.css" rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<!-- SideBar CSS -->
<title>Insert title here</title>
<style type="text/css">
body {
	background-image: url(resources/images/main_page.jpg);
	background-position: top; /*시작 위치*/
	background-size: 100%;
	background-attachment: fixed;
	background-repeat: repeat;
}
h1 {
	text-align: center;
	color: white;
	font-weight: 800;
	font-size: 40pt;
}
h2 {
	text-align: center;
	color: white;
	font-weight: 600;
	font-size: 25pt;
}

h3 {
	text-align: right;
	color: white;
	font-weight: 500;
	font-size: 20pt;
}

input{
	width:300px;
	font-size: 20pt;
}

</style>
<script type="text/javascript">


function start(){
	
if (navigator.geolocation) {
	// 위치정보 얻어옴
	navigator.geolocation.getCurrentPosition(function(position) {
		var lat_result = position.coords.latitude, // 위도
		lng_result = position.coords.longitude;// 경도
		
		var now_location = lat_result + lng_result;
		
		document.location.href="main.do?location="+now_location;
	});
}
	
}
</script>
</head>
<body>
<br>
	<div>
	&nbsp;&nbsp;&nbsp;&nbsp;
		<img src="resources/images/doum_logo.png" onclick="location.href='/'">
	</div>

<br>
	<h1>도움이 필요하신가요?</h1>
	<br>
	<h2>혼자 찾아헤매지 마시고</h2>
	<h2>무엇이든 도움 받으세요</h2>
	<h2>지역기반 주변의 전문 덕후들이 도와드립니다!</h2>
	
	<h2><input type="button" value="도움 보기" onclick="start()" class="btn btn-info"></h2>
	<h2><input type="button" value="도움 요청" onclick="location.href='signup.mb'" class="btn btn-info"></h2>
	




<%-- 	<jsp:include page="/WEB-INF/common/loginmodal.jsp" />
	<form>
	<div id="wrapper">
	<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#loginModal">로그인</button>
	<a href="signup.mb" class="btn btn-primary btn-lg" role="button">회원가입</a>
	</div>
	
	</form>
 --%>	
</body>
</html>