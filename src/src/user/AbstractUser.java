package user;

import project.Project;

import java.util.HashMap;
import java.util.Map;

abstract class AbstractUser implements User {

    protected final String username;
    protected final int clearanceLvl;
    protected final Map<String, Project> projectsAsMember;

    protected AbstractUser(String username, int clearanceLvl) {
        this.username = username;
        this.clearanceLvl = clearanceLvl;
        this.projectsAsMember = new HashMap<>();
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public int getClearanceLvl() {
        return clearanceLvl;
    }

    @Override
    public void addProjectAsMember(Project project) {
        projectsAsMember.put(project.getProjectName(), project);
    }

    @Override
    public int getNumberOfProjectsAsMember() {
        return projectsAsMember.size();
    }
}
