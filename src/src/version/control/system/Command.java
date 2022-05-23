package version.control.system;

/**
 * Enum that defines the commands of the system.
 *
 * @author - Rodrigo Santos, 63263.
 * @author - Sebastiao Martins, 63447.
 */
public enum Command {

    /**
     * Constants.
     */
    REGISTER("register - adds a new user\n"),
    USERS("users - lists all registered users\n"),
    CREATE("create - creates a new project\n"),
    PROJECTS("projects - lists all projects\n"),
    TEAM("team - adds team members to a project\n"),
    ARTEFACTS("artefacts - adds artefacts to a project\n"),
    PROJECT("project - shows detailed project information\n"),
    REVISION("revision - revises an artefact\n"),
    MANAGES("manages - lists developers of a manager\n"),
    KEYWORD("keyword - filters projects by keyword\n"),
    CONFIDENTIALITY("confidentiality - filters projects by confidentiality" +
            " level\n"),
    WORKAHOLICS("workaholics - top 3 employees with more artefacts updates\n"),
    COMMON("common - employees with more projects in common\n"),
    HELP("help - shows the available commands\n"),
    EXIT("exit - terminates the execution of the program\n"),
    UNKNOWN("Unknown command. Type help to see available commands.\n"),
    ;

    private final String commandDescription; //The description of the command.

    /**
     * Constructor.
     *
     * @param commandDescription - The description of the command.
     */
    Command(String commandDescription) {
        this.commandDescription = commandDescription;
    }

    /**
     * @return - The description of the command.
     */
    public String getCommandDescription() {
        return commandDescription;
    }
}
