package com.smoothstack.avalanche.lmsorchs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.smoothstack.avalanche.lmsorchs.dao.UserDAO;
import com.smoothstack.avalanche.lmsorchs.srv.JwtAuthenticationFilter;
import com.smoothstack.avalanche.lmsorchs.srv.JwtAuthorizationFilter;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
	UserDetailsService userDetailsService;
	@Autowired
	UserDAO udao;
	
	 private BCryptPasswordEncoder passwordEncoder;
	
	public SecurityConfiguration(UserDetailsService userDetailsService, UserDAO udao) {
		this.userDetailsService = userDetailsService;
		this.udao = udao;
		this.passwordEncoder = new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userDetailsService);
    }

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.addFilter(new JwtAuthenticationFilter(authenticationManager()))
			.addFilter(new JwtAuthorizationFilter(authenticationManager(),this.udao))
			.authorizeRequests()
			.antMatchers("/login").permitAll()
			.antMatchers("/lms/admin/**").hasRole("ADMIN")
			.antMatchers("/lms/librarian/**").hasAnyRole("ADMIN", "LIB")
			.antMatchers("/lms/borrower/**").hasAnyRole("ADMIN","USER");
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
	    DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
	    authenticationProvider.setUserDetailsService(userDetailsService);
	    authenticationProvider.setPasswordEncoder(passwordEncoder);
	    return authenticationProvider;
	}
	@Bean
	public PasswordEncoder getPasswordEncoder() {return NoOpPasswordEncoder.getInstance();}
}
