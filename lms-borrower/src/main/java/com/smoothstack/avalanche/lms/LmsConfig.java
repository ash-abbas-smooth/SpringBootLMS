package com.smoothstack.avalanche.lms;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.smoothstack.avalanche.lms.dao.*;

@Configuration
public class LmsConfig {

	/*
	public final String driver = "com.mysql.cj.jdbc.Driver";
	public final String url = "jdbc:mysql://localhost:3306/library?useSSL=false&allowPublicKeyRetrieval=true";
	public final String username = "root";
	public final String password = "root";

	@Bean
//	@Scope(value="prototype")
	public DataSource dataSource(){
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(driver);
		ds.setUrl(url);
		ds.setUsername(username);
		ds.setPassword(password);
		return ds;
	}

	@Bean
//	@Scope(value="prototype")
	public DataSource dataSourceOracle(){
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(driver);
		ds.setUrl(url);
		ds.setUsername(username);
		ds.setPassword(password);
		return ds;
	}
	
	@Bean
	@Qualifier(value="mySqlTemplate")
	public JdbcTemplate jdbcTemplate(){
		return new JdbcTemplate(dataSource());
	}
*/
	@Bean
	public AuthorDAO adao(){
		return new AuthorDAO();
	}

	@Bean
	public BookDAO bdao(){
		return new BookDAO();
	}

	@Bean
	public GenreDAO gdao(){
		return new GenreDAO();
	}
	@Bean
	public BookCopiesDAO bcdao(){
		return new BookCopiesDAO();
	}
	@Bean
	public BookLoansDAO bldao(){
		return new BookLoansDAO();
	}
	@Bean
	public BorrowerDAO bodao(){
		return new BorrowerDAO();
	}
	@Bean
	public BranchDAO brdao(){
		return new BranchDAO();
	}
/*
	@Bean
	public DataSourceTransactionManager txManager(){
		return new DataSourceTransactionManager(dataSource());
	}
	*/
}
