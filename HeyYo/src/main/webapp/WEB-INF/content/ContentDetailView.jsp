<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	상세보기 페이지 입니다.
	
	아이디 : ${content.id }<br>
	제목 : ${content.subject }<br>
	본문 내용 : ${content.content }<br>
	주소 : ${content.location }<br>
	
	<input type="button" value="신청하기">
	
</body>
</html>