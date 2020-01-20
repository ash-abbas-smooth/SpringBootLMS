/**
 * 
 */
package com.smoothstack.avalanche.lms.entity;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
	
//	@ManyToOne
//	@JoinColumn(name = "pubId", referencedColumnName = "publisherId")
//	private Publisher publisher;
	
	@ManyToMany(mappedBy ="books", cascade = CascadeType.ALL)
	private List<Author> authors;
	
	@OneToMany(
			mappedBy = "id.book",
			cascade = CascadeType.ALL,
			orphanRemoval = true
			)
	private List<BookCopies> bookCopies;
//	
	@OneToMany(mappedBy = "id.book", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<BookLoans> bookLoans;
////	
//	@OneToMany(
//			mappedBy ="book",
//			cascade = CascadeType.ALL,
//			orphanRemoval = true
//			)
//	private List<BookGenre> genres;
	
	public Book() {}
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
//	public Publisher getPublisher() {
//		return publisher;
//	}
	public List<Author> getAuthors() {
		return authors;
	}
	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
//	public List<BookCopies> getBookCopies() {
//		return bookCopies;
//	}
//	public void setBookCopies(List<BookCopies> bookCopies) {
//		this.bookCopies = bookCopies;
//	}
//	public List<BookLoans> getBookLoans() {
//		return bookLoans;
//	}
//	public void setBookLoans(List<BookLoans> bookLoans) {
//		this.bookLoans = bookLoans;
//	}
//	public void setPublisher(Publisher publisher) {
//		this.publisher = publisher;
//	}
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
