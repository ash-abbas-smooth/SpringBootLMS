package com.smoothstack.avalanche.lmssecure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.smoothstack.avalanche.lmssecure.db.UserRepository;
import com.smoothstack.avalanche.lmssecure.entity.Author;
import com.smoothstack.avalanche.lmssecure.entity.Book;
import com.smoothstack.avalanche.lmssecure.entity.BookCopies;
import com.smoothstack.avalanche.lmssecure.entity.BookLoans;
import com.smoothstack.avalanche.lmssecure.entity.Borrower;
import com.smoothstack.avalanche.lmssecure.entity.Branch;
import com.smoothstack.avalanche.lmssecure.entity.Publisher;
import com.smoothstack.avalanche.lmssecure.entity.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("lms")
@CrossOrigin
public class PublicRestApiController {
    private UserRepository userRepository;
    
	@Autowired
	RestTemplate restTemplate;

    public PublicRestApiController(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    
	/***********
	 Admin Functions
	 ***********/
    @GetMapping("admin/users")
    public List<User> users(){
        return this.userRepository.findAll();
    }
    
	@RequestMapping(path = "/admin/books", method = RequestMethod.GET)
	public Book[] readBooksAdmin()
	{
		ResponseEntity<Book[]> response = restTemplate.getForEntity("http://localhost:8081/lms/admin/books", Book[].class);
		return response.getBody();
	}
	
	
	@RequestMapping(path = "/admin/books", method= RequestMethod.POST)
	public String createBookAdmin(@RequestBody Book book)
	{
		restTemplate.postForEntity("http://localhost:8081/lms/admin/books", book, Book.class);
		return "Book Created!";
	}
	
	@RequestMapping(path = "/admin/books", method= RequestMethod.PUT)
	public String updateBookAdmin(@RequestBody Book book) 
	{
		restTemplate.put("http://localhost:8081/lms/admin/books", book);
		return "Update Success!";
	}
	
	@RequestMapping(path = "/admin/books/{bookId}", method = RequestMethod.DELETE)
	public String deleteBookAdmin(@PathVariable("bookId") Integer bookId)
	{
		Map<String, Integer> params =  new HashMap<String, Integer>();
		params.put("bookId", bookId);
		restTemplate.delete("http://localhost:8081/lms/admin/books/{bookdId}", params);
		return "Delete Success!";
	}
	
	@RequestMapping(path = "/admin/authors", method = RequestMethod.GET)
	public Author[] readAuthorsAdmin()
	{
		ResponseEntity<Author[]> response = restTemplate.getForEntity("http://localhost:8081/lms/admin/authors", Author[].class);
		return response.getBody();
	}
	
	
	@RequestMapping(path = "/admin/authors", method= RequestMethod.POST)
	public String createAuthorAdmin(@RequestBody Author author)
	{
		restTemplate.postForEntity("http://localhost:8081/lms/admin/authors", author, Book.class);
		return "Book Created!";
	}
	
	@RequestMapping(path = "/admin/authors", method= RequestMethod.PUT)
	public String updateAuthorAdmin(@RequestBody Author author) 
	{
		restTemplate.put("http://localhost:8081/lms/admin/authors", author);
		return "Update Success!";
	}
	
	@RequestMapping(path = "/admin/authors/{authorId}", method = RequestMethod.DELETE)
	public String deleteAuthorAdmin(@PathVariable("authorId") Integer authorId)
	{
		Map<String, Integer> params =  new HashMap<String, Integer>();
		params.put("authorId", authorId);
		restTemplate.delete("http://localhost:8081/lms/admin/authors/{authordId}", params);
		return "Delete Success!";
	}
	
	@RequestMapping(path = "/admin/publishers", method = RequestMethod.GET)
	public Publisher[] readPublishersAdmin()
	{
		ResponseEntity<Publisher[]> response = restTemplate.getForEntity("http://localhost:8081/lms/admin/publishers", Publisher[].class);
		return response.getBody();
	}
	
	
	@RequestMapping(path = "/admin/publishers", method= RequestMethod.POST)
	public String createPublisherAdmin(@RequestBody Publisher publisher)
	{
		restTemplate.postForEntity("http://localhost:8081/lms/admin/publishers", publisher, Publisher.class);
		return "Create Success!";
	}
	
	@RequestMapping(path = "/admin/publishers", method= RequestMethod.PUT)
	public String updatePublisherAdmin(@RequestBody Publisher publisher) 
	{
		restTemplate.put("http://localhost:8081/lms/admin/publishers", publisher);
		return "Update Success!";
	}
	
	@RequestMapping(path = "/admin/publishers/{publisherId}", method = RequestMethod.DELETE)
	public String deletePublisherAdmin(@PathVariable("publisherId") int publisherId)
	{
		Map<String, Integer> params =  new HashMap<String, Integer>();
		params.put("publisherId", publisherId);
		restTemplate.delete("http://localhost:8081/lms/admin/publishers/{publisherdId}", params);
		return "Delete Success!";
	}
	
	@RequestMapping(path = "/admin/branches", method = RequestMethod.GET)
	public Branch[] readBranchesAdmin()
	{
		ResponseEntity<Branch[]> response = restTemplate.getForEntity("http://localhost:8081/lms/admin/branches", Branch[].class);
		return response.getBody();
	}
	
	
	@RequestMapping(path = "/admin/branches", method= RequestMethod.POST)
	public String createBranchAdmin(@RequestBody Branch branch)
	{
		restTemplate.postForEntity("http://localhost:8081/lms/admin/branches", branch, Branch.class);
		return "Create Success!";
	}
	
	@RequestMapping(path = "/admin/branches", method= RequestMethod.PUT)
	public String updateBranchAdmin(@RequestBody Branch branch) 
	{
		restTemplate.put("http://localhost:8081/lms/admin/branches", branch);
		return "Update Success!";
	}
	
	@RequestMapping(path = "/admin/branches/{branchId}", method = RequestMethod.DELETE)
	public String deleteBranchAdmin(@PathVariable("branchId") Integer branchId)
	{
		Map<String, Integer> params =  new HashMap<String, Integer>();
		params.put("branchId", branchId);
		restTemplate.delete("http://localhost:8081/lms/admin/branches/{branchdId}", params);
		return "Delete Success!";
	}
	
	@RequestMapping(path = "/admin/borrowers", method = RequestMethod.GET)
	public Borrower[] readBorrowersAdmin()
	{
		ResponseEntity<Borrower[]> response = restTemplate.getForEntity("http://localhost:8081/lms/admin/borrowers", Borrower[].class);
		return response.getBody();
	}
	
	
	@RequestMapping(path = "/admin/borrowers", method= RequestMethod.POST)
	public String createBorrowerAdmin(@RequestBody Borrower borrower)
	{
		restTemplate.postForEntity("http://localhost:8081/lms/admin/borrowers", borrower, Borrower.class);
		return "Create Success!";
	}
	
	@RequestMapping(path = "/admin/borrowers", method= RequestMethod.PUT)
	public String updateBorrowerAdmin(@RequestBody Borrower borrower) 
	{
		restTemplate.put("http://localhost:8081/lms/admin/borrowers", borrower);
		return "Update Success!";
	}
	
	@RequestMapping(path = "/admin/borrowers/{cardNo}", method = RequestMethod.DELETE)
	public String deleteBorrowerAdmin(@PathVariable("cardNo") Integer cardNo)
	{
		Map<String, Integer> params =  new HashMap<String, Integer>();
		params.put("cardNo", cardNo);
		restTemplate.delete("http://localhost:8081/lms/admin/borrowers/{cardNo}", params);
		return "Delete Success!";
	}
	
	@RequestMapping(path = "/admin/loans", method = RequestMethod.GET)
	public BookLoans[] readBookLoanssAdmin()
	{
		ResponseEntity<BookLoans[]> response = restTemplate.getForEntity("http://localhost:8081/lms/admin/loans", BookLoans[].class);
		return response.getBody();
	}

	@RequestMapping(path = "/admin/loans", method= RequestMethod.PUT)
	public String updateBookLoansAdmin(@RequestBody BookLoans loan) 
	{
		restTemplate.put("http://localhost:8081/lms/admin/loans", loan);
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
