package com.test.java.student;

import java.util.Scanner;

//정적 출력
public class Output {
	
	public static void title() {
		
		System.out.println("===============================");
		System.out.println("       학생 관리 프로그램");
		System.out.println("===============================");
		
	}
	
	public static void mainmenu() {
		
		System.out.println("1. 학생 등록하기");
		System.out.println("2. 학생 목록보기");
		System.out.println("3. 학생 검색하기");
		System.out.println("4. 종료");
		System.out.print("선택: ");
	}
	
	public static void close() {
		
		System.out.println("프로그램 종료");
		
	}
	
	public static void subtitle(String title) {
		System.out.println();
		System.out.println();
		System.out.println("-------------------------------");
		System.out.println("          " + title);
		System.out.println("-------------------------------");
	}

	public static void pause() {
		
		System.out.println("계속하시려면 [엔터]를 입력하세요.");
		
		//프로그램 일시 정지
		Scanner scan = new Scanner(System.in);
		
		scan.nextLine(); //블럭.. == 일시 정지
		
		
	}
	
	public static void submenu() {
		System.out.println("-------------------------------");
		System.out.println("1. 상세보기");
		System.out.println("2. 수정하기");
		System.out.println("3. 삭제하기");
		System.out.println("4. 돌아가기");
		System.out.println("-------------------------------");
		System.out.print("선택: ");
	}
	

}





















