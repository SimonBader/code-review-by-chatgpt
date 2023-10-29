package com.mycompany.prompt2.gpt35;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.mycompany.original.OriginalTest;
import com.mycompany.prompt2.gpt35.review3.Account;
import com.mycompany.prompt2.gpt35.review3.AccountHelper;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class Prompt2Gpt35Review3Test {
  @ParameterizedTest
  @MethodSource("com.mycompany.original.OriginalTest#happyPathArguments")
  public void testHappyPath(float principal1, float rate1, int days1, float principal2, float rate2, int days2, float principal3, float rate3, int days3, float expectedResult){
    AccountHelper accountHelper = new AccountHelper();
    Account[] accounts = new Account[] {
        new Account(BigDecimal.valueOf(principal1), BigDecimal.valueOf(rate1), days1, Account.PREMIUM),
        new Account(BigDecimal.valueOf(principal2), BigDecimal.valueOf(rate2), days2, Account.PREMIUM_PLUS),
        new Account(BigDecimal.valueOf(principal3), BigDecimal.valueOf(rate3), days3, Account.BUDGET),
    };
    assertEquals(expectedResult, accountHelper.calculateFee(accounts));
  }

  @Test
  public void testNoAccounts(){
    AccountHelper accountHelper = new AccountHelper();
    Account[] accounts = new Account[] {
    };
    assertEquals(BigDecimal.valueOf(OriginalTest.ZERO), accountHelper.calculateFee(accounts));
  }

  @Test
  public void testDaysActiveZero(){
    AccountHelper accountHelper = new AccountHelper();
    Account[] accounts = new Account[] {
        new Account(new BigDecimal("4.5"), new BigDecimal("0.5"), 0, Account.PREMIUM),
    };
    assertEquals(BigDecimal.valueOf(OriginalTest.ZERO), accountHelper.calculateFee(accounts));
  }

}
