<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/mysite4.1/assets/css/mysite.css" rel="stylesheet" type="text/css">
<link href="/mysite4.1/assets/css/user.css" rel="stylesheet" type="text/css">

<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery/jquery-1.12.4.js"></script>

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
				<div id="joinForm">
					<form id=" join-form" action="/mysite4.1/join" method="get">
						<!-- 아이디 -->
						<div class="form-group">
							<label class="form-text" for="input-uid">아이디</label> <input type="text" id="input-uid" name="id" value="" placeholder="아이디를 입력하세요">
							<button type="button" id="">중복체크</button>
						</div>

						<!-- 비밀번호 -->
						<div class="form-group">
							<label class="form-text" for="input-pass">패스워드</label> <input type="text" id="input-pass" name="password" value="" placeholder="비밀번호를 입력하세요">
						</div>

						<!-- 이메일 -->
						<div class="form-group">
							<label class="form-text" for="input-name">이름</label> <input type="text" id="input-name" name="name" value="" placeholder="이름을 입력하세요">
						</div>

						<!-- //나이 -->
						<div class="form-group">
							<span class="form-text">성별</span> <label for="rdo-male">남</label> <input type="radio" id="rdo-male" name="gender" value=""> <label for="rdo-female">여</label> <input type="radio" id="rdo-female" name="gender" value="">

						</div>

						<!-- 약관동의 -->
						<div class="form-group">
							<span class="form-text">약관동의</span> <input type="checkbox" id="chk-agree" value="" name=""> <label for="chk-agree">서비스 약관에 동의합니다.</label>
						</div>

						<!-- 버튼영역 -->
						<div class="button-area">
							<button type="submit" id="btn-submit">회원가입</button>
						</div>

					</form>
				</div>
				<!-- //joinForm -->
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
<script type="text/javascript">
	$("#join-form").on("btn-submit", function() {
		console.log("회원 가입 버튼 클릭");
		//event.preventDefault();
	
		var id = $("#input-uid").val();
		var password = $("#input-pass").val();
		if (id == "" || id ==null) {
			alert("아이디 입력");

			return false;
		}
		if (password.length < 8) {
			alert("비밀번호 입력");

			return false;
		}
		//약관동의
		var agree = $("#chk-agree").is(":checked");
		if (agree = false) {
			alert("약관동의 체크");
			
			return false;
		}
		return true;
	});
</script>
</html>