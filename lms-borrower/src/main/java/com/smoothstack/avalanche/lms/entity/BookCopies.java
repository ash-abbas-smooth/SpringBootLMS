/**
 * 
 */
package com.smoothstack.avalanche.lms.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.smoothstack.avalanche.lms.entity.id.BookCopiesId;

/**
 * @author Ashian
 *
 */
@Entity
@Table(name = "tbl_book_copies")
public class BookCopies {
	
	@EmbeddedId
	private BookCopiesId bookCopiesId;
	
	@ManyToOne
	@MapsId("bookId")
	@JoinColumn(name = "bookId")
	private Book book;
	
	@ManyToOne
	@MapsId("branchId")
	@JoinColumn(name = "branchId")
	private Branch branch;
	
	@Column(name ="noOfCopies")
	private int noOfCopies;
	
	public BookCopies(BookCopiesId bookCopiesId, Book book, Branch branch, int noOfCopies) {
		this.bookCopiesId = bookCopiesId;
		this.book = book;
		this.branch = branch;
		this.noOfCopies = noOfCopies;
	}

	/*
	 * GETTERS / SETTERS
	 */
	public BookCopiesId getBookCopiesId() {
		return bookCopiesId;
	}

	public void setBookCopiesId(BookCopiesId bookCopiesId) {
		this.bookCopiesId = bookCopiesId;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public int getNoOfCopies() {
		return noOfCopies;
	}

	public void setNoOfCopies(int noOfCopies) {
		this.noOfCopies = noOfCopies;
	}

	/*
	 * Equals / Hashcode
	 */
	@Override
	public int hashCode() {
		return Objects.hash(book, branch);
	}

	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;
		BookCopies other = (BookCopies) o;
		return Objects.equals(getBook(), other.getBook()) && Objects.equals(getBranch(), other.getBranch());
	}

	
}
