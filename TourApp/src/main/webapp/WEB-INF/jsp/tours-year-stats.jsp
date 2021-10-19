<%-- 
    Document   : tours-year-stats
    Created on : Oct 19, 2021, 9:30:59 AM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<h1 class="text-center text-info">THỐNG KÊ SỐ LƯỢNG ĐẶT TOUR THEO NĂM</h1>

<form class="form" action="">
        <div class="form-group">
            <label  class="text-danger font-weight-bold h3"">Từ khoa: </label>
            <input type="text" name="kw" class="form-control"/>
        </div>
        <div class="form-group">
            <label  class="text-danger font-weight-bold h3"">Từ thoi diem:</label>
            <input type="date" name="fromDate" class="form-control"/>
        </div>
        <div class="form-group">
            <label class="text-danger font-weight-bold h3">đến thoi diem:</label>
            <input type="date" name="toDate" class="form-control"/>
        </div>        
        <button class="btn btn-success" type="submit">Báo cáo</button>
</form>

<div>
  <canvas id="myTourYearStatsChart"></canvas>
</div>

<table class="table">
    <tr>
        <th>Tháng</th>
        <th>Lượt đặt</th>
    </tr>
    <c:forEach items="${yearStats}" var="t">
    <tr>
        <td>Năm ${t[0]}</td>
        <td>${t[1]} lượt</td>
    </tr>
    </c:forEach>
</table>

<script>
    let tourLabels=[], tourInfo=[];
    
    <c:forEach items="${yearStats}" var="t">
        tourLabels.push('${t[0]}')
        tourInfo.push(${t[1]})
    </c:forEach>
        
    window.onload = function(){
        tourNumberBookYearChart("myTourYearStatsChart", tourLabels, tourInfo);
    } 
</script>
