<%-- 
    Document   : manage-staff
    Created on : Oct 14, 2021, 2:51:46 PM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<h1 class="text-center text-info">QUẢN TRỊ NHÂN VIÊN</h1>

<a href="<c:url value="/admin/staff-add-user" />" class="btn btn-success">Thêm tài khoản nhân viên</a>
<a href="<c:url value="/admin/staff-edit?staffId=0" />" class="btn btn-success">Thêm nhân viên</a>

<br></br>
<form class="form-inline" action="">    
    <label  class="text-danger font-weight-bold h3"">Tên nhân viên: </label>
    <input type="text" name="kw" class="form-control"/>
    <button type="submit" class="btn btn-primary" >Tìm kiếm</button>
</form>

<br>

<table class="table">
    <tr>
        <th>Tên nhân viên</th>
        <th>Ảnh</th>
        <th>Chức vụ</th>
        <th>Số điện thoại</th>
        <th></th>
        <th></th>
    </tr>
    
   
    <c:forEach items="${staffs}" var="staff">
        <tr id="staff${staff.id}">
        <td>${staff.name}</td>
        <td>
            <c:choose>
                <c:when test="${staff.avatar != null && staff.avatar.startsWith('http') == true }">
                    <img style="width: 15em" class="rounded-circle" class="card-img-top img-fluid mx-auto" src="${staff.avatar}" alt="Card image"/>
                </c:when>
                <c:when test="${staff.avatar == null || staff.avatar.startsWith('http') == false }" >
                     <img style="width: 15em" class="rounded-circle" class="card-img-top img-fluid" src="<c:url value="/images/Koala.jpg"/>" alt="Card image"/>
                </c:when>
            </c:choose>
        </td>
        <td>${staff.job}</td>
        <td>${staff.telNum}</td>
        <td><a href="<c:url value="/admin/staff-edit?staffId=${staff.id}" />" class="btn btn-warning">Chỉnh sửa</a></td>
        <td><a href="javascipt:;" onclick="deleteStaff(${staff.id})" class="btn btn-danger">Xóa</a></td>
        </tr>
    </c:forEach>
</table>