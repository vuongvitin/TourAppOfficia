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