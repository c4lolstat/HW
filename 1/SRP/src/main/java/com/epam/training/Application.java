package com.epam.training;

import java.util.ArrayList;
import java.util.List;

public class Application {

	public Application() {
		
	}
	
	public void start() {
		List<Book> books = new ArrayList<Book>();
		Book book = createBook();
		books.add(book);
		System.out.println(books);
	}

	private Book createBook() {
		Book.BookBuilder builder = new Book.BookBuilder();
		builder.withTitle("Introduction to the Theory of Programming Languages and Touch of Class");
		builder.withAuthorName("Bertrand Meyer");
		builder.withAuthorDescription("French academic, author, and consultant in the field of computer languages");
		builder.withDescription("This book is an excellent reference for understanding how to architect a language");
		builder.withYearOfPublication(1990);
		return builder.build();
	}
	
	public static void main(String[] args) {
		new Application().start();
	}
}
