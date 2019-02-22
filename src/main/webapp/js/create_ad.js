// the number of categories is fixed
const categoryLen = 169;

const createAdForm = {
    titleId: "#create-title",
    descriptionID: "#create-decription",
    categoriesID: "#create-ad-categories",
    priceID: "#create-price",
};

let categories = [];
// push all of the categories into a list, by selecting them through jquery
for(let i = 1; i < categoryLen; i++){
    categories.push($(`#category-${i}`).text());
}

let categoryIn = "";
let suggestions = [];
// when the user types into the field, recommend options
$(createAdForm.categoriesID).keyup( (event) => {

    suggestions = [];
    categoryIn = $(createAdForm.categoriesID).val();

    if(categoryIn === ""){
        $("#create-category-suggestions").html("");
    }
    else {
        // collect the recommended categories
        categories.forEach( (category) => {
            if(category.startsWith(categoryIn)){
                suggestions.push(`<div>${category}</div>`);
            }
        });
        // construct the html
        let html = "";
        suggestions.forEach( (elem) => {
            html += `<div>${elem}</div>`;
        });
        // write the suggestions to the html
        $("#create-category-suggestions").html(html);
    }

});