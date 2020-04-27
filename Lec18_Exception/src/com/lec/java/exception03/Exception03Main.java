package com.lec.java.exception03;

/*  예외 처리: try ~ catch
  	연습 01패키지에서 발생하던 예외들을 try~catch로 잡아보자 
  	
 	 주의! : try 블럭 안에서 선언된 변수는 try 블럭안에서만 사용되는 지역변수가 된다.
	     catch 블럭등 다른 블럭에서도 사용 가능하게 하려면 try 바깥에서 선언해야 한다
 */
public class Exception03Main {

	public static void main(String[] args) {
		System.out.println("예외 처리: try ~ catch");
		
		System.out.println();
		System.out.println("[1] ArithmeticException");
		int num1 = 0;
		int num2 = 0;
		
		//  try ~ catch 로 감싸기
		try {
		System.out.println("num1 / num2 = " + (num1 / num2));}
		catch(ArithmeticException e){
			System.out.println(num1 + " 은 " + num2 + "으로 나누지 말라능!");
			System.out.println(e.getMessage());
			e.printStackTrace();
			
		
		}
		
		
		
		System.out.println();
		System.out.println("[2] ArrayIndexOutOfBoundsException");

		//  try ~ catch 로 감싸기
		int[] numbers = new int[10];
		try {
		numbers[100] = 111;}
		catch(ArrayIndexOutOfBoundsException a) {
			System.out.print(" " + a.getMessage());
			a.printStackTrace(); 
		}
		
		
		System.out.println();
		System.out.println("[4] NullPointerException");

		//  try ~ catch 로 감싸기
		String str = null;
		try {
		System.out.println("스트링 길이: " + str.length());}
		catch(NullPointerException n) {
			System.out.println("빈공간입니다.");
			System.out.println(n.getMessage());
			n.printStackTrace();
		}

		
		System.out.println();
		System.out.println("[5] ClassCastException");

		//  try ~ catch 로 감싸기
		Object obj = new int[10];
		try {
		String str2 = (String)obj;}
		catch(ClassCastException c) {
			System.out.println(c.getMessage());
			c.printStackTrace();
		}
		
		
		

	} // end main

} // end class Exception03Main












