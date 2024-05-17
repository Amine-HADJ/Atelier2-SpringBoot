let user;
let cardList;

async function sellCard(id){
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
        console.log("Card sold");
        //window.location.href = "cardList-market-sell.html";
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
    const id = localStorage.getItem("userId");
    if(id){
        user = await fetch("http://localhost:8080/getuserdetails", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: localStorage.getItem("userId")
        }).then((response) => response.json());

        setUserInfo();
    }
    
    cardList = await fetch("http://localhost:8080/getinventory", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(localStorage.getItem("userId"))
    }).then(async (response) => { 
        const data = await response.json();
        return data.cards;
    });
    setCardlist();
});