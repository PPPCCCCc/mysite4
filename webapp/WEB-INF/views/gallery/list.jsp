<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="${pageContext.request.contextPath }/assets/css/mysite.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath }/assets/css/gallery.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath }/assets/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css">

<script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/jquery/jquery-1.12.4.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/assets/bootstrap/js/bootstrap.js"></script>

</head>


<body>
	<div id="wrap">

		<!-- 해더 네비 -->
		<c:import url="/WEB-INF/views/inclueds/header.jsp"></c:import>

		<!-- //해더 네비 -->


		<div id="container" class="clearfix">
			<!-- 게시판 aside -->
			<c:import url="/WEB-INF/views/inclueds/galleryAside.jsp"></c:import>

			<!-- //게시판 aside -->

			<div id="content">

				<div id="content-head">
					<h3>갤러리</h3>
					<div id="location">
						<ul>
							<li>홈</li>
							<li>갤러리</li>
							<li class="last">갤러리</li>
						</ul>
					</div>
					<div class="clear"></div>
				</div>
				<!-- //content-head -->

				<div id="gallery">
					<div id="list">

						<c:if test="${authUser != null }">
							<button id="btnImgUpload">이미지올리기</button>
						</c:if>
						<div class="clear"></div>


						<ul id="viewArea">

							<!-- 이미지반복영역 -->
							<c:forEach items="${galleryList}" var="galleryVo">
								<li>
									<div class="view" id="t-${galleryVo.no }">
										<img data-no="${galleryVo.no }" class="imgItem" src="${pageContext.request.contextPath }/upload/${galleryVo.saveName } ">
										<div class="imgWriter">
											작성자: <strong> ${galleryVo.name } </strong>
										</div>
									</div>
								</li>
							</c:forEach>
							<!-- 이미지반복영역 -->


						</ul>
					</div>
					<!-- //list -->
				</div>
				<!-- //gallery -->


			</div>
			<!-- //content  -->
		</div>
		<!-- //container  -->


		<!-- 푸터 -->
		<c:import url="/WEB-INF/views/inclueds/footer.jsp"></c:import>

		<!-- //푸터 -->
	</div>
	<!-- //wrap -->



	<!-- 이미지등록 팝업(모달)창 -->
	<div class="modal fade" id="addModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">이미지등록</h4>
				</div>

				<form method="post" action="${pageContext.request.contextPath }/gallery/upload" enctype="multipart/form-data">
					<div class="modal-body">
						<div class="form-group">
							<label class="form-text">글작성</label> <input id="addModalContent" type="text" name="content" value="">
						</div>
						<div class="form-group">
							<label class="form-text">이미지선택</label> <input id="file" type="file" name="file" value="">
						</div>
					</div>
					<div class="modal-footer">
						<button type="submit" class="btn" id="btnUpload">등록</button>
					</div>
				</form>


			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->



	<!-- 이미지보기 팝업(모달)창 -->
	<div class="modal fade" id="viewModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">이미지보기</h4>
				</div>
				<div class="modal-body">

					<div class="formgroup">
						<img id="viewModelImg" src="">
						<!-- ajax로 처리 : 이미지출력 위치-->
					</div>

					<div class="formgroup">
						<p id="viewModelContent"></p>
					</div>

				</div>
				<form method="" action="">
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
						<button type="button" class="btn btn-danger" id="btnDel">삭제</button>
					</div>


				</form>

			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->


</body>


<script type="text/javascript">
	//리스트에서 이미지올리기 버튼을 클릭할때
	$("#btnImgUpload").on("click", function() {
		console.log("이미지 클릭버튼");

		//모달창 보이기
		$("#addModal").modal();
	});

	//리스트에서 이미즈 클릭
	$(".imgItem")
			.on(
					"click",
					function() {
						console.log("이미지클릭")

						//no 입력하기
						var no = $(this).data("no");
						console.log("test ");

						$.ajax({
									url : "${pageContext.request.contextPath }/api/gallery/gallerySelect",
									type : "post",
									//contentType : "application/json",
									data : {no : no},
									dataType : "json",
									success : function(galleryVo) {
										/*성공시 처리해야될 코드 작성*/
										console.log(galleryVo)

										$("#btnDel").val(no);
										imgVal(gallaryVo);
										$("#viewModelContent").text(
												gallaryVo.content);

										//모달창 보이기
										$("#viewModal").modal();

										var userno = galleryVo.userNo;

										if (userno != "${sessionScope.authUser.no}") {
											$("#btnDel").hide();
										} else {
											$("#btnDel").show();

										}
									},
									error : function(XHR, status, error) {
										console.error(status + " : " + error);
									}
								});
					});
	//모달창에서 삭제를 클릭했을때
	$("#btnDel").on("click", function() {
		console.log("삭제버튼")

		var no = $("#btnDel").val();

		$.ajax({
			url : "${pageContext.request.contextPath }/api/gallery/galleryDelete",
			type : "post",
			//contentType : "application/json",
			data : {no : no},
			dataType : "json",
			success : function(count) {
				/*성공시 처리해야될 코드 작성*/
				if (count === 1) {
					$("#viewModal").modal("hide");
					$("#t-" + no).remove();
				} else {
					$("#viewModal").modal("hide");
				}
			},
			error : function(XHR, status, error) {
				console.error(status + " : " + error);
			}
		});
	});
</script>

</html>

