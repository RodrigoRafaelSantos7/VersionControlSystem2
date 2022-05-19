package version.control.system;


import project.*;
import user.*;
import version.control.system.exceptions.*;

import java.util.*;

/**
 * System of the project.
 *
 * @author - Rodrigo Santos, 63263.
 * @author - Sebastiao Martins, 63447.
 */

public class VersionControlSystemClass implements VersionControlSystem {


    private final Map<String, User> users;
    private final Map<String, Manager> managers;
    private final Map<String, Developer> developers;
    private final SortedMap<String, User> usersAlphabetic;
    private final Map<String, Project> projects;
    private final Map<String, Inhouse> inhouseProjects;
    private final Map<String, Outsourced> outsourcedProjects;

    public VersionControlSystemClass() {
        this.users = new HashMap<>();
        this.managers = new HashMap<>();
        this.developers = new HashMap<>();
        this.usersAlphabetic = new TreeMap<>();
        this.projects = new HashMap<>();
        this.inhouseProjects = new HashMap<>();
        this.outsourcedProjects = new HashMap<>();
    }

    @Override
    public void registerManager(String username, int clearanceLvl) throws
            UserAlreadyExistsException {
        if (hasUser(username))
            throw new UserAlreadyExistsException();

        Manager manager = new ManagerClass(username, clearanceLvl);
        users.put(username, manager);
        managers.put(username, manager);
        usersAlphabetic.put(username, manager);
    }

    @Override
    public void registerDeveloper(String username, String managerUsername, int clearanceLvl) throws
            ManagerUsernameDoesNotExistException, UserAlreadyExistsException {
        if (hasUser(username))
            throw new UserAlreadyExistsException();
        if (hasManager(managerUsername))
            throw new ManagerUsernameDoesNotExistException();

        Developer developer = new DeveloperClass(username, managerUsername, clearanceLvl);

        users.put(username, developer);
        developers.put(username, developer);
        usersAlphabetic.put(username, developer);

        managers.get(managerUsername).addDeveloper(username, developer);
    }

    @Override
    public Iterator<User> listAllUsers() {
        return usersAlphabetic.values().iterator();
    }

    @Override
    public int getClearanceLvl(String managerUsername) {
        return getUser(managerUsername).getClearanceLvl();
    }

    @Override
    public void addNewProject(String managerUsername, String projectype, String projectName,
                              String[] keywords, int confidentialityLevel, String companyName)
            throws ProjectTypeDoesNotExistException, ManagerUsernameDoesNotExistException,
            ProjectNameAlreadyExistException, InvalidConfidentialityLevelException {
        if (!isValidProjectType(projectype))
            throw new ProjectTypeDoesNotExistException();
        if (hasManager(managerUsername))
            throw new ManagerUsernameDoesNotExistException();
        if (hasProjectName(projectName))
            throw new ProjectNameAlreadyExistException();
        if (isValidConfidentialityLvl(confidentialityLevel, managerUsername))
            throw new InvalidConfidentialityLevelException();

        if (projectype.equalsIgnoreCase(ProjectTypes.INHOUSE.getText()))
            registerInhouseProject(managerUsername, projectName, keywords, confidentialityLevel);
        else registerOutsourcedProject(managerUsername, projectName, keywords, companyName);
    }


    /**
     * Checks if the system has a User with the given name.
     *
     * @param username -  The username we want to check.
     * @return - True if there is a user with the given username. Else returns False.
     */
    private boolean hasUser(String username) {
        return users.containsKey(username);
    }

    /**
     * Checks if the system has a Manager with the given name.
     *
     * @param username -  The username we want to check.
     * @return - True if there is a Manager with the given username. Else returns False.
     */
    private boolean hasManager(String username) {
        return !managers.containsKey(username);
    }

    /**
     * Finds the User in the HashMap and returns it.
     *
     * @param username - The name of the user we want to return.
     * @return - The User with the given username.
     */
    private User getUser(String username) {
        return users.get(username);
    }

    /**
     * Checks if the given project type is valid.
     *
     * @param projectType - The type of the project.
     * @return - True if is the projectType is valis. Else returns False.
     */
    private boolean isValidProjectType(String projectType) {
        return projectType.equalsIgnoreCase(ProjectTypes.INHOUSE.getText()) ||
                projectType.equalsIgnoreCase(ProjectTypes.OUTSOURCED.getText());
    }

    /**
     * Checks if the project name if already in use.
     *
     * @param projectName - The name of the project.
     * @return - True if the project name is already in use. Else returns False.
     */
    private boolean hasProjectName(String projectName) {
        return projects.containsKey(projectName);
    }

    /**
     * Checks if the given condidentiality level is greater than the given manager clearance level.
     *
     * @param confidentialityLvl - The confidentiality level we want to check.
     * @param managerUsername    - The username of the manager we want to compare.
     * @return - True if the given condidentiality level is greater than the given manager. Else
     * returns false.
     */
    private boolean isValidConfidentialityLvl(int confidentialityLvl, String managerUsername) {
        return confidentialityLvl > getUser(managerUsername).getClearanceLvl();
    }


    private void registerInhouseProject(String managerUsername,
                                        String projectName, String[] keywords,
                                        int confidentialityLevel) {
        Inhouse project = new InhouseClass(managerUsername, projectName,
                keywords, confidentialityLevel);

        inhouseProjects.put(projectName, project);
        projects.put(projectName, project);
        ((Manager) getUser(managerUsername)).addProjectAsManager(projectName, project);
    }

    private void registerOutsourcedProject(String managerUsername,
                                           String projectName, String[] keywords,
                                           String companyName) {
        Outsourced project = new OutsourcedClass(managerUsername, projectName,
                keywords, companyName);

        outsourcedProjects.put(projectName, project);
        projects.put(projectName, project);
        ((Manager) getUser(managerUsername)).addProjectAsManager(projectName, project);
    }
}
