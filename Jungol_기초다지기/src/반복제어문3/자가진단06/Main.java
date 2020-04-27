package 반복제어문3.자가진단06;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		int n = sc.nextInt();
		
		char input = 'A';
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(i + j <= n - 1) {
					System.out.print(input);
					input = (char)(input + 1);
				}
				
				
			}
			System.out.println();
		}

	}

}

// 0 0  01  02   0 1 2
// 1 0  1 1 1 2  1 2 3
// 2 0 2 1 2 2   2 3 4
