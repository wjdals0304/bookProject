<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
 <title>bookMarket</title>
    <meta charset="utf-8">
    <link href="/bookMarket/resources/css/bootstrap_modify.css" rel="stylesheet">
    <link href="/bookMarket/resources/css/layout.css" rel="stylesheet">
    <link href="/bookMarket/resources/css/layout_css/header.css" rel="stylesheet">
    <link href="/bookMarket/resources/css/gpaStar.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript">
       function allClick() {
          var i;
          var allchk = document.getElementById("allchk");
          var chk = document.getElementsByName("chk");
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
       }
     </script>
     <script type="text/javascript">
		function submitData() {
			var chk = document.getElementsByName("chk");
			var count = document.getElementsByName("count");
			var array = new Array();
			var a;
			if(chk.length > 0) {
					for(var i=0; i<chk.length; i++) {
						if(chk[i].checked == true) {
							document.getElementById("checkedTrue").innerHTML += "<input type=\"hidden\" value=\""+chk[i].value+","+count[i].value+"\" name=check>";
						}
						else if(chk[i].checked == false) {
							a = a + 1;
							array.push(a);
						}
					}
					if(array.length == chk.length) {
						alert("책을 선택해주세요");
					}
					else {
					document.getElementById("form").action = "/bookMarket/basketItem/create";
					document.getElementById("form").submit();	
					}
					}
				};
			/* else if(chk.length == 0) {
				alert("선택한 책이 없습니다. 책을 선택해 주세요");
			} */
    </script>
    <script type="text/javascript">
   	function basket_submit(bookId) {
	    	var count = document.getElementsByName("count");
	    	var list = document.getElementsByName("chk");
	    	var bookCount;
	    	for(var i=0;i<list.length;i++) {
	    		if(bookId == list[i].value) {
	    			if(count[i].value == 0) {
	    				alert("0권은 안되요");
	    			}
	    			else {
		    			bookCount = count[i].value;
				    	location.href = "/bookMarket/basketItem/create?bookId="+bookId+"&count="+bookCount;
	    			}
	    		}
	    	}
	};            
	</script> 
	<script type="text/javascript">
   	function purchase_submit(bookId) {
   		var count = document.getElementsByName("count");
    	var list = document.getElementsByName("chk");
    	var bookCount;
    	for(var i=0;i<list.length;i++) {
    		if(bookId == list[i].value) {
    			if(count[i].value == 0) {
    				alert("0권은 안되요");
    			}
    			else {
	    			bookCount = count[i].value;	
			    	location.href = "/bookMarket/purchasedInfo/order?bookId="+bookId+"&count="+bookCount;
    			}
    		}
    	}
	};            
	</script>  
	<script type="text/javascript">
		function buyBook() {
			var chk = document.getElementsByName("chk");
			var count = document.getElementsByName("count");
			var array = new Array();
			var a;
			if(chk.length > 0) {
				for(var i=0; i<chk.length; i++) {
					if(chk[i].checked == true) {
						document.getElementById("checkedTrue").innerHTML += "<input type=\"hidden\" value=\""+chk[i].value+","+count[i].value+"\" name=check>";
					}
					else if(chk[i].checked == false) {
						a = a + 1;
						array.push(a);
					}
				}
				if(array.length == chk.length) {
					alert("책을 선택해주세요");
				}
				else {
					document.getElementById("form").action = "/bookMarket/purchasedInfo/order";
					document.getElementById("form").submit();		
				}
			}
		};
    </script>          
    <style>
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
         margin:0 auto;
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
      .category_name{
         color:#3a60df;
         display:block;
         text-align:center;
         font-size:12px;
      }
      .title{
         display:block;
         width:180px;
         margin:0 auto;
         text-align:center;
         font-size:14px;
         word-break:break-all;
         
      }
      .author{
         display:block;
         text-align:center;
         font-size:12px;
      }
      .input_style02{
         height:19px;
         border:1px solid #c6c6c6;
         width:28px;
         line-height:19px;
      }
      .sub_button{
         padding:2px;
         width:60px;
         display:block;
         margin:5px auto 5px;
         background-color:#EEE;
         padding:1px;
         border-top-right-radius:5px;
         border-bottom-right-radius:5px;
         border-bottom-left-radius:5px;
         border-top-left-radius:5px;
         font-size:10px;
      }
      .amount_text{
         font-size:10px;
         display:block;
         text-align:center;
      }
      .img_button{
         border:1px solid #CCC;
         padding:3px;
         margin-bottom:5px;
      }
      .count{
         width:50px;
         padding:1px;
         font-size:15px;
         margin-left:0 auto 20px;
         ime-mode:disable;
      }
      
      /*showList CSS*/
      .book_list_table{
         border-top:2px solid #AAA; 
         border-bottom:2px solid #AAA;
         width:100%;
         line-height: 1.5em;
      }
      .book_list_table th{
         border-bottom:1px solid #CCC;
         padding:5px;
         text-align:center;
         font-weight:bold;
         background-color:#dde5ff;
      }
      .book_list_table td{
         border-bottom:1px solid #CCC;
         padding:5px;
      }
      .book_img{
         height:110px;
         margin-left:20px;
      }
      .book_list_chechbox{
         margin:0 auto;
         text-align:center;
      }
      .book_list_title{
         font-size:15px;
         font-weight:bold;
         display:block;
      }
      .book_list_author{
         display:block;
         font-size:12px;
      }
      .book_list_publishedDate{
         display:block;
         font-size:12px;
      }
      .book_list_allGpa{
         text-align:center;
      }
      .book_list_count{
         text-align:center;
      }
      .paginate{
         text-align:center;
         margin-top:30px;
      }
      .login{
      	font-size:13px;
      	color:#AAA;
      }
      .paging{
     	margin:30px 0;
     	text-align:center;
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
   <div class="row">
   <div style="z-index: 1020" class="col-xs-12 col-sm-2 col-md-3 col-lg-2">
   <div class="list-group panel panel-success top">
      <div class="panel-heading list-group-item text-center hidden-xs">
         <h4>카테고리</h4>
      </div>
      <div>
         <c:forEach items="${sessionScope.category}" var="category">
            <a href="/bookMarket/search/category?categoryId=${category.categoryId}" class="list-group-item hidden-xs">${category.categoryName}</a>
         </c:forEach>
      </div>
   </div>
</div>
      
<div class="col-lg-10 col-lg-10">
	  <form name="form" id="form" action="" method="post">
	  <div id = "checkedTrue"> </div>
      <table class="book_list_table">
         <colgroup>
            <col style="border-right:1px solid #CCC;width:50px">
            <col style="border-right:0px;width:130px">
            <col style="border-right:1px solid #CCC;width:450px;">
            <col style="border-right:1px solid #CCC;width:100px;">
            <col style="border-right:1px solid #CCC;width:100px;">
         </colgroup>
      
         <thead>
            <tr>
               <th><input class="book_list_chechbox" type="checkbox" class="checkbox" id="allchk" onclick="allClick();"></th>
               <th colspan="2">상품정보</th>
               <th>판매가</th>
               <th>수량</th>
               <th>선택</th>   
            </tr>
         </thead>
         <tbody>
          <c:choose>
          <c:when test="${fn:length(list2)>0}">
         <c:forEach items="${list2}" var="list">
            <tr>
               <td class="book_list_chechbox"><input type="checkbox" name="chk" value="${list.bookId}"></td>
               
                  <td>
                     <a href="/bookMarket/book/detail?bookId=${list.bookId}">
                        <img src="${list.img}" class="book_img">
                     </a>
                  </td>
                  <td>
                     <a href="/bookMarket/book/detail?bookId=${list.bookId}">
                        <span class="book_list_title">${list.title}</span>
                        <span class="book_list_author">[${list.author}] | ${list.publisher}</span>
                        <span class="book_list_publishedDate"><fmt:formatDate value="${list.publishedDate}" pattern="yyyy년 MM월 dd일"/></span>
                        <p><span class="starRating"><span style="width:${list.allGpa}%"></span></span></p>
                     </a>
                  </td>
               
               <td class="book_list_allGpa">
               		<c:choose>
               		<c:when test="${sessionScope.member.memberId ne null}">
               		<del><fmt:formatNumber value="${list.price}" type="number" />원</del>
               		<p>할인율 : ${sessionScope.degree.discount}%</p>
               		<p><fmt:formatNumber value="${(list.price-(list.price * (sessionScope.degree.discount+0.0)/(100+0.0)))}" type="number" />원</p>
               		</c:when>
               		<c:otherwise>
               			<fmt:formatNumber value="${list.price}" type="number" />원
               		</c:otherwise>
               		</c:choose>
               	</td>
               <td class="book_list_count">
                  <span class="amount_text">수량</span>
                  <input id="count" name="count" type="text" value="1" class="count" onkeyup="this.value=this.value.replace(/[^0-9]/g,'')" style="ime-mode:disable" maxlength="4">
               </td>
               <c:choose>
	               <c:when test="${sessionScope.member.memberId ne null}">
	       			<td class="center">
	                  <a href="#"><input type="button" class="sub_button" value="찜하기"></a>
	                  <input type="button" class="sub_button" value="장바구니" onclick="basket_submit(${list.bookId});">
	                  <input type="button" class="sub_button" value="바로구매" onclick="purchase_submit(${list.bookId});">
	               </td>
	               </c:when>
	               <c:otherwise>
		               <td class="login">
		               		로그인 해주세요
		               	</td>
	               </c:otherwise>
               </c:choose>
            </tr>
         </c:forEach>
         </c:when>
         <c:otherwise>
            <tr>
               <th colspan="6">책 제목이 정확하지 않거나 찾으시는 책이 없습니다.</th>
            </tr>
         </c:otherwise>
         </c:choose>
         </tbody>
      </table>
      <br>
   
	   <div class="paging">  
		   <div class="paginate">
		        <a href="/bookMarket/search?keyword=${keyword}&index=${paging.firstPageNo}&categoryId=${categoryId}" >처음 페이지</a>
		       <a href="/bookMarket/search?keyword=${keyword}&index=${paging.prevPageNo}&categoryId=${categoryId}" >이전 페이지</a>
		    <span>
		        <c:forEach var="i" begin="${paging.startPageNo}" end="${paging.endPageNo}" step="1">
		            <c:choose>
		                <c:when test="${i eq paging.pageNo}"><a href="/bookMarket/search?keyword=${keyword}&index=${i}&categoryId=${categoryId}">${i}</a></c:when>
		                <c:otherwise><a href="/bookMarket/search?keyword=${keyword}&index=${i}&categoryId=${categoryId}">${i}</a></c:otherwise>
		            </c:choose>
		        </c:forEach>
		    </span>
		       <a href="/bookMarket/search?keyword=${keyword}&index=${paging.nextPageNo}&categoryId=${categoryId}" >다음 페이지</a>
		       <a href="/bookMarket/search?keyword=${keyword}&index=${paging.finalPageNo}&categoryId=${categoryId}" >마지막 페이지</a>
		   </div>
		</div>
	
		<div align="right">
	      	<c:choose>
		      	<c:when test="${sessionScope.member.memberId ne null}">
			      <input type="button" class="btn btn-large btn-warning" value="장바구니" onclick="submitData();">
			      <input type="button" class="btn btn-large btn-warning" value="바로구매" onclick="buyBook();">
		      	</c:when>
	      	</c:choose>
	      </div>
	   </form>
	
<!-- Footer ========================================================================================== -->
   <%@include file="/layout/footer.jsp" %>
   </div>
   </div>
</div>
   </body>
</html>