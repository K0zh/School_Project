<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@include file="/WEB-INF/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link
	href="${pageContext.request.contextPath}/resources/css/sidebar.css"
	rel="stylesheet">
</head>
<body>
<jsp:include page="/WEB-INF/common/loginmodal.jsp" />


	<jsp:include page="/WEB-INF/common/navbar.jsp" />
	
	<div id="wrapper">
		<jsp:include page="/WEB-INF/common/sidebar.jsp" />
		<center>
			<h3>쪽지쓰기</h3>
		</center>
		<form action="sending.ms" method="post">
		<div class="form-group">
		<input type="hidden" id ="sender" name="sender" value="${sessionScope.loginfo.id }">
    	<label>받는 사람 : </label>${id}
    	<input type="hidden" id ="receiver" name="receiver" value="${id}">
  		</div>
		<textarea class="form-control" rows="5" placeholder="내용을 입력하세요" name="ms_content" id="ms_content"></textarea><br>
		<input type="submit" value="쪽지보내기" class="btn btn-primary btn-md btn-block">
		</form>
	</div>
</body>
</html>