package 선택제어문.형성평가01;

import java.util.Scanner;

//두 개의 정수를 입력받아 큰 수에서 작은 수를 뺀 차를 출력하는 프로그램을 작성하시오.
public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int i = sc.nextInt();
		int i1 = sc.nextInt();

		if (i < i1) {
			System.out.println(i1 - i);
		} else if (i > i1) {
			System.out.println(i - i1);
		}

		sc.close();

	}

}
