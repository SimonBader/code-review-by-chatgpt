package com.mycompany.prompt3.gpt40.review3;

public class AccountHelper {
  public double calculateTotalFee(Account... accounts) {
    double totalFee = 0;
    for (Account account : accounts) {
      totalFee += account.calculatePremiumFee();
    }
    return totalFee;
  }
}
