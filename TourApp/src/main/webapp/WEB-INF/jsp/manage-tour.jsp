<%-- 
    Document   : manage-tour
    Created on : Oct 12, 2021, 10:42:17 PM
    Author     : PC
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<h3 class="text-center text-info">QUẢN TRỊ TOURS</h3>

<a href="<c:url value="/admin/tour-edit?tourId=0" />" class="btn btn-success">Thêm tour</a>


<form action="">    
    <label  class="text-danger font-weight-bold h3"">Tên chuyến đi: </label>
    <input type="text" name="kw" class="form-control"/>
            
  <button type="submit" class="btn btn-primary">Tìm kiếm</button>
</form>
${countTours}


<div class="row">
    <c:forEach var="tour" items="${tours}">
        <div class="col-md-6 col-xs-10" style="padding: 10px">  
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
                  <h5 class="card-text">Giá: <fmt:formatNumber type = "number" 
         maxFractionDigits = "3" value = "${tour.giaTour}" /> VND</h5>
                  
                  <h5 class="card-text">Ngày khởi hành: <fmt:formatDate pattern = "dd-MM-yyyy" 
         value = "${tour.ngayKhoiHanh}" /></h5>
                  <h5 class="card-text">${tour.diemKhoiHanh} - ${tour.diemDen}</h5>
                  <p class="card-text">Thời gian: ${tour.thoiGian}</p><!-- comment -->
                  <p class="card-text">Phương tiện: ${tour.phuongTien}</p>
                  <a href="<c:url value="/admin/tour-edit?tourId=${tour.id}" />" class="btn btn-primary">Chỉnh sửa</a>
                  <a href="<c:url value="/admin/tour-edit/?tourId=${tour.id}" />" class="btn btn-warning">Xóa tour</a>
            </div>      
            </div>
    </div>
    </c:forEach>
</div>

<ul class="pagination">
    <c:forEach begin="1" end="${Math.ceil(countTours/20)}" var="page">
        <li class="page-item"><a class="page-link" href="<c:url value="/admin/manage-tour/"/>?page=${page}">${page}</a></li>
    </c:forEach>    
</ul>