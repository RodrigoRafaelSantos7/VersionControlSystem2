package project;

public enum ProjectTypes {

    INHOUSE("inhouse"),
    OUTSOURCED("outsourced")
    ;

    private final String text;

    ProjectTypes(String text){
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
