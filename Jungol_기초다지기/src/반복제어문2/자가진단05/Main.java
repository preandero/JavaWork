package 반복제어문2.자가진단05;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String input = sc.nextLine();
		String[] intarray;
		intarray = input.split("\\s+");

		int threecount = 0;
		int fivecount = 0;
		for (int i = 0; i < intarray.length; i++) {
			int to = Integer.parseInt(intarray[i]);

			if (to % 3 == 0) {
				threecount++;
			}
			if (to % 5 == 0) {
				fivecount++;
			}
		}

		System.out.println("Multiples of 3 : " + threecount);
		System.out.println("Multiples of 5 : " + fivecount);
		sc.close();

	}

}
