package 반복제어문1.자가진단06;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("1. Korea");
			System.out.println("2. USA");
			System.out.println("3. Japan");
			System.out.println("4. China");
			System.out.println("number? ");
			int input = sc.nextInt();
			

			if (input == 1) {
				System.out.println("Seoul\n");
			} else if (input == 2) {
				System.out.println("Washington\n");
			}
			else if (input == 3) {
				System.out.println("Tokyo\n");
			}
			else if (input == 4) {
				System.out.println("Beijing\n");
			} else {
				System.out.println("none\n");
				break;
			}
		}
		sc.close();

	}

}
