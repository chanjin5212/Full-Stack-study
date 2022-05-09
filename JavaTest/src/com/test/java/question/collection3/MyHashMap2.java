package com.test.java.question.collection3;

public class MyHashMap2 {

	private Item[] list;
	private int index;
	
	public MyHashMap2() {
		
		//그냥 생성과 동시에 배열 생성 해버렸음.
		this.list = new Item[4];
		this.index = 0;
		
	}
	
	public String put(String key, String value) {
		
		int index = indexOf(key);
		
		if (index > -1) {
			String temp = this.list[index].value;
			this.list[index].value = value;
			return temp;
		}
		
		if (checkLength()) {
			doubleList();
		}
		
		this.list[this.index] = new Item(key, value);
		this.index++;
		
		return null;

	}
	
	private int indexOf(String key) {
		
		for (int i=0; i<this.index; i++) {
			if (this.list[i].key.equals(key)) {
				return i;
			}
		}
		
		return -1;
	}
	
	private boolean checkLength() {

		if (this.index == this.list.length) {
			return true;
		}
		
		return false;
	}

	private void doubleList() {

		Item[] temp = new Item[this.list.length * 2];

		for (int i = 0; i < this.list.length; i++) {
			temp[i] = this.list[i];
		}

		this.list = temp;

	}
	
	public int size() {
		
		return this.index;
	}
	
	public String get(String key) {
		
		for (int i=0; i<this.index; i++) {
			if (this.list[i].key.equals(key)) {
				return this.list[i].value;
			}
		}
		
		return null;		
	}
	
	public String remove(String key) {
		
		int index = indexOf(key);
		
		if (index == -1) {
			return null;
		}
		
		for (int i=index; i<this.list.length-1; i++) {
			this.list[i] = this.list[i+1];
		}
		
		this.index--;
		
		return this.list[index].value;		
	}
	
	public boolean containKey(String key) {
		
		if (indexOf(key) > -1) {
			return true;
		} 
		
		return false;		
	}
	
	public boolean containsValue(String value) {
		
		for (int i=0; i<this.index; i++) {
			if (this.list[i].value.equals(value)) {
				return true;
			}
		}
		
		return false;		
	}
	
	public void clear() {
		
		this.index = 0;
		
	}
	
	public void trimToSize() {

		Item[] temp = new Item[this.index];

		for (int i = 0; i < this.index; i++) {
			temp[i] = this.list[i];
		}

		this.list = temp;

	}
	
	@Override
	public String toString() {
		
		String temp = "";

		temp += "\n";
		temp += String.format("length: %d\n", this.list.length);
		temp += String.format("size: %d\n", this.index);
		temp += String.format("[\n");
		for (int i = 0; i < this.list.length; i++) {
			if (this.list[i] != null) {
				temp += String.format("   %s: %s\n", this.list[i].key, this.list[i].value);
			} else {
				temp += String.format("   %s: %s\n", null, null);
			}
		}
		temp += String.format("]");
		temp += "\n";

		return temp;
	}
	
}


class Item {
	public String key;
	public String value;
	
	public Item(String key, String value) {
		this.key = key;
		this.value = value;
	}
}

