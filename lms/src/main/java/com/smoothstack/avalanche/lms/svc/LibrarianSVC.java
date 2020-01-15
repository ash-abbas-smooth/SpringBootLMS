package com.smoothstack.avalanche.lms.svc;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smoothstack.avalanche.lms.dao.BookCopiesDAO;
import com.smoothstack.avalanche.lms.dao.BranchDAO;
import com.smoothstack.avalanche.lms.entity.BookCopies;
import com.smoothstack.avalanche.lms.entity.Branch;

@Service
public class LibrarianSVC {

  @Autowired
	private BranchDAO branchDAO;

	@Autowired
	private BookCopiesDAO copiesDAO;

	/*
	 * Library Branch Functions
	 */
	public List<Branch> readBranches() throws ClassNotFoundException, SQLException {
		return branchDAO.readBranches();
	}

	public void updateBranch(Branch branch) throws ClassNotFoundException, SQLException {
		branchDAO.updateBranch(branch);
	}

	/*
	 * Book Copies Functions
	 */

	public List<BookCopies> readBookCopiesByBranch(int branchID) throws ClassNotFoundException, SQLException {
		return copiesDAO.readBookCopiesByBranch(branchID);
	}

    public void updateBookCopies(BookCopies copies) throws ClassNotFoundException, SQLException {
    	copiesDAO.updateBookCopies(copies);
    }
}
