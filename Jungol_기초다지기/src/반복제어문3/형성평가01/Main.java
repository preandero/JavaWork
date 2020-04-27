package 반복제어문3.형성평가01;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] inputarray;
		int total = 0;
		int count = 0;
		int value = 0;

		String input = sc.nextLine();

		inputarray = input.split("\\s+");

		for (int i = 0; i < inputarray.length; i++) {
			value = Integer.parseInt(inputarray[i]);
			if (value == 0) {
				break;
			} else {
				total += value;
				count++;
			}
		}

		int avg = total / count;

		System.out.print(total + " " + avg);
	}
}
