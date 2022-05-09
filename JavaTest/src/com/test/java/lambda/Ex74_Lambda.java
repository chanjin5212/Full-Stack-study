package com.test.java.lambda;

import java.util.Calendar;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.IntToDoubleFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Ex74_Lambda {
	
	public static void main(String[] args) {
		
		//Ex74_Lambda.java
		
		/*
		
			람다식 > 익명 객체의 추상 메소드 > 인터페이스 참조 변수에 저장
			> 람다식은 인터페이스 참조 변수가 필요하다.
			> 람다식은 인터페이스가 필요하다.(***)
			
			
			함수형 인터페이스, Functional Interface
			- 람다식을 사용하기 위해 JDK에서 제공하는 인터페이스
			- 다른 용도로 사용 안함. 오직 람다식을 저장하는 용도로만 사용함.
			- 표준 API 함수형 인터페이스 > JDK 제공
			- 사용자 정의 함수형 인터페이스 > 개발자 선언
			
			
			표준 API 함수형 인터페이스
			1. Consumer > 매개변수O, 반환값X
				- Consumer<T>
				- BiConsumer<T,U>
				- andThen()
							
			2. Supplier > 매개변수X, 반환값O
				- Supplier<T>
			
			3. Function > 매개변수O, 반환값O
				- Operator, Predicate 상위셋
				- Function<T,R>
				- BiFunction<T,U,R>
				- andThen()
				- compose()
			
			4. Operator > 매개변수O, 반환값O
				- Function 하위셋
				- 매개변수를 연산 후 반환 행동
				- BinaryOperator<T>
			
			5. Predicate > 매개변수O, 반환값O
				- Function 하위셋
				- 매개변수를 논리 연산 후 반환 행동
				- Predicate<T>
				- BiPredicate<T,U>
				- and()
				- or()
				- isEqual()
				- negate() > not
			
			
			
			자바의 인터페이스
			- final 상수
			- default 메소드
			- static 메소드
			
			다른 언어의 인터페이스
			- 추상 메소드를 가진다.
			- 구현 멤버를 가지지 못한다.(변수, 구현 메소드)
			
			
			
		*/
		
		//요구사항] 아래의 메소드를 구현한 객체 1개가 필요하다.
		//1. 클래스 선언 > 객체 생성 :: 다회성 객체 생성 
		//2. 인터페이스 > 익명 객체 생성 :: 1회성 객체 생성
		//3. 인터페이스 > 람다식 사용 > 익명 객체 생성 :: 1회성 객체 생성
		
		//public int sum(int a, int b) {
		//	return a + b;
		//}
		
		
		//*** 람다식을 왜 사용합니까? > 생산성
		//   > 메소드를 간단하게 만들기 위해서(짧게 코딩하려고..)
		//   > 익명 객체 특징 포함(1회용 객체를 생성할 때)
		//Test t = (a, b) -> a + b;
				
		//int result = t.sum(10, 20);
		//System.out.println(result);
		
		
		//m1();
		//m2();
		//m3();
		//m4();
		//m5();
		m6();
		
		
	}//main

	private static void m6() {
		
		//표준 API 함수형 인터페이스의 정적,디폴트 메소드
		//- 일종의 람다 객체들의 연산자 역할
		
		Calendar c = Calendar.getInstance();
		c.set(2020, 5, 10);
		User hong = new User("1", "홍길동", 25, "사원", c);
		
		//업무1.
		Consumer<User> c1 = user -> System.out.println("이름: " + user.getName());
		c1.accept(hong);
		
		//업무2.
		Consumer<User> c2 = user -> System.out.println("나이: " + user.getAge());
		c2.accept(hong);
		System.out.println();
		
		//요구사항] 업무1과 업무2를 동시에 실행
		//c1.accept(hong);
		//c2.accept(hong);
		
		//aaa(hong, c1, c2);
		
		//Consumer(c1) + Consumer(c2) = Consumer(c3)
		Consumer<User> c3 = c1.andThen(c2);
		c3.accept(hong);
		System.out.println();
		
		//c1 + c2 + c4
		Consumer<User> c4 = user -> System.out.println(user.getPosition());
		
		
		Consumer<User> c5 = c1.andThen(c2).andThen(c4); //c1 + c2 + c4
		c5.accept(hong);
		
		Consumer<User> c6 = c3.andThen(c4); //(c1 + c2) + c4
		c6.accept(hong);
		System.out.println();
		
		Consumer<User> c7 = c2.andThen(c1);
		c7.accept(hong);
		System.out.println();
		System.out.println();
		System.out.println();
		

		Function<Integer,Boolean> f1 = num -> num > 0;
		System.out.println(f1.apply(10));
		
		
		Function<Boolean,String> f2 = result -> result ? "성공입니다." : "실패";
		System.out.println(f2.apply(true));
		
		
		//Function + Function = Function
		//f1 + f2 = f3
		Function<Integer,String> f3 = f1.andThen(f2);
		System.out.println(f3.apply(10));
		
		
		Function<String,Integer> f4 = str -> str.length();
		
		
		//f1 + f2 + f4
		//Function<Integer,Integer> f5 = f1.andThen(f2).andThen(f4);
		Function<Integer,Integer> f5 = f3.andThen(f4);
		System.out.println(f5.apply(10)); 
		
		
		Function<Integer,String> f6 = num -> num > 0 ? "참" : "거짓";
		Function<String,Integer> f7 = str -> str.length();
		
		Function<Integer,Integer> f8 = f6.andThen(f7); //f6 > f7
		Function<Integer,Integer> f9 = f7.compose(f6); //f6 > f7
				
		System.out.println(f8.apply(10));
		System.out.println(f9.apply(10));
		
		
		
		//2의 배수
		Predicate<Integer> p1 = num -> num % 2 == 0;
		
		//3의 배수
		Predicate<Integer> p2 = num -> num % 3 == 0;
		
		int a = 10;
		
		System.out.println(p1.test(a));
		System.out.println(p2.test(a));
		
		//p1 and p2
		Predicate<Integer> p3 = p1.and(p2);
		System.out.println(p3.test(a));  //false
		System.out.println(p3.test(12)); //true
		
		//p1 or p2
		Predicate<Integer> p4 = p1.or(p2);
		System.out.println(p4.test(a));
		
		//!p1
		Predicate<Integer> p5 = p1.negate();
		System.out.println(p5.test(a));
		
		
		//A && B
		//A || B
		//!A
		
		
		
		
	}

	private static void aaa(User hong, Consumer<User> c1, Consumer<User> c2) {
		c1.accept(hong);
		c2.accept(hong);
	}
	
	

	private static void m5() {
		
		//Predicate
		//- 매개변수를 전달하면 처리 후 반환값을 돌려주는 업무를 구현
		//- testXXX() 추상 메소드 제공
		//- 매개변수를 전달받아 논리 검사 진행 > Boolean 반환
		
		Function <Integer,Boolean> f1 = num -> num > 0;
		Predicate<Integer>         p1 = num -> num > 0;
		
		System.out.println(f1.apply(10));
		System.out.println(f1.apply(-10));
		
		System.out.println(p1.test(10));
		System.out.println(p1.test(-10));
		
		
		BiPredicate<String, String> p2 = (s1, s2) -> s1.length() > s2.length();
		System.out.println(p2.test("홍길동", "홍아무개"));
		
		
	}

	private static void m4() {
		
		//Operator
		//- 매개변수를 전달하면 처리 후 반환값을 돌려주는 업무를 구현
		//- applyXXX() 추상 메소드 제공
		//- 추상 메소드의 매개변수와 반환값이 동일하다.
		
		
		//매개변수 2개 + 반환값 1개
		BinaryOperator<Integer> bo1 = (a, b) -> a * b;
		System.out.println(bo1.apply(10, 20));
		
		BiFunction<Integer, Integer, Integer> bf1 = (a, b) -> a * b;
		System.out.println(bf1.apply(10, 20));
		
		
		BinaryOperator<String> bo2 = (s1, s2) -> s1 + s2;
		System.out.println(bo2.apply("홍", "길동"));
		
		
	}

	private static void m3() {
		
		//Function 
		//- 매개변수를 전달하면 처리 후 반환값을 돌려주는 업무를 구현
		//- applyXXX() 추상 메소드 제공
		
		//Function<Integer,Double>
		//IntToDoubleFunction
		
		Function<Integer,Boolean> f1 = num -> num > 0;
		System.out.println(f1.apply(10));
		System.out.println(f1.apply(-10));
		
		Function<String,Integer> f2 = str -> str.length();
		System.out.println(f2.apply("홍길동"));
		System.out.println(f2.apply("홍길동님"));
		
		Function<User,String> f3 = user -> {
			if (user.getPosition().equals("사원") || user.getPosition().equals("대리") ) {
				return "사원급";
			} else {
				return "간부급";
			}
		};
		
		System.out.println(f3.apply(new User("1", "홍길동", 25, "대리", null)));
		System.out.println(f3.apply(new User("1", "홍길동", 25, "차장", null)));
		
		//BiFunction<첫번째 매개변수, 두번째 매개변수, 반환값>
		BiFunction<Integer, Integer, String> bf1 = (a, b) -> a > b ? "크다" : "작다";
		System.out.println(bf1.apply(10, 5));
		System.out.println(bf1.apply(5, 10));
		
		
		
	}

	private static void m2() {
		
		//Supplier
		//- 매개변수 없이 반환값을 돌려주는 업무를 구현
		//- getXXX() 추상 메소드 제공
		
		Supplier<Integer> s1 = () -> 100;
		System.out.println(s1.get());
		
		Supplier<Double> s2 = () -> Math.random();
		System.out.println(s2.get());
		
		Supplier<String> s3 = () -> "홍길동";
		System.out.println(s3.get());
		
		Supplier<Integer> s4 = () -> {
			Calendar c = Calendar.getInstance();
			return c.get(Calendar.HOUR_OF_DAY);
		};
		System.out.println(s4.get());
		
		Supplier<User> s5 = () -> new User("1", "홍길동", 25, "사원", null);
		System.out.println(s5.get());
		
		
		
	}

	private static void m1() {
		
		//Consumer
		//- 매개변수를 받아서 소비하는 업무를 구현
		//- acceptXXX() 추상 메소드 제공
		
		//The target type of this expression must be a functional interface
		MyConsumer m1 = num -> System.out.println(num * num);
		
		m1.test(10);
		m1.test(5);
		
		
		Consumer<Integer> c1 = num -> System.out.println(num * num);
		
		c1.accept(3);
		c1.accept(4);
		
		
		Consumer<String> c2 = str -> System.out.println(str.length());
		
		c2.accept("홍길동");
		c2.accept("안녕하세요. 반갑습니다.");
		
		
		Consumer<Integer> c3 = count -> {
			for (int i=0; i<count; i++) {
				System.out.println(i);
			}
			System.out.println();
		};
		
		c3.accept(5);
		
		
		Consumer<User> c4 = user -> {
			System.out.println("이름: " + user.getName());
			System.out.println("나이: " + user.getAge());
			System.out.println("직급: " + user.getPosition());
		};
		
		c4.accept(new User("1", "홍길동", 20, "사원", null));
		
		
		BiConsumer<String, Integer> bc1 = (name, age) -> {
			System.out.printf("이름: %s, 나이: %d세\n", name, age);
		};
		
		bc1.accept("홍길동", 25);
		
		
		//Consumer<Integer>
		IntConsumer ic1 = num -> System.out.println(num * 2);
		ic1.accept(100);
		
		
		
		
	}//main

}//Ex74



//함수형 인터페이스(목적: 람다식을 저장하려고 만든 인터페이스)
// > 함수형 인터페이스는 반드시 추상 메소드를 딱 1개만 가질 수 있다. > 이 1개의 추상 메소드가 곧 람다식(익명 메소드)이 되기 때문에..
@FunctionalInterface  //1. 남에게 역할 알리기 위해 2. 문법 체크(추상 메소드 1개인지 검사)
interface MyConsumer {
	void test(int num);
}



//인터페이스 자체가 필요해서 만든 인터페이스 아니라
// 람다식을 저장해야할 참조 변수가 필요해서 만든 인터페이스
interface Test {
	int sum(int a, int b);
	
	//public int a;
	final public int b = 20; //상수는 객체 멤버 의미 < 공용 멤버 의미
	final public static int c = 30;
	
	//public void aaa() {
		
	//}
	
	public static void bbb() { //개인 행동 > 모두의 행동  
		
	}
	
	default void ccc() {
		
	}
}




























