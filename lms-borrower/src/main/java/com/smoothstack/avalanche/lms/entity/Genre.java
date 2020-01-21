package com.smoothstack.avalanche.lms.entity;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_genre")
public class Genre 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int genreId;
	
	@Column(name = "genre_name")
	private String genreName;
	
	
	public Genre() {}
	
	public Genre(int genreId, String genreName) {
		super();
		this.genreId = genreId;
		this.genreName = genreName;
	}
	/*
	 * GETTERS/SETTERS
	 */
	public int getGenreId() {
		return genreId;
	}
	public void setGenreId(int genreId) {
		this.genreId = genreId;
	}
	public String getGenreName() {
		return genreName;
	}
	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}

	/*
	 * EQUALS/HASH
	 */
	@Override
	public int hashCode() {
		return Objects.hash(genreName);
	}
	@Override
	public boolean equals(Object o)
	{
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;
		Genre other = (Genre) o;
		return Objects.equals(getGenreName(), other.getGenreName());
	}
	
	
}
