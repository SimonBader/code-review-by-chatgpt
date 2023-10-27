package com.mycompany.prompt3.gpt35;

import static junit.framework.TestCase.assertEquals;

import com.mycompany.prompt3.gpt35.review2.Account;
import com.mycompany.prompt3.gpt35.review2.AccountHelper;
import org.junit.Test;

public class Prompt3Gpt35Review2Test {
  @Test
  public void TestHappyPath(){
    AccountHelper accountHelper = new AccountHelper();
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
    AccountHelper accountHelper = new AccountHelper();
    Account[] accounts = new Account[] {
    };
    assertEquals(0.0F, accountHelper.calculateFee(accounts));
  }

  @Test
  public void TestDaysActiveZero(){
    AccountHelper accountHelper = new AccountHelper();
    Account[] accounts = new Account[] {
        new Account(4.5F, 0.5F, 0, Account.PREMIUM),
    };
    assertEquals(0.0F, accountHelper.calculateFee(accounts));
  }

}
