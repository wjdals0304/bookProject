<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원가입</title>
	
	 <link href="/bookMarket/resources/css/bootstrap_modify.css" rel="stylesheet">
    <link href="/bookMarket/resources/css/layout.css" rel="stylesheet">
    <script type="text/javascript">
	    function checkLogin() {
			/* location.href="/bookMarket/member/loginIdCheck?registerId="+ register.inputEmail.value; */
		location.href="/bookMarket/member/loginIdCheck?registerId="+document.getElementById("check").value
		};	 
	    function delSpace(obj) {
	         if(obj.keyCode > 31 && obj.keyCode < 48) {
	            alert("공백은 입력 할 수 없습니다.");
	            history.go(0);
	         }
	      }; 
    </script>
    <style type="text/css">
        body {
            padding-top: 100px;
            padding-bottom: 40px;
            background-color: #ecf0f1;
        }
        .login-header {
            max-width: 700px;
            padding: 15px 29px 25px;
            margin: 0 auto;
            background-color: #5e6b9e;
            color: white;
            text-align: center;
            -webkit-border-radius: 15px 15px 0px 0px;
            -moz-border-radius: 15px 15px 0px 0px;
            border-radius: 15px 15px 0px 0px;
            -webkit-box-shadow: 0 1px 2px rgba(0,0,0,.05);
            -moz-box-shadow: 0 1px 2px rgba(0,0,0,.05);
            box-shadow: 0 1px 2px rgba(0,0,0,.05);
        }
        .login-footer {
            max-width: 700px;
            margin: 0 auto 20px;
            padding-left: 10px;
        }
        .form-signin {
            max-width: 700px;
            padding: 29px;
            margin: 0 auto 20px;
            background-color: #fff;
            -webkit-border-radius: 0px 0px 15px 15px;
            -moz-border-radius: 0px 0px 15px 15px;
            border-radius: 0px 0px 15px 15px;
            -webkit-box-shadow: 0 1px 2px rgba(0,0,0,.05);
            -moz-box-shadow: 0 1px 2px rgba(0,0,0,.05);
            box-shadow: 0 1px 2px rgba(0,0,0,.05);
        }
        .form-signin .form-signin-heading,
        .form-signin .checkbox {
            margin-bottom: 15px;
        }
        .form-signin input[type="text"],
        .form-signin input[type="password"] {
            font-size: 16px;
            height: auto;
            margin-bottom: 15px;
            padding: 7px 9px;
        }
        .form-btn {
            text-align: center;
            padding-top: 20px;
        }
        .button{
        	display:inline-block;
        	height:40px;
        	margin:0 0 13px 15px;
        }
        .input_size{
        	width:80%;
        	display:inline-block;
        }

    </style>
    
</head>
<body>

<div class="container">

    <!-- header -->
	<c:set var="id" value="${param.registerId}" /> 
        <input type="text" id="check" class="form-control input_size" name="inputEmail" placeholder="아이디(이메일)" required value="${id}" 
        autofocus  onkeyPress="delSpace(event);">
        <input type="submit" class="btn btn-large btn-warning button" value="중복체크" onClick="checkLogin()" >
       	<c:choose>
       		<c:when test="${exsit eq 'f'}">
        		<div style="color:skyblue;margin-bottom:15px;font-weight:bold;">
        			이 아이디는 사용가능한 아이디입니다.
        		</div>
        	</c:when>
        	<c:when test="${exsit eq 't'}">
        		<div style="color:red;margin-bottom:15px;font-weight:bold;">
        			중복된 아이디입니다. 다른 아이디를 사용해주세요.
        		</div>
        	</c:when>
        	<c:otherwise>
        		<div>
        		</div>
        	</c:otherwise>
        </c:choose>
        <form method="post" action="membership.jsp">
    <input type="button" class="btn btn-large btn-warning button" value="확인" onClick="window.close();">
		</form>
</div>

</body>
</html>