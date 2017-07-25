<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>멤버 소개</title>
<style>
.title {
	font-size: 20px;
	text-align: center;
	font-weight: bold;
	color: blue;
	border-style: dashed;
	border-width: 1px;
	width: 300px;
}

.margin_5_10 {
	margin: auto;
}

table tr:hover {
	background-color: greenyellow;
}

table td:active {
	background-color: chocolate;
}
.button{
	padding:15px 30px;
	font-size:17px;
	color:#FFF;
	background-color:#5e6b9e;
	border-top-left-radius:5px;
	border-bottom-left-radius:5px;
	border-top-right-radius:5px;
	border-bottom-right-radius:5px;
}	
.button_div{
	width:100px;
	margin:50px auto;
}
#description {
	display: none;
}
</style>
</head>
<body>
	<div class="title margin_5_10">멤버 명단</div>
	<br>
	<table align="center" border="1" cellpadding="5" cellspacing="0">
		<tr>
			<th bgcolor="lightgray">역할</th>
			<th bgcolor="lightgray">이름</th>
			<th bgcolor="lightgray" width="400">구현한 기능</th>
			<th bgcolor="lightgray"></th>
			<th bgcolor="lightgray"></th>
		</tr>
		<c:forEach items="${intro}" var="intro">
			<tr>
				<td>${intro.role}</td>
				<td>${intro.name}</td>
				<td>${intro.function}</td>
				<td><a href="/bookMarket/introDuce/delete?introDuceId=${intro.introDuceId}">삭제</a></td>
				<td><a href="/bookMarket/introDuce/submodify?introDuceId=${intro.introDuceId}&introDuceRole=${intro.role}&introDuceName=${intro.name}&introDuceFunction=${intro.function}">수정</a></td>
			</tr>
		</c:forEach>
		<tr>
				<th><a href="/bookMarket/jsp/createintro.jsp">생성</a></th>
        </tr>
	</table>
	<div class="button_div">
		<button class="button" type="reset" onclick="history.back();">취소</button>
	</div>
</body>
</html>