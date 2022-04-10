package com.test.java.question.iteration2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q05 {
	
	public static void main(String[] args) throws Exception {
		
		//1. 버퍼드리더 생성
		//2. 제시된 지문이 계속 진행되므로 while(true) 무한루프 생성
		//3. 제시된 지문처럼 자판기 만들기
		//4. 금액과 음료번호 입력받기
		//5. 선택한 음료 번호에 따른 가격을 저장할 price 변수 생성
		//6. if문과 switch문으로 지문에 나온대로 출력
		//7. 엔터입력 을 위한 reader 생성
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			int coke = 700;
			int cider = 600;
			int vita = 500;
			System.out.println("====================");
			System.out.println("       자판기");
			System.out.println("====================");		
			System.out.printf("1. 콜라 : %d원\n", coke);
			System.out.printf("2. 사이다 : %d원\n", cider);
			System.out.printf("3. 비타500 : %d원\n", vita);
			System.out.println("--------------------");
			System.out.print("금액 투입(원) : ");
			int money = Integer.parseInt(reader.readLine());
			System.out.println("--------------------");
			System.out.print("음료 선택(번호) : ");
			String choice = reader.readLine();
			
			int price = 0;
			switch(choice) {
				case "1":
					price = coke;
					break;
				case "2":
					price = cider;
					break;
				case "3":
					price = vita;
					break;
			}
			
			if (money - price < 0) {
				System.out.println("금액이 부족합니다.");
			} else {
				switch(choice) {
					case "1":
						System.out.println("+콜라를 제공합니다.");
						System.out.printf("+잔돈 %d원을 제공합니다\n", money - price);
						break;
					case "2":
						System.out.println("+사이다를 제공합니다.");
						System.out.printf("+잔돈 %d원을 제공합니다\n", money - price);
						break;
					case "3":
						System.out.println("+비타500을 제공합니다.");
						System.out.printf("+잔돈 %d원을 제공합니다\n", money - price);
						break;
						
				}

			}
			System.out.println();
			System.out.print("계속하시려면 엔터를 입력하세요.\n");
			String start = reader.readLine();
		}
		
		
	}

}
