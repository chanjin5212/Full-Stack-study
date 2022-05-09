package com.test.java.obj.cast;

public class Ex47_Casting {
	
	public static void main(String[] args) {
		
		//Ex47_Casting.java
		
		//업캐스팅 + 다운캐스팅 > 언제 사용? 왜 사용?
		
		
		//내가 가지고 있는 마우스들.. > 관리
		G304 m1 = new G304("광", 45000, 5, 12000);
		G304 m2 = new G304("광", 38000, 4, 8000);
		
		G102 m3 = new G102("광", 28000, 8000, "검정");
		G102 m4 = new G102("광", 25000, 5000, "노랑");
		G102 m5 = new G102("광", 26000, 7000, "파랑");
		
		M331 m6 = new M331("광", "검정", 33000, 10000);
		M331 m7 = new M331("광", "연두", 32000, 9000);
		
		
		
		
		
		
		
		G304[] mlist1 = new G304[2];
		mlist1[0] = m1;
		mlist1[1] = m2;
		
		G102[] mlist2 = new G102[] { m3, m4, m5 };
		
		M331[] mlist3 = new M331[] { m6, m7 };
		
		
		//마우스가 잘 있는지? 확인? > 마우스를 꺼내서 동작 테스트
		for (int i=0; i<mlist1.length; i++) {
			mlist1[i].click();
			mlist1[i].clean();
		}
		System.out.println();
		
		for (int i=0; i<mlist2.length; i++) {
			mlist2[i].click();
			mlist2[i].check();
		}
		System.out.println();
		
		for (int i=0; i<mlist3.length; i++) {
			mlist3[i].click();
			mlist3[i].charge();
		}
		System.out.println();

		
		
		
		
		G304 m8 = new G304("", 0, 0, 0);
		
		Mouse m9;
		
		//Mouse = G304
		//부모클래스 = 자식클래스
		//업캐스팅(100%)
		m9 = m8;
		
		Mouse m10 = new G304("", 0, 0, 0); //업캐스팅
		Mouse m11 = new G102("", 0, 0, "");
		Mouse m12 = new M331("", "", 0, 0);
		
		
		//마우스 7개 관리 > 모델별 배열 > 전체 배열 > 업캐스팅 활용!!!
		
		//서로 다른 자료형의 객체를 하나의 집합에 넣어서 관리하기 위해서 업캐스팅 사용
		
		Mouse[] mlist = new Mouse[7];
		mlist[0] = m1; //G304
		mlist[1] = m2; //G304
		
		mlist[2] = m3; //G102
		mlist[3] = m4; //G102
		mlist[4] = m5; //G102
		
		mlist[5] = m6; //M331
		mlist[6] = m7; //M331
		
		for (int i=0; i<mlist.length; i++) {
			
			mlist[i].click();
			
			
			//**** 서로 다른 객체(형제)를 부모 배열에 한꺼번에 관리
			//    -> 가끔씩 자식 고유의 기능을 사용해야 할때
			//    -> 부모 참조 변수로는 자식 고유의 기능을 접근 불가능(안보이니까)
			//    -> 이때 원래 자료형으로 되돌려서 고유 기능을 사용한다. > 다운 캐스팅
			//G304 > clean()
			//G304 a1 = (G304)mlist[i]; //다운 캐스팅
			//a1.clean();
			
			//연산자
			//- A instanceof B
			//- 2항 연산자
			//- A라는 객체가 B라는 자료형의 객체냐?
			//- A를 B로 형변환이 가능한가?
			//System.out.println(mlist[i] instanceof G102);
			
			if (mlist[i] instanceof G304) {
				((G304)mlist[i]).clean();
			}
			
			if (mlist[i] instanceof G102) {
				((G102)mlist[i]).check();
			}
			
			if (mlist[i] instanceof M331) {
				((M331)mlist[i]).charge();
			}
			
		}
		
		
		
		
		
		
		
		
		
		
	}//main

}//Ex47



class Mouse {
	public void click() {
		
	}
}



class G304 extends Mouse {
	
	private String type;
	private int price;
	private int buttons;
	private int dpi;
	
	public G304(String type, int price, int buttons, int dpi) {
		this.type = type;
		this.price = price;
		this.buttons = buttons;
		this.dpi = dpi;
	}

	@Override
	public String toString() {
		return "G304 [type=" + type + ", price=" + price + ", buttons=" + buttons + ", dpi=" + dpi + "]";
	}
	
	public void click() {
		System.out.printf("클릭합니다. %d, %d\n", this.price, this.dpi);
	}
	
	public void clean() {
		System.out.println("광센서를 자동으로 세척합니다.");
	}
	
}



class G102 extends Mouse {
	private String type;
	private int price;
	private int dpi;
	private String color;
	
	public G102(String type, int price, int dpi, String color) {
		this.type = type;
		this.price = price;
		this.dpi = dpi;
		this.color = color;
	}

	@Override
	public String toString() {
		return "G102 [type=" + type + ", price=" + price + ", dpi=" + dpi + ", color=" + color + "]";
	}
	
	public void click() {
		System.out.printf("Click~ %s\n", this.color);
	}
	
	public void check() {
		System.out.println("현재 DPI를 체크합니다.");
	}
	
}



class M331 extends Mouse {
	
	private String type;
	private String color;
	private int price;
	private int dpi;
	
	public M331(String type, String color, int price, int dpi) {
		super();
		this.type = type;
		this.color = color;
		this.price = price;
		this.dpi = dpi;
	}

	@Override
	public String toString() {
		return "M331 [type=" + type + ", color=" + color + ", price=" + price + ", dpi=" + dpi + "]";
	}
	
	public void click() {
		System.out.printf("클릭!! %s\n", this.type);
	}
	
	public void charge() {
		System.out.println("충전합니다.");
	}
	
	
}































