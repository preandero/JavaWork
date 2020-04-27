package com.lec.java.inherit07;

public class BusinessPerson extends Person {
	private String company;
	
	
	// getter & setter
	public String getcompany() {
		return company;
	}
	public void setcompany(String company) {
		this.company = company;
	}
	// 메소드 재정의 ( Overriding)
	@Override
	public void showInfo() {
		super.showInfo();
		System.out.println("회사: " +company);
	}
	

	// overriding 한 Method 를 다시 Overloading
	public void showInfo(int id) {
		System.out.println("id: " + id);
		showInfo();
	}
//	@Override
//	public void whoAreYou() {
//		super.whoAreYou();
//	}
	@Override
	public String toString() {
		return "BusinessPerson: " + getName() + " " + company;
	}
	
}
