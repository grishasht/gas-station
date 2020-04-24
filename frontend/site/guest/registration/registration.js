import axios from "axios";

const createUser = (login) => {
    axios.post('localhost://gas-station/register', login)
        .then(response => {
            const addedUser = response.data;
            console.log(`POST: user is added`, addedUser);
            // append to DOM
            appendToDOM([addedUser]);
        })
        .catch(error => console.error(error));

}

function registerUser() {

    let login = document.getElementById("login").value;

    alert("User login" + login);

    createUser(login);

}
