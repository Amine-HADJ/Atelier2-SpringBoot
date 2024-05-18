async function process(elt){
    
    let login = document.getElementsByName('login');
    let password = document.getElementsByName('password');
    

    data = { "usernameOrEmail": login[0].value, "password": password[0].value }

    if(data.usernameOrEmail == "" || data.password == ""){
        alert("Empty fields")
        return
    }

    await fetch("http://localhost:8080/login", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(data)
    }).then(async (response) => {
        if(!response.ok){
           alert("Incorrect password")
           return
        }
        userId = await response.text();
        localStorage.setItem("userId", userId);
        window.location.href = "home.html";
    });
}
