package com.mycompany.prompt1.gpt40;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.mycompany.original.OriginalTest;
import com.mycompany.prompt1.gpt40.review1.Account;
import com.mycompany.prompt1.gpt40.review1.AccountUtility;
import com.mycompany.prompt1.gpt40.review1.AccountType;
import org.junit.jupiter.api.Test;

public class Prompt1Gpt40Review1Test {
  @Test
  public void TestHappyPath(){
    AccountUtility accountHelper = new AccountUtility();
    Account[] accounts = new Account[] {
        new Account(OriginalTest.ACC_ONE_PRINCIPAL, OriginalTest.ACC_ONE_RATE, OriginalTest.ACC_ONE_DAYS, AccountType.PREMIUM),
        new Account(OriginalTest.ACC_TWO_PRINCIPAL, OriginalTest.ACC_TWO_RATE, OriginalTest.ACC_TWO_DAYS, AccountType.PREMIUM_PLUS),
        new Account(OriginalTest.ACC_THREE_PRINCIPAL, OriginalTest.ACC_THREE_RATE, OriginalTest.ACC_THREE_DAYS, AccountType.BUDGET),
        new Account(OriginalTest.ACC_FOUR_PRINCIPAL, OriginalTest.ACC_FOUR_RATE, OriginalTest.ACC_FOUR_DAYS, AccountType.STANDARD),
    };
    assertEquals(OriginalTest.EXPECTED_HAPPY_PATH_RESULT, accountHelper.calculateFee(accounts));
  }

  @Test
  public void TestNoAccounts(){
    AccountUtility accountHelper = new AccountUtility();
    Account[] accounts = new Account[] {
    };
    assertEquals(0.0F, accountHelper.calculateFee(accounts));
  }

  @Test
  public void TestDaysActiveZero(){
    AccountUtility accountHelper = new AccountUtility();
    Account[] accounts = new Account[] {
        new Account(4.5F, 0.5F, 0, AccountType.PREMIUM),
    };
    assertEquals(0.0F, accountHelper.calculateFee(accounts));
  }

}
