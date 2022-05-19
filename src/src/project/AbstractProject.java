package project;

public abstract class AbstractProject implements Project {

    protected final String manageUsername;
    protected final String projectName;
    protected final String[] keywords;

    protected AbstractProject(String managerUsername, String projectName, String[] keywords) {
        this.manageUsername = managerUsername;
        this.projectName = projectName;
        this.keywords = keywords;
    }




}
