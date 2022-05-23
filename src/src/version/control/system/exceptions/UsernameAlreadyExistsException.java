package version.control.system.exceptions;

/**
 * An exception that is thrown when the username of a new user is already in use.
 *
 * @author Rodrigo Santos, 63263.
 * @author Sebastiao Martins, 63447.
 */

@SuppressWarnings("serial")
public class UsernameAlreadyExistsException extends Exception {

    private static final String MESSAGE = "User %s already exists.\n";

    public UsernameAlreadyExistsException() {
        super(MESSAGE);
    }

}
