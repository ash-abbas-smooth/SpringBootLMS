package com.smoothstack.avalanche.lmsspringboot;

import com.smoothstack.avalanche.lmsspringboot.svc.BorrowerSVC;

import java.util.*;

import com.smoothstack.avalanche.lmsspringboot.ui.*;

public class LMSJDBC {

	public static void main(String[] args) {
	    System.out.println("\n\n\n[>] >>> Application Starting <<< [<]\n");
	
	    Scanner      scan  = new Scanner( System.in );
	    List<String> users = new ArrayList<>(Arrays.asList("Admin","Borrower","Librarian"));
	
	    while( true ){
	      System.out.println("\n\nWelcome to the GCIT Library Management System. Which category of user are you?\n");
	
	      BaseUI user = null;
	      do{
	
	        Integer index = 1;
	        for( String userType : users ) {
	          System.out.println( "\t"+index+") "+userType );
	          index++;
	        }
	        System.out.print("\n[?] Enter selection: ");
	
	        String input = scan.next();
	        try{
	          switch( input ){
	            case "1": user = new AdminUI();
	                      break;
	            case "2": user = new BorrowerUI();
	                      break;
	            case "3": user = new LibrarianUI();
	                      break;
	            default:  throw new IllegalArgumentException();
	          }
	        } catch( IllegalArgumentException e ) {
	          System.out.println( "\n[!] Invalid selection." );
	        }
	      } while( user == null );
	
	      user.start();
	      scan.close();
	      
	    }

	}
	
}








