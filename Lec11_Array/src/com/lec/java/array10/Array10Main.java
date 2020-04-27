package com.lec.java.array10;

import java.util.Arrays;

/* Enhanced for (향상된 for) 문
 	
 	for (배열타입 변수 : 배열이름) { ... }
 	
 */
public class Array10Main {

	public static void main(String[] args) {
		System.out.println("Enhanced for (향상된 for) 문");

		int[] arr = { 11, 22, 33, 44, 55 };
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i] + " ");

		}

		System.out.println();

		System.out.println("Enhanced-for 사용");

		for (int x : arr) {
			System.out.println(x);
		}

		System.out.println();
		System.out.println("2차원배열");

		int[][] arr1 = { { 1, 2 }, { 3, 4, 5, 6 }, { 7, 8, 9 } };
		
		for (int[] x : arr1) {
			System.out.println(Arrays.toString(x));
			for(int y : x) {
				System.out.print(y + " ");
			}
			System.out.println();
		}
	} // end main()

} // end class Array10Main
