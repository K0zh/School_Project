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
		<center><h3>비밀번호 찾기</h3></center>
		<form action="pwInquiry.mb" method="post">
		
		<div class="form-group">
    		<label>이메일</label>
    		<input type="email" class="form-control" name="email" placeholder="이메일을 입력하세요" required>
  		</div>
		
		<div class="form-group">
    		<label>이름</label>
    		<input type="text" class="form-control" name="name" placeholder="이름을 입력하세요" required>
  		</div>
  		
		<div class="form-group">
    		<label>휴대폰번호</label>
    		<input type="text" class="form-control" name="hp" placeholder="01072266086" required>
  		</div>
			
		<input type="submit" value="pw찾기" class="btn btn-primary btn-md btn-block">
		
		</form>
		
		
	</div>
</body>
</html>