var person = document.querySelector(".person");
var Return = document.querySelector(".return1");
var borrowing = document.querySelector(".borrowing");
var person_content = document.querySelector(".person_content");
var borrowing_content = document.querySelector(".borrowing_content");
var already_return_content = document.querySelector(".already_return_content");

person.onclick = function () {
    person.style.color = "blue";
    Return.style.color = "black";
    borrowing.style.color = "black";
    person_content.style.display = "block";
    already_return_content.style.display = "none";
    borrowing_content.style.display = "none";

}

Return.onclick = function () {
    person.style.color = "black";
    Return.style.color = "blue";
    borrowing.style.color = "black";
    person_content.style.display = "none";
    already_return_content.style.display = "block";
    borrowing_content.style.display = "none";

}

borrowing.onclick = function () {
    person.style.color = "black";
    Return.style.color = "black";
    borrowing.style.color = "blue";
    person_content.style.display = "none";
    already_return_content.style.display = "none";
    borrowing_content.style.display = "block";


}