package version.control.system;


import user.*;
import version.control.system.exceptions.ManagerUsernameDoesNotExistException;
import version.control.system.exceptions.UserAlreadyExistsException;

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

    public VersionControlSystemClass() {
        this.users = new HashMap<>();
        this.managers = new HashMap<>();
        this.developers = new HashMap<>();
        this.usersAlphabetic = new TreeMap<>();

    }

    @Override
    public void registerManager(String username, int clearanceLvl) throws
            UserAlreadyExistsException {
        if (users.containsKey(username))
            throw new UserAlreadyExistsException();

        Manager manager = new ManagerClass(username, clearanceLvl);
        users.put(username, manager);
        managers.put(username, manager);
        usersAlphabetic.put(username, manager);
    }

    @Override
    public void registerDeveloper(String username, String managerUsername, int clearanceLvl) throws
            ManagerUsernameDoesNotExistException, UserAlreadyExistsException {
        if (users.containsKey(username))
            throw new UserAlreadyExistsException();
        if (!managers.containsKey(managerUsername))
            throw new ManagerUsernameDoesNotExistException();

        Developer developer = new DeveloperClass(username, managerUsername, clearanceLvl);

        users.put(username, developer);
        developers.put(username, developer);
        usersAlphabetic.put(username, developer);

        managers.get(managerUsername).
    }

    @Override
    public Iterator<User> listAllUsers() {
        return usersAlphabetic.values().iterator();
    }
}
