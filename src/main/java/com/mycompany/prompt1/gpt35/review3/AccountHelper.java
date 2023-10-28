package com.mycompany.prompt1.gpt35.review3;

import java.math.BigDecimal;

public class AccountHelper {
  public BigDecimal calculateFee(Account[] accounts) {
    BigDecimal totalFees = BigDecimal.ZERO;
    for (Account account : accounts) {
      if (account.getAccountType() == Account.AccountType.PREMIUM ||
          account.getAccountType() == Account.AccountType.PREMIUM_PLUS) {
        /** OBSERVE: TODO--  throws exception during runtime **/
        /** OBSERVE: TODO--  missing constant 0.125 **/
        /** OBSERVE: TODO--  .subtract(BigDecimal.ONE) instead of subtracting account.principal **/
        BigDecimal yearFraction = BigDecimal.valueOf(account.getDaysActive()).divide(BigDecimal.valueOf(365.25));
        BigDecimal fee = account.getPrincipal().multiply(
            BigDecimal.valueOf(Math.exp(account.getRate().doubleValue() * yearFraction.doubleValue()))
                .subtract(BigDecimal.ONE)
        );
        totalFees = totalFees.add(fee);
      }
    }
    return totalFees;
  }
}
