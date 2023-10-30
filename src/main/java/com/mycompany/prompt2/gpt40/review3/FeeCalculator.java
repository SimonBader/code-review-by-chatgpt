package com.mycompany.prompt2.gpt40.review3;

import java.math.BigDecimal;
import java.math.MathContext;

public class FeeCalculator {

  public static BigDecimal calculateFee(Account[] accounts) {
    BigDecimal totalFee = BigDecimal.ZERO;
    for (Account account : accounts) {
      if (account.getAccountType() == Account.AccountType.PREMIUM ||
          account.getAccountType() == Account.AccountType.PREMIUM_PLUS) {
        BigDecimal interest = account.getPrincipal()
            .multiply(
                (BigDecimal.ONE.add(account.getRate())
                    /** OBSERVE: TODO-- replace `Math.exp(rate * n)` with `(1 + rate).pow(n)` is wrong
                    /** ADDED TODO-- code does not compile (quick-fixed)
                    .pow(account.getDaysActive() / Account.YEAR_DAYS.doubleValue(), new MathContext(4))) **/
                    .pow((int) (account.getDaysActive() / Account.YEAR_DAYS.doubleValue()), new MathContext(4)))
                    /** ADDED **/
            ).subtract(account.getPrincipal());

        totalFee = totalFee.add(interest.multiply(Account.FEE_RATE));
      }
    }
    return totalFee;
  }
}