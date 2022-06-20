-- ex09_numerical_function.sql


/*

    숫자 함수(=수학 함수)
    - 자바의 Math 클래스 역할
    
    
    round()
    - 반올림 함수
    - number round(컬럼명): 정수 반환
    - number round(컬럼명, 소수이하자릿수): 실수 반환
    
*/

select 
    height / weight, 
    round(height / weight),
    round(height / weight, 1),
    round(height / weight, 2),
    round(height / weight, 3),
    round(height / weight, 0) 
from tblComedian;




























