package com.smoothstack.avalanche.lms.entity;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_borrower")
public class Borrower {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cardNo;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "phone")
	private String phone;
	
//	@OneToMany(
//			mappedBy = "borrower",
//			cascade = CascadeType.ALL,
//			orphanRemoval = true
//			)
//	private List<BookLoans> loans;
//	
	/*
	 * GETTERS/SETTERS
	 */
	public int getCardNo() {
		return cardNo;
	}
	public void setCardNo(int cardNo) {
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
//	public List<BookLoans> getLoans() {
//		return loans;
//	}
//	public void setLoans(List<BookLoans> bookLoans) {
//		this.loans = bookLoans;
//	}

	/*
	 * EQUAL / HASHCODE
	 */
	@Override
	public int hashCode() {
		return Objects.hash(name,address,phone);
	}
	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;
		Borrower other = (Borrower) o;
		return Objects.equals(getName(), other.getName()) && Objects.equals(getAddress(), other.getAddress()) 
				&& Objects.equals(getPhone(), other.getPhone());
	}
	
}
