package com.lec.java.variable02;

//자바의 기본 자료형(primitive data type)
//  n bit = 2^n자리까지 표현가능
//정수 타입: byte(1Byte) 8bit , short(2Byte) 16bit,
//		  int(4Byte) 32bit , long(8Byte) 64bit
//실수 타입: float(4Byte) 32bit   , double(8Byte) 64bit
//문자 타입: char(2Byte)
//논리 타입: boolean

public class Variable02Main {

	public static void main(String[] args) {
		System.out.println("정수 타입 변수들");
		System.out.println("byte: " + Byte.MIN_VALUE + " ~ " + Byte.MAX_VALUE);

		byte num1 = -128;
		byte num2 = 0;
		byte num3 = 123;
		// byte num4 = 1234; error : byte 에 저장할 수 있는 크기를 넘어섬

		System.out.println("short: " + Short.MIN_VALUE + " ~ " + Short.MAX_VALUE);
		short num5 = -12345;
		short num6 = 12345;
		// short num7 = 32768; error  short 에 저장할 수 있는 크기를 넘어섬
		// short num8 = -32769; error
		
		System.out.println("int : " + Integer.MIN_VALUE + " ~ " + Integer.MAX_VALUE);
		System.out.println("long : " + Long.MIN_VALUE + " ~ " + Long.MAX_VALUE);
		
		int num9 = 987654321;
        // long num10 = 9876543210; The literal 9876543210 of type int is out of range
		// literal = 코드상에 직접 입력한 값들
		// 정수 리터럴  --> int 로 형변환 하려한다.
		// 실수 리터럴 --> Double 로 형변환 하려한다.
		// " " 리터럴 --> String으로 형변환
		
		long num11 = 9876543210L; // <-- long형 literal로 인식
		
		long num12 = 12;
		
		long num13 = 12L;
		
		int num14 = 12;
		
//		int num15 = 12L;  long 타입을 int 에 대입 불가
		
		// 값의 경계선
		byte num15 = Byte.MAX_VALUE;
		byte num16 = (byte)(num15 + 1);
		System.out.println((byte)(num16 -1));
		System.out.println("num 15 = " + num15);
		System.out.println("num 16 = " + num16);
		
		//정수 표기법
		int number1 = 11; // 10진수(Decimal)
		int number2 = 0xB; // 16진수(Hexadecimal), 0x 로 시작
		int number3 = 013; // 8진수(Octal) : 0으로 시작
		int number4 = 0b1011; // 2진수(binary) : 0b로 시작
		
		System.out.println("number1 : " + number1);
		System.out.println("number2 : " + number2);
		System.out.println("number3 : " + number3);
		System.out.println("number4 : " + number4);
				
		// String.format() 을 사용하여 원하는 포맷(진법) 으로 출력 가능
		System.out.println("number1 : " + String.format("%x", number1)); //16진법으로 출력
		System.out.println("number1 : " + String.format("%o", number2)); //8진법으로  출력
		
		//Integer.toXxx(n) 를 사용하여 원하는 포맷의 문자열로 변환 가능
		System.out.println("number1 : " + Integer.toHexString(number1));
		System.out.println("number1 : " + Integer.toOctalString(number1));
		System.out.println("number1 : " + Integer.toBinaryString(number1));
		
		
		
		
		
		
		
	} // end main()

} // end class
