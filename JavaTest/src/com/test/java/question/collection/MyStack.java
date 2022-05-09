package com.test.java.question.collection;

public class MyStack {

	private String[] list;
	private int index;

	public MyStack() {
		this.index = 0;
	}

	public boolean push(String value) {

		if (this.index == 0) {
			list = new String[4];
		} else if (this.index == this.list.length) {
			String[] newList = new String[list.length];
			for (int i = 0; i < list.length; i++) {
				newList[i] = list[i];
			}
			this.list = new String[list.length * 2];
			for (int i = 0; i < newList.length; i++) {
				list[i] = newList[i];
			}
		}
		list[this.index] = value;
		this.index++;
		return true;
	}

	public String pop() {
		this.index--;
		return list[this.index];
	}

	public int size() {
		return this.index;
	}

	public String peek() {
		return list[this.index - 1];
	}

	public void clear() {
		this.index = 0;
		list = new String[0];
	}

	public void trimToSize() {

		String[] newList = new String[this.index];
		for (int i = 0; i < this.index; i++) {
			newList[i] = list[i];
		}
		this.list = newList;

		// }
		// public boolean push(String value) {
		//
		// try {
		// init();
		// if (checkLength()) {
		// doubleList();
		// }
		// this.list[this.index] = value;
		// this.index++;
		//
		// return true;
		// } catch (Exception e) {
		//
		// return false;
		// }
		//
		//
		// }
		//
		// private void init() {
		//
		// if (this.index == 0) {
		// this.list = new String[4];
		// }
		// }
		//
		// private boolean checkLength() {
		//
		// if (this.index == this.list.length) {
		// return true;
		// }
		// return false;
		// }
		//
		// private void doubleList() {
		//
		// String[] temp = new String[this.list.length * 2];
		//
		// for (int i = 0; i < this.list.length; i++) {
		// temp[i] = this.list[i];
		// }
		//
		// this.list = temp;
		//
		//
		// }
		//
		// public String pop() {
		//
		// String temp = this.list[this.index-1];
		//
		// this.index--;
		//
		// return temp;
		//
		// }
		//
		// public int size() {
		//
		// return this.index;
		// }
		//
		// public String peek() {
		//
		// return this.list[this.index-1];
		// }
		//
		// public void clear() {
		// this.index = 0;
		// }
		//
		// public void trimToSize() {
		//
		// String[] temp = new String[this.index];
		//
		// for (int i=0; i<this.index; i++) {
		// temp[i] = this.list[i];
		// }
		//
		// this.list = temp;
		// }

	}
}
