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

public class Prompt4Gpt40Review3Test {
  @Test
  public void TestHappyPath() {
    AccountHelper accountHelper = new AccountHelper();
    List<Account> accounts = Arrays.asList(
        new Account(OriginalTest.ACC_ONE_PRINCIPAL, OriginalTest.ACC_ONE_RATE, OriginalTest.ACC_ONE_DAYS, Account.AccountType.PREMIUM),
        new Account(OriginalTest.ACC_TWO_PRINCIPAL, OriginalTest.ACC_TWO_RATE, OriginalTest.ACC_TWO_DAYS, Account.AccountType.PREMIUM_PLUS),
        new Account(OriginalTest.ACC_THREE_PRINCIPAL, OriginalTest.ACC_THREE_RATE, OriginalTest.ACC_THREE_DAYS, Account.AccountType.BUDGET),
        new Account(OriginalTest.ACC_FOUR_PRINCIPAL, OriginalTest.ACC_FOUR_RATE, OriginalTest.ACC_FOUR_DAYS, Account.AccountType.STANDARD)
    );
    assertEquals(OriginalTest.EXPECTED_HAPPY_PATH_RESULT, accountHelper.calculateTotalFee(accounts));
  }

  @Test
  public void TestNoAccounts() {
    AccountHelper accountHelper = new AccountHelper();
    List<Account> accounts = Collections.emptyList();
    assertEquals(0.0F, accountHelper.calculateTotalFee(accounts));
  }

  @Test
  public void TestDaysActiveZero() {
    AccountHelper accountHelper = new AccountHelper();
    List<Account> accounts = Collections.singletonList(
        new Account(4.5F, 0.5F, 0, AccountType.PREMIUM)
    );
    assertEquals(0.0F, accountHelper.calculateTotalFee(accounts));
  }

}
