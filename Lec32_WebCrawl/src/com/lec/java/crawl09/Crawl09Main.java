package com.lec.java.crawl09;

import java.io.IOException;
import java.net.URLEncoder;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

// 연습
// 네이버 '검색어'
// 블로그
//  -  post Title
//	-  post URL
//  -  blog Title
// 페이징 구현!

public class Crawl09Main {

	public static void main(String[] args) throws IOException {
		System.out.println("네이버 검색, 페이징");
		int count = 1;
		for (int i = 1; i <= 991; i += 10) {
			
				System.out.print(count + "번째 페이지");
				naverBlog("파이썬", i);
				count++;
			
		}

		System.out.println("\n 프로그램 종료");
	}

	public static void naverBlog(String search, int page) throws IOException {

		String url;
		Document doc;
		Response response;
		Element element;
		Elements elements;

		url = String.format(
				"https://search.naver.com/search.naver?date_from=&date_option=0&date_to=&dup_remove=1&nso=&post_blogurl=&post_blogurl_without=&query=%s&sm=tab_pge&srchby=all&st=sim&where=post&start=%d",
				URLEncoder.encode(search, "UTF-8"), page);

//		System.out.println(url);

		doc = Jsoup.connect(url).execute().parse();

		elements = doc.select(".sh_blog_top");
//		System.out.println(elements.size());

		for (Element e : elements) {
			String postTitle = e.selectFirst("dl > dt > a").text().trim();
//			System.out.println(postTitle);
			String postUrl = e.selectFirst("dl > dt > a").attr("href").trim();
			String blogTitle = e.selectFirst(".inline > a").text().trim();

			System.out.println(postTitle + " : " + blogTitle + " : " + postUrl);
		}

	}

}
