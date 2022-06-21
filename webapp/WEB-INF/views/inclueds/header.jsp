<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

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
</html>