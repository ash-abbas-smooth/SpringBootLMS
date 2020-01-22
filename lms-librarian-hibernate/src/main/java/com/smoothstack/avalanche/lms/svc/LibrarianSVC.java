package com.smoothstack.avalanche.lms.svc;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

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
		return branchDAO.findAll();
	}

	// [ 2 ] -- Get book copies by branch
	public List<BookCopies> readBookCopiesByBranch(Long branchID) throws ClassNotFoundException, SQLException
	{
		System.out.println(copiesDAO.findById(branchID));
		List<BookCopies> bc = new ArrayList<>();
		return bc;
	}

	/*****************************************************************************
	>>	UPDATE OPERATIONS
	*****************************************************************************/

	// [ 1 ] -- Update branch name/address
	public void updateBranch(Branch branch) throws ClassNotFoundException, SQLException
	{
		branchDAO.save(branch);
	}

	// [ 2 ] -- Update book copies at branch
  public void updateBookCopies(BookCopies copies) throws ClassNotFoundException, SQLException
	{
  	copiesDAO.save(copies);
  }

}
