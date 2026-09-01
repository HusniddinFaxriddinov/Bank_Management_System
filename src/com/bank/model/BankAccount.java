package src.com.bank.model;
import src.com.bank.exceptions.InsufficientAmountException;
import src.com.bank.exceptions.InvalidAmountException;

import java.util.Objects;
import java.util.Random;
import java.math.BigDecimal;


public class BankAccount {
    private int accountID = 0;
    private String ownerName;
    private String phoneNumber;
    private String cardNumber;
    private BigDecimal balance;
    private Random rd = new Random();


    public BankAccount(String ownerName, String phoneNumber, String cardNumber, BigDecimal balance) {
        this.ownerName = ownerName;
        this.phoneNumber = phoneNumber;
        this.cardNumber = cardNumber;
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

    public void setCardNumber(String cardNumber){this.cardNumber = cardNumber;}

    public String getCardNumber(){return this.cardNumber;}

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountID=" + accountID +
                ", ownerName='" + ownerName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", balance=" + balance +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BankAccount that = (BankAccount) o;
        return accountID == that.accountID && Objects.equals(ownerName, that.ownerName) && Objects.equals(phoneNumber, that.phoneNumber) && Objects.equals(cardNumber, that.cardNumber) && Objects.equals(balance, that.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountID, ownerName, phoneNumber, cardNumber, balance);
    }
}
