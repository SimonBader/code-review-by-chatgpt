package com.mycompany.prompt2.gpt40;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.mycompany.original.OriginalTest;
import com.mycompany.prompt2.gpt40.review3.Account;
import com.mycompany.prompt2.gpt40.review3.FeeCalculator;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

public class Prompt2Gpt40Review3Test {
  @Test
  public void TestHappyPath(){
    FeeCalculator accountHelper = new FeeCalculator();
    Account[] accounts = new Account[] {
        new Account(new BigDecimal("4.5"), new BigDecimal("0.5"), 17, Account.AccountType.PREMIUM),
        new Account(new BigDecimal("3.66"), new BigDecimal("0.5"), 17, Account.AccountType.PREMIUM_PLUS),
        new Account(new BigDecimal("1"), new BigDecimal("0.2"), 44, Account.AccountType.BUDGET),
        new Account(new BigDecimal("1"), new BigDecimal("0.2"), 8, Account.AccountType.STANDARD),
    };
    assertEquals(OriginalTest.EXPECTED_HAPPY_PATH_RESULT, accountHelper.calculateFee(accounts));
  }

  @Test
  public void TestNoAccounts(){
    FeeCalculator accountHelper = new FeeCalculator();
    Account[] accounts = new Account[] {
    };
    // MOVED FROM 0.0 TO 0
    assertEquals(new BigDecimal("0"), accountHelper.calculateFee(accounts));
  }

  @Test
  public void TestDaysActiveZero(){
    FeeCalculator accountHelper = new FeeCalculator();
    Account[] accounts = new Account[] {
        new Account(new BigDecimal("4.5"), new BigDecimal("0.5"), 0, Account.AccountType.PREMIUM),
    };
    // MOVED FROM 0.0 TO 0.00
    assertEquals(new BigDecimal("0.00"), accountHelper.calculateFee(accounts));
  }

}
