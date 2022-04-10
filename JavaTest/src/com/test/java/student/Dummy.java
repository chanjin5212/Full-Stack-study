package com.test.java.student;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;

public class Dummy {
	
	public static void main(String[] args) {
		
		//데이터 생성용
		try {
			
			//createStudent();
			createScore();
						
		} catch (Exception e) {
			System.out.println("Dummy.main");
			e.printStackTrace();
		}
	}


	private static void createStudent() throws Exception {
		
		//번호,이름,나이,성별,주소
		//1,홍길동,15,1,서울시 강남구 역삼동
		
		Random rnd = new Random();
		//System.out.println(rnd.nextInt()); // -21억 ~ 21억
		//System.out.println(rnd.nextInt(50)); // 0~50
		
		int size = 20;
		String[] name1 = { "김", "이", "박", "최", "정", "한", "유", "민", "고", "주"};
		String[] name2 = { "길", "동", "경", "지", "원", "미", "성", "광", "연"
				, "수", "석", "재", "형"};
		String[] address1 = { "서울시", "인천시", "부산시", "제주시", "대구시" };
		String[] address2 = { "강남구", "강동구", "강서구", "강북구", "중구" };
		String[] address3 = { "역삼동", "대치동", "압구정동", "등촌동", "천호동" };
		
		
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(DataPath.학생));
		for (int i=0; i<size; i++) {
			
			int seq = i + 1;
			
			String name = name1[rnd.nextInt(name1.length)]
						+ name2[rnd.nextInt(name2.length)]
						+ name2[rnd.nextInt(name2.length)];
			int age = rnd.nextInt(3) + 14;
			int gender = rnd.nextInt(2) + 1;
			String address = address1[rnd.nextInt(address1.length)] 
						   + " "
						   + address2[rnd.nextInt(address2.length)] 
						   + " "
						   + address3[rnd.nextInt(address3.length)]
						   + " "
						   + (rnd.nextInt(30) + 1) + "번지";
			
			//System.out.println(seq + "," + name + "," + address);
			
			writer.write(String.format("%d,%s,%d,%d,%s\n", seq, name, age, gender, address));
			
		}
		
		writer.close();
		
		System.out.println("생성 완료");
		
		
	}

	private static void createScore() throws Exception {
		
		//학생 20명 > 성적
		//1,100,80,90
		
		
		//학생 18명 > 성적 3회 분량
		
		String temp = ""; //누적 변수
		
		Random rnd = new Random();
		
		for (int j=0; j<3; j++) {
			
			BufferedReader reader = new BufferedReader(new FileReader(DataPath.학생));
			
			String line = null;
			while ((line = reader.readLine()) != null) {
				
				String seq = line.split(",")[0];
				
				int kor = rnd.nextInt(51) + 50;
				int eng = rnd.nextInt(51) + 50;
				int math = rnd.nextInt(51) + 50;
				
				temp += String.format("%s,%d,%d,%d\n", seq, kor, eng, math);
				System.out.println(temp);
							
			}//while
			
		}//for
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(DataPath.성적));
		writer.write(temp);
		writer.close();
		
		System.out.println("등록 완료");
	}
}

















