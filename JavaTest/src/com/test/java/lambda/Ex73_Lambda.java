package com.test.java.lambda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class Ex73_Lambda {

	public static void main(String[] args) {
		
		//Ex73_Lambda.java
		
		//익명 객체 활용하는 곳 > 람다식 활용하는 곳
		
		Random rnd = new Random();
		
		ArrayList<Integer> nums = new ArrayList<Integer>();
		
		for (int i=0; i<10; i++) {
			nums.add(rnd.nextInt(20) + 1);
		}
		
		System.out.println(nums);
		
		//오름차순 정렬
		nums.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				
				return o1 - o2;
			}
		});
		
		System.out.println(nums);
		
		nums.sort((Integer o1, Integer o2) -> {
			
			return o1 - o2;
		});
		
		
		nums.sort((o1, o2) -> o2 - o1);
		
		System.out.println(nums);
		
		
		
		try {
			
			BufferedReader reader 
				= new BufferedReader(new FileReader("data\\user.txt"));
			
			ArrayList<User> list = new ArrayList<User>();
			
			String line = null;
			
			//Java > Data Type > Strong Type > 엄격한 자료형 사용
			//나머지 > Weak Type > 유연한 자료형 사용
			
			while ((line = reader.readLine()) != null) {
				
				String[] temp = line.split(",");
				String[] ctemp = temp[4].split("-"); //2022-01-01
				
				Calendar c = Calendar.getInstance();
				c.set(Integer.parseInt(ctemp[0])
						, Integer.parseInt(ctemp[1])
						, Integer.parseInt(ctemp[2]));
				
				User user = new User(temp[0]
								   , temp[1]
								   , Integer.parseInt(temp[2]) 
								   , temp[3] 
								   , c);
				
				list.add(user);//***
			}
			
			System.out.println(list);
			
			
			//8개의 객체 > 정렬!!
			
			//[16, 20, 18, 11, 16, 6, 15, 4, 19, 11]
			Collections.sort(nums); //ArrayList<Integer>
			
			
			//비교 기준????
//			[
//			  User [seq=1, name=홍길동, age=25, position=사원, hireDate=2011-03-05]
//			, User [seq=2, name=아무개, age=30, position=대리, hireDate=2020-07-30]
//			, User [seq=3, name=하하하, age=40, position=부장, hireDate=2018-12-05]
//			, User [seq=4, name=호호호, age=34, position=과장, hireDate=2017-11-25]
//			, User [seq=5, name=후후후, age=38, position=차장, hireDate=2013-09-16]
//			, User [seq=6, name=헤헤헤, age=33, position=대리, hireDate=2022-02-25]
//			, User [seq=7, name=히히히, age=29, position=사원, hireDate=2018-03-14]
//			, User [seq=8, name=테스트, age=33, position=대리, hireDate=2016-07-17]
//			]
			
			//Collections.sort(list); //ArrayList<User>
			
			list.sort(new Comparator<User>() {
				@Override
				public int compare(User o1, User o2) {
				
					return o1.getAge() - o2.getAge();
				}
			});
			
			System.out.println(list);
			System.out.println();
			
			//객체배열 > 숫자멤버 정렬
			list.sort((u1, u2) -> u2.getAge() - u1.getAge());
			System.out.println(list);
			System.out.println();
			
			//객체배열 > 문자열멤버 정렬
			list.sort((u1, u2) -> u1.getName().compareTo(u2.getName()));
			System.out.println(list);
			System.out.println();
			
			//객체배열 > 날짜멤버 정렬
			list.sort((u1, u2) -> u1.getHireDate().compareTo(u2.getHireDate()));
			System.out.println(list);
			System.out.println();
			
			//객체배열 > 직급 정렬 > 부장 - 차장 - 과장 - 대리 - 사원
			list.sort((u1, u2) -> u1.getPosition().compareTo(u2.getPosition()));
			System.out.println(list);
			System.out.println();
			
	list.sort((u1, u2) -> {
	if (u1.getPosition().equals("부장") && u2.getPosition().equals("차장")) {
		return -1;
	} else if (u1.getPosition().equals("부장") && u2.getPosition().equals("과장")) {
		return -1;
	} else if (u1.getPosition().equals("부장") && u2.getPosition().equals("대리")) {
		return -1;
	} else if (u1.getPosition().equals("부장") && u2.getPosition().equals("사원")) {
		return -1;
	} else if (u1.getPosition().equals("차장") && u2.getPosition().equals("부장")) {
		return 1;
	} else if (u1.getPosition().equals("차장") && u2.getPosition().equals("과장")) {
		return -1;
	} else if (u1.getPosition().equals("차장") && u2.getPosition().equals("대리")) {
		return -1;
	} else if (u1.getPosition().equals("차장") && u2.getPosition().equals("사원")) {
		return -1;
	} else if (u1.getPosition().equals("과장") && u2.getPosition().equals("부장")) {
		return 1;
	} else if (u1.getPosition().equals("과장") && u2.getPosition().equals("차장")) {
		return 1;
	} else if (u1.getPosition().equals("과장") && u2.getPosition().equals("대리")) {
		return -1;
	} else if (u1.getPosition().equals("과장") && u2.getPosition().equals("사원")) {
		return -1;
	} else if (u1.getPosition().equals("대리") && u2.getPosition().equals("부장")) {
		return 1;
	} else if (u1.getPosition().equals("대리") && u2.getPosition().equals("차장")) {
		return 1;
	} else if (u1.getPosition().equals("대리") && u2.getPosition().equals("과장")) {
		return 1;
	} else if (u1.getPosition().equals("대리") && u2.getPosition().equals("사원")) {
		return -1;
	} else if (u1.getPosition().equals("사원") && u2.getPosition().equals("부장")) {
		return 1;
	} else if (u1.getPosition().equals("사원") && u2.getPosition().equals("차장")) {
		return 1;
	} else if (u1.getPosition().equals("사원") && u2.getPosition().equals("과장")) {
		return 1;
	} else if (u1.getPosition().equals("사원") && u2.getPosition().equals("대리")) {
		return 1;
	} else {
		return 0;
	}}
	);
			
			System.out.println(list);
			System.out.println();
			
			
			
			
		} catch (Exception e) {
			System.out.println("Ex73_Lambda.main");
			e.printStackTrace();
		}
		
		
		
	}//main
	
}//Ex73


//1,홍길동,25,사원,2011-02-05
class User {
	
	private String seq;
	private String name;
	private int age;
	private String position;
	private Calendar hireDate;
	
	public User(String seq, String name, int age, String position, Calendar hireDate) {
		super();
		this.seq = seq;
		this.name = name;
		this.age = age;
		this.position = position;
		this.hireDate = hireDate;
	}

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Calendar getHireDate() {
		return hireDate;
	}

	public void setHireDate(Calendar hireDate) {
		this.hireDate = hireDate;
	}

	@Override
	public String toString() {
		
		return String.format("User [seq=%s, name=%s, age=%s, position=%s"
							+ ", hireDate=%tF]\n", seq, name, age, position, hireDate);
	}

	
	
}
























