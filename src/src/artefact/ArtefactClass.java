package artefact;

import java.time.LocalDate;

public class ArtefactClass implements Artefact {

    private static final String WRITE_DATE_FORMAT = "dd-MM-yyyy";

    private final String creator;
    private final String name;
    private final int confidentialityLvl;
    private final String description;
    private final LocalDate date;

    public ArtefactClass(String creator, String name, int confidentialityLvl, LocalDate date,
                         String description) {
        this.creator = creator;
        this.name = name;
        this.confidentialityLvl = confidentialityLvl;
        this.description = description;
        this.date = date;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getConfidentialityLvl() {
        return confidentialityLvl;
    }

    @Override
    public String getCreator() {
        return creator;
    }
}
