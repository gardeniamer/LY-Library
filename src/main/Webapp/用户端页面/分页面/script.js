var no_return_book = document.getElementById('no_return_book');
var book_history = document.getElementById('book_history');
var no_return_book_show = document.querySelector('.no_return_book_show');
var book_history_show = document.querySelector('.book_history_show');

no_return_book.onclick = function () {
    book_history.style.color = 'black';
    no_return_book.style.color = '#3F88FF';
    no_return_book_show.style.display = 'block';
    book_history_show.style.display = 'none';
}
book_history.onclick = function () {
    no_return_book.style.color = 'black';
    book_history.style.color = '#3F88FF';
    no_return_book_show.style.display = 'none';
    book_history_show.style.display = 'block';
}

//归还之后，本书消失
var buttons = document.getElementsByClassName('button');
const lines = document.getElementsByClassName("line");

for (let vol of buttons) {
    vol.addEventListener("click", () => {
        alert("归还成功");
        vol.parentElement.remove()
        for (let vol of lines) {
            if (vol.children.length < 3) {
                if (vol.nextElementSibling.children.length >= 1) {
                    vol.append(vol.nextElementSibling.firstElementChild);
                }
            }
        }
    })
}

//归还界面的增加
// const div = document.createElement("div");
// div.className = "line";
// const more_add_no_return = `<div class="book">
//                             <div class="photo"><img
//                                     src=""></div>
//                             <div class="title"></div>
//                             <button class="button">归还</button>
//                     </div>`
// div.innerHTML = `${more_add_no_return}`
// div.firstChild.firstElementChild.firstElementChild.src = "https://aaaaaabc.oss-cn-beijing.aliyuncs.com/OIP-C%20(1)%201.png"
// no_return_book_show.append(div)

//历史记录的增加
// const div2 = document.createElement("div");
// div2.className = "line";
// const more_add_history = `<div class="book">
//                             <div class="photo"><img
//                                     src=""></div>
//                             <div class="title"></div>
//                             <div class="time_all">
//                                 <div class="borrow_time">借出时间：</div>
//                                 <div class="return_time">归还时间：</div>
//                             </div>
//                         </div>`
// div2.innerHTML = `${more_add_history}`
// book_history_show.append(div2)

// axios({
//     method: "get",
//     url: "..."
// }).then((res) => {
//     console.log(res.data);
// }).catch((err) => {
//     console.log("出错了！！",err);
// })


