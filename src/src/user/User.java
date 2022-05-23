package user;

import project.Project;

public interface User {

    int getNumberOfProjectsAsMember();

    String getUsername();

    int getClearanceLvl();

    void addProjectAsMember(Project project);

    boolean hasProject(String projectName);

}
