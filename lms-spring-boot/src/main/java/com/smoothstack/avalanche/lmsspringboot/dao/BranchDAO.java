package com.smoothstack.avalanche.lmsspringboot.dao;


import com.smoothstack.avalanche.lmsspringboot.entity.Branch;
import com.smoothstack.avalanche.lmsspringboot.entity.Book;

import java.util.List;
import java.util.ArrayList;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;

public class BranchDAO extends BaseDAO<Branch> {

  public BranchDAO(Connection conn) {
    super(conn);
  }

  public List<Branch> readBranches() throws ClassNotFoundException, SQLException {
    return read( "SELECT * FROM tbl_library_branch", null );
  }

  public void updateBranch(Branch branch) throws ClassNotFoundException, SQLException {
    save("UPDATE tbl_library_branch SET branchName = ?, branchAddress = ? WHERE branchId = ?",
          new Object[] { branch.getBranchName(), branch.getBranchAddress(), branch.getBranchId() });
  }

  @Override
  public List<Branch> extractData( ResultSet rs ) throws ClassNotFoundException, SQLException {
    BookDAO bdao = new BookDAO(conn);
    List<Branch> branches = new ArrayList<>();
    while (rs.next()) {
      Branch branch = new Branch();
      branch.setBranchId(rs.getInt("branchId"));
      branch.setBranchName(rs.getString("branchName"));
      branch.setBranchAddress(rs.getString("branchAddress"));
      branch.setBooks(bdao.read(
        "SELECT * FROM tbl_book where bookId IN (select bookId from tbl_book_copies where branchId = ?)",
        new Object[] { branch.getBranchId() }));
      branches.add(branch);
    }
    return branches;
  }

  @Override
  public List<Branch> extractDataFirstLevel(ResultSet rs) throws ClassNotFoundException, SQLException {
    List<Branch> branches = new ArrayList<>();
    while (rs.next()) {
      Branch branch = new Branch();
      branch.setBranchId(rs.getInt("branchId"));
      branch.setBranchName(rs.getString("name"));
      branches.add(branch);
    }
    return branches;
  }
}
