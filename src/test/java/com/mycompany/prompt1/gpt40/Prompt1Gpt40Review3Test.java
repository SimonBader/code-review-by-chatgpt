package com.mycompany.prompt1.gpt40;

import static junit.framework.TestCase.assertEquals;

import com.mycompany.prompt1.gpt40.review3.FeeCalculator;
import com.mycompany.prompt1.gpt40.review3.AccountType;
import com.mycompany.prompt1.gpt40.review3.Account;
import org.junit.Test;

public class Prompt1Gpt40Review3Test {
  @Test
  public void TestHappyPath(){
    FeeCalculator accountHelper = new FeeCalculator();
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
    FeeCalculator accountHelper = new FeeCalculator();
    Account[] accounts = new Account[] {
    };
    assertEquals(0.0F, accountHelper.calculateFee(accounts));
  }

  @Test
  public void TestDaysActiveZero(){
    FeeCalculator accountHelper = new FeeCalculator();
    Account[] accounts = new Account[] {
        new Account(4.5F, 0.5F, 0, AccountType.PREMIUM),
    };
    assertEquals(0.0F, accountHelper.calculateFee(accounts));
  }

}
