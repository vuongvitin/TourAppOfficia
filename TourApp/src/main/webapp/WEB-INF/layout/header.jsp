<%-- 
    Document   : header
    Created on : Sep 13, 2021, 1:29:25 AM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<nav class="navbar navbar-expand-sm bg-info navbar-dark" style="padding: 15px; font-size: 1.5em ">

  <!-- Links -->
  <ul class="navbar-nav">
    <li class="nav-item">
        <a class="nav-link" href="/"><strong>Trang chủ</strong></a>
    </li>
    <c:forEach items="${types}" var="type">
        <li class="nav-item">
            <a class="nav-link" href="/">${type.ten}</a>
        </li>
    </c:forEach>
    <li class="nav-item">
            <a class="nav-link" href="/">Liên hệ</a>
    </li>    
  </ul>
</nav>

