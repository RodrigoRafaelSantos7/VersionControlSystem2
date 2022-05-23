package user;

/**
 * Enum that defines the types of users.
 *
 * @author Rodrigo Santos, 63263.
 * @author Sebastiao Martins, 63447.
 */
public enum UserTypes {

    //Constants.
    DEVELOPER("developer"),
    MANAGER("manager"),
    ;

    //Instance variables.
    private final String text;

    //Constructor.
    UserTypes(String text) {
        this.text = text;
    }

    /**
     * @return - returns the text associated with each type.
     */
    public String getText() {
        return text;
    }
}