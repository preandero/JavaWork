package 반복제어문3.형성평가02;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int input = sc.nextInt();
		int x = input;

		for (int i = 0; i < 10; i++) {
			if (x < 100) {
				if (i == 0) {
					System.out.print(input + " ");
				} else {
					System.out.print(x + " ");

				}
				if (x % 10 == 0 && x != 0) {
					break;
				}
				x += input;
			}

		}

	}
}
