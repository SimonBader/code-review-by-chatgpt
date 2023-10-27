package com.mycompany.prompt4.gpt35.review3;

public class AccountHelper {
  public float calculateFee(Account[] accounts) {
    if (accounts == null) {
      throw new IllegalArgumentException("accounts cannot be null");
    }

    float totalFee = 0;
    for (Account account : accounts) {
      if (account.accountType == Account.AccountType.PREMIUM ||
          account.accountType == Account.AccountType.PREMIUM_PLUS) {
        double daysInYears = account.daysActive / Account.DAYS_IN_YEAR;
        double exponent = account.rate * daysInYears;
        double fee = 0.0125 * (account.principal * Math.exp(exponent) - account.principal);
        totalFee += (float) fee;
      }
    }
    return totalFee;
  }
}