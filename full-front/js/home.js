let user;

function setUserInfo(){
    document.getElementById("userNameId").innerHTML= user.username;
    document.getElementById("walletId").innerHTML= user.money;
}


document.addEventListener("DOMContentLoaded", async () => {
    cards = await fetch("../json/cardMarket.json").then((response) => response.json());

    await fetch("http://localhost:8080/generateCards", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(cards)
    }).then((response) => console.log(response.text()));
    
    user = await fetch("http://localhost:8080/getuserdetails", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: localStorage.getItem("userId")
    }).then((response) => response.json());
    setUserInfo();
});








