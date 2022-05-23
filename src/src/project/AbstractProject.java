package project;

abstract class AbstractProject implements Project{

    //Instance variables.
    protected final String managerUsername;
    protected final String projectName;
    protected final String[] keywords;

    protected AbstractProject(String managerUsername, String projectName, String[] keywords){
        this.managerUsername = managerUsername;
        this.projectName = projectName;
        this.keywords = keywords;
    }

    @Override
    public String getProjectName() {
        return projectName;
    }

    @Override
    public String getManagerUsername(){
        return managerUsername;
    }
}
