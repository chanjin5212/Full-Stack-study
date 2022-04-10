package com.test.java.question.arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q02 {
	
	public static void main(String[] args) throws Exception {
		
		//1. 버퍼드리더 생성
		//2. 학생수 입력받기
		//3. 입력받은 학생수로 배열크기 정하기
		//4. 학생명 입력받아 배열에 저장
		//5. 배열을 오름차순으로 정리한 후 for문 이용하여 출력
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("학생 수:");
		int studentNum = Integer.parseInt(reader.readLine());
		
		String[] students = new String[studentNum];
		
		for (int i=0; i<students.length; i++) {
			
			System.out.print("학생명:");
			String name = reader.readLine();
			students[i] = name;
			
		}
		Arrays.sort(students);
		
		System.out.printf("입력한 학생은 총 %d명입니다.\n", studentNum);
		for (int i=0; i<students.length; i++) {
			System.out.printf("%d. %s\n", i + 1, students[i]);
		}
		
	}

}
