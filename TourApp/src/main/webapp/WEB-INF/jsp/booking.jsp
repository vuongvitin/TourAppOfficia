<%-- 
    Document   : booking
    Created on : Oct 11, 2021, 1:28:04 AM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<h1 class="text-center text-danger">ĐÂY LÀ TRANG THANH TOÁN</h1>

<div class="row"> 
    <div class="col-md-6">

            <c:choose>
                <c:when test="${tourId.image != null && tourId.image.startsWith('http') == true }">
                       <img class="card-img-top img-fluid" src="${tourId.image}" alt="${tourId.name}"/>
                   </c:when>
                   <c:when test="${tourId.image == null || tourId.image.startsWith('http') == false }" >
                       <img class="card-img-top img-fluid" src="<c:url value="/images/Koala.jpg" />" alt="${tourId.name}"/>
                   </c:when>
            </c:choose>

    </div>
    <div class="col-md-6">
        <h1>${tourId.name}</h1>
        <h3 class="text-danger"><fmt:formatNumber type = "number" 
         maxFractionDigits = "3" value = "${tourId.giaTour}" /> VND</h3>
        <h5 style="padding: 10px 0px;">Tour này có gì hay?</h5>
        <p class="mota">- ${tourId.mota}</p>
    </div>
</div>
    
    <br>
    
<table class="table">
    <tr>
        <th>Người lớn<br><span class='quy-dinh-tuoi'>Từ 12 tuổi trở lên</span></th>
        <th>Trẻ em<br><span class='quy-dinh-tuoi'>Từ 5 tuổi đến dưới 12 tuổi</span></th>
    </tr>

    <tr>   
        <td>
        <div class="form-inline">
            <input type="number" class="form-control" 
                   onblur="updateCartAdult('${tourId.name}', this)" 
                   value="${c.quantityAdult}" />
            x <fmt:formatNumber type = "number" 
         maxFractionDigits = "3" value = "${tourId.giaTour}" /> VND
        </div>                             
        </td>
        <td>
        <div class="form-inline">,
            <input type="number" class="form-control" 
                   onblur="updateCartChildren('${tourId.name}', this)" 
                   value="${c.quantityChildren}" />
            x <fmt:formatNumber type = "number" 
         maxFractionDigits = "3" value = "${tourId.giaTour*0.5}" /> VND
        </div>                             
        </td>
    </tr>          
</table>
      
        <div>
            <h4>Tong tien: 
                <span id="amountCart">
                    <fmt:formatNumber type = "number" 
            maxFractionDigits = "3" value = "${tourId.giaTour}" />
                </span> VND
            </h4>
        </div>
        
 <div>
     <a class="btn btn-danger btn-lg mg-t-10" >THANH TOAN</a>
</div>
<br>



<script>
    window.onload = function() {
             let dates = document.querySelectorAll(".mota")
            let d = dates[0]
            var html = $(".mota").text().split(" - ");
            
            for(var i = 0; i < html.length ; i++){
                if(i == 0){
                    d.innerText =  html[i]
                    
                }
                else{
                   var content = html[i]
                    
                   d.innerText += "\n\- " + html[i]; 
                }
               
            }
             
    }
</script>