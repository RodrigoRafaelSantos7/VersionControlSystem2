package user;

public class DeveloperClass extends AbstractUser implements Developer {

    private String managerUsername;

    public DeveloperClass(String username, String managerUsername, int clearanceLvl) {
        super(username, clearanceLvl);
        this.managerUsername = managerUsername;
    }

    @Override
    public String getManagerUsername() {
        return managerUsername;
    }

    @Override
    public boolean hasProject(String projectName) {
        return projectsAsMember.containsKey(projectName);
    }
}
