package com.mycompany.prompt2.gpt35.review3;

import com.mycompany.prompt1.gpt35.review3.Account.AccountType;
import java.math.BigDecimal;

public class Account {
  
  /** ADDED **/
  public Account(BigDecimal balance, BigDecimal interestRate, int daysSinceActive, int type) {
    this.balance = balance;
    this.interestRate = interestRate;
    this.daysSinceActive = daysSinceActive;
    this.type = type;
  }
  BigDecimal balance;
  BigDecimal interestRate;
  int daysSinceActive;
  int type;

  public static final int STANDARD = 0;
  public static final int BUDGET = 1;
  public static final int PREMIUM = 2;
  public static final int PREMIUM_PLUS = 3;
}