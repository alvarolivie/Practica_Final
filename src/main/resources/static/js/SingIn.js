let username;
let password;

let checkUser=async()=>{
    if(getData()){
        fetch("elPeroli/v1/owner/checkCredentials", {
            method: "POST",
            headers: {
                "content-Type": "application/json",
                "Accept": "application/json"
            },
            body: JSON.stringify({
                "username":username,
                "password":password

            })
        }).then(res => {
            if (res.ok) {
                entrarGestor();
            }
        }).catch(error => {
            alert("Por favor compruebe los datos");
        });
    }
    else {
        alert("Porfavor rellena todos los campos")
    }
}

let getData=()=>{
    let inputs = document.getElementsByTagName("input")
    username = inputs.item(0).value;
    password = inputs.item(1).value;
    if (username!= '' & password!= '') {
        return true;
    }
    else {
        return false;
    }
}

let entrarGestor=async()=>{
    let inputs = document.getElementsByTagName("input")
    username = inputs.item(0).value;
    console.log(username);
    sessionStorage["username"]=username;
}