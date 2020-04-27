package 선택제어문.자가진단09;

import java.util.Scanner;

//3개의 정수를 입력받아 조건연산자를 이용하여 입력받은 수들 중 최소값을 출력하는 프로그램을 작성하시오.

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int i1 = sc.nextInt();
		int i2 = sc.nextInt();
		int i3 = sc.nextInt();
		
		if(i1< i2 && i1 <i3) {
			System.out.println(i1);
		} else if(i2< i1 && i2 <i3) {
			System.out.println(i2);
		} else if(i3< i1 && i3 <i2) {
			System.out.println(i3);
		}
		
		
		
		
		
		
		sc.close();
	}

}
