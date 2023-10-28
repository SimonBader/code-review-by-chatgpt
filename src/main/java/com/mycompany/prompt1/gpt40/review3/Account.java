package com.mycompany.prompt1.gpt40.review3;

public class Account {
  private float principal;
  private float rate;
  private int daysActive;
  private AccountType accountType;

  public Account(float principal, float rate, int daysActive, AccountType accountType) {
    this.principal = principal;
    this.rate = rate;
    this.daysActive = daysActive;
    this.accountType = accountType;
  }

  public boolean isPremiumOrAbove() {
    return this.accountType == AccountType.PREMIUM || this.accountType == AccountType.PREMIUM_PLUS;
  }

  /** OBSERVE: TODO++  OOP-aware **/
  public float getFee() {
    if (isPremiumOrAbove()) {
      final float constantFee = 0.0125f;
      /** OBSERVE: TODO-- potentially dangerous cast **/
      float compoundedPrincipal = principal * (float) Math.exp(rate * (daysActive/365.25));
      return constantFee * (compoundedPrincipal - principal);
    }
    return 0;
  }
}