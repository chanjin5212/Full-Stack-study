package com.test.java.question.obj.access;


public class Q06 {
	
	public static void main(String[] args) {
		
		Refrigerator r = new Refrigerator();
		
		Item item1 = new Item();
		item1.setName("김치");
		item1.setExpiration("2022-4-9");
		r.add(item1);//냉장고에 넣기
		
		Item item2 = new Item();
		item2.setName("깍두기");
		item2.setExpiration("2022-4-2");
		r.add(item2);//냉장고에 넣기

		Item item3 = new Item();
		item3.setName("멸치볶음");
		item3.setExpiration("2022-4-4");
		r.add(item3);//냉장고에 넣기

		Item item4 = r.get("깍두기");//냉장고에서 꺼내기
		System.out.printf("%s의 유통기한 : %s\n", item4.getName(), item4.getExpiration());

		System.out.printf("냉장고 안의 총 아이템 개수 : %d개\n", r.count());

		r.listItem();
		
		
		
	}

}

class Refrigerator {
	   private Item[] items = new Item[100];
	   
	   int j = 0;
	   public void add(Item item) {
		   if(j == 99) {
			   System.out.println("냉장고에 자리가 없습니다.");
			   return;
		   } else {
			   items[j] = item;
			   System.out.printf("'%s'를 냉장고에 넣었습니다.\n", items[j].getName());
			   j++;			   
		   }
		  
	   }
	   
	   public Item get(String name) {
		   System.out.println();
		   
		   int count = 0;
		   for (int i=0; i<j; i++) {
			   if (items[i].getName().equals(name)) {
				   break;
			   } else {
				   count++;
			   }
		   }
		   Item a = items[count];
		   
		   for (int i=count; i<items.length-1; i++) {
			   items[i] = items[i+1];
		   }
		   j--;
		   return a;
		   
		   
		   
	   }

	   public int count() {
		   return j;
		   
	   }

	   public void listItem() {
		   System.out.println();
		   System.out.println("[냉장고 아이템 목록]");
		   for (int i=0; i<j; i++) {
			   if (items[i] != null) {
				   System.out.printf("%s(%s)\n", items[i].getName(), items[i].getExpiration());
			   }
		   }
	   }
	}

	class Item {
	   private String name;
	   private String expiration;
	   
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getExpiration() {
		return expiration;
	}
	public void setExpiration(String expiration) {
		this.expiration = expiration;
	}
	}
