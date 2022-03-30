package com.gk.lambda.example;

import java.util.ArrayList;
import java.util.List;

public class BookDao {

	public List<Book> getBooks() {

		// static data
		List<Book> bookList = new ArrayList<>();
		bookList.add(new Book(1, "Java", 800));
		bookList.add(new Book(2, "Jdbc", 200));
		bookList.add(new Book(3, "Hibernate", 150));
		bookList.add(new Book(4, "Spring", 1000));

		return bookList;

	}

}
