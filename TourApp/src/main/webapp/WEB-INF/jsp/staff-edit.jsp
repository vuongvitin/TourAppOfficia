<%-- 
    Document   : staff-add
    Created on : Oct 15, 2021, 7:28:40 AM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<c:if test="${staff.id > 0}">
    <h1 class="text-center text-info">Chỉnh sửa nhân viên</h1>
</c:if>
<c:if test="${staff.id <= 0}">
    <h1 class="text-center text-info">Thêm nhân viên</h1> 
</c:if>

<section>
    <form:form method="post" enctype="multipart/form-data" modelAttribute="staff">
        <div class="form-group">
            <label for="name">
                Tên nhân viên:
            </label>
            <form:input id="name" class="form-control" path="name" />
        </div>
        <div class="form-group">
            <label for="file">
                Ảnh:
            </label>
            <form:input type="file" id="avatar" class="form-control" path="file" />
        </div>
        <div class="form-group">
            <label for="avatar">
                Chức vụ:
            </label>
            <form:input id="job" class="form-control" path="job" />
        </div>
        <div class="form-group">
            <label for="telNum">
                Số điện thoại:
            </label>
            <form:input id="telNum" class="form-control" path="telNum" />
        </div>
        <div class="form-group">
            <c:if test="${staff.id > 0}">
                <input type="submit" class="btn btn-warning" 
                   value="Cập nhật" />
            </c:if>
            <c:if test="${staff.id <= 0}">
                <input type="submit" class="btn btn-warning" 
                   value="Thêm tour" /> 
            </c:if>
        </div>
    </form:form>
</section>