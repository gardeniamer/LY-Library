const main_copy = document.createElement("div")

main_copy.innerHTML = `<div class="change">增添/删除</div>
        <ul class="main_01">
            <div class="pic01">
                <div class="bg_pic">
                    <div class="circle">修改</div>
                </div>
            </div>
            <div class="pic02">
                <div class="bg_pic">
                    <div class="circle">修改</div>
                </div>
            </div>
            <div class="pic03">
                <div class="bg_pic">
                    <div class="circle">修改</div>
                </div>
            </div>
        </ul>
        <ul>
            <div>
                <div>
                    <div></div>
                </div>
            </div>
            <div>
                <div>
                    <div></div>
                </div>
            </div>
            <div>
                <div>
                    <div></div>
                </div>
            </div>
        </ul>`




const main_modify_copy = document.createElement("div")
main_modify_copy.innerHTML = `
    <div class="main_modify_most">
        <div class="main_modify_most2">
            <div class="modify_top">
                <div class="modify_top_word">
                    编辑
                </div>
            </div>
            <div class="modify_vertical">
                <div class="modify_vertical_most_decoration">
                    <div class="modify_vertical_most">
                        <div class="modify_edit">
                            <div class="iconfont icon-liebiao"></div>
                        </div>
                        <div class="modify_contents">
                            <div class="modify_contents_most">
                                <div class="modify_book"></div>
                                <div class="modify_details">
                                <div class="modify_author">
                                        书名：
                                        <input type = "text" value = "" class = "input_modify"/>
                                    </div>
                                    <div class="modify_author">
                                        作者：
                                        <input type = "text" value = "" class = "input_modify"/>
                                    </div>
                                                                    <div class="modify_author">
                                        分类：
                                        <input type = "text" value = "" class = "input_modify"/>
                                    </div>
                                                                    <div class="modify_author">
                                        数量：
                                        <input type = "text" value = "" class = "input_modify"/>
                                    </div>
                                    <div class="modify_country">
                                        出版社：
                                        <input type = "text" value = "" class = "input_modify"/>
                                    </div>
                                    <div class="modify_content">
                                    简介:
    <textarea class = "textarea_modify"  id = "modify_introduce" value = "小说描写吉卜赛弃儿希斯克利夫被山庄老主人收养后，因受辱和恋爱不遂，外出致富。回来后，对与其女友……"></textarea>
                                    </div>
                                    <div class="modify_btn">完成</div>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>


    </div>`



const main_add_copy = document.createElement("div")
main_add_copy.innerHTML = `
    <div class="main_add_most">
        <div class="add_top">添加图书</div>
        <div class="add_vertical_decoration">
            <div class="add_vertical">
                <div class="add_vertical_most">
                    <div class="add_vertical_edit">
                        <div class="iconfont icon-liebiao"></div>
                    </div>
                    <div class="camera_all">
                        <div class="camera">
                            <div class="camera_look">添加封面</div>
                            <input type="file" id="file_start" />
                        </div>
                    </div>
                    <div class="msg">
                        <div class="msg_main">
                            <div class="author">
                                <div class="word01" name="word">书名:</div>
                                <input type="text" class="input_add" id="input_add01" />
                                <div class="tip"></div>
                            </div>
                            <div class="author">
                                <div class="word01" name="word">分类:</div>
                                <input type="text" class="input_add" id="input_add01" />
                                <div class="tip"></div>
                            </div>
                            <div class="author">
                                <div class="word01" name="word">作者:</div>
                                <input type="text" class="input_add" id="input_add01" />
                                <div class="tip"></div>
                            </div>
                            <div class="count">
                                <div class="word02" name="word">数量:</div>
                                <input type="text" class="input_add" id="input_add02">
                                <div class="tip"></div>
                            </div>
                            <div class="country">
                                <div class="word03" name="word">出版社:</div>
                                <input type="text" class="input_add" id="input_add03">
                                <div class="tip"></div>
                            </div>
                            <div class="content">
                                <div class="word04" name="word">简介:</div>
                                <textarea name="" cols="30" rows="10" maxWidth="140" id = "add_textarea"></textarea>
                            </div>
                            <div class="add_finish">
                                <div class="finish_btn">完成</div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>

    </div>`



const main_seek_copy = document.createElement("div")
main_seek_copy.innerHTML = `<div class="seek_tool">
            <div class="seek_decoration"></div>
            <input list = "default_books" class="seek_bord" placeholder="常搜：三体、冰与火之歌、呼啸山庄" />
            <datalist id="default_books">
                <option value="三体"></option>
                <option value="摆渡人"></option>
                <option value="红与黑"></option>
                <option value="傲慢与偏见"></option>
                <option value="呼啸山庄"></option>
                <option value="瓦尔登湖"></option>
            </datalist>
        </div>
        <ul class="main_01">
            <div class="pic01">
                <div class="pic_word">
                    《三体》
                    <div class="pic_word_count">
                        数量：5
                    </div>
                </div>
            </div>
            <div class="pic02">
                <div class="pic_word">
                    《摆渡人》
                    <div class="pic_word_count">
                        数量：5
                    </div>
                </div>
            </div>
            <div class="pic03">
                <div class="pic_word">
                    《红与黑》
                    <div class="pic_word_count">
                        数量：5
                    </div>
                </div>
            </div>
        </ul>
        <ul>
            <div>
                <div>
                    <div>
                    </div>
                </div>
            </div>
            <div>
                <div>
                    <div>
                    </div>
                </div>
            </div>
            <div>
                <div>
                    <div>
                    </div>
                </div>
            </div>
        </ul>`



const main_examine_copy = document.createElement("div")
main_examine_copy.innerHTML = `<div class="main_examine_most">
            <div class="examine_title">
                <div class="examine_title_main">
                    <div class = "examine_borrow">借阅</div>
                    <div class = "examine_return">归还</div>
                    <div class = "examine_realize_copy"></div>
                </div>
            </div>
            <div class="examine_detail">
                <div class="msg">
                    <div class="msg01_left"></div>
                    <div class="msg_right">
                        <div class="left">
                            <div class="name">
                                书名：《呼啸山庄》
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
                    </div>
                </div>
                <div class="msg">
                    <div class="msg02_left"></div>
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
                    </div>
                </div>
            </div>
            <div class="examine_user">
                <div class="examine_user_main">
                    <div class="user_headpic"></div>
                    <div class="user_details">
                        <div class="user_name">
                            用户名：小云云
                        </div>
                        <div class="user_time">
                            期数：七期
                        </div>
                        <div class="user_direction">
                            方向：xxx
                        </div>
                        <div class="user_class">
                            专业班级：xxx
                        </div>
                        <div class="user_number">
                            联系方式：123456789
                        </div>
                    </div>
                </div>
                <div class="refuse_more">
                    <textarea name="" id="examine_text" cols="30" rows="10" placeholder="请输入拒绝原因。。将反馈至用户。。。"></textarea>
                    <button id="submit">提交</button>
                </div>

            </div>
        </div>`




const main_export_copy = document.createElement("div")
main_export_copy.innerHTML = `
            <div class = "export_choice_all">
                <div class = "export_choice">
                    <div class = "export_books_choice">
                        <div class = "export_books_choice_name">Books</div>
                    </div>
                    <div class = "export_users">
                        <div class = "export_users_name">Users</div>
                    </div>
                    <div class = "export_borrowers">
                        <div class = "export_borrowers_name">Borrowers</div>
                    </div>
                </div>
            </div>
                <div class = "export_name"></div>
    <div class="main_export_most">
            <div class="export_inquire">
                <div class="inquire_btn">
                    <input list="default_books" placeholder="查询相关" id="export_content" />
            <datalist id="default_books">
                <option value="三体"></option>
                <option value="摆渡人"></option>
                <option value="红与黑"></option>
                <option value="傲慢与偏见"></option>
                <option value="呼啸山庄"></option>
                <option value="瓦尔登湖"></option>
            </datalist>
                </div>
            </div>
            <div class="export_summary">
                <div class="summary_index">
                    序列
                </div>
                <div class="summary_name">
                    书名
                </div>
                <div class="summary_author">
                    作者
                </div>
                <div class="summary_country">
                    出版社
                </div>
                <div class="summary_count">
                    剩余数量
                </div>
                <div class="summary_score">
                    类型
                </div>
            </div>
            <div class="export_books">
                <div class="book">
                    <div class="book_index">
                        1
                    </div>                
                    <div class="book_name">
                        《呼啸山庄》
                    </div>
                    <div class="book_author">
                        艾米莉勃朗特[英]
                    </div>
                    <div class="book_country">
                        译林出版社
                    </div>
                    <div class="book_count">
                        5
                    </div>
                    <div class="book_score">
                        经典著作
                    </div>
                </div>
                <div class="book_more"></div>
                <div class="book"></div>
                <div class="book_more"></div>
                <div class="book"></div>
                <div class="book_more"></div>
                <div class="book"></div>
                <div class="book_more"></div>
                <div class="book"></div>
                <div class="book_more"></div>
                <div class="book"></div>
                <div class="book_more"></div>
                <div class="book"></div>
                <div class="book_more"></div>
                <div class="book"></div>                
            </div>
        </div>`

export {
    main_copy,
    main_modify_copy,
    main_add_copy,
    main_seek_copy,
    main_examine_copy,
    main_export_copy
}