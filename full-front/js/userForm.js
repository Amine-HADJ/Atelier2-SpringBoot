var checked = false;

async function process(elt){
    let username = document.getElementsByName('username');
    let email = document.getElementsByName('email');
    let password = document.getElementsByName('password');
    let rePassword = document.getElementsByName('re-password');

    data = { "username": username[0].value, "email": email[0].value, "password": password[0].value }

    if(rePassword[0].value != password[0].value){
        alert("Passwords do not match");
        return
    }
    if(!checked){
        alert("Please accept the terms");
        return
    }
    
    await fetch("http://localhost:8080/register", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(data)
    }).then(async (response) => {
        if(!response.ok){
           alert("User already exists")
           return
        }
        data = await response.text();
        localStorage.setItem("userId", data);
        window.location.href = "home.html";
    });
}

function check(event){
    checked = !checked;
}