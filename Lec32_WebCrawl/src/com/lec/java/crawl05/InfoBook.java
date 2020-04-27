package com.lec.java.crawl05;

public class InfoBook {

	private String bookTitle; // 책제목
	private double price; // 책가격
	private String url; // 상세 페이지 url
	private String imgUrl; // 썸네일 url

	public InfoBook() {
	}

	public InfoBook(String bookTitle, double price, String url, String imgUrl) {
		this.bookTitle = bookTitle;
		this.price = price;
		this.imgUrl = imgUrl;
		this.url = url;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
	@Override
	public String toString() {
		return bookTitle + ":" + price + "원, URL: " + url + ", imgUrl: " + imgUrl;
	}

}
