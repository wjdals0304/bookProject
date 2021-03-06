<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>로그인</title>
    <link href="/bookMarket/resources/css/bootstrap_modify.css" rel="stylesheet">
    <link href="/bookMarket/resources/css/layout.css" rel="stylesheet">
    <style type="text/css">
        body {
            padding-top: 100px;
            padding-bottom: 40px;
            background-color: #ecf0f1;
        }
        .login-header {
            max-width: 400px;
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
            max-width: 400px;
            margin: 0 auto 20px;
            padding-left: 10px;
        }
        .form-signin {
            max-width: 400px;
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

    </style>
    
</head>
<body>
<div class="container">

    <!-- header -->
    <div class="login-header">
        <h2 class="form-signin-heading">로그인</h2>
    </div>

    <!-- form -->
    <form class="form-signin" action="/bookMarket/member/login" method="post">
        <input type="text" class="form-control" name="inputEmail" placeholder="아이디" required>
        <input type="password" class="form-control" name="inputPassword" placeholder="비밀번호" required>
       
        <div class="row form-btn">
         	<a href="/bookMarket/book/main" class="btn btn-large btn-default" type="submit">취소</a>
         	<a href="/bookMarket/jsp/membership.jsp" class="btn btn-large btn-default">회원가입</a>
            <button class="btn btn-large btn-warning" type="submit">로그인</button>
        </div>
    </form>
    
    <c:choose>
		<c:when test="${loginIdCheck eq 'idFalse'}">
			<script type="text/javascript">
				alert("아이디가 존재하지 않습니다. 다시 확인해주세요.");
			</script>
		</c:when>
		<c:when test="${loginPwCheck eq 'pwFalse'}">
			<script type="text/javascript">
				alert("비밀번호가 틀렸습니다. 다시 확인해주세요.");
			</script>
		</c:when>
	</c:choose>
	
    <!-- footer -->
    <div class="login-footer">
        <p>© kosta 2016.</p>
    </div>
</div>
</body>
</html>