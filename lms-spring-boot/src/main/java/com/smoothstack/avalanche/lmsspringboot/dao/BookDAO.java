package com.smoothstack.avalanche.lmsspringboot.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.smoothstack.avalanche.lmsspringboot.entity.Book;

public class BookDAO extends BaseDAO<Book> {

	public BookDAO(Connection conn) {
		super(conn);
	}

	public void saveBook(Book book) throws ClassNotFoundException, SQLException {
		save("INSERT INTO tbl_book (title) values(?)", new Object[] { book.getTitle() });
	}

	public Integer saveBookWithId(Book book) throws ClassNotFoundException, SQLException {
		return saveWithID("INSERT INTO tbl_book (title) values(?)", new Object[] { book.getTitle() });
	}

	public void insertBookAuthors(Integer bookId, Integer authorId) throws ClassNotFoundException, SQLException {
		save("INSERT INTO tbl_book_authors values(?, ?)", new Object[] { bookId, authorId});
	}

	public void editBook(Book book) throws ClassNotFoundException, SQLException {

		save("UPDATE tbl_book set title = ? where bookId = ?", new Object[] { book.getTitle(), book.getBookId() });
	}

	public void deleteBook(Book book) throws ClassNotFoundException, SQLException {
		save("DELETE FROM tbl_book where bookId = ?", new Object[] { book.getBookId() });
	}

	public List<Book> readBooks() throws ClassNotFoundException, SQLException {
		return read("SELECT * FROM tbl_book", null);
	}

	@Override
	public List<Book> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {

		AuthorDAO     adao = new AuthorDAO(conn);
		PublisherDAO  pdao = new PublisherDAO(conn);
		BookGenreDAO  bgdao = new BookGenreDAO(conn);

		List<Book> books = new ArrayList<>();

		while (rs.next()) {
			Book book = new Book();
			book.setBookId(rs.getInt("bookId"));
			book.setTitle(rs.getString("title"));
			book.setAuthors(adao.readFirstLevel(
					"SELECT * FROM tbl_author where authorId IN (select authorId from tbl_book_authors where bookId = ?)",
					new Object[] { book.getBookId() }));
			// populate genres, branch etc.
			

			books.add(book);
		}
		return books;
	}

	@Override
	public List<Book> extractDataFirstLevel(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Book> books = new ArrayList<>();
		while (rs.next()) {
			Book book = new Book();
			book.setBookId(rs.getInt("bookId"));
			book.setTitle(rs.getString("title"));
			books.add(book);
		}
		return books;
	}

}
