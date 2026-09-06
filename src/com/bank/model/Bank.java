package src.com.bank.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;
import java.util.ListIterator;

public class Bank {
    private List<BankAccount> accounts;

    public Bank(){
        this.accounts = new ArrayList<>();
    }


    // Method for creating and adding account
    public void createAccount(String username, String phoneNumber, String cardNumber, BigDecimal balance) {
        if(username == null)
            System.out.println("Account name cannot be null!");

        if(phoneNumber == null)
            System.out.println("Phone number cannot be null!");

        if(cardNumber.length() < 16 || cardNumber == null)
            System.out.println("Card number's length cannot be less than 16 digits!");

        if(balance.signum() == -1)
            System.out.println("Balance cannot be negative!");


        BankAccount an_account = new BankAccount(username, phoneNumber, cardNumber , balance);
        accounts.add(an_account);
        System.out.println("The account has been created successfully!");
    }


    // method for deleting an account with using account ID
    public void deleteAccount(int accID){
        if(accID <=0)
            System.out.println("Account ID cannot be negative or zero!");

        ListIterator<BankAccount> iterator = accounts.listIterator();
        while(iterator.hasNext()){
            BankAccount acc = iterator.next();
            if (acc.getAccountID() == accID){
                iterator.remove();
                System.out.println("Account ID" + accID + " has been deleted successfully!");
            }
        }

        System.out.println("Account ID" + accID + " not found!");
    }



    // method for finding an account by its ID
    public BankAccount findAccountByID(int accountID){
        ListIterator<BankAccount> iterator = accounts.listIterator();
        while(iterator.hasNext()){
            BankAccount acc = iterator.next();
            if(acc.getAccountID() == accountID)
                return acc;
        }

        return null;
    }


    // method for getting all accounts
    public void displayAllAccounts(){
        if(accounts == null)
            System.out.println("There is not any account to display");

        for(BankAccount account : accounts)
            System.out.println(account);
    }
}
