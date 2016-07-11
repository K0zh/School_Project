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



<script src="resources/js/jquery.js" type="text/javascript"></script>
<script type="text/javascript">
	$(function(){
		var add = document.getElementById("address1").selectedIndex;
	
		sel = document.getElementById("address2");
		for (i = sel.length - 1; i >= 0; i--) {
			sel.options[i] = null
		}
		for (i = 0; i < cnt[add].length; i++) {
			sel.options[i] = new Option(cnt[add][i], cnt[add][i]);
			
		}
	});
	
	function updateBtn(){
		if($("input[name=pw]").val()==$("input[name=oriPw]").val()){
			document.location.submit;
		}else{
			alert("비밀번호가 틀렸습니다.")
		}
	}
	
	function updateChange(add) {
		for (i = sel.length - 1; i >= 0; i--) {
			sel.options[i] = null
		}
		for (i = 0; i < cnt[add].length; i++) {
			sel.options[i] = new Option(cnt[add][i], cnt[add][i]);
		}
	}
</script>
<body>
	<div id="wrapper">
		<form name="UpdateForm" action="updateMember.mb" method="post">
			<h3>회원 정보 변경</h3>
			
			
			<div class="form-group">
    		<label>이메일 주소</label>
    		<input type="email" class="form-control" name="email" placeholder="${mem.email }" readonly>
  			</div>
  			
  			<div class="form-group">
  			<label>기존 비밀번호</label>
  			<input type="password" class="form-control" name="pw" placeholder="기존 비밀번호">
  			</div>
  			
  			<div class="form-group">
  			<label>변경할 비밀번호</label>
  			<input type="password" class="form-control" name="updatePw" placeholder="변경 비밀번호">
  			</div>
  			
  			<div class="form-group">
  			<label>변경할 비밀번호 확인</label>
  			<input type="password" class="form-control" name="rePw" placeholder="비밀번호 확인">
  			</div>
  			
  			
			<div class="form-group">
				<label>이름</label> 
				<div class="form-inline">
				<input type="text" class="form-control" value="${mem.name }" name="name">
				<input type="text" class="form-control" value="${mem.gender }" name="gender">
				</select>
				</div>
			</div>
			
			<div class="form-group">
  			<label>생년월일</label>s
  			<div class="form-inline">
  			<input type="text" class="form-control" value="${mem.birthday }" name="gender">
  			</div>
  			</div>
			
			<div class="form-group">
				<label>전화번호</label>
				<div class="form-inline">
				 <input type="text" class="form-control" value="${mem.hp }" name="hp">
				<label class="radio-inline">
 				<input type="radio" name="hpopen" value="공개">공개
				</label>
				<label class="radio-inline">
 				<input type="radio" name="hpopen" value="비공개">비공개
				</label>
				<input class="btn btn-info" type="button" value="인증">
				</div>
			</div>
			<input type="hidden" class="form-control" value="${mem.address}" name="oriAdd">
			<div class="form-group">
			<label for="address1">나의 활동 지역</label> 
				<div class="form-inline">
					<select class="form-control" id="address1" name="address" onchange="updateChange(this.selectedIndex)" class="input">
						<option value="전체">전체</option>
						<option value="서울" <c:if test="${mem.address.contains('서울')}"> selected </c:if>>서울</option>
						<option value="부산" <c:if test="${mem.address.contains('부산')}"> selected </c:if>>부산</option>
						<option value="대구" <c:if test="${mem.address.contains('대구')}"> selected </c:if>>대구</option>
						<option value="인천" <c:if test="${mem.address.contains('인천')}"> selected </c:if>>인천</option>
						<option value="광주" <c:if test="${mem.address.contains('광주')}"> selected </c:if>>광주</option>
						<option value="대전" <c:if test="${mem.address.contains('대전')}"> selected </c:if>>대전</option>
						<option value="울산" <c:if test="${mem.address.contains('울산')}"> selected </c:if>>울산</option>
						<option value="경기" <c:if test="${mem.address.contains('경기')}"> selected </c:if>>경기</option>
						<option value="강원" <c:if test="${mem.address.contains('강원')}"> selected </c:if>>강원</option>
						<option value="충북" <c:if test="${mem.address.contains('충북')}"> selected </c:if>>충북</option>
						<option value="충남" <c:if test="${mem.address.contains('충남')}"> selected </c:if>>충남</option>
						<option value="전북" <c:if test="${mem.address.contains('전북')}"> selected </c:if>>전북</option>
						<option value="전남" <c:if test="${mem.address.contains('전남')}"> selected </c:if>>전남</option>
						<option value="경북" <c:if test="${mem.address.contains('경북')}"> selected </c:if>>경북</option>
						<option value="경남" <c:if test="${mem.address.contains('경남')}"> selected </c:if>>경남</option>
						<option value="제주" <c:if test="${mem.address.contains('제주')}"> selected </c:if>>제주</option>
					</select> 
					<select class="form-control" id="address2" name="address">
						<option>선택</option>
					</select>
				</div>
			</div>

			<div class="form-group">
				<label>나의 재능</label>
				<input type="text" class="form-control" id="talentDt" name="talentDt" value="${mem.talentDt}">
			</div>
			<div class="form-group">
				<label>배울 재능</label>
				<input type="text" class="form-control" id="talentGet" name="talentGet" value="${mem.talentGet}">
			</div>
			<input type="submit" value="변경하기" class="btn btn-primary btn-md btn-block" onclick="updateBtn()">
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