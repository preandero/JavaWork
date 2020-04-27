package 선택제어문.자가진단05;

import java.util.Scanner;

//두 개의 실수를 입력받아 모두 4.0 이상이면 "A", 모두 3.0 이상이면 "B", 아니면 "C" 라고 출력하는 프로그램을 작성하시오.


public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		double d1 = sc.nextDouble();
		double d2 = sc.nextDouble();
		
		if(d1 >= 4.0 && d2 >= 4.0) {
			System.out.println("A");
		} else if(d1 >=3.0 && d2 >= 3.0) {
			System.out.println("B");
		} else {
			System.out.println("C");
		}
		
		
		
		
		
		sc.close();
		

	}

}
