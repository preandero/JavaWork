package practice.wordcount;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.stream.Stream;

/* 1] 문서(문자열) 안의 단어의 빈도수를 계수해서 출력하기
 * 	- 대소문자 구분하지 않기 :   The 와 the 는 같은 단어
 *  - 2글자 이상만 계수하기
 *  - 구두점/기호 ",.\"\'`!?;:-()" 잘라내기
 *  - 공백 짤라내기
 * ex)
 * 	an : 234
 * 	the : 314
 * ...
 * 
 * hint]
 * 	split("\\s+")  --> String[]   
 * 	--> StringTokenizer  (혹은 정규표현식)
 *  	  --> HashMap<String, Integer>   <단어, 빈도수>  사용
 * ───────────────────────────────────────────────────────────    
 * 2] 빈도수 내림차순으로 정렬하여 출력하기
 * 	ex)
 *	1 the:113개
 *	2 she:95개
 *	3 to:85개
 *	...   
 *
 * hint]
 * 	Comparable<> 이나 Comparator<> 적용
 */

// TODO : 필요한 객체들 작성
// hint> 빈도수 담을 객체, Comparator<> ..

public class AliceInWonderland {

	public static void main(String[] args) {
		System.out.println("실습: 단어 발생 빈도");
		int count = 1;
		HashMap<String, Integer> hmap = new HashMap<String, Integer>();
		String result = "";
		String[] words = C.ALICE30.trim().toLowerCase().split("\\s+");
		for (int i = 0; i < words.length; i++) {
			result += words[i] + ".";
		}
		StringTokenizer wordtokens = new StringTokenizer(result, ",.'`!?;:-()_\"");

		// 발생빈도 작성
		while (wordtokens.hasMoreTokens()) {
			String token = wordtokens.nextToken();
			if (token.length() >= 2) {
				if (hmap.get(token) == null) {
					hmap.put(token, 1);
				} else {
					hmap.put(token, hmap.get(token) + 1);
				}
			}
		}

		// 결과 출력
		/*
		 * Stream Stream map = hmap. entrySet(). stream().
		 * sorted(Map.Entry.<String,Integer>comparingByValue().reversed());
		 * 
		 * Iterator<Stream> mapStream = map.iterator();
		 * 
		 * while(mapStream.hasNext()) {
		 * 
		 * System.out.println(count + " " + mapStream.next() + "개"); count++; };
		 * Practice
		 */

		List<Map.Entry<String, Integer>> maplist = new ArrayList<Map.Entry<String, Integer>>(hmap.entrySet());

		Collections.sort(maplist, new Desc());
		
		for (Map.Entry<String, Integer> e : maplist) {
			System.out.println(count + " " + e.getKey() + " : " + e.getValue() + "개");
			count++;
		}

		System.out.println("\n프로그램 종료");
	} // end main()

} // end class

class Desc implements Comparator<Map.Entry<String, Integer>> {

	@Override
	public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
		return o2.getValue().compareTo(o1.getValue());
	}

}
