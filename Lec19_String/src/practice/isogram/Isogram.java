package practice.isogram;


import java.util.Scanner;

/*	Isogram
	 문자열을 입력받으면 isogram 여부를 판단하여 true/false 를 출력하다가, quit 가 입력되면 종료
	isogram 이란?  : 중복된 알파벳이 없는 단어
	중복되는 문자열이 없으면 true!
	 isogram 예) Machine, isogram, Alphabet, quit
 */
public class Isogram {

	static boolean solve(String input) {
		String word = input.toLowerCase();

		for (int j = 0; j < word.length() - 1; j++) {
			if (word.substring(j + 1).indexOf(word.charAt(j)) != -1) {
				return false;
			}
		}

		return true;

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String input;
		while (true) {
			input = sc.next();
			if (input.equalsIgnoreCase("quit"))
				break;
			System.out.println(solve(input));

		}

	}
} // end class
