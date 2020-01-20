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

	@Query("SELECT bookloans FROM BookLoans bookloans WHERE bookloans.id.borrower.cardNo = :cardNum")
	List<BookLoans> findByCardNo(@Param("cardNum") int cardNo);
	
	
}
