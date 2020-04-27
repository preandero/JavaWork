package com.lec.java.class06;

public class Class06Main {

	public static void main(String[] args) {
		System.out.println("클래스 연습 : 성적처리");
		
		Score sco = new Score("수영",55,44,66);
		sco.calcTotal();
		sco.calcAvg();
		sco.displayInfo();

		System.out.println("프로그램 종료");
	} // end main()

} // end class Clas06Main










