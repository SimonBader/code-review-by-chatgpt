package com.mycompany.prompt4.gpt40;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.mycompany.original.OriginalTest;
import com.mycompany.prompt4.gpt40.review3.Account;
import com.mycompany.prompt4.gpt40.review3.Account.AccountType;
import com.mycompany.prompt4.gpt40.review3.AccountHelper;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class Prompt4Gpt40Review3Test {
  @ParameterizedTest
  @MethodSource("com.mycompany.original.OriginalTest#happyPathArguments")
  public void testHappyPath(float principal1, float rate1, int days1, float principal2, float rate2, int days2, float principal3, float rate3, int days3, float expectedResult) {
    AccountHelper accountHelper = new AccountHelper();
    List<Account> accounts = Arrays.asList(
        new Account(principal1, rate1, days1, Account.AccountType.PREMIUM),
        new Account(principal2, rate2, days2, Account.AccountType.PREMIUM_PLUS),
        new Account(principal3, rate3, days3, Account.AccountType.BUDGET)
    );
    assertEquals(expectedResult, accountHelper.calculateTotalFee(accounts));
  }

  @Test
  public void testNoAccounts() {
    AccountHelper accountHelper = new AccountHelper();
    List<Account> accounts = Collections.emptyList();
    assertEquals(OriginalTest.ZERO, accountHelper.calculateTotalFee(accounts));
  }

  @Test
  public void testDaysActiveZero() {
    AccountHelper accountHelper = new AccountHelper();
    List<Account> accounts = Collections.singletonList(
        new Account(4.5F, 0.5F, 0, AccountType.PREMIUM)
    );
    assertEquals(OriginalTest.ZERO, accountHelper.calculateTotalFee(accounts));
  }

}
