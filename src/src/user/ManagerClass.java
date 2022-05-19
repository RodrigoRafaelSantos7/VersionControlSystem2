package user;


import project.Project;

import java.util.HashMap;
import java.util.Map;

public class ManagerClass extends AbstractUser implements Manager {

    private final Map<String, Developer> developers;
    private final Map<String, Project> projectsAsManager;
    private final Map<String, Project> projectsAsMember;

    public ManagerClass(String username, int clearanceLvl) {
        super(username, clearanceLvl);
        this.developers = new HashMap<>();
        this.projectsAsManager = new HashMap<>();
        this.projectsAsMember = new HashMap<>();
    }

    @Override
    public void addDeveloper(String username, Developer developer) {
        developers.put(username, developer);
    }

    @Override
    public void addProjectAsManager(String projectName, Project project) {
        projectsAsManager.put(projectName, project);
    }

    @Override
    public int getNumberOfDevs() {
        return developers.size();
    }

    @Override
    public int getProjectsAsManager() {
        return projectsAsManager.size();
    }

    @Override
    public int getProjectsAsMembers() {
        return projectsAsMember.size();
    }
}
