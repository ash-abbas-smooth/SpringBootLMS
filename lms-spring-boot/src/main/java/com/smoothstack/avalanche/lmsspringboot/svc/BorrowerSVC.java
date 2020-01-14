package com.smoothstack.avalanche.lmsspringboot.svc;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smoothstack.avalanche.lmsspringboot.dao.*;
import com.smoothstack.avalanche.lmsspringboot.entity.*;

@Service
public class BorrowerSVC {

	@Autowired
	private BookDAO bookDAO;
	
	@Autowired
	private BorrowerDAO borrowerDAO;
	
	@Autowired
	private LoansDAO loansDAO;
	
	@Autowired
	private BranchDAO branchDAO;
	
	@Autowired
	private BookCopiesDAO copiesDAO;
	
	/*
	 * Functions for returning a book
	 */
	public List<Loan> readLoansByCardNo(int cardNo) throws ClassNotFoundException, SQLException {
		return loansDAO.readLoansByCardNo(cardNo);
	}
	
	public void updateLoan(Loan loan) throws ClassNotFoundException, SQLException {
		loansDAO.updateLoan(loan);
	}
	
	/*
	 * Functions for checking out a book
	 */
	public List<Branch> readBranches() throws ClassNotFoundException, SQLException {
		return branchDAO.readBranches();
	}
	
	public List<Copies> readBookCopiesByBranch() throws ClassNotFoundException, SQLException {
		return copiesDAO.readBookCopiesByBranch();
	}
	
    public void updateBookCopies(Copies copies) throws ClassNotFoundException, SQLException {
    	copiesDAO.updateBookCopies(copies);
    }
	
	public void createLoan(Loan loan) throws ClassNotFoundException, SQLException {
	    loansDAO.createLoan(loan);
	}
}
