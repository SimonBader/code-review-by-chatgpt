package com.mycompany.prompt1.gpt35.review1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.mycompany.original.OriginalTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class Prompt1Gpt35Review1Test {
  @ParameterizedTest
  @MethodSource("com.mycompany.original.OriginalTest#happyPathArguments")
  public void testHappyPath(float principal1, float rate1, int days1, float principal2, float rate2, int days2, float principal3, float rate3, int days3, float expectedResult){
    AccountHelper accountHelper = new AccountHelper();
    Account[] accounts = new Account[] {
        new Account(principal1, rate1, days1, Account.PREMIUM),
        new Account(principal2, rate2, days2, Account.PREMIUM_PLUS),
        new Account(principal3, rate3, days3, Account.BUDGET),
    };
    assertEquals(expectedResult, accountHelper.calculateFee(accounts));
  }

  @Test
  public void testNoAccounts(){
    AccountHelper accountHelper = new AccountHelper();
    Account[] accounts = new Account[] {
    };
    assertEquals(OriginalTest.ZERO, accountHelper.calculateFee(accounts));
  }

  @Test
  public void testDaysActiveZero(){
    AccountHelper accountHelper = new AccountHelper();
    Account[] accounts = new Account[] {
        new Account(4.5F, 0.5F, 0, Account.PREMIUM),
    };
    assertEquals(OriginalTest.ZERO, accountHelper.calculateFee(accounts));
  }

}
