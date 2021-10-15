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
      <a class="nav-link" href="<c:url value="/admin/product-month-stats" />">Thong ke doanh thu theo thang</a>
    </li>
  </ul>

</nav>
