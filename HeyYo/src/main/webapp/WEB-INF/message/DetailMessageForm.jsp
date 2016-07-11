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
			<h3>쪽지보기</h3>
		</center>
		<form>
		<div class="form-group">
    	<label>보낸 사람</label>
    	<input type="text" class="form-control" name="sender" value="${message.sender}" readonly>
    	<label>받는 사람</label>
    	<input type="text" class="form-control" name="receiver" value="${message.receiver}" readonly>
  		</div>
		<textarea class="form-control" rows="5" name="ms_content" readonly>${message.ms_num}</textarea><br>
		<input type="button" value="삭제" class="btn btn-primary btn-md btn-block"
				onclick="location.href='delete.ms?messageType=${messageType}&ms_num=${message.ms_num}&sender=${message.sender}&receiver=${message.receiver}'">
		</form>
	</div>
</body>
</html>