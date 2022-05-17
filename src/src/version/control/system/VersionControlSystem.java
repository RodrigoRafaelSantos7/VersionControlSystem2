package version.control.system;

import version.control.system.exceptions.ManagerUsernameDoesNotExistException;
import version.control.system.exceptions.UserAlreadyExistsException;

public interface VersionControlSystem {
    void registerManager(String username, int clearanceLvl);

    void registerDeveloper(String username, String managerUsername, int clearanceLvl) throws
            ManagerUsernameDoesNotExistException, UserAlreadyExistsException;

}
