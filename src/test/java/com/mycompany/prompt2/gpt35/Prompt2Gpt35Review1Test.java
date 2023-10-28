package com.mycompany.prompt2.gpt35;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.mycompany.original.OriginalTest;
import com.mycompany.prompt2.gpt35.review1.Account;
import com.mycompany.prompt2.gpt35.review1.FeeCalculator;
import org.junit.jupiter.api.Test;

public class Prompt2Gpt35Review1Test {
  @Test
  public void TestHappyPath(){
    FeeCalculator accountHelper = new FeeCalculator();
    Account[] accounts = new Account[] {
        new Account(4.5, 0.5, 17, Account.PREMIUM),
        new Account(3.66, 0.5, 17, Account.PREMIUM_PLUS),
        new Account(1, 0.2, 44, Account.BUDGET),
        new Account(1, 0.2, 8, Account.STANDARD),
    };
    assertEquals(OriginalTest.EXPECTED_HAPPY_PATH_RESULT, accountHelper.calculateFee(accounts));
  }

  @Test
  public void TestNoAccounts(){
    FeeCalculator accountHelper = new FeeCalculator();
    Account[] accounts = new Account[] {
    };
    assertEquals(0.0, accountHelper.calculateFee(accounts));
  }

  @Test
  public void TestDaysActiveZero(){
    FeeCalculator accountHelper = new FeeCalculator();
    Account[] accounts = new Account[] {
        new Account(4.5, 0.5, 0, Account.PREMIUM),
    };
    assertEquals(0.0, accountHelper.calculateFee(accounts));
  }

}
