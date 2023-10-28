package com.mycompany.prompt1.gpt35.review1;

public class AccountHelper {
  /** OBSERVE: TODO--  code unchanged (beside enhanced-for-loop) **/
  public float calculateFee(Account accounts[]) {
    float totalFee = 0;
    Account account;
    for (int i = 0; i < accounts.length; i++) {
      account = accounts[i];
      if (account.accountType == Account.PREMIUM || account.accountType == Account.PREMIUM_PLUS) {
        // Calculate fee for premium accounts using a formula
        totalFee += 0.0125 * (account.principal * Math.exp(account.rate * (account.daysActive / 365.25)) - account.principal);
      }
    }
    return totalFee;
  }
}
