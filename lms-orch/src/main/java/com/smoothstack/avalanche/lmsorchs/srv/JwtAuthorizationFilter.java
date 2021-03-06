package com.smoothstack.avalanche.lmsorchs.srv;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.smoothstack.avalanche.lmsorchs.dao.UserDAO;
import com.smoothstack.avalanche.lmsorchs.entity.User;

public class JwtAuthorizationFilter extends BasicAuthenticationFilter{

	private UserDAO udao;
	
	public JwtAuthorizationFilter(AuthenticationManager authenticationManager, UserDAO udao) {
		super(authenticationManager);
		this.udao = udao;
	}
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String header = request.getHeader(JwtProperties.HEADER_STRING);
		
		if(header == null || !header.startsWith(JwtProperties.TOKEN_PREFIX))
		{
			chain.doFilter(request, response);
			return;
		}
		
		Authentication authentication = getUsernamePasswordAuthentication(request);
		SecurityContextHolder.getContext().setAuthentication(authentication);
	
		chain.doFilter(request, response);
	}
	private Authentication getUsernamePasswordAuthentication(HttpServletRequest request) {
		String token = request.getHeader(JwtProperties.HEADER_STRING).replace(JwtProperties.TOKEN_PREFIX,"");
		if( token != null)
		{
			String username = JWT.require(Algorithm.HMAC512(JwtProperties.SECRET.getBytes()))
					.build()
					.verify(token)
					.getSubject();
			
			if(username != null)
			{
				Optional<User> user = udao.findByUsername(username);
				user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + username));
				MyUserDetails userDetails = user.map(MyUserDetails::new).get();
				UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(username, null, userDetails.getAuthorities());
				return auth;
			}
			return null;
		}
		return null;
	}
	



}
