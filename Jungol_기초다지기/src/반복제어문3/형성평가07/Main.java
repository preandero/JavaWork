package 반복제어문3.형성평가07;

import java.util.Date;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		parse("invalid");
	}

	public static void parse(String str) {

		float f = Float.parseFloat(str);
		try {

		} catch (NumberFormatException nfe) {

			f = 0;

		} finally {

			System.out.println(f);

		}

	}
}