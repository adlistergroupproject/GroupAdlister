"use strict";

// returns true if a string contains only letters and spaces
const lettersOnly = (str) => {
    return /^[a-zA-Z ]+$/.test(str);
};

// watch the search bar for keyboard events
$('#search-bar').keyup((event) => {
    let search = $('#search-bar').val();
    if(!lettersOnly(search) && search !== ""){
        alert("Please enter only lower case or upper case letters.");
    }
});