package practice.maxwords;

import java.util.Scanner;
import java.util.StringTokenizer;
/* MaxWrod
	여러문장으로 구성된 문자열을 입력받은뒤 
	문자열에서 가장 단어의 개수가 많은 문장을 찾아서, 
	그 문장과 문장의 단어의 개수를 출력
	'문장'의 구분은  .(마침표) !(느낌표) ?(물음표) 로 한다.
	'단어'구분은 '공백' 으로 한다
	
	입력예]
	We test coders. Give us a try. Can you make it out? It's awesome.
	
	출력예]
	5개
	Can you make it out
 */
public class MaxWord {
	
	public static void solve(String sentences) {  // 해결 메소드 생성, 매개변수 값은 문자열을 받는다.
		String result = "";  // 정답을 담을 String 변수 선언 
		int count = 0; // 정답의 개수를 담을 int변수 선언 
		
		StringTokenizer sentencestoken = new StringTokenizer(sentences,".!?"); 			//  StringTokenizer를 사용해 문장을 먼저 구분.
		
		while(sentencestoken.hasMoreTokens()) { 			// hasMoreTokens 을 통해 토큰이 다 꺼내지면 while문 종료.
			String sentencetoken = sentencestoken.nextToken().trim(); 			// 문장을 꺼내서 미리 선언해 놓은 sentence 에 담기. trim을 통해 단어 구분 시 생기는 여백 제거
			
			String[] words = sentencetoken.split("\\s+");
			if(count< words.length) {
				count = words.length; 		// 꺼낸 문장을 공백을 기준으로 단어 구분 한뒤  개수 비교를 위해 count 에 담기			
				result =  sentencetoken;
			}
		}
		
		System.out.println(count + "개");
		System.out.println(result);
		
		
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String sentences = sc.nextLine();
		
		solve(sentences);
		
		sc.close();
	} // end main
} // end class
