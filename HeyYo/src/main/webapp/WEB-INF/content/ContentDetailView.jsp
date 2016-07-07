<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 기본 CSS -->
<link href="${pageContext.request.contextPath}/resources/common/reset.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/common/default.css" rel="stylesheet">
</head>
<body>

	<!-- Login Modal JSP-->
	<jsp:include page="/WEB-INF/common/loginmodal.jsp" />

	<!-- Navigation Bar JSP  -->
	<jsp:include page="/WEB-INF/common/navbar.jsp" />

	<div class="container">
		<div class="center-block" style="width: 80%">

			<!-- 콘텐츠 상세보기 부분 -->
			<div>
				<table class="table-bordered" style="width: 100%">
					<thead>
						<tr>
							<th width="10%"><b>${content.num }</b></th>
							<th width="80%"><b>${content.subject }</b></th>
							<th width="10%"><b>${content.c_date}</b></th>
						</tr>
						<tr>
							<th>키워드</th>
							<th colspan="2">${content.talent }</th>
					</thead>
					<tbody>
						<tr>
							<td colspan="3" height="300px">
								<div class="content">
									<div>${content.content }</div>
								</div>
							</td>
						</tr>
						<tr>
							<td colspan="3">
									<div class="center-block">
										<input type="button" value="신고 하기" class="btn btn-default">&nbsp;
										<input type="button" value="쪽지 보내기" class="btn btn-default">
									</div>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			<hr>

			<!-- 회원 상세보기 부분 -->
			<div>
				<div class="media">
					<div class="media-left media-middle">
						<a href="#"> <img class="media-object" src="..." alt="..." width="100px">
						</a>
					</div>
					<div class="media-body">
						<h4 class="media-heading">
							<b>${member.name}</b>님 상세보기
						</h4>
						<b>할 수 있어요!</b> : ${member.talentDt }<br> <b>하고 싶어요 !</b> : ${member.talentGet }<br> <font size="0.5">등급 : ${member.grade } | 이메일 : ${member.email }</font>
					</div>
				</div>
			</div>
			<hr>

			<div>
				<label class="label"><font color="black" size="3">신청하기</font> </label>
				<table class="table">
					<tr>
						<td>
							<form action="matching.con" method="post">
								<div class="form-inline" id="requestDiv">
									<input type="hidden" name="m_num" value="${content.num }"> 
									<input type="hidden" name="m_name" value="${sessionScope.loginfo.name }"> 
									<input type="hidden" name="m_id" value="${sessionScope.loginfo.id}">
									
										<textarea class="col-md-10 form-control" rows="1" cols="110" name="introduce"  <c:if test="${sessionScope.loginfo == null }">disabled</c:if> >
											<c:if test="${sessionScope.loginfo == null }">로그인이 필요합니다.</c:if>
										</textarea>
									
										<input type="submit" value="신청" class="col-md-1 col-xs-12 btn btn-primary" <c:if test="${sessionScope.loginfo == null }">disabled</c:if>  >
									
								</div>
							</form>
						</td>
					</tr>

				</table>

				<%-- <c:if test="${sessionScope.id eq content.id}"> --%>
				<table class="table table-bordered table-hover">
					<thead>
						<tr class="text-center">
							<th width="10%">Num</th>
							<th width="20%">Name</th>
							<th width="60%">내용</th>
							<th width="10%">동의</th>
						</tr>
					<thead>
					<tbody>
						<c:forEach items="${matchingList}" var="matching" varStatus="status">
							<tr>
								<td>${status.count }</td>
								<td><a href="user_detail.mb?id=${matching.M_ID}">${matching.M_NAME}</a></td>
								<td><a href="user_detail.mb?id=${matching.M_ID}">${matching.INTRODUCE}</a></td>
								<td>
									<form action="agree.con" method="post">
										<input type="hidden" name="id_able" value="${matching.M_ID}"> 
										<input type="hidden" name="id_need" value="${content.id }"> 
										<input type="submit" value="수락"> 
										<input type="button" value="거절" onclick="deny(${matching.M_ID}, ${matching.M_NUM}, ${content.id})">
									</form>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<%-- </c:if> --%>
			</div>
		</div>
	</div>
	<!-- /#container -->
	<script type="text/javascript">
		function matching() {
			$("#requestDiv").hide;
			$("#requestDiv").toggle();
		}
		
		function deny(m_id, id, num) {
			document.location.href="deny.con?m_id="+m_id+"&id="+id+"&num="+num;
		}
		
	</script>

</body>
</html>