
-- C:\class\server\JSPTest\auth.sql

create table tblUser (
    id varchar2(30) primary key,        --아이디
    pw varchar2(30) not null,            --암호
    name varchar2(30) not null,         --이름
    lv number(1) not null                 --등급(1-관리자, 2-회원, 3-준회원)
);

insert into tblUser (id, pw, name, lv) values ('hong', '1111', '홍길동', 3);
insert into tblUser (id, pw, name, lv) values ('test', '1111', '테스트', 2);
insert into tblUser (id, pw, name, lv) values ('admin', '1111', '아무개', 1);

commit;

