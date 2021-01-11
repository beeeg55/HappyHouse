<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-2.2.1.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<title>주변탐방</title>
<script>
$(document).ready(function(){
	$.get("${pageContext.request.contextPath}/search/sido"
		,function(data, status){
			$.each(data, function(index, vo) {
				$("#sido").append("<option value='"+vo.sidoCode+"'>"+vo.sidoName+"</option>");
			});//each
		}//function
		, "json"
	);//get
	
});//ready
$(document).ready(function(){
	let sicode = $("#sido").val();
	$("#sido").change(function() {
		$.get("${pageContext.request.contextPath}/search/gugun"
				,{ sido:$("#sido").val()}
				,function(data, status){
					$("#gugun").empty();
					$("#gugun").append('<option value="0">선택</option>');
					$.each(data, function(index, vo) {
						$("#gugun").append("<option value='"+vo.gugunName+"'>"+vo.gugunName+"</option>");
					});//each
				}//function
				, "json"
		);//get
	});//change
	$("#gugun").change(function() {
		
		$.ajax({
			url:'${root}/hospital/gugun/' + $("#gugun").val(),
			type:'GET',
			contentType:'application/json;charset=utf-8',
			dataType:'json',
			success:function(data, status){
				$("#searchResult").empty();
				$.each(data, function(index, vo) {
					let str = "<tr>"
					+ "<td>" + vo.name + "</td>"
					+ "<td>" + vo.address + "</td>"
					+ "<td>" + vo.tel + "</td>"
					+ "</td></tr>";
					$("#searchResult").append(str);
				}); // each
			},
			error: function(xhr,status,error){
				console.log("상태값 : " + xhr.status + "\nHttp에러메시지 : " + xhr.responseText + "\nerror : " + error);
			}
		});
		
	 	$.ajax({
			url:'${root}/screening/gugun/' + $("#gugun").val(),
			type:'GET',
			contentType:'application/json;charset=utf-8',
			dataType:'json',
			success:function(data, status){
				$("#searchResult2").empty();
				$.each(data, function(index, vo) {
					let str = "<tr>"
						+ "<td>" + vo.name + "</td>"
						+ "<td>" + vo.address + "</td>"
						+ "<td>" + vo.weektime + "</td>"
						/* + "<td>" + vo.tel + "</td>" */
						+ "<td>" + vo.possible + "</td>"
						+ "</td></tr>";
						$("#searchResult2").append(str);
				}); // each
			},
			error: function(xhr,status,error){
				console.log("상태값 : " + xhr.status + "\nHttp에러메시지 : " + xhr.responseText + "\nerror : " + error);
			}
		});
		
		
	});//change
});//ready

</script>
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/topbar.jsp"></jsp:include>
	<section class="container">
	<br/><h3>안심병원/선별진료소</h3>
	<div class="form-group form-inline mt-1">
		<div class="category">
			<select type="button" class="btn m-3" id="sido"
				style="width: 100%">
				<option value="0">시/도 </option>
			</select>
		</div>
		<div class="category">
			<select type="button" class="btn m-3" id="gugun"
				style="width: 100%">
				<option value="0">구/군</option>
			</select>
		</div>
	</div>
	<br/><span><b>안심병원</b></span>
	<table id="resultTable"
		class="table text-center">
		<thead>
			<tr>
				<th>병원명</th>
				<th>위치</th>
				<th>전화번호</th> 
			</tr>
		</thead>
		<tbody id="searchResult">
		</tbody>
	</table>
	<br/>
	<br/><span><b>선별진료소</b></span>
	<table id="resultTable2"
		class="table text-center">
		<thead>
			<tr>
				<th>병원명</th>
				<th>위치</th>
				<th>운영시간</th>
				<!-- <th>전화번호</th> --> 
				<th>검체채취 가능여부</th>
			</tr>
		</thead>
		<tbody id="searchResult2">
		</tbody>
	</table>
	</section>
	<jsp:include page="/WEB-INF/views/common/bottombar.jsp"></jsp:include>
</body>
</html>