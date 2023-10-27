package com.mycompany.prompt2.gpt35.review2;

public class Account {

  public float getPrincipal() {
    return principal;
  }

  public float getRate() {
    return rate;
  }

  public int getDaysActive() {
    return daysActive;
  }

  public int getAccountType() {
    return accountType;
  }

  private float principal;
  private float rate;
  private int daysActive;
  private int accountType;

  public static final int STANDARD = 0;
  public static final int BUDGET = 1;
  public static final int PREMIUM = 2;
  public static final int PREMIUM_PLUS = 3;

  public Account(float principal, float rate, int daysActive, int accountType) {
    this.principal = principal;
    this.rate = rate;
    this.daysActive = daysActive;
    this.accountType = accountType;
  }

  // Add getter and setter methods for class variables if needed
  // ...

  // You can also override toString() for better debugging
  // ...
}