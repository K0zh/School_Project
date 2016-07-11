<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="/WEB-INF/common/common.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
    		<input type="text" class="form-control" placeholder="${mem.email}" readonly>
  		</div>
  		<div class="form-group">
    		<label>이름</label>
    		<input type="text" class="form-control" placeholder="${mem.name}" readonly>
  		</div>
  		<div class="form-group">
    		<label>전화번호</label>
    		<input type="text" class="form-control" placeholder="${mem.hp}" readonly>
  		</div>
		<div class="form-group">
    		<label>주소</label>
    		<input type="text" class="form-control" placeholder="${mem.address}" readonly>
  		</div>
  		<div class="form-group">
    		<label>생년월일</label>
    		<input type="text" class="form-control" placeholder="${mem.birthday}" readonly>
  		</div>
  		<div class="form-group">
    		<label>기부받을 재능</label>
    		<input type="text" class="form-control" placeholder="${mem.talentDt}" readonly>
  		</div>
  		<div class="form-group">
    		<label>기부받을 재능</label>
    		<input type="text" class="form-control" placeholder="${mem.talentGet}" readonly>
  		</div>
  		<input class="btn btn-primary" type="button" value="정보 수정" onclick="location.href='updateForm.mb?id=${mem.id}'"> 
		<input class="btn btn-primary" type="button" value="회원 탈퇴" onclick="location.href='deleteForm.mb?id=${mem.id}'">
	</form>
	</div>
</body>
</html>