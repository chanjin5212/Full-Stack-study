
-- C:\class\server\JSPTest\gallery.sql

create table tblGallery (
    
    seq number primary key,                    --번호(PK)
    filename varchar2(100) not null,            --이미지 파일명(하드 디스크에 저장된 이름)
    subject varchar2(100) not null,              --제목(이미지 설명)
    regdate date default sysdate                --작성 시각
    
);

create sequence seqGallery;



select * from tblGallery order by regdate;

delete from tblGallery where seq = 1;

insert into tblGallery (seq, filename, subject) values (seqGallery.nextVal, 'a05.jpg', '이미지1');

