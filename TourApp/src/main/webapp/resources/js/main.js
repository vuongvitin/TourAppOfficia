/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/* global fetch */
function addToCart(name, price){

    
    fetch("/TourApp/api/cart", {
        method: 'post',
        body: JSON.stringify({
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