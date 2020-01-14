package com.smoothstack.avalanche.lmsspringboot.dao;

import com.smoothstack.avalanche.lmsspringboot.entity.Copies;

import java.util.List;
import java.util.ArrayList;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;

public class BookCopiesDAO extends BaseDAO<Copies> {

  public BookCopiesDAO(Connection conn) {
    super(conn);
  }

  public List<Copies> readBooks(Integer branchId) throws ClassNotFoundException, SQLException {
    return read( "SELECT * FROM tbl_book_copies WHERE branchId = ?", new Object[] { branchId } );
  }

  public List<Copies> readCopies(Integer branchId, Integer bookId) throws ClassNotFoundException, SQLException {
    return read( "SELECT * FROM tbl_book_copies WHERE branchId = ? AND bookId = ?", new Object[] { branchId, bookId });
  }

  public void updateBookCopies(Integer noOfCopies, Integer bookId, Integer branchId ) throws ClassNotFoundException, SQLException {
    save("UPDATE tbl_book_copies SET noOfCopies = ? WHERE bookId = ? AND branchId = ?", new Object[] { noOfCopies, bookId, branchId });
  }

	@Override
	public List<Copies> extractData( ResultSet rs ) throws SQLException, ClassNotFoundException {

    List<Copies> copies = new ArrayList<>();

		while (rs.next()) {

			Copies copy = new Copies();

			copy.setBookId(rs.getInt("bookId"));
			copy.setBranchId(rs.getInt("branchId"));
      copy.setCopies(rs.getInt("noOfCopies"));

			copies.add(copy);
		}
		return copies;
	}

	@Override
	public List<Copies> extractDataFirstLevel(ResultSet rs) throws SQLException, ClassNotFoundException {
    List<Copies> copies = new ArrayList<>();

    // while (rs.next()) {
		// 	Book book = new Book();
		// 	book.setBookId(rs.getInt("bookId"));
		// 	book.setBookTitle(rs.getString("title"));
		// 	books.add(book);
		// }
		return copies;
	}
}