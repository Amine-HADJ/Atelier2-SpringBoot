let user;

function setUserInfo(){
    document.getElementById("userNameId").innerHTML= user.username;
    document.getElementById("walletId").innerHTML= user.wallet;
}


document.addEventListener("DOMContentLoaded", async () => {
    user = await fetch("../json/users.json").then((response) => response.json());
    setUserInfo();
});








