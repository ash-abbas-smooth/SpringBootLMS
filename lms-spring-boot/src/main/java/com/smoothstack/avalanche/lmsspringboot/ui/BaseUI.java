package com.smoothstack.avalanche.lmsspringboot.ui;

import java.util.Scanner;

public abstract class BaseUI<T> {

  private Scanner scan = new Scanner(System.in);

  public void start() {}

  public String prompt(String menu, Boolean inputReq) {
    if(inputReq){
      System.out.print(menu);
      System.out.print("\n[?] Enter selection: ");
      String input = this.scan.next();
      System.out.print("\n");
      return input;
    } else {
      System.out.print(menu);
      System.out.print("\n");
      return "NULL";
    }
  }
}