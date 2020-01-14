package com.smoothstack.avalanche.lmsspringboot.ui;

import java.util.*;

public class AdminUI extends BaseUI<AdminUI> {

  State state;

  private enum State {
    MAIN,
    MENU1,
    MENU2,
    MENU3,
    STOP
  }

  public AdminUI(){
    this.state = State.MAIN;
  }

  @Override
  public void start() {
    try{

    } catch( Exception e ) {
      e.printStackTrace();
    }
  }
}