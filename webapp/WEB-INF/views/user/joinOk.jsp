<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
		<jsp:include page="/WEB-INF/views/inclueds/header.jsp"></jsp:include>
		<!-- //header -->

		<jsp:include page="/WEB-INF/views/inclueds/nav.jsp"></jsp:include>
		<!-- //nav -->

		<jsp:include page="/WEB-INF/views/inclueds/aside.jsp"></jsp:include>
			<!-- //aside -->

			<div id="content">

				<div id="content-head">
					<h3>회원가입</h3>
					<div id="location">
						<ul>
							<li>홈</li>
							<li>회원</li>
							<li class="last">회원가입</li>
						</ul>
					</div>
					<div class="clear"></div>
				</div>
				<!-- //content-head -->

				<div id="user">
					<div id="joinOK">

						<p class="text-large bold">
							회원가입을 축하합니다.<br> <br> <a href="/mysite4.1/loginForm">[로그인하기]</a>
						</p>

					</div>
					<!-- //joinOK -->
				</div>
				<!-- //user -->
			</div>
			<!-- //content  -->
		</div>
		<!-- //container  -->


		<jsp:include page="/WEB-INF/views/inclueds/footer.jsp"></jsp:include>
		<!-- //footer -->

	</div>
	<!-- //wrap -->

</body>

</html>