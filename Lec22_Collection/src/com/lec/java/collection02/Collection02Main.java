package com.lec.java.collection02;

import java.util.ArrayList;
import java.util.Iterator;

public class Collection02Main {

	public static void main(String[] args) {
		System.out.println("ArrayList 연습");
		ArrayList<String> al = new ArrayList<String>();
		al.add("Java");
		al.add("Game");
		al.add("Home");
		al.add("Each");
		al.add("Mine");
		System.out.println("ArrayList<String> 첫번째 출력 값: ");
		for (int i = 0; i < al.size(); i++) {
			System.out.println(al.get(i) );
		}

		System.out.println();

		al.set(0, "Hello Java!");
		al.set(1, "Happy Game!");
		System.out.println("ArrayList<String> 두번째 수정 출력 값: ");
		for (String x : al) {
			System.out.println(x );
		}

		System.out.println();

		al.remove(4);
		al.remove(3);

		Iterator<String> ai = al.iterator();
		System.out.println("ArrayList<String> 세번째 제거 출력 값: ");
		while (ai.hasNext()) {
			System.out.println(ai.next());
		}
		// String 타입을 담는 ArrayList를 만들고
		// 5개 이상의 String을 저장하고
		// set(), remove() 등의 메소드 사용하여
		// 임의의 것을 수정, 삭제 도 해보시고
		// 3가지 방식으로 출력해보세요
		// for, Enhanced-for, Iterator

		System.out.println("\n프로그램 종료");
	} // end main()

} // end class
