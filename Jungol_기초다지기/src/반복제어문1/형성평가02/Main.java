package 반복제어문1.형성평가02;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] intarray;
		int odd = 0;
		int even = 0;
		while (true) {
			String input = sc.nextLine();
			intarray = input.split("\\s+");
			for (int i = 0; i < intarray.length; i++) {
				int division = Integer.parseInt(intarray[i]);
				if (intarray[i].equals("0")) {
					break;
				} else if (division % 2 != 0) {
					odd++;
				} else if (division % 2 == 0) {
					even++;
				}
			}
			break;

		}
		System.out.println("odd : " + odd);
		System.out.println("even : " + even);

		sc.close();

	}

}
