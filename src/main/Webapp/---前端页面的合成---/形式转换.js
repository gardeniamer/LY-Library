const users_sing_in = document.getElementsByClassName("users_sing_in")[0]
const user_register = document.getElementsByClassName("user_register")[0]
const moniter = document.getElementsByClassName("moniter")[0]
const password_seek = document.getElementsByClassName("password_seek")[0]
var docCookies = {
    getItem: function (sKey) {
        return decodeURIComponent(document.cookie.replace(new RegExp("(?:(?:^|.*;)\\s*" + encodeURIComponent(sKey).replace(/[-.+*]/g, "\\$&") + "\\s*\\=\\s*([^;]*).*$)|^.*$"), "$1")) || null;
    },
    setItem: function (sKey, sValue, vEnd, sPath, sDomain, bSecure) {
        if (!sKey || /^(?:expires|max\-age|path|domain|secure)$/i.test(sKey)) { return false; }
        var sExpires = "";
        if (vEnd) {
            switch (vEnd.constructor) {
                case Number:
                    sExpires = vEnd === Infinity ? "; expires=Fri, 31 Dec 9999 23:59:59 GMT" : "; max-age=" + vEnd;
                    break;
                case String:
                    sExpires = "; expires=" + vEnd;
                    break;
                case Date:
                    sExpires = "; expires=" + vEnd.toUTCString();
                    break;
            }
        }
        document.cookie = encodeURIComponent(sKey) + "=" + encodeURIComponent(sValue) + sExpires + (sDomain ? "; domain=" + sDomain : "") + (sPath ? "; path=" + sPath : "") + (bSecure ? "; secure" : "");
        return true;
    },
    removeItem: function (sKey, sPath, sDomain) {
        if (!sKey || !this.hasItem(sKey)) { return false; }
        document.cookie = encodeURIComponent(sKey) + "=; expires=Thu, 01 Jan 1970 00:00:00 GMT" + (sDomain ? "; domain=" + sDomain : "") + (sPath ? "; path=" + sPath : "");
        return true;
    },
    hasItem: function (sKey) {
        return (new RegExp("(?:^|;\\s*)" + encodeURIComponent(sKey).replace(/[-.+*]/g, "\\$&") + "\\s*\\=")).test(document.cookie);
    },
    keys: /* optional method: you can safely remove it! */ function () {
        var aKeys = document.cookie.replace(/((?:^|\s*;)[^\=]+)(?=;|$)|^\s*|\s*(?:\=[^;]*)?(?:\1|$)/g, "").split(/\s*(?:\=[^;]*)?;\s*/);
        for (var nIdx = 0; nIdx < aKeys.length; nIdx++) { aKeys[nIdx] = decodeURIComponent(aKeys[nIdx]); }
        return aKeys;
    }
};

const all = `<div class="decoration">
        <div class="ly"></div>
        <div class="sum">图书管理系统</div>
    </div>`


import * as foo from "./辅助形式转换.js"

users_moniter_config()
user_moniter_config()
password_seek_()

//忘记密码的页面切换
function password_seek_() {
    password_seek.addEventListener("click", () => {
        location.replace("./index.html")
    })
}

function user_moniter_config() {

    //实现页面转换于同一个URL下
    register.addEventListener("click", () => {
        users_sing_in.classList.replace("users_sing_in", "user_register")
        users_sing_in.innerHTML = foo.user_register_copy.innerHTML
        users_sing_in.insertAdjacentHTML("beforebegin", `${all}`)
        register_config()
    })

    user_moniter.addEventListener("click", () => {
        users_sing_in.classList.replace("users_sing_in", "moniter")
        users_sing_in.innerHTML = foo.moniter_copy.innerHTML
        users_sing_in.insertAdjacentHTML("beforebegin", `${all}`)
        moniter_config()
    })
}

function users_moniter_config() {
    //获取形式转变的前提变量
    const register = document.getElementById("register")
    const user_moniter = document.getElementById("user_moniter")

    // 密码和验证码登录的切换
    var password_sign_in = document.querySelector(".password_sign_in");
    var verification = document.querySelector(".verification");
    var password = document.querySelector(".password");
    var verification_sign_in = document.querySelector(".verification_sign_in");
    var spwd = document.querySelector(".select_password ");
    var svft = document.querySelector(".select_verification");
    let judge2 = false;

    // axios({
    //   method: "get",
    //   url: "http://202.182.125.24:29508/Manager/login"
    // })
    //   .then((result) => {
    //   console.log(result.data);
    //   })
    //   .catch((err) => {
    //   console.log(err);
    // })

    verification.onclick = function () {
        spwd.style.backgroundColor = "rgba(0, 0, 0, 0)";
        svft.style.backgroundColor = "#006eff";
        password_sign_in.style.display = "none";
        verification_sign_in.style.display = "block";
        verification.style.color = "#3b3b3b";
        password.style.color = "#636363";
        judge2 = true;

    };
    password.onclick = function () {
        spwd.style.backgroundColor = "#006eff";
        svft.style.backgroundColor = "rgba(0, 0, 0, 0)";
        password_sign_in.style.display = "block";
        verification_sign_in.style.display = "none";
        verification.style.color = "#636363";
        password.style.color = "#3b3b3b";
        judge2 = false;
    };
    // 密码登录框的内容是否隐藏
    var close = document.querySelector(".input_close");
    var pwd = document.querySelector("#input_password");
    let flag = 0;
    close.onclick = function () {
        if (flag == 0) {
            pwd.type = "text";
            close.src =
                "https://liangjia.oss-cn-beijing.aliyuncs.com/Rectangle%206.png";
            flag = 1;
        } else {
            pwd.type = "password";
            close.src =
                "https://liangjia.oss-cn-beijing.aliyuncs.com/Rectangle%205.png";
            flag = 0;
        }
    };
    // 获取验证码的倒计时
    var get = document.querySelector(".get_verification");
    var time = 60;
    get.addEventListener("click", function () {
        get.disabled = true;
        var timer = setInterval(function () {
            if (time == 0) {
                clearInterval(timer);
                get.disabled = false;
                get.innerHTML = "获取短信验证码";
                time = 60;
            } else {
                get.innerHTML = "还剩下" + time + "秒";
                time--;
            }
        }, 1000);
    });
    // 密码登录部分是否合格
    var tip = document.querySelector("#tip");
    var signIn = document.querySelector(".sign_in");
    var inputUser = document.querySelector("#input_user");
    const check_box = document.getElementsByClassName("check_box")[0]
    if (docCookies.getItem("users") != undefined) {
        inputUser.value = docCookies.getItem("users")
    }
    if (docCookies.getItem("users_password") != undefined) {
        check_box.checked = true
        pwd.value = docCookies.getItem("users_password")
    }
    let judge = false;
    inputUser.onblur = function () {
        let email = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
        let number =
            /^(13[0-9]|14[01456879]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])\d{8}$/;
        if (email.test(this.value) || number.test(this.value)) {
            tip.innerHTML = "";
            judge = true;
        } else if (this.value !== "") {
            tip.innerHTML = "输入格式错误，请重新输入";
            judge = false;
        } else {
            tip.innerHTML = "";
            judge = false;
        }
    };
    // 验证码登录部分是否合格
    var inputUsers = document.querySelector("#input_users");
    console.log(inputUsers);
    var tip1 = document.querySelector("#tip1");
    let judge1 = false;
    inputUsers.onblur = function () {
        let number =
            /^(13[0-9]|14[01456879]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])\d{8}$/;
        if (number.test(this.value)) {
            tip1.innerHTML = "";
            judge1 = true;
        } else if (this.value !== "") {
            tip1.innerHTML = "输入格式错误，请重新输入";
            judge1 = false;
        } else {
            tip1.innerHTML = "";
            judge1 = false;
        }
    };
    var pwds = document.querySelector("#input_passwords");
    signIn.onclick = function () {
        if (judge2 === false) {
            if (judge === false) {
                alert("请完善信息！");
            } else if (pwd.value !== "") {
                alert("登陆成功");
                docCookies.setItem("users", `${inputUser.value}`, "86400")
                if (check_box.checked == true) {
                    docCookies.setItem("users_password", `${pwd.value}`, "86400")
                }
                // docCookies.removeItem("users")
                // docCookies.removeItem("users_password")
                location.replace("./用户端主页面.html")
            } else {
                alert("请完善信息！");
            }
        } else {
            if (judge1 === false) {
                alert("请完善信息！");
            } else if (pwds.value !== "") {
                alert("登陆成功");
                location.replace("./用户端主页面.html")
            } else {
                alert("请完善信息！");
            }
        }

    };
}

function moniter_config() {
    const exchange = document.getElementsByClassName("exchange")[0]
    exchange.addEventListener("click", () => {
        const decoration = document.getElementsByClassName("decoration")[0]
        users_sing_in.classList.replace("moniter", "users_sing_in")
        users_sing_in.innerHTML = foo.main_copy.innerHTML
        decoration.remove()
        users_moniter_config()
        user_moniter_config()
    })

    const username = document.getElementById("username")
    const Password = document.getElementById("password")
    const login = document.getElementById("login")
    login.addEventListener("click", () => {
        if (username.value == "") {
            alert("请输入默认用户名ヾ(≧へ≦)〃")
        }
        else {
            if (Password.value == "") {
                alert("请输入默认密码ヾ(≧へ≦)〃")
            }
            else {
                const default_name = /^admin$/
                const default_pass = /^123456$/
                //依靠正则判断管理员用户名与密码是否符合
                if (default_name.test(username.value) && default_pass.test(Password.value)) {
                    docCookies.setItem("default_name", "admin","3")
                    docCookies.setItem("default_pass", "123456", "3")
                    alert("登陆成功,欢迎回家。")
                    if (docCookies.getItem("default_name") != undefined && docCookies.getItem("default_pass") != undefined) {
                        location.replace("./管理员页面.html")
                    }
                }
                else {
                    alert("请输入正确的默认格式(可以再看看所获邀请码哦)(⊙﹏⊙)")
                    username.value = ""
                    Password.value = ""
                }
            }
        }
    })
}

function register_config() {
    var email_register = document.querySelector('.email_register');
    var phone_register = document.getElementById('phone_register');
    var email_register_list = document.querySelector('.email_register_list_One');
    var phone_register_list = document.querySelector('.phone_register_list_One');


    var phone_Number = document.getElementById('phone_Number');
    var email_get = document.getElementById('email_get');
    var phone_get = document.getElementById('phone_get');

    //实现两种方式的互换
    email_register.onclick = function () {
        this.className = 'email_register_change';
        phone_register.className = 'phone_register_change';
        email_register_list.style.display = 'block';
        phone_register_list.style.display = 'none';
    }

    phone_register.onclick = function () {
        this.className = 'phone_register';
        email_register.className = 'email_register';
        email_register_list.style.display = "none";
        phone_register_list.style.display = "block";
    }

    //验证邮箱是否合法
    var email_value = document.getElementById('email_value');
    email_value.onblur = function () {
        var reg = /^([a-zA-Z]|[0-9])(\w|\-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/;
        if (!reg.test(email_value.value)) {
            alert("请重新输入邮箱地址");
        }
    }
    // 验证手机号是否合法
    var phone_number = document.getElementById('phone_number');
    phone_number.onblur = function () {
        var reg = /^[1][3,4,5,7,8][0-9]{9}$/;
        if (!reg.test(phone_number.value)) {
            alert("请重新输入手机号");

        }

        var btn01 = document.getElementById("btn01");
        var btn02 = document.getElementById("btn02")
        var inputs = document.querySelectorAll('input');

        btn01.addEventListener("click", () => {
            finish()
        })
        btn02.addEventListener("click", () => {
            finish()
        })

        function finish() {
            let n = 0;
            for (let i = 0; i < 5; i++) {
                if (inputs[i].value == "") {
                    n++;
                }
            }
            if (n == 0) {
                alert("注册成功");
                const decoration = document.getElementsByClassName("decoration")[0]
                decoration.remove()
                users_sing_in.classList.replace("user_register", "users_sing_in")
                users_sing_in.innerHTML = foo.main_copy.innerHTML
                users_moniter_config()
                user_moniter_config()
            }
            else {
                alert("请完善信息");
            }
        }

    }
}
