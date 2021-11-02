/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/* global fetch */
function addToCart(tourId, name, price){
    fetch("/TourApp/api/cart", {
        method: 'post',
        body: JSON.stringify({
            "tourId": tourId,
            "tourName": name,
            "priceAdult": price,
            "quantityAdult": 0,
            "priceChildren": price*0.5,
            "quantityChildren": 0,
            
        }),
        headers:{
            "Content-Type": "application/json"
        }
    }).then(function(res){
        return res.json();
    }).then(function(data){
        console.info(data)
    })
}

function updateCartAdult(name, obj){
   fetch("/TourApp/api/cart", {
        method: 'put',
        body: JSON.stringify({
            "tourName": name,
            "priceAdult": 0,
            "quantityAdult": obj.value,
            "priceChildren": 0,
            "quantityChildren": 0
        }),
        headers:{
            "Content-Type": "application/json"
        }
    }).then(function(res){
        return res.json()
    }).then(function (data){
        let amount = document.getElementById("amountCart")
        amount.innerText = data
    })
}
function updateCartChildren(name, obj){
   fetch("/TourApp/api/cart", {
        method: 'put',
        body: JSON.stringify({
            "tourName": name,
            "priceAdult": 0,
            "quantityAdult": 0,
            "priceChildren": 0,
            "quantityChildren": obj.value
        }),
        headers:{
            "Content-Type": "application/json"
        }
    }).then(function(res){
        return res.json()
    }).then(function (data){
        let amount = document.getElementById("amountCart")
        amount.innerText = data
    })
} 

function deleteProduct(tourId) {
    if (confirm("Bạn chắc chắn xóa không?") == true) { 
        fetch(`/TourApp/api/tours/${tourId}`, {
            method: "delete",
            headers: {
                "Content-Type": "application/json"
            }
        }).then(res => {
            if (res.status == 200) {
                let d = document.getElementById(`tour${tourId}`);
//                d.style.display = "none";
                location.reload();
            } else 
                alert("Something wrong!!!");
        })
    }
}

function deleteStaff(staffId) {
    if (confirm("Bạn chắc chắn xóa không?") == true) { 
        fetch(`/TourApp/api/staffs/${staffId}`, {
            method: "delete",
            headers: {
                "Content-Type": "application/json"
            }
        }).then(res => {
            if (res.status == 200) {
                let d = document.getElementById(`staff${staffId}`);
//                d.style.display = "none";
                location.reload();
            } else 
                alert("Something wrong!!!");
        })
    }    
}

function addComment(tourId){
    fetch("/TourApp/api/add-comment", {
        method: 'post',
        body: JSON.stringify({
            "content": document.getElementById("commentId").value,
            "tourId": tourId          
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function(res){
        console.info(res);
        
        return res.json();
    }).then(function(data){
        console.info(data);
        
        let area = document.getElementById("commentArea");
        
        area.innerHTML = `<div class="row">
                <div class="col-md-2" style="padding: 2px">
                    <img src="${data.user.avatar}" class="rounded-circle img-fluid" alt="Cinque Terre">
                </div>
                <div class="col-md-10 mydate">
                    <p>${data.content}</p>
                    <i>${moment(data.createdDate).fromNow()}</i>
                </div>
            </div>       
            `
            + area.innerHTML
    });
}

function pay(){
    if(confirm("Ban có chắc chắn thanh toán không??") == true){
        fetch(`/TourApp/api/pay`, {
            method: "post"
        }).then(function(res){
            return res.json();
        }).then(function(data){
            console.info(data)
            location.reload()
        })
    }
}

function deleteNews(newsId) {
    if (confirm("Bạn chắc chắn xóa không?") == true) { 
        fetch(`/TourApp/api/news/${newsId}`, {
            method: "delete",
            headers: {
                "Content-Type": "application/json"
            }
        }).then(res => {
            if (res.status == 200) {
                let d = document.getElementById(`news${newsId}`);
                d.style.display = "none";
//                location.reload();
            } else 
                alert("Something wrong!!!");
        })
    }    
}

//Chart

function generateColor(){
    let r = parseInt(Math.random()*255)
    let g = parseInt(Math.random()*255)
    let b = parseInt(Math.random()*255)
    return `rgb(${r}, ${g}, ${b})`
}

function tourNumberBookMonthChart(id, tourLabels=[], tourInfo=[] ){
      
    let colors=[]
    for(let i = 0; i < tourInfo.length; i++)
        colors.push(generateColor())
    
    const data = {
  labels: tourLabels,
  datasets: [{
    label: 'Thống kê số lượng đặt tour theo tháng',
    data: tourInfo,
    backgroundColor: colors,
    hoverOffset: 4,
    borderColor: 'rgb(75, 192, 192)'
    }]
  };

    const config = {
        type: 'bar',
        data: data,
      };
      
    let ctx = document.getElementById(id).getContext("2d");
    new Chart(ctx, config)  
}

function tourNumberBookQuarterChart(id, tourLabels=[], tourInfo=[] ){
      
    let colors=[]
    for(let i = 0; i < tourInfo.length; i++)
        colors.push(generateColor())
    
    const data = {
  labels: tourLabels,
  datasets: [{
    label: 'Thống kê số lượng đặt tour theo quý',
    data: tourInfo,
    backgroundColor: colors,
    hoverOffset: 4,
    borderColor: 'rgb(75, 192, 192)'
    }]
  };

    const config = {
        type: 'bar',
        data: data,
      };
      
    let ctx = document.getElementById(id).getContext("2d");
    new Chart(ctx, config)  
}

function tourNumberBookYearChart(id, tourLabels=[], tourInfo=[] ){
      
    let colors=[]
    for(let i = 0; i < tourInfo.length; i++)
        colors.push(generateColor())
    
    const data = {
  labels: tourLabels,
  datasets: [{
    label: 'Thống kê số lượng đặt tour theo năm',
    data: tourInfo,
    backgroundColor: colors,
    hoverOffset: 4,
    borderColor: 'rgb(75, 192, 192)'
    }]
  };

    const config = {
        type: 'bar',
        data: data,
      };
      
    let ctx = document.getElementById(id).getContext("2d");
    new Chart(ctx, config)  
}

function myMonthAmountStatsChart(id, tourLabels=[], tourInfo=[] ){
      
    let colors=[]
    for(let i = 0; i < tourInfo.length; i++)
        colors.push(generateColor())
    
    const data = {
  labels: tourLabels,
  datasets: [{
    label: 'Thống kê doanh thu theo tháng',
    data: tourInfo,
    backgroundColor: colors,
    hoverOffset: 4,
    borderColor: 'rgb(75, 192, 192)'
    }]
  };

    const config = {
        type: 'bar',
        data: data,
      };
      
    let ctx = document.getElementById(id).getContext("2d");
    new Chart(ctx, config)  
}

function myQuarterAmountStatsChart(id, tourLabels=[], tourInfo=[] ){
      
    let colors=[]
    for(let i = 0; i < tourInfo.length; i++)
        colors.push(generateColor())
    
    const data = {
  labels: tourLabels,
  datasets: [{
    label: 'Thống kê doanh thu theo quý',
    data: tourInfo,
    backgroundColor: colors,
    hoverOffset: 4,
    borderColor: 'rgb(75, 192, 192)'
    }]
  };

    const config = {
        type: 'bar',
        data: data,
      };
      
    let ctx = document.getElementById(id).getContext("2d");
    new Chart(ctx, config)  
}


function myYearAmountStatsChart(id, tourLabels=[], tourInfo=[] ){
      
    let colors=[]
    for(let i = 0; i < tourInfo.length; i++)
        colors.push(generateColor())
    
    const data = {
  labels: tourLabels,
  datasets: [{
    label: 'Thống kê doanh thu theo năm',
    data: tourInfo,
    backgroundColor: colors,
    hoverOffset: 4,
    borderColor: 'rgb(75, 192, 192)'
    }]
  };

    const config = {
        type: 'bar',
        data: data,
      };
      
    let ctx = document.getElementById(id).getContext("2d");
    new Chart(ctx, config)  
}