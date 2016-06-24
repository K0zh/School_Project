<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- SideBar CSS -->
<link href="${pageContext.request.contextPath}/resources/css/sidebar.css" rel="stylesheet">

<!-- 재능 입력 (Tokenfield) CSS -->
<link href="${pageContext.request.contextPath}/resources/css/bootstrap-tokenfield.css" rel="stylesheet">
</head>
<body>
	<!-- Login Modal JSP-->
	<jsp:include page="/WEB-INF/common/loginmodal.jsp" />

	<!-- Navigation Bar JSP  -->
	<jsp:include page="/WEB-INF/common/navbar.jsp" />

	<div id="wrapper">
		<!-- Sidebar -->
		<jsp:include page="/WEB-INF/common/sidebar.jsp" />

		도움 요청 작성 페이지
		<form class="form-horizontal">
			<div class="form-group">
				<label for="subject" class="col-xs-2 control-label">제목 </label>
				<div class="col-xs-10"> 
					<input type="text" id="subject" class="form-control">
				</div>
			</div>
			<div class="form-group">
				<label for="need" class="col-xs-2 control-label">필요해요!</label>
				<div class="col-xs-10"> 
					<input type="text" id="need" class="form-control">
				</div>
			</div>
			<div class="form-group">
				<label for="date" class="col-xs-2 control-label">요청일</label>
				<div class="col-xs-10"> 
					<input type="date" id="c_date" class="form-control">
				</div>
			</div>
			<div class="form-group">
				<label for="location" class="col-xs-2 control-label">지역</label>
				<div class="col-xs-10"> 
					<input type="text" id="location" class="form-control">
					<!-- 맵 div -->
					<div id="map" style="width: 100%; height: 30%; margin-top:10px;"></div>
				</div>
			</div>
			
			<div class="form-group">
				<label for="personnel" class="col-xs-2 control-label">필요 인원</label>
				<div class="col-xs-10"> 
					<input type="text" id="personnel" class="form-control">
				</div>
			</div>
			<div class="form-group">
				<label for="gender" class="col-xs-2 control-label">성별</label>
				<div class="col-xs-10">
					<label class="radio-inline"> 
						<input type="radio" value="남자" name="gender">남자
					</label>
					<label class="radio-inline"> 
						<input type="radio" value="여자" name="gender">여자
					</label>
					<label class="radio-inline"> 
						<input type="radio" value="무관" name="gender">무관
					</label>
				</div>
			</div>
			<div class="form-group">
				<label for="content" class="col-xs-2 control-label">내용</label>
				<div class="col-xs-10">
					<textarea class="form-control" rows="3">테스트</textarea>
				</div>
			</div>
			
			<!-- 클릭한 위치 좌표값 저장 -->
			<input type="hidden" id="address" style="display: none;">
		</form>
	</div>
	<!-- /#wrapper -->

	<!-- 맵 & 좌표 얻어오는 JS -->
	<script src="${pageContext.request.contextPath}/resources/js/contentwrite-map.js"></script>

	<!-- 구글 맵 api 키값 -->
	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDr7VXyN9A75vH2I8W73He8E61iuknPtf8&callback=initMap" async defer></script>

	<!-- 재능 입력 (Tokenfield) JS -->
	<script src="${pageContext.request.contextPath}/resources/js/bootstrap-tokenfield.js"></script>
	<script type="text/javascript">
		$('#need').tokenfield({
			showAutocompleteOnFocus : true
		})
	</script>

</body>
</html>