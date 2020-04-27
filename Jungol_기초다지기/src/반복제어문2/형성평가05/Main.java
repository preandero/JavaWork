package 반복제어문2.형성평가05;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String line = sc.nextLine();
		int even=0;
		int odd=0;
		String[] linearray = line.split("\\s+");
		for (int i = 0; i < linearray.length; i++) {
			if(Integer.parseInt(linearray[i])%2 == 0){
				even++;
			} else {
				odd++;
			}
		}
		System.out.println("even : " + even);
		System.out.println("odd : " + odd);
		
		
		sc.close();

	}

}
