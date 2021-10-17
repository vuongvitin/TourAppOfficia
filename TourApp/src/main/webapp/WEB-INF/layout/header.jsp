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
        <a class="nav-link" href="<c:url value="/" />"><strong>Trang chủ</strong></a>
    </li>
    <c:forEach items="${types}" var="type">
        <li class="nav-item">
            <c:url value="/" var="typePath">
                    <c:param name="TypeId" value="${type.id}"></c:param>
            </c:url>
            <a class="nav-link" href="${typePath}">${type.ten}</a>
        </li>
    </c:forEach>
    <li class="nav-item">
        <a class="nav-link" href="<c:url value="/news-view" />">Tin tức</a>
    </li>
    
    <c:if test="${pageContext.request.userPrincipal.name == null}">
        <li class="nav-item">
            <a href="<c:url value="/login"/>" class="nav-link text-warning">
                <i class="fas fa-user">Dang nhap</i>
            </a>
        </li>
    </c:if>
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <li class="nav-item">
            <a href="<c:url value="/"/>" class="nav-link text-danger">                        
                <c:if test="${currentUser.avatar != null}" >
                    <img style="width: 30px" class="rounded-circle" src="${currentUser.avatar}"  alt="userImg"/>
                </c:if>
                <c:if test="${currentUser.avatar == null}" >
                    <i class="fas fa-user">${pageContext.request.userPrincipal.name}</i>
                </c:if>  
            </a>
        </li>
        <li class="nav-item">
            <a href="<c:url value="/logout"/>" class="nav-link text-danger">
                <i class="">Dang xuat</i>
            </a>
        </li>
    </c:if> 
    <li class="nav-item">
        <a href="<c:url value="/register"/>" class="nav-link text-warning">
             <i class="fas fa-check-circle">Dang Ky</i>
        </a>
    </li>
  </ul>
</nav>
    

      


    
 
