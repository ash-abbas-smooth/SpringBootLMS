package com.smoothstack.avalanche.lms.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.smoothstack.avalanche.lms.entity.BookCopies;

public class BookCopiesDAO extends BaseDAO<BookCopies> implements ResultSetExtractor<List<BookCopies>>
{
	/*****************************************************************************
	>>	CREATE OPERATIONS
	*****************************************************************************/

	// [ 1 ] -- Create book copies in branch
	public void createBookCopies(BookCopies bc) throws ClassNotFoundException, SQLException
	{
		mySqlTemplate.update("INSERT INTO tbl_book_copies (bookId, branchId, noOfCopies) values (?)", new Object[] {bc.getBookId(),bc.getBranchId(),bc.getNoOfCopies()});
	}

	// [ 2 ] -- Create book copies with ID as return value
	public Integer createBookCopiesWithID(BookCopies bc) throws ClassNotFoundException, SQLException
	{
		String sql = "INSERT INTO tbl_book_copies (bookId, branchId, noOfCopies) values (?,?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();

		mySqlTemplate.update(connection -> {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, bc.getBookId());
			ps.setInt(2, bc.getBranchId());
			ps.setInt(3, bc.getNoOfCopies());
			return ps;
		}, keyHolder);

		return (Integer) keyHolder.getKey();
	}

	/*****************************************************************************
	>>	READ OPERATIONS
	*****************************************************************************/

	// [ 1 ] -- Read all book copies
	public List<BookCopies> readBookCopies() throws ClassNotFoundException, SQLException
	{
		return mySqlTemplate.query("SELECT * FROM tbl_book_copies", this);
	}

	// [ 2 ] -- Read book copies by branch
	public List<BookCopies> readBookCopiesByBranch(int branchID) throws ClassNotFoundException, SQLException
	{
		return mySqlTemplate.query("SELECT * FROM tbl_book_copies WHERE branchId = ?", new Object[] {branchID}, this);
	}

	/*****************************************************************************
	>>	UPDATE OPERATIONS
	*****************************************************************************/

	// [ 1 ] -- Update book copies by branch
	public void updateBookCopies(BookCopies bc) throws ClassNotFoundException, SQLException
	{
		mySqlTemplate.update("UPDATE tbl_book_copies SET noOfCopies = ? WHERE bookId = ? && branchId = ?", new Object[] {bc.getNoOfCopies(), bc.getBookId(), bc.getBranchId()});
	}

	/*****************************************************************************
	>>	DELETE OPERATIONS
	*****************************************************************************/

	public void deleteBookCopies(BookCopies bc) throws ClassNotFoundException, SQLException
	{
		mySqlTemplate.update("DELETE FROM tbl_book_copies WHERE bookId = ? && branchId = ?", new Object[] {bc.getBookId(), bc.getBranchId()});
	}



	@Override
	public List<BookCopies> extractData(ResultSet rs) throws SQLException {
		List<BookCopies> bcs = new ArrayList<BookCopies>();
		while(rs.next())
		{
			BookCopies bc = new BookCopies();
			bc.setBookId(rs.getInt("bookId"));
			bc.setBranchId(rs.getInt("branchId"));
			bc.setNoOfCopies(rs.getInt("noOfCopies"));
			bcs.add(bc);
		}
		return bcs;
	}



}
