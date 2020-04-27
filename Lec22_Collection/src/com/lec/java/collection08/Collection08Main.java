package com.lec.java.collection08;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Collection08Main {

	public static void main(String[] args) {
		System.out.println("HashSet 연습");
		
		Scanner sc = new Scanner(System.in);
		HashSet<MyClass> set = new HashSet<MyClass>();
		// MyClass 타입을 저장할 수 있는 HashSet 인스턴스 생성
		// 데이터 3개 이상 저장해보고 iterator, enhanced-for 등을 
		// 사용하여 출력해보기
		
		int id1 = 1 , id2= 2 , id3 = 3;
		String name = "suu", name1 = "suuu", name2 = "suuuuu";
		MyClass person1 = new MyClass(id1,name);
		MyClass person2 = new MyClass(id2,name1);
		MyClass person3 = new MyClass(id1,name);
		
		
		// 데이터 3개 저장
		set.add(person1);
		set.add(person2);
		set.add(person3);
		
		// 검색: Iterator, enhanced for
		System.out.println();
		System.out.println("Iterator");
		Iterator<MyClass> itr = set.iterator();
		
		while(itr.hasNext()) {
			 itr.next().displayInfo();
		}
		
		System.out.println();
		System.out.println("enhanced for");
		for( MyClass x : set) {
			x.displayInfo();
		}

		// forEach() 메소드 사용
		System.out.println();
		System.out.println("forEach() 사용");
		// TODO

		System.out.println("\n프로그램 종료");
	} // end main()
} // end class

interface Calculable {
	public abstract double operate(double x , double y);
	/*
	  위와 같이 특정 추상 메소드만 implement 하는 목적으로 설계되는 인터페이스의 이름은
	  보통 ~ able 로 작명 경우가 많다.  
	  자바에서 제공하는 대표적으로 많이 사용하는 이러한 인터페이스들.
	  Serializable, Cloneable, Readable, Appendable, Closeable,  
	  AutoCloseable, Observable, Iterable, Comparable, Runnable,
	  Callable, Repeatable, 
	 */


	
	
	
}

