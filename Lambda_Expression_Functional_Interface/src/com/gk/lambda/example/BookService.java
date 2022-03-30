package com.gk.lambda.example;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BookService {

	public List<Book> getBooksInSort() {

		List<Book> books = new BookDao().getBooks();

		// By Passing Anonymous Class(Its mainly used when interface contains multiple
		// abstract methods)
		Collections.sort(books, new Comparator<Book>() {

			@Override
			public int compare(Book o1, Book o2) {
				// TODO Auto-generated method stub
				return o1.getName().compareTo(o2.getName());
			}

		});
		return books;

	}

	// Above Method with Lambda Expression
	public List<Book> getBooksInSortWithLambda() {

		List<Book> books = new BookDao().getBooks();

		if (!books.isEmpty()) {
			// Because Comparator is a functional Interface we can directly apply lambda
			Comparator<Book> compareByName = (Book o1, Book o2) -> o1.getName().compareTo(o2.getName());
			Collections.sort(books, compareByName);
		}

		return books;

	}

	public static void main(String[] args) {
		System.out.println(new BookService().getBooksInSort());
		// [Book [id=3, name=Hibernate, pages=150], Book [id=1, name=Java, pages=800],
		// Book [id=2, name=Jdbc, pages=200], Book [id=4, name=Spring, pages=1000]]

		System.out.println(new BookService().getBooksInSortWithLambda());
		// [Book [id=3, name=Hibernate, pages=150], Book [id=1, name=Java, pages=800],
		// Book [id=2, name=Jdbc, pages=200], Book [id=4, name=Spring, pages=1000]]
	}

}

//Traditional Approach
//class MyComparator implements Comparator<Book> {
//
//	@Override
//	public int compare(Book o1, Book o2) {
//
//		return o1.getName().compareTo(o2.getName());
//	}
//
//}