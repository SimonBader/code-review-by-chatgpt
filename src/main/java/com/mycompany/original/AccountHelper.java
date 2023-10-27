package com.mycompany.original;

public class AccountHelper {
  public float calculateFee(Account accounts[]) {
    float totalFee = 0;
    Account account;
    for (int i = 0; i < accounts.length; i++) {
      account = accounts[i];
      if ( account.accountType == Account.PREMIUM ||
          account.accountType == Account.PREMIUM_PLUS ) {
        totalFee += .0125 * ( account.principal
            * Math.exp( account.rate * (account.daysActive/365.25) )
            - account.principal );
      }
    }
    return totalFee;
  }
}
