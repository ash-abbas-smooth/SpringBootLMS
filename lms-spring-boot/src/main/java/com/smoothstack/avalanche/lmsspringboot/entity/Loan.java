package com.smoothstack.avalanche.lmsspringboot.entity;

import java.time.LocalDate;

public class Loan {

  private Integer cardNo;
  private Integer bookId;
  private Integer branchId;
  private LocalDate dateOut;
  private LocalDate dueDate;
  private LocalDate dateIn;

  private String bookTitle;
  private String bookAuthor;


  public Integer getBookId(){
    return bookId;
  }
  public void setBookId(Integer bookId){
    this.bookId = bookId;
  }

  public Integer getBranchId(){
    return branchId;
  }
  public void setBranchId(Integer branchId){
    this.branchId = branchId;
  }

  public Integer getCardNo(){
    return cardNo;
  }

  public void setCardNo(Integer cardNo){
    this.cardNo = cardNo;
  }

  public String getBookTitle(){
    return bookTitle;
  }
  public void setBookTitle(String bookTitle){
    this.bookTitle = bookTitle;
  }

  public String getBookAuthor(){
    return bookAuthor;
  }
  public void setBookAuthor(String bookAuthor){
    this.bookAuthor = bookAuthor;
  }

  public LocalDate getDateOut(){
    return dateOut;
  }
  public void setDateOut(LocalDate dateOut){
    this.dateOut = dateOut;
  }

  public LocalDate getDateIn(){
    return dateOut;
  }
  public void setDateIn(LocalDate dateIn){
    this.dateIn = dateIn;
  }

  public LocalDate getDueDate(){
    return dueDate;
  }
  public void setDueDate(LocalDate dueDate){
    this.dueDate = dueDate;
  }
}