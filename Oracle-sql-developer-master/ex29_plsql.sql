-- ex29_plsql.sql

/*

    PL/SQL
    - Oracle's Procedural Language Extension to SQL
    - 기존의 ANSI-SQL에 절차 지향 언어의 기능을 추가한 SQL
    
    ANSI-SQL
    - 비절차 지향 언어. 순서가 없고 연속적이지 않다.
    - 문장 단위 구조
    - ANSI-SQL + 절차적 기능(제어) = PL/SQL
    
    
    프로시저, Procedure
    - 메소드, 함수 등..
    - 순서가 있는 명령어의 집합
    - PL/SQL 명령어는 반드시 프로시저내에서만 작성이 가능하다. + 동작이 된다.
    
    1. 익명 프로시저
        - 1회용 코드 작성용
    
    2. 실명 프로시저
        - 재사용 가능
        - 저장 가능
        - 데이터베이스에 이름을 가지고 객체로 저장된다.


    PL/SQL 프로시저 블럭 구조
    - 4개의 키워드(블럭)으로 구성
        a. DECLARE
        b. BEGIN
        c. EXCEPTION
        d. END
    
    1. DECLARE
        - 선언부
        - 프로시저에서 사용할 변수, 객체 등을 선언하는 영역
        - 생략 가능
    
    2. BEGIN
        - 실행부, 구현부
        - BEGIN ~ END
        - 구현된 코드를 가지는 영역(메소드 body 동일)
        - 생략 불가능
        - 핵심
        - PL/SQL + ANSI-SQL 작성
    
    3. EXCEPTION
        - 예외처리부
        - catch 역할
        - 예외 처리 코드를 작성
        - 생략 가능
    
    4. END
        - BEGIN 블럭의 종료 역할
        - 생략 불가능


    PL/SQL 자료형
    - ANSI-SQL과 동일
    
    변수 선언하기
    - 변수명 자료형 [not null] [default 값];
    - 주로 질의(select)의 결과값을 저장하는 용도
    - 일반 변수로서의 역할도 동일하게 한다.
    
    PL/SQL 연산자
    - ANSI-SQL과 동일
    
    대입 연산자
    - ANSI-SQL
        ex) update table set column = '값';
    - PL/SQL
        ex) 변수 := '값';
        
*/


-- dbms_output.put_line의 결과 > 안보이게 설정
-- 접속할 때 마다 다시 실행

set serverout on;
set serverout off;


declare
    num number;
    name varchar2(20);
    today date;
begin
    num := 10;
    dbms_output.put_line(num);
    
    name := '홍길동';
    dbms_output.put_line(name);
    
    today := sysdate;
    dbms_output.put_line(today);
end;


--ORA-06550: line 6, column 10:
--PLS-00218: a variable declared NOT NULL must have an initialization assignment

declare
    num1 number;
    num2 number;
    num3 number := 30;
    num4 number default 40;
    num5 number not null := 50;
    num6 number not null default 0;
begin

    num1 := 10;
    dbms_output.put_line(num1);
    
    dbms_output.put_line('---');
    dbms_output.put_line(num2); --null
    dbms_output.put_line('---');
    
    dbms_output.put_line(num3);    
    
    -- 구현부 변수 선언
    -- num4 number;
    
    dbms_output.put_line(num4);
    
    --num5 := 50;
    dbms_output.put_line(num5);
    
    num6 := 60;
    dbms_output.put_line(num6);

end;



-- select into 절
-- 변수 > select 결과를 담는 용도


declare

    vname varchar2(15);
    buseo varchar2(15);
    
begin
    
    -- vname := (select name from tblInsa where num = 1001);
    
    -- select 컬럼 into 변수
    select name into vname from tblInsa where num = 1001;
    select buseo into buseo from tblInsa where num = 1001;
    
    dbms_output.put_line(vname);    
    dbms_output.put_line(buseo);
    
end;

-- ORA-06550: PL/SQL Error
-- PLS-00428: an INTO clause is expected in this SELECT statement
-- PLS-00201: identifier 'BUSEO' must be declared
begin
    
    -- *** PL/SQL 블럭안에서는 절대로 일반 SQL을 작성할 수 없다.
    --    > 반드시 select into절을 사용해야 한다.
    --    > ANSI-SQL의 결과값을 바로 사용 하지 못하고 PL/SQL으로 옮겨서 사용이 가능하다.
    select buseo from tblInsa where num = 1001;
    --dbms_output.put_line(buseo); --가져온 컬럼값을 변수에 넣지 않고 바로 조작(출력)
end;



create table tblName (
    name varchar2(15)
);


-- select > tblName 추가
-- 1. ANSI-SQL
-- 2. PL/SQL

declare
    vname varchar2(15);
begin
    
    select name into vname from tblInsa where buseo = '개발부' and jikwi ='부장';
    
    insert into tblname (name) values (vname);
    
end;

select * from tblname;



insert into tblname (name) values ((select name from tblInsa where buseo = '개발부' and jikwi ='부장'));






-- select into > 1개의 값을 select > 1개의 PL/SQL 변수에 대입

declare
    vname varchar2(15);
    vbuseo varchar2(15);
    vjikwi varchar2(15);
begin
    
    --select name into vname, buseo into vbuseo, jikwi into vjikwi from tblInsa where num = 1001;  
    
    -- into 주의점
    -- 1. 컬럼의 개수와 변수의 개수의 일치    
    --    PL/SQL: ORA-00947: not enough values, PL/SQL: ORA-00913: too many values
    -- 2. 컬럼의 순서와 변수의 순서의 일치
    -- 3. 컬럼과 변수의 자료형 일치
    --    ORA-06502: PL/SQL: numeric or value error: character to number conversion error
    select name, buseo, jikwi into vname, vbuseo, vjikwi from tblInsa where num = 1001;  
    
    dbms_output.put_line(vname);
    dbms_output.put_line(vbuseo);
    dbms_output.put_line(vjikwi);
    
end;



/*

    타입 참조
    - 변수를 선언할 때 사용
    
    1. %type
        - 사용하는 테이블의 특정 컬럼의 스키마를 알아내서 변수에 적용
        - 복사되는 정보
            a. 자료형
            b. 길이

    
    프로시저에서 select값을 저장하기 위한 변수를 만드는 경우
    1. vbuseo varchar2(15)
        - 정적
    
    2. vbuseo tblInsa.buseo%type
        - 동적(참조)
    

*/

desc tblInsa;

declare
    --vbuseo varchar2(15);
    vbuseo tblInsa.buseo%type; --tblInsa의 buseo컬럼을 확인해서 동일한 타입과 동일한 길이를 변수에 적용해준다.
begin
    select buseo into vbuseo from tblInsa where num = 1001;
    dbms_output.put_line(vbuseo);
end;


declare
    vname       tblInsa.name%type;
    vbuseo      tblInsa.buseo%type;
    vcity       tblInsa.city%type;
    vbasicpay   tblInsa.basicpay%type;
begin
    select
        name, buseo, city, basicpay
        into
        vname, vbuseo, vcity, vbasicpay
    from tblInsa where num = 1001;     
    
    dbms_output.put_line(vname);
    dbms_output.put_line(vbuseo);
    dbms_output.put_line(vcity);
    dbms_output.put_line(vbasicpay);
end;


-- 직원 중 일부에게 보너스 지급 > 내역 저장
-- 보너스 = basicpay * 1.5
create table tblBonus (
    seq number primary key,
    num number(5) not null references tblInsa(num), --직원번호(FK)
    bonus number not null
);

select * from tblInsa where city = '서울' and jikwi = '부장' and buseo = '영업부';

insert into tblBonus (seq, num, bonus) values (1, '김인수num', '김인수bonus');



insert into tblBonus (seq, num, bonus) 
    values (1, 
            (select num from tblInsa where city = '서울' and jikwi = '부장' and buseo = '영업부'), 
            (select basicpay * 1.5 from tblInsa where city = '서울' and jikwi = '부장' and buseo = '영업부'));


declare
    vnum tblInsa.num%type;
    vbasicpay tblInsa.basicpay%type;
begin
    select num, basicpay into vnum, vbasicpay from tblInsa where city = '서울' and jikwi = '부장' and buseo = '영업부';
    
    insert into tblBonus (seq, num, bonus) values (2, vnum, vbasicpay * 1.5);
end;


select * from tblBonus;



/*
    
    타입 참조
    1. %type
        - 컬럼 1개 참조
    2. %rowtype
        - 행 전체 참조(모든 컬럼 참조)

*/

-- 홍길동의 정보 + 출력
declare
    --vnum    tblInsa.num%type;
    --vname   tblInsa.name%type;
    --vbuseo  tblInsa.buseo%type
    
    vrow tblInsa%rowtype; --vrow > 일종 배열 역할 > 레코드 역할
    
begin
    
    --select num, name, buseo, jikwi, ssn, city, basicpay, sudang, ibsadate, tel from tblInsa where num = 1001;
    
--    select 
--        --num, name, buseo, jikwi, ssn, city, basicpay, sudang, ibsadate, tel 
--        num, name, ssn, ibsadate, city, tel, buseo, jikwi, basicpay, sudang
--        into
--        vrow
--    from tblInsa where num = 1001;
    
    select * into vrow from tblInsa where num = 1001;

    --dbms_output.put_line(vrow);
    dbms_output.put_line(vrow.num);
    dbms_output.put_line(vrow.name);
    dbms_output.put_line(vrow.buseo);
    dbms_output.put_line(vrow.basicpay);
    
end;


desc tblInsa;


--------------------

select * from tblMan;
select * from tblWoman;

-- '하하하' > 성전환 > tblWoman 이동
-- 1. tblMan > select > 정보
-- 2. tblWoman > insert
-- 3. tblMan > delete

declare
    vrow tblMan%rowtype;
begin
    --1.
    select * into vrow from tblMan where name = '하하하';
    
    --2.
    insert into tblWoman values (vrow.name, vrow.age, vrow.height, vrow.weight, vrow.couple);
    
    --3.
    delete from tblMan where name = '하하하';
    
end;



-- 제어문
-- 1. 조건문
-- 2. 반복문


declare
    vnum number := 10;
begin

    if vnum > 0 then
        dbms_output.put_line('양수');
    end if;

end;



declare
    vnum number := -10;
begin

    if vnum > 0 then
        dbms_output.put_line('양수');
    else 
        dbms_output.put_line('양수 아님');
    end if;

end;





declare
    vnum number := 0;
begin

    if vnum > 0 then
        dbms_output.put_line('양수');
    elsif vnum < 0 then -- else if, elseif, elsif
        dbms_output.put_line('음수');
    else
        dbms_output.put_line('0');
    end if;

end;



-- 직원 1명 선택 > 보너스 지급 > 간부(basicpay * 1.5), 사원(basicpay * 2)

declare

    vnum        tblInsa.num%type;
    vbasicpay   tblInsa.basicpay%type;
    vjikwi      tblInsa.jikwi%type;
    
    vbonus      number;
    
begin
    
    --1.
    select num, basicpay, jikwi into vnum, vbasicpay, vjikwi from tblInsa where name = '이순신';
    
    --2.
    if vjikwi = '부장' or vjikwi = '과장' then
        vbonus := vbasicpay * 1.5;
    elsif vjikwi in ('대리', '사원') then
        vbonus := vbasicpay * 2;
    end if;
    
    --3.
    insert into tblBonus values (3, vnum, vbonus);
    
    dbms_output.put_line('완료');
    
end;

select b.*, 
    (select name from tblInsa where num = b.num) as name,
    (select jikwi from tblInsa where num = b.num) as jikwi,
    (select basicpay from tblInsa where num = b.num) as basicpay
from tblBonus b;



/*

    case문
    - ANSI-SQL case과 유사
    - 자바 swtich or 다중 if문 유사

*/

declare
    vcontinent tblCountry.continent%type;
    vresult varchar2(30);
begin
    
    select continent into vcontinent from tblCountry where name = '대한민국';
    
    if vcontinent = 'AS' then
        vresult := '아시아';
    elsif vcontinent = 'EU' then
        vresult := '유럽';
    elsif vcontinent = 'AF' then
        vresult := '아프리카';
    else 
        vresult := '기타';
    end if;
    
    dbms_output.put_line(vresult);
    
    
    
    
    case
        when vcontinent = 'AS' then vresult := '아시아';
        when vcontinent = 'EU' then vresult := '유럽';
        when vcontinent = 'AF' then vresult := '아프리카';
        else vresult := '기타';
    end case;
    
    dbms_output.put_line(vresult);
    
    
    case vcontinent
        when 'AS' then vresult := '아시아';
        when 'EU' then vresult := '유럽';
        when 'AF' then vresult := '아프리카';
        else vresult := '기타';
    end case;
    
    dbms_output.put_line(vresult);
    
end;
/


select
    
    case continent
        when 'AS' then '아시아'
        when 'EU' then '유럽'
        when 'AF' then '아프리카'
        else '기타'
    end
    
from tblCountry;


-- '신숙주'가 대여한 비디오 제목? > '뽀뽀할까요'
select * from tblMember; --신숙주
select * from tblRent;  --연결
select * from tblVideo; --뽀뽀할까요

-- 1. 조인
select v.name from tblMember m
    inner join tblRent r
        on m.seq = r.member
            inner join tblVideo v
                on v.seq = r.video
                    where m.name = '신숙주';

-- 2. 서브쿼리
select name from tblVideo
    where seq = (select video from tblRent
                    where member = (select seq from tblMember where name = '신숙주'));
                    

-- 3. 프로시저
declare
    mseq tblMember.seq%type;
    vseq tblRent.video%type;
    vname tblVideo.name%type;
begin
    
    select seq into mseq from tblMember where name = '신숙주';
    
    select video into vseq from tblRent where member = mseq;
    
    select name into vname from tblVideo where seq = vseq;
    
    dbms_output.put_line(vname);
    
end;


/*

    반복문
    
    1. loop
        - 단순 반복
    
    2. for loop
        - 횟수 반복(자바 for)
        - loop 기반
    
    3. while loop
        - 조건 반복(자바 while)
        - loop 기반

*/

set serverout on;

begin
    loop 
        dbms_output.put_line(to_char(sysdate, 'hh24:mi:ss'));
    end loop;
end;

declare
    vnum number := 1;
begin
    loop
        
        dbms_output.put_line(to_char(sysdate, 'hh24:mi:ss'));
        
        vnum := vnum + 1;
        
        exit when vnum > 10; --조건을 만족하면 Loop 탈출
        
    end loop;
end;



create table tblLoop (
    seq number primary key,
    data varchar2(30) not null
);

create sequence seqLoop;

-- 데이터 x 1000건 추가

declare
    vnum number := 1;
begin

    loop
        insert into tblLoop values (seqLoop.nextVal, '데이터' || vnum);
        vnum := vnum + 1;
        exit when vnum > 1000;
    end loop;

end;

select * from tblLoop;
select count(*) from tblLoop;




-- 2. for loop
begin
    
    for i in 1..10 loop
        dbms_output.put_line(i);
    end loop;
    
end loop;


create table tblGugudan (
    dan number,
    num number,
    result number not null,
    
    constraint tblgugudan_dan_num_pk primary key(dan, num)
);


begin
    
    for dan in 2..9 loop
        for num in 1..9 loop
            insert into tblGugudan (dan, num, result)
                            values (dan, num, dan * num);
        end loop;
    end loop;
    
end;


select * from tblGugudan;


-- 3. while loop
declare
    vnum number := 1;
begin
    
    while vnum <= 10 loop
    
        dbms_output.put_line(vnum);
        vnum := vnum + 1;
    
    end loop;
    
end;



/*

    select > 결과셋 > PL/SQL 변수 대입
    
    1. select into
        - 결과셋의 레코드가 1개일 때만 가능하다.
    
    2. cursor + loop
        - 결과셋의 레코드가 N개일 때 사용한다.


    declare
        변수 선언;
        커서 선언;
    begin
        커서 열기;
            loop
                데이터 접급 + 조작
            end loop;
        커서 닫기;
    end;
    
*/


-- ORA-01422: exact fetch returns more than requested number of rows
declare
    vname tblInsa.name%type;
begin
    select name into vname from tblInsa;
    dbms_output.put_line(vname);
end;



--create or replace view vwTest
--as
--select문;



declare
    cursor vcursor is select name from tblInsa;
    vname tblInsa.name%type;
begin

    open vcursor; -- select문 실행 > 결과셋에 커서 연결(참조) > 탐색 가능
    
--        fetch vcursor into vname; --select into 와 동일한 역할
--        dbms_output.put_line(vname);
--        
--        fetch vcursor into vname;
--        dbms_output.put_line(vname);
--        
--        fetch vcursor into vname;
--        dbms_output.put_line(vname);

--        for i in 1..60 loop
--            
--            fetch vcursor into vname;
--            dbms_output.put_line(vname);
--        
--        end loop;

        loop
            
            fetch vcursor into vname;
            exit when vcursor%notfound; --boolean
            
            dbms_output.put_line(vname);
        
        end loop;
    
    close vcursor;

end;







-- 기획부 직원 명단 출력(이름, 직위, 지역) or 다른 테이블 복사
create table tblTemp (
    name varchar2(30),
    jikwi varchar2(15),
    city varchar2(15)
);


declare
    
    cursor vcursor is
        select name, jikwi, city from tblInsa
            where buseo = '기획부';

    vname tblInsa.name%type;
    vjikwi tblInsa.jikwi%type;
    vcity tblInsa.city%type;

begin
    
    open vcursor;
    
    loop
    
        fetch vcursor into vname, vjikwi, vcity;
        exit when vcursor%notfound;
        
        dbms_output.put_line(vname || ',' || vjikwi || ',' || vcity);
        
        insert into tblTemp values (vname, vjikwi, vcity);
    
    end loop;
    
    close vcursor;
    
end;

select * from tblTemp;

create table tblTemp2 as select name, jikwi, city from tblInsa where buseo = '기획부';

select * from tblTemp2;



-- 직원 > 보너스 지급
select * from tblBonus;


-- 모든 직원에게 보너스 지급 > 간부(1.5), 사원(2)
declare
    cursor vcursor is
        select num, basicpay, jikwi from tblInsa;
    vnum tblInsa.num%type;        
    vbasicpay tblInsa.basicpay%type;
    vjikwi tblInsa.jikwi%type;
    vseq number;
begin
    
    --boilerplate code > 반복 패턴 코드(축제 코드)
    open vcursor;
    loop
        fetch vcursor into vnum, vbasicpay, vjikwi;
        exit when vcursor%notfound;
        
        
        select max(seq) into vseq from tblBonus;
        vseq := vseq + 1;
        
        
        -- 생각
        -- 간부 vs 사원 구분?
        -- 보너스 지급 차등
        if vjikwi in ('과장', '부장') then
            insert into tblBonus values (vseq, vnum, vbasicpay * 1.5);
        elsif vjikwi in ('사원', '대리') then
            insert into tblBonus values (vseq, vnum, vbasicpay * 2);
        end if;
        
    
    end loop;    
    close vcursor;
    
end;



create sequence seqBonus start with 4;

select * from tblBonus;




declare
    cursor vcursor is
        select * from tblInsa;
    vrow tblInsa%rowtype;
begin
    
    open vcursor;
    loop
        
        fetch vcursor into vrow; -- 10컬럼 -> 10변수
        exit when vcursor%notfound;
        
        dbms_output.put_line(vrow.name || ',' || vrow.ssn);
    
    end loop;
    close vcursor;
    
end;


-- 커서 탐색
-- 1. 커서 + loop      > 사용O
-- 2. 커서 + for loop  > 사용O

declare
    cursor vcursor is
        select * from tblInsa;
    --vrow tblInsa%rowtype;
begin
    
    --open vcursor;
    --loop
    for vrow in vcursor loop -- loop + fetch into + vrow + exit when
    
        --fetch vcursor into vrow;
        --exit when vcursor%notfound;
        
        dbms_output.put_line(vrow.name);
    
    
    end loop;
    --end loop;
    --close vcursor;
    
end;


declare
    cursor vcursor is
        select * from tblInsa;
begin
    
    for vrow in vcursor loop 
    
        dbms_output.put_line(vrow.name);

    end loop;
    
end;



-- 예외 처리
-- - 실행부(begin~end)에서 발생하는 예외를 처리하는 블럭
declare
    vname varchar2(30);
begin

    dbms_output.put_line('시작');
    
    select name into vname from tblInsa; -- where num = 1001;
    dbms_output.put_line(vname);
    
    dbms_output.put_line('끝');

exception
    --when 예외상수 the n
    when others then
        dbms_output.put_line('예외 처리');

end;




-- DB 오류 발생 > 기록 남긴다.
create table tblError (
    seq number primary key,                                             --기본키(PK)
    code varchar2(7) not null check(code in ('A001', 'B001', 'B002')),  --에러 상태 코드
    regdate date default sysdate not null                               --에러 발생 시각
);

create sequence seqError;


rollback;
delete from tblCountry;


declare
    vcnt number;
    vname tblInsa.name%type;
begin  
    select count(*) into vcnt from tblCountry;
    
    -- ORA-01476: divisor is equal to zero
    dbms_output.put_line(100 / vcnt);
    
    
    select name into vname from tblInsa; -- where num = 1001;
    dbms_output.put_line(vname);
    
    
exception

    when ZERO_DIVIDE then -- catch(ArithmaticException e)
        dbms_output.put_line('0으로 나누었습니다.');
        insert into tblError values (seqError.nextVal, 'A001', default);
        
    when TOO_MANY_ROWS then
        dbms_output.put_line('가져온 행이 많음');
        insert into tblError values (seqError.nextVal, 'B001', default);
        
    when others then -- catch(Exception e)
        dbms_output.put_line('예외 처리');
        insert into tblError values (seqError.nextVal, 'B002', default);

end;


select * from tblError;







/*

    프로시저
    1. 익명 프로시저
        - 1회용
    
    2. 실명 프로시저  
        - 재사용
        - 오라클에 저장


    실명 프로시저
    - 저장 프로시저(Stored Procedure)
    1. 저장 프로시저, Stored Procedure
        - 매개변수 구성 / 반환값 구성 > 자유
    2. 저장 함수, Stored Function
        - 매개변수 필수 / 반환값 필수 > 고정
    
    
    
    익명 프로시저 선언
    
    [declare
        변수 선언;
        커서 선언;]
    begin
        구현부;
    [exception
        처리부;]
    end;
    
    
    저장 프로시저 선언
    
    create [or replace] procedure 프로시저명
    is(as)
        [변수 선언;
        커서 선언;]
    begin
        구현부;
    [exception
        처리부;]
    end;
    
*/


-- 즉시 실행
declare
    vnum number;
begin
    vnum := 100;
    dbms_output.put_line(vnum);
end;


-- 오라클 서버에 procTest 저장 > 생성
create or replace procedure procTest
is
    vnum number;
begin
    vnum := 100;
    dbms_output.put_line(vnum);
end;



-- 저장 프로시저를 호출하는 방법

begin
    procTest; --프로시저 실행(호출)
end;



procTest;

-- 사용 X
execute procTest;
exec procTest;
call procTest(); --나중에 사용








/*

    SQL 처리 순서
    
    1. ANSI-SQL or 익명 프로시저
        - 클라이언트 > 구문 작성(select) > 실행(Ctrl+Enter) > 명령어를 오라클 서버에 전달
            > 서버가 명령어를 수신 > 구분 분석(파싱) + 문법 검사 > 컴파일 실행
            > 실행 > 결과 도출 > 서버가 결과셋을 클라이언트에게 반환
            > 결과셋을 화면에 출력
        - 한번 실행했던 명령어를 다시 실행 > 위의 과정을 다시 처음부터 끝까지 모든 과정을 재실행한다.
        - 첫번째 실행 비용 = 다시 실행 비용
    
    
    2. 저장 프로시저
        - 클라이언트 > 구문 작성(create) > 실행(Ctrl+Enter) > 명령어를 오라클 서버에 전달
            > 서버가 명령어를 수신 > 구분 분석(파싱) + 문법 검사 > 컴파일 실행
            > 실행 > 컴파일된(***) 프로시저를 서버에 저장
        - 클라이언트 > 구문 작성(호출) > 실행(Ctrl+Enter) > 명령어를 오라클 서버에 전달
            > 서버가 명령어를 수신 > 구분 분석(파싱) + 문법 검사 > 컴파일 실행
            > 실행 > 프로시저 실행
        - 한번 실행했던 명령어를 다시 실행 > 구문 분석 + 컴파일 작업 생략 > 비용 절감
        - 첫번째 실행 비용 > 다시 실행 비용

*/


declare
    vnum number;
begin
    vnum := 100;
    dbms_output.put_line(vnum);
    -- 1000라인
end;


create or replace procedure procTest
is
    vnum number;
begin
    vnum := 100;
    dbms_output.put_line(vnum);
    -- 1000라인
end;


begin
    procTest; --프로시저 실행(호출)
end;




-- 저장 프로시저 = 메소드
-- 매개변수 + 반환값

-- 1. 매개변수가 있는 프로시저
create or replace procedure procTest(pnum number) --매개변수
is
    vresult number; --일반변수
begin

    vresult := pnum * 2;
    dbms_output.put_line(vresult);

end procTest;


begin
    procTest(100);
    procTest(200);
    procTest(300);
end;



create or replace procedure procTest(
    width number, 
    height number
)
is
    vresult number;
begin

    vresult := width * height;
    dbms_output.put_line(vresult);    

end procTest;

begin
    procTest(10, 20);
end;



-- *** 프로시저 매개변수는 길이와 not null 표현이 불가능하다.
create or replace procedure procTest(
    name varchar2
)
is -- 변수 선언이 없어도 반드시 기재    
begin
    
    dbms_output.put_line('안녕하세요. ' || name || '님');
    
end procTest;

begin
    procTest('홍길동');
end;



create or replace procedure procTest(
    width number,
    height number default 10
)
is
    vresult number;
begin

    vresult := width * height;
    dbms_output.put_line(vresult);

end procTest;

begin
    procTest(10, 20); -- width(10), height(20)
    procTest(20);     -- width(20), height(10)
end;




/*
    
    매개변수 모드(******)
    - 매개변수가 값을 전달하는 방식
    - Call by Value
    - Call by Reference
    
    1. in 모드 > 기본 모드
    2. out 모드
    3. in out 모드
    
*/

create or replace procedure procTest (
    pnum1 in number,
    pnum2 in number,
    presult1 out number, -- 변수자체를 매개변수로 받는다. 주소값을 받아온다. > 반환값 역할
    presult2 out number,
    presult3 out number
)
is
begin
    presult1 := pnum1 + pnum2;
    presult2 := pnum1 * pnum2;
    presult3 := pnum1 - pnum2;
    dbms_output.put_line('프로시저 실행 완료');
end;

--PLS-00363: expression 'TO_NUMBER(SQLDEVBIND1Z_1)' cannot be used as an assignment target
declare
    vresult number;
begin
    procTest(10, 20, vresult);
    dbms_output.put_line(vresult);
end;



declare
    vresult1 number;
    vresult2 number;
    vresult3 number;
begin
    procTest(10, 20, vresult1, vresult2, vresult3);
    dbms_output.put_line(vresult1);
    dbms_output.put_line(vresult2);
    dbms_output.put_line(vresult3);
end;




-- 프로시저 생성 + 호출

-- 1. 부서 지정 > 해당 부서 직원 중 급여 가장 많이 받는 사람의 번호 반환
--      in 1개 > out 1개

-- 2. 직원 번호 지정 > 같이 지역에 사는 직원 수, 같은 직위의 직원 수, 해당 직원보다 급여를 더 많이 받은 직원 수를 반환
--      in 1개 > out 3개

--procTest1
--procTest2

create or replace procedure procTest1(
    pbuseo in varchar2,
    pnum out number
)
is
begin
    
    select num into pnum from tblInsa where basicpay = (select max(basicpay) from tblInsa where buseo = pbuseo);
    
end procTest1;



declare
    vnum number;
begin
    procTest1('기획부', vnum);
    dbms_output.put_line(vnum);
end;



-- 2. 직원 번호 지정 > 같이 지역에 사는 직원 수, 같은 직위의 직원 수, 해당 직원보다 급여를 더 많이 받은 직원 수를 반환
--      in 1개 > out 3개

create or replace procedure procTest2 (

    pnum number,        --직원번호
    pcnt1 out number,   --같은 지역 직원 수
    pcnt2 out number,   --같은 직위 직원 수
    pcnt3 out number    --많이 받는 직원 수    

)
is
begin
    
    --같은 지역 직원 수
    select count(*) into pcnt1 from tblInsa where city = (select city from tblInsa where num = pnum);
    
    --같은 직위 직원 수
    select count(*) into pcnt2 from tblInsa where jikwi = (select jikwi from tblInsa where num = pnum);
    
    --많이 받는 직원 수
    select count(*) into pcnt3 from tblInsa where basicpay > (select basicpay from tblInsa where num = pnum);
    
end procTest2;

declare
    vcnt1 number;
    vcnt2 number;
    vcnt3 number;
begin
    procTest2(1001, vcnt1, vcnt2, vcnt3);
    dbms_output.put_line(vcnt1);
    dbms_output.put_line(vcnt2);
    dbms_output.put_line(vcnt3);
end;


-- 부서명 > procTest1 > 직원번호 > procTest2
declare
    vnum number;
    vcnt1 number;
    vcnt2 number;
    vcnt3 number;
begin
    procTest1('기획부', vnum);
    procTest2(vnum, vcnt1, vcnt2, vcnt3);
    dbms_output.put_line(vcnt1);
    dbms_output.put_line(vcnt2);
    dbms_output.put_line(vcnt3);
end;






--
select * from tblStaff;
select * from tblProject;

rollback;









-- procDeleteStaff
-- 특정 직원 퇴사 > 담당 업무 존재 확인? > 업무 위임 > 퇴사
create or replace procedure procDeleteStaff(
    pseq number,                --퇴사할 직원번호
    pstaff number,              --위임받을 직원번호
    presult out number          --성공(1) or 실패(0) > 생각 > 예외처리
)
is
    vcnt number; --퇴사 직원의 담당 프로젝트 개수
begin


    --1. 퇴사 직원의 담당 프로젝트가 있는지?
    select count(*) into vcnt from tblProject where staff_seq = pseq;
    dbms_output.put_line('퇴사할 직원이 ' || vcnt || '개의 프로젝트를 담당하고 있습니다.');
    
    --2. 조건 > 위임 유무 결정
    if vcnt > 0 then
        
        --3. 위임
        update tblProject set staff_seq = pstaff where staff_seq = pseq;
        dbms_output.put_line(pseq || '의 프로젝트를 ' || pstaff || '에게 위임했습니다.');
        
    else
        --3. 아무것도 안함
        null; -- 이 조건의 else절에서는 아무것도 하지 마시요!! > 개발자의 의도 표현 > Don't touch!!!
    end if;
    
    --4. 퇴사
    delete from tblStaff where seq = pseq;
    dbms_output.put_line(pseq || '가 퇴사합니다.');    
    
    --5. 성공
    presult := 1;

exception
    when others then
        presult := 0;
    
end procDeleteStaff;






declare
    vresult number;
begin
    procDeleteStaff(2, 3, vresult);
    if vresult = 1 then
        dbms_output.put_line('성공');
    else
        dbms_output.put_line('실패');
    end if;
end;





















-- 현재 담당하는 프로젝트의 수가 가장 적은 직원에게 위임
-- 동률 > rownum = 1
create or replace procedure procDeleteStaff(
    pseq number,                --퇴사할 직원번호
    presult out number          --성공(1) or 실패(0) > 생각 > 예외처리
)
is
    vcnt number;
    vstaff_seq number;
begin

    --1. 퇴사 직원의 담당 프로젝트가 있는지?
    select count(*) into vcnt from tblProject where staff_seq = pseq;
    dbms_output.put_line('퇴사할 직원이 ' || vcnt || '개의 프로젝트를 담당하고 있습니다.');
    
    
    --2. 조건 > 위임 유무 결정
    if vcnt > 0 then
    
        --2.5 위임받을 직원이 누구냐??
        select
            staff_seq into vstaff_seq
        from tblProject
            where staff_seq <> pseq
                group by staff_seq
                    having count(*) = (select min(count(*)) from tblProject
                                            where staff_seq <> pseq
                                                group by staff_seq);
        
        
        --3. 위임
        update tblProject set staff_seq = vstaff_seq where staff_seq = pseq;
        dbms_output.put_line(pseq || '의 프로젝트를 ' || '에게 위임했습니다.');
        
    else
        --3. 아무것도 안함
        null;
    end if;
    
    --4. 퇴사
    delete from tblStaff where seq = pseq;
    dbms_output.put_line(pseq || '가 퇴사합니다.');    
    
    --5. 성공
    presult := 1;

exception
    when others then
        presult := 0;
    
    
end procDeleteStaff;






declare
    vresult number;
begin
    procDeleteStaff(2, vresult);
    if vresult = 1 then
        dbms_output.put_line('성공');
    else
        dbms_output.put_line('실패');
    end if;
end;




/*

    저장 프로시저
    1. 저장 프로시저
    2. 저장 함수
    
    저장 함수, Stored Function > 함수, Function
    - 저장 프로시저와 동일
    - 반환값이 반드시 존재 > out 파라미터를 말하는게 아니라 > return 문을 사용한다.
    - out 파라미터를 사용하면 안된다. > return문만 사용
    - int 파라미터는 사용한다. 
    - 위의 특성때문에 호출하는 상황+형태가 조금 다르다.
    
*/

-- num1 + num2 > return
create or replace function fmSum(
    pnum1 in number,
    pnum2 in number
    -- presult out number
) return number
is
begin
    
    --presult := pnum1 + pnum2;
    
    return pnum1 + pnum2;
    
end;



create or replace function fnSum(pnum1 in number,pnum2 in number) return number
is
begin

    return pnum1 + pnum2;
end fnSum;


set serveroutput on;
set serverout on;

declare
    vresult number;
begin

    --변수 := procSum(10, 20, vresult);

    -- 함수 호출 특징 > 자바의 메소드 반환값 동일
    -- return문 > 단일값 반환 > 호출했던곳에서 대입 연산자 사용 가능
    vresult := fnSum(10, 20);
    
    dbms_output.put_line(vresult);

end;
/

-- 저장 프로시저는 ANSI-SQL에서는 사용이 불가능하다.(*****) > 단, 함수는 가능하다.
-- 반환값을 돌려주는 방식의 차이 > 프로시저와 함수는 사용하는 장소가 다르다.
-- 저장 함수는 주로 ANSI-SQL의 반복되는 일을 줄이기 위해서 사용한다.(*********)

select
    height, weight,
    height + weight,
    fnSum(height, weight) -- 인자 > 반환값 > 반환값 딱 1개 > 값으로 사용
    --procSum(height, weight, ??)
from tblComedian;


-- 이름, 부서, 직위, 성별(남자|여자)
select
    name, buseo, jikwi,
    case
        when substr(ssn, 8, 1) = '1' then '남자'
        when substr(ssn, 8, 1) = '2' then '여자'
    end as gender
from tblInsa;



create or replace function fnGender(
    pssn varchar2
) return varchar2
is
begin
    return case
                when substr(pssn, 8, 1) = '1' then '남자'
                when substr(pssn, 8, 1) = '2' then '여자'
           end;
end;



-- 반복되는 업무 or (다량의)복잡한 업무 > 아래 2가지 비교

-- 생산 고비용
-- 호출 고비용
-- 개발자 가독성+조작성 저하 > 유지 보수 저하
-- 팀작업 나쁨
select
    name, buseo, jikwi,
    case
        when substr(ssn, 8, 1) = '1' then '남자'
        when substr(ssn, 8, 1) = '2' then '여자'
    end as gender
from tblInsa;


-- 생산 저비용
-- 호출 저비용
-- 개발자 가독성+조작성 향상 > 유지 보수 향상
-- 팀작업 좋음
select
    name, buseo, jikwi,
    fnGender(ssn) as gender
from tblInsa;


/*

    트리거, Trigger
    - 프로시저의 한 종류
    - 개발자의 호출이 아닌, 미리 지정한 특정 사건이 발생하면 자동으로 실행되는 프로시저
    - 예약(사건) > 사건 발생 > 프로시저 자동 호출
    - 특정 테이블 지정 > 지정 테이블 감시(오라클) > 
        insert or update or delete > 미리 준비 해놓은 프로시저 호출
    - 부하;;
    
    
        
    트리거 구문
    
    create or replace trigger 트리거명
        before|after
        insert|update|delete on 테이블명
        [for each row]
    declare
        선언부;
    begin  
        실행부;
    exception
        예외처리부;
    end;
    

*/


-- before trigger
-- 트리거 실행 > 쿼리 실행
-- 쿼리 실행하기 전에 트리거를 실행하기 때문에 조건에 따라 쿼리의 실행 유무를 통제할 수 있다.
-- 사전 검사 가능!!

-- after trigger
-- 쿼리 실행 > 트리거 실행
-- 사전 개입 불가능!! > 후처리 작업을 주로 한다.


-- tblInsa > 직원 퇴사(삭제)
create or replace trigger trgInsa
    before     -- 삭제하기 직전에 아래 구현부를 실행해라!!
    delete     -- 삭제가 발생하는지 감시해라!!
    on tblInsa -- 인사테이블에서
begin
    
    dbms_output.put_line('트리거가 실행되었습니다.');
    
    -- 월요일에는 퇴사가 불가능
    if to_char(sysdate, 'dy') = '월' then
        
        -- 현재 진행하려던 업무(delete 실행 전) > 취소 > 강제로 예외 발생 > 뒤에 이어질 업무(delete)가 취소
        -- 자바 > throw new Exception()
        -- -20000 ~ -29999
        raise_application_error(-20001, '월요일에는 퇴사가 불가능합니다.');
        
    end if;
    
    
end;



select * from tblInsa;

delete from tblInsa where num = 1005;
delete from tblInsa where num = 1006;

select * from tblBonus where num = 1005;
delete from tblBonus;

commit;




-- 로그 기록
create table tblLogMan (
    seq number primary key,
    message varchar2(1000) not null,
    regdate date default sysdate not null
);

create sequence seqLogMan;


select * from tblMan;

create or replace trigger trgLogMan
    after
    insert or update or delete
    on tblMan
declare
    vmessage varchar2(1000);
begin
    
    -- insert or update or delete ??
    -- dbms_output.put_line('트리거 실행');
    
    if inserting then
        --dbms_output.put_line('트리거 실행 - 추가');
        vmessage := '새로운 항목이 추가되었습니다.';
    elsif updating then
        --dbms_output.put_line('트리거 실행 - 수정');
        vmessage := '항목이 수정되었습니다.';
    elsif deleting then
        --dbms_output.put_line('트리거 실행 - 삭제');
        vmessage := '항목이 삭제되었습니다.';
    end if;
    
    insert into tblLogMan values (seqLogMan.nextVal, vmessage, default);
    
end;


insert into tblMan values ('테스트', 22, 175, 60, null);

update tblMan set weight = 65 where name = '테스트';

delete from tblMan where name = '테스트';


select * from tblLogMan;




/*

    [for each row]
    
    1. 사용 X
        - 문장(Query) 단위 트리거
        - 트리거 실행 1회 -> 사건이 적용되는 레코드의 개수와 상관없이 트리거는 1회 호출
        - 적용된 레코드의 정보가 중요하지 않은 경우 + 사건 자제가 중요한 경우
    
    2. 사용 O
        - 행(Record) 단위 트리거
        - 트리거 실행 반복 -> 사건이 적용되는 레코드의 개수만큼 트리거가 반복 호출
        - 적용된 레코드의 정보가 중요한 경우 + 사건 자체보다 영향을 받은 레코드의 정보 하나 하나가 중요한 경우

*/

select * from tblMan;


create or replace trigger trgMan1
    after
    delete
    on tblMan
begin
    dbms_output.put_line('트리거1');
end;

create or replace trigger trgMan2
    after
    delete
    on tblMan
begin
    dbms_output.put_line('트리거2');
end;

create or replace trigger trgMan3
    after
    delete
    on tblMan
begin
    dbms_output.put_line('트리거3');
end;


-- 특정 테이블에 여러개의 트리거 적용 > 관리 어려움;; > 확인 귀찮음;; > 트리거끼리 충돌;; or 재귀 호출;;


drop trigger trgInsa;
drop trigger trgLogMan;
drop trigger trgMan1;
drop trigger trgMan2;
drop trigger trgMan3;


delete from tblMan where name = '홍길동';

select * from tblLogMan;
rollback;


-- Table A > insert 트리거 > Table B 기록
-- Table B > insert 트리거 > Table A 기록


-- for each row 사용하는 경우
-- 적용되는 행의 정보(데이터)를 가져와서 참조할 수 있다.
-- 상관 관계(:old, :new)를 사용한다. > 일종의 가상 레코드

-- insert
-- > :new (방금 추가된 행 참조)

-- update
-- > :old (수정되기 전 행 참조)
-- > :new (수정된   후 행 참조)

-- delete
-- > :old (삭제되기 전 행 참조)

create or replace trigger trgMan
    after
    delete
    on tblMan
    for each row
begin
    dbms_output.put_line('레코드를 삭제했습니다. - ' || :old.name);
end;


create or replace trigger trgMan
    after
    update
    on tblMan
    for each row
begin
    dbms_output.put_line('레코드를 수정했습니다. - ' || :old.name);
    dbms_output.put_line('수정하기 전 나이: ' || :old.age);
    dbms_output.put_line('수정하기 후 나이: ' || :new.age);
end;


-- 문장 단위 프로시저: delete 1회 실행 > 적용된 행 9개 > 프로시저 1회 실행
-- 행   단위 프로시저: delete 1회 실행 > 적용된 행 9개 > 프로시저 9회 실행
delete from tblMan; --9명

update tblMan set age = age + 1 where couple is not null;

rollback;

select * from tblMan;




-- 2번 직원 퇴사
-- 4번 직원 위임 > 2,5번 위임
select * from tblStaff;
select * from tblProject;


-- 직원을 퇴사 > 바로 전 > 담당 프로젝트 체크 > 자동 위임

create or replace trigger trgDeleteStaff
    before              --3. 전에
    delete              --2. 퇴사
    on tblStaff         --1. 직원 테이블에서
    for each row        --4. 해당 직원 정보
begin
    
    --5. 무언가를 하겠다. > 퇴사 직원의 프로젝트를 다른 직원에게 위임
    update tblProject set
        staff_seq = 4
            where staff_seq = :old.seq; -- 삭제되는 직원의 seq
    
end;


delete from tblStaff where seq = 2;





-- 회원 테이블, 게시판 테이블
-- - 포인트 제도
-- 1. 글 작성 > 포인트 + 100
-- 2. 글 삭제 > 포인트 - 50

create table tblUser (
    id varchar2(30) primary key,
    point number default 10000 not null
);

create table tblBoard (
    seq number primary key,
    subject varchar2(1000) not null,
    id varchar2(30) not null references tblUser(id)
);

create sequence seqBoard;

insert into tblUser values ('hong', default);
select * from tblUser;


-- 회원 > 글쓰기 > + 100
-- 회원 > 글삭제 > - 50


-- A. 글을 쓴다.(삭제한다.)
-- B. 포인트를 누적시킨다.




-- Case 1. Hard.. ANSI-SQL
-- 절차 > 개발자가 직접 제어
-- 실수 > 일부 업무 누락;;

-- 1.1 글쓰기
insert into tblBoard values (seqBoard.nextVal, '게시판입니다.', 'hong');

-- 1.2 포인트 누적하기
update tblUser set point = point + 100 where id = 'hong';

-- 1.3 글삭제
delete from tblBoard where seq = 1;

-- 1.4 포인트 누적하기
update tblUser set point = point - 50 where id = 'hong';




-- Case 2. 프로시저
create or replace procedure procAddBoard (
    psubject varchar2,
    pid varchar2
)
is
begin

    -- 2.1 글쓰기
    insert into tblBoard values (seqBoard.nextVal, psubject, pid);

    -- 2.2 포인트 누적하기
    update tblUser set point = point + 100 where id = pid;
    
    commit;

exception
    when others then
        rollback;    

end;



create or replace procedure procDeleteBoard (
    pseq number
)
is
    vid varchar2(30);
begin

    --삭제글의 작성자
    select id into vid from tblBoard where seq = pseq;
    
    -- 2.3 글삭제
    delete from tblBoard where seq = pseq;
    
    -- 2.4 포인트 누적하기
    update tblUser set point = point - 50 where id = vid;
    
    
    commit;

exception
    when others then
        rollback;    

end;


begin
    --procAddBoard('다시 글을 씁니다.', 'hong');
    procDeleteBoard(2);
end;




-- Case 3. 트리거
create or replace trigger trgBoard
    after
    insert or delete
    on tblBoard
    for each row
begin

    if inserting then
        update tblUser set point = point + 100 where id = :new.id;
    elsif deleting then
        update tblUser set point = point - 50 where id = :old.id;
    end if;

end;


insert into tblBoard values (seqBoard.nextVal, '또 다시 글을 씁니다.', 'hong');
delete from tblBoard where seq = 3;



select * from tblBoard;
select * from tblUser;



/*

    프로시저 Out Parameter
    1. 단일값
        a. number
        b. varchar2
        c. date
    2. 다중값
        a. cursor ***
        
        
    저장 프로시저내에서 커서 사용
    1. 커서 호출 > 결과값(ResulSet) > 프로시저내에서 소비
    2. 커서 호출 > 결과값(ResulSet) > 호출했던곳으로 반환

*/


create or replace procedure procBuseo (
    pbuseo varchar2
)
is
    
    cursor vcursor
    is
    select * from tblInsa where buseo = pbuseo;
    
    vrow tblInsa%rowtype;
    
begin

    open vcursor;
    
    loop
        
        -- select into
        fetch vcursor into vrow;
        exit when vcursor%notfound;
        
        dbms_output.put_line(vrow.name || ',' || vrow.buseo);        
    
    end loop;
    
    close vcursor;

end procBuseo;




begin
    procBuseo('영업부');
end;




create or replace procedure procBuseo(
    pbuseo in varchar2,
    pcursor out sys_refcursor   --커서를 반환값으로 사용할 때 쓰는 자료형
)
is
    -- cursor vcursor is select...
begin

    open pcursor
    for
    select * from tblInsa where buseo = pbuseo;

end procBuseo;


declare
    vcursor sys_refcursor; --커서 참조 변수
    vrow tblInsa%rowtype;
begin
    procBuseo('영업부', vcursor); -- open cursor
    
    loop
    
        fetch vcursor into vrow;
        exit when vcursor%notfound;
        
        dbms_output.put_line(vrow.name);
    
    end loop;
    
end;

-- 프로시저 + 커서 사용
-- 1. 자체 소비용
-- 2. 반환용













-- 프로시저 총 정리(***)

-- 1. 추가 작업(C)
create or replace procedure 추가작업 (
    추가할 데이터 -> in 매개변수,
    추가할 데이터 -> in 매개변수, --원하는 개수만큼
    성공 유무 반환 -> out 매개변수 --return 사용X
)
is
    내부 변수 선언
begin
    작업(insert + (select, update, delete))
    commit; --마무리
exception
    when others then
        예외작업
        rollback; --마무리
end;

select * from tblTodo;

create sequence todo_seq;

drop sequence todo_seq;
-- 사용중 테이블에 적용할 시퀀스 객체를 나중에 만들었을 경우(번호 중복 충돌 발생)
-- 1. 노가다(낮은 번호)
select todo_seq.nextval from dual;
-- 2. seed 지정(권장)
select max(*) from tblTodo;
create sequence todo_seq
    start with 30;


insert into tblTodo (seq, title, adddate, completedate) 
    values (todo_seq.nextval, '할일 추가하기', sysdate, null);

create or replace procedure procAddTodo (
    ptitle in varchar2,
    presult out number -- 1 or 0
)
is
begin
    
    insert into tblTodo (seq, title, adddate, completedate) 
        values (todo_seq.nextval, ptitle, sysdate, null);
    presult := 1; --성공 메시지 반환
    commit;
    
exception
    when others then
        presult := 0; --실패 메시지 반환
        rollback;
end;




create or replace procedure procAddTodo (
    ptitle in varchar2,
    presult out number -- 1 or 0
)
is
    vseq number; --시퀀스 역할
begin

    select max(seq) + 1 into vseq from tblTodo; --시퀀스 객체와 동일한 역할
    
    insert into tblTodo (seq, title, adddate, completedate) 
        values (vseq, ptitle, sysdate, null);
    presult := 1; --성공 메시지 반환
    commit;
    
exception
    when others then
        presult := 0; --실패 메시지 반환
        rollback;
end;


--호출
set serveroutput on;

declare
    vresult number;
begin
    procAddTodo('새로운 할일', vresult);
    dbms_output.put_line(vresult);
end;


select * from tblTodo;









--2. 수정 작업(U)
create or replace procedure 수정작업(
    수정할 데이터 -> in 매개변수,
    수정할 데이터 -> in 매개변수, --원하는 개수
    식별할 데이터 -> int 매개변수, --where절에 사용할 PK or 데이터
    성공 유무 반환 -> out 매개변수 -- N or 0
)
is
    내부 변수
begin
    작업(update + (insert, update, delete, select))
    commit;
exception
    when others then
        예외작업
        rollback;
end;





-- 할일을 했다. > completedate 채우기
create or replace procedure procCompleteTodo (
    --수정할 데이터 > sysdate 대치
    pseq in number,  --수정할 할일 번호
    presult out number --성공 유무
)
is
begin
    update tblTodo set
        completedate = sysdate
            where seq = pseq;
    presult := 1;
    commit;
exception
    when others then
        presult := 0;
        rollback;
end;

select * from tblTodo;

declare
    vresult number;
begin
    procCompleteTodo(32, vresult);
    dbms_output.put_line(vresult);
end;








--3. 삭제 작업(D)
create or replace procedure 삭제작업 (
    식별자 데이터 -> in 매개변수,
    성공 유무 반환 -> out 매개변수
)
is
    내부 변수
begin
    작업(delete + (insert, update, delete, select))
    commit;
exception
    when others then
        예외작업
        rollback;
end;





create or replace procedure procDeleteTodo (
    pseq number, --삭제할 할일 번호
    presult out number --N or 0
)
is
begin
    delete from tblTodo where seq = pseq;
    presult := 1;
    commit;
exception
    when others then
        presult := 0;
        rollback;
end;

select * from tblTodo;

declare
    vresult number;
begin
    procDeleteTodo(32, vresult);
    dbms_output.put_line(vresult);
end;






-- 4. 읽기 작업(R)
-- : 조건없이 반환 
-- : 조건있고 반환
-- : 반환 > 단일행 or 다중행 + 단일컬럼 or 다중행
create or replace procedure 읽기작업 (  
    조건 데이터 -> in 매개변수,
    단일 반환값 -> out 매개변수
)
is
    내부 변수
begin
    작업(select + (insert, update, delete, select))
    commit;
exception
    when others then
        예외작업
        rollback;
end;


create or replace procedure procCountTodo (  
    pstate in number, -- 0(안한일), 1(한일), 2(모두)
    pcnt out number
)
is
begin
    
    if pstate = 0 then
        select count(*) into pcnt from tblTodo where completedate is null;
    elsif pstate = 1 then
        select count(*) into pcnt from tblTodo where completedate is not null;
    else
        select count(*) into pcnt from tblTodo;
    end if;    
    
exception
    when others then
        dbms_output.put_line('에러발생');
end;



declare
    vcnt number;
begin
    procCountTodo(0, vcnt);
    dbms_output.put_line(vcnt);
    procCountTodo(1, vcnt);
    dbms_output.put_line(vcnt);
    procCountTodo(2, vcnt);
    dbms_output.put_line(vcnt);
end;



-- 4. 읽기 작업(R)
create or replace procedure 읽기작업 (  
    조건 데이터 -> in 매개변수,
    단일 반환값 -> out 매개변수,
    단일 반환값 -> out 매개변수,
    단일 반환값 -> out 매개변수 -- 원하는 만큼 > 1행 + 다중컬럼
)
is
    내부 변수
begin
    작업(select + (insert, update, delete, select))
    commit;
exception
    when others then
        예외작업
        rollback;
end;


create or replace procedure procCountSetTodo (  
    --조건 데이터 -> in 매개변수,
    pcnt1 out number,
    pcnt2 out number,
    pcnt3 out number
)
is
begin
    
    select count(*) into pcnt1 from tblTodo where completedate is null;
    select count(*) into pcnt2 from tblTodo where completedate is not null;
    select count(*) into pcnt3 from tblTodo;
    
exception
    when others then
        dbms_output.put_line('예외 발생');
end;


declare
    vcnt1 number;
    vcnt2 number;
    vcnt3 number;
begin
    procCountSetTodo(vcnt1, vcnt2, vcnt3);
    dbms_output.put_line(vcnt1);
    dbms_output.put_line(vcnt2);
    dbms_output.put_line(vcnt3);
end;






-- 4. 읽기 작업(R)
create or replace procedure 읽기작업 (  
    조건 데이터 -> in 매개변수,
    커서 -> out 매개변수 --행이 여러개
)
is
    내부 변수
begin
    작업(select + (insert, update, delete, select))
    commit;
exception
    when others then
        예외작업
        rollback;
end;




create or replace procedure procListTodo (  
    presult out sys_refcursor --반환값으로 커서를 사용할 때 사용하는 자료형(= 결과 테이블, ResultSet)
)
is
begin
    
    open presult for select * from tblTodo;
    
exception
    when others then
        dbms_output.put_line('예외 작업');
end;


declare
    vresult sys_refcursor; --프로시저의 커서
    vrow tblTodo%rowtype;
begin
    
    procListTodo(vresult);
    
    --vresult > 커서 탐색
    loop
        fetch vresult into vrow;
        exit when vresult%notfound;
        
        dbms_output.put_line(vrow.title);
    end loop;
    
end;



























