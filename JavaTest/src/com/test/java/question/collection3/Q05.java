package com.test.java.question.collection3;


public class Q05 {
	
	public static void main(String[] args) {
		
		//배열 생성
		MySet list = new MySet();

		//추가
		list.add("홍길동");
		list.add("아무개");
		list.add("하하하");

		//개수
		System.out.println(list.size());

		//삭제
		list.remove("아무개");

		//개수
		System.out.println(list.size());

		//탐색 + 읽기
		while (list.hasNext()) {
		      System.out.println(list.next());
		}

		//초기화
		list.clear();
		System.out.println(list.size());
		
	}

}
