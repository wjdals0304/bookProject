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
			window.open("/bookMarket/member/loginIdCheck?registerId="+ register.inputEmail.value, 'ID중복확인', 'width=700 height=300');
		}	 
	    function checkpw(){
	    	if(register.inputPassword.value == register.inputPasswordCheck.value){
	    		document.getElementById("pass").innerHTML = "<div style='color:skyblue;font-weight:bold;'>비밀번호가 일치합니다.</div>";
	    	}else{
	    		document.getElementById("pass").innerHTML = "<div style='color:red;font-weight:bold;'>비밀번호가 일치하지 않습니다. 다시 확인해주세요<div>";
	    	}
	    	
	    }
	    function showPopup(){
	    	if(register.inputPassword.value != register.inputPasswordCheck.value){
	    		alert("비밀번호가 일치하지않습니다!!!");
	    		return;
	    	}else{
	    	alert("회원가입이 완료되었습니다. 로그인 화면으로 돌아갑니다.");
	    	document.getElementById("register").action = "/bookMarket/member/create" ;
	    	document.getElementById("register").submit();
	    	}
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
    <div class="login-header">
        <h2 class="form-signin-heading">회원가입</h2>
    </div>

    <!-- form -->
    <form name="register"class="form-signin" action="" method="post" id="register">
        <input type="text" class="form-control input_size" name="inputEmail" placeholder="아이디(이메일)" required value="${loginId}" autofocus 
        onkeyPress="delSpace(event);">
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
        <input type="text" class="form-control" name="inputName" placeholder="이름" required>
        <input type="password" class="form-control" name="inputPassword" placeholder="비밀번호" required>
        <input type="password" class="form-control" name="inputPasswordCheck" placeholder="비밀번호 확인" onkeyup = "checkpw()" required>
		<div id="pass"></div>
        <div class="row form-btn">
            <a class="btn btn-large btn-warning" type="reset" href="login.jsp" onclick="history.back();">취소</a>
            <input type="submit" class="btn btn-large btn-default" value="회원가입" onClick="showPopup();">
        </div>
        
    </form>

    <!-- footer -->
    <div class="login-footer">
        <p>© kosta 2016.</p>
    </div>
</div>

</body>
</html>