package version.control.system.exceptions;

/**
 * An exception that is thrown when the clearance level of the project is higher than clearance
 * level of its manager.
 *
 * @author Rodrigo Santos, 63263.
 * @author Sebastiao Martins, 63447.
 */

@SuppressWarnings("serial")
public class InsuficientClearanceLevelException extends Exception {

    //Constants.
    private static final String MESSAGE = "Project manager %s has clearance level %d.\n";

    //Constructor.
    public InsuficientClearanceLevelException() {
        super(MESSAGE);
    }
}
