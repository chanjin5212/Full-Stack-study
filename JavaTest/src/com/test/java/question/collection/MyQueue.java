package com.test.java.question.collection;

public class MyQueue {
	
	private String[] list; 	
	private int index;		
	
	public MyQueue() {
		this.index = 0;
	}
	
//	public boolean add(String value) {
//		
//		if (this.index == 0) {
//			list = new String[4];
//		} else if (this.index >= this.list.length) {
//			String[] newList = new String[list.length];
//			for (int i=0; i<list.length; i++) {
//				newList[i] = list[i];
//			}
//			list = new String[list.length * 2];
//			for (int i=0; i<newList.length; i++) {
//				list[i] = newList[i];
//			}
//		}
//		list[this.index] = value;
//		this.index++;
//		return true;
//	}
//	public String poll() {
//		
//		String str = list[0];
//		for (int i=0; i<this.index-1; i++) {
//			list[i] = list[i+1];
//		}
//		this.index--;
//		
//		return str;
//	
//	}
//	
//	public int size() {
//		return this.index;
//	}
//	
//	public String peek() {
//		
//		return list[0];
//	}
//	
//	public void clear() {
//		this.index = 0;
//		list = new String[0];
//	}
//	
//	public void trimToSize() {
//		
//		String[] newList = new String[this.index];
//		for (int i=0; i<this.index; i++) {
//			newList[i] = list[i];
//		}
//		this.list = newList;
//		
//	}
	public boolean add(String value) {

		try {
			init();
			if (checkLength()) {
				doubleList();
			}
			this.list[this.index] = value;
			this.index++;

			return true;
		} catch (Exception e) {

			return false;
		}


	}

	private void init() {

		if (this.index == 0) {
			this.list = new String[4];
		}
	}

	private boolean checkLength() {
	
		if (this.index == this.list.length) {
			return true;
		}
		return false;
	}

	private void doubleList() {
		
		String[] temp = new String[this.list.length * 2];

		for (int i = 0; i < this.list.length; i++) {
			temp[i] = this.list[i];
		}

		this.list = temp;


	}
	
	public String poll() { // =remove(0)
		
		String temp = this.list[0];
		
		for (int i=0; i<this.index-1; i++) {
			this.list[i] = this.list[i+1];
		}
		
		this.index--;
		
		return temp;
		
	}
	
	public int size() {
		
		return this.index;
	}
	
	public String peek() {
		
		return this.list[0];
	}
	
	public void clear() {
		this.index = 0;
	}
	
	public void trimToSize() {
		
		String[] temp = new String[this.index];
		
		for (int i=0; i<this.index; i++) {
			temp[i] = this.list[i];
		}
		
		this.list = temp;
	}

		

}
