<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/common/common.jsp"%>
<!-- 네비게이션 바 -->
<nav class="navbar navbar-fixed-top navbar-inverse">
	<div class="container-fluid">
		<div class="col-xs-2">
			<div id="navbar" class="text-left">
				<a class="navbar-brand glyphicon glyphicon-menu-hamburger"
					href="#menu-toggle" id="menu-toggle"> </a>
			</div>
		</div>
		<div class="col-xs-8" style="border: 10px">
			<div class="row">
				<br>
				<div class="col-lg-6">
					<div class="input-group">
						<div class="input-group-btn">
							<button type="button" class="btn btn-default dropdown-toggle"
								data-toggle="dropdown" aria-expanded="false">
								선택 <span class="caret"></span>
							</button>
							<ul class="dropdown-menu" role="menu">
								<li><a href="main.do">전체 보기</a></li>
								<li><a href="main.do?type=need">필요해요!</a></li>
								<li><a href="main.do?type=able">필요해요?</a></li>
								<li class="divider"></li>
								<li><a href="write.con">요청,나눔글 작성</a></li>
							</ul>
						</div>
						<!-- /btn-group -->
						<input type="text" class="form-control" placeholder="키워드"
							aria-label="..." name="talent"> <span
							class="input-group-btn">
							<button class="btn btn-default" type="button"
								onclick="talentClick()">
								<span class="glyphicon glyphicon-search"></span>
							</button>
						</span>
					</div>
					<!-- /input-group -->
				</div>
				<!-- /.col-lg-6 -->
				<div class="col-lg-6">
					<div class="input-group">
						<input type="text" class="form-control" placeholder="지역명"
							name="location"> <span class="input-group-btn">
							<button class="btn btn-default" type="button"
								onclick="locationClick()">GO!</button>
						</span>
					</div>
					<!-- /input-group -->
				</div>
				<!-- /.col-lg-6 -->
			</div>
			<!-- /.row -->
		</div>
		<div class="col-xs-2">
			<div id="navbar" class="navbar-right">
				<a class="navbar-brand glyphicon glyphicon-user" href="#"
					data-toggle="modal" data-target="#loginModal"> </a>
			</div>
		</div>
	</div>
</nav>
<!-- 네비게이션 바 end -->
<script type="text/javascript">
	function talentClick() {
		var talent = $("input[name=talent]").val();
		location.href = 'main.do?talent=' + talent;
	}

	function locationClick() {

	}
</script>