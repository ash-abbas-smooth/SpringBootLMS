/**
 * 
 */
package com.smoothstack.avalanche.lms.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_library_branch")
public class Branch {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "branchId")
	private Integer branchId;
    
	@Column(name = "branchName")
	private String branchName;
	
	@Column(name = "branchAddress")
	private String address;
	
	public Branch() {}
	public Branch(Integer branchId, String branchName, String address) {
		super();
		this.branchId = branchId;
		this.branchName = branchName;
		this.address = address;
	}
//	private List<BookCopies> bookCopies;
//	private List<BookLoans> bookLoans;
	
	
	public Integer getBranchId() {
		return branchId;
	}
	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
//	public List<BookCopies> getBookCopies() {
//		return bookCopies;
//	}
//	public void setBookCopies(List<BookCopies> bookCopies) {
//		this.bookCopies = bookCopies;
//	}
//	public List<BookLoans> getBookLoans() {
//		return bookLoans;
//	}
//	public void setBookLoans(List<BookLoans> bookLoans) {
//		this.bookLoans = bookLoans;
//	}
	
}
