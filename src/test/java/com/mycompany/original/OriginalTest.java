package com.mycompany.original;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class OriginalTest {

  public static Stream<Arguments> happyPathArguments() {
    return Stream.of(
        // principal1, rate1, days1, principal2, rate2, days2, principal3, rate3, days3, expectedResult
        Arguments.of(4.5F, 0.5F, 17, 3.66F, 0.5F, 17, 1F, 0.2F, 44, 0.0024015524F),
        Arguments.of(4.5564F, 21.556F, 147, 354.66F, 100.5F, 317, 1F, 0.2F, 44, 3.3693461E38F)
        /** OBSERVE: TODO expectedResult too large for a float
        Arguments.of(4.5564F, 21.556F, 147, 364.66F, 100.5F, 317, 1F, 0.2F, 44, 0F)  **/
    );
  }

  @ParameterizedTest
  @MethodSource("com.mycompany.original.OriginalTest#happyPathArguments")
  public void TestHappyPath(float principal1, float rate1, int days1, float principal2, float rate2, int days2, float principal3, float rate3, int days3, float expectedResult){
    AccountHelper accountHelper = new AccountHelper();
    Account[] accounts = new Account[] {
        new Account(principal1, rate1, days1, Account.PREMIUM),
        new Account(principal2, rate2, days2, Account.PREMIUM_PLUS),
        new Account(principal3, rate3, days3, Account.BUDGET),
    };
    assertEquals(expectedResult, accountHelper.calculateFee(accounts));
  }

  @Test
  public void testNoAccounts() {
    AccountHelper accountHelper = new AccountHelper();
    Account[] accounts = new Account[]{
    };
    assertEquals(0.0F, accountHelper.calculateFee(accounts));
  }

  @Test
  public void testDaysActiveZero() {
    AccountHelper accountHelper = new AccountHelper();
    Account[] accounts = new Account[]{
        new Account(4.5F, 0.5F, 0, Account.PREMIUM),
    };
    assertEquals(0.0F, accountHelper.calculateFee(accounts));
  }

}
