package com.mycompany.prompt3.gpt40;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.mycompany.original.OriginalTest;
import com.mycompany.prompt3.gpt40.review3.Account;
import com.mycompany.prompt3.gpt40.review3.AccountType;
import com.mycompany.prompt3.gpt40.review3.AccountHelper;
import org.junit.jupiter.api.Test;

public class Prompt3Gpt40Review3Test {
  @Test
  public void TestHappyPath(){
    AccountHelper accountHelper = new AccountHelper();
    Account[] accounts = new Account[] {
        new Account(4.5, 0.5, 17, AccountType.PREMIUM),
        new Account(3.66, 0.5, 17, AccountType.PREMIUM_PLUS),
        new Account(1, 0.2, 44, AccountType.BUDGET),
        new Account(1, 0.2, 8, AccountType.STANDARD),
    };
    assertEquals(OriginalTest.EXPECTED_HAPPY_PATH_RESULT, accountHelper.calculateTotalFee(accounts));
  }

  @Test
  public void TestNoAccounts(){
    AccountHelper accountHelper = new AccountHelper();
    Account[] accounts = new Account[] {
    };
    assertEquals(0.0, accountHelper.calculateTotalFee(accounts));
  }

  @Test
  public void TestDaysActiveZero(){
    AccountHelper accountHelper = new AccountHelper();
    Account[] accounts = new Account[] {
        new Account(4.5, 0.5, 0, AccountType.PREMIUM),
    };
    assertEquals(0.0, accountHelper.calculateTotalFee(accounts));
  }

}
