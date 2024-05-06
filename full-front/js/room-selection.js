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
    user = await fetch("../json/users.json").then((response) => response.json());
    cardList = await fetch("../json/cardList.json").then((response) => response.json());
    setUserInfo()
    setTemplateRoom("#roomlist","#roomContent",roomList)
});




