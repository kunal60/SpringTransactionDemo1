package com.info.bookshop.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainWithoutTransaction {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		BookShop bookShop = (BookShop) context.getBean("bookshop");
		bookShop.purchase("0001", 101);
	}

}
