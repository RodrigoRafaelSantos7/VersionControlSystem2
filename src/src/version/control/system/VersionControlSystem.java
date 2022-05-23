package version.control.system;

import artefact.Artefact;
import project.Project;
import user.User;
import version.control.system.exceptions.*;

import java.util.Iterator;

public interface VersionControlSystem {
    void registerUser(String jobPosition, String username, String managerUsername,
                      int clearanceLvl) throws JobPositionDoesNotExistException,
            UsernameAlreadyExistsException, ManagerUsernameDoesNotExistException;

    Iterator<User> listAllUsers();

    void registerProject(String managerUsername, String projectType, String projectName,
                         String[] keywords, String companyName, int confidentialityLvl) throws
            ProjectTypeDoesNotExistException, ManagerUsernameDoesNotExistException,
            ProjectNameAlreadyExistsException, InsuficientClearanceLevelException;

    int getClearanceLvl(String username);

    Iterator<Project> listAllProjects();

    Iterator<String> addUsersToProject(String managerUsername, String projectName,
                                       String[] usernames) throws
            ManagerUsernameDoesNotExistException, ProjectNameDoesNotExistException,
            InvalidManagerException;

    String getProjectManagerUsername(String projectName);

    Iterator<String> addArtefactsToProject(String memberUsername, String projectName,
                                           Artefact[] artefacts) throws UserDoesNotExistException,
            ProjectNameDoesNotExistException,UserDoesNotExistInProjectException;

}
