<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-2.2.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="../common/common.css" />
<link rel="stylesheet" type="text/css" href="notice.css" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-2.2.1.min.js"></script>

<title>Insert title here</title>
<style type="text/css">
table {
	color: black;
	margin: 30px;
	margin-right: 10%;
	border-collapse: separate;
	border-spacing: 30px 30px;
}

.movetitle {
	color: black;
	font-size: 15px;
}

</style>
</head>
<body>
	
	<jsp:include page="/WEB-INF/views/common/topbar.jsp"></jsp:include>
	<section class="container">
		<br/><h3>사이트맵</h3>
		<table>
			<thead>
				<tr style = "background-color: #f8ecc9;">
					<th  style = "width: 200px;">페이지 명</th>
					<th style = "width: 800px;">기능</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>실거래가 조회</td>
					<td><a href='${root}/search/main'>지도와 함께 실시간으로 원하는 매물을 조회해보세요!</a></td>
				</tr>
				<tr>
					<td>스마트 조회</td>
					<td><a href='${root}/smartsearch/main'>원하는 지역, 원하는 가격으로 매물을 조회해보세요!</a></td>
				</tr>
				<tr>
					<td>관심지역</td>
					<td><a href='${root}/biz/main'>관심있는 지역의 주변 상권을 조회해보세요!</a></td>
				</tr>
				<tr>
					<td>안심지역/선별진료소</td>
					<td><a href='${root}/hospital/main'>관심 지역의 코로나 기관을 조회해보세요!</a></td>
				</tr>
				<tr>
					<td>공지사항</td>
					<td><a href='${root}/notice/main'>해피하우스 공지사항을 확인해주세요!</a></td>
				</tr>
			</tbody>
		</table>
	</section>
	<div class="form-group form-inline">
		
	</div>
	<jsp:include page="/WEB-INF/views/common/bottombar.jsp"></jsp:include>
</body>
</html>