package version.control.system.exceptions;

/**
 * An exception that is thrown when the project name does not exist.
 *
 * @author Rodrigo Santos, 63263.
 * @author Sebastiao Martins, 63447.
 */

@SuppressWarnings("serial")
public class ProjectNameDoesNotExistException extends Exception {

    //Constants.
    private static final String MESSAGE = "%s project does not exist.\n";

    //Constructor.
    public ProjectNameDoesNotExistException() {
        super(MESSAGE);
    }
}
