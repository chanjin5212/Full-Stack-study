package com.test.java.question.multipleloops;

public class Q11 {
	
	public static void main(String[] args) {
		
		//1. 숫자를 점점 더해나갈 변수와 그 숫자의 합을 저장할 변수 1개를 만든다.
		//2. for문을 이용해 1씩 숫자를 더해 나간다
		//3. if문을 이용해 100이 넘으면 멈춘다
		//4. 출력
		
		
		int num = 1;
		int n = 1;
		int sum = 0;
		String numList = "";
	
		while (num < 100) {
			
			numList += num + " + ";
			sum += num;
			num += n;
			
			n++;
		}
		
		System.out.printf("%s = %d", numList + "\b\b", sum);
	}

}
