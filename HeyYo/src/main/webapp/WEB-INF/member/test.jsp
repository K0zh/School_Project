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
			<h3>������</h3>
		</center>
		
		<%-- 	
	���̵� ��� ã�� �׽�Ʈ
	<c:out value="${mb.email}"/><br>
	<c:out value="${mb.pw}"/><br>
	<c:out value="${mb.name}"/> --%>

	<form>
		<div class="form-group">
    		<label>�̸���</label>
    		<input type="text" class="form-control" placeholder="${loginfo.email}" readonly>
  		</div>
  		<div class="form-group">
    		<label>�̸�</label>
    		<input type="text" class="form-control" placeholder="${loginfo.name}" readonly>
  		</div>
  		<div class="form-group">
    		<label>��ȭ��ȣ</label>
    		<input type="text" class="form-control" placeholder="${loginfo.hp}" readonly>
  		</div>
		<div class="form-group">
    		<label>�ּ�</label>
    		<input type="text" class="form-control" placeholder="${loginfo.address}" readonly>
  		</div>
  		<div class="form-group">
    		<label>�������</label>
    		<input type="text" class="form-control" placeholder="${loginfo.birthday}" readonly>
  		</div>
  		<div class="form-group">
    		<label>��ι��� ���</label>
    		<input type="text" class="form-control" placeholder="${loginfo.talentDt}" readonly>
  		</div>
  		<div class="form-group">
    		<label>��ι��� ���</label>
    		<input type="text" class="form-control" placeholder="${loginfo.talentGet}" readonly>
  		</div>
	</form>
	</div>
</body>
</html>