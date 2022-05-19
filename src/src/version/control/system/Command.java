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
    EXIT("exit - terminates the execution of the program\n"),
    HELP("help - shows the available commands\n"),
    REGISTER("register - adds a new user\n"),
    USERS("users - lists all registered users\n"),
    CREATE("create - create a new project\n"),
    PROJECTS("projects - lists all projects\n"),
    UNKNOWN("Unknown command. Type help to see available commands."),
    ;

    private final String text; // The variable that stores the text associated with the constant.

    Command(String text) {
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
