package com.mycompany.prompt2.gpt35.review1;

public class FeeCalculator {
  // Constants for fee calculation
  private static final double FEE_RATE = 0.0125;

  public static double calculateFee(Account accounts[]) {
    double totalFee = 0;
    Account currentAccount;

    for (int i = 0; i < accounts.length; i++) {
      currentAccount = accounts[i];

      // Check if the account type is premium or premium plus
      if (currentAccount.accountType == Account.PREMIUM ||
          currentAccount.accountType == Account.PREMIUM_PLUS) {

        // Avoid division by zero by checking if daysActive is non-zero
        if (currentAccount.daysActive != 0) {
          double expValue = Math.exp(currentAccount.rate * (currentAccount.daysActive / 365.25));
          double fee = FEE_RATE * (currentAccount.principal * (expValue - 1));
          totalFee += fee;
        }
      }
    }
    return totalFee;
  }
}