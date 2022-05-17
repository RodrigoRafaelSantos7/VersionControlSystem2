package version.control.system.exceptions;

@SuppressWarnings("serial")
public class UserAlreadyExistsException extends RuntimeException {

    private static final String MESSAGE = "User %s already exists.\n";

    public UserAlreadyExistsException(){
        super(MESSAGE);
    }
}
