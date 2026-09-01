package src.com.bank.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;
import java.util.ListIterator;

public class Bank {
    private List<BankAccount> accounts = new ArrayList<>();

    // Method for creating and adding account
    public boolean createAccount(String phoneNumber, String username, BigDecimal balance) {
        if(phoneNumber == null)
        {
            System.out.println("Phone number cannot be null!");
            return false;
        }
        if(username == null){
            System.out.println("Account name cannot be null!");
            return false;
        }
        if(balance.signum() == -1){
            System.out.println("Balance cannot be negative!");
            return false;
        }

        BankAccount an_account = new BankAccount(phoneNumber, username, balance);
        accounts.add(an_account);
        return true;
    }

    // method for deleting an account with using account ID
    public boolean deleteAccount(int accID){
        if(accID <=0){
            System.out.println("Account ID cannot be negative or zero!");
            return false;
        }

        ListIterator<BankAccount> iterator = accounts.listIterator();
        while(iterator.hasNext()){
            BankAccount acc = iterator.next();
            if (acc.getAccountID() == accID){
                iterator.remove();
                return true;
            }
        }

        System.out.println("Account ID" + accID + " not found!");
        return false;
    }
}
