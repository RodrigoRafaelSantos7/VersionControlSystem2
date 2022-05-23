package version.control.system.exceptions;

/**
 * An exception that is thrown when the job position does not exist.
 *
 * @author Rodrigo Santos, 63263.
 * @author Sebastiao Martins, 63447.
 */

@SuppressWarnings("serial")
public class JobPositionDoesNotExistException extends Exception {

    private static final String MESSAGE = "Unknown job position.\n";

    public JobPositionDoesNotExistException() {
        super(MESSAGE);
    }
}

