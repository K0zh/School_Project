<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@include file="/WEB-INF/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div id="wrapper">
	
		<center><h3>아이디 찾기</h3></center>
		<form action="idInquiry.mb" method="post">
		
		<div class="form-group">
    		<label>이름</label>
    		<input type="text" class="form-control" name="name" placeholder="이름을 입력하세요" required>
  		</div>
  		
		<div class="form-group">
    		<label>휴대폰번호</label>
    		<input type="text" class="form-control" name="hp" placeholder="01012341234" required>
  		</div>
			
		<input type="submit" value="Email찾기" class="btn btn-primary btn-md btn-block">
		
		</form>
		
		
	</div>
</body>
</html>