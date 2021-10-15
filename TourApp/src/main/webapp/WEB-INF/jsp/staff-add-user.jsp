<%-- 
    Document   : staff-add-user
    Created on : Oct 15, 2021, 10:18:43 AM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<h1 class="text-center text-danger">Thêm tài khoản nhân viên</h1>

<c:if test="${errMsg !=  null}">
    <div class="alert alert-danger">
        ${errMsg}
    </div>
</c:if>

<form:form method="post"  
           enctype="multipart/form-data" modelAttribute="user">
    <div class="form-group"> 
        <label for="firstname">First Name</label>
        <form:input type="text" id="username" path = "firstName" class="form-control" />
    </div>
    <div class="form-group"> 
        <label for="lastname">Last Name</label>
        <form:input type="text" id="username" path = "lastName" class="form-control" />
    </div>
    <div class="form-group"> 
        <label for="lastname">Email</label>
        <form:input type="email" id="email" path = "email" class="form-control" />
    </div>
    <div class="form-group"> 
        <label for="username">Username</label>       
        <form:input type="text" id="username" path = "username" class="form-control" />
    </div>
    <div class="form-group"> 
        <label for="password">Password</label>
        <form:input type="password" id="password" path = "password" class="form-control" />
    </div>
    <div class="form-group"> 
        <label for="password">Confirm Password</label>
        <form:input type="password" id="confirm-password" path = "confirmPassword" class="form-control" />
    </div>
    <div class="form-group"> 
        <label for="avatar">Confirm Password</label>
        <form:input type="file" id="avatar" path = "file" class="form-control" />
    </div>
    <div class="form-group">
        <input type="submit" value="Thêm" class="btn btn-danger"/>
    </div>
</form:form>
