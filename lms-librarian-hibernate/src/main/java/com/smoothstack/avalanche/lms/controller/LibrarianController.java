package com.smoothstack.avalanche.lms.controller;

import java.util.List;

import java.sql.SQLException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;

import com.smoothstack.avalanche.lms.entity.Branch;
import com.smoothstack.avalanche.lms.entity.BookCopies;

import com.smoothstack.avalanche.lms.svc.LibrarianSVC;

@RestController
public class LibrarianController {


	@Autowired
	LibrarianSVC LibrarianService;

	/*****************************************************************************
	>>	READ OPERATIONS
	*****************************************************************************/

	// [ 1 ] -- Branches
	@RequestMapping( path = "/lms/librarian/branches", method = RequestMethod.GET )
	public List<Branch> readBranches() throws ClassNotFoundException, SQLException
	{
		return LibrarianService.readBranches();
	}

	// [ 2 ] -- Books by branch
	@RequestMapping( path = "/lms/librarian/bookcopies/{branchId}", method = RequestMethod.GET )
	public List<BookCopies> readBookCopiesByBranch( @PathVariable Long branchId ) throws ClassNotFoundException, SQLException
	{
		return LibrarianService.readBookCopiesByBranch( branchId );
	}

	/*****************************************************************************
	>>	UPDATE OPERATIONS
	*****************************************************************************/

	// [ 1 ] -- Update branch name/address: {"branchName": "Frostburg State University", "branchId": 1, "branchAddress": "2417 Summit Point"}
	@RequestMapping( path = "/lms/librarian/branch", method = RequestMethod.PUT )
	public ResponseEntity<Branch> updateBranch( @RequestBody Branch branch ) throws ClassNotFoundException, SQLException
	{
		LibrarianService.updateBranch( branch );
		ResponseEntity<Branch> response = new ResponseEntity<Branch>( HttpStatus.NO_CONTENT );
		return response;
	}

	// [ 2 ] -- Update book copies at branch: {"bookId": 1, "branchId": 1, "noOfCopies": 15}
	@RequestMapping(path = "/lms/librarian/bookcopies", method = RequestMethod.PUT )
	public ResponseEntity<BookCopies> updateBookCopies( @RequestBody BookCopies bc ) throws ClassNotFoundException, SQLException
	{
		LibrarianService.updateBookCopies(bc);
		ResponseEntity<BookCopies> response = new ResponseEntity<BookCopies>( HttpStatus.NO_CONTENT );
		return response;
	}

}
