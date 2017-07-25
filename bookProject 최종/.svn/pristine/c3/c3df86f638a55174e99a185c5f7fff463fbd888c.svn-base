<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
	<div class="row">
		<div class="col-lg-12">
			<div class="jumbotron">
				<a href="/bookMarket/book/main"><img
					src="/bookMarket/img/logo.png" class="logo_img"></a>
				<form action="/bookMarket/search" method="Get" id="check">
					<select name="categoryId" class="category_select">
                      <option name="categoryId" value="total" >통합검색</option>
                    <c:forEach items="${sessionScope.category}" var="category">
                          <option name="categoryId" value="${category.categoryId}" ${category.categoryId == categoryId ? 'selected="selected"':''}>${category.categoryName}</option>
                    </c:forEach>
                    </select> <input type="text" placeholder="검색어를 입력해주세요."
						class="search_box" name="keyword" id="keyword" required value="${keyword}"> <input
						type="submit" value="검색"
						class="search_button btn btn-large btn-warning">
				</form>
			</div>
		</div>
	</div>
</div>