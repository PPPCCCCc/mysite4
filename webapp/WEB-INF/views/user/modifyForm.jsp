<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/mysite4.1/assets/css/mysite.css" rel="stylesheet" type="text/css">
<link href="/mysite4.1/assets/css/user.css" rel="stylesheet" type="text/css">

</head>

<body>
	<div id="wrap">

		<div id="header" class="clearfix">
			<h1>
				<a href="">MySite</a>
			</h1>
			<c:if test="${empty sessionScope.authUser }">
				<!-- 로그인 실패, 로그인전 -->
				<ul>
					<li><a href="/mysite4.1/loginForm" class="btn_s">로그인</a></li>
					<li><a href="/mysite4.1/joinForm" class="btn_s">회원가입</a></li>
				</ul>
			</c:if>

			<c:if test="${!empty sessionScope.authUser }">
				<!-- 로그인 성공 -->
				<ul>
					<li>${authUser.getName()}님안녕하세요^^</li>
					<li><a href="/mysite4.1/logout" class="btn_s">로그아웃</a></li>
					<li><a href="/mysite4.1/modifyForm" class="btn_s">회원정보수정</a></li>
				</ul>
			</c:if>

		</div>
		<!-- //header -->

		<div id="nav">
			<ul class="clearfix">
				<li><a href="">입사지원서</a></li>
				<li><a href="">게시판</a></li>
				<li><a href="">갤러리</a></li>
				<li><a href="">방명록</a></li>
			</ul>
		</div>
		<!-- //nav -->

		<div id="container" class="clearfix">
			<div id="aside">
				<h2>회원</h2>
				<ul>
					<li>회원정보</li>
					<li>로그인</li>
					<li>회원가입</li>
				</ul>
			</div>
			<!-- //aside -->

			<div id="content">

				<div id="content-head">
					<h3>회원정보</h3>
					<div id="location">
						<ul>
							<li>홈</li>
							<li>회원</li>
							<li class="last">회원정보</li>
						</ul>
					</div>
					<div class="clear"></div>
				</div>
				<!-- //content-head -->

				<div id="user">
					<div id="modifyForm">
						<form action="/mysite4.1/modifyForm" method="get">

							<!-- 아이디 -->
							<div class="form-group">
								<label class="form-text" for="input-uid">아이디</label> <span class="text-large bold">${requestScope.userVo.id }</span>
							</div>

							<!-- 비밀번호 -->
							<div class="form-group">
								<label class="form-text" for="input-pass">패스워드</label> <input type="text" id="input-pass" name="password" value="${requestScope.userVo.password }" placeholder="비밀번호를 입력하세요">
							</div>

							<!-- 이메일 -->
							<div class="form-group">
								<label class="form-text" for="input-name">이름</label> <input type="text" id="input-name" name="name" value="${requestScope.userVo.name }" placeholder="이름을 입력하세요">
							</div>

							<!-- //나이 -->
							<div class="form-group">
								<span class="form-text">성별</span>
								<!-- eq? -->
								<c:choose>
									<c:when test="${userVo.gender == 'male'}">
										<label for="rdo-male">남</label>
										<input type="radio" id="rdo-male" name="gender" value="male" checked="checked">
										<label for="rdo-female">여</label>
										<input type="radio" id="rdo-female" name="gender" value="female">
									</c:when>
									<c:otherwise>
										<label for="rdo-male">남</label>
										<input type="radio" id="rdo-male" name="gender" value="male">
										<label for="rdo-female">여</label>
										<input type="radio" id="rdo-female" name="gender" value="female" checked="checked">

									</c:otherwise>

								</c:choose>

							</div>

							<!-- 버튼영역 -->
							<div class="button-area">
								<button type="submit" id="btn-submit">회원정보수정</button>
							</div>

						</form>


					</div>
					<!-- //modifyForm -->
				</div>
				<!-- //user -->
			</div>
			<!-- //content  -->

		</div>
		<!-- //container  -->

		<div id="footer">Copyright ⓒ 2020 황일영. All right reserved</div>
		<!-- //footer -->

	</div>
	<!-- //wrap -->

</body>

</html>