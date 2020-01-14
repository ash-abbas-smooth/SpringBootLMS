package com.smoothstack.avalanche.lmsspringboot.ui;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

import com.smoothstack.avalanche.lmsspringboot.entity.Book;
import com.smoothstack.avalanche.lmsspringboot.entity.Loan;
import com.smoothstack.avalanche.lmsspringboot.entity.Copies;
import com.smoothstack.avalanche.lmsspringboot.entity.Author;
import com.smoothstack.avalanche.lmsspringboot.entity.Branch;
import com.smoothstack.avalanche.lmsspringboot.entity.Borrower;

import com.smoothstack.avalanche.lmsspringboot.svc.BorrowerSVC;

import java.sql.SQLException;

public class BorrowerUI extends BaseUI<BorrowerUI> {

  private Book         book;
  private Scanner      scan;
  private State        state;
  private Branch       branch;
  private Integer      cardNo;
  private BorrowerSVC  brwrsvc;

  private List<Book>   books;
  private List<Loan>   loans;
  private List<Copies> copies;
  private List<Branch> branches;

  private enum State {
    LOGIN,
    MENU1,
    MENU2,
    MENU3,
    STOP
  }

  public BorrowerUI(){
    this.state    = State.LOGIN;
    this.brwrsvc  = new BorrowerSVC();
    this.scan     = new Scanner(System.in);
  }

  @Override
  public void start(){

    while(this.state != State.STOP){
      try{
        switch(this.state) {
          case LOGIN: login();
                      break;
          case MENU1: menu1();
                      break;
          case MENU2: menu2();
                      break;
          case MENU3: menu3();
                      break;
          default: throw new NoSuchMethodException();
        }
      } catch( NoSuchMethodException e ) {
        this.state = State.STOP;
        e.printStackTrace();
      }
    }
  }

  public void login(){
    System.out.print("\nEnter valid card number, or 'quit' to cancel: ");

    String input = scan.next();
    if(input.equals("quit")){
      this.state = State.STOP;
    } else {
      try{
        // Valid cardNo for testing: 4964773
        Integer cardNo = Integer.parseInt(input);
        List<Borrower> borrowers = this.brwrsvc.readBorrowers();
        for(Borrower b : borrowers){
          if(cardNo.equals(b.getCardNo())){
            this.cardNo = cardNo;
            this.state = State.MENU1;
          }
        }

        /* DEBUG */this.state = State.MENU1;/* DEBUG */

        if(this.state == State.LOGIN){
          System.out.println( "\n[!] Card number not found, please try again." );
        }
      } catch(IllegalArgumentException e){
        System.out.println( "\n[!] Not a valid card number!" );
      }
    }
  }

  public void menu1(){

    String menu = ""
      + "\n\t1) Check out a book"
      + "\n\t2) Return a book"
      + "\n\t3) Quit to Previous\n";

    String input = prompt(menu, true);
    try{
      switch(input){
        case "1": this.state = State.MENU2;
                  break;
        case "2": this.state = State.MENU3;
                  break;
        case "3": this.state = State.STOP;
                  break;
        default: throw new IllegalArgumentException();
      }
    } catch( IllegalArgumentException e ) {
      System.out.println( "\n[!] Invalid selection @ menu1." );
    }
  }

  private void menu2() {
    try{

      this.branches = this.brwrsvc.readBranches();

      String menu = "Pick the Branch you want to check out from:\n\n";

      for(Branch b : this.branches){
        menu += "\t"
             + b.getBranchId() + ") "
             + b.getBranchName() + ", "
             + b.getBranchAddress()
             + "\n";
      }

      String input = prompt(menu, true);
      for(Branch b : this.branches){
        if( String.valueOf(b.getBranchId()).equals(input) ){
          this.branch = b;
        }
      }

      if(this.branch == null ){
        throw new IllegalArgumentException();
      }

      checkOutBook();

    } catch( IllegalArgumentException e ) {
      System.out.println( "\n[!] Invalid selection @ menu2." );
    }
  }

  public void menu3(){

    try{

      this.branches = this.brwrsvc.readBranches();

      String menu = "Pick the Branch you want to return to:\n\n";

      for(Branch b : this.branches){
        menu += "\t"
             + b.getBranchId() + ") "
             + b.getBranchName() + ", "
             + b.getBranchAddress()
             + "\n";
      }

      String input = prompt(menu, true);
      for(Branch b : this.branches){
        if( String.valueOf(b.getBranchId()).equals(input) ){
          this.branch = b;
        }
      }

      if(this.branch == null ){
        throw new IllegalArgumentException();
      }

      returnBook();

    } catch( IllegalArgumentException e ) {
      System.out.println( "\n[!] Invalid selection @ menu3." );
    }
  }

  public void checkOutBook(){

    this.books = this.branch.getBooks();

    try{
      String menu = "Pick the book you want to check out:\n\n";
      for(Book b : this.books){
        String authors = "";
        for(Author a : b.getAuthors()){
          authors += (a.getAuthorName() + ",");
        }

        menu += "\t"
             + b.getBookId() + ") "
             + b.getTitle() + " by "
             + authors
             + "\n";
      }

      String quitIndex = String.valueOf(
                          this.books.get( this.books.size() -1 )
                          .getBookId() + 1);

      menu += "\t"+quitIndex+") Quit to cancel operation\n";

      String input = prompt(menu, true);
      if(input.equals(quitIndex)){
        this.state = State.MENU1;
        return;
      } else {
        for(Book b : this.branch.getBooks()){
          if( String.valueOf(b.getBookId()).equals(input) ){
            this.book = b;
          }
        }
      }

      if(book == null ){
        throw new IllegalArgumentException();
      } else {
        Boolean result = this.brwrsvc.addLoan(this.book, this.branch, this.cardNo);
        if(result){
          System.out.println("\n[+] Book successfully checked out.\n");
          this.state = State.MENU1;
        }
      }
    } catch(IllegalArgumentException e){
      System.out.println("[!] Invalid selection, try again.");
    }
  }

  public void returnBook(){

    this.loans = brwrsvc.readLoans(this.cardNo);

    try{
      String menu = "Pick the book you want to return:\n\n";
      for(Loan l : this.loans){

        menu += "\t"
             + l.getBookId() + ") "
             + l.getBookTitle() + " by "
             + l.getBookAuthor()
             + "\n";
      }

      String quitIndex = String.valueOf(this.loans.size() + 1);

      menu += "\t"+quitIndex+") Quit to cancel operation\n";

      String input = prompt(menu, true);
      if(input.equals(quitIndex)){
        this.state = State.MENU1;
        return;
      } else {
        for(Loan loan : this.loans){
          if( String.valueOf(loan.getBookId()).equals(input) ){
            // Boolean result = brwrsvc.returnLoan(l.getBookId(), l.getBranchId(), this.cardNo);
            Boolean result = brwrsvc.returnLoan( loan, this.cardNo);
            if(result){
              System.out.println("\n[+] Book successfully returned.\n");
              this.state = State.MENU1;
            }
          }
        }
      }
    } catch(IllegalArgumentException e){
      System.out.println("[!] Invalid selection, try again.");
      this.state = State.MENU3;
    }
  }
}
