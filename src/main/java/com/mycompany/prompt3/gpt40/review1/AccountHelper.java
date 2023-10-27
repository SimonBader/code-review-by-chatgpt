package com.mycompany.prompt3.gpt40.review1;

public class AccountHelper {
  public float calculateTotalFee(Account[] accounts) {
    float totalFee = 0;
    for (Account account : accounts) {
      totalFee += account.calculateFee();
    }
    return totalFee;
  }
}
