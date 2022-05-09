package com.test.java.collection;

import java.util.ArrayList;
import java.util.HashMap;

public class Ex60 {
	
	public static void main(String[] args) {
		
		//ArrayList + HashMap

		//학생 성적 처리
		
		//학생(국어,영어,수학) x N명
		
		//국어, 영어, 수학 > 한곳에 저장할 자료형
		//1. 배열(ArrayList)
		//2. HashMap
		//3. 클래스
		
		//Case 1. Array(ArrayList)
		//- 루프 사용
		//- 비용 낮음
		//- 가독성 문제 > 과목을 식별 > 방번호
		int[] score = new int[3];
		
		score[0] = 100; //국어
		score[1] = 90;	//영어
		score[2] = 80;	//수학
		
		
		//Case 2. HashMap
		HashMap<String,Integer> scoreMap = new HashMap<String,Integer>();
		//- 가독성 높음 > 과목을 이름(key)으로 식별
		//- 루프 사용 불가능
		//- 비용 낮음 > 틀을 안만들어서 > 단점!!!
		
		scoreMap.put("국어", 100);
		scoreMap.put("영어", 90);
		scoreMap.put("수학", 80);
		
		HashMap<String,Integer> scoreMap2 = new HashMap<String,Integer>();
		
		scoreMap2.put("극이", 100);
		scoreMap2.put("영어", 90);
		scoreMap2.put("수학", 80);
		
		
		//Case 3. Class
		Score scoreObject = new Score();
		
		scoreObject.set국어(100);
		scoreObject.set영어(90);
		scoreObject.set수학(80);
		
		Score scoreObject2 = new Score();
		
		scoreObject2.set국어(100);
		scoreObject2.set영어(90);
		scoreObject2.set수학(80);
		
		
		//HashMap & Class
		//- 내부 요소를 이름으로 구분(***)
		//- 생산 비용이 다르다
		
		
		
		
		
		
		//학생 x 3명
		//HashMap<String,Integer>[] list = new HashMap<String,Integer>[3];
		
		//2차원 배열
		ArrayList<HashMap<String,Integer>> list
			= new ArrayList<HashMap<String,Integer>>();
		
		HashMap<String,Integer> s1 = new HashMap<String,Integer>();
		s1.put("국어", 100);
		s1.put("영어", 90);
		s1.put("수학", 80);
		
		list.add(s1); //2차원배열.add(1차원배열)
		
		HashMap<String,Integer> s2 = new HashMap<String,Integer>();
		s2.put("국어", 95);
		s2.put("영어", 95);
		s2.put("수학", 75);
		
		HashMap<String,Integer> s3 = new HashMap<String,Integer>();
		s3.put("국어", 85);
		s3.put("영어", 65);
		s3.put("수학", 77);
		
		list.add(s2);
		list.add(s3);
		
		//[
		//	{국어=100, 수학=80, 영어=90}, 
		//	{국어=95, 수학=75, 영어=95}, 
		//	{국어=85, 수학=77, 영어=65}
		//]

		System.out.println(list);
		
		
		
		
	}//main

}

//Case 3. Class
//- 가독성 높음, HashMap 유사
//- 멤버에 루프 적용 불가능, HashMap 유사
//- 비용 높음

class Score {
	
	private int 국어;
	private int 영어;
	private int 수학;
	
	public int get국어() {
		return 국어;
	}
	public void set국어(int 국어) {
		this.국어 = 국어;
	}
	public int get영어() {
		return 영어;
	}
	public void set영어(int 영어) {
		this.영어 = 영어;
	}
	public int get수학() {
		return 수학;
	}
	public void set수학(int 수학) {
		this.수학 = 수학;
	}
	
}




















































