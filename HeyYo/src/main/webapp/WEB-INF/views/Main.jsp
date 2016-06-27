<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- SideBar CSS -->
<link href="${pageContext.request.contextPath}/resources/css/sidebar.css" rel="stylesheet">
<script type="text/javascript">
function need() {
	document.location.href="main.do?type=need";
}
function able() {
	document.location.href="main.do?type=able";
}

</script>
</head>
<body>
	<!-- Login Modal JSP-->
	<jsp:include page="/WEB-INF/common/loginmodal.jsp" />

	<!-- Navigation Bar JSP  -->
	<jsp:include page="/WEB-INF/common/navbar.jsp" />

	<div id="wrapper">

		<!-- Sidebar -->
		<jsp:include page="/WEB-INF/common/sidebar.jsp" />
		<!-- Map 띄우기 위한 Div -->
		<div id="map" style="width: 80%; height: 50%; margin: 50px;"></div>


		<input type="button" value="도움 요청하기" onclick="location.href='write.con'"><br>
		<input type="button" value="전체보기"  onclick="location.href='main.do'"><br>
		<input type="button" value="필요해요!"  onclick="need()"><br>
		<input type="button" value="필요해요?"  onclick="able()"><br>
	</div>
	<!-- /#wrapper -->

	<!-- 지도 정보처리 script -->
	<script type="text/javascript">
		var str = "";
	
		$.ajax({
			type : 'post',
			url : 'infowindow.con',
			dataType : 'html',
			success : function(data) {
				str = data
			},
			async: false
			
		});

		/* DB에서 가져온 주소값 */
		var address = new Array();
		var coordinate = new Array();

		/* 마커 정보창 text */
		var contentString = new Array();
		
		<c:forEach items="${contentLists}" var="content" varStatus="status">
			str = str.replace("$SUBJECT", "${content.SUBJECT}")
			str = str.replace("$TALENT", "${content.TALENT}")
			str = str.replace("$C_DATE", "${content.C_DATE}")
			str = str.replace("$ID", "${content.ID}")
		
			address.push("${content.ADDRESS}"); //주소값
			coordinate.push("${content.LOCATION}") //좌표값
			
			contentString.push(str); //마커 정보
		</c:forEach>
	</script>


	<!-- Map JS -->
	<script src="${pageContext.request.contextPath}/resources/js/map.js"></script>

	<!-- 구글 맵 api 키값 -->
	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDr7VXyN9A75vH2I8W73He8E61iuknPtf8&callback=initMap" async defer></script>


</body>
</html>
