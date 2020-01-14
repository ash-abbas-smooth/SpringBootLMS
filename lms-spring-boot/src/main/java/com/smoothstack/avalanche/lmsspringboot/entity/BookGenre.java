package com.smoothstack.avalanche.lmsspringboot.entity;

public class BookGenre {

	  private Integer bookId;
	  private Integer genreId;


	  public Integer getGenreId(){
	    return genreId;
	  }
	  public void setGenreId(Integer genreId){
	    this.genreId = genreId;
	  }


	  public Integer getBookId(){
	    return bookId;
	  }
	  public void setBookId(Integer bookId){
	    this.bookId = bookId;
	  }
	}
