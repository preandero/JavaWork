package com.lec.java.array04;

import java.util.Scanner;

/* 연습
 * 길이 5개 int 형 배열을 선언하고
 * 사용자로부터 5개 정수를 입력받아 초기화 한뒤 
 * 
 * 총점, 평균, 최대값, 최소값  출력해보기
 */
public class Array04Main {

	public static void main(String[] args) {
		System.out.println("배열 연습");
		
		Scanner sc = new Scanner(System.in);
		int[] array = new int[5];
		int all = 0;
		
		
		for (int i = 0; i < array.length; i++) {
			int value = sc.nextInt();
			array[i] = value;	
			all += value;
		}
		
		double avg = (double)all / array.length;
		
		System.out.println("총점: " + all);
		System.out.println("평균: " + avg);
		
		System.out.println();
		//최댓값
		int Max= array[0];
		for (int i = 0; i < array.length; i++) {
			if(array[i] > Max) {
				Max = array[i];
			}
			
		}
		
		System.out.println("최대값 = " + Max);
		
		int Min= array[0];
		for (int i = 0; i < array.length; i++) {
//			if(array[i] < Min) {
//				Min = array[i];
//			}
			
			Min = (array[i] < Min) ? array[i] : Min;
		}
		
		System.out.println("최소값 = " + Min);
		
		
		
		
		sc.close();
		
	} // end main()

} // end class Array04Main








