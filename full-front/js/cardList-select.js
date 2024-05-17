let user;
let cardList;

function onProcess(id){
    console.log(id)
    window.location.replace("/cardList-play.html?id="+id)
}


function setCardlist(){
    setTemplate("#cardlist","#tableContent", cardList)
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
        body: JSON.stringify({
            userId: localStorage.getItem("userId")
        })
    }).then((response) => response.json());
    setCardlist();
});