<!-- 잘 업데이트 되었나 확인 - 김정수 - -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
   	<meta charset="UTF-8">
   	<title>장바구니</title>
   	<link href="/bookMarket/resources/css/bootstrap_modify.css" rel="stylesheet">
   	<link href="/bookMarket/resources/css/layout.css" rel="stylesheet">
   	<link href="/bookMarket/resources/css/layout_css/header.css" rel="stylesheet">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script type="text/javascript">

function purchase_submit(bookId) {
	var count = document.getElementsByName("count");
	var list = document.getElementsByName("check");
	var bookCount;
	for(var i=0;i<list.length;i++) {
		var result = list[i].value.split(",");
		if(bookId == result[0]) {
			if(count[i].value == 0) {
				alert("0권은 안되요");
			}
			else {
    			bookCount = count[i].value;	
		    	location.href = "/bookMarket/purchasedInfo/order?bookId="+bookId+"&count="+bookCount+"&basketItemId="+result[2];
			}
		}
	}
}; 

function Cnt_UpDown(obj, key) {
   var bookId = obj;
   var count = parseInt(document.getElementById(bookId).value);
       if (key == "D") {
          if(count != 1){
             count = count - 1;
             document.getElementById(bookId).value = count;
          }
      } else {
         count = count + 1;
         document.getElementById(bookId).value = count;
      }
   
}

function allClick() {
    var i;
    var allchk = document.getElementById("all");
    var chk = document.getElementsByName("check");
    var leng = chk.length;   
      if(allchk.checked == true) {
       for (i=0;i<leng;i++) {
          chk[i].checked = true;
       }   
      }
      else if(allchk.checked == false) {
         for(i=0;i<leng;i++) {
            chk[i].checked = false;
         }
      }
    change_totalPrice();
 }

function order(){
    var check = document.getElementsByName("check");
       var flag = false;
       for(var i=0; i<check.length; i++){
          if(check[i].checked == true){
            flag = true;
          }else{
          }
       }
       if ( flag == true ) {
          document.getElementById("basket").action = "/bookMarket/purchasedInfo/order";
           document.getElementById("basket").submit();
       } 
   };

 
function update(bookId, basketItemId, price, sales){
   var check = document.getElementsByName("check");
   for(var i=0; i<check.length; i++){
      check[i].checked = false;
      document.getElementById("totalSalesPrice").innerHTML = "0원";
      document.getElementById("totalPrice").innerHTML = "0원";
      document.getElementById("total").innerHTML = "0원";
   }
   var bookId = bookId;
   var basketItemId =  basketItemId;
   var count = document.getElementById(bookId).value;
   var price = price;
   var sales = sales;
   var reg = /([+-]?\d+)(\d{3})(\.\d+)?/;
   var salesPrice = 0;
   
   salesPrice = price * count * (1-(sales/100));
   price = parseInt(price * count);
   
   /* 수량 변경시 변경 된 값 hidden에 넣어주기*/
   document.getElementById(bookId+"_salesPrice_hidden").value = salesPrice;
   document.getElementById(bookId+"_price_hidden").value = price;
   
   /*천단위 콤마 추가*/
   salesPrice += '';
   salesPrice = salesPrice.replace( /^\s+|\s+$|,|[^+-\.\d]/g, "" );
   while (reg.test( salesPrice )) salesPrice = salesPrice.replace( reg, "$1" + "," + "$2" + "$3" );
   
   price += '';
   price = price.replace( /^\s+|\s+$|,|[^+-\.\d]/g, "" );
   while (reg.test( price )) price = price.replace( reg, "$1" + "," + "$2" + "$3" );
   
   document.getElementById(bookId+"_salesPrice").innerHTML = "<div>"+ salesPrice + "원" +"</div>";
   document.getElementById(bookId+"_price").innerHTML = price + "원" ;
   
   location.href="/bookMarket/basketItem/update?count=" + count + "&basketItemId=" + basketItemId;
   return;
   
}

function change_totalPrice() {
   var checkList = document.getElementsByName("check");
   var check = [];
   for ( var i = 0; i<checkList.length; i++ ) {
      if(checkList[i].checked == true){
         var result = checkList[i].value.split(",");
         check.push(result[0]);
      }
   }
   var bookId = 0;
   var count = 0;
   var price = 0;
   var salesSum = 0;
   var totalPrice = 0;
   var total = 0; 
   var reg = /([+-]?\d+)(\d{3})(\.\d+)?/;
   for(var i=0; i<check.length; i++){
      bookId = check[i];
      price = document.getElementById(bookId+"_salesPrice_hidden").value;
      salesSum += parseInt(price);
   }
   salesSum += '';
   salesSum = salesSum.replace( /^\s+|\s+$|,|[^+-\.\d]/g, "" );
   while (reg.test( salesSum )) salesSum = salesSum.replace( reg, "$1" + "," + "$2" + "$3" );
   document.getElementById("totalSalesPrice").innerHTML = salesSum +"원";
   
   for(var i=0; i<check.length; i++){
      bookId = check[i];
      price = document.getElementById(bookId+"_price_hidden").value;
      totalPrice += parseInt(price);
   }
   totalPrice += '';
   totalPrice = totalPrice.replace( /^\s+|\s+$|,|[^+-\.\d]/g, "" );
   while (reg.test( totalPrice )) totalPrice = totalPrice.replace( reg, "$1" + "," + "$2" + "$3" );
   document.getElementById("totalPrice").innerHTML = totalPrice +"원";
   
   /*결제 예정금액 계산*/
   total = salesSum;
   total += '';
   total = total.replace( /^\s+|\s+$|,|[^+-\.\d]/g, "" );
   while (reg.test( total )) total = total.replace( reg, "$1" + "," + "$2" + "$3" );
   salesSum = document.getElementById("total").innerHTML = total + "원";
   
};
    
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
      .publisher{
         font-size:20px;
         border-right:1px solid #CCC;
         margin-right:15px;
         padding-right:15px;
         margin-bottom:20px;
      }
      .publishedDate{
         font-size:20px;
         margin-bottom:20px;
         display:block;
      }
      .gpa{
         display:block;
         font-size:20px;
      }
      span{
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
      .book_title{
         font-size:30px;
         display:block;
      }
      .listnodata02 {
         color:#333333;
         border:none;
         border-bottom:1px solid #e7e7e7;
         padding:25px 0px;
         text-align:center;
         font-size:12px;
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
      
      .basket_table{
          margin-top:30px;
       width:100%;
       border-top:2px solid #333;
       border-bottom:1px solid #CCC;
       margin-bottom:50px;
       
      }
      .basket_table tr{
         border-bottom:1px solid #CCC;
      }
      
      .basket_table th{
           border-bottom:1px solid #CCC;
           background-color:#ecf0f1;
         text-align:center;
         font-weight:bold;
         font-size:18px;
         padding:5px;
   }
  	 .basket_table td{
         border-bottom:1px solid #CCC;
         padding:5px;
      }
   .basket_img {
         height:150px;
         margin:20px 20px;
   }
   
   .count_input{
         height:25px;
         width:40px;
         border:1px solid #DDD;
         line-height:19px;
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
   .order_button{
      float:right;
      display:block;
      margin:20px 0;
     
   }
   .book_list_checkbox{
       margin:0 auto;
       text-align:center;
    }
    .book_list_checkbox_center{
    	text-align:center;
    }
    .one_price{
    	text-align:center;
    	color:#AAA;
    }
    .one_salesPrice{
    	text-align:center;
    	font-weight:bold;
    	font-size:20px;
    }

   /*수량 변경 이미지 css*/
      .ui_count_box{position:relative;width:53px;height:25px;text-align:left;margin:5px auto;}
      .ui_count_box .quantity_up {position:absolute;right:0;top:0;border:1px solid #d0d0d0;width:11px;height:13px;overflow:hidden;}
      .ui_count_box .quantity_down {position:absolute;right:0;bottom:0;border:1px solid #d0d0d0;width:11px;height:13px;overflow:hidden;}
      .ui_count_box .quantity_up img,
      .ui_count_box .quantity_down img{vertical-align:top;}
      .ui_count_box .quantity_up:hover,
      .ui_count_box .quantity_down:hover{border:1px solid #adadad}
      .ui_count_box .quantity_up {position:absolute;right:0;top:0;border:1px solid #d0d0d0;width:11px;height:13px;overflow:hidden;}
      .ui_count_box .quantity_down {position:absolute;right:0;bottom:0;border:1px solid #d0d0d0;width:11px;height:13px;overflow:hidden;}
    </style>
    
</head>
<body>

<!-- Main Navigation ========================================================================================== -->
 
 <%@include file="/layout/mainNavigation.jsp" %>

<!-- Header ========================================================================================== -->
 
 <%@include file="/layout/header.jsp" %>

<!-- Container ======================================================================================= -->
<div class="container">

   <form action="" method="post" id="basket">
   
      <h1>장바구니</h1>
      <br>
         <table class="basket_table">
         	<colgroup>
	            <col style="width:50px">
	            <col style="width:130px">
	            <col style="width:450px;">
	            <col style="width:100px;">
	            <col style="width:100px;">
	         </colgroup>
             <thead>
               	<tr>
                  	  <th class="center">
                     	<input type="checkbox" class="book_list_checkbox" title="전체선택" id="all"  value="" onclick="allClick();"/>
                  	  </th>
	                  <th class="center" colspan="2">상품정보</th>
	                  <th class="center">판매가</th>
	                  <th class="center">수량</th>
	                  <th class="center">합계</th>
	                  <th class="center">선택</th>
               </tr>
            </thead>
            <tbody>
               <c:forEach items="${basketItemList}" var="basketItem">
                  <tr>
                     <td class="book_list_checkbox_center"><input type="checkbox" name="check" value="${basketItem.book.bookId}${','}${basketItem.count}${','}${basketItem.basketItemId}" onclick="change_totalPrice();" /></td>
                     <td>
                     	   <a href="/bookMarket/book/detail?bookId=${basketItem.book.bookId}"><img src="${basketItem.book.img}" class="basket_img"></a>
                     </td>
                     <td>
                        <div>
                           <a href="/bookMarket/book/detail?bookId=${basketItem.book.bookId}">
                              <span>[도서]&nbsp;${basketItem.book.title}</span>
                           </a>
                        </div>
                     </td>
                     <td>
                        <div class="one_price"><del><fmt:formatNumber value="${basketItem.book.price}" type="number" />원</del></div>
                        <div class="one_salesPrice"><fmt:formatNumber value="${basketItem.book.price *(1-(degree.discount/100)) }" type="number" />원</div>
                     </td>
                     <td class="center">
                        <div class="ui_count_box">
                           <span id="test" style="display: none" title="수량"></span> 
                           <input type="text" class="count_input" id="${basketItem.book.bookId}" value="${basketItem.count}" maxlength="4" name="count">
                           <a class="quantity_up" id="plus" onclick="Cnt_UpDown(${basketItem.book.bookId}, 'U');"><img src="http://image.kyobobook.co.kr/ink/images/common/icon_quantity_up.gif" alt="수량증가" /></a> 
                           <a onclick="Cnt_UpDown(${basketItem.book.bookId}, 'D');" class="quantity_down"><img src="http://image.kyobobook.co.kr/ink/images/common/icon_quantity_down.gif" alt="수량감소" /></a>
                        </div> 
                        <a onclick="update(${basketItem.book.bookId},${basketItem.basketItemId},${basketItem.book.price},${degree.discount})">변경</a>
                     </td>
                     <td class="center">
                        <div><del id="${basketItem.book.bookId}_price"><fmt:formatNumber value="${basketItem.book.price * basketItem.count}" pattern="#,###" /></del></div>
                        <div id="${basketItem.book.bookId}_salesPrice"><fmt:formatNumber value="${basketItem.book.price * basketItem.count *(1-(degree.discount/100))}" pattern="#,###" /></div>
                           <input type="hidden" value="${basketItem.book.price * basketItem.count}" id="${basketItem.book.bookId}_price_hidden">
                           <input type="hidden" value="${basketItem.book.price * basketItem.count *(1-(degree.discount/100))}" id="${basketItem.book.bookId}_salesPrice_hidden">
                        <div>[${degree.discount}%↓]</div>
                     </td>
                     <td class="center">
                        <a href="#">
                        <input type="button" class="sub_button" value="바로구매" onclick="purchase_submit(${basketItem.book.bookId});">
                        <input type="button" class="sub_button" value="찜하기"></a> 
                        <a href="/bookMarket/basketItem/delete?basketItemId=${basketItem.basketItemId}"><input type="button" class="sub_button" value="삭제"></a>
                     </td>
                  </tr>
               </c:forEach>
            </tbody>
         </table>
         <br>
         <div>
            <div>
               <table class="pay_table">
                  <colgroup>
                     <col style="border-right: 1px solid #899bdb;">
                     <col style="border-right: 1px solid #899bdb;">
                  </colgroup>
                  <thead>
                     <tr>
                        <th class="center">상품금액</th>
                        <th class="center">할인 후 금액</th>
                        <th class="center">결제 예정금액</th>
                     </tr>
                  </thead>
                  
                  <tbody>
                     <tr>
                        <td class="right" id="totalPrice">0원</td>
                        <td class="right" id="totalSalesPrice">0원</td>
                        <td class="right font_red" id="total">0원</td>
                     </tr>
                  </tbody>
               </table>
               <div>
                  <input type="button" onclick="order();" class="btn btn-large btn-warning order_button" value="회원주문하기">
               </div>

            </div>
         </div>
   </form>
<!-- Footer ========================================================================================== -->
<%@include file="/layout/footer.jsp" %>

   </div>

</body>
</html>