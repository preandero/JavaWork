package com.lec.java.crawl13;

import java.util.List;

public class User {
	private String name;
	private int age;
	private List<String> messages;
	private score score1;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public List<String> getMessages() {
		return messages;
	}
	public void setMessages(List<String> messages) {
		this.messages = messages;
	}
	
	@Override
	public String toString() {
		return "[name:" + name + ",age:" +age + ",messages:" +messages + "]";
	}
	public score getScore1() {
		return score1;
	}
	public void setScore1(score score1) {
		this.score1 = score1;
	}
	
	
	
}
