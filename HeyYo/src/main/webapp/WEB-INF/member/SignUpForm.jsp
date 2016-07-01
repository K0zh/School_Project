<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<!-- 재능 입력 (Tokenfield) CSS -->
<link href="${pageContext.request.contextPath}/resources/css/bootstrap-tokenfield.css" rel="stylesheet">
</head>

<body>
	
	<div id="wrapper">
		<form name="WriteForm" action="write.mb" method="post">
			<h3>원하는 시간에 재능을 나누세요</h3>

			
			<div class="form-group">
    		<label>이메일 주소</label>
    		<input type="email" class="form-control" name="email" placeholder="이메일을 입력하세요">
  			</div>
  			
  			<div class="form-group">
  			<label>비밀번호</label>
  			<input type="password" class="form-control" name="pw" placeholder="비밀번호">
  			</div>
  			
  			
			<div class="form-group">
				<label>이름</label> 
				<div class="form-inline">
				<input type="text" class="form-control" placeholder="홍길동" name="name">
				<select class="form-control" name="gender">
  				<option value="남자">남자</option>
  				<option value="여자">여자</option>
				</select>
				</div>
			</div>
			
			<div class="form-group">
  			<label>생년월일</label>s
  			<div class="form-inline">
  			<input type="date" name="birthday"class="form-control" placeholder="date input">
  			</div>
  			</div>
			
			<div class="form-group">
				<label>전화번호</label>
				<div class="form-inline">
				 <input type="text" class="form-control" placeholder="01012345678" name="hp">
				<label class="radio-inline">
 				<input type="radio" name="hpopen" value="공개">공개
				</label>
				<label class="radio-inline">
 				<input type="radio" name="hpopen" value="비공개">비공개
				</label>
				<input class="btn btn-info" type="button" value="인증">
				</div>
			</div>

			<div class="form-group">
			<label for="address1">나의 활동 지역</label> 
				<div class="form-inline">
					<select class="form-control" id="address1" name="address" onchange="change(this.selectedIndex);" class="input">
						<option value="전체">전체</option>
						<option value="서울">서울</option>
						<option value="부산">부산</option>
						<option value="대구">대구</option>
						<option value="인천">인천</option>
						<option value="광주">광주</option>
						<option value="대전">대전</option>
						<option value="울산">울산</option>
						<option value="경기">경기</option>
						<option value="강원">강원</option>
						<option value="충북">충북</option>
						<option value="충남">충남</option>
						<option value="전북">전북</option>
						<option value="전남">전남</option>
						<option value="경북">경북</option>
						<option value="경남">경남</option>
						<option value="제주">제주</option>
					</select> 
					<select class="form-control" id="address2" name="address">
						<option>선택</option>
					</select>
				</div>
			</div>

			<div class="form-group">
				<label>나의 재능</label>
				<input type="text" class="form-control" id="talentDt" name="talentDt">
			</div>
			<div class="form-group">
				<label>배울 재능</label>
				<input type="text" class="form-control" id="talentGet" name="talentGet">
			</div>

			<input type="submit" value="신청하기" class="btn btn-primary btn-md btn-block">
		</form>
	</div>
	<!-- /#wrapper -->

	<!-- 활동 지역 JS -->
	<script src="${pageContext.request.contextPath}/resources/js/address.js"></script>

	<!-- 재능 입력 (Tokenfield) JS -->
	<script src="${pageContext.request.contextPath}/resources/js/bootstrap-tokenfield.js"></script>
	<script type="text/javascript">
		$('#talentDt').tokenfield({
					showAutocompleteOnFocus : true
				});
		$('#talentGet').tokenfield({
					showAutocompleteOnFocus : true
				});
	</script>

</body>
</html>