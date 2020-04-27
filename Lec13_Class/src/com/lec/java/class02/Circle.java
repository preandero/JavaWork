package com.lec.java.class02;

public class Circle {
	
	// 원의 상태(속성) -> 멤버변수
	public double radius;// 반지름 
	
	// 생성자(Constructor)
	// default Constructor = 매개변수가 없는 생성자
	public Circle() {
		System.out.println("Circle() 생성자 호출");
		System.out.println("반지름 : " + radius);
		
	}
	
	// 생성자 오버로딩 가능
	public Circle(double r) {
		System.out.println("Circle(" + r + ") 생성자 호출");
		radius = r;
		System.out.println("반지름 : " + radius);
	}
	
	
	// 원의 기능(동작) -> 멤버 메소드 
	
	// 원의 둘레 계산
	public double calcPerimeter() {
		return 2 * Math.PI * radius;
	}
	
	// 원의 면적 계산
	public double calcArea() {
		return Math.PI * radius * radius;
	}
}
