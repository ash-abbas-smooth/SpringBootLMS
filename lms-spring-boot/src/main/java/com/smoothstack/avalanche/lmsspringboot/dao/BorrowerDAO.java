package com.smoothstack.avalanche.lmsspringboot.dao;

import com.smoothstack.avalanche.lmsspringboot.entity.Borrower;
import com.smoothstack.avalanche.lmsspringboot.entity.Book;

import java.util.List;
import java.util.ArrayList;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;

public class BorrowerDAO extends BaseDAO<Borrower> {

  public BorrowerDAO(Connection conn) {
    super(conn);
  }

  public List<Borrower> readBorrowers() throws ClassNotFoundException, SQLException {
    return read("SELECT * FROM tbl_borrower", null);
  }

	@Override
	public List<Borrower> extractData( ResultSet rs ) throws ClassNotFoundException, SQLException {

    List<Borrower> borrowers = new ArrayList<>();
    while(rs.next()){
      Borrower borrower = new Borrower();
      borrower.setCardNo(rs.getInt("cardNo"));
      borrower.setName(rs.getString("name"));
      borrower.setPhone(rs.getString("phone"));
      borrower.setAddress(rs.getString("address"));
      borrowers.add(borrower);
    }
		return borrowers;
	}

	@Override
	public List<Borrower> extractDataFirstLevel(ResultSet rs) throws ClassNotFoundException, SQLException {

    List<Borrower> borrowers = new ArrayList<>();
    return borrowers;
	}
}