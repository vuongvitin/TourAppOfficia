<%-- 
    Document   : tours-amount-quarter-stats.jsp
    Created on : Oct 19, 2021, 10:25:50 AM
    Author     : PC
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<h1 class="text-center text-info">THỐNG KÊ DOANH THU THEO QUÝ</h1>

<form class="form" action="">
        <div class="form-group">
            <label  class="text-danger font-weight-bold h3"">Từ khóa: </label>
            <input type="text" name="kw" class="form-control"/>
        </div>
        <div class="form-group">
            <label  class="text-danger font-weight-bold h3"">Từ thời điểm:</label>
            <input type="date" name="fromDate" class="form-control"/>
        </div>
        <div class="form-group">
            <label class="text-danger font-weight-bold h3">đến thời điểm:</label>
            <input type="date" name="toDate" class="form-control"/>
        </div>        
        <button class="btn btn-success" type="submit">Báo cáo</button>
</form>

<div>
  <canvas id="myQuarterAmountStatsChart"></canvas>
</div>

<table class="table">
    <tr>
        <th>Quý</th>
        <th>Doanh thu</th>
    </tr>
    <c:forEach items="${quarterAmountStats}" var="t">
    <tr>
        <td>Quý ${t[0]} năm ${t[1]}</td>
        <td><fmt:formatNumber type = "number" 
         maxFractionDigits = "3" value = "${t[2]}" /> VNĐ</td>
    </tr>
    </c:forEach>
</table>

<script>
    let tourLabels=[], tourInfo=[];
    
    <c:forEach items="${quarterAmountStats}" var="t">
        tourLabels.push('${t[0]}/${t[1]}')
        tourInfo.push(${t[2]})
    </c:forEach>
        
    window.onload = function(){
        myQuarterAmountStatsChart("myQuarterAmountStatsChart", tourLabels, tourInfo);
    } 
</script>