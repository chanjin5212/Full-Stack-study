
-- C:\class\server\JSPTest\memo.sql

create table tblMemo (
    seq number primary key,                     --번호(PK)
    subject varchar2(100) not null,              --제목
    content varchar2(1000) not null,            --내용
    name varchar2(30) not null,                  --작성자
    pw varchar2(30) not null,                      --암호
    regdate date default sysdate not null     --날짜
);

create sequence seqMemo;

-- 업무 SQL
insert into tblMemo (seq, subject, content, name, pw, regdate) values (seqMemo.nextVal, '메모입니다.', '내용입니다.', '홍길동', '1111', default);

select * from tblMemo order by seq desc;

select count(*) from tblMemo where seq = 1 and pw = '1111'; -- 인증(허가)

update tblMemo set subject = '', content = '', name = '' where seq = 1;

delete tblMemo where seq = 1;

commit;

