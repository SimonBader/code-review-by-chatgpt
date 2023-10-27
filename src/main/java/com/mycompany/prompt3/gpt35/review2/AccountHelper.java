package com.mycompany.prompt3.gpt35.review2;


public class AccountHelper {
  public float calculateFee(Account accounts[]) {
    float totalFee = 0;

    for (int i = 0; i < accounts.length; i++) {
      Account account = accounts[i];

      // Check if the account type is premium or premium plus.
      /** ADDED TODO: code does not compile (fixed)
      if (account.accountType == Account.PREMIUM || account.accountType == Account.PREMIUM_PLUS) { **/
      if (account.getAccountType() == Account.PREMIUM || account.getAccountType() == Account.PREMIUM_PLUS) {
      /** ADDED **/
        // Calculate the fee using the given formula.
        /** ADDED TODO: code does not compile (quick-fixed)
        float fee = 0.0125f * (account.getBalance() * Math.exp(account.getInterestRate() * (account.getDaysActive() / 365.25f)) - account.getBalance()); **/
        float fee = (float) (0.0125f * (account.getBalance() * Math.exp(account.getInterestRate() * (account.getDaysActive() / 365.25f)) - account.getBalance()));
        /** ADDED **/

        // Add the fee to the total.
        totalFee += fee;
      }
    }
    return totalFee;
  }
}
