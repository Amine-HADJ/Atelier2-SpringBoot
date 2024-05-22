let user;
let authLinks;
let userDetails;
const navbarDiv = document.querySelector('nav');

function insertNavbar() {
    navbarDiv.innerHTML = `
      <h3 id="authLinks" class="ui right floated header">
        <a href="/loginUser.html">Login</a>
        <span>|
        <a id="registerAnchor" href="/formUser.html">Register</a>
      </h3>
      <h3 id="userDetails" style="display: none;" class="ui right floated header">
        <i class="user circle outline icon"></i>
        <div class="content">
          <span id="userNameId"></span>
          <div id="wallet" class="sub header"></div>
        </div>
      </h3>
    `;
}

function setUserInfo(){
  userDetails = navbarDiv.querySelector("#userDetails");
  navbarDiv.querySelector("#userNameId").innerHTML = user.username;
  navbarDiv.querySelector("#wallet").innerHTML = user.money+"$";
  userDetails.style.display = "block";
}

document.addEventListener("DOMContentLoaded", async () => {
    const id = localStorage.getItem("userId");
    insertNavbar();
    authLinks = document.querySelector("#authLinks");

    if(id){
        authLinks.style.display = "none";
        user = await fetch("http://localhost:8080/getuserdetails", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: localStorage.getItem("userId")
        }).then((response) => response.json())
        .catch(error => { 
          authLinks.style.display = "block";
          return;
        });
        setUserInfo();
    }
});