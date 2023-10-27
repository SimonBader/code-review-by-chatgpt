package com.mycompany.prompt3.gpt40.review3;

public class Account {

  /** ADDED **/
  public Account(double principal, double rate, int daysActive, AccountType accountType) {
    this.principal = principal;
    this.rate = rate;
    this.daysActive = daysActive;
    this.accountType = accountType;
  }

  private double principal;
  private double rate;
  private int daysActive;
  private AccountType accountType;

  private static final double FEE_RATE = 0.0125;

  // constructors, getters, setters ...

  double calculatePremiumFee() {
    if (accountType == AccountType.PREMIUM || accountType == AccountType.PREMIUM_PLUS) {
      return FEE_RATE * (principal * Math.exp(rate * (daysActive / 365.25)) - principal);
    }
    return 0;
  }
}