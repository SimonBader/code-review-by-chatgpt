package com.mycompany.prompt3.gpt40;

import static junit.framework.TestCase.assertEquals;

import com.mycompany.prompt3.gpt40.review1.Account;
import com.mycompany.prompt3.gpt40.review1.AccountHelper;
import org.junit.Test;

public class Prompt3Gpt40Review1Test {
  @Test
  public void TestHappyPath(){
    AccountHelper accountHelper = new AccountHelper();
    Account[] accounts = new Account[] {
        new Account(4.5F, 0.5F, 17, Account.AccountType.PREMIUM),
        new Account(3.66F, 0.5F, 17, Account.AccountType.PREMIUM_PLUS),
        new Account(1F, 0.2F, 44, Account.AccountType.BUDGET),
        new Account(1F, 0.2F, 8, Account.AccountType.STANDARD),
    };
    assertEquals(0.0024015524F, accountHelper.calculateTotalFee(accounts));
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
