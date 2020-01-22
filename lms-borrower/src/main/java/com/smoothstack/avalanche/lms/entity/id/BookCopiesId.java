package com.smoothstack.avalanche.lms.entity.id;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.smoothstack.avalanche.lms.entity.Book;
import com.smoothstack.avalanche.lms.entity.Branch;

@Embeddable
public class BookCopiesId implements Serializable{
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "bookId", nullable = false)
	private Book book;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "branchId", nullable = false)
	private Branch branch;
	
	/*
	 * getters/setters
	 */

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

	/*
	 * Equals and HashCode
	 */
	@Override
	public boolean equals(Object o)
	{
		if(this == o) return true;
		if(o == null || getClass() != o.getClass())
			return false;
		BookCopiesId that = (BookCopiesId) o;
			return Objects.equals(getBook(), that.getBook()) && Objects.equals(getBranch(), that.getBranch());
	}
	
	@Override
	public int hashCode()
	{
		return Objects.hash(book, branch);
	}
}
