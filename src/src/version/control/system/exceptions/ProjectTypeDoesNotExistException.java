package version.control.system.exceptions;

/**
 * An exception that is thrown when the project type does not exist.
 *
 * @author Rodrigo Santos, 63263.
 * @author Sebastiao Martins, 63447.
 */

@SuppressWarnings("serial")
public class ProjectTypeDoesNotExistException extends Exception {

    //Constant.
    private static final String MESSAGE = "Unknown project type.\n";

    //Constructor.
    public ProjectTypeDoesNotExistException() {
        super(MESSAGE);
    }

}
