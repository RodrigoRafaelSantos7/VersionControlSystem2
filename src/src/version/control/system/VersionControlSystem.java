package version.control.system;

import user.User;
import version.control.system.exceptions.ManagerUsernameDoesNotExistException;
import version.control.system.exceptions.UserAlreadyExistsException;

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
     * username.
     */
    void registerDeveloper(String username, String managerUsername, int clearanceLvl) throws
            ManagerUsernameDoesNotExistException, UserAlreadyExistsException;


    Iterator<User> listAllUsers();
}
