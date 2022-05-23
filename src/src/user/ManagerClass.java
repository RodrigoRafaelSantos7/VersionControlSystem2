package user;

import project.Project;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class ManagerClass extends AbstractUser implements Manager {

    private final Map<String, Project> projectsAsManager;
    private final HashSet<User> developers;

    public ManagerClass(String username, int clearanceLvl) {
        super(username, clearanceLvl);
        this.projectsAsManager = new HashMap<>();
        this.developers = new HashSet<>();
    }

    @Override
    public boolean hasProject(String projectName) {
        return projectsAsMember.containsKey(projectName) ||
                projectsAsManager.containsKey(projectName);
    }

    @Override
    public void addDeveloper(User developer) {
        developers.add(developer);
    }

    @Override
    public void addProjectAsManager(Project project) {
        projectsAsManager.put(project.getProjectName(), project);
    }

    @Override
    public int getNumDevelopers() {
        return developers.size();
    }

    @Override
    public int getNumProjectsAsManager() {
        return projectsAsManager.size();
    }
}
