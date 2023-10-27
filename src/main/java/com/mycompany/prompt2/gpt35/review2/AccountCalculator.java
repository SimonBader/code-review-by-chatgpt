package com.mycompany.prompt2.gpt35.review2;

public class AccountCalculator {
  private static final double FEE_RATE = 0.0125;

  public static float calculateFee(Account[] accounts) {
    float totalFee = 0;
    for (Account account : accounts) {
      if (account.getAccountType() == Account.PREMIUM || account.getAccountType() == Account.PREMIUM_PLUS) {
        totalFee += calculatePremiumFee(account);
      }
    }
    return totalFee;
  }

  private static float calculatePremiumFee(Account account) {
    float principal = account.getPrincipal();
    float rate = account.getRate();
    int daysActive = account.getDaysActive();

    double expValue = Math.exp(rate * (daysActive / 365.25));
    float fee = (float) (FEE_RATE * (principal * (expValue - 1)));
    return fee;
  }
}