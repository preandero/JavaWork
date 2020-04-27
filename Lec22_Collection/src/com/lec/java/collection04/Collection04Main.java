package com.lec.java.collection04;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Collection04Main {

	public static void main(String[] args) {
		System.out.println("ArrayList 연습");

		Scanner sc = new Scanner(System.in);
		ArrayList<MemberModel> info = new ArrayList<MemberModel>();
		int count = 0;
		while (count < 3) {
			System.out.println("id: ");
			String id = sc.next();
			System.out.println("password: ");
			String password = sc.next();

			MemberModel model = new MemberModel(id, password);
			info.add(model);
			count++;
		}

		System.out.println("for");
		for (int i = 0; i < info.size(); i++) {
			info.get(i).displayInfo();
		}

		System.out.println();
		System.out.println("향상된 for");
		for (MemberModel x : info) {
			x.displayInfo();
		}

		Iterator<MemberModel> info1 = info.iterator();

		System.out.println();
		System.out.println("iterator");
		while (info1.hasNext()) {
			info1.next().displayInfo();
			;
		}

		sc.close();

		System.out.println("\n프로그램 종료");
	} // end main()

} // end class
