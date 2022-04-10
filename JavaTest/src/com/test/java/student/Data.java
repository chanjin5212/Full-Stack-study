package com.test.java.student;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

//파일 데이터 <-> 메모리(배열)
public class Data {
	
	//프로그램 전역(전체)에서 사용하게 될 자원(데이터)은 static로 선언하면 편리하다.
	public static ArrayList<Student> slist = new ArrayList<Student>();
	public static ArrayList<Score> clist = new ArrayList<Score>();
	
	public static void load() {
		try {
			
			//학생.txt -> slist
			BufferedReader reader = new BufferedReader(new FileReader(DataPath.학생));
			
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				//번호,이름,나이,성별,주소
	  			//1,홍길동,15,1,서울시 강남구 역삼동
				String[] temp = line.split(",");
				
				Student s = new Student(temp[0], temp[1], temp[2], temp[3], temp[4]);
				
				slist.add(s);
				
				
			}
			
			reader.close();
			
			//성적.txt -> clist
			reader = new BufferedReader(new FileReader(DataPath.성적));
			
			line = null;
			
			while ((line = reader.readLine()) != null) {
				//학생번호,국어,영어,수학
	  			//1,100,80,90
				String[] temp = line.split(",");
				
				Score s = new Score(temp[0], Integer.parseInt(temp[1]), Integer.parseInt(temp[2]), Integer.parseInt(temp[3]));
				
				clist.add(s);
				
				
			}
			
			reader.close();
			
		} catch (Exception e) {
			System.out.println("Data.load");
			e.printStackTrace();
		}
	}
	
	public static void save() {
		
		//메모리 > 파일 데이터
		try {
			
			//slist > 학생.txt
			BufferedWriter writer = new BufferedWriter(new FileWriter(DataPath.학생));
			
			for (Student s : slist) {
				
				String line = String.format("%s,%s,%s,%s,%s\n", s.getSeq(), s.getName(), s.getAge(), s.getGender(), s.getAddress());
				
				writer.write(line);
				
			}
			
			writer.close();
			
			//clist > 성적.txt
			writer = new BufferedWriter(new FileWriter(DataPath.성적));
			
			for (Score s : clist) {
				
				String line = String.format("%s,%d,%d,%d\n", s.getSeq(), s.getKor(), s.getEng(), s.getMath());
				
				writer.write(line);
				
			}
			
			writer.close();
			
			
			
			
		} catch (Exception e) {
			System.out.println("Data.save");
			e.printStackTrace();
		}
		
		
		
		
	}
	

}























