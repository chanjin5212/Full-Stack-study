
--1. traffic_accident. 각 교통 수단 별(지하철, 철도, 항공기, 선박, 자동차) 발생한 총 교통 사고 발생 수, 총 사망자 수, 사건 당 평균 사망자 수를 가져오시오.
select * from traffic_accident;

select 
    trans_type,
    sum(total_acct_num),
    sum(death_person_num),
    round(sum(death_person_num) / sum(total_acct_num), 2)
from traffic_accident
    group by trans_type;
        
        

--2. tblZoo. 종류(family)별 평균 다리의 갯수를 가져오시오.
select * from tblZoo;

select
    family,
    round(avg(leg), 2) 
from tblZoo
    group by family;

    

    
--3. tblZoo. 체온이 변온인 종류 중 아가미 호흡과 폐 호흡을 하는 종들의 갯수를 가져오시오.

SELECT 
    count(case
        when breath in ('lung') then 1
    end) as "변온,폐 호흡",
    count(case
        when breath in ('gill') then 1
    end) as "변온,아가미 호흡"
FROM tblzoo
    GROUP BY thermo
        HAVING thermo = 'variable';
        

--4. tblZoo. 사이즈와 종류별로 그룹을 나누고 각 그룹의 갯수를 가져오시오.

select
    sizeof, family,
    count(*)
from tblZoo
    group by sizeof, family
        ORDER BY family asc, sizeof desc;

        

--5. tblMen. tblWomen. 서로 짝이 있는 사람 중 남자와 여자의 정보를 모두 가져오시오.(X)
--    [남자]        [남자키]   [남자몸무게]     [여자]    [여자키]   [여자몸무게]
--    홍길동         180       70              장도연     177        65
--    아무개         175       null            이세영     163        null
--    ..


    
    

--10. tblAddressBook. 가장 많은 사람들이 가지고 있는 직업은 주로 어느 지역 태생(hometown)인가?


        

--12. tblAddressBook. 관리자의 실수로 몇몇 사람들의 이메일 주소가 중복되었다. 중복된 이메일 주소만 가져오시오.

select * from tblAddressBook;

select
    email,
    count(email)
from tblAddressBook
    group by email
        having count(email) > 1;

--13. tblAddressBook. 이메일 도메인들 중 평균 아이디 길이가 가장 긴 이메일 사이트의 도메인은 무엇인가?


            
            

--14. tblAddressBook. 평균 나이가 가장 많은 출신(hometown)들이 가지고 있는 직업 중 가장 많은 직업은?


            

--15. tblAddressBook. 성씨별 인원수가 100명 이상 되는 성씨들을 가져오시오.

select
    substr(name, 1, 1)
from tblAddressBook
    group by substr(name, 1, 1)
        having count(substr(name, 1, 1)) >= 100;



--16. tblAddressBook. 남자 평균 나이보다 나이가 많은 서울 태생 + 직업을 가지고 있는 사람들을 가져오시오.

select 
    *
from tblAddressBook
    where age > (select avg(age) from tblAddressBook where gender='m')
            and hometown='서울' and job not in ('취업준비생','백수');

--17. tblAddressBook. 이메일이 스네이크 명명법으로 만들어진 사람들 중에서 여자이며, 20대이며, 키가 150~160cm 사이며, 고향이 서울 또는 인천인 사람들만 가져오시오.
--또는 인천인 사람들만 가져오시오.

SELECT * FROM tbladdressbook
    where instr(email,'_') <> 0 and gender = 'f' and age like ('2_') and height <= 160 and height >= 150 and hometown in ('서울','인천');




--18. tblAddressBook. gmail.com을 사용하는 사람들의 성별 > 세대별(10,20,30,40대) 인원수를 가져오시오.



--19. tblAddressBook. 가장 나이가 많으면서 가장 몸무게가 많이 나가는 사람과 같은 직업을 가지는 사람들을 가져오시오.




--20. tblAddressBook. '건물주'와 '건물주자제분'들의 거주지가 서울과 지방의 비율이 어떻게 되느냐?

SELECT job,
    round(count(case
        when substr(address,1,2) like ('%서울%') then 1 
    end)/count(job)*100,2)||'%' as "서울 거주자",
     round(count(case
        when substr(address,1,2) not like ('%서울%') then 1 
    end)/count(job)*100,2)||'%' as "(비)서울 거주자"   
FROM tbladdressbook group by job having job in ('건물주','건물주자제분');



--21. tblAddressBook.  동명이인이 여러명 있습니다. 이 중 가장 인원수가 많은 동명이인(모든 이도윤)의 명단을 가져오시오.



--22. tblAddressBook. 가장 사람이 많은 직업의(332명) 세대별 비율을 구하시오.
--    [10대]       [20대]       [30대]       [40대]
--    8.7%        30.7%        28.3%        32.2%











