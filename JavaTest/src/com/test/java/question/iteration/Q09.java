package com.test.java.question.iteration;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q09 {
	
	public static void main(String[] args) throws Exception {
		
		//1. 버퍼드리더 생성
		//2. 난수 생성(1~10)
		//3. 횟수 저장할 count 변수 생성 (바로 맞춰도 1회 시도니까 1로 변수 저장)
		//4. 무한 루프 for문 생성
		//5. if 문 이용하여 맞거나 틀렸을 경우 출력
		//6. 10회 이상하면 종료를 위해 count == 10 일때 종료하는 else if문 생성
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int computerNum = (int)(Math.random() * 10 + 1);
		System.out.println("컴퓨터가 1~10 사이의 숫자를 1개 생각했습니다.\n");
		int count = 1;
		
		for (;;) {
			
			System.out.print("숫자:");
			int inputNum = Integer.parseInt(reader.readLine());
			
			if (inputNum == computerNum) {
				System.out.println("맞았습니다.\n");
				
				break;
			} else if (count == 10) {
				System.out.println("틀렸습니다.\n");
				break;
			} else {
				System.out.println("틀렸습니다.\n");
				count += 1;
			}
			
		}
		
		System.out.printf("컴퓨터가 생각한 숫자는 %d입니다.\n", computerNum);
		System.out.printf("정답을 맞추는데 시도한 횟수는 %d회입니다.\n\n", count);
		System.out.println("프로그램을 종료합니다.");
		
	}//main

}
