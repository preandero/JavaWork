package com.lec.java.while01;

/*
 	조건식이 true 인 동안 while 블럭 반복
 	
 	while(조건식 true / false){
 		.. 
 		..
 	}
 
 */
public class While01Main {

	public static void main(String[] args) {
		System.out.println("while 반복문");

		int count = 1; // 초기식
		while (count <= 10) {  // 조건식
			System.out.println(count);
			count++; // 증감식
		} // end while

		System.out.println();
		int count1 = 10;
		while (count1 > 0) {
			System.out.println(count1);
			count1--;
		}
		
		System.out.println();
		
		
		
		
		
		

	} // end main()

} // end class While01Main
