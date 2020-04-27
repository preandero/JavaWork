package 반복제어문2.형성평가02;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input1 = sc.nextInt();
		int input2 = sc.nextInt();
		
		if(Integer.compare(input1, input2) == 1) {
			for(int i = input2 ; i <= input1; i++) {
				System.out.print(i + " ");
			} }else {
				for(int i = input1 ; i <= input2; i++) {
					System.out.print(i + " ");
			}
			}
		
		
		
		
		sc.close();

	}

}
