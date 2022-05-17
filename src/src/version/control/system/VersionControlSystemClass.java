package version.control.system;

import user.DeveloperClass;
import user.ManagerClass;
import user.User;
import version.control.system.exceptions.ManagerUsernameDoesNotExistException;
import version.control.system.exceptions.UserAlreadyExistsException;

import java.util.HashMap;
import java.util.Map;

/**
 * System of the project.
 *
 * @author - Rodrigo Santos, 63263.
 * @author - Sebastiao Martins, 63447.
 */

public class VersionControlSystemClass implements VersionControlSystem {


    private final Map<String, User> users;
    private final Map<String, User> managers;
    private final Map<String, User> developers;

    public VersionControlSystemClass() {
        this.users = new HashMap<>();
        this.managers = new HashMap<>();
        this.developers = new HashMap<>();
    }

    @Override
    public void registerManager(String username, int clearanceLvl) throws
            UserAlreadyExistsException {
        if (users.containsKey(username))
            throw new UserAlreadyExistsException();

        User manager = new ManagerClass(username, clearanceLvl);
        users.put(username, manager);
        managers.put(username, manager);
    }

    @Override
    public void registerDeveloper(String username, String managerUsername, int clearanceLvl) throws
            ManagerUsernameDoesNotExistException, UserAlreadyExistsException {
        if (users.containsKey(username))
            throw new UserAlreadyExistsException();
        if (!managers.containsKey(managerUsername))
            throw new ManagerUsernameDoesNotExistException();

        User developer = new DeveloperClass(username, managerUsername, clearanceLvl);
        users.put(username, developer);
        developers.put(username, developer);
    }
}
