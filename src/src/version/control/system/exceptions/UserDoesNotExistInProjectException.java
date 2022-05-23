package version.control.system.exceptions;


/**
 * An exception that is thrown when the given username does not belong to the given project.
 *
 * @author Rodrigo Santos, 63263.
 * @author Sebastiao Martins, 63447.
 */

@SuppressWarnings("serial")
public class UserDoesNotExistInProjectException extends Exception {

    private static final String MESSAGE = "User %s does not belong to the team of %s.\n";

    public UserDoesNotExistInProjectException() {
        super(MESSAGE);
    }
}
