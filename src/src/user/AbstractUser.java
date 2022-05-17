package user;

public abstract class AbstractUser implements User {

    protected final String username;
    protected final int clearanceLvl;

    protected AbstractUser(String username, int clearanceLvl) {
        this.username = username;
        this.clearanceLvl = clearanceLvl;
    }

}
