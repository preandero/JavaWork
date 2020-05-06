package 반복제어문3.형성평가07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println(Solution.solution(10));
		
	}

	
}


class Solution {
	  public static long solution(long n) {
	      	long answer = 0;
	      
	      	String ia = Long.toString(n);
	      	
	      	ArrayList<Long> result = new ArrayList<Long>();
	      	
	      	for(int i =0 ; i < result.size();i++) {
	      		long lo = Long.parseLong(ia, ia.charAt(i));
	      		result.add(lo);
	      		System.out.println(result.get(i));
	      	}
	      	
	      	
	      	Collections.sort(result,Collections.reverseOrder());
	      	
	      	
	      	
	      	
	      	for(int i =0 ; i < result.size(); i++) {
	      		System.out.println(result.get(i));
	      		
	      		
	      	}
	      	
	      
	     
	      	
	      	
	      
	      
	      return answer;
	  }
	}