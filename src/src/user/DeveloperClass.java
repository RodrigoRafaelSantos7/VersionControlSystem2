package user;

public class DeveloperClass extends AbstractUser implements Developer {

    private final String managerUsername;
    private int numberOfProjects;

    public DeveloperClass(String username, String managerUsername, int clearanceLvl) {
        super(username, clearanceLvl);
        this.managerUsername = managerUsername;
        this.numberOfProjects = 0;
    }

    @Override
    public int getNumberOfProjects() {
        return numberOfProjects;
    }

    @Override
    public String getManagerUsername() {
        return managerUsername;
    }
}
