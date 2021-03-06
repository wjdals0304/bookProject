<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>도서 주문</title>
	<link href="/bookMarket/resources/css/bootstrap_modify.css" rel="stylesheet">
    <link href="/bookMarket/resources/css/layout.css" rel="stylesheet">
    <link href="/bookMarket/resources/css/layout_css/header.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    
   	<script type="text/javascript">
	 	function order(){
	 		 alert("주문이완료되었습니다.");
	 	}
 	</script>
    
    <style>
		.img_size{
			height:450px;
			border:1px solid #DDD;	
			border-top-left-radius:5px;
			border-bottom-left-radius:5px;
			border-top-right-radius:5px;
			border-bottom-right-radius:5px;
		}
		.new_list{
			height:280px;
			margin-top:23px;
		}
		.book_list_img{
			height:180px;
			display:block;
			margin:0 auto;
			border:1px solid #DDD;
		}
		.best_list{
			margin-top:20px;
			height:280px;
		}
		.user_list{
			height:280px;
			margin-top:70px;
		}
		.table_border{
			width:90%;
			height:280px;
			margin:0 auto;
		}
		.border{
			border-top:1px solid #DDD;
			margin-top:5px;
		}
		.right{
			text-align:right;
			width:180px;
			padding:12px;
			font-size:20px;
			margin-left:10px;
		}
		.center{
			margin-top:5px;
			text-align:center;
		}
		h4{
			display:inline;
		}
		h6{
			display:inline;
		}
		.more{
			float:right;
			display:inline;
		}
		.top{
			background:#5e6b9e;
		}
		.book_img{
			padding-left:30px;
		}
		.title{
			font-size:35px;
			color:#3a60df;
			font-weight:bold;
			display:block;
		}
		.author{
			font-size:20px;
			border-right:1px solid #CCC;
			margin-right:15px;
			padding-right:15px;
			margin-bottom:20px;
		}
		.info{
			margin-bottom:20px;
		}
		.border_bottom{
			border-bottom:1px solid #CCC;
			margin-bottom:40px;
		}
		.price, .sale{
			display:block;
			margin-bottom:20px;
			font-size:18px;
		}
		.salesPrice{
			font-size:30px;
			color:red;
			font-weight:bold;
		}
		.sales{
			font-size:20px;
			margin-bottom:25px;
			display:block;
		}
		.price_info{
			border-bottom:1px solid #CCC;
			margin-bottom:50px;
		}
		.button{
			width:180px;
			padding:12px;
			font-size:20px;
			margin-left:10px;
		}
		.book_info{
			border-top:3px solid #DDD;
			padding:50px 30px;
			margin-top:20px;
			margin-bottom:20px;
			font-size:20px;
		}
		/* basket css*/
		.sub_button{
			padding:2px;
			width:80px;
			display:block;
			margin:5px auto 5px;
			background-color:#EEE;
			padding:3px;
			border-top-right-radius:5px;
			border-bottom-right-radius:5px;
			border-bottom-left-radius:5px;
			border-top-left-radius:5px;
		}
		.book_list{
			margin-top:30px;
			width:100%;
			border-top:2px solid #333;
			border-bottom:1px solid #CCC;
			margin-bottom:50px;
		}
		.book_list th{
			border-bottom:1px solid #CCC;
			background-color:#ecf0f1;
			text-align:center;
			font-weight:bold;
			font-size:18px;
			padding:5px;
		}
		.order_img{
			height:150px;
			margin:20px 40px;
		}
		.book_title{
			font-size:18px;
		}
		.pay_table{
			width:100%;
			border-top:1px solid #899bdb;
			border-bottom:1px solid #899bdb;
		}
		.pay_table th{
			border-bottom:1px solid #899bdb;
			padding:10px 0 10px 20px;
			font-size:18px;
			font-weight:bold;	
			background-color:#dde5ff;
		}
		.pay_table td{
			border-bottom:1px solid #899bdb;
			padding:10px;
			font-size:30px;
			font-weight:bold;
			text-align:right;
		}
		.book_price{
			display:block;
		}
		.book_table_center{
			text-align:center;
		}
		.order_button{
	      float:right;
	      display:block;
	      margin:20px 0;
     
  		 }
  		 .degree{
  		 	font-weigh:bold;
  		 	font-size:20px;
  		 	border-top:1px solid #CCC;
  		 	border-bottom:1px solid #CCC;
  		 	padding:5px 20px;
  		 	background-color:#ecf0f1;
  		 	margin-bottom:40px;
  		 }
		
    </style>

</head>
<body>

<!-- Main Navigation ========================================================================================== -->
 
 <%@include file="/layout/mainNavigation.jsp" %>

<!-- Header ========================================================================================== -->
 
 <%@include file="/layout/header.jsp" %>

<!-- Container ======================================================================================= -->
<div class="container">
	<div class="degree">${sessionScope.member.userName} 님 &nbsp;&nbsp;&nbsp;  등급 : [${sessionScope.degree.degreeName }]</div>
	<h1>주문상품 목록</h1>
	
	<form action="/bookMarket/purchasedInfo/create" method="post">
			
		<table class="book_list">
			<colgroup>
	            <col style="width:250px">
	            <col style="width:400px">
	            <col style="width:250px;">
	            <col style="width:100px;">
	         </colgroup>
	         <thead>
				 <tr>
					<th colspan="2">상품정보</th>
					<th>판매가</th>
					<th>수량</th>
					<th>합계</th>
				 </tr>
			 </thead>
			 <tbody>
				 <c:set var="totalPrice" value="0" />
				 <c:forEach items="${purchasedInfoList}" var="purchasedInfo">
				 <input type="hidden" name="check" value="${purchasedInfo.book.bookId}${','}${purchasedInfo.count}">
				 
				 <tr>
					<td>
				        <img src="${purchasedInfo.book.img}" class="order_img" />
			        </td>
			        <td>
						<span class="book_title">${purchasedInfo.book.title}</span>
					</td>
					
					<td class="book_table_center">
						<span class="book_price">정가 :<fmt:formatNumber value="${purchasedInfo.book.price}" type="number" />원
							<br>${sessionScope.degree.discount}%↓
							<br><fmt:formatNumber value="${purchasedInfo.book.price * (1-(sessionScope.degree.discount)/100)}" type="number" />원 </td>
						</span>
					</td>
					<td class="book_table_center">${purchasedInfo.count}</td>
				 	<c:set var="price" value="${(purchasedInfo.book.price-(purchasedInfo.book.price * (sessionScope.degree.discount+0.0)/(100+0.0)))*purchasedInfo.count}" /> 
					<td class="book_table_center"><fmt:formatNumber value="${price}" type="number" />원 </td>
				</tr>
				
					<c:set var="totalPrice" value="${totalPrice + price}" />
				</c:forEach>
			</tbody>
		</table>
		
		<table class="pay_table">
			<colgroup>
				<col style="border-right:1px solid #899bdb;">
				<col style="border-right:1px solid #899bdb;">
			</colgroup>
			<thead>
				<tr>
					<th>상품금액</th>
					<th>배송비</th>
					<th>결제 예정금액</th>
				</tr>
			</thead>
			<tbody>
			<tr>
				<td><fmt:formatNumber value="${totalPrice}" type="number" />원</td>
				<td>0</td>
				<td><fmt:formatNumber value="${totalPrice}" type="number" />원</td>
			</tr>
			</tbody>
		</table>
		
			<c:forEach items="${basketItemIdList}" var="basketItemId">
				<input type="hidden" name="basketItemId" value="${basketItemId}">
			</c:forEach>
 			<input type="hidden" name="totalPrice" value="${totalPrice}">
			<button onclick="order();" class="btn btn-large btn-warning order_button">주문하기</button>
	
	</form>
	
<!-- Footer ========================================================================================== -->
   <%@include file="/layout/footer.jsp" %>
   
</div>

</body>
</html>