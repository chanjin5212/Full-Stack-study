
-- C:\class\java\JDBCTest\script.sql

-- 주소록 테이블
select * from tblAddress;

create table tblAddress (
    seq number primary key,                                 --PK
    name varchar2(10) not null,                             --이름
    age number(3) not null check (age between 0 and 150),   --나이
    gender char(1) not null check(gender in ('m','f')),     --성별(m,f)
    tel varchar2(15) not null,                              --전화번호
    address varchar2(300) not null,                         --주소
    regdate date default sysdate not null                   --등록일
);

create sequence seqAddress;

insert into tblAddress (seq, name, age, gender, tel, address, regdate)
    values (seqAddress.nextVal, '홍길동', 20, 'm', '010-1234-5678', '서울시 강남구 역삼동 한독빌딩', default);

update tblAddress set age = age + 1 where seq = 1;

delete from tblAddress where seq = 1;    

select * from tblAddress;

commit;


select seqJava.nextVal from dual;





create table tblAddress (
    seq number primary key, 
    name varchar2(10) not null,
    age number(3) not null check (age between 0 and 150),
    gender char(1) not null check(gender in ('m','f')),
    tel varchar2(15) not null,
    address varchar2(300) not null, 
    regdate date default sysdate not null 
);

select count(*) from tblInsa;
    
    
    
select * from tblBonus;    
    
create sequence seqBonus;    
    
select nam, buseo, jikwi from tblInsa;    

select m.name, v.name from tblVideo v inner join tblRent r on v.seq = r.video inner join tblMember m on m.seq = r.member;    
    
    
insert into tblAddress (seq, name, age, gender, tel, address, regdate) 
    values (seqAddress.nextVal, '하하하', 20, 'm', '010-1111-2222', '서울시 동대문구 이문''s동', default);
    
    
select * from tblAddress order by seq asc;
    
--9	    하하하	20	m	010-1111-2222	서울시 동대문구 이문's동	22/05/10
--10	하하하	20	m	010-1111-2222	서울시 동대문구 이문''s동	22/05/10   

desc tblInsa;




-- Ex06_CallableStatement.java

-- m1. 인자값, 반환값
create or replace procedure procM1
is
begin
    insert into tblAddress (seq, name, age, gender, tel, address, regdate)
    values (seqAddress.nextVal, '홍길동', 20, 'm', '010-1234-5678', '서울시 강남구 역삼동 한독빌딩', default);
end;

select * from tblAddress order by seq desc;



-- m2. 인자값(O), 반환값(X)
create or replace procedure procM2 (
    pname       tblAddress.name%type,
    page        tblAddress.age%type,
    pgender     tblAddress.gender%type,
    ptel        tblAddress.tel%type,
    paddress    tblAddress.address%type
)
is
begin

    insert into tblAddress (seq, name, age, gender, tel, address, regdate)
    values (seqAddress.nextVal, pname, page, pgender, ptel, paddress, default);

end;

-- 검증!!!!
begin
    procM2('이름', 20, 'm', '010-1111-1111', '주소');
end;

select * from tblAddress order by seq desc;



-- m3. 인자값(X), 반환값(O)
create or replace procedure procM3 (
    pcount out number
)
is
begin
    
    select count(*) into pcount from tblAddress;
    
end procM3;


set serverout on;

declare
    vcount number;
begin
    procM3(vcount);
    dbms_output.put_line(vcount);
end;



-- m4.
--//문제. 직원 번호를 입력하면, 이름, 부서, 직위, 지역을 반환 + 출력
--// procM4
--// - in > 직원 번호
--// - out > 이름
--// - out > 부서
--// - out > 직위
--// - out > 지역

create or replace procedure procM4 (
    pnum in number,
    pname out varchar2,
    pbuseo out varchar2,
    pjikwi out varchar2,
    pcity out varchar2
)
is
begin

    select name, buseo, jikwi, city into pname, pbuseo, pjikwi, pcity
        from tblInsa where num = pnum;

end;

declare
    vname tblInsa.name%type;
    vbuseo tblInsa.buseo%type;
    vjikwi tblInsa.jikwi%type;
    vcity tblInsa.city%type;
begin
    procM4(1001, vname, vbuseo, vjikwi, vcity);
    dbms_output.put_line(vname);
    dbms_output.put_line(vbuseo);
    dbms_output.put_line(vjikwi);
    dbms_output.put_line(vcity);
end;





-- m5.
create or replace procedure procM5 (
    pbuseo in varchar2,
    pcursor out sys_refcursor
)
is
begin

    open pcursor 
    for 
        select name, jikwi, basicpay 
            from tblInsa 
                where buseo = pbuseo;

end procM5;


declare
    pcursor     sys_refcursor;
    vname       tblInsa.name%type;
    vjikwi      tblInsa.jikwi%type;
    vbasicpay   tblInsa.basicpay%type;
begin
    procM5('개발부', pcursor);
    
    loop
        fetch pcursor into vname, vjikwi, vbasicpay;
        exit when pcursor%notfound;
        
        dbms_output.put_line(vname || ',' || vjikwi || ',' || vbasicpay);
    
    end loop;
    
end;









select * from tblBonus;



-- m6
create or replace procedure procM6(
    pbuseo in varchar2,
    pcursor out sys_refcursor
)
is
    
begin

    --1. 부서명 > 직원 번호
    --2. 직원번호 > 보너스 지급 내역
    open pcursor for 
        select name, bonus from tblInsa i
            left outer join tblBonus b
                on i.num = b.num
                    where buseo = pbuseo;
    

end procM6;



















































