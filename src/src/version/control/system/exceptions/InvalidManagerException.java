package version.control.system.exceptions;

/**
 * An exception that is thrown when the given manager username is not correspodent to the project
 * manager of the project with the given project name.
 *
 * @author Rodrigo Santos, 63263.
 * @author Sebastiao Martins, 63447.
 */

@SuppressWarnings("serial")
public class InvalidManagerException extends Exception {

    //Constants.
    private static final String MESSAGE = "%s is managed by %s.\n";

    //Constructor.
    public InvalidManagerException() {
        super(MESSAGE);
    }
}
