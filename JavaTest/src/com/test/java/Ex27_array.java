package com.test.java;

import java.util.Arrays;

public class Ex27_array {
	
	public static void main(String[] args) {
	
		//Ex27_array.java
		
		//다차원 배열
		//- 배열의 차원
		
		//m1();
		//m2();
		
		//m3();
		//m4();
		//m5();
		//m6();
		
//		원본 배열 길이: 사용자 입력
//		원본 배열 요소: 난수(1~9)
//		결과 배열 길이: 사용자 입력 / 2
		
		//설명();
		
		m7();
		
		
	} //main

	private static void m7() {
		
		//문제 설명
		//5x5 2차원 배열
		
		int[][] nums = new int[5][5];
		
		//데이터 입력 > 문제의 요구사항에 따라 수정 > 문제 풀이
		int n = 1;
		
		for (int i=0; i<5; i++) {
			for (int j=4; j>=0; j--) {
				nums[i][j] = n;
				n++;
			}
		}
		
		//데이터 출력 > 절대 수정 금지!!!!
		for (int i=0; i<5; i++) {
			for (int j=0; j<5; j++) {
				System.out.printf("%5d", nums[i][j]);
			}
			System.out.println();
		}		
		
	}

	private static void 설명() {
		int length = 5;
		
		int[] list1 = new int[length];
		
		for (int i=0; i<length; i++) {
			list1[i] = (int)(Math.random() * 9) + 1;
		}
		
		System.out.println("원본: " + Arrays.toString(list1));
		
		
		//Math.round(length)
		int[] list2 = new int[(int)Math.round(length / 2.0)];
		
		//[ 1, 5, 3, 6, 2, 7, 8, 2, 2, 9 ]
		//[ 6, 9, 9, 10, 11 ]
		
		//원본 : [ 1, 5, 3, 2, 7 ]
		//결과 : [ 6, 5, 7 ]
						
		for (int i=0; i<list2.length; i++) {
			//0 -> 0 + 1
			//1 -> 2 + 3
			//2 -> 4 + 5
			
			if (list1.length % 2 == 1 && i == list2.length-1) {
				//원본의 배열의 홀수 && 복사의 배열의 마지막 방이냐?
				list2[i] = list1[i*2];
			} else {
				//나머지 모든 방들
				list2[i] = list1[i*2] + list1[i*2+1];
			}
		}
		
		System.out.println("절반: " + Arrays.toString(list2));
	}

	private static void m6() {
		
		//배열 검색
		//- 집합에서 원하는 항목을 검색
		
		String[] member = { "홍길동", "유재석", "박내래", "정형돈", "박명수", "이광수", "김종국", "노홍철", "강호동", "하하" };
		
		//요소 검색 > 결과(반환값)
		//1. boolean
		//2. index

		//변수값의 초기값 > 실패하거나 아무일도 안일어났을때 가져야될 값으로 초기화한다. 피해가 가장 적을것 같다고 생각하는 값
		boolean result = false;
		String search = "아무개"; //검색할 회원명
		
		for (int i=0; i<member.length; i++) {
			if (member[i].equals(search)) {
				result = true; //찾았다!!
				break; //불필요한 회전 중단
			}
		}
		
		if (result) {
			System.out.println(search + " 발견!!");
		} else {
			System.out.println(search + " 없음;;");
		}
		
		
		int index = -1; //발견 위치
		
		for (int i=0; i<member.length; i++) {
			if (member[i].equals(search)) {
				index = i; //찾은 위치 > i
				break;
			}
		}
		
		System.out.println(search + "의 위치: " + index);
		
		
		//search = "이광수";
		
		System.out.println(contains(member, search));
		System.out.println(indexOf(member, search));
		
	}
	
	
	//단위화, 모듈화, 기능화.. > 가독성, 재사용성
	public static boolean contains(String[] member, String search) {
		
		for (int i=0; i<member.length; i++) {
			if (member[i].equals(search)) {
				return true;
			}
		}
		
		return false;
	}
	
	public static int indexOf(String[] member, String search) {
				
		for (int i=0; i<member.length; i++) {
			if (member[i].equals(search)) {
				return i;
			}
		}
		
		return -1;
	}
	

	private static void m5() {
		
		//배열 삽입/삭제
		//[5, 6, 1, 3, 2, 0, 0, 0, 0, 0]
		//[5, 6, 0, 3, 2, 0, 0, 0, 0, 0] (X)
		//[5, 6, 3, 2, 0, 0, 0, 0, 0, 0] (O)
		
		int[] nums = { 5, 6, 1, 3, 2, 0, 0, 0, 0, 10 };
		int index = 2; //삭제 위치
		
		System.out.println(Arrays.toString(nums));
		
		//Left Shift, 좌측 시프트 > for 증가
		for (int i=index; i<nums.length-1; i++) {
			
			nums[i] = nums[i+1];
			
		}

		System.out.println(Arrays.toString(nums));
		
		nums[nums.length-1] = 0;
		
		System.out.println(Arrays.toString(nums));
		
	}

	private static void m4() {
		
		//배열 삽입/삭제
		//[5, 6, 1, 3, 2, 0, 0, 0, 0, 0]
		//[5, 6, 100, 3, 2, 0, 0, 0, 0, 0] (X)
		//[5, 6, 100, 1, 3, 2, 0, 0, 0, 0] (O)
		
		int[] nums = { 5, 6, 1, 3, 2, 0, 0, 0, 0, 10 };
		int index = 2; //삽입 위치
		int value = 100; //삽입 값
		
		System.out.println(Arrays.toString(nums));
		
		//Right Shift, 우측 시프트 > for 감소
		for (int i=nums.length-2; i>=index; i--) {
			nums[i+1] = nums[i]; //이동
		}
		
		System.out.println(Arrays.toString(nums));
		
		nums[index] = value;
		
		System.out.println(Arrays.toString(nums));
		
	}

	private static void m3() {
		
		//중복되지 않는 임의의 숫자 6개를 만드시오.(로또)
		
		long begin = System.nanoTime(); //tick
		
		int[] lotto = new int[6];
		boolean isDuplicate = false;
		
		for (int i=0; i<lotto.length; i++) {
			
			int n = (int)(Math.random() * 45) + 1;
			
			//생성한 난수를 배열에 넣기 전에 > 기존의 숫자와 중복되는지 검사!!
			for (int j=0; j<i; j++) {
				//기존의 숫자들
				if (lotto[j] == n) {
					//중복된 숫자!!!
					isDuplicate = true;
					i--; //이 회차를 한번 실행 > 빈칸이 생기지 않게 하기 위해서
					//System.out.println(n);
					break;
				}
			}
			
			if (!isDuplicate) {
				lotto[i] = n;				
			}
			
			isDuplicate = false;
			
		}
		
		Arrays.sort(lotto); //정렬
		System.out.println(Arrays.toString(lotto)); //덤프
		
		
		long end = System.nanoTime(); //tick
		
		System.out.println(end - begin + "ns"); //소요 시간
		
		
	}

	private static void m2() {
		
		//다차원 배열의 초기화 리스트
		int[] nums1 = { 10, 20, 30 };
		
		//2차원 배열
		//= new int[2][3]
		int[][] nums2 = {{ 10, 20, 30 }, { 40, 50, 60 }};
		
		//3차원 배열
		//= new int[2][2][3];
		int[][][] nums3 = {{{ 10, 20, 30 }, { 40, 50, 60 }}, {{ 10, 20, 30 }, { 40, 50, 60 }}};
		
		int[][][] nums4 = 
			{
				{
					{ 10, 20, 30 }, 
					{ 40, 50, 60 }
				}, 
				{
					{ 10, 20, 30 }, 
					{ 40, 50, 60 }
				}
			};
		
		
		
	}

	private static void m1() {
		
		//1차원 배열
		int[] nums1 = new int[3];
		
		//2차원 배열(테이블)
		int[][] nums2 = new int[2][3]; //2(행), 3(열)
		
		//3차원 배열
		int[][][] nums3 = new int[2][2][3]; //2(면), 2(행), 3(열)
		
		
		//배열 요소 접근(방번호 매기기)
		//1차원 배열
		nums1[0] = 100;
		nums1[1] = 200;
		nums1[2] = 300;
		
		//2차원 배열 > 차원 2개 > 첨자 2개
		nums2[0][0] = 100;
		nums2[0][1] = 200;
		nums2[0][2] = 300;
		nums2[1][0] = 400;
		nums2[1][1] = 500;
		nums2[1][2] = 600;
		
		//3차원 배열 > 차원 3개 > 첨자 3개
		nums3[0][0][0] = 100;
		nums3[0][0][1] = 200;
		nums3[0][0][2] = 300;
		
		nums3[0][1][0] = 400;
		nums3[0][1][1] = 500;
		nums3[0][1][2] = 600;
		
		nums3[1][0][0] = 700;
		nums3[1][0][1] = 800;
		nums3[1][0][2] = 900;
		
		nums3[1][1][0] = 1000;
		nums3[1][1][1] = 1100;
		nums3[1][1][2] = 1200;
		
		
		
		//배열 탐색(+조작)
		//- 1차원 배열 > 단일 for문
		//- 2차원 배열 > 2중 for문
		//- 3차원 배열 > 3중 for문
		
		//1차원 배열
		for (int i=0; i<nums1.length; i++) {
			System.out.printf("nums1[%d] = %d\n", i, nums1[i]);
		}
		System.out.println();
		
		for (int i=0; i<nums1.length; i++) {
			System.out.printf("%5d", nums1[i]);
		}
		System.out.println();
		System.out.println();
		
		
		
		//2차원 배열
		for (int i=0; i<2; i++) {
			for (int j=0; j<3; j++) {
				System.out.printf("nums2[%d][%d] = %d\n", i, j, nums2[i][j]);
			}
		}
		System.out.println();
		
		
		for (int i=0; i<nums2.length; i++) {
			for (int j=0; j<nums2[0].length; j++) {
				System.out.printf("%5d", nums2[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();
		
		
		
		//3차원 배열
		for (int i=0; i<2; i++) {
			for (int j=0; j<2; j++) {
				for (int k=0; k<3; k++) {
					
					System.out.printf("nums3[%d][%d][%d] = %d\n", i, j, k, nums3[i][j][k]);
					
				}
			}
		}
		System.out.println();
		
		
		
		for (int i=0; i<nums3.length; i++) {
			for (int j=0; j<nums3[0].length; j++) {
				for (int k=0; k<nums3[0][0].length; k++) {
					
					System.out.printf("%5d", nums3[i][j][k]);
					
				}
				System.out.println(); //행
			}
			System.out.println();//면
		}
		System.out.println();
		
		
		//다차원 배열의 길이(= 방 개수)
		//1차원 배열
		//= new int[3];
		System.out.println(nums1.length);
		System.out.println();
		
		//2차원 배열
		//= new int[2][3]
		System.out.println(nums2.length); //행의 개수
		System.out.println(nums2[0].length); //열의 개수
		System.out.println();
		
		
		//3차원 배열
		//= new int[2][2][3]
		System.out.println(nums3.length); //면의 개수
		System.out.println(nums3[0].length); //행의 개수
		System.out.println(nums3[0][0].length); //열의 개수
		System.out.println();
		
		
		
	}

}









































