var banner1 = document.querySelector(".banner1");
    var check = document.querySelector(".check");
    var checkForm = document.querySelector(".check_form");
    var p = document.getElementById("p");
    var arrow = document.querySelector("i");
    let flag = 0;
    // arrow.onclick = function () {
    //   if (flag == 0) {
    //     checkForm.style.display = "block";
    //     arrow.style.borderColor = "#3F88FF";
    //     flag = 1;
    //   } else {
    //     checkForm.style.display = "none";
    //     arrow.style.borderColor = "black";
    //     flag = 0;
    //   }
    // };
    var imgs = document.querySelector(".imgs");
    var btn1 = document.querySelector(".btn1");
    var btn2 = document.querySelector(".btn2");
    var cercle = document.querySelector(".cercle");
    //首页图片切换
    function animate(obj, target, callback) {
      clearInterval(obj.timer);
      obj.timer = setInterval(function () {
        var step = (target - obj.offsetLeft) / 100;
        step = step > 0 ? Math.ceil(step) : Math.floor(step);
        if (obj.offsetLeft == target) {
          clearInterval(obj.timer);
          if (callback) {
            callback();
          }
        }
        obj.style.left = obj.offsetLeft + step + "px";
      }, 0.1);
    }
    var banner1Width = banner1.offsetWidth;
    for (var a = 0; a < imgs.children.length - 1; a++) {
      var div = document.createElement("div");
      div.setAttribute("index", a);
      cercle.appendChild(div);
      div.addEventListener("click", function () {
        for (var a = 0; a < cercle.children.length; a++) {
          cercle.children[a].style.background = "rgba(0,0,0,0)";
        }
        this.style.background = "white";
        var index = this.getAttribute("index");
        num = index;
        num1 = index;
        animate(imgs, -banner1Width * index);
      });
    }
    // 根据图片对应的圆点切换到对应的图片
    cercle.children[0].style.background = "white";
    var num = 0;
    var num1 = 0;
    btn1.addEventListener("click", function () {
      if (num == imgs.children.length - 1) {
        imgs.style.left = "0";
        num = 0;
      }
      num++;
      animate(imgs, -banner1Width * num);
      num1++;
      if (num1 == cercle.children.length) {
        num1 = 0;
      }
      for (var a = 0; a < cercle.children.length; a++) {
        cercle.children[a].style.background = "rgba(0,0,0,0)";
      }
      cercle.children[num1].style.background = "white";
    });
    btn2.addEventListener("click", function () {
      if (num == 0) {
        num = imgs.children.length - 1;
        imgs.style.left = -num * banner1Width + "px";
      }
      num--;
      animate(imgs, -banner1Width * num);
      num1--;
      if (num1 < 0) {
        num1 = cercle.children.length - 1;
      }
      for (var a = 0; a < cercle.children.length; a++) {
        cercle.children[a].style.background = "rgba(0,0,0,0)";
      }
      cercle.children[num1].style.background = "white";
    });
    //首页图片自动切换
    var selfMotion = setInterval(function () {
      btn1.click();
    }, 3000);
    //导航栏页面切换
    var nav = document.querySelector(".nav");
    var divs = nav.querySelectorAll("div");
    var change_box = document.querySelector(".change_box");
    var divss = change_box.querySelectorAll(".box");
    var blue = document.querySelector(".blue");
    var no_return_book = document.getElementById('no_return_book');
    var book_history = document.getElementById('book_history');
    var no_return_book_show = document.querySelector('.no_return_book_show');
    var book_history_show = document.querySelector('.book_history_show');
    for (var a = 0; a < divs.length; a++) {
      divs[a].setAttribute("index", a);
      divs[a].onclick = function () {
        window.scrollTo({
          top:0,
        })
        for (var a = 0; a < divs.length; a++) {
          divs[a].style.color = "black";
        }
        this.style.color = "#3F88FF";
        var index = this.getAttribute("index");
        if(index==3){
          console.log(123)
          for (var a = 0; a < divss.length; a++) {
          divss[a].style.display = "none";
        }
        divss[index-1].style.display = "block";
        no_return_book.style.color = 'black';
        book_history.style.color = '#3F88FF';
        no_return_book_show.style.display = 'none';
        book_history_show.style.display = 'block';
      }else{
           for (var a = 0; a < divss.length; a++) {
          divss[a].style.display = "none";
        }
        divss[index].style.display = "block";
      };
      if(index==0){
        selfMotion = setInterval(function () {
          btn1.click();
        }, 3000);
      }else{
        clearInterval(selfMotion);
      }
      }
    }
     
    //鼠标上浮显示图书简介
    var words = document.querySelectorAll(".words");
    var booksUl = document.querySelector(".books_ul");
    var bookImg = booksUl.querySelectorAll("img");
    var lis = booksUl.querySelectorAll("li");
    var ul=document.querySelectorAll('ul');
    let abc = 0 ;
    ul[0].addEventListener('click',function(e){
        console.log(e.target.getAttribute('index1'));
        this.abc = e.target.getAttribute('index1')
        
    })
    for (var a = 0; a < bookImg.length; a++) {
      bookImg[a].setAttribute("index1", a);
      bookImg[a].onmouseover = function () {
        this.style.height = "420px";
        this.style.width = "320px";
        var index1 = this.getAttribute("index1");
        lis[index1].style.height = "570px";
        lis[index1].style.width = "320px";
        words[index1].style.height = "205px";
        words[index1].style.background = "white";
      };
      bookImg[a].onmouseout = function () {
        this.style.height = "400px";
        this.style.width = "300px";
        var index1 = this.getAttribute("index1");
        lis[index1].style.height = "550px";
        lis[index1].style.width = "300px";
        words[index1].style.height = "80px";
        words[index1].style.background = "rgba(0, 0, 0, 0)";
      };
      var main_box1=document.querySelector('.main_box1');
      var main_box2=document.querySelector('.main_box2');
      var book_name=document.querySelector('#book_name');
      var book_number=document.querySelector('#book_number');
      var introduce=document.querySelector('.introduce');
      bookImg[a].onclick=function(){
        main_box1.style.display='none';
        main_box2.style.display='block';
        window.scrollTo({
          top:0,
        })
        axios({
          method: "get",
          url: "http://202.182.125.24:41348/LYlibrary/presentAllBooks-servlet",
        }).then((res) => {
          for(var i=0;i<res.data.data.length;i++){
            book_name.innerHTML=`${res.data.data[abc].bookname}数量：`
          book_number.innerHTML=`${res.data.data[abc].number}`
          introduce.innerHTML=`内容梗概：${res.data.data[abc].introduction}`
        }
          });
      }
    }
    // var books = document.querySelectorAll(".books");
    // for (var a = 0; a < checkForm.children.length; a++) {
    //   checkForm.children[a].setAttribute("index2", a);
    //   checkForm.children[a].onclick = function () {
    //     for (var a = 0; a < divs.length; a++) {
    //       divs[a].style.color = "black";
    //     }
    //     divs[1].style.color = "#3F88FF";
    //     for (var a = 0; a < divss.length; a++) {
    //       divss[a].style.display = "none";
    //     }
    //     divss[1].style.display = "block";
    //     for (var a = 0; a < checkForm.children.length; a++) {
    //       checkForm.children[a].style.background = "rgba(0,0,0,0)";
    //     }
    //     this.style.background = "rgba(205, 202, 202, 0.9)";
    //     var index2 = this.getAttribute("index2");
    //     for (var a = 0; a < books.length; a++) {
    //       books[a].style.display = "none";
    //     }
    //     books[index2].style.display = "block";
    //   };
    // }

    var h4=document.querySelectorAll("h4");
    var h3=document.querySelectorAll("h3");
    var p_introduction=document.querySelectorAll('.p_introduction');   
    axios({
      method: "get",
      url: "http://202.182.125.24:41348/LYlibrary/presentAllBooks-servlet",
    }).then((res) => {
      for(var i=0;i<res.data.data.length;i++){
        console.log(res.data.data[i].bookname);
        h4[i].innerHTML=`【${res.data.data[i].bookname}】 ${res.data.data[i].writer} ${res.data.data[i].publishing_house}`
        h3[i].innerHTML=`数量：${res.data.data[i].number}`
        p_introduction[i].innerHTML=`内容梗概：${res.data.data[i].introduction}`
      }
    });
    var input_search=document.querySelector('.input_search');
    var find=document.querySelector('.find');
    find.onclick=function(){
      axios({
        method: "post",
        url: "http://202.182.125.24:41348/LYlibrary/presentcertainBook-servlet",
        data: {
          bookName:`${input_search.value}`
        },
      }).then((res) => {
        console.log(res);
        alert(res.data.data[0].introduction)
      }).catch((err) => {
            console.log("出错了",err);
        })
    }