package com.mycompany.prompt1.gpt40.review1;

public class Account {
  private float principal;
  private float rate;
  private int daysActive;
  private AccountType accountType;

  // Consider adding getters and setters for these fields if necessary.

  public Account(float principal, float rate, int daysActive, AccountType accountType) {
    this.principal = principal;
    this.rate = rate;
    this.daysActive = daysActive;
    this.accountType = accountType;
  }

  public AccountType getAccountType() {
    return accountType;
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
}
