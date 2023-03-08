// const user_register = document.getElementsByClassName("user_register")[0]
const user_register_copy = document.createElement("div")
user_register_copy.innerHTML = `<div class="user_register_type">
            <div class="phone_register" id="phone_register">手机号注册</div>
            <div class="email_register" id="email_regisiter">邮箱注册</div>
            <div class="phone_register_list_One">
                <div class="phone_register_list" id="phone_register_list">
                    <div class="list_one">
                        <div class="name">
                            <div class="name_msg" >姓名</div>
                            <input type= "text" id= "name">
                        </div>
                        <div class="number">
                            <div class="number_msg" >学号</div>
                            <input type= "text" id= "number">
                        </div>
                    </div>
                    <div class="list_two">
                        <div class="phone">
                            <div class="phone_number" id="phone_Number">电话号码</div>
                            <input type="text" id="phone_number">
                            <button class="phone_get" id="phone_get">获取短信验证码</button>
                        </div>
                        <div class="check_number">
                            <div class="check_number_number">验&ensp;证&ensp;码</div>
                            <input type="text" id="check_number">
                        </div>
                        <button id = "btn01">注册</button>
                    </div>
                </div>
            </div>
            
            <div class="email_register_list_One">
                <div class="email_register_list" id="email_register_list">
                    <div class="list_one">
                        <div class="name">
                            <div class="name_msg" >姓名</div>
                            <input type= "text" id= "name">
                        </div>
                        <div class="number">
                            <div class="number_msg" >学号</div>
                            <input type= "text" id= "number">
                        </div>
                    </div>
                    <div class="list_two">
                        <div class="phone">
                            <div class="email" id="email">邮箱地址</div>
                            <input type="text" id="email_value">
                            <button class="email_get" id="email_get">获取邮箱验证码</button>
                        </div>
                        <div class="check_number">
                            <div class="check_number_number">验&ensp;证&ensp;码</div>
                            <input type="text" id="check_number">
                        </div>
                        <button id = "btn02">注册</button>
                    </div>
                </div>
            </div>
        </div>`

// const moniter = document.getElementsByClassName("moniter")[0]
const moniter_copy = document.createElement("div")
moniter_copy.innerHTML = `
            <div class="gltitle">
                管理员登录
            </div>
            <div class="msg">
                <div class="msg1">
                    <input type="text" placeholder="请输入默认用户名" id = "username"  class = "moniter_input"/>
                </div>
                <div class="msg2">
                    <input type="password" placeholder="请输入默认密码" id = "password"  class = "moniter_input"/>
                </div>
            </div>

            <div class="btn">
                <div class="login" id = "login">安全登录</div>
            </div>
            <div class="exchange">
                <div class="words" id = "change">用户登录</div>
            </div>
        </div>`

// const main = document.getElementsByClassName("user_sing_in")[0]
const main_copy = document.createElement("div")
main_copy.innerHTML = `
<img class="logo" src="https://liangjia.oss-cn-beijing.aliyuncs.com/Rectangle%2011%20(1)(1).png" />
    <div class="title">图书管理系统</div>
    <div class="password">密码登录</div>
    <div class="verification">验证码登录</div>
    <div class="select">
    <div class="select_password"></div>
    <div class="select_verification"></div>
    </div>
    <div class="password_sign_in">
    <div class="input">
        <input type="text" id="input_user" placeholder="请输入手机号或邮箱" />
        <div id="tip"></div>
        <input type="password" id="input_password" placeholder="请输入密码" />
        <img class="input_close" src="https://liangjia.oss-cn-beijing.aliyuncs.com/Rectangle%205.png" />
    </div>
    <div class="check">
        <p><input type="checkbox" />自动登录</p>
        <p><input type="checkbox" />记住密码</p>
        <p style="cursor: pointer">忘记密码</p>
    </div>
    </div>
    <div class="verification_sign_in">
    <div class="input">
        <input type="text" id="input_users" placeholder="请输入手机号" />
        <div id="tip1"></div>
        <input type="text" id="input_passwords" placeholder="请输入短信验证码" />
        <button class="get_verification">获取短信验证码</button>
    </div>
    </div>
    <a class="sign_in" href="#">登录</a>
    <div class="line"></div>
    <p class="other">其他登录方式</p>
    <div class="others_img">
    <img src="https://liangjia.oss-cn-beijing.aliyuncs.com/Ellipse%201.png" />
    <img src="https://liangjia.oss-cn-beijing.aliyuncs.com/Ellipse%202.png" />
    <img src="https://liangjia.oss-cn-beijing.aliyuncs.com/Ellipse%203.png" />
    </div>

    <a class="sign_up" href="#" id="register">立即注册</a>
    <p class="users" id="user_moniter">管理员登录</p>
    ` 


export {
    user_register_copy,
    moniter_copy,
    main_copy
}