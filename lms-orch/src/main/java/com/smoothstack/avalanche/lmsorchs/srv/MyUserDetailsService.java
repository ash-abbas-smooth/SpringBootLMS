package com.smoothstack.avalanche.lmsorchs.srv;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.smoothstack.avalanche.lmsorchs.dao.UserDAO;
import com.smoothstack.avalanche.lmsorchs.entity.User;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	UserDAO udao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = udao.findByUsername(username);
		
		user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + username));
		
		return user.map(MyUserDetails::new).get();
	}
	

}
