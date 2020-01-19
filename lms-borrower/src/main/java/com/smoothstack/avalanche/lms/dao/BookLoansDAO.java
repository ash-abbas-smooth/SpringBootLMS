package com.smoothstack.avalanche.lms.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.smoothstack.avalanche.lms.entity.BookLoans;

@Repository
public interface BookLoansDAO extends JpaRepository<BookLoans ,Long>{

	@Query("SELECT bookloans FROM BookLoans bookloans WHERE bookloans.id.cardNo = :cardNum")
	List<BookLoans> findByCardNo(@Param("cardNum") int cardNo);
	
	@Modifying
	@Query("UPDATE BookLoans bookloans "
			+ "SET bookloans.dueDate = :dueDate"
			+ " WHERE bookloans.id.bookId = :bkid AND bookloans.id.cardNo = :cn AND bookloans.id.branchId = :brid")
	void updateDueDate(@Param("dueDate") Date date, @Param("bkid") int bkid, @Param("cn") int cardNo, @Param("brid") int brid);
	
	@Modifying
	@Query("UPDATE BookLoans bookloans "
			+ "SET bookloans.dateIn = :dateIn"
			+ " WHERE bookloans.id.bookId = :bkid AND bookloans.id.cardNo = :cn AND bookloans.id.branchId = :brid")
	void updateDateIn(@Param("dateIn") Date date, @Param("bkid") int bkid, @Param("cn") int cardNo, @Param("brid") int brid);
	
	@Modifying
	@Query(value = "INSERT INTO tbl_book_loans (book_id, card_no, branch_id, date_out, due_date) "
			+ "VALUES (:bkid, :cn, :brid, :do, :dd)",
			nativeQuery = true)
	void createBookLoan(@Param("bkid") int bkid, @Param("cn") int cardNo, @Param("brid") int branchId, @Param("do") Date dateOut, @Param("dd") Date dueDate);
	
}
