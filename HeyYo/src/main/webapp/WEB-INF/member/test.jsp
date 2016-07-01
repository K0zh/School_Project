<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
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
	<!-- Login Modal JSP-->
	<jsp:include page="/WEB-INF/common/loginmodal.jsp" />

	<!-- Navigation Bar JSP  -->
	<jsp:include page="/WEB-INF/common/navbar.jsp" />
	<div id="wrapper">
		<!-- Sidebar -->
		<jsp:include page="/WEB-INF/common/sidebar.jsp" />
		<center>
			<h3>내정보</h3>
		</center>
		
		<%-- 	
	아이디 비번 찾기 테스트
	<c:out value="${mb.email}"/><br>
	<c:out value="${mb.pw}"/><br>
	<c:out value="${mb.name}"/> --%>

	<form>
		<div class="form-group">
    		<label>이메일</label>
    		<input type="text" class="form-control" placeholder="${loginfo.email}" readonly>
  		</div>
  		<div class="form-group">
    		<label>이름</label>
    		<input type="text" class="form-control" placeholder="${loginfo.name}" readonly>
  		</div>
  		<div class="form-group">
    		<label>전화번호</label>
    		<input type="text" class="form-control" placeholder="${loginfo.hp}" readonly>
  		</div>
		<div class="form-group">
    		<label>주소</label>
    		<input type="text" class="form-control" placeholder="${loginfo.address}" readonly>
  		</div>
  		<div class="form-group">
    		<label>생년월일</label>
    		<input type="text" class="form-control" placeholder="${loginfo.birthday}" readonly>
  		</div>
  		<div class="form-group">
    		<label>기부받을 재능</label>
    		<input type="text" class="form-control" placeholder="${loginfo.talentDt}" readonly>
  		</div>
  		<div class="form-group">
    		<label>기부받을 재능</label>
    		<input type="text" class="form-control" placeholder="${loginfo.talentGet}" readonly>
  		</div>
	</form>
	</div>
</body>
</html>