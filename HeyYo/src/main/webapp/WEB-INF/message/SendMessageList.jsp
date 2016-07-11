<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<!-- SideBar CSS -->
<link
	href="${pageContext.request.contextPath}/resources/css/sidebar.css"
	rel="stylesheet">
<body>


	<jsp:include page="/WEB-INF/common/loginmodal.jsp" />


	<jsp:include page="/WEB-INF/common/navbar.jsp" />
	
	<div id="wrapper">
		<jsp:include page="/WEB-INF/common/sidebar.jsp" />
		<center>
			<h3>보낸 쪽지함</h3>
		</center>
		<a class="btn btn-default" href="receiveList.ms?receiver=${sessionScope.loginfo.id}" role="button">받은쪽지</a>
		<div class="table-responsive">
			<table class="table table-bordered">
				<tr>
				<th width="15%">받는사람</th>
				<th width="40%">내용</th>
				<th width="10%">날짜</th>
				</tr>
				
				<c:forEach items="${messageLists}" var="message" varStatus="status">
					<tr>
					<td width="15%"><a href="write.ms?id=${message.RECEIVER }">
					${message.RECEIVER}</a></td>
					<td width="40%"><a href="detailMessage.ms?messageType=send&ms_num=${message.MSNUM }">
					${message.MSCONTENT}</a></td>
					<td width="10%">${message.MSDATE}</td>
					</tr>
				
				</c:forEach>
				
				<!-- <tr><td><input type="checkbox" name="box1"/></td></tr> -->
				
			</table>
		</div>
		
	</div>
</body>
</html>