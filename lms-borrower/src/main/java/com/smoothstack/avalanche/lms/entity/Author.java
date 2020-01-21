package com.smoothstack.avalanche.lms.entity;

import java.util.List;
import java.util.Objects;

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
public class Author 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int authorId;
	
	@Column( name = "authorName")
	private String authorName;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "tbl_book_authors",
			joinColumns = { @JoinColumn(name = "authorId")},
			inverseJoinColumns ={ @JoinColumn(name = "bookId")})
	private List<Book> books;
	
	public Author() {}
	public Author(int authorId, String name)
	{
		this.authorId = authorId;
		this.authorName = name;
	}
	/*
	 * Getters / Setters
	 */
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	/*
	 * Equals/ HashCode
	 */
	@Override
	public boolean equals(Object o)
	{
		if( this == o) return true;
		if( o == null || getClass() != o.getClass())
			return false;
		Author other = (Author) o;
		return Objects.equals(getAuthorName(), other.getAuthorName());
	}
	
	@Override
	public int hashCode()
	{
		return Objects.hash(authorName);
	}
}
