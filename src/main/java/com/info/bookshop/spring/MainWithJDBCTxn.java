package com.info.bookshop.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainWithJDBCTxn {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("springJdbcTxn.xml");
		BookShop bookShop = (BookShop) context.getBean("bookshop");
		bookShop.purchase("0001", 101);

	}

}
