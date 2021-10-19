<%-- 
    Document   : tours-quarter-stats
    Created on : Oct 19, 2021, 7:42:35 AM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<h1 class="text-center text-info">THỐNG KÊ SỐ LƯỢNG ĐẶT TOUR THEO QUÝ</h1>

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
  <canvas id="myTourQuarterStatsChart"></canvas>
</div>

<table class="table">
    <tr>
        <th>Tháng</th>
        <th>Lượt đặt</th>
    </tr>
    <c:forEach items="${quarterStats}" var="t">
    <tr>
        <td>Quý ${t[0]} năm ${t[1]}</td>
        <td>${t[2]} lượt</td>
    </tr>
    </c:forEach>
</table>

<script>
    let tourLabels=[], tourInfo=[];
    
    <c:forEach items="${quarterStats}" var="t">
        tourLabels.push('${t[0]}/${t[1]}')
        tourInfo.push(${t[2]})
    </c:forEach>
        
    window.onload = function(){
        tourNumberBookQuarterChart("myTourQuarterStatsChart", tourLabels, tourInfo);
    } 
</script>
