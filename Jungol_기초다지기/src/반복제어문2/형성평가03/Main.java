package 반복제어문2.형성평가03;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int input = sc.nextInt();
		int total = 0;
		for (int i = 1; i <= input; i++) {
			if(i%5==0) {
				total += i;
			}
		}
		System.out.println(total);
		sc.close();

	}

}
