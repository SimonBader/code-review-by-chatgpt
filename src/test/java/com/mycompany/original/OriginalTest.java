package com.mycompany.original;

import static junit.framework.TestCase.assertEquals;

import com.mycompany.original.Account;
import com.mycompany.original.AccountHelper;
import org.junit.Test;

public class OriginalTest {
  public static final float EXPECTED_HAPPY_PATH_RESULT = 0.0024015524F;
  public static final float ACC_ONE_PRINCIPAL = 4.5F;
  public static final float ACC_ONE_RATE = 0.5F;
  public static final int ACC_ONE_DAYS = 17;
  public static final float ACC_TWO_PRINCIPAL = 3.66F;
  public static final float ACC_TWO_RATE = 0.5F;
  public static final int ACC_TWO_DAYS = 17;
  public static final float ACC_THREE_PRINCIPAL = 1F;
  public static final float ACC_THREE_RATE = 0.2F;
  public static final int ACC_THREE_DAYS = 44;
  public static final float ACC_FOUR_PRINCIPAL = 1F;
  public static final float ACC_FOUR_RATE = 0.2F;
  public static final int ACC_FOUR_DAYS = 8;
  @Test
  public void TestHappyPath(){
    AccountHelper accountHelper = new AccountHelper();
    Account[] accounts = new Account[] {
        new Account(ACC_ONE_PRINCIPAL, ACC_ONE_RATE, ACC_ONE_DAYS, Account.PREMIUM),
        new Account(ACC_TWO_PRINCIPAL, ACC_TWO_RATE, ACC_TWO_DAYS, Account.PREMIUM_PLUS),
        new Account(ACC_THREE_PRINCIPAL, ACC_THREE_RATE, ACC_THREE_DAYS, Account.BUDGET),
        new Account(ACC_FOUR_PRINCIPAL, ACC_FOUR_RATE, ACC_FOUR_DAYS, Account.STANDARD),
    };
    assertEquals(EXPECTED_HAPPY_PATH_RESULT, accountHelper.calculateFee(accounts));
  }

  @Test
  public void TestNoAccounts(){
    AccountHelper accountHelper = new AccountHelper();
    Account[] accounts = new Account[] {
    };
    assertEquals(0.0F, accountHelper.calculateFee(accounts));
  }

  @Test
  public void TestDaysActiveZero(){
    AccountHelper accountHelper = new AccountHelper();
    Account[] accounts = new Account[] {
        new Account(4.5F, 0.5F, 0, Account.PREMIUM),
    };
    assertEquals(0.0F, accountHelper.calculateFee(accounts));
  }

}
