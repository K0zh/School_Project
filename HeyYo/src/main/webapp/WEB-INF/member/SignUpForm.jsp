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
		<form name="WriteForm" action="write.con" method="post">
			<h3>원하는 시간에 재능을 나누세요</h3>

			<div class="form-group has-success has-feedback">
				<label>이름</label> 
				<input type="text" class="form-control" placeholder="홍길동" name="name" aria-describedby="inputSuccess2Status">
				<span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>
				<span id="inputSuccess2Status" class="sr-only">(success)</span>
			</div>

			<div class="form-group">
				<label>전화번호</label> <input type="text" class="form-control" placeholder="01012345678" name="tel">
			</div>

			<div class="form-group">
			<label for="address1">나의 활동 지역</label> 
				<div class="form-inline">
					<select class="form-control" id="address1" name="address" onchange="change(this.selectedIndex);" class="input">
						<option value="전체">전체</option>
						<option value="서울">서울</option>
						<option value="부산">부산</option>
						<option value="대구">대구</option>
						<option value="인천">인천</option>
						<option value="광주">광주</option>
						<option value="대전">대전</option>
						<option value="울산">울산</option>
						<option value="경기">경기</option>
						<option value="강원">강원</option>
						<option value="충북">충북</option>
						<option value="충남">충남</option>
						<option value="전북">전북</option>
						<option value="전남">전남</option>
						<option value="경북">경북</option>
						<option value="경남">경남</option>
						<option value="제주">제주</option>
					</select> 
					<select class="form-control" id="address2" name="address">
						<option>선택</option>
					</select>
				</div>
			</div>

			<div class="form-group">
				<label>나의 재능</label>
				<input type="text" class="form-control" id="talent" name="talent">
			</div>

			<div class="form-group">
				<label>시간</label> <input type="text" class="form-control" name="time">
			</div>
			<input type="submit" value="신청하기" class="btn btn-primary btn-md btn-block">
		</form>
	</div>
	<!-- /#wrapper -->

	<!-- 활동 지역 JS -->
	<script src="${pageContext.request.contextPath}/resources/js/address.js"></script>

	<!-- 재능 입력 (Tokenfield) JS -->
	<script src="${pageContext.request.contextPath}/resources/js/bootstrap-tokenfield.js"></script>
	<script type="text/javascript">
		$('#talent').tokenfield({
					showAutocompleteOnFocus : true
				})
	</script>

</body>
</html>