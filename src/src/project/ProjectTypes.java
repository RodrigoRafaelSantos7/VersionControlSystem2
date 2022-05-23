package project;

/**
 * Enum that defines the types of projects.
 *
 * @author Rodrigo Santos, 63263.
 * @author Sebastiao Martins, 63447.
 */
public enum ProjectTypes {

    //Constants.
    INHOUSE("inhouse"),
    OUTSOURCED("outsourced"),
    ;

    //Instance variables.
    private final String text;

    //Constructor.
    ProjectTypes(String text){
        this.text = text;
    }

    /**
     * @return - The text associated with the type of the project.
     */
    public String getText() {
        return text;
    }
}
