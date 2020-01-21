package com.smoothstack.avalanche.lms.entity;
import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_publisher")
public class Publisher {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "publisherId")
	private Integer publisherId;
	
	@Column(name = "publisherName")
	private String publisherName;
	
	@Column(name = "publisherAddress")
	private String publisherAddress;
	
	@Column(name = "publisherPhone")
	private String publisherPhone;
	
	@OneToMany(mappedBy = "publisher")
	private Collection<Book> publisherBooks;	
	
	public Publisher() {}
	public Publisher(Integer publisherId, String publisherName, String publisherAddress, String publisherPhone,
			Collection<Book> publisherBooks) {
		super();
		this.publisherId = publisherId;
		this.publisherName = publisherName;
		this.publisherAddress = publisherAddress;
		this.publisherPhone = publisherPhone;
		this.publisherBooks = publisherBooks;
	}
	public Integer getPublisherId() {
		return publisherId;
	}
	public void setPublisherId(int publisherId) {
		this.publisherId = publisherId; 
	}
	
	public String getPublisherName() {
		return publisherName;
	}
	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}
	
	public String getPublisherAddress() {
		return publisherAddress;
	}
	public void setPublisherAddress(String publisherAddress) {
		this.publisherAddress = publisherAddress;
	}
	
	public String getPublisherPhone() {
		return publisherPhone;
	}
	public void setPublisherPhone(String publisherPhone) {
		this.publisherPhone = publisherPhone;
	}	
}
