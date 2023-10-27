package com.mycompany.prompt1.gpt35.review2;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class Prompt1Gpt35Review2Test {
  @Test
  public void TestHappyPath(){
    AccountFeeCalculator accountHelper = new AccountFeeCalculator();
    Account[] accounts = new Account[] {
        new Account(4.5F, 0.5F, 17, Account.PREMIUM),
        new Account(3.66F, 0.5F, 17, Account.PREMIUM_PLUS),
        new Account(1F, 0.2F, 44, Account.BUDGET),
        new Account(1F, 0.2F, 8, Account.STANDARD),
    };
    assertEquals(0.0024015524F, accountHelper.calculateFee(accounts));
  }

  @Test
  public void TestNoAccounts(){
    AccountFeeCalculator accountHelper = new AccountFeeCalculator();
    Account[] accounts = new Account[] {
    };
    assertEquals(0.0F, accountHelper.calculateFee(accounts));
  }

  @Test
  public void TestDaysActiveZero(){
    AccountFeeCalculator accountHelper = new AccountFeeCalculator();
    Account[] accounts = new Account[] {
        new Account(4.5F, 0.5F, 0, Account.PREMIUM),
    };
    assertEquals(0.0F, accountHelper.calculateFee(accounts));
  }

}
