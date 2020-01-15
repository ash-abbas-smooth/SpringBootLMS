package com.smoothstack.avalanche.lms.svc;

import java.sql.SQLException;
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
	public List<Book> readBooks() throws ClassNotFoundException, SQLException {
		return bookDAO.readBooks();
	}
	
	public void createBook(Book book) throws ClassNotFoundException, SQLException {
	    bookDAO.createBook(book);
	}
	
	public void deleteBook(int bookId) throws ClassNotFoundException, SQLException {
	    bookDAO.deleteBook(bookId);
	}
	
	public void updateBook(Book book) throws ClassNotFoundException, SQLException {
		bookDAO.updateBook(book);
	}
	
	/*
	 * Author functions
	 */
	public List<Author> readAuthors() throws ClassNotFoundException, SQLException {
		return authorDAO.readAuthors();
	}
	
	public void createAuthor(Author author) throws ClassNotFoundException, SQLException {
	    authorDAO.createAuthor(author);
	}
	
	public void deleteAuthor(int authorId) throws ClassNotFoundException, SQLException {
	    authorDAO.deleteAuthor(authorId);
	}
	
	public void updateAuthor(Author author) throws ClassNotFoundException, SQLException {
		authorDAO.updateAuthor(author);
	}
	
	/*
	 * Publisher Functions
	 */
	public List<Publisher> readPublishers() throws ClassNotFoundException, SQLException {
		return publisherDAO.readPublishers();
	}
	
	public void createPublisher(Publisher publisher) throws ClassNotFoundException, SQLException {
	    publisherDAO.createPublisher(publisher);
	}
	
	public void deletePublisher(int publisherId) throws ClassNotFoundException, SQLException {
	    publisherDAO.deletePublisher(publisherId);
	}
	
	public void updatePublisher(Publisher publisher) throws ClassNotFoundException, SQLException {
		publisherDAO.updatePublisher(publisher);
	}

	/*
	 * Library Branch Functions
	 */
	public List<Branch> readBranches() throws ClassNotFoundException, SQLException {
		return branchDAO.readBranches();
	}
	
	public void createBranch(Branch branch) throws ClassNotFoundException, SQLException {
	    branchDAO.createBranch(branch);
	}
	
	public void deleteBranch(int branchId) throws ClassNotFoundException, SQLException {
	    branchDAO.deleteBranch(branchId);
	}
	
	public void updateBranch(Branch branch) throws ClassNotFoundException, SQLException {
		branchDAO.updateBranch(branch);
	}
	
	/*
	 * Borrower Functions
	 */
	public List<Borrower> readBorrowers() throws ClassNotFoundException, SQLException {
		return borrowerDAO.readBorrowers();
	}
	
	public void createBorrower(Borrower borrower) throws ClassNotFoundException, SQLException {
	    borrowerDAO.createBorrower(borrower);
	}
	
	public void deleteBorrower(int cardNo) throws ClassNotFoundException, SQLException {
	    borrowerDAO.deleteBorrower(cardNo);
	}
	
	public void updateBorrower(Borrower borrower) throws ClassNotFoundException, SQLException {
		borrowerDAO.updateBorrower(borrower);
	}
	
	/*
	 * Loan Functions
	 */
	public List<BookLoans> readBookLoans() throws ClassNotFoundException, SQLException {
		return loansDAO.readBookLoans();
	}
	
	public void updateBookLoan(BookLoans loan) throws ClassNotFoundException, SQLException {
	    loansDAO.updateBookLoan(loan);
	}
	
}