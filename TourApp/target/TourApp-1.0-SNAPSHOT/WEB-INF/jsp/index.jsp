<%-- 
    Document   : index
    Created on : Sep 18, 2021, 6:29:04 AM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<h1 class="text-center text-danger">WEB DAT TOUR</h1>
${countTours}

<ul class="pagination">
    <c:forEach begin="1" end="${Math.ceil(countTours/9)}" var="page">
        <li class="page-item"><a class="page-link" href="<c:url value="/"/>?page=${page}">${page}</a></li>
    </c:forEach>    
</ul>

<div class="row">
    <c:forEach var="tour" items="${tours}">
        <div class="col-md-4 col-xs-12" style="padding: 10px">  
        <div class="card">
               <a href="<c:url value="/tours/${tour.id}" />">
                <c:choose>
                    <c:when test="${tour.image != null && tour.image.startsWith('http') == true }">
                        <img class="card-img-top img-fluid" src="${tour.image}" alt="Card image"/>
                    </c:when>
                    <c:when test="${tour.image == null || tour.image.startsWith('http') == false }" >
                         <img class="card-img-top img-fluid" src="<c:url value="/images/Koala.jpg"/>" alt="Card image"/>
                    </c:when>
                </c:choose>
            </a>             
                <div class="card-body">
                  <h4 class="card-title">${tour.name}</h4>
                  <h5 class="card-text">${tour.giaTour} VND</h5>
                  <h5 class="card-text">${tour.diemKhoiHanh} - ${tour.diemDen}</h5>
                  <p class="card-text">Thời gian: ${tour.thoiGian}</p><!-- comment -->
                  <p class="card-text">Phương tiện: ${tour.phuongTien}</p>
                  <a href="#" class="btn btn-primary">Chi tiết</a>
            </div>      
            </div>
    </div>
    </c:forEach>
</div>
