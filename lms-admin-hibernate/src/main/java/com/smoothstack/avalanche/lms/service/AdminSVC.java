package com.smoothstack.avalanche.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smoothstack.avalanche.lms.dao.*;
import com.smoothstack.avalanche.lms.entity.*;

@Service
public class AdminSVC {

	@Autowired
	private AuthorDAO authorDAO;
	
	@Autowired
	private BookDAO bookDAO;
	
	@Autowired
	private PublisherDAO publisherDAO;
	
	@Autowired
	private BranchDAO branchDAO;
	
	@Autowired
	private BorrowerDAO borrowerDAO;
	
	@Autowired
	private BookLoansDAO loansDAO;
	
	/*
	 * Book Functions
	 */
	public List<Book> readAllBooks() {
		return bookDAO.findAll();
	}
	
	public void createBook(Book book) {
	    bookDAO.save(book);
	}
	
	public void deleteBook(Integer bookId) {
	    bookDAO.deleteById(bookId);
	}
	
	public void updateBook(Book book) {
		bookDAO.save(book);
	}
	
	/*
	 * Author functions
	 */
	public List<Author> readAllAuthors() {
		return authorDAO.findAll();
	}
	
	public void createAuthor(Author author) {
	    authorDAO.save(author);
	}
	
	public void deleteAuthor(Integer authorId) {
	    authorDAO.deleteById(authorId);
	}
	
	public void updateAuthor(Author author) {
		authorDAO.save(author);
	}
	
	/*
	 * Publisher Functions
	 */
	public List<Publisher> readAllPublishers() {
		return publisherDAO.findAll();
	}
	
	public void createPublisher(Publisher publisher) {
	    publisherDAO.save(publisher);
	}
	
	public void deletePublisher(Integer publisherId) {
	    publisherDAO.deleteById(publisherId);
	}
	
	public void updatePublisher(Publisher publisher) {
		publisherDAO.save(publisher);
	}

	/*
	 * Library Branch Functions
	 */
	public List<Branch> readAllBranches() {
		return branchDAO.findAll();
	}
	
	public void createBranch(Branch branch) {
	    branchDAO.save(branch);
	}
	
	public void deleteBranch(Integer branchId) {
	    branchDAO.deleteById(branchId);
	}
	
	public void updateBranch(Branch branch) {
		branchDAO.save(branch);
	}
	
	/*
	 * Borrower Functions
	 */
	public List<Borrower> readAllBorrowers() {
		return borrowerDAO.findAll();
	}
	
	public void createBorrower(Borrower borrower) {
	    borrowerDAO.save(borrower);
	}
	
	public void deleteBorrower(Integer cardNo) {
	    borrowerDAO.deleteById(cardNo);
	}
	
	public void updateBorrower(Borrower borrower) {
		borrowerDAO.save(borrower);
	}
	
	/*
	 * Loan Functions
	 */
	public List<BookLoans> readAllBookLoans() {
		return loansDAO.findAll();
	}
	
	public void updateBookLoan(BookLoans loan) {
	    loansDAO.save(loan);
	}
	
}