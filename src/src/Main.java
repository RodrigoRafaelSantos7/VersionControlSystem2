import artefact.Artefact;
import artefact.ArtefactClass;
import org.jetbrains.annotations.NotNull;
import project.Inhouse;
import project.Outsourced;
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

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Main program to demonstrate the Version Control System.
 *
 * @author - Rodrigo Santos, 63263.
 * @author - Sebastiao Martins, 63447.
 */
public class Main {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");


    /**
     * Main Program. Invokes the command interpreter.
     *
     * @param args -  arguments to run the application. Not used in this program.
     */
    public static void main(String[] args) {
        Main.commandInterpreter();
    }

    /**
     * Command interpreter.
     */
    private static void commandInterpreter() {
        Scanner input = new Scanner(System.in);
        Command comm = getCommand(input);
        VersionControlSystem controlSystem = new VersionControlSystemClass();

        while (!comm.equals(Command.EXIT)) {
            switch (comm) {

                case REGISTER:
                    register(input, controlSystem);
                    break;
                case USERS:
                    users(controlSystem);
                    break;
                case CREATE:
                    create(input, controlSystem);
                    break;
                case PROJECTS:
                    projects(controlSystem);
                    break;
                case TEAM:
                    team(input, controlSystem);
                    break;
                case ARTEFACTS:
                    artefacts(input, controlSystem);
                    break;
                case PROJECT:
                    break;
                case REVISION:
                    break;
                case MANAGES:
                    break;
                case KEYWORD:
                    break;
                case CONFIDENTIALITY:
                    break;
                case WORKAHOLICS:
                    break;
                case COMMON:
                    break;
                case HELP:
                    help();
                    break;
                default:
                    System.out.print(Command.UNKNOWN.getCommandDescription());
                    break;
            }
            comm = getCommand(input);
        }
        System.out.print(Output.EXITING.getOutput());
        input.close();
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
     * Lists all the available commands in the system.
     */
    private static void help() {
        System.out.print(Output.HEADER_COMMANDS.getOutput());
        for (Command comm : Command.values()) {
            if (!comm.equals(Command.UNKNOWN)) System.out.print(comm.getCommandDescription());
        }
    }

    private static void register(Scanner input, VersionControlSystem controlSystem) {
        String jobPosition = input.next();
        String username = input.next();
        String managerUsername = null;

        if (jobPosition.equals(UserTypes.DEVELOPER.getText())) managerUsername = input.next();

        int clearanceLvl = input.nextInt();

        try {
            controlSystem.registerUser(jobPosition, username, managerUsername, clearanceLvl);

            if (jobPosition.equals(UserTypes.DEVELOPER.getText()))
                System.out.printf(Output.DEVELOPER_ADDED.getOutput(), username, clearanceLvl);
            else System.out.printf(Output.MANAGER_ADDED.getOutput(), username, clearanceLvl);
        } catch (JobPositionDoesNotExistException e) {
            System.out.print(e.getMessage());
        } catch (UsernameAlreadyExistsException e) {
            System.out.printf(e.getMessage(), username);
        } catch (ManagerUsernameDoesNotExistException e) {
            System.out.printf(e.getMessage(), managerUsername);
        }
    }

    private static void users(VersionControlSystem controlSystem) {
        Iterator<User> it = controlSystem.listAllUsers();

        if (!it.hasNext()) System.out.print(Output.NO_USERS.getOutput());
        else {
            System.out.print(Output.HEADER_USERS.getOutput());
            while (it.hasNext()) {
                User user = it.next();

                if (user instanceof Manager manager) {
                    System.out.printf(Output.MANAGER_OUTPUT.getOutput(), manager.getUsername(),
                            manager.getNumDevelopers(), manager.getNumProjectsAsManager(),
                            manager.getNumberOfProjectsAsMember());
                } else if (user instanceof Developer developer) {
                    System.out.printf(Output.DEVELOPER_OUTPUT.getOutput(), developer.getUsername(),
                            developer.getManagerUsername(),
                            developer.getNumberOfProjectsAsMember());
                }
            }
        }
    }

    private static void create(Scanner input, VersionControlSystem controlSystem) {
        String managerUsername = input.next();
        String projectType = input.next();
        String projectName = input.nextLine().trim();
        int numKeyword = input.nextInt();
        String[] keywordArray = new String[numKeyword];

        for (int i = 0; i < numKeyword; i++) {
            String keyword = input.next();

            keywordArray[i] = keyword;
        }

        int confidentialityLvl = 0;
        String companyName = null;

        if (projectType.equalsIgnoreCase(ProjectTypes.OUTSOURCED.getText()))
            companyName = input.next();
        else confidentialityLvl = input.nextInt();

        try {
            controlSystem.registerProject(managerUsername, projectType, projectName, keywordArray,
                    companyName, confidentialityLvl);
            System.out.printf(Output.PROJECT_ADDED.getOutput(), projectName);
        } catch (ProjectTypeDoesNotExistException e) {
            System.out.print(e.getMessage());
        } catch (ManagerUsernameDoesNotExistException e) {
            System.out.printf(e.getMessage(), managerUsername);
        } catch (ProjectNameAlreadyExistsException e) {
            System.out.printf(e.getMessage(), projectName);
        } catch (InsuficientClearanceLevelException e) {
            System.out.printf(e.getMessage(), managerUsername,
                    controlSystem.getClearanceLvl(managerUsername));
        }
    }

    private static void projects(VersionControlSystem controlSystem) {
        Iterator<Project> it = controlSystem.listAllProjects();
        if (!it.hasNext()) System.out.print(Output.NO_PROJECTS.getOutput());
        else {
            System.out.print(Output.HEADER_PROJECTS.getOutput());
            while (it.hasNext()) {
                Project project = it.next();

                if (project instanceof Inhouse inhouse) {
                    System.out.printf(Output.INHOUSE_OUTPUT.getOutput(), inhouse.getProjectName(),
                            inhouse.getManagerUsername(), inhouse.getConfidentialityLvl(),
                            inhouse.getNumOfMembers(), inhouse.getNumOfArtefacts(),
                            inhouse.getNumOfRevisions());
                } else if (project instanceof Outsourced outsourced) {
                    System.out.printf(Output.OUTSOURSE_OUTPUT.getOutput(),
                            outsourced.getProjectName(), outsourced.getManagerUsername(),
                            outsourced.getCompanyName());
                }
            }
        }
    }

    private static void team(Scanner input, VersionControlSystem controlSystem) {
        String managerUsername = input.next();
        String projectName = input.nextLine().trim();
        int numberOfUsernames = input.nextInt();
        String[] usernamesArray = new String[numberOfUsernames];

        for (int i = 0; i < numberOfUsernames; i++) {
            String username = input.next();

            usernamesArray[i] = username;
        }

        try {
            Iterator<String> it = controlSystem.addUsersToProject(managerUsername, projectName,
                    usernamesArray);

            System.out.print(Output.HEADER_TEAM.getOutput());

            while (it.hasNext()) {
                System.out.print(it.next());
            }
        } catch (ManagerUsernameDoesNotExistException e) {
            System.out.printf(e.getMessage(), managerUsername);
        } catch (ProjectNameDoesNotExistException e) {
            System.out.printf(e.getMessage(), projectName);
        } catch (InvalidManagerException e) {
            System.out.printf(e.getMessage(), projectName,
                    controlSystem.getProjectManagerUsername(projectName));
        }
    }

    private static void artefacts(Scanner input, VersionControlSystem controlSystem) {
        String memberUsername = input.next();
        String projectName = input.nextLine().trim() ;

        LocalDate date = LocalDate.parse(input.nextLine(),formatter);

        int numArtefacts = input.nextInt();
        Artefact[] artefacts = new Artefact[numArtefacts];

        for (int i = 0; i < numArtefacts; i++) {
            artefacts[i] = new ArtefactClass(memberUsername, input.next().trim(), input.nextInt(),
                    date , input.nextLine().trim());
        }

        try {
            Iterator<String> it = controlSystem.addArtefactsToProject(memberUsername, projectName,
                    artefacts);

            System.out.print(Output.HEADER_ARTEFACTS.getOutput());

            while (it.hasNext()) {
                System.out.print(it.next());
            }
        } catch (UserDoesNotExistException e) {
            System.out.printf(e.getMessage(), memberUsername);
        } catch (ProjectNameDoesNotExistException e) {
            System.out.printf(e.getMessage(), projectName);
        } catch (UserDoesNotExistInProjectException e) {
            System.out.printf(e.getMessage(), memberUsername, projectName);
        }
    }
}