package com.smoothstack.avalanche.lmsspringboot.entity;

import java.util.List;

public class Copies {


  private Integer bookId;
  private Integer copies;
  private Integer branchId;

  public Integer getBookId() {
    return bookId;
  }

  public void setBookId( Integer bookId ) {
    this.bookId = bookId;
  }

  public Integer getBranchId() {
		return branchId;
	}

  public void setBranchId(Integer branchId) {
    this.branchId = branchId;
  }

  public Integer getCopies() {
    return copies;
  }

  public void setCopies(Integer copies) {
    this.copies = copies;
  }
}
