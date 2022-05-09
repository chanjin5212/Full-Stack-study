package com.test.java;

import java.util.Arrays;
import java.util.Comparator;

public class Ex26_array {

	public static void main(String[] args) {
		
		//Ex26_array.java
		
		//정렬, Sort
		//1. 오름차순 정렬
		//2. 내림차순 정렬
		
		//배열 = 순서가 있는 집합
		
		
		//정렬하는 방법
		//1. 직접 구현
		//- 수많은 정렬 알고리즘 > 10여가지
		//- 버블 정렬
		
		//2. 구현된 기능 활용(JDK) > Quick Sort
		
		
		
		//m1();
		//m2();
		m3();
		//m4();
		
	}//main

	private static void m4() {
		
		
		int[] nums = { 5, 3, 1, 4, 2 };
		
		String[] name = { "유재석", "정형돈", "박나래", "하하", "박명수" };
		
		
		//오름차순 정렬 > 공식적 메소드O
		//내림차순 정렬 > 공식적 메소드X
		System.out.println(Arrays.toString(nums));
		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));
		
//		Integer[] nums2 = { 5, 3, 1, 4, 2 };
//		Arrays.sort(nums2, new Comparator<Integer>() {
//			@Override
//			public int compare(Integer o1, Integer o2) {
//			
//				return o2 - o1;
//			}
//		});
//		System.out.println(Arrays.toString(nums2));
		
				
		System.out.println(Arrays.toString(name));
		Arrays.sort(name);
		System.out.println(Arrays.toString(name));
		
		
		
		
	}

	private static void m3() {
		
		String[] name = { "유재석", "정형돈", "박나래", "하하", "박명수" };
		
		System.out.println(Arrays.toString(name)); //정렬 전
		
		for (int i=0; i<name.length-1; i++) {
			
			for (int j=0; j<name.length-1-i; j++) {
				
				//** 비교?
				if (name[j].compareTo(name[j+1]) > 0) {
					
					String temp = name[j];
					name[j] = name[j+1];
					name[j+1] = temp;
					
				}
				
			}
			
		}
		
		System.out.println(Arrays.toString(name)); //정렬 후
		
		
		
	}

	private static void m2() {
		
		//정렬
		//1. 숫자 > 우위 비교
		//2. 문자(열) > 문자 코드값
		//3. 날짜 > 과거 vs 미래 > tick
		
		
		String[] name = { "유재석", "정형돈", "박나래", "하하", "박명수" };
		
		//모든 참조형은 산출(비교)연산자의 피연산자가 될 수 없다.
//		if (name[0] > name[1]) {
//			
//		}
		
		
//		System.out.println((int)name[0].charAt(0)); //유재석
//		System.out.println((int)name[0].charAt(1));
//		System.out.println((int)name[0].charAt(2));
		
		
		String name1 = "유재석";
		String name2 = "김형돈";
		
		String result = "";
		
		//**** 문자열의 우위 비교는 문자열내의 문자들의 문자코드값으로 비교한다.
		
		for (int i=0; i<3; i++) { //이름 3글자
			
			char c1 = name1.charAt(i);
			char c2 = name2.charAt(i);
			
			if (c1 > c2) {
				result = name1;
				break; //for 탈출 > 다음 글자는 비교할 필요없어서..
			} else if (c1 < c2) {
				result = name2;
				break;
			}
			
		}
		
		System.out.println(result);
		
		
		
		name1 = "가가가";
		name2 = "가가가";
		
		//name1 > name2 : 양수 반환
		//name1 < name2 : 음수 반환
		//name1 = name2 : 0 반환
		System.out.println(name1.compareTo(name2)); //int
		
		
	}

	private static void m1() {
		
		int[] nums = { 5, 3, 1, 4, 2 };

		//오름차순 정렬 > { 1, 2, 3, 4, 5 } 재배치
		
		//버블 정렬
		//i(0) > j(0  1  2  3)
		//i(1) > j(0  1  2)
		//i(2) > j(0  1)
		//i(3) > j(0)
		
		System.out.println(Arrays.toString(nums)); //정렬 전
		
		for (int i=0; i<nums.length-1; i++) {
			
			for (int j=0; j<nums.length-i-1; j++) {
				
				//if (nums[j] > nums[j+1]) {  //오름차순 정렬
				if (nums[j] < nums[j+1]) {    //내림차순 정렬
					
					int temp = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = temp;
					
				}
			}
		}
		
		System.out.println(Arrays.toString(nums)); //정렬 후
		
		
		
		
	}
	
}























