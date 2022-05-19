import org.jetbrains.annotations.NotNull;
import project.Project;
import project.ProjectTypes;
import user.Developer;
import user.Manager;
import user.User;
import user.UserTypes;
import version.control.system.Command;
import version.control.system.Output;
import version.control.system.VersionControlSystem;
import version.control.system.VersionControlSystemClass;
import version.control.system.exceptions.*;

import java.util.Iterator;
import java.util.Scanner;

/**
 * Main program to demonstrate the Version Control System.
 *
 * @author - Rodrigo Santos, 63263.
 * @author - Sebastiao Martins, 63447.
 */
public class Main {

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
                    users(control);
                    break;
                case CREATE:
                    create(input, control);
                    break;
                case PROJECTS:
                    projects(control);
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

        if (jobPosition.equalsIgnoreCase(UserTypes.DEVELOPER.getText())) {
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
        } else if (jobPosition.equalsIgnoreCase(UserTypes.MANAGER.getText())) {
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

    /**
     * Lists all the Users of the system. Username alphabetic order.
     *
     * @param control -  the VersionControlSystem from where the users will be listed by
     *                alphabetic order.
     */
    private static void users(VersionControlSystem control) {
        Iterator<User> it = control.listAllUsers();
        if (!it.hasNext()) {
            System.out.print(Output.NO_USERS.getText());
        } else {
            System.out.print(Output.HEADER_USERS.getText());
            while (it.hasNext()) {
                User user = it.next();
                if (user instanceof Developer) {
                    System.out.printf(Output.DEVELOPER_OUTPUT.getText(), user.getUsername(),
                            ((Developer) user).getManagerUsername(),
                            ((Developer) user).getNumberOfProjects());
                } else {
                    System.out.printf(Output.MANAGER_OUTPUT.getText(), user.getUsername(),
                            ((Manager) user).getNumberOfDevs(),
                            ((Manager) user).getProjectsAsManager(),
                            ((Manager) user).getProjectsAsMembers());
                }
            }
        }
    }

    private static void create(Scanner input, VersionControlSystem control) {
        String projectManager = input.next();
        String projectType = input.next();
        String projectName = input.nextLine().trim();
        int numberKeyWords = input.nextInt();
        String[] keyWords = new String[numberKeyWords];
        int confidentialityLvl = 0;
        String companyName = null;

        for (int i = 0; i < numberKeyWords; i++) {
            String keyWord = input.next();
            keyWords[i] = keyWord;
        }

        if (projectType.equals(ProjectTypes.INHOUSE.getText())) {
            confidentialityLvl = input.nextInt();
        } else {
            companyName = input.next();
        }

        try {
            control.addNewProject(projectManager, projectType, projectName, keyWords,
                    confidentialityLvl, companyName);
            System.out.printf(Output.PROJECT_ADDED.getText(), projectName);
        } catch (ProjectTypeDoesNotExistException e) {
            System.out.print(e.getMessage());
        } catch (ManagerUsernameDoesNotExistException e) {
            System.out.printf(e.getMessage(), projectManager);
        } catch (ProjectNameAlreadyExistException e) {
            System.out.printf(e.getMessage(), projectName);
        } catch (InvalidConfidentialityLevelException e) {
            System.out.printf(e.getMessage(), projectManager,
                    control.getClearanceLvl(projectManager));
        }
    }

    private static void projects(VersionControlSystem control){
        Iterator<Project> it = control.listAllProjects();

    }
}
