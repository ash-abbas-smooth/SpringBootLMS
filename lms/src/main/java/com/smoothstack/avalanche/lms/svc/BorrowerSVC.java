package com.smoothstack.avalanche.lmsspringboot.svc;

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

	public List<Branch> readBranches() throws ClassNotFoundException, SQLException {
		return branchDAO.readBranches();
	}
	
	public List<Book> readBookCopiesByBranch() throws ClassNotFoundException, SQLException {
		return bookDAO.readBooksByBranch();
	}
	
	public List<BookLoans> readBookLoansByCardNo(int cardNo) throws ClassNotFoundException, SQLException {
		return loansDAO.readBookLoansByCardNo(cardNo);
	}
	
	public void createBookLoans(BookLoans loan) throws ClassNotFoundException, SQLException {
	    loansDAO.createBookLoan(loan);
	}
	
	public void updateBookLoans(BookLoans loan) throws ClassNotFoundException, SQLException {
		loansDAO.updateBookLoan(loan);
	}
}
