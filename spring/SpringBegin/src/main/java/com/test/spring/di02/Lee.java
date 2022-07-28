package com.test.spring.di02;

public class Lee {
	
	private Brush brush;
	

	public void setBrush(Brush brush) {
		this.brush = brush;
	}
	
	public void run() {

		brush.draw();
		
	}

}
