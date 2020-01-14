package com.smoothstack.avalanche.lmsspringboot.entity;

public class Publisher {

	  private Integer publisherId;
	  private String  publisherName;
	  private String  publisherPhone ;
	  private String  publisherAddress;


	  public Integer getPublisherId(){
	    return publisherId;
	  }

	  public void setPublisherId(Integer publisherId){
	    this.publisherId = publisherId;
	  }

	  public String getPublisherName(){
	    return publisherName;
	  }

	  public void setPublisherName(String publisherName){
	    this.publisherName = publisherName;
	  }

	  public String getPublisherAddress(){
	    return publisherAddress;
	  }

	  public void setPublisherAddress(String publisherAddress){
	    this.publisherAddress = publisherAddress;
	  }

	  public String getPublisherPhone(){
	    return publisherPhone;
	  }

	  public void setPublisherPhone(String publisherPhone){
	    this.publisherPhone = publisherPhone;
	  }
	}