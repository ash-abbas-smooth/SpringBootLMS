package com.smoothstack.avalanche.lmsspringboot.svc;

import java.util.List;
import java.util.ArrayList;

import java.sql.Connection;
import java.sql.SQLException;

import com.smoothstack.avalanche.lmsspringboot.entity.Book;
import com.smoothstack.avalanche.lmsspringboot.entity.Branch;
import com.smoothstack.avalanche.lmsspringboot.entity.Copies;
import com.smoothstack.avalanche.lmsspringboot.entity.Author;

import com.smoothstack.avalanche.lmsspringboot.dao.BookDAO;
import com.smoothstack.avalanche.lmsspringboot.dao.BranchDAO;
import com.smoothstack.avalanche.lmsspringboot.dao.BookCopiesDAO;

public class LibrarianSVC {

	ConnectionUtil connUtil = new ConnectionUtil();

	public List<Branch> readBranches() {
		Connection conn = null;
		List<Branch> branches = new ArrayList<>();
		try {
			conn = connUtil.getConnection();
			BranchDAO bdao = new BranchDAO(conn);
			branches = bdao.readBranches();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("[!] Reading branches faiiled!");
		} finally {
			if (conn != null) {
        try{
          conn.close();
        } catch(SQLException e){
          e.printStackTrace();
    			System.out.println("[!] Closing DB connection faiiled!");
        }
			}
		}
		return branches;
	}

	public List<Book> readBooks(){
		Connection conn = null;
		List<Book> books = new ArrayList<>();
		try {
			conn = connUtil.getConnection();
			BookDAO bdao = new BookDAO(conn);
			books = bdao.readBooks();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("[!] Reading branches faiiled!");
		} finally {
			if (conn != null) {
        try{
          conn.close();
        } catch(SQLException e){
          e.printStackTrace();
    			System.out.println("[!] Closing DB connection faiiled!");
        }
			}
		}
		return books;
	}

	public Boolean addBook(Book book) {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			BookDAO bdao = new BookDAO(conn);
			Integer bookId = bdao.saveBookWithId(book);
			if(book.getAuthors()!=null){
				for(Author a: book.getAuthors()){
					bdao.insertBookAuthors(bookId, a.getAuthorId());
				}
			}
			conn.commit();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("[!] Adding Book failed!");
			if (conn != null) {
				try{
					conn.rollback();
				} catch(SQLException e1){
					e1.printStackTrace();
					System.out.println("[!] Rolling back DB connection faiiled!");
				}
			}
			return false;
		} finally {
			if (conn != null) {
				try{
					conn.close();
				} catch(SQLException e){
					e.printStackTrace();
					System.out.println("[!] Closing DB connection faiiled!");
				}
			}
		}
		return true;
	}

	public Integer readCopies(Branch branch, Book book) {
		Connection conn = null;
		Integer copies = null;
		try {
			conn = connUtil.getConnection();
			BookCopiesDAO bcdao = new BookCopiesDAO(conn);
			List<Copies> result = bcdao.readCopies(branch.getBranchId(), book.getBookId());
			// Hit an index out of bounds error here once...
			copies = result.get(0).getCopies();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("[!] Reading copies faiiled!");
		} finally {
			if (conn != null) {
				try{
					conn.close();
				} catch(SQLException e){
					e.printStackTrace();
					System.out.println("[!] Closing DB connection faiiled!");
				}
			}
		}
		return copies;
	}

	public Boolean updateBranch(Branch branch) {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			BranchDAO bdao = new BranchDAO(conn);
      bdao.updateBranch(branch);
			conn.commit();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("[!] Updating branch faiiled!");
			if (conn != null) {
				try{
					conn.rollback();
				} catch(SQLException e1){
					e1.printStackTrace();
					System.out.println("[!] Rolling back DB connection faiiled!");
				}
			}
			return false;
		} finally {
			if (conn != null) {
        try{
          conn.close();
        } catch(SQLException e){
          e.printStackTrace();
    			System.out.println("[!] Closing DB connection faiiled!");
        }
			}
		}
		return true;
	}

	public Boolean addCopies(Integer noOfCopies, Branch branch, Book book ){

		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			BookCopiesDAO bcdao = new BookCopiesDAO(conn);
			Integer currentCopies = bcdao.readCopies(branch.getBranchId(), book.getBookId()).get(0).getCopies();
			bcdao.updateBookCopies(currentCopies + noOfCopies, book.getBookId(), branch.getBranchId() );
			conn.commit();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			if (conn != null) {
				try{
					conn.rollback();
				} catch(SQLException e1){
					e1.printStackTrace();
					System.out.println("[!] Rolling back DB connection faiiled!");
				}
			}
			return false;
		} finally {
			if (conn != null) {
				try{
					conn.close();
				} catch(SQLException e){
					e.printStackTrace();
					System.out.println("[!] Closing DB connection faiiled!");
				}
			}
		}
		return true;
	}
}