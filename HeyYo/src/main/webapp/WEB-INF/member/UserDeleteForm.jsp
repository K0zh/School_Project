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

<script src="resources/js/jquery.js" type="text/javascript"></script>
<script type="text/javascript">
	function deleteBtn(){
		if($("input[id=pw]").val()==$("input[name=oriPw]").val()){
			alert("탈퇴 되었습니다.")
			document.location.href="deleteMember.mb?id="+$("input[name=memid]").val();
		}else{
			alert("비밀번호가 틀렸습니다.")
		}
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
		<center>
			<h3>내정보</h3>
		</center>

	<form>
		<div class="form-group">
    		<label>아이디</label>
    		<input type="text" class="form-control" placeholder="${mem.email}" readonly>
  		</div>
  		<div class="form-group">
    		<label>비밀번호</label>
    		<input type="password" class="form-control" id ="pw">
  		</div>
  		<input type="hidden" class="form-control" value="${mem.pw}" name="oriPw">
  		<input type="hidden" class="form-control" value="${mem.id}" name="memid">
		<input class="btn btn-primary" type="button" value="회원 탈퇴" onclick="deleteBtn()">	
		<input class="btn btn-primary" type="button" value="취소" onclick="location.href='myPage.mb?id=${mem.id}'"> 
	</form>
	</div>
</body>
</html>