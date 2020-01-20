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
	private BookCopiesId id;
	
	@Column(name ="noOfCopies")
	private int noOfCopies;
	
	public BookCopies(BookCopiesId bookCopiesId, Book book, Branch branch, int noOfCopies) {
		this.id = bookCopiesId;
		this.noOfCopies = noOfCopies;
	}

	public BookCopies() {}
	/*
	 * GETTERS / SETTERS
	 */
	public BookCopiesId getBookCopiesId() {
		return id;
	}

	public void setBookCopiesId(BookCopiesId bookCopiesId) {
		this.id = bookCopiesId;
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
		return Objects.hash(id, noOfCopies);
	}

	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;
		BookCopies other = (BookCopies) o;
		return Objects.equals(getBookCopiesId(), other.getBookCopiesId()) && Objects.equals(getNoOfCopies(), other.getNoOfCopies());
	}

	
}
