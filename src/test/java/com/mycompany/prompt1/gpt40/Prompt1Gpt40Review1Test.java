package com.mycompany.prompt1.gpt40;

import static junit.framework.TestCase.assertEquals;

import com.mycompany.prompt1.gpt40.review1.Account;
import com.mycompany.prompt1.gpt40.review1.AccountUtility;
import com.mycompany.prompt1.gpt40.review1.AccountType;
import org.junit.Test;

public class Prompt1Gpt40Review1Test {
  @Test
  public void TestHappyPath(){
    AccountUtility accountHelper = new AccountUtility();
    Account[] accounts = new Account[] {
        new Account(4.5F, 0.5F, 17, AccountType.PREMIUM),
        new Account(3.66F, 0.5F, 17, AccountType.PREMIUM_PLUS),
        new Account(1F, 0.2F, 44, AccountType.BUDGET),
        new Account(1F, 0.2F, 8, AccountType.STANDARD),
    };
    assertEquals(0.0024015524F, accountHelper.calculateFee(accounts));
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
