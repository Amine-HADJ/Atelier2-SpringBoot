let user;
let cardList;

async function sellCard(id){
    console.log(id)
    await fetch("http://localhost:8080/sellcard", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            userId: localStorage.getItem("userId"),
            cardId: id,
        })
    }).then((response) => {
        if(!response.ok){
            console.log("Couldn't sell card");
            return
        }
        console.log("Card sold")
        window.location.href = "cardList-market-sell.html";
    });
}

async function buyCard(id){
    console.log(id)
    await fetch("http://localhost:8080/buyCard", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            userId: localStorage.getItem("userId"),
            cardId: id,
        })
    }).then((response) => {
        if(!response.ok){
            console.log("Couldn't buy card");
            return
        }
        console.log("Card bought")
        window.location.href = "cardList-market-sell.html";
    });
}


function setCardlist(){
    setTemplate("#cardlist","#tableContent",cardList)
}


function setUserInfo(){
    document.getElementById("userNameId").innerHTML= user.username;
    document.getElementById("walletId").innerHTML= user.money;
}

document.addEventListener("DOMContentLoaded", async () => {
    user = await fetch("http://localhost:8080/getuserdetails", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: localStorage.getItem("userId")
    }).then((response) => response.json());
    /*
    cardList = await fetch("http://localhost:8080/getmarket", {
        method: "GET",
        headers: {
            "Content-Type": "application/json"
        },
    }).then((response) => response.json());
    */
    setUserInfo();
    setCardlist();
});