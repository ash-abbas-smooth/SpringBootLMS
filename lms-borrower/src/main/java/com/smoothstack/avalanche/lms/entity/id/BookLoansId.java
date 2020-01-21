package com.smoothstack.avalanche.lms.entity.id;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.smoothstack.avalanche.lms.entity.Book;
import com.smoothstack.avalanche.lms.entity.Borrower;
import com.smoothstack.avalanche.lms.entity.Branch;

@Embeddable
public class BookLoansId implements Serializable{

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)	
	@JoinColumn(name = "bookId", nullable = false)
	private Book book;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "branchId", nullable = false)
	private Branch branch;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "cardNo", nullable = false)
	private Borrower borrower;
	
	
	public BookLoansId() {}
	public BookLoansId(Book book, Branch branch, Borrower borrower)
	{
		this.book = book;
		this.branch = branch;
		this.borrower = borrower;
	}
	/*
	 * getters / setters
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

	public Borrower getBorrower() {
		return borrower;
	}

	public void setCard(Borrower borrower) {
		this.borrower = borrower;
	}

	/*
	 * equals / hashcode
	 */
	@Override
	public boolean equals(Object o)
	{
		if(this == o) return true;
		if(o == null || getClass() != o.getClass())
			return false;
		BookLoansId that = (BookLoansId) o;
			return Objects.equals(book, that.getBook()) && Objects.equals(branch, that.getBranch()) && Objects.equals(borrower, that.getBorrower());
	}
	
	@Override
	public int hashCode()
	{
		return Objects.hash(book,branch,borrower);
	}
}
