let cardList;

function onProcess(id){
    console.log(id)
}

function setGame(userCardId){
    let cList=[]
    cList.push(getCardById(userCardId,cardList))
    setTemplate("#cardPlayer","#cardPlayerContent",cList)

    let cList2=[]
    let opponentId=getRandomInt(cardList.length)
    cList2.push(getCardById(opponentId+1,cardList))

    setTemplate("#opponentPlayer","#opponentContent",cList2)
    
}

const queryString = window.location.search;
const urlParams = new URLSearchParams(queryString);
const userCardId = urlParams.get('id');

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
    setGame(userCardId);
});