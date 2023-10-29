package com.mycompany.prompt3.gpt40;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.mycompany.prompt3.gpt40.review3.Account;
import com.mycompany.prompt3.gpt40.review3.AccountType;
import com.mycompany.prompt3.gpt40.review3.AccountHelper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class Prompt3Gpt40Review3Test {
  @ParameterizedTest
  @MethodSource("com.mycompany.original.OriginalTest#happyPathArguments")
  public void testHappyPath(float principal1, float rate1, int days1, float principal2, float rate2, int days2, float principal3, float rate3, int days3, float expectedResult){
    AccountHelper accountHelper = new AccountHelper();
    Account[] accounts = new Account[] {
        new Account(principal1, rate1, days1, AccountType.PREMIUM),
        new Account(principal2, rate2, days2, AccountType.PREMIUM_PLUS),
        new Account(principal3, rate3, days3, AccountType.BUDGET),
    };
    assertEquals(expectedResult, accountHelper.calculateTotalFee(accounts));
  }

  @Test
  public void testNoAccounts(){
    AccountHelper accountHelper = new AccountHelper();
    Account[] accounts = new Account[] {
    };
    assertEquals(0.0, accountHelper.calculateTotalFee(accounts));
  }

  @Test
  public void testDaysActiveZero(){
    AccountHelper accountHelper = new AccountHelper();
    Account[] accounts = new Account[] {
        new Account(4.5, 0.5, 0, AccountType.PREMIUM),
    };
    assertEquals(0.0, accountHelper.calculateTotalFee(accounts));
  }

}
