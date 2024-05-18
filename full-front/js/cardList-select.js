let cardList;

function onProcess(id){
    console.log(id)
    window.location.replace("/cardList-play.html?id="+id)
}


function setCardlist(){
    setTemplate("#cardlist","#tableContent", cardList)
}

document.addEventListener("DOMContentLoaded", async () => {
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