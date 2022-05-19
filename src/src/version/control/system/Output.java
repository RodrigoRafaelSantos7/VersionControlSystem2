package version.control.system;

/**
 * Enum that defines the outputs of the system.
 *
 * @author - Rodrigo Santos, 63263.
 * @author - Sebastiao Martins, 63447.
 */

public enum Output {

    /**
     * Constants.
     */
    EXITING("Bye!\n"),
    UNKNOWN_JOB("Unknown job position.\n"),
    MANAGER_ADDED("User %s was registered as project manager with clearance level %d\n"),
    DEVELOPER_ADDED("User %s was registered as software developer with clearance level %d\n"),
    NO_USERS("No users registered.\n"),
    HEADER_USERS("All registered users:\n"),
    DEVELOPER_OUTPUT("developer %s is managed by %s [%d]\n"),
    MANAGER_OUTPUT("manager %s [%d, %d, %d]\n"),
    PROJECT_ADDED("%s project was created\n"),
    HEADER_PROJECTS("All projects:\n"),
    INHOUSE_OUTPUT("in-house %s is managed by %s [%d, %d, %d, %d]\n"),
    OUTSOURSE_OUTPUR("outsourced %s is managed by %s and developed by %s\n"),
    NO_PROJECTS("No projects added.\n"),
    ;

    private final String text; // The variable that stores the text associated with the constant.

    Output(String text) {
        this.text = text;
    }

    /**
     * Getter - returns the text associated with the constant.
     *
     * @return - the text associated with the constant.
     */
    public String getText() {
        return text;
    }
}
