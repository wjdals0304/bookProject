<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <title>구매 목록</title>
    <meta charset="utf-8">
    <link href="/bookMarket/resources/css/bootstrap_modify.css" rel="stylesheet">
    <link href="/bookMarket/resources/css/layout.css" rel="stylesheet">
    <link href="/bookMarket/resources/css/layout_css/header.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

	<!-- datepicker -->
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" />
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
	<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
	
	<script type="text/javascript">
	
	  $.datepicker.setDefaults({
	    dateFormat: 'yy-mm-dd',
	    prevText: '이전 달',
	    nextText: '다음 달',
	    monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
	    monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
	    dayNames: ['일', '월', '화', '수', '목', '금', '토'],
	    dayNamesShort: ['일', '월', '화', '수', '목', '금', '토'],
	    dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
	    showMonthAfterYear: true,
	    yearSuffix: '년'
	  });
	
	  $(function() {
	    $("#datepicker1, #datepicker2").datepicker();
	  });

	</script>
	
    <style>
        #testbanner{
            position: absolute;
            border: 2px solid #EEE;
            left : 1348px;
            top : 300px;
            width: 180px;
            height: 350px;
            padding-top:20px;
        }

		.img_size{
			height:300px;
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
      
      .paging_number{
      	display:none;
      }
      
      /*purchasedInfo css*/
      .purchased_info{
       		margin-top:30px;
			width:100%;
			border-left:1px solid #CCC;
			border-right:1px solid #CCC;
			margin-bottom:50px;
			border-top:2px solid #AAA;
			border-bottom:2px solid #AAA;
      }
      .purchased_info th{
			border-bottom:2px solid #AAA;
			background-color:#ecf0f1;
			text-align:center;
			font-weight:bold;
			font-size:18px;
			padding:5px;
		}
		.purchased_info td{
			border-bottom:1px solid #CCC;
			text-align:center;
			font-weight:bold;
			font-size:18px;
			padding:5px;
		}
		.purchased_img{
			height:150px;
			margin:20px 40px;
		}
      .datepicker{
      	text-align:center;
      	margin:30px 0 40px 0;
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
  	.search{
  		height:28px;
  		line-height:8px;
  		font-size:14px;
  		margin-top:-6px;
  	}
  	.datepicker_date{
 		border-top-left-radius:5px;
		border-bottom-left-radius:5px;
		border-top-right-radius:5px;
		border-bottom-right-radius:5px;
		border:1px solid #CCC;
		height:28px;
  	}
     .order{
     	font-size:18px;
     	margin-bottom:20px;
     }
     .paging{
     	margin:30px 0;
     	text-align:center;
     }
     .border{
     	border-bottom:1px solid #CCC;
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
	<form action="/bookMarket/purchasedInfo/list?datepicker1=${startDate}&datepicker2=${endDate}" method="get">
	  
	  <div class="degree">${sessionScope.member.userName} 님 &nbsp;&nbsp;&nbsp;  등급 : [${sessionScope.degree.degreeName }]</div>
	  
		  <div class="col-lg-12 datepicker"><span>조회기간 : </span>
		  <input type="text" class="datepicker_date" id="datepicker1" name="datepicker1" required  value="${startDate}"> ~ 
		  <input type="text" class="datepicker_date" id="datepicker2" name="datepicker2" value="${endDate}" required>
		  <button class="btn btn-large btn-default search">조회</button>
	  	</div>
  
	</form> 

    <div class="col-lg-12 col-lg-12">
	  	<table class="purchased_info">
					 
			<c:choose> 
				  <c:when test="${empty startDate }"> 
						<div class="order">최근 3개월 주문내역/<strong>총${orderList.size()}건</strong></div>
				  </c:when>
				  <c:otherwise>
				  		<div class="order">${startDate}~${endDate}/<strong>총${orderList.size()}건</strong></div>
				  </c:otherwise>
			</c:choose>
				
			<colgroup>
				<col width="14%" style="border-right:1px solid #CCC;" />
				<col width="14%" style="border-right:1px solid #CCC;" />
				<col width="70" style="border-right:1px solid #CCC;" />
				<col style="border-right:1px solid #CCC;"/>
				<col width="5%" style="border-right:1px solid #CCC;" />
				<col width="15%" style="border-right:1px solid #CCC;" />
				<col width="14%" />
			</colgroup>
				
				<tbody>
					<tr>
						<th scope="col">주문번호</th>
						<th scope="col">주문금액(할인율포함)</th>
						<th scope="col" colspan="2">상품정보</th>
						<th scope="col">수량</th>
						<th scope="col">주문상태</th>
					</tr>
						
					<c:choose>
						 <c:when test="${pagingOrderList.size() gt 0 }">
					    		<c:forEach items="${pagingOrderList}" var="order">
					    		<tr>
									<td rowspan="${order.purchasedInfoList.size()}">
										${order.orderId}<br>${order.orderDate}
									</td>
									<td rowspan="${order.purchasedInfoList.size()}"><fmt:formatNumber value="${order.totalPrice}" type="number" />원  </td> 
	
							 		<c:forEach items="${order.purchasedInfoList}" var="purchasedInfo">
										<td><img src="${purchasedInfo.book.img}" class="purchased_img"/></td>
								<td><a href="/bookMarket/book/detail?bookId=${purchasedInfo.book.bookId}">${purchasedInfo.book.title}</a><br>
											<fmt:formatNumber value="${purchasedInfo.book.price}" type="number" />원/${purchasedInfo.count}개
										</td>
										<td>${purchasedInfo.count}</td>
										<!--주문상태  -->
										<td>배송완료</td>
									</tr>
								</c:forEach>
							</c:forEach>
						</c:when>
						<c:otherwise>
		                        <tr>
		                            <th colspan="6">최근 주문목록이 없습니다.</th>
		                        </tr>
		                </c:otherwise>
					</c:choose>
				</tbody>
			</table>
        </div>
        
 	<div class="paging">       
		 
		 <c:choose>
		   	<c:when test="${ empty startDate }">
		   		<div class="paginate">
				     <a href="/bookMarket/purchasedInfo/list?index=${paging.firstPageNo}" ><img alt="처음페이지" src="http://image.kyobobook.co.kr/ink/images/common/btn_prev02_on.gif"></a>
					 <a href="/bookMarket/purchasedInfo/list?index=${paging.prevPageNo}" ><img alt="이전페이지" src="http://image.kyobobook.co.kr/ink/images/common/btn_prev_on.gif"></a>
				    	<span>
					        <c:forEach var="i" begin="${paging.startPageNo}" end="${paging.endPageNo}" step="1">
					            <c:choose>
					                <c:when test="${i eq paging.pageNo}"><a href="/bookMarket/purchasedInfo/list?index=${i}">${i}</a></c:when>
					                <c:otherwise><a href="/bookMarket/purchasedInfo/list?index=${i}">${i}</a></c:otherwise>
					            </c:choose>
					        </c:forEach>
		  		  		</span>
			   	 		<a href="/bookMarket/purchasedInfo/list?index=${paging.nextPageNo}" ><img alt="다음페이지" src="http://image.kyobobook.co.kr/ink/images/common/btn_next_on.gif"></a>
			    		<a href="/bookMarket/purchasedInfo/list?index=${paging.finalPageNo}" ><img alt="마지막페이지" src="http://image.kyobobook.co.kr/ink/images/common/btn_next02_on.gif"></a>
					</div>
				</c:when>
		
			<c:otherwise>
				<div class="paginate">
				     <a href="/bookMarket/purchasedInfo/list?index=${paging.firstPageNo}&datepicker1=${startDate}&datepicker2=${endDate}"><img alt="처음페이지" src="http://image.kyobobook.co.kr/ink/images/common/btn_prev02_on.gif"></a>
					 <a href="/bookMarket/purchasedInfo/list?index=${paging.prevPageNo}&datepicker1=${startDate}&datepicker2=${endDate}"><img alt="이전페이지" src="http://image.kyobobook.co.kr/ink/images/common/btn_prev_on.gif"></a>
				    	<span>
					        <c:forEach var="i" begin="${paging.startPageNo}" end="${paging.endPageNo}" step="1">
					            <c:choose>
					                <c:when test="${i eq paging.pageNo}"><a href="/book/purchasedInfo/list?index=${i}&datepicker1=${startDate}&datepicker2=${endDate}">${i}</a></c:when>
					                <c:otherwise>
					                	<a href="/bookMarket/purchasedInfo/list?index=${i}&datepicker1=${startDate}&datepicker2=${endDate}">${i}</a>
					                </c:otherwise>
					            </c:choose>
					        </c:forEach>
				  		</span>
			   	 		<a href="/bookMarket/purchasedInfo/list?index=${paging.nextPageNo}&datepicker1=${startDate}&datepicker2=${endDate}"><img alt="다음페이지" src="http://image.kyobobook.co.kr/ink/images/common/btn_next_on.gif"></a>
			    		<a href="/bookMarket/purchasedInfo/list?index=${paging.finalPageNo}&datepicker1=${startDate}&datepicker2=${endDate}"><img alt="마지막페이지" src="http://image.kyobobook.co.kr/ink/images/common/btn_next02_on.gif"></a>
					</div>
				</c:otherwise>
			</c:choose> 
			
		</div> 
  
       	<div class="text-center">
	       	<a href="/bookMarket/book/main">
	       		<button type="button" class="btn btn-default">  메인  </button>
	       	</a>
      	</div>


<!-- Footer ========================================================================================== -->

<%@include file="/layout/footer.jsp" %>

</div>

</body>
</html>