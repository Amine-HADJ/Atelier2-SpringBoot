async function process(elt){
    
    let firstName = document.getElementsByName('first-name');
    let lastName = document.getElementsByName('last-name');
    let password = document.getElementsByName('password');
    let rePassword = document.getElementsByName('re-password');

    data = { "username": firstName[0].value, "email": lastName[0].value, "password": password[0].value }
    console.log(data);

    await fetch("http://localhost:8080/register", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(data)
    }).then(async (response) => {
        if(!response.ok){
           console.log("User already exists")
           return
        }
        data = await response.text();
        localStorage.setItem("userId", data);
    });
}

function check(input){
    console.log("checked");
}