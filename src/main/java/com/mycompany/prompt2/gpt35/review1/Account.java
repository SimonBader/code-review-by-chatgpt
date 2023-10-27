package com.mycompany.prompt2.gpt35.review1;

public class Account {
  /** ADDED **/
  public Account(double principal, double rate, int daysActive, int accountType) {
    this.principal = principal;
    this.rate = rate;
    this.daysActive = daysActive;
    this.accountType = accountType;
  }

  double principal;
  double rate;
  int daysActive;
  int accountType;

  public static final int STANDARD = 0;
  public static final int BUDGET = 1;
  public static final int PREMIUM = 2;
  public static final int PREMIUM_PLUS = 3;
}