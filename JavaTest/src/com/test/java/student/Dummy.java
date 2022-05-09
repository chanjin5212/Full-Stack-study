package com.test.java.student;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class Dummy {

	public static void main(String[] args) {

		// 데이터 생성용
		try {

			//createStudent();
			//createTeam();
			create();
			
		} catch (Exception e) {
			System.out.println("Dummy.main");
			e.printStackTrace();
		}
	}


	private static void create() {
		
		
		
	}


	private static void createTeam() throws IOException {
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(DataPath.팀));
		
		Random rnd = new Random();
		
		String[] teamName = {"LG 트윈스", "두산 베어스", "롯데 자이언츠", "SSG 랜더스", "KIA 타이거즈",
								"키움 히어로즈", "NC 다이노스", "KT 위즈", "삼성 라이온즈", "한화 이글스"};
		
		String[] teamPlace = {"잠실야구장", "잠실야구장", "사직야구장", "인천SSG랜더스필드", "광주기아챔피언스필드", "고척스카이돔",
								"창원NC파크", "수원KT위즈파크",  "대구삼성라이온즈파크", "한화이글스파크"};
		
		int year = 2014;
		int a = 1;
		for (int j=0; j<8; j++) {
			for (int i=0; i<10; i++) {
				int win = rnd.nextInt(144);
				int lose = 144 - win;
				writer.write(String.format("%d●%d●야구●%s●%d●%d●%s\n", a, year, teamName[i], win, lose, teamPlace[i]));
				a++;
			}
			year++;
		}
		
		writer.close();
		
		System.out.println("생성 완료");
		
	}


	private static void createStudent() throws Exception {

		BufferedWriter writer = new BufferedWriter(new FileWriter(DataPath.회원));

		Random rnd = new Random();
		int size = 100;

		String num0 = "010";
		int[] num1 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};


		HashSet<String> phoneNum = new HashSet<String>();
		for (int i = 0; i < size; i++) {

			String phone =
					num0 + "-" + num1[rnd.nextInt(num1.length)] + num1[rnd.nextInt(num1.length)]
							+ num1[rnd.nextInt(num1.length)] + num1[rnd.nextInt(num1.length)] + "-"
							+ num1[rnd.nextInt(num1.length)] + num1[rnd.nextInt(num1.length)]
							+ num1[rnd.nextInt(num1.length)] + num1[rnd.nextInt(num1.length)];


			// System.out.println(콜);


			if (!phoneNum.contains(phone))
				phoneNum.add(phone);
			else
				i--;

		}
		ArrayList<String> s1 = new ArrayList<String>();
		for (String s : phoneNum) {
			s1.add(s);
		}
		


		 String[] name1 = {"김", "이", "박", "최", "정", "강", "조", "윤", "장", "임", "한", "오", "서", "신", "권", "황", "안", "송", "류", "전", "홍",
		            "고", "문", "양", "손", "배", "조", "백", "허", "유", "남", "심", "노", "정", "하", "곽", "성", "차", "주", "우", "구", "신",
		            "임", "나", "전", "민", "유", "진", "지", "엄", "채", "원", "천",
		            "방", "공", "강", "현", "함", "변", "염", "양", "변", "여", "추", "노", "도", "소", "신",
		            "석", "선", "설", "마", "길", "주", "연", "방", "위", "표", "명", "기", "반", "왕", "금", "옥", "육", "인", "맹", "제", "모",
		            "장", "남", "탁", "국", "여", "진", "어", "은", "편", "구", "용"};


		      String[] name2 = { "가", "강", "건", "경", "고", "관", "광", "구", "규", "근", "기", "길", "나", "남", "노", "누", "다", "단",
		            "달", "담", "대", "덕", "도", "동", "두", "라", "래", "로", "루", "리", "마", "만", "명", "무", "문", "미", "민", "바", "박",
		            "백", "범", "별", "병", "보", "빛", "사", "산", "상", "새", "서", "석", "선", "설", "섭", "성", "세", "소", "솔", "수", "숙", "순",
		            "숭", "슬", "승", "시", "신", "아", "안", "애", "엄", "여", "연", "영", "예", "오", "옥", "완", "요", "용", "우", "원", "월", "위",
		            "유", "윤", "율", "으", "은", "의", "이", "익", "인", "일", "잎", "자", "잔", "장", "재", "전", "정", "제", "조", "종", "주",
		            "준", "중", "지", "진", "찬", "창", "채", "천", "철", "초", "춘", "충", "치", "탐", "태", "택", "판", "하", "한", "해", "혁",
		            "현", "형", "혜", "호", "홍", "화", "환", "회", "효", "훈", "휘", "희", "운", "모", "배", "부", "림", "봉", "혼", "황", "량",
		            "린", "을", "비", "솜", "공", "면", "탁", "온", "디", "항", "후", "려", "균", "묵", "송", "욱", "휴", "언", "령", "섬", "들",
		            "견", "추", "걸", "삼", "열", "웅", "분", "변", "양", "출", "타", "흥", "겸", "곤", "번", "식", "란", "더", "손", "술", "훔",
		            "반", "빈", "실", "직", "흠", "흔", "악", "람", "뜸", "권", "복", "심", "헌", "엽", "학", "개", "롱", "평", "늘", "늬", "랑",
		            "얀", "향", "울", "련" };


		for (int i = 0; i < size; i++) {

			int seq = i + 1;

			String name = name1[rnd.nextInt(name1.length)] + name2[rnd.nextInt(name2.length)]
					+ name2[rnd.nextInt(name2.length)];

			StringBuilder jumin = new StringBuilder();

			jumin.append(rnd.nextInt(9));
			jumin.append(rnd.nextInt(9));
			int a = rnd.nextInt(1);
			if (a == 1) {
				jumin.append(a);
				jumin.append(rnd.nextInt(2));
			} else {
				jumin.append(a);
				jumin.append(rnd.nextInt(9) + 1);
			}
			int b = rnd.nextInt(2);
			if (b == 0) {
				jumin.append(b);
				jumin.append(rnd.nextInt(9) + 1);
			} else {
				jumin.append(b);
				jumin.append(rnd.nextInt(10));
			}

			jumin.append("-");
			jumin.append(rnd.nextInt(2) + 1);

			int point = (int) (Math.random() * 10000);
			point = point - (point % 10);

			

			char[] id = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
					'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4',
					'5', '6', '7', '8', '9'};

			StringBuffer sb = new StringBuffer();

			

			int idLength = rnd.nextInt(12) + 4;
			for (int k = 0; k < idLength; k++) {

				sb.append(id[rnd.nextInt(id.length)]);

			}
			

			StringBuffer sb1 = new StringBuffer();


			int pwLength1 = rnd.nextInt(9) + 8;
			for (int k = 0; k < pwLength1; k++) {

				sb1.append(id[rnd.nextInt(id.length)]);

			}

			



			writer.write(String.format("%d●%s●%s●%s●%s●%s●%d\n", seq, name, jumin, s1.get(i), sb, sb1, point));

		}

		writer.close();

		System.out.println("생성 완료");


	}

}


