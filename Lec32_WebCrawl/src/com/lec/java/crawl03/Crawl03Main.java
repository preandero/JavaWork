package com.lec.java.crawl03;

import java.io.IOException;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawl03Main {
	public static void main(String[] args) throws IOException {
		System.out.println("Daum 실시간 검색어");
		
		Document daum;
		Element element;
		Response response;
		Elements elements;
		
		String url = "http://www.daum.net";
		response = Jsoup.connect(url).execute();
		
		
		daum = response.parse();
		
		
		elements = daum.select("div.slide_favorsch ul li a");
		System.out.println(elements.size()+ "개");
		for(Element e : elements ) {
			System.out.println(e.text());
			System.out.println(e.attr("href").trim());
		}
		
		
		
		
		
		
		// http://www.daum.net
		// 15개
		
		
		
		System.out.println("\n프로그램 종료");
	}
}
