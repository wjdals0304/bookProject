<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
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