package com.lec.java.firstjava;
/*
모든 자바 프로그램은 main() 메소드로부터 '시작'한다
프로그램 실행순서는 '시작' 부터 한 문장(Statement) 씩 실행되는 것이 원칙
문장의 끝은 반드시 세미콜론 ';' 으로 마무리 해야 한다
*/

// 블럭 주석
//  /*  ~   */
public class FirstJava {
	public static void main(String[] args) {
		System.out.println("My First Java App");

		System.out.println(123);
		System.out.println(); // 줄바꿈만.
		System.out.println(10 + 20); // 10, 20 은 숫자로 인식
		System.out.println("10 + 20"); // "~" 안의 10 + 20 은 문자열로 인식

		// 문자열 출력은 반.드.시 " ~ " 로 감싸야 한다.
//		System.out.println(안녕하세요);  // 에러
		System.out.println(3.141592 * 10 * 10);
		System.out.println(10 * 10 / 2);
		System.out.println("안녕하세요" + "여러분!");
		System.out.println(" 결과 : " + 10);
//		Home + (Shift + End) = 한줄선택
		System.out.println(" 결과 : " + 10 + 20);
		System.out.println(" 결과 : " + (10 + 20));

		// 사칙연산 보여주기 ( +, -, *, /)
		System.out.println("10 + 20 = " + (10 + 20));
		System.out.println("10 - 20 = " + (10 - 20));
		System.out.println("10 * 20 = " + (10 * 20));
		System.out.println("10 / 20 = " + (10 / 20));
		System.out.println("10 / 20 = " + ((double) 10 / 20));

		// \" : 쌍따옴표 출력
		// \n : 줄바꿈
		// \t : 탭문자
		// \\ : 역슬래시

		// 이스케이프 문자 (escape character)
		System.out.println("she says \"Hi\"  ");
		System.out.println(  "\t123\t456");
		System.out.println("1\t0\t4");
		
		System.out.println("Avengers\n\\Endgame");
	}
}
