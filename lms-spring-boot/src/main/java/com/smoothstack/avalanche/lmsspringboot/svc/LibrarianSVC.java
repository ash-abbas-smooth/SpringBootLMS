package com.smoothstack.avalanche.lmsspringboot.svc;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smoothstack.avalanche.lmsspringboot.dao.*;
import com.smoothstack.avalanche.lmsspringboot.entity.*;

@Service
public class LibrarianSVC {
	
    @Autowired
	private BranchDAO branchDAO;
	
	@Autowired
	private BookCopiesDAO copiesDAO;

	/*
	 * Library Branch Functions
	 */
	public List<Branch> readBranches() throws ClassNotFoundException, SQLException {
		return branchDAO.readBranches();
	}
	
	public void updateBranch(Branch branch) throws ClassNotFoundException, SQLException {
		branchDAO.updateBranch(branch);
	}
	
	/*
	 * Book Copies Functions
	 */
	
	public List<Copies> readBookCopiesByBranch() throws ClassNotFoundException, SQLException {
		return copiesDAO.readBookCopiesByBranch();
	}
	
    public void updateBookCopies(Copies copies) throws ClassNotFoundException, SQLException {
    	copiesDAO.updateBookCopies(copies);
    }
}
