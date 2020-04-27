package com.lec.java.crawl00;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawl00Main {

	public static void main(String[] args) throws IOException {
		System.out.println("Jsoup");
		
		Element element;
		Elements elements;
		
		
		File f = new File("data/hello.html");
		
		Document doc = Jsoup.parse(f,"UTF-8");	// 파일 -> Document 변환(DOM구조 변환)
		
		
		// System.out.println(doc.outerHtml());  
		
		
		
		element = doc.selectFirst("div");
		
//		System.out.println(element.outerHtml());
		
		elements = doc.select("div");
		System.out.println(elements.size() + "개");
		
		// Elements 의 get(n) -> n번째 Element return!
//		element = elements.get(3);
//		System.out.println(element.outerHtml());
		
//		for (int i = 0; i < elements.size(); i++) {
//			System.out.println(elements.get(i).outerHtml());
//			System.out.println();
//		}
		
//		for(Element e : elements) {
//			System.out.println(e.outerHtml());
//			System.out.println();
//		}
		
		element = doc.selectFirst("div#addr");
		System.out.println(element.outerHtml());
		
		elements = element.select("ul.favorite a");
		System.out.println(elements.size() + "개");
		
		
		for(Element e : elements) {
//			System.out.println(e.outerHtml());
			System.out.println(e.text().trim());
			System.out.println(e.attr("href").trim());
		}
		System.out.println();
		
		elements = doc.select("div.article img");
		
		for(Element e : elements) {
			System.out.println(e.attr("src").trim());
			System.out.println();
		}
		
		
		
		System.out.println("\n 프로그램 종료");
	}

}
