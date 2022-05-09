package com.test.java.question.obj.access;

public class Q02 {

	public static void main(String[] args) {

		Note note = new Note();

		note.setSize("B4");
		note.setColor("노란색");
		note.setPage(25);
		note.setOwner("홍길동");

		System.out.println(note.info());


		Note note2 = new Note();

		note2.setSize("A4");
		note2.setColor("검정색");
		note2.setPage(100);

		System.out.println(note2.info());

	}

}


class Note {
	private String size;
	private String color;
	private int page;
	private String owner;
	private int price;

	// setter, getter 구현

	public void setSize(String size) {
		if (size.equals("A3") || size.equals("A4") || size.equals("A5") || size.equals("B3")
				|| size.equals("B4") || size.equals("B5")) {
			this.size = size;
		} else {
			System.out.println("올바르지 않은 사이즈입니다.");
		}
	}

	public void setColor(String color) {
		if (color.equals("검정색") || color.equals("흰색") || color.equals("노란색")
				|| color.equals("파란색")) {
			this.color = color;
		} else {
			System.out.println("올바르지 않은 색깔입니다.");
		}
	}

	public void setPage(int page) {
		if (page >= 10 && page <= 200) {
			this.page = page;
		} else {
			System.out.println("올바르지 않은 페이지수 입니다.");
		}
	}

	public void setOwner(String owner) {
		int count = 0;
		for (int i = 0; i < owner.length(); i++) {
			if (owner.charAt(i) < '가' && owner.charAt(i) > '힣' && owner.length() > 5
					&& owner.length() < 2) {
				count++;
			}
		}
		if (count == 0) {
			this.owner = owner;
		} else {
			System.out.println("올바르지 않은 이름입니다.");
		}

	}

	public String info() {
			if (this.owner == null) {
				return String.format("■■■■■■ 노트 정보 ■■■■■■\n주인 없는 노트\n■■■■■■■■■■■■■■■■■■■■■■\n");
				
			} else {
				price = 500;
				switch (this.color) {
					case "검정색":
						price += 100;
						break;
					case "노란색":
						price += 200;
						break;
					case "파란색":
						price += 200;
						break;
				}
				switch(this.size) {
					case "A3":
						price += 400;
						break;
					case "A4":
						price += 200;
						break;
					case "B3":
						price += 500;
						break;
					case "B4":
						price += 300;
						break;
					case "B5":
						price += 100;
						break;
				}
				if (this.page > 10) {
					price += (this.page - 10) * 10;
				}
				
				String thick = "";
				if (this.page >= 10 && this.page <= 50) {
					thick = "얇은";
				} else if (this.page > 50 && this.page <= 100) {
					thick = "보통";
				} else if (this.page > 100 && this.page <= 200) {
					thick = "두꺼운";
				}
				return String.format("■■■■■■ 노트 정보 ■■■■■■\n소유자:%s\n특성:%s %s %s노트\n가격:%,d원\n■■■■■■■■■■■■■■■■■■■■■■\n\n"
						, this.owner
						, this.color
						, thick
						, this.size
						, this.price);
			}
		
		
		
	        
	   }
}
