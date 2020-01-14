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

	public List<Branch> readBranches() throws ClassNotFoundException, SQLException {
		return branchDAO.readBranches();
	}
	
	public List<Book> readBooksByBranch() throws ClassNotFoundException, SQLException {
		return bookDAO.readBooksByBranch();
	}
	
	public List<Loan> readLoansByCardNo(int cardNo) throws ClassNotFoundException, SQLException {
		return loansDAO.readLoansByCardNo(cardNo);
	}
	
	public void createLoan(Loan loan) throws ClassNotFoundException, SQLException {
	    loansDAO.createLoan(loan);
	}
	
	public void updateLoan(Loan loan) throws ClassNotFoundException, SQLException {
		loansDAO.updateLoan(loan);
	}
}
