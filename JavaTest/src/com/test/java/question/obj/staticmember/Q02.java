package com.test.java.question.obj.staticmember;

public class Q02 {
	
	public static void main(String[] args) {
		
		//바리스타
		Barista barista = new Barista();

		//손님 1
		//에스프레소 1잔 주문 - 원두 30g
		Espresso e1 = barista.makeEspresso(30);
		e1.drink();

		//손님 2
		//라테 1잔 주문 - 원두 30g, 우유 250ml
		Latte l1 = barista.makeLatte(30, 250);
		l1.drink();

		//손님 3
		//아메리카노 1잔 주문 - 원두 30g, 물 300ml, 각얼음 20개
		Americano a1 = barista.makeAmericano(30, 300, 20);
		a1.drink();

		//손님 4
		//에스프레소 10잔 주문 - 원두 25g
		Espresso[] e2 = barista.makeEspressoes(25, 10);

		for (Espresso e : e2) {
		      e.drink();
		}

		//손님 5
		//라테 5잔 주문 - 원두 25g, 우유 300ml
		Latte[] l2 = barista.makeLattes(25, 300, 5);

		for (Latte l : l2) {
		      l.drink();
		}

		//손님 6
		//아메리카노 15잔 주문 - 원두 20g, 물 350ml, 각얼음 30개
		Americano[] a2 = barista.makeAmericanos(20, 350, 30, 15);

		for (Americano a : a2) {
		      a.drink();
		}

		//결산
		barista.result();
		
	}//main

}

class Barista {
	
	public Espresso makeEspresso(int bean) {
		
		Espresso e1 = new Espresso(bean);
		return e1;
	}
	
	public Espresso[] makeEspressoes(int bean, int count) {
		
		Espresso[] e1 = new Espresso[count];
		for (int i=0; i<e1.length; i++) {
			Espresso e2 = new Espresso(bean);
			e1[i] = e2;
		}
		
		return e1;
		
	}
	
	public Latte makeLatte(int bean, int milk) {
		
		Latte l1 = new Latte(bean, milk);
		
		return l1;
	}
	
	public Latte[] makeLattes(int bean, int milk, int count) {
		
		Latte[] l1 = new Latte[count];
		for (int i=0; i<l1.length; i++) {
			Latte l2 = new Latte(bean, milk);
			l1[i] = l2;
		}
		
		
		return l1;
	}
	
	public Americano makeAmericano(int bean, int water, int ice) {
		
		Americano a1 = new Americano(bean, water, ice);
		return a1;
	}
	
	public Americano[] makeAmericanos(int bean, int water, int ice, int count) {
		
		Americano[] a1 = new Americano[count];
		for (int i=0; i<a1.length; i++) {
			Americano a2 = new Americano(bean, water, ice);
			a1[i] = a2;
		}
		
		
		return a1;
	}
	
	public void result() {
		System.out.println("=================================");
		System.out.println("판매 결과");
		System.out.println("=================================");
		System.out.println();
		System.out.println("---------------------------------");
		System.out.println("음료 판매량");
		System.out.println("---------------------------------");
		System.out.printf("에스프레소 : %d잔\n아메리카노 : %d잔\n라테 : %d잔\n"
							, Coffee.espresso
							, Coffee.americano
							, Coffee.latte);
		System.out.println();
		System.out.println("---------------------------------");
		System.out.println("원자재 소비량");
		System.out.println("---------------------------------");
		System.out.printf("원두 : %dg\n물 : %dml\n얼음 : %d개\n우유 : %dml\n"
							, Coffee.bean
							, Coffee.water
							, Coffee.ice
							, Coffee.milk);
		System.out.println();
		System.out.println("---------------------------------");
		System.out.println("매출액");
		System.out.println("---------------------------------");
		System.out.printf("원두 : %,d원\n물 : %,d원\n얼음 : %,d원\n우유 : %,d원\n"
							, Coffee.beanTotalPrice
							, Coffee.waterTotalPrice
							, Coffee.iceTotalPrice
							, Coffee.milkTotalPrice);
	}
	
}

class Coffee {
	
	static int bean = 0;
	static int water = 0;
	static int ice = 0;
	static int milk = 0;
	static int beanUnitPrice = 1;
	static double waterUnitPrice = 0.2;
	static int iceUnitPrice = 3;
	static int milkUnitPrice = 4;
	static int beanTotalPrice = 0;
	static int waterTotalPrice = 0;
	static int iceTotalPrice = 0;
	static int milkTotalPrice = 0;
	static int americano = 0;
	static int latte = 0;
	static int espresso = 0;
	
}

class Espresso {
	
	private int bean;

	public Espresso(int bean) {
		Coffee.bean += bean;
		Coffee.beanTotalPrice += bean * Coffee.beanUnitPrice;
		Coffee.espresso++;
		this.bean = bean;
	}
	
	public void drink() {
		System.out.printf("원두 %dg으로 만들어진 에스프레소를 마십니다.\n", this.bean);
	}
	
}

class Latte {
	
	private int bean;
	private int milk;
	
	public Latte(int bean, int milk) {
		Coffee.bean += bean;
		Coffee.beanTotalPrice += bean * Coffee.beanUnitPrice;
		Coffee.latte++;
		this.bean = bean;
		Coffee.milk += milk;
		Coffee.milkTotalPrice += milk * Coffee.milkUnitPrice;
		this.milk = milk;
	}
	
	public void drink() {
		System.out.printf("원두 %dg, 우유 %dml으로 만들어진 라떼를 마십니다.\n"
								, this.bean
								, this.milk);
	}
	
}

class Americano {
	
	private int bean;
	private int water;
	private int ice;
	
	public Americano(int bean, int water, int ice) {
		Coffee.bean += bean;
		Coffee.beanTotalPrice += bean * Coffee.beanUnitPrice;
		Coffee.americano++;
		this.bean = bean;
		Coffee.water += water;
		Coffee.waterTotalPrice += water * Coffee.waterUnitPrice;
		this.water = water;
		Coffee.ice += ice;
		Coffee.iceTotalPrice += ice * Coffee.iceUnitPrice;
		this.ice = ice;
	}
	
	public void drink() {
		System.out.printf("원두 %dg, 물 %dml, 얼음 %d개로 만들어진 아메리카노를 마십니다.\n"
								, this.bean
								, this.water
								, this.ice);
	}
	
}
