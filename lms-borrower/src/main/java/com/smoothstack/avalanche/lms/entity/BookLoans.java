package com.smoothstack.avalanche.lms.entity;

import java.sql.Date;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.smoothstack.avalanche.lms.entity.id.BookLoansId;

@Entity
@Table(name = "tbl_book_loans")
public class BookLoans {
	
	@EmbeddedId
	private BookLoansId id;
	
	@Column(name ="dateOut")
	private Date dateOut;
	
	@Column (name ="dueDate")
	private Date dueDate;
	
	@Column(name = "dateIn")
	private Date dateIn;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@MapsId("bookId")
	@JoinColumn(name = "bookId")
	private Book book;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@MapsId("branchId")
	@JoinColumn(name = "branchId")
	private Branch branch;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@MapsId("cardNo")
	@JoinColumn(name ="cardNo")
	private Borrower borrower;
	
	/*
	 * Getters / Setters
	 */
	public BookLoansId getId() {
		return id;
	}
	public void setId(BookLoansId id) {
		this.id = id;
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
	/*
	 * Equals / Hash
	 */
	@Override
	public boolean equals(Object o)
	{
		if(this == o) return true;
		if(o == null || getClass() != o.getClass())
			return false;
		BookLoans that = (BookLoans) o;
			return Objects.equals(getDateOut(), that.getDateOut()) 
					&& Objects.equals(getDueDate(), that.getDueDate())
					&& Objects.equals(getBook(), that.getBook())
					&& Objects.equals(getBorrower(), that.getBorrower())
					&& Objects.equals(getBranch(), that.getBranch());
	}
	
	@Override
	public int hashCode()
	{
		return Objects.hash(book, borrower, branch, dateOut, dueDate);
	}
}
