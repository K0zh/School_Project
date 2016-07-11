<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 기본 CSS -->
<link href="${pageContext.request.contextPath}/resources/common/default.css" rel="stylesheet">
</head>
<body>

	<!-- Login Modal JSP-->
	<jsp:include page="/WEB-INF/common/loginmodal.jsp" />

	<!-- Navigation Bar JSP  -->
	<jsp:include page="/WEB-INF/common/navbar.jsp" />


	<div class="container">
		<div class="center-block" style="width: 80%">
			<div class="form-inline">
				<div class="col-md-3 col-md-offset-3 col-xs-12 input-group">
					<input type="text" class="form-control" placeholder="지역명" name="location"> <span class="input-group-btn">
						<button class="btn btn-default" type="button" onclick="locationClick()">GO!</button>
					</span>
				</div>
				<div class="col-md-3  col-xs-12 input-group pull-right">
					<div class="input-group-btn">
						<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
							선택 <span class="caret"></span>
						</button>
						<ul class="dropdown-menu" role="menu">
							<li><a href="list.do">전체 보기</a></li>
							<li><a href="list.do?type=need">필요해요!</a></li>
							<li><a href="list.do?type=able">필요해요?</a></li>
							<li class="divider"></li>
						</ul>
					</div>
					<!-- /btn-group -->
					<input type="text" class="form-control" placeholder="키워드" name="talent"> <span class="input-group-btn">
						<button class="btn btn-default" type="button" onclick="talentClick()" style="height: 34px;">
							<i class="glyphicon glyphicon-search"></i>
						</button>
					</span>
				</div>
				<div class="col-md-3 col-xs-12 input-group pull-left">
					<input type="button" value="지도로 보기" onclick="location.href='main.do'" class="col-xs-6 btn btn-default"> <input type="button" value="리스트로 보기" class="col-xs-6 btn btn-default">
				</div>
			</div>
			<br>
			<!-- 게시판 형태 리스트 -->
			<table class="table table-bordered table-hover" style="width: 100%; margin: auto;">
				<thead>
					<tr>
						<th width="8%">글 번호</th>
						<th width="10%">프로필</th>
						<th width="65%">내용</th>
						<th width="17%">등록일</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach items="${contentLists}" var="content" varStatus="status">
						<tr>
							<td align="center">${content.NUM }
							<td>
								<div class="media-left">
									<img class="media-object" src="${pageContext.request.contextPath}/resources/images/profile/${content.IMAGE}" alt="image" width="50px">
								</div>
							</td>
							<td>
								<div class="media-body">
									<a href="detail.con?num=${content.NUM }&id=${content.ID}">
										<h4 class="media-heading"><b>${content.SUBJECT }</b></h4> 
										<c:if test="${content.TYPE eq 'able'}">
											able : 
										</c:if>
										<c:if test="${content.TYPE eq 'need'}">
											need : 
										</c:if>
										${content.TALENT }
									</a>
								</div>
							</td>
							<td><fmt:formatDate value="${content.C_DATE }" pattern="yyyy년 MM월 dd일" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<br>
		<input type="button" value="요청/나눔 등록" onclick="location.href='write.con'" class="col-md-8 col-md-offset-2 col-xs-12 btn btn-primary">
		<div class="col-md-12 col-xs-12 text-center">${pageInfo.pagingHtml}</div>
	</div>


	<!-- 사이드바 토글 Script -->
	<script>
		/* 사이드바 토글 */
		$("#menu-toggle").click(function(e) {
			e.preventDefault();
			$("#wrapper").toggleClass("toggled");
		});
	</script>

	<script type="text/javascript">
		function talentClick() {
			var talent = $("input[name=talent]").val();
			location.href = 'list.do?talent=' + talent;
		}
	</script>

</body>
</html>
