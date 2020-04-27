package 반복제어문2.자가진단04;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		int total = 0;
		for (int i = input; i <= 100; i++) {
			total += i;
		}
		System.out.println(total);
		sc.close();

	}

}
