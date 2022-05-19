package user;


import java.util.HashMap;
import java.util.Map;

public class ManagerClass extends AbstractUser implements Manager {

    private int projectsAsManager;
    private int projectsAsMembers;
    private final Map<String, Developer> developers;

    public ManagerClass(String username, int clearanceLvl) {
        super(username, clearanceLvl);
        this.projectsAsManager = 0;
        this.projectsAsMembers = 0;
        this.developers = new HashMap<>();
    }

    @Override
    public void addDeveloper(String username, Developer developer) {
        developers.put(username, developer);
    }

    @Override
    public int getProjectsAsManager() {
        return projectsAsManager;
    }

    @Override
    public int getProjectsAsMembers() {
        return projectsAsMembers;
    }

    @Override
    public int getNumberOfDevs() {
        return developers.size();
    }
}
