package com.mycompany.prompt4.gpt35.review3;

public class Account {

  /** ADDED **/
  public Account(float principal, float rate, int daysActive, AccountType accountType) {
    this.principal = principal;
    this.rate = rate;
    this.daysActive = daysActive;
    this.accountType = accountType;
  }

  float principal;
  float rate;
  int daysActive;

  /** ADDED TODO-- code does not compile (fix) **/
  AccountType accountType;
  /** ADDED **/

  public enum AccountType {
    STANDARD,
    BUDGET,
    PREMIUM,
    PREMIUM_PLUS
  }

  public static final double DAYS_IN_YEAR = 365.25;
}