package com.mycompany.prompt3.gpt40;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.mycompany.original.OriginalTest;
import com.mycompany.prompt3.gpt40.review1.Account;
import com.mycompany.prompt3.gpt40.review1.AccountHelper;
import org.junit.jupiter.api.Test;

public class Prompt3Gpt40Review1Test {
  @Test
  public void TestHappyPath(){
    AccountHelper accountHelper = new AccountHelper();
    Account[] accounts = new Account[] {
        new Account(OriginalTest.ACC_ONE_PRINCIPAL, OriginalTest.ACC_ONE_RATE, OriginalTest.ACC_ONE_DAYS, Account.AccountType.PREMIUM),
        new Account(OriginalTest.ACC_TWO_PRINCIPAL, OriginalTest.ACC_TWO_RATE, OriginalTest.ACC_TWO_DAYS, Account.AccountType.PREMIUM_PLUS),
        new Account(OriginalTest.ACC_THREE_PRINCIPAL, OriginalTest.ACC_THREE_RATE, OriginalTest.ACC_THREE_DAYS, Account.AccountType.BUDGET),
        new Account(OriginalTest.ACC_FOUR_PRINCIPAL, OriginalTest.ACC_FOUR_RATE, OriginalTest.ACC_FOUR_DAYS, Account.AccountType.STANDARD),
    };
    assertEquals(OriginalTest.EXPECTED_HAPPY_PATH_RESULT, accountHelper.calculateTotalFee(accounts));
  }

  @Test
  public void TestNoAccounts(){
    AccountHelper accountHelper = new AccountHelper();
    Account[] accounts = new Account[] {
    };
    assertEquals(0.0F, accountHelper.calculateTotalFee(accounts));
  }

  @Test
  public void TestDaysActiveZero(){
    AccountHelper accountHelper = new AccountHelper();
    Account[] accounts = new Account[] {
        new Account(4.5F, 0.5F, 0, Account.AccountType.PREMIUM),
    };
    assertEquals(0.0F, accountHelper.calculateTotalFee(accounts));
  }

}
