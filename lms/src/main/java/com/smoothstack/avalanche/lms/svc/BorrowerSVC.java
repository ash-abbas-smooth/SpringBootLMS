package com.smoothstack.avalanche.lms.svc;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smoothstack.avalanche.lms.dao.*;
import com.smoothstack.avalanche.lms.entity.*;

@Service
public class BorrowerSVC {

	@Autowired
	private BookDAO bookDAO;
	
	@Autowired
	private BorrowerDAO borrowerDAO;
	
	@Autowired
	private BookLoansDAO loansDAO;
	
	@Autowired
	private BranchDAO branchDAO;
	
	@Autowired
	private BookCopiesDAO copiesDAO;
	
	/*
	 * Functions for returning a book
	 */
	public List<BookLoans> readLoansByCardNo(int cardNo) throws ClassNotFoundException, SQLException {
		return loansDAO.readBookLoansByCardNo(cardNo);
	}
	
	public void updateLoan(BookLoans loan) throws ClassNotFoundException, SQLException {
		loansDAO.updateBookLoan(loan);
	}
	
	/*
	 * Functions for checking out a book
	 */
	public List<Branch> readBranches() throws ClassNotFoundException, SQLException {
		return branchDAO.readBranches();
	}
	
	public List<BookCopies> readBookCopiesByBranch(int branchID) throws ClassNotFoundException, SQLException {
		return copiesDAO.readBookCopiesByBranch(branchID);
	}
	
    public void updateBookCopies(BookCopies copies) throws ClassNotFoundException, SQLException {
    	copiesDAO.updateBookCopies(copies);
    }
	
	public void createLoan(BookLoans loan) throws ClassNotFoundException, SQLException {
	    loansDAO.createBookLoan(loan);
	}
}