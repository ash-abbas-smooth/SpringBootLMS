package com.smoothstack.avalanche.lmsspringboot.ui;

import java.util.List;
import java.util.HashMap;
import java.util.Scanner;

import java.sql.SQLException;

import com.smoothstack.avalanche.lmsspringboot.entity.Book;
import com.smoothstack.avalanche.lmsspringboot.entity.Copies;
import com.smoothstack.avalanche.lmsspringboot.entity.Author;
import com.smoothstack.avalanche.lmsspringboot.entity.Branch;

import com.smoothstack.avalanche.lmsspringboot.svc.LibrarianSVC;


public class LibrarianUI extends BaseUI<LibrarianUI> {

  private enum State {
    MENU1,
    MENU2,
    MENU3,
    STOP
  }

  private Book   book;
  private State  state;
  private Branch branch;

  private List<Book>   books;
  private List<Branch> branches;

  LibrarianSVC libsvc;

  public LibrarianUI() {
    this.state  = State.MENU1;
    this.libsvc = new LibrarianSVC();
  }

  @Override
  public void start() {
    while(this.state != State.STOP){
      try{
        switch(this.state) {
          case MENU1: menu1();
                      break;
          case MENU2: menu2();
                      break;
          case MENU3: menu3();
                      break;
          default: throw new NoSuchMethodException();
        }
      } catch(NoSuchMethodException e) {
        this.state = State.STOP;
        e.printStackTrace();
      }
    }
  }

  private void menu1() {
    try{
      String menu = (""
        + "\n\t1) Enter branch you manage"
        + "\n\t2) Quit to previous\n");
      String input = prompt(menu, true);
      switch( input ) {
        case "1": this.state = State.MENU2;
                  break;
        case "2": this.state = State.STOP;
                  break;
        default: throw new IllegalArgumentException();
      }
    } catch( IllegalArgumentException e ) {
      System.out.println( "\n[!] Invalid selection @ main." );
    }
  }

  private void menu2() {
    try{

      this.branches = this.libsvc.readBranches();

      String menu = "Which branch do you want to manage:\n\n";

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

      this.state = State.MENU3;

    } catch( IllegalArgumentException e ) {
      System.out.println( "\n[!] Invalid selection @ main." );
    }
  }

  private void menu3() {
    try{
      String menu = (""
        + "\t1) Update the details of the Library"
        + "\n\t2) Add copies of Book to the Branch"
        + "\n\t3) Quit to previous\n");

      String input = prompt(menu, true);

      switch(input){
        case "1": updateBranch();
                  break;
        case "2": addBooks();
                  break;
        case "3": this.state = State.MENU1;
                  break;
        default: throw new IllegalArgumentException();
      }
    } catch( IllegalArgumentException e ) {
      System.out.println( "\n[!] Invalid selection, try again." );
    }
  }

  private void updateBranch(){

    Scanner scan = new Scanner(System.in);

    String menu = ""
      + "\tYou have chosen to update the Branch with Branch Id: "
      + this.branch.getBranchId()+" and Branch Name: "
      + this.branch.getBranchName()
      + "\n\tEnter ‘quit’ at any prompt to cancel operation.";

    prompt(menu, false);
    String newNamePrompt = "\nPlease enter new branch name or enter N/A for no change: ";
    System.out.print(newNamePrompt);
    String newName = scan.nextLine();

    if(newName.equals("quit")){
      scan.close();
      return;
    } else {

      String newAddressPrompt = "\nPlease enter new branch address or enter N/A for no change: ";
      System.out.print(newAddressPrompt);
      String newAddress = scan.nextLine();
      if(newAddress.equals("quit")){
    	scan.close();
        return;
      } else {
        this.branch.setBranchName(
          (newName.equals("N/A") ? this.branch.getBranchName() : newName )
        );
        this.branch.setBranchAddress(
          (newAddress.equals("N/A") ? this.branch.getBranchAddress() : newAddress )
        );
      }
    }

    Boolean result = this.libsvc.updateBranch(this.branch);

    if(result){
      System.out.println("\n[+] Branch successfully updated.\n");
    } /*else { OUTPUTS EVEN IF NO CHANGE IS MADE, NEED TO ALTER LOGIC/FLOW
      System.out.println("\n[!] Failed to update branch!");
    }
    */
    this.state = State.MENU3;
    scan.close();
  }

  private void addBooks(){

    this.books = this.libsvc.readBooks();

    Scanner scan = new Scanner(System.in);

    try{
      String menu = "Pick the book you want to add copies of to your branch:\n\n";
      for(Book b : books){

        String authors = "";
        for(Author a : b.getAuthors()){
          authors += (a.getAuthorName() + " ");
        }

        menu += "\t"
             + b.getBookId() + ") "
             + b.getTitle() + " by "
             + authors
             + "\n";
      }

      String input = prompt(menu, true);
      for(Book b : books){
        if( String.valueOf(b.getBookId()).equals(input) ){
          this.book = b;
        }
      }

      if(book == null ){
    	scan.close();
        throw new IllegalArgumentException();
      }
    } catch(IllegalArgumentException e){
      System.out.println("[!] Invalid selection, try again.");
    }

    try{
      Integer copies = this.libsvc.readCopies(this.branch, this.book);

      String prompt = "Existing number of copies: "
                    + ( copies > 0 ? copies : "0" )
                    + "\n";

      System.out.println(prompt);
      System.out.print("Enter new number of copies: ");

      Integer input = Integer.parseInt(scan.next());

      Boolean result = this.libsvc.addCopies(input, this.branch, this.book );

      if(result){
        System.out.println("\n[+] Added "+input+" copies of "+book.getTitle()+" to "+branch.getBranchName()+".\n");
      } else {
        System.out.println("\n[!] Adding more copies to branch failed!\n");
      }

    } catch(NumberFormatException e){
      System.out.println( "\n[!] Invalid selection, try again." );
    }
    
    scan.close();
  }
}



