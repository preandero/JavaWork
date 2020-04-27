package 반복제어문1.형성평가04;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		String[] intarray ;
		int count = 0;
		while(true) {
			
			intarray = input.split(" ");
			
			for(int i = 0 ; i < intarray.length; i++) {
				int division = Integer.parseInt(intarray[i]);
				if(intarray[i].equals("0")) {
					break;
				} else if (division%3 == 0 || division%5 ==0 ) {
					count--;
				}
				count++;
				
			}
			break;
		}
		
		System.out.println(count);
		
		
		sc.close();

	}

}
