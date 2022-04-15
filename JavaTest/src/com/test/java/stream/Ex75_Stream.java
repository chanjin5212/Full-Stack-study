package com.test.java.stream;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import com.test.data.Data;
import com.test.data.User;

public class Ex75_Stream {
	
	public static void main(String[] args) {
		
		//com.test.java.stream > Ex75_Stream.java
		/*
		
			자바 스트림
			1. 입출력 스트림
				- 파일 입출력, 콘솔 입출력, 네트워크 입출력 등..
			
			2. 스트림
				- Java 8(JDK 1.8) + 람다식
				- 배열(컬렉션)의 탐색(조작) 지원 기술
				- 파일 입출력 지원
				- 디렉토리 탐색 지원
				- 익명 객체 필요 > 람다식 사용!!!
				- 스트림은 1회용(Iterator와 동일한 성질)
			
			
			배열, 컬렉션 탐색
			1. for문(루프변수)
			2. 향상된 for문
			3. iterator
			4. 스트림 
			
			
			람다식 + 표준 API 함수형 인터페이스
			- (매개변수) -> {구현부}
			- 익명 객체가 구현한 추상 메소드를 표현하는 표현식
			
			- 인터페이스 참조변수 = (매개변수) -> {구현부}  //정의
			- 참조변수.추상메소드()						//호출(사용)
			
			
			1. Consumer
				- (매개변수) -> {구현부}
				
			2. Supplier
				- () -> {return 값}
				
			3. Function
				- (매개변수) -> {return 값}
			
			4. Operator
				- (매개변수) -> {return 값}
				- 매개변수와 반환값이 자료형 동일
			
			5. Predicate
				- (매개변수) -> {return 값}
				- 반환값이 boolean
							
		
		*/
		
		//m1();
		//m2();
		//m3();
		m4();
		
	}//main

	private static void m4() {
		
		//스트림을 얻어오는 방법
		//- stream() 메소드를 사용한다.
		//1. 배열로부터
		//2. 컬렉션로부터
		//3. 숫자범위로부터
		//4. 파일로부터
		//5. 디렉토리로부터
		
		//1. 배열로부터
		int[] nums1 = { 10, 20, 30, 40, 50 };
		
		//nums1.stream()
		Arrays.stream(nums1).forEach(num -> System.out.println(num));
		System.out.println();
		
		
		//2. 컬렉션로부터
		ArrayList<Integer> nums2 = new ArrayList<Integer>();
		nums2.add(100);
		nums2.add(200);
		nums2.add(300);
		
		nums2.stream().forEach(num -> System.out.println(num));
		System.out.println();
		
		LinkedList<Integer> nums3 = new LinkedList<Integer>();
		nums3.add(1000);
		nums3.add(2000);
		nums3.add(3000);
		
		nums3.stream().forEach(num -> System.out.println(num));
		System.out.println();
		
		HashSet<Integer> nums4 = new HashSet<Integer>();
		nums4.add(10000);
		nums4.add(20000);
		nums4.add(30000);
		
		nums4.stream().forEach(num -> System.out.println(num));
		System.out.println();
		
		//HashMap<String,Integer> nums5 = new HashMap<String,Integer>();
		//nums5.keySet().stream()
		
		
		
		//3. 숫자범위로부터
		//Stream<Integer> : 범용 스트림 > forEach > Consumer<Integer>
		//IntStream       : 전용 스트림 > forEach > IntConsumer
		IntStream.range(1, 10).forEach(num -> System.out.println(num));
		System.out.println();
		
		
		
		
		try {
			
			//4. 파일로부터
			//- 스트림을 통해서 파일 읽기가 가능
			
			Path path = Paths.get("data\\number.txt");
			
			Files.lines(path).forEach(line -> System.out.println(line));
			System.out.println();
			
			
			
			//5. 디렉토리로부터
			//- 목록보기 > dir.listFiles()
			Path dir = Paths.get("C:\\class\\eclipse");
			
			Files.list(dir).forEach(p -> {
				System.out.println(p.getFileName());
				System.out.println(p.toFile().getName());
				System.out.println(p.toFile().isFile());
			});
			
			System.out.println();			
			
			
			
		} catch (Exception e) {
			System.out.println("Ex75_Stream.m4");
			e.printStackTrace();
		}
		
		
		
	}//m4

	private static void m3() {
		
		//함수형 프로그래밍 == 의식의 흐름
		Data.getIntList().stream().forEach(num -> System.out.printf("%4d", num));
		System.out.println();
		
		
		Data
			.getStringList()
			.stream()
			.forEach(str -> System.out.printf("%s(%d), ", str, str.length()));
		System.out.println();
		
		
		Data.getUserList().stream().forEach(user -> {
			System.out.println("[회원 정보]");
			System.out.println("이름: " + user.getName());
			System.out.println("나이: " + user.getAge());
			System.out.println("성별: " + ((user.getGender() == 1) ? "남자" : "여자"));
			System.out.println();			
		});
		System.out.println();
		
		
		Data.getItemList().stream().forEach(item -> {
			System.out.println(item.getName());
			System.out.println(item.getColor());
			System.out.println(item.getSize());
			System.out.printf("%tF", item.getDate());
			System.out.println();
			System.out.println();
		});
		
		
	}

	private static void m2() {
		
		//배열(컬렉션) 탐색
		List<String> list = Data.getStringList(30);
		
		//1. for문
		for (int i=0; i<list.size(); i++) {
			System.out.print(list.get(i) + "   ");
		}
		System.out.println();
		System.out.println();
		
		
		//2. 향상된 for문
		for (String word : list) { //stream.forEach
			System.out.print(word + "   "); //c1.accept() 호출 + 람다식
		}
		System.out.println();
		System.out.println();
		
		
		//3. iterator
		Iterator<String> iter = list.iterator();
		
		while (iter.hasNext()) {
			System.out.print(iter.next() + "   ");
		}
		System.out.println();
		System.out.println();
		
		
		//4. stream
		Stream<String> stream = list.stream();
		
		Consumer<String> c1 = (str) -> { System.out.println(str); };
				
		//forEach 메소드의 행동
		//1. stream을 얻어낸 데이터 소스(list) > 요소를 하나씩 가져온다.(향상된 for문처럼)  
		//2. 가져온 요소(데이터)를 Consumer의 매개변수로 전달해서 람다식(추상메소드)을 호출한다.
		stream.forEach(c1); //30회전
		stream.forEach(c1); //0회전
		stream.forEach(c1); //0회전
		
		//"애플아케이드" -> c1.accept("애플아케이드")
		//"국내" -> c1.accept("국내")
		//.. x 30번
		
		
	 	//Stream<String> stream2 = list.stream();
		
	 	//stream2.forEach((str) -> { System.out.println(str); });
	 	
		
		//함수형 프로그래밍 > 메소드 체인닝 > 문장이 길다(****)
	 	list.stream().forEach(str -> System.out.println(str)); //30회전
	 	list.stream().forEach(str -> System.out.println(str)); //30회전
	 	list.stream().forEach(str -> System.out.println(str)); //30회전
	 	
		
	}

	private static void m1() {
		
		int[] nums1 = Data.getIntArray();
		System.out.println(nums1.length);
		
		int[] nums2 = Data.getIntArray(10);
		System.out.println(nums2.length);
		
		List<Integer> nums3 = Data.getIntList();
		System.out.println(nums3.size());
		
		List<Integer> nums4 = Data.getIntList(5);
		System.out.println(nums4.size());
		
		String[] txt1 = Data.getStringArray(10);
		System.out.println(Arrays.toString(txt1));
		System.out.println(txt1.length);
		
		User[] list = Data.getUserArray(3);
		System.out.println(Arrays.toString(list));
		
	}
	
	
}//Ex75




















