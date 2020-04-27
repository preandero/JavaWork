package com.lec.java.class02;

public class Rectangle {
		
	// 속성 : 멤버변수
	// 가로, 세로
	double width;
	double Height;
	
	//생성자
	//1. 디폴트 생성자 
	public Rectangle() {
		System.out.println("Rectangle() 생성");
		width = 100; // 디폴트 값 지정 가능
		Height = 100;
		System.out.println("가로: " + width);
		System.out.println("세로: " + Height);
	}
	public Rectangle(double width,double Height) {
		System.out.println("Rectangle(width,Height) 생성");
		this.width = width;
		this.Height = Height;
		System.out.println("가로: " + width);
		System.out.println("세로: " + Height);
	}
	//동작 : 멤버 메소드
	
	public double calcPerimeter() {
		return (width + Height) *2;
	}
	
	public double calcArea() {
		return width * Height;
	}
}
