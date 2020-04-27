package com.lec.java.collection07;

import java.util.HashSet;
import java.util.Iterator;

public class Collection07Main {

	public static void main(String[] args) {
		System.out.println("HashSet 연습");
		
		HashSet<String> set = new HashSet<String>();
		set.add("I'm going Home");
		set.add("you going Home");
		set.add("We going Home");
		set.add("Going Home");
		set.add("I love Home");
		
		System.out.println("Enhanced For 출력");
		for(String x : set) {
			System.out.println(x);
		}
		
		set.remove("Going Home");
		set.add("Let's Go Home"); // 변경
		
		set.remove("We going Home"); // 삭제
		
		set.add("Angry"); // 저장
		
		Iterator<String> itr = set.iterator();
		System.out.println();
		System.out.println("Iterator 출력");
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		// String 타입을 저장할 수 있는 HashSet 를 생성하고
		// 5개 이상의 데이터는 저장, 수정, 삭제 등의 동작을 해보고,
		// iterator, enhanced-for 문을 사용해서 출력해보기
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class
















