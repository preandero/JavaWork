package 배열1.자가진단09;

import java.util.Scanner;

//10개의 정수를 입력받아 배열에 저장한 후 내림차순으로 정렬하여 출력하시오.
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[10];
//		int[] arr = {3, 1, 7, 4, 6, 2, 1, 3, 6, 2, 4};


		for (int i = 0; i < 10; i++) {
			arr[i] += sc.nextInt();
		}
		sc.close();
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		
		System.out.println();
		
		for (int i = 0; i < arr.length - 1; i++) {
			int axis = arr[i];
			for(int z = i + 1; z < arr.length; z ++) {
//				System.out.println("( compare : " + arr[i] + ", " + arr[z]+ ")");
				int comparable = arr[z];
				if(axis < comparable) {
//					System.out.println("(" + arr[z] + " is higher than " + arr[i] + ")");
//					System.out.println("( before change : " + arr[i] + ", " + arr[z] + ")");
					arr[i] = comparable;
					arr[z] = axis;
					axis = comparable;
//					System.out.println("( after change : " + arr[i] + ", " + arr[z] + ")");
				}
				
//				int temp = arr[i]; 7 1 3 4
//				if( arr[i] < arr[z+1]) {
//					arr[i] = arr[z+1];
//					arr[z+1] = temp;
//				}
				
//				break;
			}
		}
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

	}
}
 