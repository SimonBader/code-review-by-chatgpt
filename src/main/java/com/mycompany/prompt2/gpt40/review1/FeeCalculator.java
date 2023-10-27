package com.mycompany.prompt2.gpt40.review1;

import java.math.BigDecimal;
import java.math.MathContext;

public class FeeCalculator {
  private static final BigDecimal FEE_RATE = new BigDecimal("0.0125");
  private static final BigDecimal DAYS_IN_YEAR = new BigDecimal("365.25");

  public static BigDecimal calculateFee(Account[] accounts) {
    BigDecimal totalFee = BigDecimal.ZERO;
    for (Account account : accounts) {
      if (account.getAccountType() == Account.AccountType.PREMIUM ||
          account.getAccountType() == Account.AccountType.PREMIUM_PLUS) {

        BigDecimal growthFactor = account.getRate().multiply(new BigDecimal(account.getDaysActive())).divide(DAYS_IN_YEAR, MathContext.DECIMAL64);
        /** ADDED TODO: code does not compile
        BigDecimal accruedAmount = account.getPrincipal().multiply(growthFactor.exp(MathContext.DECIMAL64)); **/
        BigDecimal accruedAmount = new BigDecimal("0");
        if (true) throw new RuntimeException("code does not compile");
        /** ADDED **/

        BigDecimal fee = accruedAmount.subtract(account.getPrincipal()).multiply(FEE_RATE);
        totalFee = totalFee.add(fee);
      }
    }
    return totalFee;
  }
}