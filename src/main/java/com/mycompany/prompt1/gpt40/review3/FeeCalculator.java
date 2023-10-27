package com.mycompany.prompt1.gpt40.review3;

public class FeeCalculator {
  public static float calculateFee(Account[] accounts) {
    if (accounts == null) {
      return 0;
    }

    float totalFee = 0;
    for (Account account : accounts) {
      totalFee += account.getFee();
    }
    return totalFee;
  }
}