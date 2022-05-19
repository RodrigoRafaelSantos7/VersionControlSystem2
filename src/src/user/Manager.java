package user;

import project.Project;

public interface Manager extends User {
    /**
     * @return - The number of Developers associated with the Manager.
     */
    int getNumberOfDevs();

    /**
     * @return - The number of project managed by the Manager.
     */
    int getProjectsAsManager();

    /**
     * @return - The number of projects as Member.
     */
    int getProjectsAsMembers();

    /**
     * Associates a new Developer to the manager.
     *
     * @param username  - the username of the developer.
     * @param developer - the developer.
     */
    void addDeveloper(String username, Developer developer);

    /**
     * Associates a new Project to the manager.
     *
     * @param projectName - the name of the project
     * @param project     - the project.
     */
    void addProjectAsManager(String projectName, Project project);
}
