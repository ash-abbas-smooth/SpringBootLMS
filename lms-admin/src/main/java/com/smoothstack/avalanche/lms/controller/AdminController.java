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

import com.smoothstack.avalanche.lms.entity.*;
import com.smoothstack.avalanche.lms.svc.AdminSVC;

@RestController
public class AdminController {
	
	@Autowired
	AdminSVC AdminService;
	
	/*
	 * Functions for Book
	 */
	@RequestMapping(path = "/lms/admin/book", method= RequestMethod.GET)
	public List<Book> readBooks() throws ClassNotFoundException, SQLException
	{
		return AdminService.readBooks();
	}
	
	@RequestMapping(path = "/lms/admin/book", method= RequestMethod.POST)
	public ResponseEntity<Book> createBook(@RequestBody Book book) throws ClassNotFoundException, SQLException
	{
		AdminService.createBook(book);
		ResponseEntity<Book> response = new ResponseEntity<Book>(HttpStatus.CREATED);
		return response;
	}
	
	@RequestMapping(path = "/lms/admin/book", method= RequestMethod.PUT)
	public ResponseEntity<Book> updateBook(@RequestBody Book book) throws ClassNotFoundException, SQLException {
		AdminService.updateBook(book);
		ResponseEntity<Book> response = new ResponseEntity<Book>(HttpStatus.NO_CONTENT);
		return response;
	}
	
	@RequestMapping(path = "/lms/admin/book/{bookId}", method= RequestMethod.DELETE)
	public ResponseEntity<Book> deleteBook(@PathVariable("bookId") int bookId) throws ClassNotFoundException, SQLException {
		AdminService.deleteBook(bookId);
		ResponseEntity<Book> response = new ResponseEntity<Book>(HttpStatus.NO_CONTENT);
		return response;
	}
	
	/*
	 * Functions for Author
	 */
	@RequestMapping(path = "/lms/admin/author", method= RequestMethod.GET)
	public List<Author> readAuthors() throws ClassNotFoundException, SQLException
	{
		return AdminService.readAuthors();
	}
	
	@RequestMapping(path = "/lms/admin/author", method= RequestMethod.POST)
	public ResponseEntity<Author> createAuthor(@RequestBody Author author) throws ClassNotFoundException, SQLException
	{
		AdminService.createAuthor(author);
		ResponseEntity<Author> response = new ResponseEntity<Author>(HttpStatus.CREATED);
		return response;
	}
	
	@RequestMapping(path = "/lms/admin/author", method= RequestMethod.PUT)
	public ResponseEntity<Author> updateAuthor(@RequestBody Author author) throws ClassNotFoundException, SQLException {
		AdminService.updateAuthor(author);
		ResponseEntity<Author> response = new ResponseEntity<Author>(HttpStatus.NO_CONTENT);
		return response;
	}
	
	@RequestMapping(path = "/lms/admin/author/{authorId}", method= RequestMethod.DELETE)
	public ResponseEntity<Author> deleteAuthor(@PathVariable("authorId") int authorId) throws ClassNotFoundException, SQLException {
		AdminService.deleteAuthor(authorId);
		ResponseEntity<Author> response = new ResponseEntity<Author>(HttpStatus.NO_CONTENT);
		return response;
	}
	
	/*
	 * Functions for Publisher
	 */
	@RequestMapping(path = "/lms/admin/publisher", method= RequestMethod.GET)
	public List<Publisher> readPublishers() throws ClassNotFoundException, SQLException
	{
		return AdminService.readPublishers();
	}
	
	@RequestMapping(path = "/lms/admin/publisher", method= RequestMethod.POST)
	public ResponseEntity<Publisher> createPublisher(@RequestBody Publisher publisher) throws ClassNotFoundException, SQLException
	{
		AdminService.createPublisher(publisher);
		ResponseEntity<Publisher> response = new ResponseEntity<Publisher>(HttpStatus.CREATED);
		return response;
	}
	
	@RequestMapping(path = "/lms/admin/publisher", method= RequestMethod.PUT)
	public ResponseEntity<Publisher> updatePublisher(@RequestBody Publisher publisher) throws ClassNotFoundException, SQLException {
		AdminService.updatePublisher(publisher);
		ResponseEntity<Publisher> response = new ResponseEntity<Publisher>(HttpStatus.NO_CONTENT);
		return response;
	}
	
	@RequestMapping(path = "/lms/admin/publisher/{publisherId}", method= RequestMethod.DELETE)
	public ResponseEntity<Publisher> deletePublisher(@PathVariable("publisherId") int publisherId) throws ClassNotFoundException, SQLException {
		AdminService.deletePublisher(publisherId);
		ResponseEntity<Publisher> response = new ResponseEntity<Publisher>(HttpStatus.NO_CONTENT);
		return response;
	}
	
	/*
	 * Functions for Branch
	 */
	@RequestMapping(path = "/lms/admin/branch", method= RequestMethod.GET)
	public List<Branch> readBranchs() throws ClassNotFoundException, SQLException
	{
		return AdminService.readBranches();
	}
	
	@RequestMapping(path = "/lms/admin/branch", method= RequestMethod.POST)
	public ResponseEntity<Branch> createBranch(@RequestBody Branch branch) throws ClassNotFoundException, SQLException
	{
		AdminService.createBranch(branch);
		ResponseEntity<Branch> response = new ResponseEntity<Branch>(HttpStatus.CREATED);
		return response;
	}
	
	@RequestMapping(path = "/lms/admin/branch", method= RequestMethod.PUT)
	public ResponseEntity<Branch> updateBranch(@RequestBody Branch branch) throws ClassNotFoundException, SQLException {
		AdminService.updateBranch(branch);
		ResponseEntity<Branch> response = new ResponseEntity<Branch>(HttpStatus.NO_CONTENT);
		return response;
	}
	
	@RequestMapping(path = "/lms/admin/branch/{branchId}", method= RequestMethod.DELETE)
	public ResponseEntity<Branch> deleteBranch(@PathVariable("branchId") int branchId) throws ClassNotFoundException, SQLException {
		AdminService.deleteBranch(branchId);
		ResponseEntity<Branch> response = new ResponseEntity<Branch>(HttpStatus.NO_CONTENT);
		return response;
	}
	
	/*
	 * Functions for Borrower
	 */
	@RequestMapping(path = "/lms/admin/borrower", method= RequestMethod.GET)
	public List<Borrower> readBorrowers() throws ClassNotFoundException, SQLException
	{
		return AdminService.readBorrowers();
	}
	
	@RequestMapping(path = "/lms/admin/borrower", method= RequestMethod.POST)
	public ResponseEntity<Borrower> createBorrower(@RequestBody Borrower borrower) throws ClassNotFoundException, SQLException
	{
		AdminService.createBorrower(borrower);
		ResponseEntity<Borrower> response = new ResponseEntity<Borrower>(HttpStatus.CREATED);
		return response;
	}
	
	@RequestMapping(path = "/lms/admin/borrower", method= RequestMethod.PUT)
	public ResponseEntity<Borrower> updateBorrower(@RequestBody Borrower borrower) throws ClassNotFoundException, SQLException {
		AdminService.updateBorrower(borrower);
		ResponseEntity<Borrower> response = new ResponseEntity<Borrower>(HttpStatus.NO_CONTENT);
		return response;
	}
	
	@RequestMapping(path = "/lms/admin/borrower/{cardNo}", method= RequestMethod.DELETE)
	public ResponseEntity<Borrower> deleteBorrower(@PathVariable("cardNo") int cardNo) throws ClassNotFoundException, SQLException {
		AdminService.deleteBorrower(cardNo);
		ResponseEntity<Borrower> response = new ResponseEntity<Borrower>(HttpStatus.NO_CONTENT);
		return response;
	}
	
	/*
	 * Functions for Loan
	 */
	@RequestMapping(path = "/lms/admin/loan", method= RequestMethod.GET)
	public List<BookLoans> readBookLoans() throws ClassNotFoundException, SQLException
	{
		return AdminService.readBookLoans();
	}
	
	@RequestMapping(path = "/lms/admin/loan", method= RequestMethod.PUT)
	public ResponseEntity<BookLoans> updateBookLoan(@RequestBody BookLoans loan) throws ClassNotFoundException, SQLException {
		AdminService.updateBookLoan(loan);
		ResponseEntity<BookLoans> response = new ResponseEntity<BookLoans>(HttpStatus.NO_CONTENT);
		return response;
	}
}
