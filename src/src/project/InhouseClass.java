package project;

public class InhouseClass extends AbstractProject implements Inhouse {

    private final int confidentialityLvl;

    public InhouseClass(String managerUsername, String projectName, String[] keywords,
                        int confidentialityLvl) {
        super(managerUsername, projectName, keywords);
        this.confidentialityLvl = 0;
    }
}
