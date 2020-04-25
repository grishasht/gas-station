
const createUser = (login) => {
    axios.post('http://localhost:8080/guest/registration', login)
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
    alert("User signin" + login);

    createUser(login);
}

// document.getElementById("submitRegisterData").addEventListener('click', () => {
//
//     let login = document.getElementById("signin").value;
//     alert("User signin" + login);
//
//     createUser(login);
//
// });
