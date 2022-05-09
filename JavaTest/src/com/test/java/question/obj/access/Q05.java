package com.test.java.question.obj.access;

public class Q05 {

	public static void main(String[] args) {

		Box box = new Box();
		
		box.cook();
		System.out.println();
		box.check();	
		System.out.println();
		box.list();

	}

}


class Box {
	private Macaron[] list = new Macaron[10];

	public void cook() {
		
		for (int i=0; i<list.length; i++) {
			
			Macaron m = new Macaron();
			
			int n = (int)(Math.random() * 11) + 5;
			
			m.setSize(n);
			
			String[] color = { "red", "blue", "yellow", "white", "pink", "purple", "green", "black" };
			n = (int)(Math.random() * color.length);
			
			m.setColor(color[n]);
			
			n = (int)(Math.random() * 20) + 1;
			
			m.setThickness(n);			
			
			this.list[i] = m;
			
		}
		
		System.out.println("마카롱을 " + list.length + "개 만들었습니다.");		
	}

	public void check() {
		
		
		int pass = 0;
		int failed = 0;
		
		for (int i=0; i<this.list.length; i++) {
			
			Macaron m = this.list[i];
			
			if (checkMacaron(m)) {
				pass++;
			} else {
				failed++;
			}
			
		}
		
		System.out.printf("[박스 체크 결과]\n"
							+ "QC 합격 개수 : %d개\n"
							+ "QC 불합격 개수 : %d개\n"
							, pass
							, failed);

		
	}

	private boolean checkMacaron(Macaron m) {
		
		if (m.getSize() < 8 || m.getSize() > 14) {
			return false;
		}
		
		if (m.getColor().equals("black")) {
			return false;
		}
		
		if (m.getThickness() < 3 || m.getThickness() > 18) {
			return false;
		}
		
		return true;
	}

	public void list() {
		
		System.out.println("[마카롱 목록]");
		
		for (int i=0; i<this.list.length; i++) {
			
			Macaron m = this.list[i];
			
			System.out.printf("%d번 마카롱 : %dcm(%s, %dmm) : %s\n"
								, (i+1)
								, m.getSize()
								, m.getColor()
								, m.getThickness()
								, checkMacaron(m) ? "합격" : "불합격");
		}
	}
}


class Macaron {
	private int size;
	private String color;
	private int thickness;
	
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getThickness() {
		return thickness;
	}
	public void setThickness(int thickness) {
		this.thickness = thickness;
	}
	
	
}




































