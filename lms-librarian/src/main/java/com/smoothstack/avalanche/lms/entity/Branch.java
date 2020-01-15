/**
 *
 */
package com.smoothstack.avalanche.lms.entity;

import java.util.List;

/**
 * @author Ashian
 *
 */
public class Branch
{
	private int branchId;
	private String branchName;
	private String branchAddress;
	private List<BookCopies> bookCopies;
	private List<BookLoans> bookLoans;

	public int getBranchId() {
		return branchId;
	}
	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getBranchAddress() {
		return branchAddress;
	}
	public void setBranchAddress(String address) {
		this.branchAddress = address;
	}
	public List<BookCopies> getBookCopies() {
		return bookCopies;
	}
	public void setBookCopies(List<BookCopies> bookCopies) {
		this.bookCopies = bookCopies;
	}
	public List<BookLoans> getBookLoans() {
		return bookLoans;
	}
	public void setBookLoans(List<BookLoans> bookLoans) {
		this.bookLoans = bookLoans;
	}

}
