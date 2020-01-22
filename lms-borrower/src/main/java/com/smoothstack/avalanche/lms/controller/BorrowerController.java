package com.smoothstack.avalanche.lms.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping(path = "/lms/borrower/bookloans/{cardNo}")
	public List<BookLoans> readLoansByCardNo(@PathVariable("cardNo") int cardNo) throws ClassNotFoundException, SQLException
	{
		return BorrowerService.readLoansByCardNo(cardNo);
	}

	@PostMapping(path = "/lms/borrower/bookloan")
	public ResponseEntity<BookLoans> createLoan(@RequestBody BookLoans loan) throws ClassNotFoundException, SQLException
	{
		if(loan == null)
			return new ResponseEntity<BookLoans>(HttpStatus.BAD_REQUEST);
		BorrowerService.createLoan(loan);
		ResponseEntity<BookLoans> response = new ResponseEntity<BookLoans>(HttpStatus.CREATED);
		return response;
	}
	
	@PutMapping(path = "/lms/borrower/bookloans:bookloans")
	public ResponseEntity<BookLoans> updateLoan(@RequestBody BookLoans loan) throws ClassNotFoundException, SQLException {
		BorrowerService.updateBookLoans(loan);
		ResponseEntity<BookLoans> response = new ResponseEntity<BookLoans>(HttpStatus.NO_CONTENT);
		return response;
	}
//
//	/*
//	 * Function for Branches
//	 */
	@GetMapping(path ="/lms/borrower/branches")
	public List<Branch> readBranches() throws ClassNotFoundException, SQLException
	{
		return BorrowerService.readBranches();
	}

	/*
	 * Function for Book Copies
	 */
	@GetMapping(path = "/lms/borrower/bookcopies/{branchId}")
	public List<BookCopies> readBookCopiesByBranch(@PathVariable("branchId") int branchId) throws ClassNotFoundException, SQLException
	{
		return BorrowerService.readBookCopiesByBranch(branchId);
	}

	@PutMapping(path = "/lms/borrower/bookcopies:bookcopies")
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
