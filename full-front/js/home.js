document.addEventListener("DOMContentLoaded", async () => {
    cards = await fetch("../json/cardMarket.json").then((response) => response.json());

    await fetch("http://localhost:8080/generateCards", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(cards)
    }).then(async (response) => console.log(await response.text()));
});