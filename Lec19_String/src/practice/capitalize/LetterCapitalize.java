package practice.capitalize;

import java.util.Scanner;

/* LetterCapitalize
 * 	문장을 입력하고,  단어의 앞 문자를 대문자로 만들어 출력하기를 반복하다가
 *  quit 을 입력 받으면 종료하기
 * 
 * 	[입력예]
 * 		hello my world
 *  [출력예]
 * 		Hello My World  
 */

public class LetterCapitalize {


	// TODO : 필요한 메소드 있으면 추가 작성
	
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);

			String[] word;
			while(true) {
				String result = "";
				
				String line = sc.nextLine();
				word = line.split("\\s+");
				if(line.trim().equalsIgnoreCase("quit")) break;
			for(int i = 0; i < word.length; i++) {
				result += word[i].substring(0,1).toUpperCase();
				result += word[i].substring(1);
				result += " ";
			}
			System.out.println(result);
			
			}
			
		sc.close();
	} // end main()
} // end class
