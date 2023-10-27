package com.mycompany.prompt4.gpt40;

import static junit.framework.TestCase.assertEquals;

import com.mycompany.prompt4.gpt40.review3.Account;
import com.mycompany.prompt4.gpt40.review3.Account.AccountType;
import com.mycompany.prompt4.gpt40.review3.AccountHelper;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Test;

public class Prompt4Gpt40Review3Test {
  @Test
  public void TestHappyPath() {
    AccountHelper accountHelper = new AccountHelper();
    List<Account> accounts = Arrays.asList(
        new Account(4.5F, 0.5F, 17, Account.AccountType.PREMIUM),
        new Account(3.66F, 0.5F, 17, Account.AccountType.PREMIUM_PLUS),
        new Account(1F, 0.2F, 44, Account.AccountType.BUDGET),
        new Account(1F, 0.2F, 8, Account.AccountType.STANDARD)
    );
    assertEquals(0.0024015524F, accountHelper.calculateTotalFee(accounts));
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
