package com.smoothstack.avalanche.lms.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.smoothstack.avalanche.lms.entity.BookCopies;

@Repository
public interface BookCopiesDAO extends JpaRepository<BookCopies ,Long>{
//
	@Query("SELECT bc FROM BookCopies bc WHERE bc.id.branch.branchId = :brid")
	List<BookCopies> findBookCopiesByBranch(@Param("brid") int branchId);
	
	@Query("SELECT bc FROM BookCopies bc WHERE bc.id.book.bookId = :bid AND bc.id.branch.branchId = :brid")
	Optional<BookCopies> findBookCopiesById(@Param("bid") int bookId, @Param("brid") int branchId);

	
}
