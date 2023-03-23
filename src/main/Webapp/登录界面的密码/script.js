const next_step = document.querySelector(".next_step");
const find_password_card = document.querySelector(".find_password_card");
const set_new_password_card = document.querySelector(".set_new_password_card");
const phone_email_number = document.getElementById("phone_email_number")
const check_number_input = document.getElementById("check_number_input")
next_step.onclick = function () {
    if (phone_email_number.value == "" || check_number_input.value == "") {
        alert("请完善信息");
    }
    else {
        find_password_card.style.display = 'none';
        set_new_password_card.style.display = 'block';
    }

}

const set_password_again = document.querySelector(".set_password_again");
const new_number = document.getElementById("new_password");
const set_new_password_again = document.getElementById("set_new_password_again");
set_password_again.onclick = function () {
    if (new_number.value == "" || set_new_password_again.value == "") {
        alert("请完善信息");
    }
    else {
        alert("重置密码成功");
    }
}

//发送验证码倒计时
const send_again = document.querySelector(".send_again");
var time = 60;
send_again.addEventListener("click", function () {
    //console.log("1111");
    send_again.disabled = true;
    var timer = setInterval(function () {
        if (time == 0) {
            clearInterval(timer);
            send_again.disabled = false;
            send_again.innerHTML = "发送验证码";
            time = 60;
        } else {
            send_again.innerHTML = "还剩下" + time + "秒";
            time--;
        }
    }, 1000);
});
