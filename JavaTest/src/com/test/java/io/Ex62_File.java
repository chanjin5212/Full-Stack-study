package com.test.java.io;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Ex62_File {
	
	//누적 변수
	private static int count = 0;

	public static void main(String[] args) {
		
		//"com.test.java.io" > "Ex62_File.java"
		
		/*
		
			1. 파일/디렉토리 조작
				- 윈도우 탐색기로 하는 행동 > 자바로 구현
				- 파일 > 정보 확인, 새로 만들기, 이름 바꾸기, 이동하기, 삭제하기 등
				- 폴더 > 정보 확인, 새로 만들기, 이름 바꾸기, 이동하기, 삭제하기 등
			2. 파일 입출력
				- 파일 > 읽기/쓰기
				- 텍스트 입출력
				- 메모장, 이클립스 등..
					
		*/
		
		m1();
		//m2();
		
		//m3();
		//m4();
		//m5();
		//m6();
		
		//m7();
		//m8();
		//m9();
		//m10();
		//m11();
		//m12();
		
		//m13();
		//m14();
		//m15();
		
		
		
		//파일(폴더) > 생성, 이름 수정, 이동, 삭제
		//폴더 > 내용 보기(listFilse())
		//	  > 재귀호출(폴더 탐색) ***
		
		
		
		//m16();
		
		
		
	}//main
	
	private static void m16() {
		
		//List -> 순서 존재 -> 루프 사용(방번호, Iterator)
		//Set -> 순서 없음 -> 루프 사용(Iterator)
		//Map -> 순서 없음 -> 루프 사용X
		
		//Map 루프 돌리는 방법
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("one", "하나");
		map.put("two", "둘");
		map.put("three", "셋");
		map.put("four", "넷");
		map.put("five", "다섯");
		
		//HashSet(C) > Set(I)
		Set<String> set = map.keySet(); //HashMap의 key들로만 구성된 Set
		Collection<String> values = map.values(); //value들로만 구성된 Collection
		
		//System.out.println(set);
		//System.out.println(values);
		
		
		Iterator<String> iter = set.iterator();
		
		//향상된 for문 구조
		while (iter.hasNext()) {
			//System.out.println(iter.next()); //소비(Stack,Queue 유사)
			
			String key = iter.next();
			
			System.out.println(key + ":" + map.get(key));
		}
		
		
		
		
		
		
		
	}

	private static void m15() {
		
		//폴더의 내용 보기 + 업무 추가
		// > 특정 폴더의 모든 파일 개수 세기?
		
		//파일 11,701, 폴더 2,448, 크기 805,584,749 바이트
		
		String path = "C:\\class\\eclipse";
		File dir = new File(path);
		
		if (dir.exists()) {
			
			countFile(dir);
			
			
			System.out.printf("총 파일 개수: %,d개\n", count);
			
		}
		
		
	}
	
	//넘어온 폴더의 파일 개수 누적..
	private static void countFile(File dir) {
		
		//1. 목록 가져오기
		File[] list = dir.listFiles();
		
		//2. 파일 개수
		for (File subfile : list) {
			if (subfile.isFile()) {
				//count++;
				count += subfile.length();
			}
		}
		
		//3. 자식 폴더를 대상으로 1~2번을 반복
		for (File subdir : list) {
			if (subdir.isDirectory()) {
				//count++;
				//1~3번까지 반복
				countFile(subdir); //재귀 호출
			}
		}
	}

	private static void m14() {
		
		//폴더의 내용 보기 + 업무 추가
		// > 특정 폴더의 모든 파일 개수 세기?
		
		//파일 11,702, 폴더 2,488, 크기 785,787,074 바이트
		
		String path = "C:\\class\\eclipse";
		File dir = new File(path);
		
		int count = 0; //누적 변수
		
		if (dir.exists()) {
			
			File[] list = dir.listFiles();
			
			for (File subfile : list) {
				if (subfile.isFile()) {
					count++;
				}
			}
			
			//자식 폴더 접근
			for (File subdir : list) { //6바퀴(자식폴더 6개)
				
				if (subdir.isDirectory()) {
					
					//자식 폴더의 내용물
					File[] sublist = subdir.listFiles();
					
					for (File subsubfile : sublist) {
						if (subsubfile.isFile()) {
							count++;
						}
					}
					
					//자식의 자식 폴더 접근
					for (File subsubdir : sublist) {
						if (subsubdir.isDirectory()) {
							
							//손자 폴더의 내용물
							File[] subsublist = subsubdir.listFiles();
							
							for (File subsubsubfile : subsublist) {
								if (subsubsubfile.isFile()) {
									count++;
								}
							}
							
						}
					}
					
				}
				
			}
			
			
			System.out.printf("총 파일 개수: %,d개\n", count);
			
		}
		
		
	}

	private static void m13() {
		
		//폴더의 내용 보기
		
		File dir = new File("C:\\class\\eclipse");
		
		if (dir.exists()) {
			
			//자식 파일명 + 자식 폴더명
//			String[] list = dir.list();
//			
//			for (String f : list) {
//				
//				//이름 사용 > File 객체 생성 > isFile(), isDirectory()
//				System.out.println(f);
//				
//				File file = new File(dir.getAbsolutePath() + "\\" + f);
//				System.out.println(file.isFile());
//				System.out.println();
//				
//			}
			
			
			//자식 파일 + 자식 폴더 -> File 배열
//			File[] list = dir.listFiles(); //주로 사용
//			
//			for (File f : list) {
//				System.out.println(f.isDirectory());
//				System.out.println(f.getName());
//				System.out.println();
//			}
			
			
			//탐색기 느낌
			File[] list = dir.listFiles();
			
			for (File d : list) {
				
				if (d.isDirectory()) {
					
					System.out.printf("[%s]\n", d.getName());
					
				}
				
			}
			
			for (File f : list) {
				
				if (f.isFile()) {
					
					System.out.printf("%s\n", f.getName());
					
				}
				
			}
			
			
			
			
		}
		
		
		
		
		
	}

	private static void m12() {
		
		//폴더 삭제하기
		//- 빈폴더만 삭제가 가능하다. > 직접 구현
		File dir  = new File("C:\\class\\java\\file\\회원");
		
		if (dir.exists()) {
			boolean result = dir.delete();
			System.out.println(result);
		}
		
		
	}

	private static void m11() {
		
		//폴더 이동하기
		File dir  = new File("C:\\class\\java\\file\\todo");
		File dir2 = new File("C:\\class\\java\\move\\todo");
		
		boolean result = dir.renameTo(dir2);
		System.out.println(result);		
		
	}

	private static void m10() {
		
		//폴더명 바꾸기
		File dir  = new File("C:\\class\\java\\file\\할일");
		File dir2 = new File("C:\\class\\java\\file\\todo");
		
		boolean result = dir.renameTo(dir2);
		System.out.println(result);		
		
	}

	private static void m9() {
		
		//요구사항] 할일 > 날짜별 폴더 > "2022-01-01" ~ "2022-12-31"
		
		Calendar c = Calendar.getInstance();
		c.set(2022, 0, 1);
		
//		System.out.printf("%tF", c);
//		c.add(Calendar.DATE, 1);
//		System.out.printf("%tF", c);
		
		//System.out.println(c.getActualMaximum(Calendar.DAY_OF_YEAR));
		
		for (int i=0; i<c.getActualMaximum(Calendar.DAY_OF_YEAR); i++) {
			
			String path = String.format("%tF", c);
			
			File dir = new File("C:\\class\\java\\file\\할일\\" + path);
			
			System.out.println(dir.mkdir());
			
			c.add(Calendar.DATE, 1);
			
		}
		
		System.out.println("종료");
		
	}

	private static void m8() {
		
		//요구사항] 회원 > 회원명으로 개인 폴더 생성
		String[] member = { "홍길동", "아무개", "하하하", "호호호", "후후후" };
		
		for (int i=0; i<member.length; i++) {
			
			String path = String.format("C:\\class\\java\\file\\회원\\[개인폴더]%s님"
																	, member[i]);
			File dir = new File(path);
			
			System.out.println(dir.mkdir()); //log..
			
			
		}
		
	}

	private static void m7() {
		
		//폴더 생성하기
		
//		File dir = new File("C:\\class\\java\\file\\aaa");
//		
//		if (!dir.exists()) {
//			boolean result = dir.mkdir();
//			System.out.println(result);
//		} else {
//			System.out.println("이미 같은 이름의 폴더가 존재함.");
//		}
		
		
		File dir = new File("C:\\class\\java\\file\\bbb\\ccc");
		
		if (!dir.exists()) {
			boolean result = dir.mkdirs();
			System.out.println(result);
		} else {
			System.out.println("이미 같은 이름의 폴더가 존재함.");
		}
		 
		
		
	}

	private static void m6() {
		
		//파일 삭제하기
		File file = new File("C:\\class\\java\\file\\data.txt");
		
		if (file.exists()) {
			
			//휴지통 > 폴더 이동
			boolean result = file.delete(); //진짜 삭제
			System.out.println(result);	
			
		}
		
	}

	private static void m5() {
		
		//파일 이동하기
		//- file\hello.txt > move\hello.txt
		File file  = new File("C:\\class\\java\\file\\hello.txt");
		File file2 = new File("C:\\class\\java\\move\\hi.txt");
		
		if (file.exists()) {
			
			boolean result = file.renameTo(file2);
			System.out.println(result);			
			
		}
		
	}

	private static void m4() {
		
		//파일명 바꾸기
		//- hello.txt -> hi.txt
		
		File file  = new File("C:\\class\\java\\file\\hello.txt");
		File file2 = new File("C:\\class\\java\\file\\hi.txt");
		
		if (file.exists()) {
		
			//file(hello.txt) -> file2(hi.txt)
			boolean result = file.renameTo(file2);
			System.out.println(result);
			
		}	
		
		
	}

	private static void m3() {
		
		//파일 조작 > 생성(O), 복사(X), 이동, 파일명 수정, 삭제
		
		//새파일 만들기
		File file = new File("C:\\class\\java\\file\\hello.txt");
		
		if (!file.exists()) {
			
			try {
				
				//동일한 파일이 존재하면 새로 만들기를 실패
				System.out.println(file.createNewFile());
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} else {
			System.out.println("이미 동일한 파일이 존재합니다.");
		}
		
		
		
	}

	private static void m2() {
		
		//폴더 > 정보
		//- 폴더(Folder), 디렉토리(Directory)
		
		//경로
		final String PATH = "C:\\class\\java\\file";
		
		//디렉토리 참조 객체
		//- 디렉토리(폴더)는 파일이다.
		File dir = new File(PATH);
		
		if (dir.exists()) {
			System.out.println("폴더 있음");
			
			System.out.println(dir.getName()); //file
			System.out.println(dir.isFile()); //false
			System.out.println(dir.isDirectory()); //true
			
			System.out.println(dir.length()); //0 **폴더 크기
			
			System.out.println(dir.getAbsolutePath()); //C:\class\java\file
			System.out.println(dir.getPath()); //C:\class\java\file
			
			System.out.println(dir.lastModified()); //1649032549977
			System.out.println(dir.isHidden()); //false
			
			System.out.println(dir.getParent()); //C:\class\java
			
		} else {
			System.out.println("폴더 없음");
		}
		
		
		
	}

	private static void m1() {
		
		//파일 > 정보
		//"C:\class\java\file" 폴더 생성
		//"C:\class\java\file\data.txt" 텍스트 파일 생성
		
		//자바에서 외부의 파일을 접근!!
		//1. 외부 파일을 참조하는 참조 객체 생성 > 대리인, 위임자
		//2. 참조 객체 조작 > 외부 파일에 적용
		
		//경로
		final String PATH = "C:\\class\\java\\file\\data.txt";
		
		//윈도우 탐색기 > 
		
		//파일 참조 객체 > java.io.File
		// - file 객체 == data.txt
		File file = new File(PATH);
		
		//System.out.println(file.exists()); //true
		
		if (file.exists()) {
			
			System.out.println("파일 있음");
			
			//정보
			System.out.println(file.getName()); //data.txt
			System.out.println(file.isFile()); //true
			System.out.println(file.isDirectory()); //false
			
			System.out.println(file.length()); //19 > 파일 크기(바이트)
			
			System.out.println(file.getAbsolutePath()); //C:\class\java\file\data.txt
			System.out.println(file.getPath()); //C:\class\java\file\data.txt
			
			System.out.println(file.lastModified()); //1649031832298
			System.out.println(file.isHidden()); //false
			
			//tick -> 년월일시분초
			Calendar c1 = Calendar.getInstance();
			System.out.println(c1.getTimeInMillis());
			c1.setTimeInMillis(file.lastModified()); //c1를 수정
			
			System.out.printf("%tF %tT\n", c1, c1);
			
			
		} else {
			System.out.println("파일 없음");
		}
		
		
		
		
		
		
		
		
		
		
	}
	
}

































