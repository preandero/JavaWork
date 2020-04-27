package 반복제어문2.형성평가04;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		int count = sc.nextInt();
		
		String in = sc.nextLine();
		String input = sc.nextLine().trim();
		String[] inputint = input.split("\\s+");
		
		int total = 0;
		
		
		for(int i = 0; i<inputint.length; i++) {
			int totalcount1 = Integer.parseInt(inputint[i]);
			 total += totalcount1;
		}
		double avg = (double)total / count;
		System.out.printf("%.2f",avg);
		
		sc.close();
	}

}
