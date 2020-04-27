package 반복제어문3.자가진단01;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		int total = 0;
		int count = 0;
		for (int i = 1; i < input; i += 2) {
			total += i;
			count++;
			if (total >= input)
				break;

		}
		System.out.print(count + " " + total);

		sc.close();

	}

}
