package com.smoothstack.avalanche.lmsspringboot.dao;


import com.smoothstack.avalanche.lmsspringboot.entity.Book;
import com.smoothstack.avalanche.lmsspringboot.entity.BookGenre;

import java.util.List;
import java.util.ArrayList;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;

public class BookGenreDAO extends BaseDAO<BookGenre> {

  public BookGenreDAO(Connection conn) {
    super(conn);
  }

  public List<BookGenre> readBookGenres(Book book) throws ClassNotFoundException, SQLException {
    return read( "SELECT * FROM tbl_book_genres WHERE bookId = ?", new Object[] { book.getBookId() } );
  }

  @Override
  public List<BookGenre> extractData( ResultSet rs ) throws ClassNotFoundException, SQLException {
    List<BookGenre> bookGenres = new ArrayList<>();
    while (rs.next()) {
      BookGenre bookGenre = new BookGenre();
      bookGenre.setGenreId(rs.getInt("genre_id"));
      bookGenre.setBookId(rs.getInt("bookId"));
      bookGenres.add(bookGenre);
    }
    return bookGenres;
  }

  @Override
  public List<BookGenre> extractDataFirstLevel( ResultSet rs ) throws ClassNotFoundException, SQLException {
    List<BookGenre> bookGenres = new ArrayList<>();
    while (rs.next()) {
      BookGenre bookGenre = new BookGenre();
      bookGenre.setGenreId(rs.getInt("genre_id"));
      bookGenre.setBookId(rs.getInt("bookId"));
      bookGenres.add(bookGenre);
    }
    return bookGenres;
  }
}
