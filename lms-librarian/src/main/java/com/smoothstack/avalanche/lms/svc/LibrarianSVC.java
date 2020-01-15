package com.smoothstack.avalanche.lms.svc;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smoothstack.avalanche.lms.dao.*;
import com.smoothstack.avalanche.lms.entity.*;

@Service
public class LibrarianSVC {

	@Autowired
	private BranchDAO branchDAO;

	@Autowired
	private BookCopiesDAO copiesDAO;

	@Autowired
	private AuthorDAO authorDAO;

	/*****************************************************************************
	>>	CREATE OPERATIONS
	*****************************************************************************/

	/*****************************************************************************
	>>	READ OPERATIONS
	*****************************************************************************/

	// [ 1 ] -- Get all branches
	public List<Branch> readBranches() throws ClassNotFoundException, SQLException
	{
		return branchDAO.readBranches();
	}

	// [ 2 ] -- Get book copies by branch
	public List<BookCopies> readBookCopiesByBranch(int branchID) throws ClassNotFoundException, SQLException
	{
		return copiesDAO.readBookCopiesByBranch(branchID);
	}

	/*****************************************************************************
	>>	UPDATE OPERATIONS
	*****************************************************************************/

	// [ 1 ] -- Update branch name/address
	public void updateBranch(Branch branch) throws ClassNotFoundException, SQLException
	{
		branchDAO.updateBranch(branch);
	}

	// [ 2 ] -- Update book copies at branch
  public void updateBookCopies(BookCopies copies) throws ClassNotFoundException, SQLException
	{
  	copiesDAO.updateBookCopies(copies);
  }

}
