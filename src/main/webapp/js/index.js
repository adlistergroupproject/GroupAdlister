"use strict";

// returns true if a string contains only letters and spaces
const lettersAndSpaces = (str) => {
    return /^[a-zA-Z ]+$/.test(str);
};
// returns true if a string contains only lower case and upper case letters
const lettersOnly = (str) => {
    return /^[a-zA-Z]+$/.test(str);
};

const isValidEmailAddr = (str) => {
    return (str.includes("@") && str.includes(".") && !str.includes(" "));
};

const caseWarning = "Please only enter lowercase or uppercase letters";

// watch the search bar for keyboard events
$('#search-bar').keyup((event) => {
    let search = $('#search-bar').val();
    if(!lettersAndSpaces(search) && search !== ""){
        alert(caseWarning);
    }
});

const registerForm = {
    idForm: "#register-form",
    idUsername: "#register-username",
    idEmail: "#register-email",
    idPassword: "#register-password",
    idConfirm: "#register-confirm-password",
    idSubmit: "#register-form-btn",
};
// watch the froms on the register page
$(registerForm.idUsername).keyup(() => {
   let username = $('#register-username').val();
   if(!lettersOnly(username) && username !== ""){
       alert(caseWarning);
   }
});
// watch the password confirmation text field
$(registerForm.idComfirm).keyup(() => {
    let originalPass = $(registerForm.idPassword).val();
    let confirmPass = $(registerForm.idConfirm).val();
    //console.log(`${originalPass} ${confirmPass}`);

    if(confirmPass.length >= originalPass.length){
        if(confirmPass !== originalPass){
            alert("Passwords do not match.");
        }
    }
});
// watch the submission button for the register form
$(registerForm.idSubmit).click( (event) => {
    event.preventDefault();

    let formVals = {
        username: $(registerForm.idUsername).val(),
        email: $(registerForm.idEmail).val(),
        password: $(registerForm.idPassword).val(),
        confirm: $(registerForm.idConfirm).val(),
    };

    if(formVals.password !== formVals.confirm){
        alert("Passwords do not match.");
    }
    else if(!isValidEmailAddr(formVals.email)){
        alert(`Invalid email address: ${formVals.email}`);
    }
    else if(!lettersOnly(formVals.username)){
        alert(`Invalid username: ${formVals.username}`);
    } else {
        $(registerForm.idForm).submit();
    }

});



//LEXI TODO:
// -forms: include this at the bottom in all forms
//     <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
//     <script type="text/javascript" src="${pageContext.request.contextPath}/js/index.js"></script>
//THEN customize the last chunk of code on here to listen to each form
//-make a new object for log in and edit and then check those values