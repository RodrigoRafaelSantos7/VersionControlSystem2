package project;

public class OutsourcedClass extends AbstractProject implements Outsourced{

    private final String companyName;

    public OutsourcedClass(String managerUsername, String projectName, String[] keywords,
                              String companyName) {
        super(managerUsername, projectName, keywords);
        this.companyName = companyName;
    }


    @Override
    public String getCompanyName() {
        return companyName;
    }
}
