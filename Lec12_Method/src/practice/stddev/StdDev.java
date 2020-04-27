package practice.stddev;

import java.util.Arrays;

public class StdDev {

	public static void main(String[] args) {

		int[] intarray = new int[5];
		for (int i = 0; i < intarray.length; i++) {
			intarray[i] = (int) (Math.random() * 100) + 1;
			System.out.print(intarray[i] + "  ");
		}
		System.out.println();
		System.out.println("평균 : " + calcAvg(intarray));
		System.out.println("분산 : " + calcVariance(intarray));
		System.out.println("표준편차 : " + calcStdDev(intarray));

		// 임의정수 5개로 초기화한 정수로
		// 평균, 분산, 표준편차 구하기

	} // end main

	
	/**
	 * 메소드 이름 : calcAvg 매개변수 : int [] 리턴값 : double
	 * 
	 * 주어진 배열의 '평균값' 리턴
	 */
	public static double calcAvg(int[] avg) {
		double total = 0;
		for (int i = 0; i < avg.length; i++) {
			total += (double) avg[i];
		}
		return (total / avg.length);
	}

	/**
	 * 메소드 이름 : calcVariance 매개변수 : int [] 리턴값 : double
	 * 
	 * 주어진 배열의 '분산값' 리턴
	 */
	public static double calcVariance(int[] var) {
		double dispersion = 0;
		for (int i = 0; i < var.length; i++) {
			double deviation = (var[i] - calcAvg(var));
			double deviationmul = (deviation * deviation);
			dispersion += deviationmul;
		}

		return dispersion / var.length;

	}

	/**
	 * 메소드 이름 : calcStdDev 매개변수 : int [] 리턴값 : double
	 * 
	 * 주어진 배열의 '표준편차' 리턴
	 */
	public static double calcStdDev(int[] std) {
		return Math.sqrt(calcVariance(std));
	}

} // end class
