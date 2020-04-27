package com.lec.java.constant;
/* 상수 : final
* 변수 선언 앞에 final 키워드를 사용하면
* '상수 (constant)' 가 되어.
* 한번 값을 대입하면 변경할수 없게 된다.
* 
* 관례적으로 상수값을 담는 상수명은 대문자로 작성
*/

public class ConstantMain {

	public static void main(String[] args) {

		int myAge = 35;
		myAge = 40;
		myAge = 23;

		final int MYAGE = 35;
		// MYAGE = 21; Error!

		final short GRADE;
		GRADE = 100;
		// GRADE = 200 초기화 이후로는 final 상수 변경 불가능
		
		final short MYAGE2;
		MYAGE2 = 100; //초기화
		// MYAGE2 = 200; Error!
		
		// 변수 rename시 refactor 사용!

	}

}
