package com.smoothstack.avalanche.lms.svc;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smoothstack.avalanche.lms.dao.AuthorDAO;
import com.smoothstack.avalanche.lms.dao.BookCopiesDAO;
import com.smoothstack.avalanche.lms.dao.BookLoansDAO;
import com.smoothstack.avalanche.lms.dao.BranchDAO;
import com.smoothstack.avalanche.lms.entity.BookCopies;
import com.smoothstack.avalanche.lms.entity.BookLoans;
import com.smoothstack.avalanche.lms.entity.Branch;

@Service
public class BorrowerSVC{
	
	@Autowired
	private BookLoansDAO loansDAO;
	
	@Autowired
	private BranchDAO branchDAO;
	
	@Autowired
	private BookCopiesDAO copiesDAO;
	
	@Autowired
	private AuthorDAO authorDAO;

	/*
	 * Functions for returning a book
	 */
	@Transactional
	public List<BookLoans> readLoansByCardNo(int cardNo) throws ClassNotFoundException, SQLException {
		List<BookLoans> searchLoans = loansDAO.findByCardNo(cardNo);
		return searchLoans == null? Collections.EMPTY_LIST : searchLoans;
	}
	

	public void updateBookLoans(BookLoans loan) throws ClassNotFoundException, SQLException {
		Optional<BookLoans> searchLoan = loansDAO.findByBookLoanId(loan.getId().getBorrower().getCardNo(), loan.getId().getBook().getBookId(), loan.getId().getBranch().getBranchId());
		loansDAO.save(loan);
	}

	/*
	 * Functions for returning a list of books based on author
	 */
	/*
	 * TODO: Create in DAO readBookList(author author) if needed
	 */
	
	/*
	 * Functions for checking out a book
	 */
	public List<Branch> readBranches() throws ClassNotFoundException, SQLException {
		return branchDAO.findAll();
	}

	public List<BookCopies> readBookCopiesByBranch(int branchID) throws ClassNotFoundException, SQLException {
		List<BookCopies> searchCopies = copiesDAO.findBookCopiesByBranch(branchID);
		return searchCopies == null? Collections.EMPTY_LIST : searchCopies;
	}
	
    public void updateBookCopies(BookCopies copies) throws ClassNotFoundException, SQLException {
    	copiesDAO.save(copies);
    }

	public void createLoan(BookLoans loan) throws ClassNotFoundException, SQLException {
		loansDAO.save(loan);
	}
}