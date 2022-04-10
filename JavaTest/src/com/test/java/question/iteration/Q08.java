package com.test.java.question.iteration;

public class Q08 {

	public static void main(String[] args) {
		
		//1년 1월 1일은 월요일이다.
		
		//1. 더한 값을 저장하는 sum 변수 생성
		//2. 년,월,일 변수 생성
		//3. 윤년에 따라 값을 더하는 for문 과 if문 생성
		//4. 월에 따라 값을 더하는 for문 과 if문 생성
		//5. 모두 더한 sum값을 7로 나눈 나머지를 이용하여 요일 계산
		//6. 출력

		int sum = 0;
		int year = 2022;
		int month = 3;
		int date = 16;
		String day = "";
		for (int i = 1; i < year; i++) {

			if (i % 4 == 0) {
				if (i % 100 == 0) {
					if (i % 400 == 0) {
						sum += 366;
					} else {
						sum += 365;
					}
				} else {
					sum += 366;
				}
			} else {
				sum += 365;
			}

		}
		for (int i = 1; i < month; i++) {

			switch (i) {
				case 1:
				case 3:
				case 5:
				case 7:
				case 8:
				case 10:
				case 12:
					sum += 31;
					break;
				case 2:
					if (i % 4 == 0) {
						if (i % 100 == 0) {
							if (i % 400 == 0) {
								sum += 29;
							} else {
								sum += 28;
							}
						} else {
							sum += 29;
						}
					} else {
						sum += 28;
					}
					break;
				case 4:
				case 6:
				case 9:
				case 11:
					sum += 30;
					break;
			}
		}
		switch ((sum + date) % 7) {
			case 1:
				day = "월";
				break;
			case 2:
				day = "화";
				break;
			case 3:
				day = "수";
				break;
			case 4:
				day = "목";
				break;
			case 5:
				day = "금";
				break;
			case 6:
				day = "토";
				break;
			case 0:
				day = "일";
				break;
		}
		System.out.printf("%d년 %d월 %d일은 %,d일째 되는 날이고 %s요일입니다.", year, month, date, sum + date, day);
		
	} //main
}
