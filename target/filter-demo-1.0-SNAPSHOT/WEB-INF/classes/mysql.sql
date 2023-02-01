create table books
(
    `index`          int         not null
        primary key,
    bookname         varchar(20) not null,
    ISBN             varchar(20) not null,
    writer           varchar(20) not null,
    publishing_house varchar(20) not null,
    number           int         not null,
    classification   varchar(10) not null
)
    comment '书库';

create table borrower
(
    `index`     int auto_increment
        primary key,
    name        varchar(10) null,
    book        varchar(20) null,
    ISBN        varchar(20) null,
    examined    tinyint(1)  null,
    approved    tinyint(1)  null,
    Borrow_Date date        null,
    returned    tinyint(1)  null,
    Return_Date date        null
)
    comment '借阅者信息';

create table users
(
    `index`     int auto_increment
        primary key,
    username    varchar(10) null,
    password    varchar(10) not null,
    name        varchar(10) not null,
    periods     varchar(10) not null,
    phoneNumber varchar(20) null,
    email       varchar(20) null
)
    comment '用户表';