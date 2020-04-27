package 선택제어문.형성평가05;

import java.util.Scanner;



public class Main1 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int year = sc.nextInt();

		if (year == 2) {
			System.out.println(28);
		} else if (year == 4 || year == 6 || year == 9 || year == 11) {
			System.out.println(30);
		} else {
			System.out.println(31);
		}

			sc.close();

	}

}
