package version.control.system.exceptions;

/**
 * An exception that is thrown when the project name already exists.
 *
 * @author Rodrigo Santos, 63263.
 * @author Sebastiao Martins, 63447.
 */

@SuppressWarnings("serial")
public class ProjectNameAlreadyExistsException extends Exception {

    //Constants.
    private static final String MESSAGE = "%s project already exists.\n";

    //Constructor.
    public ProjectNameAlreadyExistsException() {
        super(MESSAGE);
    }
}
