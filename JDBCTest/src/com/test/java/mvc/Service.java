package com.test.java.mvc;

import java.util.ArrayList;
import java.util.Scanner;
import mylibrary.db.DBUtil;

//Address 업무 담당 객체
//1. 쓰기
//2. 읽기
//3. 수정
//4. 삭제
public class Service {
	
	public void start() {
		
		boolean loop = true;
		Scanner scan = new Scanner(System.in);
		
		while (loop) {
			View view = new View();
			view.menu();
			
			String input = scan.nextLine();
			
			if (input.equals("1")) {
				add();
			} else if (input.equals("2")) {
				list();
			} else if (input.equals("3")) {
				edit();
			} else if (input.equals("4")) {
				del();
			} else {
				loop = false;
			}
			
		}
		
		
	}

	private void add() {
		
		System.out.println("[주소록 등록하기]");
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("이름: ");
		String name = scan.nextLine();
		
		System.out.print("나이: ");
		String age = scan.nextLine();
		
		System.out.print("성별(m,f): ");
		String gender = scan.nextLine();
		
		System.out.print("전화: ");
		String tel = scan.nextLine();
		
		System.out.print("주소: ");
		String address = scan.nextLine();
		
		
		//DB 담당자
		DAO dao = new DAO();
		
		//Service -> (데이터) -> DAO
		Address dto = new Address();
		
		dto.setName(name);
		dto.setAge(age);
		dto.setGender(gender);
		dto.setTel(tel);
		dto.setAddress(address);
		
		
		int result = dao.add(dto); //1.성공, 0.실패
		
		if (result == 1) {
			//성공
			System.out.println("주소록 등록을 완료했습니다");
			pause();
		} else {
			//실패
			
		}
		
		
		
		
	}

	private void list() {
		
		System.out.println("[주소록 목록보기]");
		
		//1. DB 위임 > DB > select > rs
		//2. 결과셋 반환
		//3. View에게 전달 + 출력
		
		DAO dao = new DAO();
		
		
		//*** DB 담당자 > JDBC 코드 관리 > DAO
		//*** Service 담당자 > JDBC 코드 관리
		//************* Connection, Statement, ResultSet > 반드시 DAO.java에서만 코딩
		//ResultSet rs = dao.list();
		
		//Address > 레코드
		//ArrayList > 테이블
		ArrayList<Address> list = dao.list();
		
		View view = new View();
		view.list(list);
		
		
		
		pause();
		
	}

	private void edit() {
		
		System.out.println("[주소록 수정하기]");
		
		//수정할 번호 > 입력 > 현재 내용 출력 > 수정할 데이터 입력
		Scanner scan = new Scanner(System.in);
		
		System.out.print("수정할 번호: ");
		String seq = scan.nextLine();
		
		DAO dao = new DAO();
		
		Address dto = dao.get(seq);
		
		System.out.println("이름: " + dto.getName());
		System.out.println("나이: " + dto.getAge());
		System.out.println("성별: " + dto.getGender());
		System.out.println("전화: " + dto.getTel());
		System.out.println("주소: " + dto.getAddress());
		System.out.println();
		
		
		System.out.println("수정할 항목(수정하지 않으려면 입력하지 않고 엔터)");
		System.out.print("이름: ");
		String name = scan.nextLine();
		
		if (!name.equals("")) {
			dto.setName(name); //수정
		}
		
		
		System.out.print("나이: ");
		String age = scan.nextLine();
		
		if (!age.equals("")) {
			dto.setAge(age);
		}
		
		System.out.print("성별: ");
		String gender = scan.nextLine();
		
		if (!gender.equals("")) {
			dto.setGender(gender);
		}
		
		System.out.print("전화: ");
		String tel = scan.nextLine();
		
		if (!tel.equals("")) {
			dto.setTel(tel);
		}
		
		System.out.print("주소: ");
		String address = scan.nextLine();
		
		if (!address.equals("")) {
			dto.setAddress(address);
		}
		
		
		//DB -> update
		int result = dao.edit(dto);
		
		if (result == 1) {
			System.out.println("주소록 수정을 완료했습니다.");
		} else {
			System.out.println("주소록 수정을 실패했습니다.");
		}
		
		
		
		
		pause();
		
	}

	private void del() {
		
		System.out.println("[주소록 삭제하기]");
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("삭제할 번호: ");
		String seq = scan.nextLine();
		
		DAO dao = new DAO();
		
		int result = dao.del(seq);
		
		if (result == 1) {
			System.out.println("주소록 삭제를 완료했습니다.");
		} else {
			System.out.println("주소록 삭제를 실패했습니다.");
		}
		
		pause();
		
	}
	
	private void pause() {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("계속하려면 엔터를 입력하세요.");
		scan.nextLine();
		
	}

}
