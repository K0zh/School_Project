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

<script src="resources/js/jquery.js" type="text/javascript"></script>
<script type="text/javascript">
$(function(){
	var lat_result, lng_result;

	lat_result = "${content.lat}"; // 위도
	lng_result = "${content.lng}";// 경도

	var myLatLng = {
			lat : lat_result,
			lng : lng_result
			}
	
	alert(lat_result + " " + lng_result);
	myMap(myLatLng);
});


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

		<!-- 도움 요청 글쓰기 폼 -->
		<form class="form-horizontal" action="updateContent.con" method="post">
			<!-- 카테고리  -->
			<div class="form-group">
				<label for="type" class="col-xs-2 control-label">카테고리 </label>
				<div class="col-xs-2">
					<select id="type" name="type" class="form-control">
						<option>선택</option>
						<option value="need" <c:if test="${content.type== need}"> selected </c:if>>필요 해요!</option>
						<option value="able" <c:if test="${content.type== able}"> selected </c:if>>필요 해요?</option>
					</select>
				
				</div>
			</div>
		
			<!-- 제목 -->
			<div class="form-group">
				<label for="subject" class="col-xs-2 control-label">제목 </label>
				<div class="col-xs-10 col-md-9">
					<input type="text" id="subject" name="subject" class="form-control" value="${content.subject }">
				</div>
			</div>

			<!-- 재능 키워드 -->
			<div class="form-group">
				<label for="talent" class="col-xs-2 control-label">재능</label>
				<div class="col-xs-10 col-md-9">
					<input type="text" id="talent" name="talent" class="form-control" value="${content.subject }">
				</div>
			</div>

			<!-- 재능 날짜 -->
			<div class="form-group">
				<label for="date" class="col-xs-2 control-label">요청일</label>
				<div class="col-xs-10 col-md-9">
					<input type="date" id="s_day" name="s_day" class="form-control" value="${content.s_day }">
				</div>
			</div>

			<!-- 지도 클릭시 해당하는 주소명 -->
			<div class="form-group">
				<label for="location" class="col-xs-2 control-label">지역</label>
				<div class="col-xs-10 col-md-9">
					<input type="text" id="address" name="address" class="form-control" value="${content.address }">
					<!-- 맵 div -->
					<div id="map" style="width: 100%; height: 30%; margin-top: 10px;"></div>
				</div>
			</div>

			<!-- 필요/신청가능 인원 -->
			<div class="form-group">
				<label for="personnel" class="col-xs-2 control-label">필요 인원</label>
				<div class="col-xs-10 col-md-9">
					<input type="number" id="personnel" name="personnel" class="form-control" value="${content.personnel }">
				</div>
			</div>

			<!-- 성별 -->
			<div class="form-group">
				<label for="gender" class="col-xs-2 control-label">성별</label>
				<div class="col-xs-10 col-md-9">
					<label class="radio-inline"> <input type="radio" value="남자" id="gender" name="gender" <c:if test="${content.gender== '남자'}"> checked </c:if>>남자
					</label> <label class="radio-inline"> <input type="radio" value="여자" id="gender" name="gender"<c:if test="${content.gender== '여자'}"> checked </c:if>>여자
					</label> <label class="radio-inline"> <input type="radio" value="무관" id="gender" name="gender"<c:if test="${content.gender=='무관'}"> checked </c:if>>무관
					</label>
				</div>
			</div>

			<!-- 본문 내용 -->
			<div class="form-group">
				<label for="content" class="col-xs-2 control-label">내용</label>
				<div class="col-xs-10 col-md-9"> 
					<textarea class="form-control" rows="3" id="content" name="content" value="${content.content }">테스트</textarea>
				</div>
			</div>

			<div class="form-group">
				<div class="col-xs-2">
					<!-- 클릭한 위치 좌표값 저장 -->
					<input type="hidden" id="location" name="location">

					<!-- 아이디 값을 넘기기 위한 input 태그 -->
					<input type="hidden" name="id" value="${sessionScope.loginfo.id }">
				</div>
				<div class="col-xs-10 col-md-9">
					<input type="submit" value="변경하기" class="btn btn-primary btn-block ">
				</div>
			</div>
		</form>
	</div>
	<!-- /#wrapper -->


	<!-- 맵 & 좌표 얻어오는 JS -->
	<script src="${pageContext.request.contextPath}/resources/js/contentUpdate-map.js"></script>
	
		<!-- 구글 맵 api 키값 -->
	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDr7VXyN9A75vH2I8W73He8E61iuknPtf8&callback=initMap" async defer></script>

	<!-- 재능 입력 (Tokenfield) JS -->
	<script src="${pageContext.request.contextPath}/resources/js/bootstrap-tokenfield.js"></script>
	<script type="text/javascript">
		$('#talent').tokenfield({
			showAutocompleteOnFocus : true
		})
	</script>

</body>
</html>