package com.test.java.obj.constructor;

public class Ex37_Constructor {
	
	public static void main(String[] args) {
		
		//Ex37_Constructor.java
		
		//공산품 > 일괄적 초기화 > model(M705), price(40000)
		Mouse m1 = new Mouse();
		
		Mouse m2 = new Mouse();
		m2.setPrice(35000);
		
		Mouse m3 = new Mouse();
		m3.setPrice(35000);
		
		
		//객체의 초기 상태 > 상황에 따라 달라질 수 있다. > 생성자의 매개변수 사용 > 다양성
		
		Mouse m4 = new Mouse(35000); //모델명 기본값(M705) + 가격 지정
		
		//QC > discount > 35000
		
		
		Mouse m5 = new Mouse("A100"); //모델명 지정 + 가격 기본값(40000);
		
		Mouse m6 = new Mouse("B123", 30000); //모델명 지정 + 가격 지정
		
		System.out.println(m1.getModel() + "," + m1.getPrice());
		System.out.println(m2.getModel() + "," + m2.getPrice());
		System.out.println(m3.getModel() + "," + m3.getPrice());
		System.out.println(m4.getModel() + "," + m4.getPrice());
		
		
	}//main

}


class Mouse {
	
	private String model;
	private int price;
	
	public Mouse() {
		this.model = "M705";
		this.price = 40000;
	}
	
	public Mouse(int price) {
		this.model = "M705";
		this.price = price;
	}
	
	public Mouse(String model) {
		this.model = model;
		this.price = 40000;
	}
	
	public Mouse(String model, int price) {
		this.model = model;
		this.price = price;
	}
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
}












































