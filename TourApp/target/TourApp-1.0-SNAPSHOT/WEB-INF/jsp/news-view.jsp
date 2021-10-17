<%-- 
    Document   : news-view
    Created on : Oct 16, 2021, 11:14:47 AM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<h1 class="text-center text-info">Trang tin tức</h1>

<ul class="pagination">
    <c:forEach begin="1" end="${Math.ceil(countNews/3)}" var="page">
        <li class="page-item"><a class="page-link" href="<c:url value="/news-view"/>?page=${page}">${page}</a></li>
    </c:forEach>    
</ul>

<div class="row">
    <c:forEach var="news" items="${news}">
        <div class="col-md-4 col-xs-12" id="news${news.id}"  style="padding: 10px">  
        <div class="card">
                <c:choose>
                    <c:when test="${news.image != null && news.image.startsWith('http') == true }">
                        <img class="card-img-top img-fluid" src="${news.image}" alt="Card image"/>
                    </c:when>
                    <c:when test="${news.image == null || news.image.startsWith('http') == false }" >
                         <img class="card-img-top img-fluid" src="<c:url value="/images/Koala.jpg"/>" alt="Card image"/>
                    </c:when>
                </c:choose>            
                <div class="card-body">
                    <h5>${news.name}</h5>
                    <p>${news.contentSummary}</p>
                  <sec:authorize access="!hasRole('ROLE_ADMIN')">
                        <a href="javascript:;" class="btn btn-primary">Xem thêm</a>
                  </sec:authorize>
                  <sec:authorize access="hasRole('ROLE_ADMIN')">
                      <a href="<c:url value="/admin/news-edit?newsId=0" />" class="btn btn-primary">Thêm</a>
                  </sec:authorize>
                  <sec:authorize access="hasRole('ROLE_ADMIN')">
                      <a href="<c:url value="/admin/news-edit?newsId=${news.id}" />" class="btn btn-warning">Chỉnh sửa</a>
                  </sec:authorize>
                  <sec:authorize access="hasRole('ROLE_ADMIN')">
                      <a href="javascript:;" onclick="deleteNews(${news.id})" class="btn btn-danger">Xóa</a>
                  </sec:authorize>
            </div>      
            </div>
    </div>
    </c:forEach>
</div>
