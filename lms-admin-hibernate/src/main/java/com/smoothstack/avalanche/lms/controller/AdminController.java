package com.smoothstack.avalanche.lms.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smoothstack.avalanche.lms.entity.*;
import com.smoothstack.avalanche.lms.service.AdminSVC;

@RestController
@RequestMapping("/lms/admin")
public class AdminController {
	@Autowired
	AdminSVC adminService;
	
	/*
	 * Author Mappings
	 */
	@GetMapping("/authors")
	public List<Author> readAllAuthors() {
	    return adminService.readAllAuthors();
	}
	
	@PostMapping("/authors")
	public ResponseEntity<Author> createAuthor(@Valid @RequestBody Author author) {
		adminService.createAuthor(author);
		ResponseEntity<Author> response = new ResponseEntity<Author>(HttpStatus.CREATED);
		return response;
	}
	
	@PutMapping("/authors/{authorId}")
	public ResponseEntity<Author> updateAuthor(@Valid @RequestBody Author author, @Valid @PathVariable Integer authorId) {
		adminService.updateAuthor(author);
		ResponseEntity<Author> response = new ResponseEntity<Author>(HttpStatus.NO_CONTENT);
		return response;
	}
	
	@DeleteMapping("/authors/{authorId}")
	public ResponseEntity<Author> deleteAuthor(@Valid @PathVariable Integer authorId) {
		adminService.deleteAuthor(authorId);
		ResponseEntity<Author> response = new ResponseEntity<Author>(HttpStatus.NO_CONTENT);
		return response;
	}	
	
	/*
	 * Book Mappings
	 */
	@GetMapping("/books")
	public List<Book> readAllBooks() {
	    return adminService.readAllBooks();
	}
	
	@PostMapping("/books")
	public ResponseEntity<Book> createBook(@Valid @RequestBody Book book) {
		adminService.createBook(book);
		ResponseEntity<Book> response = new ResponseEntity<Book>(HttpStatus.CREATED);
		return response;
	}
	
	@PutMapping("/books/{bookId}")
	public ResponseEntity<Book> updateBook(@Valid @RequestBody Book book, @Valid @PathVariable Integer bookId) {
		adminService.updateBook(book);
		ResponseEntity<Book> response = new ResponseEntity<Book>(HttpStatus.NO_CONTENT);
		return response;
	}
	
	@DeleteMapping("/books/{bookId}")
	public ResponseEntity<Book> deleteBook(@Valid @PathVariable Integer bookId) {
		adminService.deleteBook(bookId);
		ResponseEntity<Book> response = new ResponseEntity<Book>(HttpStatus.NO_CONTENT);
		return response;
	}	
	
	/*
	 * Publisher Mappings
	 */
	@GetMapping("/publishers")
	public List<Publisher> readAllPublishers() {
	    return adminService.readAllPublishers();
	}
	
	@PostMapping("/publishers")
	public ResponseEntity<Publisher> createPublisher(@Valid @RequestBody Publisher publisher) {
		adminService.createPublisher(publisher);
		ResponseEntity<Publisher> response = new ResponseEntity<Publisher>(HttpStatus.CREATED);
		return response;
	}
	
	@PutMapping("/publishers{pubId}")
	public ResponseEntity<Publisher> updatePublisher(@Valid @RequestBody Publisher publisher, @Valid @PathVariable Integer publisherId) {
		adminService.updatePublisher(publisher);
		ResponseEntity<Publisher> response = new ResponseEntity<Publisher>(HttpStatus.NO_CONTENT);
		return response;
	}
	
	@DeleteMapping("/publishers/{pubId}")
	public ResponseEntity<Publisher> deletePublisher(@Valid @PathVariable Integer publisherId) {
		adminService.deletePublisher(publisherId);
		ResponseEntity<Publisher> response = new ResponseEntity<Publisher>(HttpStatus.NO_CONTENT);
		return response;
	}	
	
	/*
	 * Branch Mappings
	 */
	@GetMapping("/branches")
	public List<Branch> readAllBranches() {
	    return adminService.readAllBranches();
	}
	
	@PostMapping("/branches")
	public ResponseEntity<Branch> createBranch(@Valid @RequestBody Branch branch) {
		adminService.createBranch(branch);
		ResponseEntity<Branch> response = new ResponseEntity<Branch>(HttpStatus.CREATED);
		return response;
	}
	
	@PutMapping("/branches/{branchId}")
	public ResponseEntity<Branch> updateBranch(@Valid @RequestBody Branch branch, @Valid @PathVariable Integer branchId) {
		adminService.updateBranch(branch);
		ResponseEntity<Branch> response = new ResponseEntity<Branch>(HttpStatus.NO_CONTENT);
		return response;
	}
	
	@DeleteMapping("/branches/{branchId}")
	public ResponseEntity<Branch> deleteBranch(@Valid @PathVariable Integer branchId) {
		adminService.deleteBranch(branchId);
		ResponseEntity<Branch> response = new ResponseEntity<Branch>(HttpStatus.NO_CONTENT);
		return response;
	}	
	
	/*
	 * Borrower Mappings
	 */
	@GetMapping("/borrowers")
	public List<Borrower> readAllBorrowers() {
	    return adminService.readAllBorrowers();
	}
	
	@PostMapping("/borrowers")
	public ResponseEntity<Borrower> createBorrower(@Valid @RequestBody Borrower borrower) {
		adminService.createBorrower(borrower);
		ResponseEntity<Borrower> response = new ResponseEntity<Borrower>(HttpStatus.CREATED);
		return response;
	}
	
	@PutMapping("/borrowers/{cardNo}")
	public ResponseEntity<Borrower> updateBorrower(@Valid @RequestBody Borrower borrower, @Valid @PathVariable Integer cardNo) {
		adminService.updateBorrower(borrower);
		ResponseEntity<Borrower> response = new ResponseEntity<Borrower>(HttpStatus.NO_CONTENT);
		return response;
	}
	
	@DeleteMapping("/borrowers/{cardNo}")
	public ResponseEntity<Borrower> deleteBorrower(@Valid @PathVariable Integer cardNo) {
		adminService.deleteBorrower(cardNo);
		ResponseEntity<Borrower> response = new ResponseEntity<Borrower>(HttpStatus.NO_CONTENT);
		return response;
	}	
	
	/*
	 * Loan Mappings
	 */
	@GetMapping("/loans")
	public List<BookLoans> readAllLoans() {
	    return adminService.readAllBookLoans();
	}
	
	@PutMapping("/loans")
	public ResponseEntity<BookLoans> updateBookLoan(@Valid @RequestBody BookLoans bookLoan, @RequestParam Integer bookId, 
			@RequestParam Integer branchId, @RequestParam Integer cardNo) {
		adminService.updateBookLoan(bookLoan);
		ResponseEntity<BookLoans> response = new ResponseEntity<BookLoans>(HttpStatus.NO_CONTENT);
		return response;
	}
}
