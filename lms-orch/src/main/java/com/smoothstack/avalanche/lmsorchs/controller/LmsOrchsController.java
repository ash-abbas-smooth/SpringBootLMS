package com.smoothstack.avalanche.lmsorchs.controller;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.smoothstack.avalanche.lmsorchs.entity.Author;
import com.smoothstack.avalanche.lmsorchs.entity.Book;
import com.smoothstack.avalanche.lmsorchs.entity.BookCopies;
import com.smoothstack.avalanche.lmsorchs.entity.BookLoans;
import com.smoothstack.avalanche.lmsorchs.entity.Borrower;
import com.smoothstack.avalanche.lmsorchs.entity.Branch;
import com.smoothstack.avalanche.lmsorchs.entity.Publisher;


@RestController
@RequestMapping("/lms")
public class LmsOrchsController {

	@Autowired
	RestTemplate restTemplate;
	

	/***********
	 Admin Functions
	 ***********/
	
	@RequestMapping(path = "/admin/book", method = RequestMethod.GET)
	public Book[] readBooksAdmin()
	{
		ResponseEntity<Book[]> response = restTemplate.getForEntity("http://localhost:8081/lms/admin/book", Book[].class);
		return response.getBody();
	}
	
	
	@RequestMapping(path = "/admin/book", method= RequestMethod.POST)
	public String createBookAdmin(@RequestBody Book book)
	{
		restTemplate.postForEntity("http://localhost:8081/lms/admin/book", book, Book.class);
		return "Book Created!";
	}
	
	@RequestMapping(path = "/admin/book", method= RequestMethod.PUT)
	public String updateBookAdmin(@RequestBody Book book) 
	{
		restTemplate.put("http://localhost:8081/lms/admin/book", book);
		return "Update Success!";
	}
	
	@RequestMapping(path = "/admin/book/{bookId}", method = RequestMethod.DELETE)
	public String deleteBookAdmin(@PathVariable("bookId") Integer bookId)
	{
		Map<String, Integer> params =  new HashMap<String, Integer>();
		params.put("bookId", bookId);
		restTemplate.delete("http://localhost:8081/lms/admin/book/{bookdId}", params);
		return "Delete Success!";
	}
	
	@RequestMapping(path = "/admin/author", method = RequestMethod.GET)
	public Author[] readAuthorsAdmin()
	{
		ResponseEntity<Author[]> response = restTemplate.getForEntity("http://localhost:8081/lms/admin/author", Author[].class);
		return response.getBody();
	}
	
	
	@RequestMapping(path = "/admin/author", method= RequestMethod.POST)
	public String createAuthorAdmin(@RequestBody Author author)
	{
		restTemplate.postForEntity("http://localhost:8081/lms/admin/author", author, Book.class);
		return "Book Created!";
	}
	
	@RequestMapping(path = "/admin/author", method= RequestMethod.PUT)
	public String updateAuthorAdmin(@RequestBody Author author) 
	{
		restTemplate.put("http://localhost:8081/lms/admin/author", author);
		return "Update Success!";
	}
	
	@RequestMapping(path = "/admin/author/{authorId}", method = RequestMethod.DELETE)
	public String deleteAuthorAdmin(@PathVariable("authorId") Integer authorId)
	{
		Map<String, Integer> params =  new HashMap<String, Integer>();
		params.put("authorId", authorId);
		restTemplate.delete("http://localhost:8081/lms/admin/author/{authordId}", params);
		return "Delete Success!";
	}
	
	@RequestMapping(path = "/admin/publisher", method = RequestMethod.GET)
	public Publisher[] readPublishersAdmin()
	{
		ResponseEntity<Publisher[]> response = restTemplate.getForEntity("http://localhost:8081/lms/admin/publisher", Publisher[].class);
		return response.getBody();
	}
	
	
	@RequestMapping(path = "/admin/publisher", method= RequestMethod.POST)
	public String createPublisherAdmin(@RequestBody Publisher publisher)
	{
		restTemplate.postForEntity("http://localhost:8081/lms/admin/publisher", publisher, Publisher.class);
		return "Create Success!";
	}
	
	@RequestMapping(path = "/admin/publisher", method= RequestMethod.PUT)
	public String updatePublisherAdmin(@RequestBody Publisher publisher) 
	{
		restTemplate.put("http://localhost:8081/lms/admin/publisher", publisher);
		return "Update Success!";
	}
	
	@RequestMapping(path = "/admin/publisher/{publisherId}", method = RequestMethod.DELETE)
	public String deletePublisherAdmin(@PathVariable("publisherId") int publisherId)
	{
		Map<String, Integer> params =  new HashMap<String, Integer>();
		params.put("publisherId", publisherId);
		restTemplate.delete("http://localhost:8081/lms/admin/publisher/{publisherdId}", params);
		return "Delete Success!";
	}
	
	@RequestMapping(path = "/admin/branch", method = RequestMethod.GET)
	public Branch[] readBranchesAdmin()
	{
		ResponseEntity<Branch[]> response = restTemplate.getForEntity("http://localhost:8081/lms/admin/branch", Branch[].class);
		return response.getBody();
	}
	
	
	@RequestMapping(path = "/admin/branch", method= RequestMethod.POST)
	public String createBranchAdmin(@RequestBody Branch branch)
	{
		restTemplate.postForEntity("http://localhost:8081/lms/admin/branch", branch, Branch.class);
		return "Create Success!";
	}
	
	@RequestMapping(path = "/admin/branch", method= RequestMethod.PUT)
	public String updateBranchAdmin(@RequestBody Branch branch) 
	{
		restTemplate.put("http://localhost:8081/lms/admin/branch", branch);
		return "Update Success!";
	}
	
	@RequestMapping(path = "/admin/branch/{branchId}", method = RequestMethod.DELETE)
	public String deleteBranchAdmin(@PathVariable("branchId") Integer branchId)
	{
		Map<String, Integer> params =  new HashMap<String, Integer>();
		params.put("branchId", branchId);
		restTemplate.delete("http://localhost:8081/lms/admin/branch/{branchdId}", params);
		return "Delete Success!";
	}
	
	@RequestMapping(path = "/admin/borrower", method = RequestMethod.GET)
	public Borrower[] readBorrowersAdmin()
	{
		ResponseEntity<Borrower[]> response = restTemplate.getForEntity("http://localhost:8081/lms/admin/borrower", Borrower[].class);
		return response.getBody();
	}
	
	
	@RequestMapping(path = "/admin/borrower", method= RequestMethod.POST)
	public String createBorrowerAdmin(@RequestBody Borrower borrower)
	{
		restTemplate.postForEntity("http://localhost:8081/lms/admin/borrower", borrower, Borrower.class);
		return "Create Success!";
	}
	
	@RequestMapping(path = "/admin/borrower", method= RequestMethod.PUT)
	public String updateBorrowerAdmin(@RequestBody Borrower borrower) 
	{
		restTemplate.put("http://localhost:8081/lms/admin/borrower", borrower);
		return "Update Success!";
	}
	
	@RequestMapping(path = "/admin/borrower/{cardNo}", method = RequestMethod.DELETE)
	public String deleteBorrowerAdmin(@PathVariable("cardNo") Integer cardNo)
	{
		Map<String, Integer> params =  new HashMap<String, Integer>();
		params.put("cardNo", cardNo);
		restTemplate.delete("http://localhost:8081/lms/admin/borrower/{borrowerdId}", params);
		return "Delete Success!";
	}
	
	@RequestMapping(path = "/admin/loan", method = RequestMethod.GET)
	public BookLoans[] readBookLoanssAdmin()
	{
		ResponseEntity<BookLoans[]> response = restTemplate.getForEntity("http://localhost:8081/lms/admin/loan", BookLoans[].class);
		return response.getBody();
	}

	@RequestMapping(path = "/admin/loan", method= RequestMethod.PUT)
	public String updateBookLoansAdmin(@RequestBody BookLoans loan) 
	{
		restTemplate.put("http://localhost:8081/lms/admin/loan", loan);
		return "Update Success!";
	}
	
	/********************************************************
		>>Librarian Functions
	 ********************************************************/

	@RequestMapping(path = "/librarian/branches", method = RequestMethod.GET)
	public Branch[] readBranchesLibrarian()
	{
		ResponseEntity<Branch[]> response = restTemplate.getForEntity("http://localhost:8082/lms/librarian/branches", Branch[].class);
		return response.getBody();
	}
	
	@RequestMapping( path = "/librarian/bookcopies/{branchId}", method = RequestMethod.GET )
	public BookCopies[] readBookCopiesByBranchLibrarian( @PathVariable("branchId") int branchId )
	{
		Map<String, Integer> params =  new HashMap<String, Integer>();
		params.put("branchId", branchId);
		ResponseEntity<BookCopies[]> response = restTemplate.getForEntity("http://localhost:8082/lms/librarian/bookcopies/{branchId}", BookCopies[].class, params);
		return response.getBody();
	}
	
	@RequestMapping(path = "/librarian/branches", method= RequestMethod.PUT)
	public String updateBranchLibrarian(@RequestBody Branch branch) 
	{
		restTemplate.put("http://localhost:8081/lms/librarian/branches", branch);
		return "Update Success!";
	}
	
	@RequestMapping(path = "/librarian/bookcopies", method= RequestMethod.PUT)
	public String updateBookCopiesLibrarian(@RequestBody BookCopies bc)
	{
		restTemplate.put("http://localhost:8081/lms/librarian/bookCopies", bc);
		return "Update Success!";
	}
	
	/*********
	 * BORROWER FUNCTIONS
	 */
	@RequestMapping(path = "/borrower/bookloans/{cardNo}", method= RequestMethod.GET)
	public BookLoans[] readLoansByCardNoBorrower(@PathVariable("cardNo") int cardNo)
	{
		Map<String,Integer> params = new HashMap<String,Integer>();
		params.put("cardNo", cardNo);
		ResponseEntity<BookLoans[]> response = restTemplate.getForEntity("http://localhost:8083/lms/borrower/bookloans/{cardNo}", BookLoans[].class, params);
		return response.getBody();
	}
	@RequestMapping(path = "/borrower/bookloans", method= RequestMethod.POST)
	public String createLoanBorrower(@RequestBody BookLoans loans)
	{
		restTemplate.postForEntity("http://localhost:8083/lms/borrower/bookloans", loans, BookLoans.class);
		return "Create Successful!";
	}
	
	@RequestMapping(path = "/borrower/bookloans", method= RequestMethod.PUT)
	public String updateLoanBorrower(@RequestBody BookLoans loans)
	{
		restTemplate.put("http://localhost:8083/lms/borrower/bookloans", loans);
		return "Update Successful!";
	}
	
	@RequestMapping(path = "/borrower/branches", method = RequestMethod.GET)
	public Branch[] readBranchesBorrower()
	{
		ResponseEntity<Branch[]> response = restTemplate.getForEntity("http://localhost:8083/lms/borrower/branches", Branch[].class);
		return response.getBody();
	}
	
	@RequestMapping( path = "/borrower/bookcopies/{branchId}", method = RequestMethod.GET )
	public BookCopies[] readBookCopiesByBranchBorrower( @PathVariable("branchId") int branchId )
	{
		Map<String, Integer> params =  new HashMap<String, Integer>();
		params.put("branchId", branchId);
		ResponseEntity<BookCopies[]> response = restTemplate.getForEntity("http://localhost:8083/lms/borrower/bookcopies/{branchId}", BookCopies[].class, params);
		return response.getBody();
	}
	
	@RequestMapping(path = "/borrower/bookcopies", method= RequestMethod.PUT)
	public String updateBookCopiesBorrower(@RequestBody BookCopies bc)
	{
		restTemplate.put("http://localhost:8081/lms/librarian/bookCopies", bc);
		return "Update Success!";
	}
	
}
