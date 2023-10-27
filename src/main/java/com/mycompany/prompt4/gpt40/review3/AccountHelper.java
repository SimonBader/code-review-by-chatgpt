package com.mycompany.prompt4.gpt40.review3;

import java.util.List;

public class AccountHelper {
  public float calculateTotalFee(List<Account> accounts) {
    final float FEE_MULTIPLIER = 0.0125f;
    final float DAYS_IN_YEAR = 365.25f;

    float totalFee = 0;

    for (Account account : accounts) {
      if (account.getAccountType() == Account.AccountType.PREMIUM ||
          account.getAccountType() == Account.AccountType.PREMIUM_PLUS) {
        totalFee += FEE_MULTIPLIER * (account.getPrincipal() *
            Math.exp(account.getRate() * (account.getDaysActive() / DAYS_IN_YEAR)) -
            account.getPrincipal());
      }
    }

    return totalFee;
  }
}