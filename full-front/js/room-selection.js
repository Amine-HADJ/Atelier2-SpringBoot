let user;
let cardList;

function onProcess(id){
    let roomName = document.getElementsByName('room-name');
    let betName = document.getElementsByName('bet');
    

    data = {"roomName":roomName[0].value, "bet":betName[0].value}
    console.log(data);
}

function onProcessGame(obj){
    let room_id = obj.firstElementChild.innerHTML;
    console.log(room_id);
    document.location.href="/cardList-select-card.html?room_id="+room_id; 
}


function setUserInfo(){
    document.getElementById("userNameId").innerHTML= user.username;
    document.getElementById("walletId").innerHTML= user.wallet;
}

const queryString = window.location.search;
const urlParams = new URLSearchParams(queryString);
const userCardId = urlParams.get('id');


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
    setTemplateRoom("#roomlist","#roomContent",roomList)
});




