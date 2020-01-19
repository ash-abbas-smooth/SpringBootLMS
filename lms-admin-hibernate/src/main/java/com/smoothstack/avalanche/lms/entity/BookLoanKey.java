package com.smoothstack.avalanche.lms.entity;

import java.io.Serializable;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class BookLoanKey implements Serializable {

	private static final long serialVersionUID = 3071037665384069914L;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "bookId", nullable = false)
	private Book book;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "branchId", nullable = false)
	private Branch branch;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cardNo", nullable = false)
	private Borrower borrower;
    /*
     * Equals and Hash-code
     */
    
    /*
     * Getters and Setters
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
	public void setBorrower(Borrower borrower) {
		this.borrower = borrower;
	}
}
