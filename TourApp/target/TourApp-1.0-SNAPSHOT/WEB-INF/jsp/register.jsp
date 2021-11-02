<%-- 
    Document   : register
    Created on : Sep 8, 2021, 10:28:23 PM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<h1 class="text-center text-danger">ĐĂNG KÝ</h1>

<c:if test="${errMsg !=  null}">
    <div class="alert alert-danger">
        ${errMsg}
    </div>
</c:if>

<c:url value="/register" var="action"  />
<form:form method="post" action="${action}" 
           enctype="multipart/form-data" modelAttribute="user">
    <form:errors path="*" cssClass="alert alert-danger" element="div"/>
    
    <div class="form-group"> 
        <label for="firstname">Tên</label>
        <form:input type="text" id="firstName" path = "firstName" class="form-control" />
        <form:errors path="firstName" cssClass="alert alert-danger" element="div"/>
    </div>
    <div class="form-group"> 
        <label for="lastname">Họ</label>
        <form:input type="text" id="lastName" path = "lastName" class="form-control" />
        <form:errors path="lastName" cssClass="alert alert-danger" element="div"/>
    </div>
    <div class="form-group"> 
        <label for="lastname">Email</label>
        <form:input type="email" id="email" path = "email" class="form-control" />
        <form:errors path="email" cssClass="alert alert-danger" element="div"/>
    </div>
    <div class="form-group"> 
        <label for="username">Tài khoản</label>       
        <form:input type="text" id="username" path = "username" class="form-control" />
        <form:errors path="username" cssClass="alert alert-danger" element="div"/>
    </div>
    <div class="form-group"> 
        <label for="password">Mật khẩu</label>
        <form:input type="password" id="password" path = "password" class="form-control" />
        <form:errors path="password" cssClass="alert alert-danger" element="div"/>
    </div>
    <div class="form-group"> 
        <label for="password">Xác nhận mật khẩu:</label>
        <form:input type="password" id="confirm-password" path = "confirmPassword" class="form-control" />
        <form:errors path="confirmPassword" cssClass="alert alert-danger" element="div"/>
    </div>
    <div class="form-group"> 
        <label for="avatar">Ảnh đại điện</label>
        <form:input type="file" id="avatar" path = "file" class="form-control" />
        <form:errors path="file" cssClass="alert alert-danger" element="div"/>
    </div>
    <div class="form-group">
        <input type="submit" value="Đăng Ký" class="btn btn-danger"/>
    </div>
</form:form>
