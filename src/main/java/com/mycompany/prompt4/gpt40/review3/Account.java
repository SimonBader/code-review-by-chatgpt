package com.mycompany.prompt4.gpt40.review3;

public class Account {

  /** ADDED **/
  public Account(float principal, float rate, int daysActive, AccountType accountType) {
    this.principal = principal;
    this.rate = rate;
    this.daysActive = daysActive;
    this.accountType = accountType;
  }

  public float getPrincipal() {
    return principal;
  }

  public float getRate() {
    return rate;
  }

  public int getDaysActive() {
    return daysActive;
  }

  public AccountType getAccountType() {
    return accountType;
  }
  /** ADDED **/

  private float principal;
  private float rate;
  private int daysActive;
  private AccountType accountType;

  public enum AccountType {
    STANDARD, BUDGET, PREMIUM, PREMIUM_PLUS;
  }

  // ... Constructors, getters, setters ...
}