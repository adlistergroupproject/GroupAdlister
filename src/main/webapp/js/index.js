"use strict";

console.log("this is the jquery");

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

const emptyTitle = "Please enter a title.";

const emptyDescription = "Please enter a description.";

const emptyPrice = "Please enter a Price. (If the item is free enter 0.00)";

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
$(registerForm.idConfirm).keyup(() => {
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


const editProfileForm = {
    idForm: "#edit-profile-form",
    idUsername: "#updateUsername",
    idEmail: "#updateEmail",
    idSubmit: "#edit-profile-button"
};

// watch the forms on the edit profile page
$(editProfileForm.idUsername).keyup(() => {
    let username = $('#updateUsername').val();
    if (!lettersOnly(username) && username !== "") {
        alert(caseWarning);
    }
});


// watch the submission button for the register form
$(editProfileForm.idSubmit).click( (event) => {
    event.preventDefault();
    console.log("someone pressed the register form button");
    let formVals = {
        username: $(editProfileForm.idUsername).val(),
        email: $(editProfileForm.idEmail).val()
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


//this is all for the change password form:
const changePasswordForm = {
    idForm: "#change-pw-form",
    idPassword: "#password",
    idNewPassword: "#new_password",
    idConfirm: "#confirm_password",
    idSubmit: "#change-password-form-btn"
};

// watch the password confirmation text field
$(changePasswordForm.idConfirm).keyup(() => {
    let originalPass = $(changePasswordForm.idNewPassword).val();
    let confirmPass = $(changePasswordForm.idConfirm).val();
    //console.log(`${originalPass} ${confirmPass}`);

    if(confirmPass.length >= originalPass.length){
        if(confirmPass !== originalPass){
            alert("Passwords do not match.");
        }
    }
});


// watch the submission button for the change password form
$(changePasswordForm.idSubmit).click( (event) => {
    event.preventDefault();

    let formVals = {
        password: $(changePasswordForm.idPassword).val(),
        confirm: $(changePasswordForm.idConfirm).val(),
    };

    if(formVals.password !== formVals.confirm){
        alert("Passwords do not match.");
    } else {
        $(changePasswordForm.idForm).submit();
    }

});

const editAdForm = {
    idForm: "#edit-ad-form",
    idTitle: "#title",
    idPrice: "#price",
    idDescription: "#description",
    idSubmit: "#edit-ad-submit"
};

// watch the title field for an empty title
$(editAdForm.idTitle).keyup(() => {
    let title= $('#title').val();
    if(title === ""){
        alert(emptyTitle);
    }
});

// watch the description field for an empty description
$(editAdForm.idDescription).keyup(() => {
    let description = $('#description').val();
    if(description  === ""){
        alert(emptyDescription);
    }
});

// watch the price field for an empty price
$(editAdForm.idPrice).keyup(() => {
    let price = $('#price').val();
    if(price  === ""){
        alert(emptyPrice);
    }
});

// watch the submission button for the edit ad form
$(editAdForm.idSubmit).click( (event) => {
    event.preventDefault();

    let formVals = {
       title: "#title",
        price: "#price",
        description: "#description"
    };

    if(formVals.title === "" && formVals.description === "" && formVals.price === ""){
        alert("Please fill out all fields of the form.");
    } else {
        $(editAdForm.idForm).submit();
    }

});

