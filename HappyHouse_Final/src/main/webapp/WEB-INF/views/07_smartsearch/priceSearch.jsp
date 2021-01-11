<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../common/common.css" />
<link rel="stylesheet" href="../plugin/jquery-ui/jquery-ui.css">
<link rel="stylesheet" href="../plugin/jqgrid/css/ui.jqgrid.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-2.2.1.min.js"></script>
<script src="../plugin/jqgrid/js/i18n/grid.locale-kr.js" type="text/javascript"></script>
<script src="../plugin/jqgrid/js/jquery.jqGrid.min.js" type="text/javascript"></script>
<link rel="shortcut icon" href="http://designm.ag/favicon.ico">
  <link rel="icon" href="http://designm.ag/favicon.ico">
  <link rel="stylesheet" type="text/css" media="all" href="css/styles.css">
  <link rel="stylesheet" type="text/css" media="all" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.16/themes/base/jquery-ui.css">
  <link rel="stylesheet" type="text/css" media="all" href="http://fonts.googleapis.com/css?family=Acme">
  <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
  <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"></script>
<style>
div.ui-slider-range.ui-widget-header {
    background: #cfdac8;
}
.white {
	color: white;
}
.container{
	margin : 10px;
}
.setting{
	background-color: #f8ecc9;
	color: black;
}
#dongContainer{
	margin-bottom: 10px;
}
</style>
<script>
$(function(){
	  $('#rangeslider').slider({
	    range: true,
	    min: 7500,
	    max: 242000,
	    values: [ 9000, 30000 ],
	    slide: function( event, ui ) {
	      $('#rangeval').html(ui.values[0]+" - "+ui.values[1]);
			$.get("${pageContext.request.contextPath}/smartsearch/price"
				,{start: ui.values[0], end: ui.values[1], dong: $("#dong").val()}
				,function(data, status){
					$("#searchResult").empty();
					$.each(data, function(index, vo) {
						let str = "<tr>"
						+ "<td>" + vo.no + "</td>"
						+ "<td>" + vo.dong + "</td>"
						+ "<td>" + vo.aptName + "</td>"
						+ "<td>" + vo.dealAmount + "</td>"
						$("#searchResult").append(str);
					});//each
				}//function
				, "json"
			);//get
	    }
	  });
	});

</script>
<meta charset="UTF-8">
<title>가격대 별 매물 조회</title>
</head>
<!--  start body -->
<body>
	<jsp:include page="/WEB-INF/views/common/topbar.jsp"></jsp:include>
	<section class="container">
		<!-- 공지 section, 글쓰기 버튼  -->
		<div class="list">
		<br/><h3>스마트매물 조회</h3>
				<span class = "setting">원하시는 법정동을 설정해주세요</span>
				<div id = "dongContainer">
				법정동: <input type="text" name="dong" id = "dong" /> <br/>
				</div>
				
				<span class = "setting">원하시는 가격대를 설정해주세요</span>
				<div id="rangedval">
				가격대: <span id="rangeval">9000 - 10000</span>(단위 : 천만원)
  				</div>
  			<div id="rangeslider"></div>
				
		</div>
		<div class="jumbotron bg-white text-center">
         <table id="resultTable" class="table table-bordered table-hover text-center">
				<thead>
					<tr>
						<th>번호</th>
						<th>법정동</th>
						<th>아파트이름</th>
						<th>실거래가</th>
					</tr>
				</thead>
				<tbody id="searchResult">
					</tbody>
				</table>
      </div>

	</section>
<jsp:include page="/WEB-INF/views/common/bottombar.jsp"></jsp:include>
</body>
</html>