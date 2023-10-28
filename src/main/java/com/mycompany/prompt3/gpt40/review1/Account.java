package com.mycompany.prompt3.gpt40.review1;

public class Account {

  /** ADDED **/
  public Account(float principal, float rate, int daysActive, AccountType accountType) {
    this.principal = principal;
    this.rate = rate;
    this.daysActive = daysActive;
    this.accountType = accountType;
  }

  private float principal;
  private float rate;
  private int daysActive;
  private AccountType accountType;

  public enum AccountType {
    STANDARD, BUDGET, PREMIUM, PREMIUM_PLUS
  }

  /** OBSERVE: TODO++  OOP-aware **/
  public float calculateFee() {
    if (accountType == AccountType.PREMIUM || accountType == AccountType.PREMIUM_PLUS) {
      final float FEE_PERCENTAGE = 0.0125f;
      /** ADDED TODO-- code does not compile (quick-fixed)
      return FEE_PERCENTAGE * (principal * Math.exp(rate * (daysActive / 365.25f)) - principal); **/
      return (float) (FEE_PERCENTAGE * (principal * Math.exp(rate * (daysActive / 365.25f)) - principal));
      /** ADDED **/
    }
    return 0;
  }
}