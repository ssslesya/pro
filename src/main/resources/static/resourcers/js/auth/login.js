function login() {
    let id = document.getElementById("id").value;
    let password = document.getElementById("password").value;

    let client = {
        id: id,
        password: password,
        name: "",

    };
    if(id !== "" && password !== "" ) {
        fetch('http://localhost:8080/auth/login', {
            method: 'POST',
            headers: {
                 'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify(client)
        })
            .then(response => {
            if (!response.ok) {
                document.getElementById("message").innerText = "Неправильный логин или пароль";
                throw new Error('Invalid login or password');
            }
            return response.json();
        })
            .then(client => {

                if (client.name==="admin"){
                    window.location.href='admin0.html';
                }else{
                    document.getElementById("message").innerText = "Успешно";
                    sessionStorage.setItem("id", client.id);
                    window.location.href='client0.html';
                }

            })
//             .then(data => {
//                 console.log(data.status.toString())
//                 if(data.status.toString()==="500") {
//                     document.getElementById("message").innerText = "Неправильный логин или пароль";
//                 }
//             })
//             .then(response => response.json())
//             .catch((data) => {
//             })
//             .then(result => {
//                 {
// //                    sessionStorage.setItem("id",result.id);
//
//                    window.location.href = "http://localhost:63342/resourcers/html/client0.html";
//
//
//                 }
//             })
    }

}