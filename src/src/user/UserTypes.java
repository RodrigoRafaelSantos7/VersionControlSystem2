package user;

public enum UserTypes {

    DEVELOPER("Developer"),
    MANAGER("Manager"),
    ;

    private final String text;

    UserTypes(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
