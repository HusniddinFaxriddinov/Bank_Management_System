package src;

import java.math.BigDecimal;

public class BankAccount {
    private int accountNumber;
    private String ownerName;
    private BigDecimal balance;

    public BankAccount(int accountNumber, String ownerName, BigDecimal balance){
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    // there will be some methods which lets account owner do some actions

}
