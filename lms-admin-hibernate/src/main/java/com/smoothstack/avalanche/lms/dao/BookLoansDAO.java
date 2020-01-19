package com.smoothstack.avalanche.lms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smoothstack.avalanche.lms.entity.BookLoans;

@Repository
public interface BookLoansDAO extends JpaRepository<BookLoans, Integer> {

}
