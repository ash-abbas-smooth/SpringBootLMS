package com.smoothstack.avalanche.lmsorchs.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smoothstack.avalanche.lmsorchs.entity.User;

@Repository
public interface UserDAO extends JpaRepository<User, Integer>{
	Optional<User> findByUsername(String username);
}
