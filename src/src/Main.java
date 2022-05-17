import org.jetbrains.annotations.NotNull;
import version.control.system.Command;
import version.control.system.Output;
import version.control.system.VersionControlSystem;
import version.control.system.VersionControlSystemClass;
import version.control.system.exceptions.ManagerUsernameDoesNotExistException;
import version.control.system.exceptions.UserAlreadyExistsException;

import java.util.Scanner;

/**
 * Main program to demonstrate the Version Control System.
 *
 * @author - Rodrigo Santos, 63263.
 * @author - Sebastiao Martins, 63447.
 */
public class Main {

    private static final String DEVELOPER = "Developer";
    private static final String MANAGER = "Manager";

    /**
     * Main Program. Invokes the command interpreter.
     *
     * @param args -  arguments to run the application. Not used in this program.
     */
    public static void main(String[] args) {
        Main.interpreter();
    }

    /**
     * Command interpreter.
     */
    private static void interpreter() {
        VersionControlSystem control = new VersionControlSystemClass();
        Scanner input = new Scanner(System.in);
        Command comm = getCommand(input);
        while (!comm.equals(Command.EXIT)) {
            switch (comm) {
                case HELP:
                    help();
                    break;
                case REGISTER:
                    register(input, control);
                    break;
                case USERS:
                    break;
                default:
                    System.out.println(Command.UNKNOWN.getText());
                    break;
            }
            comm = getCommand(input);
        }
        System.out.println(Output.EXITING.getText());
    }

    /**
     * Reads the command from the input and returns the correspondent value from the Command enum.
     *
     * @param input - the input from where the data will be read.
     * @return - the value of the enum that resemble the command.
     */
    private static Command getCommand(@NotNull Scanner input) {
        try {
            return Command.valueOf(input.next().toUpperCase());
        } catch (IllegalArgumentException e) {
            return Command.UNKNOWN;
        }
    }

    /**
     * Prints all the available commands in the system and their use.
     */
    private static void help() {
        for (Command comm :
                Command.values()) {
            if (!comm.equals(Command.UNKNOWN)) {
                System.out.println(comm.getText());
            }
        }
    }

    /**
     * Registers a new user in the system.
     *
     * @param input   - the input from where the data will be read.
     * @param control - the VersionControlSystem where the user will be registered.
     */
    private static void register(@NotNull Scanner input, VersionControlSystem control) {

        String jobPosition = input.next();
        String username = input.next();

        if (jobPosition.equalsIgnoreCase(DEVELOPER)) {
            String managerUsername = input.next();
            int clearanceLvl = input.nextInt();
            try {
                control.registerDeveloper(username, managerUsername, clearanceLvl);
                System.out.printf(Output.DEVELOPER_ADDED.getText(), username, clearanceLvl);
            } catch (UserAlreadyExistsException e) {
                System.out.printf(e.getMessage(), username);
            } catch (ManagerUsernameDoesNotExistException e) {
                System.out.printf(e.getMessage(), managerUsername);
            }
        } else if (jobPosition.equalsIgnoreCase(MANAGER)) {
            int clearanceLvl = input.nextInt();
            try {
                control.registerManager(username, clearanceLvl);
                System.out.printf(Output.MANAGER_ADDED.getText(), username, clearanceLvl);
            } catch (UserAlreadyExistsException e) {
                System.out.printf(e.getMessage(), username);
            }
        } else {
            System.out.print(Output.UNKNOWN_JOB.getText());
            input.nextLine();
        }
    }
}
