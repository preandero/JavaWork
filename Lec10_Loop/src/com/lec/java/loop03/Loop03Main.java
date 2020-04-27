package com.lec.java.loop03;

public class Loop03Main {

	public static void main(String[] args) {
		System.out.println("중첩 for 문 nested for");

		// 구구단 출력 : 중첩 for 사용
		// 2 x 1 = 2
		// 2 x 2 = 4
		// ...
		// 2 x 9 = 18
		// 3 x 1 = 3
		// 3 x 2 = 6
		// ..
		// 9 x 9 = 81

		for (int dan = 2; dan <= 9; dan++) {

			System.out.println(dan + "단");
			for (int n = 1; n <= 9; n++) {

				System.out.println(dan + " x " + n + " = " + (dan * n));
			}
			System.out.println();
		}

		System.out.println();
		// 구구단 출력 : 중첩 while 문 사용

		int i = 2;
		
		while (i < 10) {
			System.out.println(i + "단");
			int i1 = 1;
			while (i1 <10) {
				System.out.println(i + " x " + i1 + " = " + (i * i1));
				i1++;
			} 
			System.out.println();
			i++;
		}

		System.out.println("\n프로그램 종료");
	} // end main()

} // end class
