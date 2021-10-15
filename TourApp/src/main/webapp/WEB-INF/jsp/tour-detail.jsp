<%-- 
    Document   : tour-detail
    Created on : Sep 28, 2021, 8:04:38 PM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<h1 class="text-center text-danger">CHI TIẾT CHUYẾN ĐI</h1>

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
        <h3 class="text-danger">${tourId.giaTour} VND</h3>
        <h5 style="padding: 10px 0px;">Tour này có gì hay?</h5>
        <p class="mota">- ${tourId.mota}</p>
        <div>
            <a class="btn btn-primary btn-lg mg-t-10" href="<c:url value="/booking/${tourId.id}" />" 
               onclick="addToCart('${tourId.name}', ${tourId.giaTour})">Dat ngay</a>
        </div>
<!--        <a href="#" class="btn btn-primary" onclick="addToCart(${tourId.id}, '${tourId.name}', ${tourId.giaTour})">Dat hang</a>-->
    </div>
</div>        
        
<br></br>

             
            
            
<div class="listImges">
    <div class="row">
        <c:forEach items="${tourId.imgesCollection}" var="images">
            <div class="col-4 pt-2"> <img class="card-img-top img-fluid" src="${images.imges}" alt="${tourId.name}"/></div>
        </c:forEach>
    </div>
    <br>
</div>
 
<br></br>
        
<form>
    <div class="form-group" style="padding: 10px">
        <label for="comment">Bình luận:</label>
        <textarea class="form-control" cols="6" id="commentId" placeholder="Nhập bình luận..."></textarea>
<!--        <button type="button" onclick="addComment({tourId.id})" class="btn btn-primary">Gui binh luan</button>-->
        <button type="button" class="btn btn-primary">Gửi bình luận</button>
    </div>   
</form> 

${countComment}
<ul class="pagination">
    <c:forEach begin="1" end="${Math.ceil(countComment/3)}" var="page">
        <li class="page-item"><a class="page-link" href="<c:url value="/tours/${tourId.id}"/>?page=${page}">${page}</a></li>
    </c:forEach>    
</ul>

<div id="commentArea">
    <c:forEach items="${comments}" var="comment" >
    <div class="row">
        <div class="col-md-2" style="padding: 2px">
            <img src="https://res.cloudinary.com/dwsyse8jk/image/upload/v1630358291/uuylm0wbfblm3bfd1jdn.png" class="rounded-circle img-fluid" alt="Cinque Terre">
        </div>
        <div class="col-md-10 mydate">
            <p>${comment.content}</p>
            <i>${comment.createdDate}</i>
        </div>
    </div>
    <br></br>
    </c:forEach>
</div>     
    
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

<script>
    window.onload = function() {
        let dates = document.querySelectorAll("div.mydate > i")
        for (var i = 0; i < dates.length; i++) {
            let d = dates[i]
            d.innerText = moment(d.innerText).fromNow();
        }
    }
</script>

