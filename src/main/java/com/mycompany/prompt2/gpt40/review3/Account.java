package com.mycompany.prompt2.gpt40.review3;

import java.math.BigDecimal;

public class Account {

  private BigDecimal principal;
  private BigDecimal rate;
  private int daysActive;
  private AccountType accountType;

  public enum AccountType {
    STANDARD, BUDGET, PREMIUM, PREMIUM_PLUS;
  }

  public static final BigDecimal YEAR_DAYS = new BigDecimal("365.25");
  public static final BigDecimal FEE_RATE = new BigDecimal("0.0125");

  public Account(BigDecimal principal, BigDecimal rate, int daysActive, AccountType accountType) {
    this.principal = principal;
    this.rate = rate;
    this.daysActive = daysActive;
    this.accountType = accountType;
  }

  public AccountType getAccountType() {
    return accountType;
  }

  public BigDecimal getPrincipal() {
    return principal;
  }

  public BigDecimal getRate() {
    return rate;
  }

  public int getDaysActive() {
    return daysActive;
  }
}