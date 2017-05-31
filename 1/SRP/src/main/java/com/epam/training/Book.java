package com.epam.training;

public class Book {

	private String authorName;

	private String authorDescription;

	private int yearOfPublication;

	private String title;

	private String description;
	
	private Book() {
	}

	static public class BookBuilder{

		private String authorName;
		private String authorDescription;
		private int yearOfPublication;
		private String title;
		private String description;

		public void withAuthorDescription(String description) {
			this.authorDescription = description;
		}

		public void withAuthorName(String name) {
			this.authorName = name;
		}

		public void withYearOfPublication(int yearOfPublication) {
			this.yearOfPublication = yearOfPublication;
		}

		public void withTitle(String title) {
			this.title = title;
		}

		public void withDescription(String description) {
			this.description = description;
		}


		public Book build(){
			Book book = new Book();
			book.authorName = this.authorName;
			book.authorDescription = this.authorDescription;
			book.description = this.description;
			book.title = this.title;
			book.yearOfPublication = this.yearOfPublication;
			return book;
		}
	}

	public int getYearOfPublication() {
		return yearOfPublication;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public String getAuthorName() {
		return authorName;
	}

	public String getAuthorDescription() {
		return authorDescription;
	}

	@Override
	public String toString() {
		return "Book [authorName=" + authorName + ", authorDescription="
				+ authorDescription + ", yearOfPublication="
				+ yearOfPublication + ", title=" + title + ", description="
				+ description + "]";
	}

}
