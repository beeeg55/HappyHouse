<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../common/common.css" />
<link rel="stylesheet" type="text/css" href="notice.css" />
<link rel="stylesheet" href="../plugin/jquery-ui/jquery-ui.css">
<link rel="stylesheet" href="../plugin/jqgrid/css/ui.jqgrid.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-2.2.1.min.js"></script>
<script src="../plugin/jqgrid/js/i18n/grid.locale-kr.js" type="text/javascript"></script>
<script src="../plugin/jqgrid/js/jquery.jqGrid.min.js" type="text/javascript"></script>
<style>
.white {
	color: white;
}
.container{
	margin : 10px;
}
</style>
<meta charset="UTF-8">
<title>공지사항</title>
</head>
<!--  start body -->
<body>
	<jsp:include page="/WEB-INF/views/common/topbar.jsp"></jsp:include>
	<section class="container">
		<!-- 공지 section, 글쓰기 버튼  -->
		<div class="list">
			<br/><h3>공지사항</h3>
			<button type="button" class="btn btn-dark" data-toggle="modal" data-target="#write"
				style="float: right;">글쓰기</button>
		</div>
		<!-- 공지테이블  -->
		<div class="jumbotron bg-white text-center">
         <table class="table">
            <thead class="thead-light">
               <tr>
                  <th>번호</th>
                  <th>날짜</th>
                  <th>제목</th>
               </tr>
            </thead>
            <tbody>
               <c:forEach items="${noticeList}" var="notice" varStatus="status">
                  <tr>
                     <td>${notice.id}</td>
                     <td>${notice.date }</td>
                     <td><a href = "${pageContext.request.contextPath}/notice/select?id=${notice.id}">${notice.title}</a></td>
                  </tr>
               </c:forEach>
            </tbody>
         </table>
      </div>

	</section>
<jsp:include page="/WEB-INF/views/common/bottombar.jsp"></jsp:include>
</body>
<form action="${pageContext.request.contextPath}/notice/write" method="post">
<div class="modal" id="write">
	<div class="modal-dialog">
		<div class="modal-content">

			<!-- Modal Header -->
			<div class="modal-header">
				<h4 class="modal-title">글 작성</h4>
			</div>

			<!-- Modal body -->
			<div class="modal-body">
				<div class="form-group" style="text-align: center; display: grid">
					<input type="text" name = "title" placeholder="제목을 입력하세요."><br>
					<textarea rows="10" cols="50" style="height: 300px;"
						name = "des" placeholder="내용을 입력하세요." ></textarea>
				</div>
			</div>

			<!-- Modal footer -->
			<div class="modal-footer"
				style="display: inline-block; text-align: center;">
				<button type="button" class="center-block btn btn-warning"
					data-dismiss="modal">취소</button>
				<button type="submit" class="btn btn-primary" >확인</button>
			</div>

		</div>
	</div>
</div>
</form>
</html>