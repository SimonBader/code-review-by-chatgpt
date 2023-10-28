package com.mycompany.prompt1.gpt35.review2;


class AccountFeeCalculator {
  private static final double DAYS_IN_YEAR = 365.25;
  private static final double FEE_RATE = 0.0125;

  static float calculateFee(Account[] accounts) {
    float totalFee = 0;
    for (Account account : accounts) {
      if (isPremiumAccount(account)) {
        totalFee += calculatePremiumFee(account);
      }
    }
    return totalFee;
  }

  private static boolean isPremiumAccount(Account account) {
    return account.accountType == Account.PREMIUM || account.accountType == Account.PREMIUM_PLUS;
  }

  private static float calculatePremiumFee(Account account) {
    double daysFraction = account.daysActive / DAYS_IN_YEAR;
    double interest = account.principal * Math.exp(account.rate * daysFraction) - account.principal;
    /** OBSERVE: TODO-- potentially dangerous cast **/
    return (float) (FEE_RATE * interest);
  }
}
