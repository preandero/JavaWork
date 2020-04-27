package 반복제어문3.형성평가06;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		//2번 문제
		Scanner sc= new Scanner(System.in);
		String input = sc.nextLine();
		String input2 = sc.nextLine();
		String input3 = sc.nextLine();
		sc.close();
		
		String result = "";
		
		
		result += input.charAt(0);
		result += input2.charAt(0);
		result += input3.charAt(0);
		
		System.out.println(result);
		
	}
}
