<%-- 
    Document   : tours-amount-month-stats
    Created on : Oct 19, 2021, 9:53:39 AM
    Author     : PC
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<h1 class="text-center text-info">THỐNG KÊ DOANH THU THEO THÁNG</h1>

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
  <canvas id="myMonthAmountStatsChart"></canvas>
</div>

<table class="table">
    <tr>
        <th>Tháng</th>
        <th>Lượt đặt</th>
    </tr>
    <c:forEach items="${monthAmountStats}" var="t">
    <tr>
        <td>${t[0]}/${t[1]}</td>
        <td><fmt:formatNumber type = "number" 
         maxFractionDigits = "3" value = "${t[2]}" /> VNĐ</td>
    </tr>
    </c:forEach>
</table>

<script>
    let tourLabels=[], tourInfo=[];
    
    <c:forEach items="${monthAmountStats}" var="t">
        tourLabels.push('${t[0]}/${t[1]}')
        tourInfo.push(${t[2]})
    </c:forEach>
        
    window.onload = function(){
        myMonthAmountStatsChart("myMonthAmountStatsChart", tourLabels, tourInfo);
    } 
</script>
