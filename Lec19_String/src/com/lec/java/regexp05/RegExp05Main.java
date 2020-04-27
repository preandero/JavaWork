package com.lec.java.regexp05;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 대표적인 정규 표현식 
 *  구글링 하면 대표적인 정규표현식들이 많이 구할수 있습니다.
 *  각 정규표현식들을 작성해보고
 *	매칭되는 문자열과 그렇지 않은 것들을 출력해봅시다.   
 */
public class RegExp05Main {

	public static void main(String[] args) {
		System.out.println("많이 쓰는 정규표현식");

		String regex, intput, title;
		String [] arrInput;
		
		//─────────────────────────────────────────
		title = "URL";
		regex = "^((http|https)://)?(www.)?([a-zA-Z0-9]+)\\.[a-z]+([a-zA-z0-9.?#]+)?"; 
		arrInput = new String[] {
			
				"june" , // 매칭x
				"website", // 매칭x
				"http:web.site", // 매칭x
				"naver.com", // 매칭o
				"www.web.site", // 매칭o
				"https://web.site.sth", // 매칭o
				"http://web.site",// 매칭o
				"https://june.me" // 매칭o
		};
		System.out.println(title);
		regExpTest(regex, arrInput);

		
		//─────────────────────────────────────────
		title = "email";
		regex = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$";
		arrInput = new String[] {
				"jsa177@naver.com", //매칭o
				"jsa177!naver.com.", //매칭x
				"jsa1uu@com.naver", //매칭o
				"kame@naver,com", //매칭x
				"jsa177@gogosing.com.net" //매칭o
		};
		System.out.println(title);
		regExpTest(regex, arrInput);

		//─────────────────────────────────────────
		title = "주민등록번호";
		regex = "^\\d{6}-(1|2|3|4)\\d{6}$"; 
		arrInput = new String[] {
					"801111-2123456",//매칭o
					"801221-1346467",//매칭o
					"039425-24672431",//매칭x
					"0394225-4672431"//매칭x
					
		};
		System.out.println(title);
		regExpTest(regex, arrInput);
		
		//─────────────────────────────────────────
		title = "날짜 YYYY-MM-DD";
		regex = "(18|19|20)\\d{2}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])";
		arrInput = new String[] {
			"1912-06-12",//매칭o
			"1952-12-12",//매칭o
			"1912-06-43",//매칭x
			"1912-13-12",//매칭x
			"2020-03-23"//매칭o
			
		};
		System.out.println(title);
		regExpTest(regex, arrInput);
		
		//─────────────────────────────────────────
		title = "자연수";
		regex = "^[1-9][0-9]*$"; 
		arrInput = new String[] {
			"0",//매칭x
			"01",//매칭x
			"10", //매칭o
			"10234" //매칭o
		};
		System.out.println(title);
		regExpTest(regex, arrInput);

		//─────────────────────────────────────────
		title = "정수";
		regex = "^[-+]?(0|[1-9][0-9]*)(\\\\.[0-9]+)?([eE][-+]?[0-9]+)?$";
		arrInput = new String[] {
			"123",
			"-123",
			"0",
			"-0.1",
			"1.6",
			"13213124"
		};
		System.out.println(title);
		regExpTest(regex, arrInput);

		//─────────────────────────────────────────
		title = "소수";
		regex = "^-?\\d*\\.\\d+|\\d+\\.\\d*$";
		arrInput = new String[] {
			  "0.1",
			  "0.534",
			  "1.23",
			  "123.344",
			  "-13.22"
		};
		System.out.println(title);
		regExpTest(regex, arrInput);

		//─────────────────────────────────────────
		title = "소숫점 둘째자리까지";
		regex = "^-?\\d*\\.\\d{2}$";
		arrInput = new String[] {
			"12.23",
			"12.234",
			"-12.234",
			"-12.24"
		};
		System.out.println(title);
		regExpTest(regex, arrInput);

		//─────────────────────────────────────────
		title = "통화표시 (￦)";
		regex = "^[1-9]\\d*\\￦";
		arrInput = new String[] {
			"1000￦",
			"2000￦",
			"3000000￦"
				
		};
		System.out.println(title);
		regExpTest(regex, arrInput);

		System.out.println("프로그램 종료");

	} // end main()

	// 도우미 함수
	public static void regExpTest(String regex, String[] arrInput) {
		for (String input : arrInput)
			regExpTest(regex, input);
	}

	public static void regExpTest(String regex, String input) {
		System.out.println("[정규표현식 매칭 테스트]-----------------");
		System.out.println("정규표현식: " + regex);
		System.out.println("입력문자열: " + input);

		if(Pattern.matches(regex, input)) {
			System.out.println("   ●매칭●");
		} else {
			System.out.println("   Ⅹ매칭 없슴Ⅹ");
		}
		
		System.out.println();
	} // end regExpTest()

} // end class
