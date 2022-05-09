package com.test.java.question.obj.access;

import com.test.java.question.obj.access.Book;

public class Q01 {

	public static void main(String[] args) {

		Book b1 = new Book();

		b1.setTitle("자바의 정석");
		b1.setPrice(45000);
		b1.setAuthor("남궁성");
		b1.setPublisher("도우출판");
		b1.setIsbn("8994492038");
		b1.setPage(1022);

		System.out.println(b1.info());

	}// main

}// Q01


class Book {

	private String title;
	private int price;
	private String author;
	private String publisher;
	private String pubYear = "2019";
	private String isbn;
	private int page;

	

	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		
		if (checkTitle(title)) {
			this.title = title;
		} else {
			System.out.println("제목이 올바르지 않습니다.");
		}
	}



	private boolean checkTitle(String title) {
		
		if (title.length() > 50) {
			return false;
		}
		
		for (int i=0; i<title.length(); i++) {
			
			char c = title.charAt(i);
			
			if ((c < '가' || c > '힣') 
					&& (c < 'A' || c > 'Z') 
					&& (c < 'a' || c > 'z') 
					&& (c < '0' || c > '9')
					&& (c != ' ')) {
				return false;
			}
			
		}
		
		return true;
	}



	public int getPrice() {
		return price;
	}



	public void setPrice(int price) {
		
		if (price >=0 && price <= 1000000) {
			this.price = price;
		} else {
			System.out.println("가격 오류");
		}
	}



	public String getAuthor() {
		return author;
	}



	public void setAuthor(String author) {
		this.author = author;
	}


	

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}



	public String getPubYear() {
		return pubYear;
	}



	public String getIsbn() {
		return isbn;
	}



	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}



	public int getPage() {
		return page;
	}



	public void setPage(int page) {
		if (page > 0) {
			this.page = page;
		} else {
			System.out.println("페이지 오류");
		}
	}



	public String info() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("제목: " + this.title);
		sb.append("\r\n");
		sb.append(String.format("가격: %,d원", this.price));
		sb.append("\r\n");
		sb.append("저작: " + this.author);
		sb.append("\r\n");
		sb.append("출판사: " + this.publisher);
		sb.append("\r\n");
		sb.append(String.format("발행년도: %s년", this.pubYear));
		sb.append("\r\n");
		sb.append("ISBN: " + this.isbn);
		sb.append("\r\n");
		sb.append(String.format("페이지: %,d장", this.page));
		
		return sb.toString(); //StringBuilder -> String
	}
}

