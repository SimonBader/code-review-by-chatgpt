package com.mycompany.prompt4.gpt35.review1;

public class AccountHelper {
  public float calculateFee(Account accounts[]) {
    float totalFee = 0;
    Account account;
    for (int i = 0; i < accounts.length; i++) {
      account = accounts[i];
      if (account.accountType == Account.PREMIUM || account.accountType == Account.PREMIUM_PLUS) {
        // Calculate fee for premium accounts
        /** ADDED TODO-- code does not compile (quick-fixed)
        float fee = .0125f * (account.principal * Math.exp(account.rate * (account.daysActive / 365.25f)) - account.principal); **/
        float fee = (float) (.0125f * (account.principal * Math.exp(account.rate * (account.daysActive / 365.25f)) - account.principal));
        /** ADDED **/
        totalFee += fee;
      }
    }
    return totalFee;
  }
}
