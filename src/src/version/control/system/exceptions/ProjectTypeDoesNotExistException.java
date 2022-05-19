package version.control.system.exceptions;

public class ProjectTypeDoesNotExistException extends RuntimeException{

    private static final String MESSAGE = "Unknown project type.\n";

    public ProjectTypeDoesNotExistException(){
        super(MESSAGE);
    }
}
