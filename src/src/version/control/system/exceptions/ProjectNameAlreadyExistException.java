package version.control.system.exceptions;

public class ProjectNameAlreadyExistException extends Exception{

    private static final String MESSAGE = "%s project already exists.\n";

    public ProjectNameAlreadyExistException(){
        super(MESSAGE);
    }
}
