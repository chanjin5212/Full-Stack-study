package com.test.java.student;


//데이터 > 학생 1명 컨테이너 > 멤버변수 + 생성자 + Getter/Setter + toString
public class Student {
	
	private String seq;
	private String name;
	private String age;
	private String gender;
	private String address;
	
	
	
	public Student(String seq, String name, String age, String gender, String address) {
		super();
		this.seq = seq;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
	}
	
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "Student [seq=" + seq + ", name=" + name + ", age=" + age + ", gender=" + gender
				+ ", address=" + address + "]";
	}
	
	
	
	
}
