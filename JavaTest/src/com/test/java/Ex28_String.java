package com.test.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex28_String {

	public static void main(String[] args) throws Exception {
		
		//Ex28_String.java
		
		//문자열, String
		//- JDK 제공하는 문자열 조작 기능
		//- 문자열의 실체
		
		//m1();
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
		m15();
		
		//String
		//1. length() > 문자열 길이
		//2. charAt(index) > 문자 추출
		//3. indexOf(search, index), lastIndexOf(search, index) > 위치 검색
		//4. trim() > 공백 제거
		//5. toUpperCase(), toLowerCase() > 대소문자 변환
		//6. startsWith(word), endsWith(word) > 패턴 검색
		//7. substring(being, end) >  문자열 추출
		//8. contains(word) > 문자열 검색
		//9. replace(old, new) > 문자열 치환
		
		
	}//main

	private static void m15() {
		
		//문자열 분리
		//- String[] split(String delimiter)
		//- 문자열을 구분자를 기준으로 쪼개는 메소드
		
		String name = "홍길동,아무개,하하하,강호동,유재석"; //경험
		
		String[] list = name.split(","); //구분자는 사라진다.(***)
		
		for (int i=0; i<list.length; i++) {
			System.out.println(list[i]);
		}
		
		
		
		
		
		String txt = "홍길동입니다.";
		
		
		
		char[] clist = txt.toCharArray();
		System.out.println(Arrays.toString(clist));
		
		
		
		
		char[] clist2 = new char[txt.length()];
		
		for (int i=0; i<clist2.length; i++) {
			clist2[i] = txt.charAt(i);
		}
		System.out.println(Arrays.toString(clist2));
		
		
	}

	private static void m14() {
		
		//문자열 치환(바꾸기)
		//- String replace(String old, String new)
		//- 문자열의 일부를 다른 문자열로 교체하는 메소드
		
		String txt = "안녕하세요. 홍길동입니다. 저를 홍길동이라고 부르세요.";
		
		System.out.println(txt.replace("홍길동", "아무개"));
		
		
		String content = "게시판에 글을 작성합니다. 바보야!!";
		String word = "바보";
		
		//Masking
		System.out.println(content.replace(word, "**"));
		
		
		txt = "     하나     둘      셋      ";
		System.out.printf("[%s]\n", txt);
		System.out.printf("[%s]\n", txt.trim());
		System.out.printf("[%s]\n", txt.replace(" ", "")); //replace로 무언가를 제거하고 싶으면 ""로 교체하면 된다.
		
		System.out.printf("[%s]\n", txt.replace("하나", "")); //"하나"만 제거
		
				
	}

	private static void m13() {
		
		//문자열 검색
		String txt = "안녕하세요. 홍길동입니다.";
		
		System.out.println(txt.contains("홍길동"));
		System.out.println(txt.contains("아무개"));
		
		System.out.println(txt.indexOf("홍길동") > -1);
		System.out.println(txt.indexOf("아무개") > -1);
		
	}

	private static void m12() {
		
		//문자열 추출
		//- String substring(int beginIndex, int endIndex)
		//- String substring(int beginIndex)
		//- beginIndex: 포함(inclusive)
		//- endInex: 미포함(exclusive)
		
		String txt = "가나다라마바사아자차카타파하";
		
		System.out.println(txt.substring(3, 7));
		System.out.println(txt.charAt(5)); //자료형 > char > '바'
		System.out.println(txt.substring(5, 6)); //자료형 > String > "바"
		System.out.println();
		
		
		//정형화된 데이터
		String jumin = "950322-2014785";
		
		//성별?
		System.out.println(jumin.charAt(7) == '1' ? "남자" : "여자");
		System.out.println(jumin.substring(7, 8).equals("1") ? "남자" : "여자" );
		
		//몇년생?
		System.out.println("" + jumin.charAt(0) + jumin.charAt(1)); //'9'(57) + '5'(53)
		System.out.println(jumin.substring(0, 2));
		
		//몇월생?
		System.out.println(jumin.substring(2, 4));
		
		//몇일생?
		System.out.println(jumin.substring(4, 6));
		System.out.println();
		
		
		
		//파일 경로
		String path = "C:\\class\\JavaTest\\Hello.java";
		
		//1. 파일명 추출
		int index = path.lastIndexOf("\\");
		//String filename = path.substring(index + 1, path.length()); //시작위치~끝위치 추출
		String filename = path.substring(index + 1); //시작위치에서 끝까지 추출
		System.out.println(filename);
		
		//2. Hello.java
		// > 확장자 없는 파일명 추출 > Hello
				
		index = filename.lastIndexOf(".");
		String filenameWithoutExtension = filename.substring(0, index);
		System.out.println(filenameWithoutExtension);
		
		//3. 확장자만 추출
		String extension = filename.substring(index);
		System.out.println(extension);
		
		
		
	}

	private static void m11() {
		
		//왼쪽 -> 오른쪽
		//- int indexOf(char)
		//- int indexOf(String)
		//- int indexOf(char, int)
		//- int indexOf(String, int)
		
		//오른쪽 -> 왼쪽
		//- int lastIndexOf(char)
		//- int lastIndexOf(String)
		//- int lastIndexOf(char, int)
		//- int lastIndexOf(String, int)
		
		String txt = "홍길동 자바 공부 홍길동";
		
		System.out.println(txt.indexOf("홍길동")); 
		System.out.println(txt.indexOf("홍길동", 0+3));
		
		System.out.println(txt.lastIndexOf("홍길동"));
		System.out.println(txt.lastIndexOf("홍길동", 9));
		
		
		 
		
	}

	private static void m10() {
		
		//패턴 검색
		//- boolean startsWith(String word)
		//- boolean endsWith(String word)
		
		String txt = "자바 오라클 프로그래밍";
		
		System.out.println(txt.startsWith("자바"));
		System.out.println(txt.startsWith("오라클"));
		System.out.println();
		
		String name = "홍길동";
		
		System.out.println(name.startsWith("홍"));
		System.out.println(name.charAt(0) == '홍');
		System.out.println(name.indexOf('홍') == 0);
		System.out.println();
		
		System.out.println(txt.endsWith("프로그래밍"));
		System.out.println(txt.endsWith("밍"));
		
		System.out.println(name.endsWith("동"));
		System.out.println(name.endsWith("석"));
		System.out.println(name.charAt(name.length()-1) == '동');
		System.out.println(name.indexOf('동') == name.length() - 1);
		
		System.out.println();
		
		
		
		//파일 경로(파일명)
		String path = "C:\\class\\java\\JavaTest\\Ex28_String.java";
		
		//해당 경로의 파일이 자바 소스파일입니까? > 확장자 검사
		if (path.endsWith(".java")) {
			System.out.println("O");
		} else {
			System.out.println("X");
		}
		
		
		String img = "MyHome > dog.GIF";
		
		//img = img.toLowerCase(); //이 행동!! > 아래 조건에 사용되는 목적 이외에 영구적으로 변환
		
		//해당 파일이 이미지 파일입니까? > .jpg, .jpeg, .gif, .png
		if (img.toLowerCase().endsWith(".jpg") 
				|| img.toLowerCase().endsWith(".jpeg") 
				|| img.toLowerCase().endsWith(".gif") 
				|| img.toLowerCase().endsWith(".png")) {
			
			System.out.println("이미지 파일");
			
		} else {
			System.out.println("다른 종류 파일");
		}
		
		
		System.out.println(img);
		
		
	}

	private static void m9() {
		
		//문자열 대소문자 변경
		//- String toUpperCase() > 문자열의 모든 문자를 대문자로 변환
		//- String toLowerCase() > 문자열의 모든 문자를 소문자로 변환
		
		String content = "오늘 수업하는 과목은 Java입니다.";
		String word = "java";
		
		//System.out.println(content.toUpperCase());
		//System.out.println(word.toUpperCase());
		
		//대소문자 구분(Case sensitive)
		//- 정확도 높음
		//- 검색율 낮음
		if (content.indexOf(word) > -1) {
			System.out.println("결과 있음");
		} else {
			System.out.println("결과 없음");
		}

		//대소문자 구분 X(Case insensitive)
		//- 검색율 높음
		//- 정확도 낮음
		if (content.toUpperCase().indexOf(word.toUpperCase()) > -1) {
			System.out.println("결과 있음");
		} else {
			System.out.println("결과 없음");
		}
		
		//메소드 체인
		//- 코딩 패턴 중 하나 > 패턴 > 패러다임 > 함수형 프로그래밍
		//- 문자열.메소드().메소드().메소드()
		
		
		
		
		
	}

	private static void m8() {
		
		//게시판 글쓰기 > 금지어!!
		
		String word = "바보"; //금지어
		String content = "안녕하세요. ㅂㅏㅂㅗ 야!! 멍청이 저는 자바를 배우는 학생입니다."; //글쓰기
		
		if (content.indexOf(word) > -1) {
			//금지어를 발견!!
			System.out.println("금지어 발견!!");
		} else {
			System.out.println("글쓰기 진행..");
		}
		
		String[] words = { "바보", "멍청이", "메롱", "ㅂㅏㅂㅗ" };
		
		for (int i=0; i<words.length; i++) {
			if (content.indexOf(words[i]) > -1) {
				System.out.println("금지어 발견!!");
				break; //**
			}
		}
		
		System.out.println("완료");
		
		
		//주민등록번호 '-'
		String jumin = "950510-2012541";
		
		if (jumin.charAt(6) == '-') {
			System.out.println("O");
		} else {
			System.out.println("X");
		}
		
		if (jumin.indexOf('-') == 6) {
			System.out.println("O");
		} else {
			System.out.println("X");
		}
		
		
	}

	private static void m7() {
		
		//문자열 검색(*********)
		//- 문자열내에서 원하는 문자(열)을 검색 > 발견한 위치(index) 반환
		//- 처음 만난 검색의 위치를 반환한 뒤 종료(뒤에 반복되는 검색어는 검색 안함)
		//- int indexOf(char c)
		//- int indexOf(String s)
		//- int indexOf(char c, int beginIndex)
		//- int indexOf(String s, int beginIndex)
		
		String txt = "안녕하세요. 홍길동입니다.";
		
		int index = -1;
		
		index = txt.indexOf('하');
		System.out.println(index); //2
		
		index = txt.indexOf('홍');
		System.out.println(index); //7
		
		index = txt.indexOf('강');
		System.out.println(index); //-1
		
		index = txt.indexOf("홍길동"); //7 - 첫번째 문자의 위치를 반환
		System.out.println(index); //
		System.out.println();
		
		
		txt = "안녕하세요. 홍길동입니다. 반갑습니다. 홍길동입니다. 네 홍길동입니다.";
		
		index = txt.indexOf("홍길동"); //첫번째 홍길동
		System.out.println(index);
		
		index = txt.indexOf("홍길동", index + "홍길동".length());		
		System.out.println(index);
		
		index = txt.indexOf("홍길동", index + "홍길동".length());
		System.out.println(index);
		
		
		
	}

	private static void m6() {
		
		//문자열 공백 제거
		//- String trim()
		//- 문자열에 존재하는 공백(Whitespace > 스페이스, 탭, 개행)을 제거하는 메소드
		//- 문자열의 시작과 끝에 존재하는 공백 문자를 제거한다.(***)
		//- 불필요하거나 or 사용자 실수로 생긴 공백 제거 역할
		
		
		String txt = "     하나     둘     셋     ";
		
		System.out.printf("[%s]\n", txt);
		System.out.printf("[%s]\n", txt.trim());
		
		
		
		//"                   자바                 ".equals("자바")
		//"자바".equals("자바")
		
		
	}

	private static void m5() {
		
		//951005-1021457
		//- 중간에 '-' 반드시 입력
		String jumin = "951005-2021457";
		
		if (isValidJumin(jumin)) {
			System.out.println("올바른 주민번호");
			
			if (jumin.charAt(7) == '1') {
				System.out.println("남자");
			} else {
				System.out.println("여자");
			}
			
		} else {
			System.out.println("올바르지 않은 주민번호");
		}
		
	}
	
	

	private static boolean isValidJumin(String jumin) {
		
		if (jumin.charAt(6) == '-') {
			return true;
		} else {
			return false;
		}
	}

	private static void m4() throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		//회원 가입
		//- 이름 입력 > 길이(2~5자) + 한글만 가능
		
		System.out.print("이름: ");
		String name = reader.readLine();
		
		if (isValid(name)) {
			System.out.println("올바른 이름");
		} else {
			System.out.println("올바르지 않은 이름");
		}
		
	}
	
	
	//isValid vs isValid2 비교
	private static boolean isValid(String name) {
		
		if (name.length() < 2 || name.length() > 5) { //1. 첫번째 검사
			return false;
		}
		
				
		for (int i=0; i<name.length(); i++) {
			char c = name.charAt(i);
			
			if (c < '가' || c > '힣') { //2. 두번째 검사
				return false;
			}
		}
		
		
		return true;
		
	}

	private static boolean isValid2(String name) {
		
		//길이 검사
		//한글 검사
		
		//코드 위상 > 들여쓰기 증가
		
		//길이 검사
		if (name.length() >= 2 && name.length() <= 5) { //1. 첫번째 검사
			
			//한글 검사
			for (int i=0; i<name.length(); i++) { //2. 두번째 검사
				char c = name.charAt(i);
				
				if (c >= '가' && c <= '힣') {
					//?
				} else {
					return false;
				}
			}
			
			return true; //*** 입력 문자 모두가 한글인게 확인된 위치!!
			
		} else {
			return false;
		}
		
	}

	private static void m3() throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		//아이디 입력 > 올바른 아이디 검사
		//- 영어 소문자
		
		System.out.print("아이디: ");
		String id = reader.readLine();
		
		for (int i=0; i<id.length(); i++) {
			
			char c = id.charAt(i);
			//System.out.println(c);
			
			//문자 코드값 비교
			if (c < 'a' || c > 'z') { //영소문자가 아니냐?
				System.out.println("잘못된 문자가 발견되었습니다.");
				break;
			}
			
		}
		
		System.out.println("종료");
		
		
		//String a = "A";
		//char b = 'A';
		
		//System.out.println((int)a); //값형 <-> 참조형 형변환 불가능
		//System.out.println((int)b); //값형 형변환 > 가능
		
	}

	private static void m2() {
		
		//문자열 추출
		//- char charAt(int index)
		//- 원하는 위치의 문자를 추출하는 메소드
		//- Zero-based Index
		
		//            0 1 2 3 4567 8 910
		String txt = "안녕하세요. 홍길동입니다.";
		
		char c = txt.charAt(3);
		System.out.println(c);
		
		c = txt.charAt(7);
		System.out.println(c);
		
		c = txt.charAt(13);
		System.out.println(c);
		
		//java.lang.StringIndexOutOfBoundsException: index 14,length 14
		//c = txt.charAt(14);
		//System.out.println(c);
		
		//마지막 문자
		c = txt.charAt(txt.length()-1);
		System.out.println(c);
		
	}

	private static void m1() throws Exception {
		
		//문자열 <=> 문자
		//String <=> char
		//문자열 = 문자의 집합
		
		//문자열 없는 언어 > 문자 배열 > String == char[]
		
		//문자열 조작 기능 == 배열 조작 기능 유사
		
		
		//문자열 길이
		//- 문자열을 구성하는 문자의 개수(글자수)
		//- int length()
		
		int[] nums = { 10, 20, 30 };
		System.out.println(nums.length); //프로퍼티(변수)
		
		char[] clist = { '홍', '길', '동', '입', '니', '다', '.' };
		System.out.println(clist.length);
		
		String str = "홍길동입니다.";
		System.out.println(str.length()); //메소드
		
		System.out.println("아무개입니다.".length());
		
		System.out.println("English, 한글, 01234567890, !@#$%".length());
		
		
		//요구사항] 사용자 입력 > 문자수?
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("문장 입력: ");
		String statement = reader.readLine();
		
		System.out.printf("입력한 문장은 %d개의 문자로 구성되었습니다.\n",
							statement.length());
		
		//유효성 검사
		//- 이름 입력
		//- 2자 ~ 5자이내
		if (statement.length() >= 2 && statement.length() <= 5) {
			System.out.println("올바른 이름");
		} else {
			System.out.println("이름은 2자 ~ 5자이내");
		}
		
		
		
	}
	
}


















































