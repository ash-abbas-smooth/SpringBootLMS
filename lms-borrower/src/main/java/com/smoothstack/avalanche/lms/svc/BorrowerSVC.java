package com.smoothstack.avalanche.lms.svc;

import java.sql.SQLException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smoothstack.avalanche.lms.dao.AuthorDAO;
import com.smoothstack.avalanche.lms.dao.BookAuthorDAO;
import com.smoothstack.avalanche.lms.dao.BookCopiesDAO;
import com.smoothstack.avalanche.lms.dao.BookLoansDAO;
import com.smoothstack.avalanche.lms.dao.BranchDAO;
import com.smoothstack.avalanche.lms.entity.BookAuthor;
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
	
	@Autowired
	private BookAuthorDAO badao;
	
	/*
	 * Functions for returning a book
	 */

	public List<BookAuthor> readBA()
	{
		return badao.findAll();
	}
	@Transactional
	public List<BookLoans> readLoansByCardNo(int cardNo) throws ClassNotFoundException, SQLException {
		return loansDAO.findByCardNo(cardNo);
	}
	

	public void updateDueDate(BookLoans loan) throws ClassNotFoundException, SQLException {
		loansDAO.updateDueDate(loan.getDueDate(), loan.getId().getBookId(), loan.getId().getCardNo(), loan.getId().getBranchId());
	}
	
	public void updateDateIn(BookLoans loan)
	{
		loansDAO.updateDateIn(loan.getDateIn(), loan.getId().getBookId(), loan.getId().getCardNo(), loan.getId().getBranchId());
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
//	public List<Branch> readBranches() throws ClassNotFoundException, SQLException {
//		return branchDAO.findAll();
//	}
//	
//	public List<BookCopies> readBookCopiesByBranch(int branchID) throws ClassNotFoundException, SQLException {
//		return copiesDAO.findBookCopiesByBranch(branchID);
//	}
//	
//    public void updateBookCopies(BookCopies copies) throws ClassNotFoundException, SQLException {
//    	copiesDAO.updateBookCopies(copies.getNoOfCopies(), copies.getBookCopiesId());
//    }
//	
	public void createLoan(BookLoans loan) throws ClassNotFoundException, SQLException {
	    loansDAO.createBookLoan(loan.getId().getBookId(), loan.getId().getCardNo(), loan.getId().getBranchId(),
	    		loan.getDateOut(), loan.getDueDate());
	}
}