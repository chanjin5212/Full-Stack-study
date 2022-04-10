package com.test.java.question.obj.access;

import java.util.Calendar;

public class Q03 {

	public static void main(String[] args) {

		Bugles snack = new Bugles();

		snack.setSize(500);
		snack.setCreationTime("2022-3-21");
		System.out.println("가격 : " + snack.getPrice() + "원");
		System.out.println("유통 기한이 " + snack.getExpiration() + "일 남았습니다.");

		snack.eat();


		Bugles snack2 = new Bugles();

		snack2.setSize(300);
		snack2.setCreationTime("2022-3-13");
		System.out.println("가격 : " + snack2.getPrice() + "원");
		System.out.println("유통 기한이 " + snack2.getExpiration() + "일 남았습니다.");
		
		snack2.eat();

	}

}

class Bugles {
	private int price;
	private int size;
	private Calendar creationTime;
	private int expiration;

	// getter, setter 구현

	public int getPrice() {
		price = 500;
		switch(this.size) {
			case 300:
				price = 850;
				break;
			case 500:
				price = 1200;
				break;
			case 850:
				price = 1950;
				break;
		}
		return price;
	}
	public Calendar getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(String creationTime) {
		String[] time = creationTime.split("-");
		Calendar time1 = Calendar.getInstance();
		time1.set(Integer.parseInt(time[0]), Integer.parseInt(time[1])-1, Integer.parseInt(time[2]));
		
		this.creationTime = time1;
		
	}
	
	public int getExpiration() {
		long a = (System.currentTimeMillis() - creationTime.getTimeInMillis())/(1000*60*60*24);
		
		switch(this.size) {
			case 300:
				expiration = 7 - (int)a;
				break;
			case 500:
				expiration = 10 - (int)a;
				break;
			case 850:
				expiration = 15 - (int)a;
				
		}
		return expiration-2;
	}
	public int getSize() {
		return size;
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	public void eat() {
		
		if (this.expiration >= 0) {
			System.out.println("과자를 맛있게 먹습니다.");
		} else {
			System.out.println("유통기한이 지나 먹을 수 없습니다.");
		}

	}

}
