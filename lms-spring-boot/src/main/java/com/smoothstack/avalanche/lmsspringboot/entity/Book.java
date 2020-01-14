package com.smoothstack.avalanche.lmsspringboot.entity;


import java.util.List;

public class Book {

	private String title;
	private Integer bookId;
	private List<Author> authors;
	private List<BookGenre> bookGenres;
	private List<Branch> branches;
	private Publisher publisher;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public List<BookGenre> getBookGenres() {
		return bookGenres;
	}

	public void setBookGenres(List<BookGenre> bookGenres) {
		this.bookGenres = bookGenres;
	}

	public List<Branch> getBranches() {
		return branches;
	}

	public void setBranches(List<Branch> branches) {
		this.branches = branches;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
}
