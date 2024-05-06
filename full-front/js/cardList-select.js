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
    document.getElementById("walletId").innerHTML= user.wallet;
}

document.addEventListener("DOMContentLoaded", async () => {
    user = await fetch("../json/users.json").then((response) => response.json());
    cardList = await fetch("../json/cardList.json").then((response) => response.json());
    setUserInfo();
    setCardlist();
});