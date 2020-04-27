package com.lec.java.class02;
//생성자(Constructor)
	// 생성자의 목적: 인스턴스 생성시 멤버변수들의 초기화
	// 생성자의 이름은 반드시 클래스의 이름과 동일
	// 생성자는 리턴 타입이 없다.
	// 생성자도 매개변수(argument)를 가질 수 있습니다.
	// 생성자도 오버로딩(overload) 가능
	
	// 클래스를 만들 때, 생성자를 따로 만들지 않으면
	// '디폴트 생성자(default constructor)'를 자동으로 만들어줌.
	// 디폴트 생성자란 : 매개변수가 없는 생성자.  모든 멤버변수는 기본값으로 초기화
	// (주의) 클래스에서 하나 이상의 생성자를 만들게 되면,
	// 자동으로 디폴트 생성자를 만들어 주지 않습니다.
	// (강력권장) 아무일도 안하더라도 디폴트 생성자는 반드시 만들어 주자.


public class Class02Main {

	public static void main(String[] args) {
		System.out.println("클래스 연습");		
		Circle c1 = new Circle();
		Circle c2 = new Circle(3);
		double perimeter = c1.calcPerimeter();
		System.out.println("c1의 둘레 : " + perimeter);
		perimeter = c2.calcPerimeter();
		System.out.println("c2의 둘레 : " + perimeter);
		
		System.out.println("원의 넓이 : " + c1.calcArea());
		System.out.println("원의 넓이 : " + c2.calcArea());
		
		Rectangle r1 = new Rectangle();
		Rectangle r2 = new Rectangle(2,3);
		
		System.out.println("r1의 둘레 : " + r1.calcPerimeter());
		System.out.println("r1의 넓이 : " + r1.calcArea());
		
		System.out.println("r2의 둘레 : " + r2.calcPerimeter());
		System.out.println("r2의 넓이 : " + r2.calcArea());
		
	} // end main()

} // end class Class02Main










