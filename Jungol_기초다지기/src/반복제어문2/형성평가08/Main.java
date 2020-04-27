package 반복제어문2.형성평가08;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		int input1 = sc.nextInt();

		for (int i = 1; i <= input; i++) {
			int count = 0;
			for (int j = 1; j <= input1; j++) {
				System.out.print(count + i + " ");
				count += i;
			}
			System.out.println();
		}

		sc.close();

	}

}
