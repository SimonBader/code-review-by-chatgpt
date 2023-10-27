package com.mycompany.prompt1.gpt35.review2;

/**
 * Represents an account with principal, rate, daysActive, and accountType fields.
 * Account types are defined as constants.
 */
public class Account {
  /** ADDED **/
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

  // Constructors, getters, and setters can be added here for better encapsulation.
}
