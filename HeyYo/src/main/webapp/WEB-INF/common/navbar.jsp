<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/common/common.jsp"%>
<!-- 네비게이션 바 -->
<nav class="navbar navbar-fixed-top navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        		<span class="icon-bar"></span>
        		<span class="icon-bar"></span>
        		<span class="icon-bar"></span>                        
      		</button>
      		<a class="navbar-brand" href="/heyyo">
      		<img src="${pageContext.request.contextPath}/resources/images/doum_logo.png" width="80px">
      		</a>
      	</div>
      	<div class="collapse navbar-collapse" id="myNavbar">
      		<ul class="nav navbar-nav">
        		<li><a href="#">Page 1</a></li>
        		<li><a href="#">Page 2</a></li>
        		<li><a href="#">Page 3</a></li>
        		<li class="divider"></li>
      		</ul>
      		<ul class="nav navbar-nav navbar-right">
      			<c:choose>
					<c:when test="${sessionScope.loginfo == null}">
        				<li><a href="signup.mb"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
        				<li><a href="#" data-toggle="modal" data-target="#loginModal">
        					<span class="glyphicon glyphicon-log-in"></span> Login</a></li>
        			</c:when>
        			<c:otherwise>
						<div>
							<font color="white">${sessionScope.loginfo.name} 님 환영 합니다.</font>
							<input type="button" value="myPage" onclick="location.href='myPage.mb'"> 
							<input type="button" value="로그아웃" onclick="location.href='logout.mb'">
						</div>
					</c:otherwise>
        		</c:choose>
      		</ul>
    	</div>
    </div>
</nav>
<!-- 네비게이션 바 end -->
