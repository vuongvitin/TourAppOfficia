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
            <a class="nav-link" href="/">Liên hệ</a>
    </li>       
  </ul>
</nav>
    
<form action="">
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
    <label  class="text-danger font-weight-bold h3"">Tên chuyến đi: </label>
    <input type="text" name="kw" class="form-control"/>
            
  <button type="submit" class="btn btn-primary">Tìm kiếm</button>
</form>
      


    
 
