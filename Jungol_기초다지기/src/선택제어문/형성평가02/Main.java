package 선택제어문.형성평가02;

import java.util.Scanner;

//정수를 입력받아 0 이면 "zero" 양수이면 "plus" 음수이면 "minus" 라고 출력하는 프로그램을 작성하시오.


public class Main {

	public static void main(String[] args) {
	
		
		Scanner sc = new Scanner(System.in);
		
		int i = sc.nextInt();
		
		if(i == 0) {
			System.out.println("zero");
		} else if(i>0) {
			System.out.println("plus");
		} else {
			System.out.println("minus");
		}

		sc.close();

	}

}
