package version.control.system.exceptions;

@SuppressWarnings("serial")
public class ManagerUsernameDoesNotExistException extends Exception {

    private static final String MESSAGE = "Project manager %s does not exist.\n";

    public ManagerUsernameDoesNotExistException(){
        super(MESSAGE);
    }
}
