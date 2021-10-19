<%-- 
    Document   : admin-left
    Created on : Oct 6, 2021, 4:37:13 PM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<nav class="navbar bg-light">

  <!-- Links -->
  <ul class="navbar-nav">
    <li class="nav-item">
        <a class="nav-link" href="<c:url value="/admin/manage" />">Quản trị Tours</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="<c:url value="/admin/manage-staff" />">Quản trị nhân viên</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="<c:url value="/admin/tours-month-stats" />">Thống kê lượt đặt tour theo tháng</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="<c:url value="/admin/tours-quarter-stats" />">Thống kê lượt đặt tour theo quý</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="<c:url value="/admin/tours-year-stats" />">Thống kê lượt đặt tour theo năm</a>
    </li>
    
    <li class="nav-item">
        <a class="nav-link" href="<c:url value="/admin/tours-amount-month-stats" />">Thống kê <strong>doanh thu</strong> theo
            <strong>tháng</strong></a>
    </li><!-- comment -->
    <li class="nav-item">
      <a class="nav-link" href="<c:url value="/admin/tours-amount-quarter-stats" />">Thống kê <strong>doanh thu</strong> theo 
            <strong>quý</strong></a>
    </li><!-- comment -->
    <li class="nav-item">
      <a class="nav-link" href="<c:url value="/admin/tours-amount-year-stats" />">Thống kê <strong>doanh thu</strong> theo 
            <strong>năm</strong></a>
    </li>
  </ul>

</nav>
