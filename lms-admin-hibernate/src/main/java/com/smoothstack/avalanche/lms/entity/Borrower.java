package com.smoothstack.avalanche.lms.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_borrower")
public class Borrower implements Serializable{

	private static final long serialVersionUID = 4664483656490549923L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cardNo")
	private Integer cardNo;
    
	@Column(name = "name")
	private String name;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "phone")
	private String phone;
	
	@OneToMany(mappedBy = "bookLoanKey.borrower")
	private List<BookLoans> loanBooks;
    /*
     * Equals and Hash-code
     */
    
    /*
     * Getters and Setters
     */
	public Integer getCardNo() {
		return cardNo;
	}
	public void setCardNo(Integer cardNo) {
		this.cardNo = cardNo;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
