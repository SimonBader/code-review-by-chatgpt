package com.mycompany.prompt3.gpt35.review2;

public class Account {

  /** ADDED **/
  public Account(float balance, float interestRate, int daysActive, int accountType) {
    this.balance = balance;
    this.interestRate = interestRate;
    this.daysActive = daysActive;
    this.accountType = accountType;
  }

  public float getBalance() {
    return balance;
  }

  public float getInterestRate() {
    return interestRate;
  }

  public int getDaysActive() {
    return daysActive;
  }

  public int getAccountType() {
    return accountType;
  }

  private float balance;
  private float interestRate;
  private int daysActive;
  private int accountType;

  public static final int STANDARD = 0;
  public static final int BUDGET = 1;
  public static final int PREMIUM = 2;
  public static final int PREMIUM_PLUS = 3;

  // Constructor and getters/setters as needed.
}