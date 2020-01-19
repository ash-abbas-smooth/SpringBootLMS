package com.smoothstack.avalanche.lms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.smoothstack.avalanche.lms.entity.BookCopies;
import com.smoothstack.avalanche.lms.entity.id.BookCopiesId;

@Repository
public interface BookCopiesDAO extends JpaRepository<BookCopies ,Long>{
//
//	@Query("SELECT bc FROM BookCopies bc WHERE bc.branchId = ?1")
//	List<BookCopies> findBookCopiesByBranch(int branchId);
//	
//	@Query("UPDATE BookCopies bc "
//			+ "SET bc.noOfCopies = :noOfCopies"
//			+ "WHERE bc.bookId = :#{#id.bookId} AND bc.branchId = :#{#id.branchId}")
//	void updateBookCopies(@Param("noOfCopies")int copies, @Param("id") BookCopiesId id);
}
