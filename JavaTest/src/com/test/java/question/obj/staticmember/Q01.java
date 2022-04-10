package com.test.java.question.obj.staticmember;


public class Q01 {
	
	public static void main(String[] args) {
		
		//포장하는 직원
		Packer packer = new Packer();

		//연필
		Pencil p1 = new Pencil();
		p1.setHardness("HB");
		packer.packing(p1);

		Pencil p2 = new Pencil();
		p2.setHardness("4B");
		packer.packing(p2);

		//지우개
		Eraser e1 = new Eraser();
		e1.setSize("Large");
		packer.packing(e1);

		//볼펜
		BallPointPen b1 = new BallPointPen();
		b1.setThickness(0.3);
		b1.setColor("black");
		packer.packing(b1);

		BallPointPen b2 = new BallPointPen();
		b2.setThickness(1.5);
		b2.setColor("red");
		packer.packing(b2);

		//자
		Ruler r1 = new Ruler();
		r1.setLength(30);
		r1.setShape("줄자");
		packer.packing(r1);

		//결과 확인
		packer.countPacking(0);
		packer.countPacking(1);
		packer.countPacking(2);
		packer.countPacking(3);
		packer.countPacking(4);
		
	}

}


class Packer {
	
	private static int pencilCount = 0;
	private static int eraserCount = 0;
	private static int ballPoinPenCount = 0;
	private static int rulerCount = 0;
	
	
	public void packing(Pencil pencil) {
		System.out.println(pencil.info());
		Packer.pencilCount++;
		
	}
	public void packing(Eraser eraser) {
		System.out.println(eraser.info());
		Packer.eraserCount++;
		
	}
	public void packing(BallPointPen ballPointPen) {
		System.out.println(ballPointPen.info());
		Packer.ballPoinPenCount++;
	}
	public void packing(Ruler ruler) {
		System.out.println(ruler.info());
		Packer.rulerCount++;
		
	}
	public void countPacking(int type) {
		System.out.println("=====================");
		System.out.println("포장 결과");
		System.out.println("=====================");
		switch(type) {
			case 0:
				System.out.printf("연필 %d회\n지우개 %d회\n볼펜 %d회\n자 %d회\n"
									, Packer.pencilCount
									, Packer.eraserCount
									, Packer.ballPoinPenCount
									, Packer.rulerCount);
				break;
			case 1:
				System.out.printf("연필 %d회\n", Packer.pencilCount);
				break;
			case 2:
				System.out.printf("지우개 %d회\n", Packer.eraserCount);
				break;
			case 3:
				System.out.printf("볼펜 %d회\n", Packer.ballPoinPenCount);
				break;
			case 4:
				System.out.printf("자 %d회\n", Packer.rulerCount);
				break;
		}
		System.out.println();
		
	}
	
}

class Pencil {
	
	private String hardness;
	public void setHardness(String hardness) {
		this.hardness = hardness;
	}
	
	public String info() {
		return String.format("포장 전 검수 : %s진하기 연필입니다.\n포장을 완료했습니다.\n", this.hardness);
	}

}

class Eraser {
	
	private String size;

	public void setSize(String size) {
		this.size = size;
	}
	
	public String info() {
		return String.format("포장 전 검수 : %s 사이즈 지우개입니다.\n포장을 완료했습니다.\n", this.size);
	}
	
}

class BallPointPen {
	
	private double thickness;
	private String color;
	
	
	public void setThickness(double thickness) {
		this.thickness = thickness;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public String info() {
		return String.format("포장 전 검수 : %s 색상 %.1fmm 볼펜입니다.\n포장을 완료했습니다.\n", this.color, this.thickness);
	}
	
}

class Ruler {
	
	private int length;
	private String shape;
	
	
	public void setLength(int length) {
		this.length = length;
	}
	
	public void setShape(String shape) {
		this.shape = shape;
	}
	
	public String info() {
		return String.format("포장 전 검수 : %dcm %s입니다.\n포장을 완료했습니다.\\n", this.length, this.shape);
	}
	
}