package com.smoothstack.avalanche.lms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.smoothstack.avalanche.lms.entity.BookLoans;

@Repository
public interface BookLoansDAO extends JpaRepository<BookLoans ,Long>{

	@Query("SELECT bookloans FROM BookLoans bookloans WHERE bookloans.id.cardNo = :cardNum")
	List<BookLoans> findByCardNo(@Param("cardNum") int cardNo);
	
//	@Query("UPDATE BookLoans bookloans "
//			+ "SET bookloans.dueDate = :dueDate"
//			+ "WHERE bookloans.bookId = :#{#id.bookId} AND bookloans.cardNo = :#{#id.cardNo} AND bookloans.branchId = :#{#id.branchId}")
//	void updateDueDate(@Param("dueDate") Date date, @Param("id") BookLoansId id);
//	
//	@Query("UPDATE BookLoans bookloans "
//			+ "SET bookloans.dateIn = :dateIn"
//			+ "WHERE bookloans.bookId = :#{#id.bookId} AND bookloans.cardNo = :#{#id.cardNo} AND bookloans.branchId = :#{#id.branchId}")
//	void updateDateIn(@Param("dateIn") Date date, @Param("id") BookLoansId id);
//	
//	@Query("INSERT INTO Bookloans bookloans (bookloans.bookId, bookloans.cardNo, bookloans.branchId, bookloans.dateOut, bookloans.dueDate, bookloans.dateIn)"
//			+ "VALUES (:#{#loan.bookId}, :#{#loan.cardNo}, :#{#loan.branchId}, :#{#loan.dateOut}, :#{#loan.dueDate}, :#{#loan.dateIn}")
//	void createBookLoan(@Param("loan") BookLoans loan);
	
}
