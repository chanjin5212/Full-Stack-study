package com.test.java.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import com.test.data.Data;
import com.test.data.User;

public class Ex76_Stream {
	
	public static void main(String[] args) {
		
		//Ex76_Stream.java
		
		/*
		  	
		  	
		  	스트림, Stream
		  	- 데이터 소스로부터 탐색/조작 가능한 도구
		  	- list.stream().forEach()
		  	
		  	파이프, pipe
		  	- 스트림 객체 메소드
		  	
		  	1. 중간 파이프
		  		- 반환값 > 스트림O
		  		
		  	2. 최종 파이프
		 		- 반환값 > 스트림X > void, 다른 자료형
		 		
		 		
		 	필터링
		 	- filter()
		 	- 중간처리 파이프
		 	- 앞의 스트림에서 조건에 맞는 요소만 남기고 맞지 않는 요소는 버린다. > 조건에 맞는 요소만
		 	남아있는 스트림을 반환하다.
		 	
		 
		 	처리
		 	- forEach()
		 	- 최종처리 파이프
		 	- 앞의 스트림에서 요소를 최종 처리하는 메소드
		 	
		 
		 
		 */
		
		//m1();
		//m2();
		//m3();
		m4();
		
		
		
		
		
		
		
		
	}

	private static void m4() {
		
		//매핑
		//- map(), mapXXX()
		//- 중간처리 파이프
		//- 변환 작업에 사용한다.(*******)
		//- map() >				   앞의 스트림을 처리 후 다른 타입의 스트림을 반환
		//- distinct(), filter() > 앞의 스트림 처리 후 동일한 타입의 스트림을 반환
		
		List<String> list = Data.getStringList(10);
		System.out.println(list);
		
		list.stream().filter(word -> word.length() <= 3).forEach(word -> System.out.println(word));
		System.out.println();
		
		list.stream()						//Stream<String>: 단어 스트림
				.map(word -> {				//Stream<Integer>: 단어 길이 스트림
					return word.length();
				}).forEach(num -> System.out.println(num));
		
		list.stream()
				//.filter(word -> word.length() >= 5)
				.map(word -> word.length())
				.forEach(length -> System.out.println(length));
		System.out.println();
		
		
		
		String[] names = { "홍길동", "홍재석", "테스트", "아무개", "하하하", "호호호", "후후후", "유재석", "박명수" };
		
		
		//mapping
		Arrays.stream(names)
				.map(name -> name.substring(1))
				.forEach(name -> System.out.println(name));
		System.out.println();
		
		
		List<User> ulist = Data.getUserList();
		
		//map() > 의도? > 원본 데이터를 다른 형태로 가공!!
		ulist.stream()
				//.map(user -> user.getName())
				.map(user -> user.getAge())
				.forEach(user -> System.out.println(user));
		
		System.out.println();
		
		List<Student> slist = new ArrayList<Student>();
		
		slist.add(new Student("가가가", 100, 90, 80));
		slist.add(new Student("나나나", 77, 88, 66));
		slist.add(new Student("다다다", 92, 82, 84));
		slist.add(new Student("라라라", 100, 92, 88));
		slist.add(new Student("마마마", 56, 47, 35));
		
		slist.stream()
				.map(s -> {
					int total = s.getKor() + s.getEng() + s.getMath();
					
					if (total >= 180) {
						return "합격";
					} else {
						return "불합격";
					}
				}) //Stream<Student> -> Stream<String>
				.forEach(result -> System.out.println(result));
		System.out.println();
		
		
		
	}

	private static void m3() {
		
		//중복 제거
		//- distinct()
		//- 중간처리 파이프
		//- 앞의 스트림에서 중복 요소를 제거한다. > 유일한 요소만 남아있는 스트림을 발현한다.
		//- Set의 성질과 유사
		
		System.out.println(Data.getIntList().size());
		
		
		List<Integer> list = Data.getIntList();
		
		//요구사항] 위의 배열에서 중복값 제거
		//Case 1.
		Set<Integer> set = new HashSet<Integer>();
		
		for (int n : list) {
			set.add(n);
		}
 		System.out.println(set.size());
 		
 		//Case 2.
 		//- ArrayList -> (변환) -> HashSet
 		Set<Integer> set2 = new HashSet<Integer>(list);
 		System.out.println(set2.size());
 		
 		
 		//Case 3.
 		//list.stream().distinct().forEach(n -> System.out.println(n));
 		System.out.println(list.stream().count());
 		System.out.println(list.stream().distinct().count());
 		
 		String[] names = { "홍길동", "아무개", "하하하", "홍길동", "호호호", "후후후", "홍길동" };
 		
 		Arrays.stream(names).distinct().forEach(name -> System.out.println(name));
		
 		
 		List<Cup> clist = new ArrayList<Cup>();
 		
 		
 		clist.add(new Cup(Cup.BLACK, 200));
 		clist.add(new Cup(Cup.WHITE, 300)); //1
 		clist.add(new Cup(Cup.RED,   400));
 		clist.add(new Cup(Cup.YELLOW,500));
 		clist.add(new Cup(Cup.BLUE,  600)); //2
 		clist.add(new Cup(Cup.BLACK, 700));
 		clist.add(new Cup(Cup.WHITE, 300)); //1
 		clist.add(new Cup(Cup.RED,   900));
 		clist.add(new Cup(Cup.YELLOW,1000));
 		clist.add(new Cup(Cup.BLUE,  600)); //2
 		
 		//*** 기본적으로 같은 자료형(클래스)의 객체가 동일한 값(상태)을 가지더라고 다른 객체이다.
 		//	  > 두 객체는 독립적으로 존재한다. (메모리 주소가 다르다.) == 쌍둥이
 		
 		clist.stream().distinct().forEach(cup -> System.out.println(cup));
 		
 		
 		//Set, distinct() > 중복 객체를 제거하려면
 		
 		
 		
	}

	private static void m2() {
		
		Data.getStringList().stream()
			.filter(word -> word.length() > 5)
			.forEach(word -> System.out.println(word));
		System.out.println();
		
		Data.getUserList().stream()
				.filter(user -> user.getWeight() >= 70)
				.filter(user -> user.getGender() == 1)
				.filter(user -> user.getHeight() >= 180)
				.forEach(user -> System.out.println(user));
		System.out.println();
		
	}

	private static void m1() {
		List<Integer> list = Data.getIntList(20);
		System.out.println(list);
		
		//짝수만 출력
		for (int i=0; i<list.size(); i++) {
			if (list.get(i) % 2 == 0) {
				System.out.printf("%4d", list.get(i));				
			}
		}
		System.out.println();
		
		for (int n : list) {
			if (n % 2 == 0) {
				System.out.printf("%4d", n);				
			}
		}
		System.out.println();
		
		
		list.stream().forEach(n -> {
			if (n % 2 == 0) {
				System.out.printf("%4d", n);
			}
		});
		System.out.println();
		
		//1. list stream() > 20개의 숫자 탐색
		//2. filter(조건) > 20개의 숫자를 조건 검사 > true 요소들만 가지고 새로운 Stream 생성
		//3. forEach(소비) > 짝수만 들어있는 Stream을 소비
		list.stream().filter(n -> {
			if (n % 2 == 0) {
				return true;
			} else {
				return false;
			}
		}).forEach(n -> System.out.printf("%4d", n));
		System.out.println();
		
		
		list.stream().filter(n -> n % 2 == 0).forEach(n -> System.out.printf("%4d", n));
		System.out.println();
		
		
		list.stream()
				.filter(n -> n % 2 == 0)
				.filter(n -> n >= 50)
				.forEach(n -> System.out.printf("%4d", n));
		System.out.println();
	}

}//Ex76

class Cup {
	
	public static final int BLACK = 1;
	public static final int WHITE = 2;
	public static final int RED = 3;
	public static final int YELLOW = 4;
	public static final int BLUE = 5;
	
	
	private int color;
	private int size;
	
	public Cup(int color, int size) {
		this.color = color;
		this.size = size;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return String.format("Cup [color=%s, size=%s]", color, size);
	}
	
	//개발자의 의도대로 Cup 객체를 비교하기 위해서..
	//1. hashCode() 재정의
	//2. equals() 재정의
	@Override
	public int hashCode() {
		//비교하려는 객체의 상태(멤버 변수값)를 가지고 해시코드 생성 + 반환
		
		return ("" + this.color + this.size).hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		
		return this.hashCode() == obj.hashCode();
	}
	
}



class Student {
	
	private String name;
	private int kor;
	private int eng;
	private int math;
	
	//생성자, Getter/Setter, toString
	
	public Student(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	@Override
	public String toString() {
		return String.format("Student [name=%s, kor=%s, eng=%s, math=%s]", name, kor, eng, math);
	}
	
	
	
}



















