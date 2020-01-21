package com.smoothstack.avalanche.lms.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_publisher")
public class Publisher {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int publisherId;
	
	@Column(name = "publisherName")
	private String publisherName;
	
	@Column(name = "publisherAddress")
	private String publisherAddress;
	
	@Column(name = "publisherPhone")
	private String publisherPhone;
	
	public Publisher() {}
	public Publisher(int publisherId, String publisherName, String publisherAddress, String publisherPhone) {
		super();
		this.publisherId = publisherId;
		this.publisherName = publisherName;
		this.publisherAddress = publisherAddress;
		this.publisherPhone = publisherPhone;
	}
	/*
	 * GETTERS / SETTERS
	 */
	public int getPublisherId() {
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
	@Override
	public int hashCode() {
		return Objects.hash(publisherId, publisherName, publisherAddress);
	}
	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if( o == null || getClass() != o.getClass()) return false;
		Publisher other = (Publisher) o;
		return Objects.equals(getPublisherId(), other.getPublisherId()) && Objects.equals(getPublisherName(), other.getPublisherName())
				&& Objects.equals(getPublisherPhone(), other.getPublisherPhone());
	}
	
	
}
