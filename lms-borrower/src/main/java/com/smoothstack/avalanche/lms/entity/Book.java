/**
 * 
 */
package com.smoothstack.avalanche.lms.entity;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Ashian
 *
 */
@Entity
@Table (name = "tbl_book")
public class Book 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookId;
	@Column(name = "title")
	private String title;
	
	@ManyToMany(mappedBy ="books", cascade = CascadeType.ALL)
	private List<Author> authors;
	@ManyToMany(mappedBy = "books", cascade = CascadeType.ALL)
	private List<Genre> genres;
	@OneToMany(
			mappedBy = "id.book",
			cascade = CascadeType.ALL,
			orphanRemoval = true
			)
	private List<BookCopies> bookCopies;
	
	@OneToMany(mappedBy = "id.book", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<BookLoans> bookLoans;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)	
	@JoinColumn(name = "publisher_id", nullable = false)
	private Publisher publisher;
	
	public Book() {}
	
	public Book(int bookId, String title, List<Author> authors, List<BookCopies> bookCopies, List<BookLoans> bookLoans, List<Genre> genres, Publisher publisher) {
	super();
	this.bookId = bookId;
	this.title = title;
	this.authors = authors;
	this.bookCopies = bookCopies;
	this.bookLoans = bookLoans;
	this.genres = genres;
	this.publisher = publisher;
}

	/*
	 * Getters / Setters
	 */
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<Author> getAuthors() {
		return authors;
	}
	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
	
	public List<Genre> getGenres(){
		return genres;
	}
	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	/*
	 * Equals / Hashcode
	 */
	@Override
	public boolean equals(Object o)
	{
		if(this == o) return true;
		if( o == null || getClass() != o.getClass()) return false;
		Book other = (Book) o;
		return Objects.equals(getTitle(), other.getTitle()); //&& Objects.equals(getAuthors(), other.getAuthors());
				//&& Objects.equals(getPublisher(), other.getPublisher());
	}
	@Override
	public int hashCode()
	{
		return Objects.hash(bookId, title);
	}
}
