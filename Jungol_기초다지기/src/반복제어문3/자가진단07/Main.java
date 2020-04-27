package 반복제어문3.자가진단07;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int resultint = 1;
		char resultchar = 'A';
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n+1; j++) {
				if(i+j <= n-1) {
					System.out.print(resultint + 
							" ");
					resultint += 1;
				} else {
					System.out.print(resultchar + " ");
					resultchar = (char)(resultchar+1);
				}
			}
			System.out.println();
		}

	}

}

// 0 0  0 1 0 2 ,0 3
// 1 0  1 1 ,1 2 1 3
// 2 0, 2 1 2 2 2 3
 
