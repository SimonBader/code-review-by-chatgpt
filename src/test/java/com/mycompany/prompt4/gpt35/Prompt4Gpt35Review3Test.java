package com.mycompany.prompt4.gpt35;

import static junit.framework.TestCase.assertEquals;

import com.mycompany.original.OriginalTest;
import com.mycompany.prompt4.gpt35.review3.Account;
import com.mycompany.prompt4.gpt35.review3.AccountHelper;
import org.junit.Test;

public class Prompt4Gpt35Review3Test {
  @Test
  public void TestHappyPath(){
    AccountHelper accountHelper = new AccountHelper();
    Account[] accounts = new Account[] {
        new Account(OriginalTest.ACC_ONE_PRINCIPAL, OriginalTest.ACC_ONE_RATE, OriginalTest.ACC_ONE_DAYS, Account.AccountType.PREMIUM),
        new Account(OriginalTest.ACC_TWO_PRINCIPAL, OriginalTest.ACC_TWO_RATE, OriginalTest.ACC_TWO_DAYS, Account.AccountType.PREMIUM_PLUS),
        new Account(OriginalTest.ACC_THREE_PRINCIPAL, OriginalTest.ACC_THREE_RATE, OriginalTest.ACC_THREE_DAYS, Account.AccountType.BUDGET),
        new Account(OriginalTest.ACC_FOUR_PRINCIPAL, OriginalTest.ACC_FOUR_RATE, OriginalTest.ACC_FOUR_DAYS, Account.AccountType.STANDARD),
    };
    assertEquals(OriginalTest.EXPECTED_HAPPY_PATH_RESULT, accountHelper.calculateFee(accounts));
  }

  @Test
  public void TestNoAccounts(){
    AccountHelper accountHelper = new AccountHelper();
    Account[] accounts = new Account[] {
    };
    assertEquals(0.0F, accountHelper.calculateFee(accounts));
  }

  @Test
  public void TestDaysActiveZero(){
    AccountHelper accountHelper = new AccountHelper();
    Account[] accounts = new Account[] {
        new Account(4.5F, 0.5F, 0, Account.AccountType.PREMIUM),
    };
    assertEquals(0.0F, accountHelper.calculateFee(accounts));
  }

}
