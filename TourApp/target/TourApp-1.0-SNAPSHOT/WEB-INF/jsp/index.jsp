<%-- 
    Document   : index
    Created on : Sep 18, 2021, 6:29:04 AM
    Author     : PC
--%>

<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="spring"  uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<h1 class="text-center text-danger">WEB DAT TOUR</h1>
${countTours}
<sec:authorize access="hasRole('ROLE_ADMIN')">
    <div>
        <a href="<c:url value="/admin/manage"/>"  class="btn btn-danger" >Trang quản trị</a>
    </div>
</sec:authorize>

<form action="">
    <sec:authorize access="!hasRole('ROLE_ADMIN')">
        <div class="form-inline">
                    <label for="sel1" class="text-danger font-weight-bold h3"">Giá từ:</label>
                    <select class="form-control" id="sel1" name="fp">
                      <option selected value="">Chọn giá</option>
                      <option value="200000">2 trăm</option>
                      <option value="1000000">1 triệu</option>
                      <option value="2000000">2 triệu</option>
                      <option value="3000000">3 triệu</option>
                      <option value="5000000">5 triệu</option>
                      <option value="6000000">6 triệu</option>
                      <option value="7000000">7 triệu</option>
                      <option value="8000000">8 triệu</option>
                      <option value="9000000">9 triệu</option>
                      <option value="10000000">10 triệu</option>
                    </select>
                    <label for="sel1" class="text-danger font-weight-bold h3"">đến:</label>
                    <select class="form-control" id="sel1" name="tp">
                      <option selected value="">Chọn giá</option>
                      <option value="500000">5 trăm</option>
                      <option value="1000000">1 triệu</option>
                      <option value="2000000">2 triệu</option>
                      <option value="3000000">3 triệu</option>
                      <option value="4000000">4 triệu</option>
                      <option value="5000000">5 triệu</option>
                      <option value="6000000">6 triệu</option>
                      <option value="7000000">7 triệu</option>
                      <option value="8000000">8 triệu</option>
                      <option value="9000000">9 triệu</option>
                      <option value="10000000">10 triệu</option>
                      <option value="25000000">25 triệu</option>
                      <option value="35000000">35 triệu</option>
                    </select>
        </div>
        <div class="form-inline">
                <label  class="text-danger font-weight-bold h3"">Thời điểm khởi hành từ:</label>
                <input type="date" name="startDate" class="form-control"/>
                <label  class="text-danger font-weight-bold h3"">đến:</label>
                <input type="date" name="endDate" class="form-control"/>

        </div>
    </sec:authorize>
    <label  class="text-danger font-weight-bold h3"">Tên chuyến đi: </label>
    <input type="text" name="kw" class="form-control"/>
            
  <button type="submit" class="btn btn-primary">Tìm kiếm</button>
</form>

<ul class="pagination">
    <c:forEach begin="1" end="${Math.ceil(countTours/20)}" var="page">
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
                  <h5 class="card-text">Giá: <fmt:formatNumber type = "number" 
         maxFractionDigits = "3" value = "${tour.giaTour}" /> VND</h5>
                  
                  <h5 class="card-text">Ngày khởi hành: <fmt:formatDate pattern = "dd-MM-yyyy" 
         value = "${tour.ngayKhoiHanh}" /></h5>
                  <h5 class="card-text">${tour.diemKhoiHanh} - ${tour.diemDen}</h5>
                  <p class="card-text">Thời gian: ${tour.thoiGian}</p><!-- comment -->
                  <p class="card-text">Phương tiện: ${tour.phuongTien}</p>
                  <sec:authorize access="!hasRole('ROLE_ADMIN')">
                        <a href="<c:url value="/tours/${tour.id}" />" class="btn btn-primary">Chi tiết</a>
                  </sec:authorize>
                  <sec:authorize access="hasRole('ROLE_ADMIN')">
                      <a href="<c:url value="/admin/tour-edit?tourId=${tour.id}" />" class="btn btn-primary">Chỉnh sửa</a>
                  </sec:authorize>     
            </div>      
            </div>
    </div>
    </c:forEach>
</div>
