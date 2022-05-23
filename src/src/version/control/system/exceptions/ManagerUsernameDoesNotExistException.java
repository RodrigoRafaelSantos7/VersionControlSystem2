package version.control.system.exceptions;

/**
 * An exception that is thrown when the manager name does not exist.
 *
 * @author Rodrigo Santos, 63263.
 * @author Sebastiao Martins, 63447.
 */

@SuppressWarnings("serial")
public class ManagerUsernameDoesNotExistException extends Exception{

    private static final String MESSAGE = "Project manager %s does not exist.\n";

    public ManagerUsernameDoesNotExistException(){
        super(MESSAGE);
    }
}
