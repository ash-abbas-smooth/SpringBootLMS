package com.smoothstack.avalanche.lmsspringboot.dao;


import java.util.List;
import java.util.ArrayList;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;

import com.smoothstack.avalanche.lmsspringboot.entity.Book;
import com.smoothstack.avalanche.lmsspringboot.entity.Loan;
import com.smoothstack.avalanche.lmsspringboot.entity.Branch;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LoansDAO extends BaseDAO<Loan> {

  public LoansDAO(Connection conn) {
    super(conn);
  }

  public void addLoan(Integer bookId, Integer branchId, Integer cardNo ) throws ClassNotFoundException, SQLException {
    save("INSERT INTO tbl_book_loans (bookId, branchId, cardNo, dateOut, dueDate, dateIn) VALUES (?, ?, ?, CURDATE(), DATE_ADD(CURDATE(), INTERVAL 7 DAY), null)",
          new Object[] { bookId, branchId, cardNo });
  }

  public List<Loan> readLoans(Integer cardNo) throws ClassNotFoundException, SQLException {
    return read( "SELECT * FROM tbl_book_loans WHERE cardNo = ? AND dateIn = NULL", new Object[] { cardNo } );
  }

  public void returnLoan(Integer bookId, Integer branchId, Integer cardNo ) throws ClassNotFoundException, SQLException {
    save("UPDATE tbl_book_loans SET dateIn = CURDATE() WHERE bookId = ? AND branchId = ? AND cardNo = ?",
          new Object[] { bookId, branchId, cardNo });
  }

  @Override
  public List<Loan> extractData( ResultSet rs ) throws ClassNotFoundException, SQLException {

    List<Loan> loans = new ArrayList<>();

    BookDAO bdao = new BookDAO(conn);
    AuthorDAO adao = new AuthorDAO(conn);

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    while (rs.next()) {

      Loan loan = new Loan();
      loan.setBookId(rs.getInt("bookId"));
      loan.setBranchId(rs.getInt("branchId"));
      loan.setCardNo(rs.getInt("cardNo"));

      loan.setBookTitle(bdao.readFirstLevel(
  					"SELECT * FROM tbl_book where bookId = ?",
  					new Object[] { loan.getBookId() }).get(0).getTitle());

      loan.setBookAuthor(adao.readFirstLevel((""
        + "SELECT * FROM library.tbl_author WHERE authorId IN("
        + "SELECT authorId FROM tbl_book_authors WHERE bookId = ?)"
  			), new Object[] { loan.getBookId() }).get(0).getAuthorName());

      LocalDate dateOut = LocalDate.parse(rs.getString("dateOut"), formatter);
      LocalDate dueDate = LocalDate.parse(rs.getString("dueDate"), formatter);
      if(rs.getString("dateIn") != null){
        LocalDate dateIn = LocalDate.parse(rs.getString("dueDate"), formatter);
      }
      loan.setDateOut(dateOut);
      loan.setDueDate(dateOut);
      loan.setDateIn(dateOut);

      loans.add(loan);
    }
    return loans;
  }

  @Override
  public List<Loan> extractDataFirstLevel( ResultSet rs ) throws ClassNotFoundException, SQLException {
    List<Loan> loans = new ArrayList<>();
    while (rs.next()) {
      Loan loan = new Loan();
      loan.setBookId(rs.getInt("bookId"));
      loan.setBranchId(rs.getInt("branchId"));
      loan.setCardNo(rs.getInt("cardNo"));

      // loan.setDateOut(rs.getString("dateOut"));
      // loan.setDueDate(rs.getString("dueDate"));
      // loan.setDateIn(rs.getString("dateIn"));

      loans.add(loan);
    }
    return loans;
  }
}