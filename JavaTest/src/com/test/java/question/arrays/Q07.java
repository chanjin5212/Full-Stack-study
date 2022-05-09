package com.test.java.question.arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q07 {

	public static void main(String[] args) throws Exception {
		//1. 첫번째 방법
		//	1.1 배열에 값을 넣고자 하는 위치부터의 배열을 저장한다.
		//	1.2 저장한 배열을 값을 넣고자 하는 위치의 뒤에자리에 대입한다.(마지막 자리는 대입X)
		//	1.3 값을 넣고자 하는 위치에 넣는다.
		
		//2. 두번째 방법
		//	2.1 배열에 값을 넣고자 하는 위치부터 값을 뒤로 옮긴다.
		//	2.2 값을 넣고자 하는 위치에 넣는다.

		
		m1();
		//m2();
		
	}//main
	
	public static void m1() throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("삽입 위치 : ");
		int inNum = Integer.parseInt(reader.readLine());
		System.out.print("값 : ");
		int value = Integer.parseInt(reader.readLine());
		
		int[] array = {5, 6, 1, 3, 2, 8, 7, 4, 10, 9};
		
		System.out.printf("원본 : %s\n", Arrays.toString(array));
		int[] array1 = new int[10-inNum];
		
		
		for (int i=0; i<array1.length; i++) {
			array1[i] = array[i+inNum];
		}
		
		array[inNum] = value;
		
		for (int i=0; i<array1.length-1; i++) {
			array[inNum+1+i] = array1[i];
		}
		System.out.printf("결과 : %s\n", Arrays.toString(array));
		
	}
	
	public static void m2() throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("삽입 위치 : ");
		int inNum = Integer.parseInt(reader.readLine());
		System.out.print("값 : ");
		int value = Integer.parseInt(reader.readLine());
		
		int[] array = {5, 6, 1, 3, 2, 8, 7, 4, 10, 9};
		
		System.out.printf("원본:%s\n",Arrays.toString(array));
		
		for (int i=8; i>=inNum; i--) {
			array[i+1] = array[i];
		}
		array[inNum] = value;
		
		System.out.printf("결과:%s\n",Arrays.toString(array));
	}
	
}


