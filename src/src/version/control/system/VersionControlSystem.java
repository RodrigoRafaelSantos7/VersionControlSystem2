package version.control.system;

import user.User;
import version.control.system.exceptions.*;

import java.util.Iterator;

public interface VersionControlSystem {

    /**
     * Registers a new Manager into the system.
     *
     * @param username     -  the username of the Manager.
     * @param clearanceLvl -  the clearance level of the Manager.
     * @throws UserAlreadyExistsException - if already exist a User with the given username.
     */
    void registerManager(String username, int clearanceLvl) throws UserAlreadyExistsException;

    /**
     * Registers a new Developer into the system.
     *
     * @param username        - the username of the Developer.
     * @param managerUsername - the username of the associated Manager,
     * @param clearanceLvl    - the clearance level of the Developer.
     * @throws ManagerUsernameDoesNotExistException - if the manager does not exist.
     * @throws UserAlreadyExistsException           - if already exist a User with the given
     *                                              username.
     */
    void registerDeveloper(String username, String managerUsername, int clearanceLvl) throws
            ManagerUsernameDoesNotExistException, UserAlreadyExistsException;

    /**
     * @return - The iterator with all the users of the system ordered by alphabetic order.
     */
    Iterator<User> listAllUsers();

    /**
     * Returns the ClearanceLvl of the user with the given name.
     *
     * @param managerUsername - The username of the User.
     * @return - The clearance level.
     */
    int getClearanceLvl(String managerUsername);

    void addNewProject(String managerUsername, String projectype, String projectName,
                       String[] keyword, int confidentialityLevel, String companyName) throws
            ProjectTypeDoesNotExistException, ManagerUsernameDoesNotExistException,
            ProjectNameAlreadyExistException, InvalidConfidentialityLevelException;

}
