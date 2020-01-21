package com.smoothstack.avalanche.lmsorchs.entity;

import java.sql.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.smoothstack.avalanche.lmsorchs.entity.id.BookLoansId;

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
				&& Objects.equals(getDateIn(), that.getDateIn());
	}
	@Override
	public int hashCode()
	{
		return Objects.hash(dateOut, dueDate, dateIn);
	}
}
