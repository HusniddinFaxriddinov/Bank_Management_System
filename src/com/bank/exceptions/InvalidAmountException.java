package src.com.bank.exceptions;

/** InvalidAmountException
 * @since 1.0
 * @author Husniddin Tsutomu
 * Description: it throws exception when user tries to add invalid amount of money
 * to an account
 * */
public class InvalidAmountException extends Exception {
    public InvalidAmountException(String message) {
        super(message);
    }
}
