package com.smoothstack.avalanche.lms.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.smoothstack.avalanche.lms.entity.BookCopies;
import com.smoothstack.avalanche.lms.entity.BookLoans;
import com.smoothstack.avalanche.lms.entity.Branch;
import com.smoothstack.avalanche.lms.svc.BorrowerSVC;

@RestController
public class BorrowerController {
	
	@Autowired
	BorrowerSVC BorrowerService;
	/*
	 * Functions for BookLoans
	 */
	@RequestMapping(path = "/lms/borrower/bookloans/{cardNo}", method= RequestMethod.GET)
	public List<BookLoans> readLoansByCardNo(@PathVariable("cardNo") int cardNo) throws ClassNotFoundException, SQLException
	{
		return BorrowerService.readLoansByCardNo(cardNo);
	}
	
	@RequestMapping(path = "/lms/borrower/bookloan", method= RequestMethod.POST)
	public ResponseEntity<BookLoans> createLoan(@RequestBody BookLoans loan) throws ClassNotFoundException, SQLException
	{
		BorrowerService.createLoan(loan);
		ResponseEntity<BookLoans> response = new ResponseEntity<BookLoans>(HttpStatus.CREATED);
		return response;
	}
	@RequestMapping(path = "/lms/borrower/bookloans", method= RequestMethod.PUT)
	public ResponseEntity<BookLoans> updateLoan(@RequestBody BookLoans loan) throws ClassNotFoundException, SQLException {
		BorrowerService.updateLoan(loan);
		ResponseEntity<BookLoans> response = new ResponseEntity<BookLoans>(HttpStatus.NO_CONTENT);
		return response;
	}
	
	/*
	 * Function for Branches
	 */
	@RequestMapping(path ="/lms/borrower/branch", method= RequestMethod.GET)
	public List<Branch> readBranches() throws ClassNotFoundException, SQLException
	{
		return BorrowerService.readBranches();
	}
	
	/*
	 * Function for Book Copies
	 */
	@RequestMapping(path = "/lms/borrower/bookcopy/{branchId}", method= RequestMethod.GET)
	public List<BookCopies> readBookCopiesByBranch(@RequestBody int branchId) throws ClassNotFoundException, SQLException
	{
		return BorrowerService.readBookCopiesByBranch(branchId);
	}
	
	@RequestMapping(path = "/lms/borrower/bookcopy", method= RequestMethod.PUT)
	public ResponseEntity<BookCopies> updateBookCopy(@RequestBody BookCopies bc) throws ClassNotFoundException, SQLException
	{
		BorrowerService.updateBookCopies(bc);
		ResponseEntity<BookCopies> response = new ResponseEntity<BookCopies>(HttpStatus.NO_CONTENT); 
		return response;
	}
	/*
	 * Function for 
	 */
}
