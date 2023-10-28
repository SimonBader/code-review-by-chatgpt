package com.mycompany.prompt1.gpt40.review1;

public class AccountUtility {

  private static final float FEE_RATE = 0.0125f;
  private static final float DAYS_IN_YEAR = 365.25f;

  /** OBSERVE: TODO--  code unchanged (beside enhanced-for-loop & magic numbers & getters) **/
  public static float calculateFee(Account[] accounts) {
    float totalFee = 0;
    for (Account account : accounts) {
      if (account.getAccountType() == AccountType.PREMIUM || account.getAccountType() == AccountType.PREMIUM_PLUS) {
        totalFee += FEE_RATE * (account.getPrincipal() * Math.exp(account.getRate() * (account.getDaysActive() / DAYS_IN_YEAR)) - account.getPrincipal());
      }
    }
    return totalFee;
  }
}
