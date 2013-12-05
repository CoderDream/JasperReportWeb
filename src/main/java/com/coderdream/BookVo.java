package com.coderdream;

public class BookVo {

	private int id;
	private String name;
	private String author;

	// 无参数的构造器
	public BookVo() {
	}

	// 初始化全部属性的构造器
	public BookVo(int id, String name, String author) {
		this.id = id;
		this.name = name;
		this.author = author;
	}

	// id属性的setter和getter方法
	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}

	// name属性的setter和getter方法
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	// author属性的setter和getter方法
	public void setAuthor(String author) {
		this.author = author;
	}

	public String getAuthor() {
		return this.author;
	}
}