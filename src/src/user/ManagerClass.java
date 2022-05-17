package user;

public class ManagerClass extends AbstractUser implements Manager {

    public ManagerClass(String username, int clearanceLvl) {
        super(username, clearanceLvl);
    }
}
