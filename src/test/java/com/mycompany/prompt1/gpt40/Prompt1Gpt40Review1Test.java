package com.mycompany.prompt1.gpt40;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.mycompany.prompt1.gpt40.review1.Account;
import com.mycompany.prompt1.gpt40.review1.AccountUtility;
import com.mycompany.prompt1.gpt40.review1.AccountType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class Prompt1Gpt40Review1Test {
  @ParameterizedTest
  @MethodSource("com.mycompany.original.OriginalTest#happyPathArguments")
  public void testHappyPath(float principal1, float rate1, int days1, float principal2, float rate2, int days2, float principal3, float rate3, int days3, float expectedResult){
    AccountUtility accountHelper = new AccountUtility();
    Account[] accounts = new Account[] {
        new Account(principal1, rate1, days1, AccountType.PREMIUM),
        new Account(principal2, rate2, days2, AccountType.PREMIUM_PLUS),
        new Account(principal3, rate3, days3, AccountType.BUDGET),
    };
    assertEquals(expectedResult, accountHelper.calculateFee(accounts));
  }

  @Test
  public void testNoAccounts(){
    AccountUtility accountHelper = new AccountUtility();
    Account[] accounts = new Account[] {
    };
    assertEquals(0.0F, accountHelper.calculateFee(accounts));
  }

  @Test
  public void testDaysActiveZero(){
    AccountUtility accountHelper = new AccountUtility();
    Account[] accounts = new Account[] {
        new Account(4.5F, 0.5F, 0, AccountType.PREMIUM),
    };
    assertEquals(0.0F, accountHelper.calculateFee(accounts));
  }

}
