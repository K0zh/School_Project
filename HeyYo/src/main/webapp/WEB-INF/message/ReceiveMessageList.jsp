<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 체크박스 체크부분 -->
<script  src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
    $("input[type='checkbox']").click(function(){
       if($(this).attr("id") == "checkAll") {
           $("input[id!='checkAll']").attr("checked", $(this).is(":checked"));
       } else {
           var checked = $(this).is(":checked");
           if(!checked) {
               $("#checkAll").attr("checked", false);
           }
       } 
   }); 
});

</script>

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
			<h3>쪽지함</h3>
		</center>
		<a class="btn btn-default" href="sendList.ms" role="button">보낸쪽지</a>
		<a class="btn btn-default" href="delete.ms" role="button">삭제</a>
		<div class="table-responsive">
			<table class="table table-bordered">
				<tr>
				<th width="8%"><input type="checkbox"  name="checkAll" id="checkAll" /></th>
				<th width="15%">보낸사람</th>
				<th width="40%">내용</th>
				<th width="10%">날짜</th>
				</tr>
				
				<c:forEach items="${messageLists}" var="message" varStatus="status">
					<tr>
					<td width="8%"><input type="checkbox"  name="${message.MS_NUM}" id="${message.MS_NUM}" /></td>
					<td width="15%">${message.SENDER}</td>
					<td width="40%">${message.MS_CONTENT}</td>
					<td width="10%">${message.MS_DATE}</td>
					</tr>
				
				</c:forEach>
				
				<!-- <tr><td><input type="checkbox" name="box1"/></td></tr> -->
				
			</table>
		</div>
		
	</div>
</body>
</html>