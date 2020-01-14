package com.smoothstack.avalanche.lmsspringboot.svc;


import java.util.List;
import java.util.ArrayList;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import com.smoothstack.avalanche.lmsspringboot.entity.Book;
import com.smoothstack.avalanche.lmsspringboot.entity.Loan;
import com.smoothstack.avalanche.lmsspringboot.entity.Branch;
import com.smoothstack.avalanche.lmsspringboot.entity.Borrower;

import com.smoothstack.avalanche.lmsspringboot.dao.LoansDAO;
import com.smoothstack.avalanche.lmsspringboot.dao.BranchDAO;
import com.smoothstack.avalanche.lmsspringboot.dao.BorrowerDAO;

public class BorrowerSVC {

	ConnectionUtil connUtil = new ConnectionUtil();

	public List<Borrower> readBorrowers() {
		Connection conn = null;
		List<Borrower> borrowers = new ArrayList<>();
		try {
			conn = connUtil.getConnection();
			BorrowerDAO bdao = new BorrowerDAO(conn);
			borrowers = bdao.readBorrowers();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("[!] Reading borrowers faiiled!");
		} finally {
			try{
				if (conn != null) {
					conn.close();
				}
			} catch(SQLException e){
				e.printStackTrace();
				System.out.println("[!] Closing DB connection faiiled!");
			}
		}
		return borrowers;
	}

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

	public List<Loan> readLoans( Integer cardNo){
		Connection conn = null;
		List<Loan> loans = new ArrayList<>();
		try {
			conn = connUtil.getConnection();
			LoansDAO ldao = new LoansDAO(conn);
			loans = ldao.readLoans(cardNo);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("[!] Getting loans failed!");
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
		return loans;
	}

	public Boolean addLoan( Book book, Branch branch, Integer cardNo){
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			LoansDAO ldao = new LoansDAO(conn);
			ldao.addLoan(book.getBookId(), branch.getBranchId(), cardNo);
			conn.commit();
		} catch (SQLIntegrityConstraintViolationException e) {
				System.out.println("[!] Failed to check out book, already checked out to this card! (SQL Constraint Violation...)\n\n");
				return false;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("[!] Adding loan faiiled!");
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

	public Boolean returnLoan( Loan loan, Integer cardNo){
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			LoansDAO ldao = new LoansDAO(conn);
			ldao.returnLoan(loan.getBookId(), loan.getBranchId(), cardNo);
			conn.commit();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("[!] Returning loan faiiled!");
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