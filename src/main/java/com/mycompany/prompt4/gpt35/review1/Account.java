package com.mycompany.prompt4.gpt35.review1;

public class Account {

  public Account(float principal, float rate, int daysActive, int accountType) {
    this.principal = principal;
    this.rate = rate;
    this.daysActive = daysActive;
    this.accountType = accountType;
  }

  float principal;
  float rate;
  int daysActive;
  int accountType;

  public static final int STANDARD = 0;
  public static final int BUDGET = 1;
  public static final int PREMIUM = 2;
  public static final int PREMIUM_PLUS = 3;
}