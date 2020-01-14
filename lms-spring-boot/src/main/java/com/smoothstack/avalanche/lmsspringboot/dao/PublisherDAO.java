package com.smoothstack.avalanche.lmsspringboot.dao;


import java.util.List;
import java.util.ArrayList;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;

import com.smoothstack.avalanche.lmsspringboot.entity.Publisher;


public class PublisherDAO extends BaseDAO<Publisher> {

  public PublisherDAO(Connection conn) {
    super(conn);
  }

  public List<Publisher> readPublishers() throws ClassNotFoundException, SQLException {
    return read( "SELECT * FROM tbl_publishers", null );
  }

  @Override
  public List<Publisher> extractData( ResultSet rs ) throws ClassNotFoundException, SQLException {
    List<Publisher> publishers = new ArrayList<>();
    while (rs.next()) {
      Publisher publisher = new Publisher();
      publisher.setPublisherName(rs.getString("publisherName"));
      publisher.setPublisherPhone(rs.getString("publisherPhone"));
      publisher.setPublisherAddress(rs.getString("publisherAddress"));
      publishers.add(publisher);
    }
    return publishers;
  }

  @Override
  public List<Publisher> extractDataFirstLevel( ResultSet rs ) throws ClassNotFoundException, SQLException {
    List<Publisher> publishers = new ArrayList<>();
    while (rs.next()) {
      Publisher publisher = new Publisher();
      publisher.setPublisherId(rs.getInt("publisherId"));
      publisher.setPublisherName(rs.getString("publisherName"));
      publisher.setPublisherPhone(rs.getString("publisherPhone"));
      publisher.setPublisherAddress(rs.getString("publisherAddress"));
      publishers.add(publisher);
    }
    return publishers;
  }
}
