<%-- 
    Document   : index
    Created on : Sep 18, 2021, 6:29:04 AM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<h1 class="text-center text-danger">WEB DAT TOUR</h1>

<div class="row">
    <c:forEach var="tours" items="${tours}">
        <div class="col-md-4 col-xs-12" style="padding: 10px">  
        <div class="card">
                <c:choose>
                    <c:when test="${tours.image != null && tours.image.startsWith('http') == true }">
                        <img class="card-img-top img-fluid" src="${tours.image}" alt="Card image"/>
                    </c:when>
                    <c:when test="${tours.image == null || tours.image.startsWith('http') == false }" >
                         <img class="card-img-top img-fluid" src="<c:url value="/images/Koala.jpg"/>" alt="Card image"/>
                    </c:when>
                </c:choose>
            </a>             
                <div class="card-body">
                  <h4 class="card-title">${tours.name}</h4>
                  <p class="card-text">${tours.giaTour} VND</p>
                  <a href="#" class="btn btn-primary">Dat tour</a>
            </div>      
            </div>
    </div>
    </c:forEach>
</div>
