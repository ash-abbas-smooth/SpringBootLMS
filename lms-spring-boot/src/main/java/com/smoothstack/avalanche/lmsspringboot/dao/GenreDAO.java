package com.smoothstack.avalanche.lmsspringboot.dao;

import java.util.List;
import java.util.ArrayList;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;

import com.smoothstack.avalanche.lmsspringboot.entity.Genre;


public class GenreDAO extends BaseDAO<Genre> {

  public GenreDAO(Connection conn) {
    super(conn);
  }

  public List<Genre> readGenres() throws ClassNotFoundException, SQLException {
    return read( "SELECT * FROM tbl_genre", null );
  }

  @Override
  public List<Genre> extractData( ResultSet rs ) throws ClassNotFoundException, SQLException {
    List<Genre> genres = new ArrayList<>();
    while (rs.next()) {
      Genre genre = new Genre();
      genre.setGenreId(rs.getInt("genre_id"));
      genre.setGenreName(rs.getString("genre_name"));
      genres.add(genre);
    }
    return genres;
  }

  @Override
  public List<Genre> extractDataFirstLevel(ResultSet rs) throws ClassNotFoundException, SQLException {
    List<Genre> genres = new ArrayList<>();
    while (rs.next()) {
      Genre genre = new Genre();
      genre.setGenreId(rs.getInt("genre_id"));
      genre.setGenreName(rs.getString("genre_name"));
      genres.add(genre);
    }
    return genres;
  }
}