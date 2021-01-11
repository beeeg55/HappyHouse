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
span{
	background-color: #f8ecc9;
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
			<button  class="btn btn-dark" onClick="location.href='${pageContext.request.contextPath}/notice/main'"
				style="float: right;">목록</button>
		</div>
		<div></div>
		<!-- 공지테이블  -->
		<form action="${pageContext.request.contextPath}/notice/update" method="post">
		<div class="jumbotron bg-white text-center">
        <div class="form-group" style="text-align: center; display: grid">
				<span><b>제목</b></span><input type="text" name = "title" value = "${notice.title}"><br>
				<span><b>내용</b></span> <textarea rows="10" cols="50" style="height: 300px;" name = "des">${notice.des}</textarea>
				<input type = "hidden" name = "id" value = "${notice.id}">
		</div>
		<c:if test="${useage == 100}">
		<button onClick="location.href='${pageContext.request.contextPath}/notice/delete?id=${notice.id}'" type="button" class="center-block btn btn-warning">삭제</button>
		<button type="submit" class="btn btn-primary">수정</button>
		</c:if>
      </div>
	</form>
	</section>
<jsp:include page="/WEB-INF/views/common/bottombar.jsp"></jsp:include>
</body>
</html>