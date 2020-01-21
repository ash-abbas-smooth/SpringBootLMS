package com.smoothstack.avalanche.lms.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_author")
public class Author{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "authorId")
	private Integer authorId;
    
    @Column(name = "authorName")
	private String authorName;
    
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
    		name = "tbl_book_authors",
    		joinColumns = { @JoinColumn(name = "authorId") },
    		inverseJoinColumns = { @JoinColumn(name = "bookId") })
    private Set<Book> authorBooks;

    public Author() {}
    public Author(Integer authorId, String authorName, Set<Book> authorBooks) {
		super();
		this.authorId = authorId;
		this.authorName = authorName;
		this.authorBooks = authorBooks;
	}
	/*
     * Equals and Hash-code
     */
    
    /*
     * Getters and Setters
     */
	public Integer getAuthorId() {
		return authorId;
	}
	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}
	
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
}
