package com.test.java.question.multipleloops;

public class Q10 {

	public static void main(String[] args) {
		
		//1. 10씩 커지는 for문 생성
		//2. 더한 값 저장할 sum 변수 생성
		//3. 9번 문제와 다르게 다중for문 2번째 for문에 j=1+i, j<=i+10 으로 설정
		//4. 출력


		for (int i = 0; i < 100; i += 10) {

			int sum = 0;
			
			for (int j=1+i; j<=i+10; j++) {
				sum += j;
			}
			System.out.printf("%2d ~ %3d : %3d\n", 1 + i, i + 10, sum);



		}

	}

}
