package com.smoothstack.avalanche.lms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smoothstack.avalanche.lms.entity.Genre;

@Repository
public interface GenreDAO extends JpaRepository<Genre ,Long>{

}
