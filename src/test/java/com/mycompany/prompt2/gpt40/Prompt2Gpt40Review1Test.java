package com.mycompany.prompt2.gpt40;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.mycompany.prompt2.gpt40.review1.Account;
import com.mycompany.prompt2.gpt40.review1.FeeCalculator;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class Prompt2Gpt40Review1Test {
  @ParameterizedTest
  @MethodSource("com.mycompany.original.OriginalTest#happyPathArguments")
  public void testHappyPath(float principal1, float rate1, int days1, float principal2, float rate2, int days2, float principal3, float rate3, int days3, float expectedResult){
    FeeCalculator accountHelper = new FeeCalculator();
    Account[] accounts = new Account[] {
        new Account(BigDecimal.valueOf(principal1), BigDecimal.valueOf(rate1), days1, Account.AccountType.PREMIUM),
        new Account(BigDecimal.valueOf(principal2), BigDecimal.valueOf(rate2), days2, Account.AccountType.PREMIUM_PLUS),
        new Account(BigDecimal.valueOf(principal3), BigDecimal.valueOf(rate3), days3, Account.AccountType.BUDGET),
    };
    assertEquals(expectedResult, accountHelper.calculateFee(accounts));
  }

  @Test
  public void testNoAccounts(){
    FeeCalculator accountHelper = new FeeCalculator();
    Account[] accounts = new Account[] {
    };
    // MOVED FROM 0.0 TO 0
    assertEquals(new BigDecimal("0"), accountHelper.calculateFee(accounts));
  }

  @Test
  public void testDaysActiveZero(){
    FeeCalculator accountHelper = new FeeCalculator();
    Account[] accounts = new Account[] {
        new Account(new BigDecimal("4.5"), new BigDecimal("0.5"), 0, Account.AccountType.PREMIUM),
    };
    // MOVED FROM 0.0 TO 0.00
    assertEquals(new BigDecimal("0.00"), accountHelper.calculateFee(accounts));
  }

}
