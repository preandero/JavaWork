package com.lec.java.variable03;

// 실수형 자료 타입: float(4Byte) , double(8Byte)
// 정수형 자료타입의 기본형은 int
// 실수형 자료타입의 기뵨형은 double
public class Variable03Main {

	public static void main(String[] args) {
		System.out.println("변수 - 실수타입");
		
		double number1 = 3.141592;
//		float number2 = 3.14; // 기본적으로 실수 리터럴은 double로 인식
		
		// float 리터럴
		float number3 = 3.14f;
		
		// 실수 타입 최소, 최대값
		System.out.println("float : " + Float.MIN_VALUE + " ~ " + Float.MAX_VALUE);
		System.out.println("float : " + Double.MIN_VALUE + " ~ " + Double.MAX_VALUE );
		
		// 1.4E-45 = 1.4 * 10^-45
		
		float number4 = 1.23456789f;
		double number5 = 1.23456789;
		System.out.println("number 4 : " + number4);
		System.out.println("number 4 : " + number5);
		// float 과 double은 저장할 수 있는 값의 크기만이 아니라
		// 소수점 이하 정밀도(precision)의 차이가 있다.
		
		// 실수 표기법
		double number6 = 123;
		double number7 = 1.23e2; // 지수표기법(exponential notation)
		System.out.println("number6 : " + number6);
		System.out.println("number7 : " + number7);
		
		double number8 = 0.0001213;
		double number9 = 1.213E-4;
		System.out.println("number8 : " + number8);
		System.out.println("number9 : " + number9);
		
		
	} // end main()

} // end class
