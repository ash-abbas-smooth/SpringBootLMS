package com.smoothstack.avalanche.lmsspringboot.entity;

public class Genre {

	  private Integer genreId;
	  private String genreName;


	  public Integer getGenreId(){
	    return genreId;
	  }
	  public void setGenreId(Integer genreId){
	    this.genreId = genreId;
	  }


	  public String getGenreName(){
	    return genreName;
	  }
	  public void setGenreName(String genreName){
	    this.genreName = genreName;
	  }
	}