package user;

public class DeveloperClass extends AbstractUser implements Developer {

    private final String managerUsername;

    public DeveloperClass(String username, String managerUsername, int clearanceLvl) {
        super(username, clearanceLvl);
        this.managerUsername = managerUsername;
    }
}
