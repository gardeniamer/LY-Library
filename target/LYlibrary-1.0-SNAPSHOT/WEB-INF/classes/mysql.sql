create table books
(
    `index`          int          not null comment '序号'
        primary key,
    bookname         varchar(20)  not null comment '书名',
    writer           varchar(20)  not null comment '作者',
    publishing_house varchar(20)  not null comment '出版社',
    number           int          not null comment '图书数量',
    classification   varchar(10)  not null comment '图书类别',
    introduction     varchar(500) null comment '图书简介'
)
    comment '书库';

create table borrower
(
    `index`     int auto_increment comment '序号'
        primary key,
    name        varchar(10) null comment '姓名',
    book        varchar(20) null comment '书籍',
    examined    varchar(10) null comment '是否审核',
    approved    varchar(10) null comment '审核是否通过',
    Borrow_Date date        null comment '借书日期',
    returned    varchar(10) null comment '是否还书',
    Return_Date date        null comment '还书日期'
)
    comment '借阅者信息';

create table users
(
    `index`     int auto_increment comment '序号'
        primary key,
    name        varchar(10) null comment '姓名',
    period varchar (10) null comment '期数',
    direction   varchar(10) null comment '方向',
    phoneNumber varchar(20) null comment '电话号码',
    email       varchar(20) null comment '邮箱',
    password    varchar(10) null comment '密码'
)
    comment '用户表';