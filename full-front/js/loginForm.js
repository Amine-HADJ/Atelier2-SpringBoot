async function process(elt){
    
    let login = document.getElementsByName('login');
    let password = document.getElementsByName('password');
    

    data = { "usernameOrEmail": login[0].value, "password": password[0].value }
    console.log(data);

    await fetch("http://localhost:8080/login", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(data)
    }).then((response) => {
        if(!response.ok){
           console.log("Incorrect password")
           return
        }
        userId = response.json();
        console.log("Logged in")
        localStorage.setItem("userId", userId);
    });
}
