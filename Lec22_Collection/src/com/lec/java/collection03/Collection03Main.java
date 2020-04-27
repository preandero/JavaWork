package com.lec.java.collection03;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Collection03Main {

	public static void main(String[] args) {
		System.out.println("ArrayList 연습");
		Scanner sc = new Scanner(System.in);
		
		System.out.println("차례로 국어,영어,수학 점수를 입력하세요 (공백)");
		int kor = sc.nextInt(), eng = sc.nextInt() , math = sc.nextInt();
		
		System.out.println("id와 이름을 입력하세요.");
		int id = sc.nextInt() ;
		String name = sc.next();
		
		Score score1 = new Score(kor,eng,math);
		
		Student student = new Student(id,name,score1);
		
		ArrayList<Student> stinfo = new ArrayList<Student>();
		
		stinfo.add(student);
		
		System.out.println("for 문");
		for (int i = 0; i < stinfo.size(); i++) {
			System.out.println(stinfo.get(i));
		}
		
		System.out.println("향상된 for 문");
		for(Student x : stinfo) {
			System.out.println(x);
		}
		
		System.out.println("Iterator 출력");
		
		Iterator<Student> Iter = stinfo.iterator();
		
		while(Iter.hasNext()) {
			System.out.println(Iter.next());
		}
		
		// Student 타입을 담는 ArrayList를 만드고
		// 사용자로부터 3개의 Student 데이터 을 입력받아서
		// 3가지 방법으로 출력해보세요. 
		// for, Enhanced-for, Iterator

		
		
		
		
		
		sc.close();
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class









