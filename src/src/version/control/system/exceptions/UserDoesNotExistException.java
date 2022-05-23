package version.control.system.exceptions;

/**
 * An exception that is thrown when the given username does not belong to a user in the system.
 *
 * @author Rodrigo Santos, 63263.
 * @author Sebastiao Martins, 63447.
 */

@SuppressWarnings("serial")
public class UserDoesNotExistException extends Exception{

    //Constant.
    private static final String MESSAGE = "User %s does not exist.\n";

    //Constructor
    public UserDoesNotExistException(){
        super(MESSAGE);
    }
}
