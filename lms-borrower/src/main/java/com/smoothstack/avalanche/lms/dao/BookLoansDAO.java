package com.smoothstack.avalanche.lms.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.smoothstack.avalanche.lms.entity.BookLoans;

@Repository
public interface BookLoansDAO extends JpaRepository<BookLoans , Long>{

	@Query("SELECT bookloans FROM BookLoans bookloans WHERE bookloans.id.borrower.cardNo = :cardNum")
	List<BookLoans> findByCardNo(@Param("cardNum") int cardNo);
	
	@Query("SELECT bookloan FROM BookLoans bookloan "
			+ "WHERE bookloan.id.borrower.cardNo = :cardNum AND "
			+ "bookloan.id.book.bookId = :bookId AND "
			+ "bookloan.id.branch.branchId = :branchId")
	Optional<BookLoans> findByBookLoanId(@Param("cardNum") int cardNo, @Param("bookId") int bookId, @Param("branchId") int branchId);
}
