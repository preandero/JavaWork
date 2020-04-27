package 반복제어문2.자가진단07;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int subject = sc.nextInt();
		sc.nextLine();

		String score = sc.nextLine();
		String[] scorearray;

		int total = 0;
		scorearray = score.split("\\s+");

		for (int i = 0; i < subject; i++) {
			int scored = Integer.parseInt(scorearray[i]);
			total += scored;
		}

		double avg = (double) total / subject;
		System.out.printf("avg : %.1f", avg);
		System.out.println();
		if (avg >= 80) {
			System.out.println("pass");
		} else {
			System.out.println("fail");
		}

		sc.close();

	}

}
