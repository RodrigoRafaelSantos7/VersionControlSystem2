package version.control.system.exceptions;

public class InvalidConfidentialityLevelException extends Exception {
    private static final String MESSAGE = "Project manager &s has clearance level %d\n";

    public InvalidConfidentialityLevelException() {
        super(MESSAGE);
    }
}
