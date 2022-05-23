package user;

import project.Project;

public interface Manager extends User{

    void addDeveloper(User developer);

    void addProjectAsManager(Project project);

    int getNumDevelopers();

    int getNumProjectsAsManager();
}
