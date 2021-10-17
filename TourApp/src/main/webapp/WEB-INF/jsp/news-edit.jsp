<%-- 
    Document   : news-edit
    Created on : Oct 17, 2021, 7:45:04 AM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<h1 class="text-center text-info">QUẢN TRỊ TIN TỨC</h1>

<section>
    <c:url value="/admin/tour-edit?tourId=${tour.id}" var="action"  />
    <form:form method="post" enctype="multipart/form-data" modelAttribute="news">
        <form:errors path="*" element="div" class="alert alert-danger" />
        
        <div class="form-group">
            <label for="name">
                Chủ đề tin tức:
            </label>
            <form:input id="name" class="form-control" path="name" />
        </div>
        <div class="form-group">
            <label for="name">
                Nội dung vắn tắt:
            </label>
            <form:textarea id="contentSummary" class="form-control" path="contentSummary" />
        </div>
        <div class="form-group">
            <label for="name">
                Nội dung vắn tắt:
            </label>
            <form:input type="file" id="image" class="form-control" path="file" />
        </div>
        <div class="form-group">
            <c:if test="${news.id > 0}">
                <input type="submit" class="btn btn-warning" 
                   value="Cập nhật" />
            </c:if>
            <c:if test="${news.id <= 0}">
                <input type="submit" class="btn btn-warning" 
                   value="Thêm tin tức" /> 
            </c:if>
        </div>
    </form:form>
</section>