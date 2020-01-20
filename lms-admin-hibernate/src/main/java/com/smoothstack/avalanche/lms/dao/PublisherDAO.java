package com.smoothstack.avalanche.lms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smoothstack.avalanche.lms.entity.Publisher;

@Repository
public interface PublisherDAO extends JpaRepository<Publisher, Integer> {

}
