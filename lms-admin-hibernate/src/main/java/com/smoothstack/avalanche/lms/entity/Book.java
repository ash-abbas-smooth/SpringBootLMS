package com.smoothstack.avalanche.lms.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

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

import com.smoothstack.avalanche.lms.entity.BookLoans;

@Entity
@Table(name = "tbl_book")
public class Book{
	

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bookId")
	private Integer bookId;
    
    @Column(name = "title")
	private String title;
    
    @ManyToMany(mappedBy = "authorBooks")
    private Set<Author> bookAuthors;
    
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "pubId")
	private Publisher publisher;
	
	@OneToMany(mappedBy = "bookLoanKey.book")
	private List<BookLoans> loanBooks;
    /*
     * Equals and Hash-code
     */
    public Book() {}
    public Book(Integer bookId, String title, Set<Author> bookAuthors, Publisher publisher, List<BookLoans> loanBooks) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.bookAuthors = bookAuthors;
		this.publisher = publisher;
		this.loanBooks = loanBooks;
	}
	/*
     * Getters and Setters
     */
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Publisher getPublisher() {
		return publisher;
	}
	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	
	public Set<Author> getBookAuthors() {
		return bookAuthors;
	}
	public void setBookAuthors(Set<Author> bookAuthors) {
		this.bookAuthors = bookAuthors;
	}
	
}
