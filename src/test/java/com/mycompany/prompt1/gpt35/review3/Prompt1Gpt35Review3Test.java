package com.mycompany.prompt1.gpt35.review3;

import static junit.framework.TestCase.assertEquals;

import com.mycompany.original.OriginalTest;
import com.mycompany.prompt1.gpt35.review3.Account.AccountType;
import java.math.BigDecimal;
import org.junit.Test;

public class Prompt1Gpt35Review3Test {
  @Test
  public void TestHappyPath(){
    AccountHelper accountHelper = new AccountHelper();
    Account[] accounts = new Account[] {
        new Account(new BigDecimal("4.5"), new BigDecimal("0.5"), 17, AccountType.PREMIUM),
        new Account(new BigDecimal("3.66"), new BigDecimal("0.5"), 17, AccountType.PREMIUM_PLUS),
        new Account(new BigDecimal("1"), new BigDecimal("0.2"), 44, AccountType.BUDGET),
        new Account(new BigDecimal("1"), new BigDecimal("0.2"), 8, AccountType.STANDARD),
    };
    assertEquals(OriginalTest.EXPECTED_HAPPY_PATH_RESULT, accountHelper.calculateFee(accounts));
  }

  @Test
  public void TestNoAccounts(){
    AccountHelper accountHelper = new AccountHelper();
    Account[] accounts = new Account[] {
    };
    // MOVED FROM 0.0 TO 0
    assertEquals(new BigDecimal("0"), accountHelper.calculateFee(accounts));
  }

  @Test
  public void TestDaysActiveZero(){
    AccountHelper accountHelper = new AccountHelper();
    Account[] accounts = new Account[] {
        new Account(new BigDecimal("4.5"), new BigDecimal("0.5"), 0, AccountType.PREMIUM),
    };
    // MOVED FROM 0.0 TO 0.00
    assertEquals(new BigDecimal("0.00"), accountHelper.calculateFee(accounts));
  }

}
