"use strict";

// returns true if a string contains only letters and spaces
const lettersAndSpaces = (str) => {
    return /^[a-zA-Z ]+$/.test(str);
};
// returns true if a string contains only lower case and upper case letters
const lettersOnly = (str) => {
    return /^[a-zA-Z]+$/.test(str);
};

const validEmailAddr = (str) => {
    return (str.contains("@") && str.contains(".") && !str.contains(' '));
};

const caseWarning = "Please only enter lowercase or uppercase letters";

// watch the search bar for keyboard events
$('#search-bar').keyup((event) => {
    let search = $('#search-bar').val();
    if(!lettersAndSpaces(search) && search !== ""){
        alert(caseWarning);
    }
});

// watch the froms on the register page
$('#register-username').keyup(() => {
   let username = $('#register-username').val();
   if(!lettersOnly(username) && username !== ""){
       alert(caseWarning);
   }
});

// watch the password confirmation text field
$('#register-confirm-password').keyup(() => {
    let originalPass = $('#register-password').val();
    let confirmPass = $('#register-confirm-password').val();
    console.log(`${originalPass} ${confirmPass}`);

    if(confirmPass.length >= originalPass.length){
        if(confirmPass !== originalPass){
            alert("Passwords do not match.");
        }
    }
});