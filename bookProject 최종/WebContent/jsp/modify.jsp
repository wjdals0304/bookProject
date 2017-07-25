<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>수정한다!</title>
</head>
<body>
	<form action="/bookMarket/introDuce/modify" method="post">
	<table align="center" border="1" cellpadding="5" cllspacing="0">
		<tr>
			<td>역할</td>
			<input id="introDuceId" name="introDuceId"	type="hidden" value="${intro}">
				<td><input id="role" name="introDuceRole" type="text" value="${introDuceRole}"></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input id="name" name="introDuceName" type="text" value="${introDuceName}"></td>
		</tr>
		<tr>
			<td>구현한 기능</td>
			<td><input id="function" name="introDuceFunction" type="text" value="${introDuceFunction}"></td>
		</tr>
		<tr>
			<td ><div> <input type="submit" value="저장"></div></td>
			<th><a href="/bookMarket/introDuce/list">멤버 목록으로</a></th>
		</tr>
	</table>
	</form>
</body>
</html>