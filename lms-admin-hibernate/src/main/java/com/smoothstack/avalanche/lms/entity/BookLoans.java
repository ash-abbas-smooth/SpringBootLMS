package com.smoothstack.avalanche.lms.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_book_loans")
public class BookLoans {

	@EmbeddedId
	private BookLoanKey bookLoanKey;
    
    @Column(name = "dateOut")
	private Date dateOut;
    
    @Column(name = "dueDate")
	private Date dueDate;
    
    @Column(name = "dateIn")
	private Date dateIn;
    
    public BookLoans() {}
    
    public BookLoans(BookLoanKey bookLoanKey, Date dateOut, Date dueDate, Date dateIn) {
		super();
		this.bookLoanKey = bookLoanKey;
		this.dateOut = dateOut;
		this.dueDate = dueDate;
		this.dateIn = dateIn;
	}

	/*
     * Equals and Hash-code
     */
    
    /*
     * Getters and Setters
     */
	public BookLoanKey getBookLoanKey() {
		return bookLoanKey;
	}
	public void setBookLoanKey(BookLoanKey bookLoanKey) {
		this.bookLoanKey = bookLoanKey;
	}
	
	public Date getDateOut() {
		return dateOut;
	}
	public void setDateOut(Date dateOut) {
		this.dateOut = dateOut;
	}
	
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	
	public Date getDateIn() {
		return dateIn;
	}
	public void setDateIn(Date dateIn) {
		this.dateIn = dateIn;
	}
}
