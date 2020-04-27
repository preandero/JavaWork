package 반복제어문2.형성평가10;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i1 = sc.nextInt();
		int i2 = sc.nextInt();
		if (i1 >= i2) {
			for (int i = 1; i <= 9; i++) {
				for (int x = i1; x >= i2; x--) {
					System.out.printf("%d * %d = %2d   ", x, i, x * i);
				}
					System.out.println();
			}
		} else {
			for (int i = 1; i <= 9; i++) {
				for (int x = i1; x <= i2; x++) {
					System.out.printf("%d * %d = %2d   ", x, i, x * i);
				}
					System.out.println();
			}
		}

		sc.close();
	}
}
