package 반복제어문3.자가진단05;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n * 2 - 1; j++) {

				if (i + j >= n * 2 - 1) {
					System.out.print(" ");
				} else if (i - j <= 0) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();

		}

	}
}
