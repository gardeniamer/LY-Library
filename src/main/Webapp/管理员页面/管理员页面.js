const main = document.getElementsByClassName("main")[0]
const modify = document.getElementsByClassName("modify")[0]
const seek = document.getElementsByClassName("seek")[0]
const examine = document.getElementsByClassName("examine")[0]
const EXport = document.getElementsByClassName("EXport")[0]
const more_unavailable = document.getElementsByClassName("more_unavailable")[0]
const background = document.getElementsByClassName("background")[0]
const main_all = document.getElementsByClassName("main_all")[0]
const Export_more = document.getElementsByClassName("Export_more")[0]
const ul_load = document.createElement("ul")
ul_load.className = "main_02"
const add_load = `<div>
                        <div></div>
                    </div>`
for (let i = 0; i < 3; i++) {
    const div_load = document.createElement("div")
    div_load.insertAdjacentHTML("beforeend", `${add_load}`)
    ul_load.appendChild(div_load)
}

main.append(ul_load)
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
//依据cookie来判断用户是否为恶意用户，防止管理员端数据丢失
if (docCookies.getItem("default_name") != undefined && docCookies.getItem("default_pass") == undefined) {
    location.replace("./警告.html")
}

let arr_show = ['url("https://roninz.oss-cn-beijing.aliyuncs.com/Rectangle 33 (1).png")', 'url("https://roninz.oss-cn-beijing.aliyuncs.com/Rectangle 34 (1).png")', 'url("https://roninz.oss-cn-beijing.aliyuncs.com/Rectangle 35.png")']
let brr_show = ["《傲慢与偏见》 数量：5", "《呼啸山庄》  数量：5", "《瓦尔登湖》  数量：5"]

// axios.interceptors.request.use(() => {

// })
// axios.interceptors.response.use(() => {

//     })

let instance = axios.create({
    baseURL: "http://202.182.125.24:41348/LYlibrary/presentAllBooks-servlet",
    timeout: 6000
})
let instance2 = axios.create({
    baseURL: 'http://202.182.125.24:41348/LYlibrary/borrowerAllRecord-servlet',
    timeout: 6000
})

var scrollTop = document.documentElement.scrollTop

const more_new = `<div class="bg_pic_more"><div class="add">
<div class="tb"></div>
</div></div>`

import * as foo from "./辅助页面转换.js"

modify_config()
date_realize()


//导航栏以及书籍的展示方式
window.addEventListener("scroll", () => {

    scrollTop = document.documentElement.scrollTop
    const uls = document.getElementsByTagName("ul")
    var ulsCount = 0

    if (scrollTop >= 440) {
        bottom_down()
    }
    if (scrollTop < 440) {
        bottom_up()
    }
    if (scrollTop > 550) {
        if (background.nextElementSibling.firstElementChild.className == "main") {
            for (let vol of uls) {
                ulsCount++
                if (ulsCount == 1) {
                    continue
                }
                else {
                    vol.style.opacity = "1"
                    if (vol.children.length > 1 && vol.previousElementSibling.firstElementChild.firstElementChild.firstElementChild.className
                        == "circle") {
                        var arr_count = 0
                        Array.from(vol.children).forEach((m) => {
                            m.className = "pic"
                            m.style.backgroundImage = `${arr_show[arr_count]}`
                            m.firstElementChild.className = "bg_pic"
                            m.firstElementChild.firstElementChild.className = "circle"
                            m.firstElementChild.firstElementChild.textContent = "修改"
                            arr_count++
                        });
                    }
                    if (vol.children.length > 1 && vol.previousElementSibling.firstElementChild.firstElementChild.firstElementChild.className
                        == "circle_copy") {
                        var arr_count = 0
                        Array.from(vol.children).forEach((m) => {
                            m.className = "pic"
                            m.style.backgroundImage = `${arr_show[arr_count]}`
                            m.firstElementChild.className = "bg_pic"
                            m.firstElementChild.firstElementChild.className = "circle_copy"
                            m.firstElementChild.firstElementChild.innerHTML = `<div class = 'del'></div>`
                            arr_count++
                        });
                    }

                }
            }
        }
        if (background.nextElementSibling.firstElementChild.className == "main_seek") {
            for (let vol of uls) {
                ulsCount++
                if (ulsCount == 1) {
                    continue
                }
                else {
                    var arr_count = 0
                    vol.style.opacity = "1"
                    Array.from(vol.children).forEach((m) => {
                        m.className = "pic"
                        m.style.backgroundImage = `${arr_show[arr_count]}`
                        m.firstElementChild.className = "pic_word"
                        m.firstElementChild.firstElementChild.className = "pic_word_count"
                        m.firstElementChild.firstElementChild.textContent = `${brr_show[arr_count]}`
                        arr_count++
                    });

                }
            }
        }
    }


    else {
        if (background.nextElementSibling.firstElementChild.className == "main" || background.nextElementSibling.firstElementChild.className == "main_seek") {
            for (let vol of uls) {
                ulsCount++
                if (ulsCount == 1) {
                    continue
                }
                else {
                    vol.style.opacity = "0"
                }
            }
        }
    }



})


//图书内容修改
function modify_config() {

    const circles = document.getElementsByClassName("circle")
    for (let vol of circles) {
        vol.addEventListener("click", () => {

            main.classList = "main_modify"
            main.innerHTML = foo.main_modify_copy.innerHTML
            const more_content = document.getElementById("more_content")
            const modify_content = document.getElementsByClassName("modify_content")[0]
            const input_modifys = document.getElementsByClassName("input_modify")
            const textarea_modify = document.getElementsByClassName("textarea_modify")[0]
            document.getElementById("modify_introduce").value = "..."
            instance({
                method: 'get',
            }).then((res) => {
                console.log(res.data.data);
                input_modifys[0].value = res.data.data[5].bookname
                input_modifys[1].value = res.data.data[5].writer
                input_modifys[2].value = res.data.data[5].classification
                input_modifys[3].value = res.data.data[5].number
                input_modifys[4].value = res.data.data[5].publishing_house
                textarea_modify.value = res.data.data[5].introduction
            }).catch((err) => {
                console.log("出错了！！！", err);
            })
            const modify_btn = document.getElementsByClassName("modify_btn")[0]
            modify_btn.addEventListener("click", () => {
                alert("修改成功...")

                axios({
                    method: 'post',
                    url: 'http://202.182.125.24:41348/LYlibrary/update',
                    data: {
                        updateBookname: `${input_modifys[0].value}`,
                        classification: `${input_modifys[2].value}`,
                        introduction: `${textarea_modify.value}`,
                        number: `${input_modifys[3].value}`,
                        publishing_house: `${input_modifys[4].value}`,
                        writer: `${input_modifys[1].value}`,
                    }
                }).then((res) => { })
                    .catch((err) => {
                        console.log("出错了！！", err);
                    })

                main.classList = "main"
                main.innerHTML = foo.main_copy.innerHTML
                modify_config()
            })
        })
    }

    add_del()
    seek_config()
    examine_config()
    EXport_config()

}


//图书查询功能
function seek_config() {

    seek.addEventListener("click", () => {
        Export_more.style.display = "none"
        main.classList = "main_seek"
        main.innerHTML = foo.main_seek_copy.innerHTML
        seek.style.borderBottom = "2px solid white"
        examine.style.borderBottom = "none"
        modify.style.borderBottom = "none"
        EXport.style.borderBottom = "none"
        const seek_bord = document.getElementsByClassName("seek_bord")[0]
        const seek_decoration = document.getElementsByClassName("seek_decoration")[0]
        seek_decoration.addEventListener("click", () => {
            if (seek_bord.value == "") {
                seek_bord.placeholder = "请输入要查询的书籍。。。"
            }
            else {
                instance({
                    method: 'get',
                }).then((res) => {
                    console.log(res.data.data);
                    for (let vol of res.data.data) {
                        if (vol.bookname == seek_bord.value) {

                        }
                    }
                }).catch((err) => {
                    console.log("出错了！！！", err);
                })
            }

        })

        modify_config()

    })
}

//图书审批功能
function examine_config() {

    examine.addEventListener("click", () => {
        Export_more.style.display = "none"
        main.classList = "main_examine"
        main.innerHTML = foo.main_examine_copy.innerHTML
        seek.style.borderBottom = "none"
        examine.style.borderBottom = "2px solid white"
        modify.style.borderBottom = "none"
        EXport.style.borderBottom = "none"
        const borrow_users = document.getElementsByClassName("borrow_user")
        const examine_user_main = document.getElementsByClassName("examine_user_main")[0]
        for (let vol of borrow_users) {
            vol.addEventListener("mouseover", () => {
                examine_user_main.style.opacity = "1"
            })
            vol.addEventListener("mouseout", () => {
                examine_user_main.style.opacity = "0"
            })
        }
        const examine_realize = document.getElementsByClassName("examine_realize")[0]
        const examine_realize_copy = document.getElementsByClassName("examine_realize_copy")[0]
        const examine_detail = document.getElementsByClassName("examine_detail")[0]
        let examine_detail_number = examine_detail.children.length
        instance2({
            method: 'get',
        }).then((res) => {
            examine_realize_copy.textContent = res.data.data.length
            examine_realize.textContent = res.data.data.length
            if (examine_detail.children.length != res.data.data.length) {
                for (let i = examine_detail.children.length; i < res.data.data.length; i++) {
                    const div = document.createElement("div")
                    div.className = "msg"
                    div.innerHTML = `<div class="msg02_left"></div>
                    <div class="msg_right">
                        <div class="left">
                            <div class="name">
                                书名：《摆渡人》
                            </div>
                            <div class="borrow_count">
                                借阅数量：1
                            </div>
                            <div class="remain">

                            </div>
                            <div class="borrow_time">
                            </div>
                        </div>
                        <div class="right">
                            <div class="borrow_user">
                                借阅者：小云云
                            </div>
                            <div class="accept">同意</div>
                            <div class="refuse">拒绝</div>
                        </div>
                    </div>`
                    examine_detail.append(div)
                }
            }
        })
        //审批数量的自动校正
        setInterval(() => {
            if (examine_detail.children.length != examine_detail_number) {
                examine_detail_number = examine_detail.children.length
                instance2({
                    method: 'get',
                }).then((res) => {
                    examine_realize_copy.textContent = res.data.data.length
                    examine_realize.textContent = res.data.data.length
                })
            }
        }, 2000);
        const examine_borrow = document.getElementsByClassName("examine_borrow")[0]
        const examine_return = document.getElementsByClassName("examine_return")[0]
        const remains = document.getElementsByClassName("remain")
        const borrow_times = document.getElementsByClassName("borrow_time")
        instance({
            method: 'get'
        }).then((res) => {
            for (let vol of remains) {
                vol.textContent = "剩余数量：" + `${res.data.data[1].number}`
            }
        })
        instance2({
            method: 'get',
        }).then((res) => {
            for (let vol of borrow_times) {
                vol.textContent = "借阅时间：" + `${res.data.data[0].borrow_Date}`
            }
        })
        examine_borrow.addEventListener("click", () => {
            examine_borrow.style.color = "cornflowerblue"
            examine_return.style.color = "#838383"
            instance({
                method: 'get'
            }).then((res) => {
                for (let vol of remains) {
                    vol.textContent = "剩余数量：" + `${res.data.data[1].number}`
                }
            })
            instance2({
                method: 'get',
            }).then((res) => {
                for (let vol of borrow_times) {
                    vol.textContent = "借阅时间：" + `${res.data.data[0].borrow_Date}`
                }
            })
        })
        examine_return.addEventListener("click", () => {
            examine_return.style.color = "cornflowerblue"
            examine_borrow.style.color = "#838383"
            instance2({
                method: 'get',
            }).then((res) => {
                for (let vol of remains) {
                    vol.textContent = "借阅时间：" + `${res.data.data[0].borrow_Date}`
                }
            })
            instance({
                method: 'get'
            }).then((res) => {
                for (let vol of borrow_times) {
                    vol.textContent = "剩余数量：" + `${res.data.data[1].number}`
                }
            })

        })
        const accepts = document.getElementsByClassName("accept")
        const refuses = document.getElementsByClassName("refuse")
        const refuse_more = document.getElementsByClassName("refuse_more")[0]
        const submit = document.getElementById("submit")

        for (let vol of accepts) {
            console.log(vol);
            vol.addEventListener("click", () => {

                alert("操作成功。。")
                vol.parentElement.parentElement.parentElement.remove()
            })

        }

        for (let vol of refuses) {
            let n

            vol.addEventListener("click", () => {
                refuse_more.style.opacity = "1"
                submit.addEventListener("click", () => {
                    if (submit.previousElementSibling.value != "") {
                        alert("操作成功。。。")
                        console.log(vol.previousElementSibling);
                        vol.previousElementSibling.parentElement.parentElement.parentElement.remove()
                        submit.previousElementSibling.value = ""
                        refuse_more.style.opacity = "0"
                    }
                    else {
                        submit.previousElementSibling.placeholder = "请输入拒绝的理由。。。。。"
                    }
                })

            })

            vol.addEventListener("dblclick", () => {
                refuse_more.style.opacity = "0"
            })
            n++
        }
        modify_config()

    })
}

//图书的添加与删除
function add_del() {

    if (main.className === "main") {
        //图书数量修改
        const change = document.getElementsByClassName("change")[0]
        const bg_pics = document.getElementsByClassName("bg_pic")

        change.addEventListener("dblclick", () => {
            for (let vol of bg_pics) {
                vol.innerHTML = "<div class='circle'>修改</div>"
            }
            const uls = document.getElementsByTagName("ul")
            if (uls[uls.length - 1].firstElementChild.style.backgroundImage == "") {
                uls[uls.length - 1].innerHTML = ""
            }

            modify_config()
        })

        change.addEventListener("click", () => {
            const bg_pics = document.getElementsByClassName("bg_pic")
            for (let vol of bg_pics) {
                vol.innerHTML = "<div class = 'circle_copy'><div class = 'del' > </div ></div> "
            }
            more_add()
            const tb = document.getElementsByClassName("tb")[0]
            const dels = document.getElementsByClassName("circle_copy")
            tb.addEventListener("click", () => {
                main.classList = "main_add"
                main.innerHTML = foo.main_add_copy.innerHTML
                const camera_look = document.getElementsByClassName("camera_look")[0]
                const textarea = document.getElementsByTagName("textarea")[0]
                camera_look.addEventListener("click", () => {

                })

                const finish_btn = document.getElementsByClassName("finish_btn")[0]
                finish_btn.addEventListener("click", () => {
                    const input_add = document.getElementsByClassName("input_add")
                    const tip = document.getElementsByClassName("tip")
                    let n = -1
                    let m = 0
                    for (let vol of input_add) {
                        n++
                        if (vol.value == "") {
                            tip[n].innerHTML = "请输入此处内容ヾ(≧へ≦)〃"
                            tip[n].style.color = "red"
                            break;
                        }
                        else {
                            tip[n].innerHTML = ""
                            if (textarea.value == "") {
                                textarea.placeholder = "这本书还没有一个简介嘛？Σ(っ °Д °;)っ"
                            }
                            else {
                                textarea.placeholder = ""
                                m = 1
                            }
                        }
                    }
                    if (m == 1) {
                        alert("书籍添加成功...")
                        const input_adds = document.getElementsByClassName("input_add")
                        instance({
                            method: 'post',
                            data: {
                                bookname: `${input_adds[0].value}`,
                                classificaton: `${input_adds[1].value}`,
                                writer: `${input_adds[2].value}`,
                                number: `${input_adds[3].value}`,
                                publishing_house: `${input_adds[4].value}`,
                                introduction: `${textarea.value}`
                            }
                        }).then((res) => {

                        }).catch((err) => {
                            console.log("出错了！", err);
                        })
                        instance({
                            method: 'get',
                        }).then((res) => {
                            const li = document.createElement("li")
                            li.style.backgroundImage = res.data.data[res.data.data.length - 1].background
                            main.classList = "main"
                            main.innerHTML = foo.main_copy.innerHTML
                            main.appendChild(li)
                        })


                        modify_config()
                    }
                })
            })
            for (let vol of dels) {
                vol.addEventListener("click", () => {
                    alert("删除成功。。。")
                    vol.parentElement.parentElement.remove()
                    const uls = document.getElementsByTagName("ul")

                    let p = -1
                    for (let vol of uls) {
                        ++p
                        if (vol.children.length < 3) {
                            give(p)
                        }
                    }
                })
            }

        })
    }

}

//图书清单展示

function EXport_config() {
    EXport.addEventListener("click", () => {
        main.classList = "main_export"
        main.innerHTML = foo.main_export_copy.innerHTML
        seek.style.borderBottom = "none"
        examine.style.borderBottom = "none"
        modify.style.borderBottom = "none"
        EXport.style.borderBottom = "2px solid white"
        Export_more.style.display = "block"
        const export_choice_all = document.getElementsByClassName("export_choice_all")[0]
        const export_books_choice = document.getElementsByClassName("export_books_choice")[0]
        const export_users = document.getElementsByClassName("export_users")[0]
        const export_borrowers = document.getElementsByClassName("export_borrowers")[0]
        const export_name = document.getElementsByClassName("export_name")[0]
        const main_export_most = document.getElementsByClassName("main_export_most")[0]
        const export_summary = document.getElementsByClassName("export_summary")[0]
        var options = document.getElementsByTagName("option")
        const book_authors = document.getElementsByClassName("book_author")
        const book_countrys = document.getElementsByClassName("book_country")
        const book_counts = document.getElementsByClassName("book_count")
        const book_scores = document.getElementsByClassName("book_score")
        const summary_score = document.getElementsByClassName("summary_score")[0]
        const book_indexs = document.getElementsByClassName("book_index")
        const book_names = document.getElementsByClassName("book_name")
        const books = document.getElementsByClassName("book")
        const export_books = document.getElementsByClassName("export_books")[0]
        for (let vol of books) {
            vol.innerHTML = `
                    <div class="book_index">
                    </div>                
                    <div class="book_name">
                    </div>
                    <div class="book_author">
                    </div>
                    <div class="book_country">
                    </div>
                    <div class="book_count">
                    </div>
                    <div class="book_score">
                    </div>
                    `
        }


        export_books_choice.addEventListener("click", () => {
            Export_more.style.transform = "translate(135px,-42px) rotate(45deg)"
            export_choice_all.style.display = "none"
            let j = -1
            let k = -1
            let g = 0
            let f1 = 0, f2 = 0, f3 = 0, f4 = 0, f5 = 0, f = 1
            for (let vol of book_scores) {
                vol.style.transform = "translateX(10px)"
            }
            summary_score.style.transform = "translateX(0px)"
            for (let vol of book_indexs) {
                vol.style.transform = "translateX(-25px)"
            }
            for (let vol of book_names) {
                vol.style.transform = "translateX(-11px)"
            }
            export_name.textContent = "Books"
            main_export_most.style.display = "block"
            let export_books_special = main_export_most.firstElementChild.nextElementSibling
            let brr = ["序列", "书名", "作者", "出版社", "剩余数量", "类型"]
            export_books_special.children[1].textContent
            for (let vol of export_books_special.children) {
                vol.textContent = brr[g]
                g++
            }
            // let hrr = [book_names, book_authors, book_countrys, book_counts, book_scores]
            const books = document.getElementsByClassName("book")
            let crr01 = [], crr02 = [], crr03 = [], crr04 = [], crr05 = []
            instance({
                method: 'get',
            }).then((res) => {
                console.log(res.data.data);
                for (let vol of res.data.data) {
                    crr01.push(vol.bookname)
                    crr02.push(vol.writer)
                    crr03.push(vol.publishing_house)
                    crr04.push(vol.number)
                    crr05.push(vol.classification)
                }
                if (res.data.data.length != (export_books.children.length + 1) / 2) {
                    for (let i = (export_books.children.length + 1) / 2; i < res.data.data.length; i++) {
                        export_books.insertAdjacentHTML("beforeend", `                <div class="book_more"></div>
                <div class="book"></div> `)
                    }

                }
                for (let vol of book_names) {
                    vol.textContent = crr01[f1]
                    f1++
                }
                for (let vol of book_authors) {
                    vol.textContent = crr02[f2]
                    f2++
                }
                for (let vol of book_countrys) {
                    vol.textContent = crr03[f3]
                    f3++
                }
                for (let vol of book_counts) {
                    vol.textContent = crr04[f4]
                    f4++
                }
                for (let vol of book_scores) {
                    vol.textContent = crr05[f5]
                    f5++
                }
                for (let vol of book_indexs) {
                    vol.textContent = f
                    f++
                    if (f > res.data.data.length) {
                        break
                    }
                }
            }).catch((err) => {
                console.log("出错了！", err);
            })

            // for (let vol of books[0].children) {
            //     vol.textContent = crr[f]
            //     f++
            // }
            if (export_books_special.children.length > 6) {
                for (let vol of export_books_special.children) {
                    j++
                    if (j >= 6) {
                        vol.remove()
                    }
                }
            }
            if (books[0].children.length > 6) {
                for (let vol of books[0].children) {
                    k++
                    if (k >= 6) {
                        vol.remove()
                    }
                }
            }
            let arr = ["三体", "摆渡人", "红与黑", "傲慢与偏见", "呼啸山庄", "瓦尔登湖"]
            options = arr
        })

        export_users.addEventListener("click", () => {
            Export_more.style.transform = "translate(135px,-42px) rotate(45deg)"
            export_choice_all.style.display = "none"
            let j = -1
            let k = -1
            let g = 0
            let f1 = 0, f2 = 0, f3 = 0, f4 = 0, f5 = 0, f6 = 0, f = 1
            main_export_most.style.display = "block"
            for (let vol of book_countrys) {
                vol.style.transform = "translateX(-12px)";
            }
            for (let vol of book_scores) {
                vol.style.transform = "translateX(3px)"
            }
            for (let vol of book_indexs) {
                vol.style.transform = "translateX(-12px)"
            }
            for (let vol of book_names) {
                vol.style.transform = "translateX(-3px)"
            }
            summary_score.style.transform = "translateX(0px)"
            export_name.textContent = "Users"
            let export_user_special = main_export_most.firstElementChild.nextElementSibling
            let brr = ["序列", "方向", "邮箱", "名字", "密码", "期数"]
            for (let vol of export_user_special.children) {
                vol.textContent = brr[g]
                g++
            }
            const books = document.getElementsByClassName("book")
            let crr01 = [], crr02 = [], crr03 = [], crr04 = [], crr05 = [], crr06 = []

            if (export_user_special.children.length > 6) {
                for (let vol of export_user_special.children) {
                    j++
                    if (j >= 6) {
                        vol.remove()
                    }
                }
            }
            if (books[0].children.length > 6) {
                for (let vol of books[0].children) {
                    k++
                    if (k >= 6) {
                        vol.remove()
                    }
                }
            }
            for (let vol of options) {
                vol.value = "小云云"
            }
            if (export_summary.lastElementChild.className != "summary_more") {
                const div = document.createElement("div")
                div.className = "summary_more"
                div.textContent = "学号"
                export_summary.append(div)
            }
            for (let vol of books) {
                if (vol.lastElementChild.className != "book_more_msg") {
                    const div4 = document.createElement("div")
                    div4.className = "book_more_msg01"
                    vol.append(div4)
                }
            }
            const book_more_msg_return = document.getElementsByClassName("book_more_msg01")
            axios({
                method: 'get',
                url: 'http://202.182.125.24:41348/LYlibrary/showUsers-servlet'
            }).then((res) => {
                console.log(res.data.data);
                for (let vol of res.data.data) {
                    crr01.push(vol.direction)
                    crr02.push(vol.email)
                    crr03.push(vol.name)
                    crr04.push(vol.password)
                    crr05.push(vol.period)
                    crr06.push(vol.student_ID)
                }
                if (res.data.data.length != (export_books.children.length + 1) / 2) {
                    for (let i = (export_books.children.length + 1) / 2; i < res.data.data.length; i++) {
                        export_books.insertAdjacentHTML("beforeend", `                <div class="book_more"></div>
                <div class="book"></div> `)
                    }

                }
                for (let vol of book_names) {
                    vol.textContent = crr01[f1]
                    f1++
                }
                for (let vol of book_authors) {
                    vol.textContent = crr02[f2]
                    f2++
                }
                for (let vol of book_countrys) {
                    vol.textContent = crr03[f3]
                    f3++
                }
                for (let vol of book_counts) {
                    vol.textContent = crr04[f4]
                    f4++
                }
                for (let vol of book_scores) {
                    vol.textContent = crr05[f5]
                    f5++
                }
                for (let vol of book_more_msg_return) {
                    vol.textContent = crr06[f6]
                    f6++
                }
                for (let vol of book_indexs) {
                    vol.textContent = f
                    f++
                    if (f > res.data.data.length) {
                        break
                    }
                }
            })
        })

        export_borrowers.addEventListener("click", () => {
            let g = 0
            let f1 = 0, f2 = 0, f3 = 0, f4 = 0, f5 = 0, f6 = 0, f7 = 0, f = 1, f8 = 0
            Export_more.style.transform = "translate(135px,-42px) rotate(45deg)"
            export_choice_all.style.display = "none"
            main_export_most.style.display = "block"
            export_summary.style.fontSize = "15px"
            export_name.textContent = "Borrowers"
            summary_score.style.transform = "translateX(0px)"
            for (let vol of book_scores) {
                vol.style.transform = "translateX(0px)"
            }
            for (let vol of book_indexs) {
                vol.style.transform = "translateX(0px)"
            }
            for (let vol of book_names) {
                vol.style.transform = "translateX(0px)"
            }
            let export_borrow_special = main_export_most.firstElementChild.nextElementSibling
            let brr = ["序列", "名字", "书籍", "是否审核", "审核是否通过", "借书日期"]
            for (let vol of export_borrow_special.children) {
                vol.textContent = brr[g]
                g++
            }
            if (export_summary.lastElementChild.className != "summary_more") {
                const div = document.createElement("div")
                div.className = "summary_more"
                div.textContent = "还书日期"
                const div2 = document.createElement("div")
                div2.className = "summary_more"
                div2.textContent = "是否还书"
                const div3 = document.createElement("div")
                div3.className = "summary_more"
                div3.textContent = "实际还书日期"
                export_summary.append(div, div2, div3)
            }

            const books = document.getElementsByClassName("book")
            let crr01 = [], crr02 = [], crr03 = [], crr04 = [], crr05 = [], crr06 = [], crr07 = []

            for (let vol of books) {
                if (vol.lastElementChild.className != "book_more_msg") {
                    const div4 = document.createElement("div")
                    div4.className = "book_more_msg01"
                    const div5 = document.createElement("div")
                    div5.className = "book_more_msg02"
                    const div6 = document.createElement("div")
                    div6.className = "book_more_msg03"
                    vol.append(div4, div5, div6)
                }
            }
            const book_more_msg_return = document.getElementsByClassName("book_more_msg01")
            const book_more_msg_return_real = document.getElementsByClassName("book_more_msg02")
            for (let vol of options) {
                vol.value = "小云云"
            }

            instance2({
                method: 'get',
            }).then((res) => {
                console.log(res.data.data);
                for (let vol of res.data.data) {
                    crr01.push(vol.name)
                    crr02.push(vol.book)
                    crr03.push(vol.examined)
                    crr04.push(vol.approved)
                    crr05.push(vol.borrow_Date)
                    crr06.push(vol.return_Date)
                    crr07.push(vol.returned)
                }
                if (res.data.data.length != (export_books.children.length + 1) / 2) {
                    for (let i = (export_books.children.length + 1) / 2; i < res.data.data.length; i++) {
                        export_books.insertAdjacentHTML("beforeend", `                <div class="book_more"></div>
                <div class="book"></div> `)
                    }

                }
                for (let vol of book_names) {
                    vol.textContent = crr01[f1]
                    f1++
                }
                for (let vol of book_authors) {
                    vol.textContent = crr02[f2]
                    f2++
                }
                for (let vol of book_countrys) {
                    vol.textContent = crr03[f3]
                    f3++
                }
                for (let vol of book_counts) {
                    vol.textContent = crr04[f4]
                    f4++
                }
                for (let vol of book_scores) {
                    vol.textContent = crr05[f5]
                    f5++
                }
                for (let vol of book_more_msg_return) {
                    vol.textContent = crr06[f6]
                    f6++
                }
                for (let vol of book_more_msg_return_real) {
                    vol.textContent = crr07[f7]
                    f7++
                }
                for (let vol of book_indexs) {
                    vol.textContent = f
                    f++
                    if (f > res.data.data.length) {
                        break
                    }
                }

            })


        })

        Export_more.addEventListener("click", () => {
            Export_more.style.transform = "translate(135px,-34px) rotate(225deg)"
            export_choice_all.style.display = "block"
        })
        Export_more.addEventListener("dblclick", () => {
            Export_more.style.transform = "translate(135px,-42px) rotate(45deg)"
            export_choice_all.style.display = "none"
            main_export_most.style.display = "block"
            export_name.textContent = "Books"
        })
    })



}


//主页面回溯

modify.addEventListener("click", () => {
    Export_more.style.display = "none"
    main.classList = "main"
    main.innerHTML = foo.main_copy.innerHTML
    seek.style.borderBottom = "none"
    examine.style.borderBottom = "none"
    modify.style.borderBottom = "2px solid white"
    EXport.style.borderBottom = "none"
    modify_config()

})

//书籍逾期提醒功能
function date_realize() {
    instance2({
        method: 'get',
    }).then((res) => {
        let crr = [], crr2 = []
        for (let vol of res.data.data) {
            crr.push(vol.borrow_Date)
            crr2.push(vol.return_Date)
        }
        let special_borrow = 0
        for (let vol of crr) {
            if (vol != undefined) {
                let date_arr = []
                let date_str_real = 20
                let date_str_from = ""
                const re = /\d+/ig
                let result = re.exec(crr2[special_borrow])
                while (result) {
                    date_arr.push(result[0])
                    result = re.exec(crr2[special_borrow])
                }
                for (let vol of date_arr) {
                    date_str_real += vol.toString()
                }
                let timer = setInterval(() => {
                    let d = new Date()
                    date_str_from = d.getFullYear().toString() + (d.getMonth() + 1).toString() + d.getDate().toString()
                    if (Number(date_str_real) === date_str_from) {
                        clearInterval(timer)
                    }
                }, 86400000);
            }
            special_borrow++
        }
    })
}


//所用函数的整合
function more_add() {
    if (main.lastElementChild.className == "main_02") {
        const ul = document.createElement("ul")
        if (ul.children.length < 1) {
            const li = document.createElement("li")
            li.className = "pic"
            li.insertAdjacentHTML("afterbegin", `${more_new}`)
            ul.appendChild(li)
            main.insertAdjacentElement("beforeend", ul)
        }
    }

    else {
        const uls = document.getElementsByTagName("ul")
        for (let vol of uls) {
            if (vol.children.length < 1) {
                const li = document.createElement("li")
                li.className = "pic"
                li.insertAdjacentHTML("afterbegin", `${more_new}`)
                vol.appendChild(li)
                main.insertAdjacentElement("beforeend", vol)
            }
        }

    }

}

function give(m) {
    const uls = document.getElementsByTagName("ul")
    if (uls[m + 1]) {
        if (uls[m + 1].children.length > 0) {
            uls[m].appendChild(uls[m + 1].firstElementChild)
        }
    }
}

function bottom_down() {

    if (more_unavailable.nextElementSibling.className == "bottom") {
        const bottom = document.getElementsByClassName("bottom")[0]
        bottom.style.position = "fixed"
        bottom.classList = "bottom_copy"
    }

}

function bottom_up() {

    if (more_unavailable.nextElementSibling.className == "bottom_copy") {
        const bottom_copy = document.getElementsByClassName("bottom_copy")[0]
        bottom_copy.style.position = "absolute"
        bottom_copy.classList = "bottom"
    }

}