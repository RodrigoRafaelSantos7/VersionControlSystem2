package version.control.system;

/**
 * Enum that defines the outputs of the system.
 *
 * @author - Rodrigo Santos, 63263.
 * @author - Sebastiao Martins, 63447.
 */

public enum Output {
    //Constants.
    ADDED_PROJECT("%s: added to the project.\n"),
    ADDED_TEAM("%s: added to the team.\n"), //Constants.
    ALREADY_IN_PROJECT("%s: already in the project.\n"),
    ALREADY_MEMBER("%s: already a member.\n"),
    DEVELOPER_ADDED("User %s was registered as developer with clearance level %d.\n"),
    DEVELOPER_OUTPUT("developer %s is managed by %s [%d]\n"),
    EXCEEDS_CONFIDENTIALITY("%s: exceeds project confidentiality level.\n"),
    EXITING("Bye!\n"),
    HEADER_COMMANDS("Available commands:\n"),
    HEADER_PROJECTS("All projects:\n"),
    HEADER_ARTEFACTS("Latest project artefacts:\n"),
    HEADER_TEAM("Latest team members:\n"),
    HEADER_USERS("All registered users:\n"),
    INHOUSE_OUTPUT("in-house %s is managed by %s [%d, %d, %d, %d]\n"),
    INSUFFICIENT_CLEARANCE("%s: insufficient clearance level.\n"),
    MANAGER_ADDED("User %s was registered as manager with clearance level %d.\n"),
    MANAGER_OUTPUT("manager %s [%d, %d, %d]\n"),
    NO_PROJECTS("No projects added.\n"),
    NO_USERS("No users registered.\n"),
    OUTSOURSE_OUTPUT("outsourced %s is managed by %s and developed by %s\n"),
    PROJECT_ADDED("%s project was created.\n"),
    USERNAME_DOES_NOT_EXIST("%s: does not exist.\n");


    private final String output; //The output of the system.

    /**
     * Constructor.
     *
     * @param output - The output of the system.
     */
    Output(String output) {
        this.output = output;
    }

    /**
     * @return - The output we want to print.
     */
    public String getOutput() {
        return output;
    }
}

