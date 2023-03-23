var cover = document.getElementById("cover");
var book_name = document.getElementById("book_name");
var lend_time = document.getElementById("lend_time");
var borrow_time = document.getElementById("borrow_time");
var comments = document.getElementById("comments");
var introduce = document.querySelector(".introduce");
var book_number = document.getElementById("book_number");
var btn = document.getElementById("btn");
var success_borrow_logo = document.querySelector(".success_borrow_logo");
var main_box2=document.querySelector('.main_box2');
var inputs = main_box2.querySelectorAll("input");
var fail_borrow_logo=document.querySelector('.fail_borrow_logo');
var main_area=document.querySelector('.main_area')
btn.onclick = function () {
    var flag=true;
    if(inputs[0].value!=='' && inputs[1].value!==''){
        flag=true;
    }else{
        flag=false;
    }
    if(flag===true){
        if(book_number.innerHTML > 0){
            success_borrow_logo.style.display = 'block';
            main_area.style.display = 'none';
            book_number--;
        } else {
            fail_borrow_logo.style.display = 'block';
            main_area.style.display = "none";
            success_borrow_logo.style.display = 'none';
        }
    }
    else {
        alert("请完善信息");
    }
}
