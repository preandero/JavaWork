package 반복제어문3.형성평가03;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		for (int i = 0; i < (input*2-1); i++) {
			for (int j = 0; j < input; j++) {
				if((input*2-1)<= i+j || i-j < 0) {
					
				}else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
		
		
		

	}

}

//0 0 0 1 0 2	0 3 0 4			1  2
//1 0 1 1 1 2	1 3 1 4				3
//2 0 2 1 2 2	2 3	2 4			
//3 0 3 1 3 2 3 3 3 4					5								 							
//4 0 4 1 4 2 4 3 4 4				5 6

//1
//12
//123
//1234 3 3
//123 4 3 
//12 5 3 5 4
//1  62  63  64 