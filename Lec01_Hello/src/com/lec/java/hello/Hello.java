package com.lec.java.hello;


import java.util.Scanner;

//10개의 정수를 입력받아 배열에 저장한 후 내림차순으로 정렬하여 출력하시오.
public class Hello {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[10];
		for (int i = 0; i < 10; i++) {
			arr[i] += sc.nextInt();
		}
		
		// 배열 정렬하기
		// bubble sort
		
		//cycle
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if(arr[i]<arr[j]) {
					arr[j] = arr[i];
				}
				
			}
			
		} 
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		
		
		
		sc.close();
		
	}
}