package com.test.java.question.iteration;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q06 {
	
	public static void main(String[] args) throws Exception {
		
		//1. 버퍼드리더 생성
		//2. 숫자 입력받기
		//3. 입력받은 숫자 더할 sum 변수 생성
		//4. for문 생성
		//4. 처음 시작을 더하기 때문에 홀수번째는 더하고 짝수번째는 빼야한다 이걸 위해 flag 라는 변수를 1로 생성하여 for문이 한번 실행할때 마다 -1를 곱해서
		//   더하고 빼기를 실행한다.
		//5. 출력
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("시작 숫자:");
		int startNum = Integer.parseInt(reader.readLine());
		System.out.print("종료 숫자:");
		int endNum = Integer.parseInt(reader.readLine());
		
		int sum = 0;
		int flag = 1;
		
		for (int i=startNum; i<=endNum; i++) {
			
			if (i == endNum) {
				System.out.printf("%d = ", i);
			} else if (flag > 0) {
				System.out.printf("%d - ", i);
			} else {
				System.out.printf("%d + ", i);
			}
			
			sum += (i * flag);
			flag = flag * -1;
			
		}
		System.out.println(sum);
		
		
		
	}//main

}
