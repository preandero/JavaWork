package 반복제어문1.형성평가05;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.print("Base = ");
			double base = sc.nextInt();
			System.out.print("Height = ");
			int Height = sc.nextInt();
			double width = (double)(base * Height) / 2;
			System.out.printf("Triangle width = %.1f \n", width);
			System.out.print("Continue? ");
			String input = sc.next();
			if (input.equalsIgnoreCase("y")) {
				continue;
			} else
				break;
		}

		sc.close();

	}

}
