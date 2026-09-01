package src.com.bank.exceptions;

/** InsufficientAmountException
 * @since 1.0
 * @author Husniddin Tsutomu
 * Description: it throws exception when user tries to withdraw invalid amount of money
 * from an account
 * */

public class InsufficientAmountException extends Exception{
    public InsufficientAmountException(String message){
        super(message);
    }
}
