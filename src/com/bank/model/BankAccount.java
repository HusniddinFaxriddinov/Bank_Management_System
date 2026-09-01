package src.com.bank.model;
import src.com.bank.exceptions.InsufficientAmountException;
import src.com.bank.exceptions.InvalidAmountException;
import java.util.Random;
import java.math.BigDecimal;


public class BankAccount {
    private int accountID = 0;
    private String ownerName;
    private String phoneNumber;
    private BigDecimal balance;
    private Random rd = new Random();


    public BankAccount(String phoneNumber, String ownerName, BigDecimal balance) {
        this.phoneNumber = phoneNumber;
        this.ownerName = ownerName;
        this.balance = balance;
        this.accountID = rd.nextInt(000, 999);
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

    public int getAccountID(){
        return accountID;
    }

    public void setOwnerName(String name){
        this.ownerName = name;
    }
    public String getOwnerName(){
        return ownerName;
    }

    public void setPhoneNumber(String phone){
        this.phoneNumber = phone;
    }
    public String getPhoneNumber(){return this.phoneNumber;}
}
