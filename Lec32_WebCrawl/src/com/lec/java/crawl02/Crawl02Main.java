package com.lec.java.crawl02;

import java.io.IOException;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawl02Main {

	public static void main(String[] args) throws IOException {

		System.out.println("네이트 인기 검색어");
		
		
		Document nate;
		Element element;
		Response response;
		Elements elements;
		
		String url = "https://www.nate.com";
		
		response = Jsoup.connect(url).execute();
		
		System.out.println(response.statusCode());
		nate = response.parse();
		
		
		
		elements = nate.select("div.search_keyword dl dd a");
		
		for(Element e: elements) {
			System.out.println(e.text());
			System.out.println(e.attr("href").trim());
		}
		
		
		
		
		
		
		//www.nate.com
		
		
		
		
		
		
		System.out.println("\n프로그램 종료");
		
	}

}
