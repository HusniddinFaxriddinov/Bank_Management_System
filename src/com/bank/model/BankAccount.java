package src.com.bank.model;
import src.com.bank.exceptions.InsufficientAmountException;
import src.com.bank.exceptions.InvalidAmountException;

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

    // method for Deposit
    public void deposit(BigDecimal amount) throws InvalidAmountException{
        if(amount == null)
            throw new InvalidAmountException("Amount cannot be null");
        if(amount.signum() == -1)
            throw new InvalidAmountException("Invalid amount, amount cannot be negative!");

        this.balance = this.balance.add(amount);

    }

    // method for Withdraw
    public void withdraw(BigDecimal amount) throws InsufficientAmountException, InvalidAmountException{
        if(amount == null)
            throw new InvalidAmountException("Amount cannot be null");
        if(amount.signum() == -1)
            throw new InvalidAmountException("Invalid amount, amount cannot be negative!");
        if(balance.compareTo(amount) == -1)
            throw new InsufficientAmountException("You do not have enough amount to complete this operation");

        this.balance = this.balance.subtract(amount);
    }

    // setter and getter methods
    public void setBalance(BigDecimal balance) throws InvalidAmountException{
        if(balance == null)
            throw new InvalidAmountException("Amount cannot be null");
        if(balance.signum() == -1)
            throw new InvalidAmountException("Invalid amount, balance cannot be negative!");

        this.balance = balance;
    }

    public BigDecimal getBalance(){
        return balance;
    }
}
